package com.teachmeskills.visaction.service;

import com.teachmeskills.visaction.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAllCountries();

    Country findCountryById(Long id);

    Country findCountryByName(String name);

    void saveCountry(Country country);

    Country updateCountry(Long id, Country country);

    void deleteCountry(Long id);
}
