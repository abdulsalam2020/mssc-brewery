package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getById(@PathVariable("customerId") UUID id){
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
		CustomerDto saveDto = customerService.saveCustomer(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "/api/v1/customer"+saveDto.getId());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handlePut(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
		customerService.updateCustomer(customerId, customerDto);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
		customerService.deleteById(customerId);
	}
}
