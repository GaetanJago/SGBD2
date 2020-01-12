package main;

import controller.DAO.*;
import model.*;
import view.Interface;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    //private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //PropertyConfigurator.configure("log4j.properties");
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LienSGBD_Projet2"); //name of persistence unit
        EntityManager em = emf.createEntityManager();
        
    	generateExample(emf,em);
    	
        //Launch the window
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface(emf,em);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});        
    }
    
    public static void generateExample(EntityManagerFactory emf, EntityManager em) {
    	

        CodecDAO codecDAO = new CodecDAO(em);
        CompanyDAO companyDAO = new CompanyDAO(em);
        FormatDAO formatDAO = new FormatDAO(em);
        PlayerDAO playerDAO = new PlayerDAO(em);
        VideoDAO videoDAO = new VideoDAO(em);

        Player player = new Player("VLC", 1000);
        Player player_b = new Player("Windows media player", 460);
        Format format = new Format("MP4", "mp4");
        Format format_b = new Format("AVI", "avi");
        Codec codec = new Codec("codecName", "fileName");
        Codec codec_b = new Codec("dacodec", "pt.dll");
        
        formatDAO.create(format);
        formatDAO.create(format_b);
        codec.setFormat(format);
        codec_b.setFormat(format_b);
        codecDAO.create(codec);
        codecDAO.create(codec_b);
        player.addCodec(codec);
        player_b.addCodec(codec_b);
        playerDAO.create(player);
        playerDAO.create(player_b);

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
        //codecDAO.delete(codec);

        Video video = new Video("video", format);
        videoDAO.create(video);

        //System.out.println(format.getCodecs());

/*
        em.close();
        emf.close();*/
    }
}
