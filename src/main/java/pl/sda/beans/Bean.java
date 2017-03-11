package pl.sda.beans;

import java.util.List;
import java.util.Map;

/**
 * Created by trot on 11.03.17.
 */
public class Bean {

    private String code;
    private BeanVersion version;
    private List<String> altCodes;
    private List<SubBean> subBeans;
    private Map<String, CountryBean> countryMap;

    public Bean(List altCodes) {
        this.altCodes = altCodes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BeanVersion getVersion() {
        return version;
    }

    public void setVersion(BeanVersion version) {
        this.version = version;
    }

    public List<String> getAltCodes() {
        return altCodes;
    }

    public List<SubBean> getSubBeans() {
        return subBeans;
    }

    public void setSubBeans(List<SubBean> subBeans) {
        this.subBeans = subBeans;
    }

    public Map<String, CountryBean> getCountryMap() {
        return countryMap;
    }

    public void setCountryMap(Map<String, CountryBean> countryMap) {
        this.countryMap = countryMap;
    }
}
