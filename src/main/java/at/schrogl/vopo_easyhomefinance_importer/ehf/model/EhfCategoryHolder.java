package at.schrogl.vopo_easyhomefinance_importer.ehf.model;

import java.io.Serializable;

public class EhfCategoryHolder implements Serializable {

	public enum EhfCategoryInOut {

		OUT("0"),
		IN("1"),
		TRANSFER("2");

		public final String value;

		EhfCategoryInOut(String value) {
			this.value = value;
		}


		@Override
		public String toString() {
			return value;
		}
	}

	public enum EhfCategory {

		Supermarkt("Supermarkt", "1", EhfCategoryInOut.OUT),
		Wohnen("Wohnen", "3", EhfCategoryInOut.OUT),
		Auto("Auto", "4", EhfCategoryInOut.OUT),
		Konsum("Konsum", "5", EhfCategoryInOut.OUT),
		Sport("Sport", "6", EhfCategoryInOut.OUT),
		Urlaub("Urlaub", "8", EhfCategoryInOut.OUT),
		AktivesEinkommen("Aktives Einkommen", "11", EhfCategoryInOut.IN),
		PassivesEinkommen("Passives Einkommen", "12", EhfCategoryInOut.IN),
		Geschenk("Geschenk", "13", EhfCategoryInOut.IN),
		EigenerTransfer("Eigener Transfer", "A", EhfCategoryInOut.TRANSFER),
		Essen2Go("Essen2Go", "14", EhfCategoryInOut.OUT);

		public final String description;
		public final String groupId;
		public final EhfCategoryInOut inOut;

		EhfCategory(String description, String groupId, EhfCategoryInOut inOut) {
			this.description = description;
			this.groupId = groupId;
			this.inOut = inOut;
		}


		@Override
		public String toString() {
			return description;
		}
	}
}
