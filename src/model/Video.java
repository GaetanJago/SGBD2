package model;

import javax.persistence.*;

@Entity
@Table(name = "Video")
public class Video {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fileName;

    @ManyToOne
    private Format format;

    public Video() {
    }

    public Video(String fileName, Format format) {
        this.fileName = fileName;
        this.format = format;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        if(this.format != null){
            this.format.getVideos().remove(this);
        }
        this.format = format;
        if(format != null && !this.format.getVideos().contains(this)){
            this.format.getVideos().add(this);
        }
    }
    
    @Override
    public String toString() {
    	return getFileName();
    }
}
