package pl.javastart.jpaoptimalization.country;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Set<CountryWithBiggestCity> findAllWithBiggestCity() {
        return countryRepository.findAllCountriesWithBiggestCity();
    }

    public List<Country> findAllWithLanguages() {
        return countryRepository.findAllCountriesWithLanguages();
    }

}
