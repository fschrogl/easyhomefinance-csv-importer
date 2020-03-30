package at.schrogl.vopo_easyhomefinance_importer.ehf.model;

public enum EhfAccount {

	NONE(""),
	Giro("1"),
	Sparkonto("2"),
	Depot("3"),
	Verrechnung("4"),
	Schulden("5");

	public final String id;

	EhfAccount(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id;
	}
}
