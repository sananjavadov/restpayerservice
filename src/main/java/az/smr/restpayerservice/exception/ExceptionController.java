package az.smr.restpayerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import az.smr.restpayerservice.model.NotFoundModel;



@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> notFound() {
		return new ResponseEntity<Object>(new NotFoundModel(), HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exception() {
		return new ResponseEntity<Object>(new NotFoundModel("Gözlənilməz səhv baş verdi!"), HttpStatus.OK);
	}	
}
