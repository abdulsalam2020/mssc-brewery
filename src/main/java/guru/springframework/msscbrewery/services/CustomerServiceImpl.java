package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID id) {
		return CustomerDto.builder()
				.id(id)
				.name("Tom")
				.build();
	}

	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		// TODO Update an existing customer
		
	}

	@Override
	public void deleteById(UUID customerId) {
		// TODO Auto-generated method stub
		
		log.debug("Deleting Customer...");
	}

}
