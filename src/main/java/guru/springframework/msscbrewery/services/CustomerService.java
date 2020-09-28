package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

	public CustomerDto getCustomerById(UUID id);

	public CustomerDto saveCustomer(CustomerDto customerDto);

	public void updateCustomer(UUID customerId, CustomerDto customerDto);

	public void deleteById(UUID customerId);
}
