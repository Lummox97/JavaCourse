public abstract class KeywordAnalyzer implements TextAnalyzer {
	protected abstract String [] getKeywords();
	protected abstract Label getLabel();
}
interface TextAnalyzer {
	Label processText(String text);
}

enum Label {
	SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}
