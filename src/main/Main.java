package main;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LienSGBD_Projet2"); //name of persistence unit
        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }
}
