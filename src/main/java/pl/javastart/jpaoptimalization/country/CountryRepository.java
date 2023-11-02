package pl.javastart.jpaoptimalization.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CountryRepository extends JpaRepository<Country, String> {
    @Query("SELECT NEW pl.javastart.jpaoptimalization.country.CountryWithBiggestCity(c.name, ci.name, ci.population) " +
            "FROM Country c " +
            "JOIN City ci ON c.code = ci.country " +
            "WHERE ci.population = (SELECT MAX(city.population) FROM City city WHERE city.country = c.code) " +
            "ORDER BY c.name")
    Set<CountryWithBiggestCity> findAllCountriesWithBiggestCity();

}
