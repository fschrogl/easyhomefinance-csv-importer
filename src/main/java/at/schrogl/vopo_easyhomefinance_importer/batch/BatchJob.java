package at.schrogl.vopo_easyhomefinance_importer.batch;

public abstract class BatchJob {

	protected final String batchCmdName;
	protected final String[] arguments;

	public BatchJob(String batchCmdName, String[] args) {
		this.batchCmdName = batchCmdName;
		this.arguments = args;
	}

	public abstract void execute();

}
