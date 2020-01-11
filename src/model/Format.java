package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Format")
public class Format {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String extension;

    @OneToMany(mappedBy = "format", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Codec> codecs;


    @OneToMany(mappedBy = "format", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos;

    public Format(){}

    public Format(String name, String extension) {
        this.extension = extension;
        this.name = name;
        this.codecs = new ArrayList<>();
        this.videos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public List<Codec> getCodecs() {
        return codecs;
    }


    public List<Video> getVideos() {
        return videos;
    }

    public void addCodec(Codec codec){
        if(!this.codecs.contains(codec)){
            this.codecs.add(codec);
            codec.setFormat(this);
        }
    }

    public void addVideo(Video video){
        if(!this.videos.contains(video)){
            this.videos.add(video);
            video.setFormat(this);
        }
    }

}
