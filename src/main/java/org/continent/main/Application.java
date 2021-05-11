package org.continent.main;

import org.continent.bean.Continent;
import org.continent.bean.Country;
import org.continent.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Continent europe = new Continent("Europe");
            Continent asia = new Continent("Asia");

            Country svk = new Country("Slovakia");
            Country hun = new Country("Hungary");
            Country pol = new Country("Poland");

            Set<Country> europeCountries = new HashSet<>();
            europeCountries.add(svk);
            europeCountries.add(hun);
            europeCountries.add(pol);
            europe.setCountries(europeCountries);

            Country chi = new Country("China");
            Country kor = new Country("South Korea");
            Country jap = new Country("Japan");

            Set<Country> asiaCountries = new HashSet<>();

            asiaCountries.add(chi);
            asiaCountries.add(kor);
            asiaCountries.add(jap);
            asia.setCountries(asiaCountries);

            session.save(europe);
            session.save(asia);


            Query query2 = session.createQuery("SELECT DISTINCT cont FROM "
                    + "Continent cont JOIN cont.countries WHERE continent_name='Europe'");

            Continent europe_cont = (Continent) query2.getSingleResult();

            System.out.println("\u001B[34m"+"<===============================================================================>"+"\u001B[0m");
            System.out.println("\u001B[32m"+europe_cont+"\u001B[0m");


            session.getTransaction().commit();

        } finally {
            HibernateUtil.shutdown();
        }

    }
}
