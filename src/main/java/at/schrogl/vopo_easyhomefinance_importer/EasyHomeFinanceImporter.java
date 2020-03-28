package at.schrogl.vopo_easyhomefinance_importer;

import at.schrogl.vopo_easyhomefinance_importer.batch.BatchJob;

import java.lang.reflect.InvocationTargetException;

public class EasyHomeFinanceImporter {

	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		if (args == null || args.length < 1) {
			System.out.println(String.format("Arguments:\n\t%s <command> [[cmd-args][] ... ]", EasyHomeFinanceImporter.class.getSimpleName()));
			throw new IllegalArgumentException(String.format("At least one argument must be given"));
		}

		BatchJob batchJob = new BatchCreator().createBatchFromArguments(args);
		batchJob.execute();
	}

}
