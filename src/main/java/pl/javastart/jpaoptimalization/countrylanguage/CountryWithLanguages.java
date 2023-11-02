package pl.javastart.jpaoptimalization.countrylanguage;

import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguage;

import java.util.Collection;
import java.util.List;

public class CountryWithLanguages {
    private String name;
    private Collection<CountryLanguage> languages;

    public CountryWithLanguages(String name, Collection<CountryLanguage> languages) {
        this.name = name;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<CountryLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(Collection<CountryLanguage> languages) {
        this.languages = languages;
    }
}
