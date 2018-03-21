package org.wecancodeit.ecom.tea;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeapotController {

	@RequestMapping("/teapot/coffee") // not good REST
	public void makeCoffee() {
		throw new IllegalCoffeeRequestException();
	}
	
	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT, reason = "I do not make coffee.")
	public class IllegalCoffeeRequestException extends RuntimeException {}
}