package com.example.demo.service.countryService;

import com.example.demo.model.Country;
import com.example.demo.service.IService;

public interface ICountryService extends IService<Country> {
    Country findByName(String name);
}
