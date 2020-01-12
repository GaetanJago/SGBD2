package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Player")
public class Player {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int koRequired;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "Accede",
            joinColumns = { @JoinColumn(name = "player_id")},
            inverseJoinColumns = {@JoinColumn(name = "codec_id")}
    )
    private List<Codec> codecs;

    public Player(){}

    public Player(String name, int koRequired) {
        this.name = name;
        this.koRequired = koRequired;
        this.codecs = new ArrayList<>();
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

    public int getKoRequired() {
        return koRequired;
    }

    public void setKoRequired(int koRequired) {
        this.koRequired = koRequired;
    }

    public List<Codec> getCodecs() {
        return codecs;
    }

    public void addCodec(Codec codec){
        if(!this.codecs.contains(codec)){
            codec.getPlayers().add(this);
            this.codecs.add(codec);
        }
    }

    public void removeCodec(Codec codec){
        if(!this.codecs.contains(codec)){
            codec.getPlayers().remove(this);
            this.codecs.remove(codec);
        }
    }
    
    @Override
    public String toString() {
    	return getName();
    }
}
