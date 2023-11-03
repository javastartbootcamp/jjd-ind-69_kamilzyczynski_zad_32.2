package pl.javastart.jpaoptimalization.countrylanguage;

import org.springframework.stereotype.Service;
import pl.javastart.jpaoptimalization.country.CountryDto;
import pl.javastart.jpaoptimalization.country.CountryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;
    private final CountryRepository countryRepository;

    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository, CountryRepository countryRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
        this.countryRepository = countryRepository;
    }

    public List<CountryLanguage> findAll() {
        return countryLanguageRepository.findAll();
    }

    public Map<String, List<String>> findAllLanguagesWithCountries() {
        List<CountryDto> allCountriesWithCode = countryRepository.findAllCountriesWithCode();
        List<CountryLanguageDto> allLanguagesWithCodes = countryLanguageRepository.findAllLanguagesWithCountries();
        Map<String, List<String>> languagesWithCountries = new TreeMap<>();

        Map<String, String> countriesByCode = allCountriesWithCode.stream()
                .collect(Collectors.toMap(CountryDto::getCode, CountryDto::getCountry));

        for (CountryLanguageDto languageDto : allLanguagesWithCodes) {
            String language = languageDto.getLanguage();
            String countryCode = languageDto.getCode();

            String countryName = countriesByCode.get(countryCode);

            languagesWithCountries
                    .computeIfAbsent(language, key -> new ArrayList<>())
                    .add(countryName);
        }
        return languagesWithCountries;
    }
}
