package at.schrogl.vopo_easyhomefinance_importer.batch.xls;

import at.schrogl.vopo_easyhomefinance_importer.batch.BatchJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;
import java.util.Optional;

public class XlsToCsvConverterBatch extends BatchJob {

	static final Logger logger = LoggerFactory.getLogger(XlsToCsvConverterBatch.class);

	public XlsToCsvConverterBatch(String batchCmdName, String[] args) {
		super(batchCmdName, args);
	}

	@Override
	public void execute() {
		logger.info("Batch arguments given: {}", ((Object[]) arguments));
		// parse
		// map
		// write to disk
	}

	private Optional<Object> argumentToXlsFile(String argument) {
		return (!argument.equals(batchCmdName)) ? Optional.of(Paths.get(argument)) : Optional.empty();
	}


}
