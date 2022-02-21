package com.teachmeskills.visaction.service.impl;

import com.teachmeskills.visaction.model.Country;
import com.teachmeskills.visaction.repository.CountryRepo;
import com.teachmeskills.visaction.service.CountryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepo countryRepo;

    public CountryServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Country> findAllCountries() {
        return countryRepo.findAll();
    }

    @Override
    public Country findCountryById(Long id) {
        return countryRepo.getById(id);
    }

    @Override
    public Country findCountryByName(String nameCountry) {
        return countryRepo.findCountryByNameCountry(nameCountry);
    }

    @Override
    public void saveCountry(Country country) {
        countryRepo.save(country);
    }

    @Override
    public Country updateCountry(Long id, Country request) {
        Country countryFromDb = countryRepo.getById(id);
        countryFromDb.setNameCountry(request.getNameCountry());
        countryFromDb.setPriceCountry(request.getPriceCountry());
        countryFromDb.setContinents(request.getContinents());
        countryFromDb.setActive(request.isActive());
        countryFromDb.setUpdatedAt(LocalDateTime.now());
        return countryRepo.save(countryFromDb);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepo.deleteById(id);
    }
}


