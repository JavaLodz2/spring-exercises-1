package pl.sda.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.enums.Continent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by trot on 11.03.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
public class BeanTest {

    @Autowired
    private Bean bean;

    @Autowired
    @Qualifier(value = "childBean")
    private Bean childBean;

    @Test
    public void testBeanInjection() throws Exception {
        assertNotNull(bean);
    }

    @Test
    public void testCodeFieldValue() throws Exception {
        testBeanInjection();
        assertEquals("00001", bean.getCode());
    }

    @Test
    public void testVersionFieldCheck() throws Exception {
        testBeanInjection();
        assertEquals(1, bean.getVersion().getVersionNumber());
    }

    @Test
    public void testListAltCodes() throws Exception {
        testBeanInjection();
        assertEquals("54000", bean.getAltCodes().get(2));
    }

    @Test
    public void testChildBeanInjection() throws Exception {
        assertNotNull(childBean);
        assertEquals("54000", childBean.getAltCodes().get(2));
        assertEquals("00010", childBean.getCode());
    }

    @Test
    public void testSubBeanListCheck() throws Exception {
        testBeanInjection();
        assertEquals("subBean1", bean.getSubBeans().get(0).getName());
        assertEquals("subBean2", bean.getSubBeans().get(1).getName());
    }

    @Test
    public void testCountryMap() throws Exception {
        testBeanInjection();
        assertNotNull(bean.getCountryMap());

        assertEquals("Poland", bean.getCountryMap().get("Poland").getName());
        assertEquals("Japan", bean.getCountryMap().get("Japan").getName());
        assertEquals("Egypt", bean.getCountryMap().get("Egypt").getName());

        assertEquals("001", bean.getCountryMap().get("Poland").getIsoCode());
        assertEquals("010", bean.getCountryMap().get("Japan").getIsoCode());
        assertEquals("100", bean.getCountryMap().get("Egypt").getIsoCode());

        assertEquals(Continent.EUROPE, bean.getCountryMap().get("Poland").getContinent());
        assertEquals(Continent.ASIA, bean.getCountryMap().get("Japan").getContinent());
        assertEquals(Continent.AFRICA, bean.getCountryMap().get("Egypt").getContinent());
    }
}