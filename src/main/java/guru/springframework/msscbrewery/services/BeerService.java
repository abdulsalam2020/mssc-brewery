package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
public interface BeerService {
    public BeerDto getBeerById(UUID beerId);
    public BeerDto saveNewBeer(BeerDto beerDto);
	public void updateBeer(UUID beerId, BeerDto beerDto);
	public void deleteById(UUID beerId);
    
}
