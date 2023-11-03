package pl.javastart.jpaoptimalization.countrylanguage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageKey> {
    @Query("SELECT NEW pl.javastart.jpaoptimalization.countrylanguage.CountryLanguageDto(cl.countryCode, cl.language) FROM CountryLanguage cl")
    List<CountryLanguageDto> findAllLanguagesWithCountries();

}
