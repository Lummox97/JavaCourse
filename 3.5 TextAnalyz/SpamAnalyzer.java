public class SpamAnalyzer extends KeywordAnalyzer {
	static String [] spamWords;
	SpamAnalyzer (String [] spam) {
		spamWords = spam;
	}
	
	@Override
	protected Label getLabel() {
		return Label.SPAM;
	}
	@Override
	protected String [] getKeywords() {
		String [] a = {"Jopa", "Jopa2"};
		return a;
	}
	@Override
	public Label processText(String text){
		for (String words : spamWords) {
			if (text.indexOf(words) != -1)
				return getLabel();
		}
		return Label.OK;
	}
}