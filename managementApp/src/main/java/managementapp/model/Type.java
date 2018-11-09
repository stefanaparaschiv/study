package managementapp.model;

public enum Type {
	REGULAR, VEGETARIAN;

	public static boolean containsString(String string) {

		for (Type t : Type.values()) {
			if (t.name().equals(string)) {
				return true;
			}
		}

		return false;
	}

}
