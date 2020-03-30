package at.schrogl.vopo_easyhomefinance_importer.ehf.model;

public enum EhfCategoryInOut {

	OUT("0"),
	IN("1"),
	TRANSFER("2");

	public final String value;

	EhfCategoryInOut(String value) {
		this.value = value;
	}
}
