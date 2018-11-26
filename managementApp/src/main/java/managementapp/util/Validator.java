package managementapp.util;

import managementapp.dto.MenuDTO;
import managementapp.exceptions.ValidationException;
import managementapp.model.Job;
import managementapp.model.Type;

public class Validator {

	public static void validateJob(String job) throws ValidationException {
		if (!Job.containsString(job)) {
			throw new ValidationException("Incorrect value provided for job. Job does not exist.");
		}
	}

	public static void validateMenuId(MenuDTO menu, Long menuId) throws ValidationException {
		if (menu.getId() != menuId) {
			throw new ValidationException("Path id and menu id do not match");
		}
	}

	public static void validateType(String type) throws ValidationException {
		if (!Type.containsString(type)) {
			throw new ValidationException("Incorrect value provided for menu type");
		}
	}

}
