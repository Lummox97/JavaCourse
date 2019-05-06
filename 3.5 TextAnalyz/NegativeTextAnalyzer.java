public class NegativeTextAnalyzer extends KeywordAnalyzer {
	static String [] badWords;
	String [] a = {":(", "=(", ":|"};
	NegativeTextAnalyzer () {
		this.getKeywords();
	}
	@Override
	protected String [] getKeywords() {
		badWords = a;
		return badWords;
	}
	@Override
	protected Label getLabel() {
		return Label.NEGATIVE_TEXT;
	}
	@Override
	public Label processText(String text){
		for (String words : badWords) {
			if (text.indexOf(words) != -1)
				return getLabel();
		}
		return Label.OK;
	}
}