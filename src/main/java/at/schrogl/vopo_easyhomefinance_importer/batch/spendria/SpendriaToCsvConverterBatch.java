package at.schrogl.vopo_easyhomefinance_importer.batch.spendria;

import at.schrogl.vopo_easyhomefinance_importer.batch.BatchJob;

public class SpendriaToCsvConverterBatch extends BatchJob {

	public SpendriaToCsvConverterBatch(String batchCmdName, String[] args) {
		super(batchCmdName, args);
	}

	@Override
	public void execute() {
		throw new RuntimeException("Not implemented yet!");
	}
}
