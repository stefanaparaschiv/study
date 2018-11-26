package managementapp.errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import managementapp.exceptions.ValidationException;
import managementapp.dto.ErrorDto;
import managementapp.exceptions.BusinessException;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);
	
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorDto handleNotFoundException(BusinessException ex) {
		LOGGER.error("Exception thrown: ", ex);
		return this.generateErrorDto(HttpStatus.NOT_FOUND, ex);
	}

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorDto handleBadRequestException(ValidationException ex) {
		return this.generateErrorDto(HttpStatus.BAD_REQUEST, ex);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDto defaultHandler(Exception ex) {
		LOGGER.error("Exception thrown: ", ex);
		return new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	}

	private ErrorDto generateErrorDto(HttpStatus status, Exception ex) {
		LOGGER.error("Exception thrown: ", ex);
		return new ErrorDto(status.value(), ex.getMessage());
	}
}