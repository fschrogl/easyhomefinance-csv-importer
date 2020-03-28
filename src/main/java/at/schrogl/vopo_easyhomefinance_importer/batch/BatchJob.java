package at.schrogl.vopo_easyhomefinance_importer.batch;

public abstract class BatchJob {

	protected final String[] arguments;

	public BatchJob(String[] args) {
		this.arguments = args;
	}

	public abstract void execute();

}
