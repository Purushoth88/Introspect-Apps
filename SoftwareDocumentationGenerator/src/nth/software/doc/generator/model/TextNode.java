package nth.software.doc.generator.model;

public class TextNode implements Node {

	private final String text;

	public TextNode(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
