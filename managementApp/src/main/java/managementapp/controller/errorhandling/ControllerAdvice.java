package managementapp.controller.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import managementapp.exceptions.NotFoundException;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorDto handleNotFoundException(NotFoundException ex) {
		return this.generateErrorDto(HttpStatus.NOT_FOUND, ex);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDto defaultHandler(Exception ex) {
		return new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	}

	private ErrorDto generateErrorDto(HttpStatus status, Exception ex) {
		return new ErrorDto(status.value(), ex.getMessage());
	}
}