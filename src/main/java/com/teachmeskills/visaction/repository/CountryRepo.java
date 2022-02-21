package com.teachmeskills.visaction.repository;

import com.teachmeskills.visaction.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {

    Country findCountryByNameCountry(String nameCountry);
}

