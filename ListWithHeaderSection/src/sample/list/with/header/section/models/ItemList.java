package sample.list.with.header.section.models;

public abstract class ItemList {

	protected Boolean isHeader;
	protected String text;

	public ItemList(String text, Boolean isHeader) {
		this.text = text;
		this.isHeader = isHeader;
	}

	public final Boolean isHeader() {
		return isHeader;
	}

	public String getText() {
		return text;
	}
}
