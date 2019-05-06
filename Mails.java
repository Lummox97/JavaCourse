import java.util.logging.*;

public class Mails {
	
	public static final String AUSTIN_POWERS = "Austin Powers";
	public static final String WEAPONS = "weapons";
	public static final String BANNED_SUBSTANCE = "banned substance";

	public static interface Sendable {
    	String getFrom();
	    String getTo();
	}

	public static abstract class AbstractSendable implements Sendable {

    	protected final String from;
    	protected final String to;

    	public AbstractSendable(String from, String to) {
	        this.from = from;
        	this.to = to;
    	}

    	@Override
    	public String getFrom() {
	        return from;
    	}

    	@Override
    	public String getTo() {
        	return to;
    	}

    	@Override
    	public boolean equals(Object o) {
        	if (this == o) return true;
        	if (o == null || getClass() != o.getClass()) return false;

        	AbstractSendable that = (AbstractSendable) o;

        	if (!from.equals(that.from)) return false;
        	if (!to.equals(that.to)) return false;

        	return true;
    	}
	}

	public static class MailMessage extends AbstractSendable {

    	private final String message;

    	public MailMessage(String from, String to, String message) {
        	super(from, to);
        	this.message = message;
    	}

    	public String getMessage() {
        	return message;
    	}

    	@Override
    	public boolean equals(Object o) {
    	    if (this == o) return true;
    	    if (o == null || getClass() != o.getClass()) return false;
	        if (!super.equals(o)) return false;

    	    MailMessage that = (MailMessage) o;

	        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        	return true;
    	}

	}

	public static class MailPackage extends AbstractSendable {
 		
 		private final Package content;

    	public MailPackage(String from, String to, Package content) {
        	super(from, to);
        	this.content = content;
    	}

    	public Package getContent() {
        	return content;
    	}

    	@Override
    	public boolean equals(Object o) {
        	if (this == o) return true;
        	if (o == null || getClass() != o.getClass()) return false;
        	if (!super.equals(o)) return false;

        	MailPackage that = (MailPackage) o;

        	if (!content.equals(that.content)) return false;

        	return true;
    	}

	}

	public static class Package {
 	    private final String content;
	    private final int price;

    	public Package(String content, int price) {
	        this.content = content;
        	this.price = price;
    	}

    	public String getContent() {
	        return content;
    	}

	    public int getPrice() {
    	    return price;
    	}

    	@Override
    	public boolean equals(Object o) {
	        if (this == o) return true;
    	    if (o == null || getClass() != o.getClass()) return false;

        	Package aPackage = (Package) o;

        	if (price != aPackage.price) return false;
        	if (!content.equals(aPackage.content)) return false;

        	return true;
   		 }
	}

	public static interface MailService {
    	Sendable processMail(Sendable mail);
	}


	public static class RealMailService implements MailService {

    	@Override
    	public Sendable processMail(Sendable mail) {
         	if (mail instanceof MailMessage){
         		MailMessage newM = (MailMessage) mail;
         		System.out.println(newM.message);
         		return newM;
         	}
         	else {
         		MailPackage newM = (MailPackage) mail;
         		System.out.println(newM.content.content);
         		return newM;
         	}
         }
	}

	public static class UntrustworthyMailWorker implements MailService {
    	
    	RealMailService real = new RealMailService();
    	MailService [] mails;
    	
    	Sendable data;

    	public UntrustworthyMailWorker(MailService [] thatMails) {
    		mails = thatMails;
    	}

    	public RealMailService getRealMailService() {
    		return real;
    	}

    	@Override
    	public Sendable processMail(Sendable mail) {
    		data = mail;
    		for (MailService i : mails) {
    			data = i.processMail(data);
    		}
    		return getRealMailService().processMail(data);
    	}
	}

	public static class Spy implements MailService {
	    Logger logs = null;
	    
	    public Spy(Logger newLog) {
        	logs = newLog;
    	}

    	@Override
    	public Sendable processMail(Sendable mail) {
    		RealMailService a = new RealMailService();
    		if (mail instanceof MailMessage) {
    			MailMessage newM = (MailMessage) mail;
    			if(newM.to.equals(AUSTIN_POWERS) || newM.from.equals(AUSTIN_POWERS))
    				logs.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", new Object[] {newM.from, newM.to, newM.message});
    			else
    				logs.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[] {newM.from, newM.to});
    			return a.processMail(newM);
    		}
    		
    		return a.processMail(mail);
    	}
	}

	public static class Inspector implements MailService {
	    
	    @Override
    	public Sendable processMail(Sendable mail) {
    		if (mail instanceof MailPackage) {
    			MailPackage newM = (MailPackage) mail;
    			if (newM.content.content.equals(WEAPONS) || newM.content.content.equals(BANNED_SUBSTANCE)) {
    				throw new IllegalPackageException(newM.content.content + " in the package");
    			}
    			if (newM.content.content.indexOf("stones") != -1) {
    				throw new StolenPackageException("stones in the package");
    			}
    		}
    		return mail;
    	}
	}

	public static class Thief implements MailService {
	    int cena;
	    int sum = 0;

	    public Thief(int value) {
        	cena = value;
    	}

    	public int getStolenValue() {
    		return sum;
    	}

    	@Override
    	public Sendable processMail(Sendable mail) {
	   		RealMailService a = new RealMailService();
    		if(mail instanceof MailPackage) {
    			MailPackage newM = (MailPackage) mail;
    			if(newM.content.price >= cena) {
    				String str = "stones instead of " + newM.content.content;
    				MailPackage newPac = new MailPackage(newM.from, newM.to, new Package(str, 0));
    				sum += newM.content.price;
    				return a.processMail(newPac);
    			}
    		}
    		return a.processMail(mail);
		}
	}
	// implement UntrustworthyMailWorker, Spy, Inspector, Thief, StolenPackageException, IllegalPackageException as public static classes here
	public static class StolenPackageException extends RuntimeException {

    	public StolenPackageException() {
	        super();
    	}

    	public StolenPackageException(String message) {
	        super(message);
    	}

    	public StolenPackageException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}

	public static class IllegalPackageException extends RuntimeException {

    	public IllegalPackageException() {
	        super();
    	}

    	public IllegalPackageException(String message) {
	        super(message);
    	}

    	public IllegalPackageException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}

	public static void main(String[] args) {

		MailMessage message = new MailMessage("Austin Powers", "loh", "ty loh");
		MailPackage pack = new MailPackage("loh", "Austin Powers", new Package("weapons", 1));
		RealMailService real = new RealMailService();
		Logger log = Logger.getLogger("AAA");
		Spy spy = new Spy(log);
		Thief thief = new Thief(0);
		Inspector insp = new Inspector();
		
		real.processMail(message);
		real.processMail(pack);
		spy.processMail(message);
		spy.processMail(pack);
		thief.processMail(message);
		thief.processMail(pack);
		thief.processMail(pack);
		try {
			insp.processMail(thief.processMail(pack));
		}
		catch (StolenPackageException e) {
			System.out.println(e);
		}
		System.out.println(thief.getStolenValue());
	}
}