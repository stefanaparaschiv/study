package managementapp.errorhandling;

public class ErrorDto {

	private int statusCode;

	private String message;

	public ErrorDto() {
	};

	public ErrorDto(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}
}
