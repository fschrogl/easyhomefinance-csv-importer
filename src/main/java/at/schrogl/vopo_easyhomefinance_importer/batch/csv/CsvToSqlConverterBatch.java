package at.schrogl.vopo_easyhomefinance_importer.batch.csv;

import at.schrogl.vopo_easyhomefinance_importer.batch.BatchJob;

public class CsvToSqlConverterBatch extends BatchJob {

	public CsvToSqlConverterBatch(String batchCmdName, String[] args) {
		super(batchCmdName, args);
	}

	@Override
	public void execute() {
		throw new RuntimeException("Not implemented yet!");
	}

}
