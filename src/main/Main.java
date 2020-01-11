package main;

import controller.DAO.*;
import model.*;
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

        CodecDAO codecDAO = new CodecDAO(em);
        CompanyDAO companyDAO = new CompanyDAO(em);
        FormatDAO formatDAO = new FormatDAO(em);
        PlayerDAO playerDAO = new PlayerDAO(em);
        VideoDAO videoDAO = new VideoDAO(em);

        Player player = new Player("VLC", 1000);
        Format format = new Format("MP4", "mp4");
        Codec codec = new Codec("codecName", "fileName");

        formatDAO.create(format);
        codec.setFormat(format);
        codecDAO.create(codec);
        player.addCodec(codec);
        playerDAO.create(player);

        Company company = new Company("Google", "www.google.com");
        codec.setCompany(company);

        companyDAO.create(company);

        Codec codec2 = new Codec("codec2", "file2");
        //codec.addPlayer(player);
        player.addCodec(codec2);
        codecDAO.create(codec2);

        //System.out.println(codec.getPlayers());
        //System.out.println(player.getCodecs());

        format.addCodec(codec2);
        formatDAO.save();

        //System.out.println(format.getCodecs());
        //System.out.println(format.getVideos());
        System.out.println(player.getCodecs());
        System.out.println(codec.getPlayers());
        //formatDAO.delete(format);
        codecDAO.delete(codec);

        Video video = new Video("video", format);
        videoDAO.create(video);

        //System.out.println(format.getCodecs());


        em.close();
        emf.close();
    }
}
