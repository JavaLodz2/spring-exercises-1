package pl.sda.beans;

import pl.sda.enums.Continent;

/**
 * Created by trot on 11.03.17.
 */
public class CountryBean {
    private String name;
    private String isoCode;
    private Continent continent;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}
