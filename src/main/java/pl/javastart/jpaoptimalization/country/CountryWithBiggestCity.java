package pl.javastart.jpaoptimalization.country;

public class CountryWithBiggestCity {
    private String countryName;
    private String cityName;
    private Integer cityPopulation;

    public CountryWithBiggestCity(String countryName, String cityName, Integer cityPopulation) {
        this.countryName = countryName;
        this.cityName = cityName;
        this.cityPopulation = cityPopulation;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(Integer cityPopulation) {
        this.cityPopulation = cityPopulation;
    }
}
