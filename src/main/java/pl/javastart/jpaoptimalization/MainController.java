package pl.javastart.jpaoptimalization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.jpaoptimalization.country.CountryService;
import pl.javastart.jpaoptimalization.country.CountryWithBiggestCity;
import pl.javastart.jpaoptimalization.countrylanguage.CountryWithLanguages;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguage;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguageService;

import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    private final CountryService countryService;
    private final CountryLanguageService countryLanguageService;

    public MainController(CountryService countryService,
                          CountryLanguageService countryLanguageService) {
        this.countryService = countryService;
        this.countryLanguageService = countryLanguageService;
    }

    @GetMapping("/najwieksze-miasta")
    public String countryWithBiggestCity(Model model) {
        Set<CountryWithBiggestCity> countries = countryService.findAllWithBiggestCity();
        model.addAttribute("countries", countries);

        return "countryWithBiggestCity";
    }

    @GetMapping("/kraje-i-jezyki")
    public String countryWithLanguages(Model model) {
        List<CountryWithLanguages> countries = countryService.findAllCountriesWithLanguages();

        model.addAttribute("countries", countries);

        return "countryWithLanguages";
    }

    @GetMapping("/jezyki-i-kraje")
    public String languagesWithCountries(Model model) {
        List<CountryLanguage> languages = countryLanguageService.findAll();

        model.addAttribute("languages", languages);

        return "languagesWithCountries";
    }

}
