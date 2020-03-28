package at.schrogl.vopo_easyhomefinance_importer;

import at.schrogl.vopo_easyhomefinance_importer.batch.BatchJob;
import at.schrogl.vopo_easyhomefinance_importer.batch.csv.CsvToSqlConverterBatch;
import at.schrogl.vopo_easyhomefinance_importer.batch.spendria.SpendriaToCsvConverterBatch;
import at.schrogl.vopo_easyhomefinance_importer.batch.xls.XlsToCsvConverterBatch;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class BatchCreator {

	enum JobType {
		XlsToEhfCsvConverter("xls2csv", XlsToCsvConverterBatch.class),
		SpendriaCsvToEhfConverter("spendria2csv", SpendriaToCsvConverterBatch.class),
		EhfCsvToEhfSqlConverter("csv2sql", CsvToSqlConverterBatch.class);

		final String cmdName;
		final Class<? extends BatchJob> batchClazz;

		JobType(String cmdName, Class<? extends BatchJob> batchClazz) {
			this.cmdName = cmdName;
			this.batchClazz = batchClazz;
		}
	}

	public BatchJob createBatchFromArguments(final String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		JobType jobClazz = Arrays.asList(JobType.values()).stream()
			.filter(jobType -> jobType.cmdName.equals(args[0]))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Unknown command: " + args[0]));
		return jobClazz.batchClazz.getDeclaredConstructor(String[].class).newInstance(new Object[] {args});
	}

}
