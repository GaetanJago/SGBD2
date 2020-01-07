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
        this.format = format;
    }
}
