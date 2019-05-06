
public class Logi {
	private static final Logger classA = Logger.getLogger("org.stepic.java.logging.ClassA");
	private static final Handler hanh = new java.util.logging.ConsoleHandler();
	public static void main(String [] argc) {
		classA.setLevel(Level.ALL);
		hanh.setFormatter(new java.util.logging.XMLFormatter());
		hanh.setLevel(Level.ALL);
		classA.fine("jopa");
		classA.addHandler(hanh);
		classA.setUseParentHandlers(false);
		classA.fine("NEjopa");
		//Logi.class.getName().fine("tojeJopa");
	}
}