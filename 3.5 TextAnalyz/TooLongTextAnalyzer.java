public class TooLongTextAnalyzer implements TextAnalyzer {
	private int maxLength;
	TooLongTextAnalyzer(int max){
		maxLength = max;
	}
	
	protected Label getLabel() {
		return Label.TOO_LONG;
	}
	@Override
	public Label processText(String text) {
		if (text.length() >= maxLength)
			return getLabel();
		return Label.OK;
	}
}