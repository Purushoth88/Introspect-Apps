package nth.software.doc.generator.framer;

import java.util.List;

import nth.software.doc.generator.model.Bold;
import nth.software.doc.generator.model.Chapter;
import nth.software.doc.generator.model.DocumentationModel;
import nth.software.doc.generator.model.Hyperlink;
import nth.software.doc.generator.model.Image;
import nth.software.doc.generator.model.LineBreak;
import nth.software.doc.generator.model.ListItem;
import nth.software.doc.generator.model.Node;
import nth.software.doc.generator.model.SubChapter;
import nth.software.doc.generator.model.SubSubChapter;
import nth.software.doc.generator.model.Text;
import nth.software.doc.generator.model.TextBlock;
import nth.software.doc.generator.model.TextWithFixedWidthFont;
import nth.software.doc.generator.model.Underline;
import nth.software.doc.generator.model.inlinetag.InlineTag;

public abstract class DocumentationFramer {

	

	protected final DocumentationModel documentationModel;

	public DocumentationFramer(DocumentationModel documentationModel) {
		this.documentationModel = documentationModel;
	}
	
	public void frame() {
		onStartFraming();
		for (Node node : documentationModel.getChildren()) {
			frame(node);
		}
		onCloseFraming();
	}

	
	public void onCloseFraming() {
		// hook
	}

	public void onStartFraming() {
		//hook
	}


	public void frameChildren(List<Node> nodes) {
		for (Node node : nodes) {
			frame(node);
		}
	}


	private void frame(Node node) {
		frameTextBlocks(node);
		frameInlineTags(node);
		frameTags(node);
		frameComments(node);

	}

	private void frameTags(Node node) {
		// So far JavaDoc tags are not framed
	}

		private void frameInlineTags(Node node) {
		if (node.getClass() == InlineTag.class) {
			InlineTag inlineTag=(InlineTag) node;
			frameInlineTag(inlineTag);
		}
	}

	

	private void frameComments(Node node) {
		if (node.getClass() == Hyperlink.class) {
			frameHyperlink((Hyperlink) node);
		} else if (node.getClass() == nth.software.doc.generator.model.List.class) {
			frameList((nth.software.doc.generator.model.List) node);
		} else if (node.getClass() == ListItem.class) {
			frameListItem((ListItem) node);
		} else if (node.getClass() == Bold.class) {
			frameBold((Bold) node);
		} else if (node.getClass() == Underline.class) {
			frameUnderline((Underline) node);
		} else if (node.getClass() == LineBreak.class) {
			frameLineBreak((LineBreak) node);
		} else if (node.getClass() == Text.class) {
			frameText((Text) node);
		}else if (node.getClass() == Image.class) {
			frameImage((Image) node);
		}
	}

	public abstract  void frameImage(Image node);

	public abstract void frameUnderline(Underline node);

	public abstract void frameBold(Bold node);

	public abstract void frameListItem(ListItem node);

	public abstract void frameList(nth.software.doc.generator.model.List node);
	
	private void frameTextBlocks(Node node) {
		if (node.getClass() == Chapter.class) {
			frameChapter((Chapter) node);
		} else if (node.getClass() == SubChapter.class) {
			frameSubChapter((SubChapter) node);
		} else if (node.getClass() == SubSubChapter.class) {
			frameSubSubChapter((SubSubChapter) node);
		} else if (node.getClass() == TextBlock.class) {
			frameTextBlock((TextBlock) node);
		} else if (node.getClass() == TextWithFixedWidthFont.class) {
			frameTextWithFixedWidthFont((TextWithFixedWidthFont) node);
		}
	}

	
	// textblocks 
	public abstract void frameChapter(Chapter chapter);

	public abstract void frameSubChapter(SubChapter node);

	public abstract void frameSubSubChapter(SubSubChapter node);

	public abstract void frameTextBlock(TextBlock node);
	
	public abstract void frameTextWithFixedWidthFont(TextWithFixedWidthFont node);

	
	// inline tags
	public abstract void frameInlineTag(InlineTag inlineTag);


	// comments
	public abstract void frameText(Text node);

	public abstract void frameLineBreak(LineBreak node);

	public abstract void frameHyperlink(Hyperlink node);

}
