package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String website;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Codec> codecs;

    public Company() {
    }

    public Company(String name, String website) {
        this.name = name;
        this.website = website;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Codec> getCodecs() {
        return codecs;
    }

    public void addCodec(Codec codec){
        if(!this.codecs.contains(codec)){
            this.codecs.add(codec);
            codec.setCompany(this);
        }
    }

    public void removeCodec(Codec codec){
        if(!this.codecs.contains(codec)){
            this.codecs.remove(codec);
            codec.setCompany(null);
        }
    }
}
