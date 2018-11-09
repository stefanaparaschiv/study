package managementapp.model;

public enum Job {
	COOK,
	VENDOR;
	
	public static boolean containsString(String string) {

		for (Job job : Job.values()) {
			if (job.name().equals(string)) {
				return true;
			}
		}

		return false;
	}
}
