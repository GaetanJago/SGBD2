package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Codec")
public class Codec {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String dllFileName;

    @ManyToOne
    private Format format;

    @ManyToOne
    private Company company;

    @ManyToMany(mappedBy = "codecs")
    private List<Player> players;

    public Codec() {
    }

    public Codec(String name, String dllFileName){
        this.name = name;
        this.dllFileName = dllFileName;
        this.players = new ArrayList<>();
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

    public String getDllFileName() {
        return dllFileName;
    }

    public void setDllFileName(String dllFileName) {
        this.dllFileName = dllFileName;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        if(this.format != null){
            this.format.getCodecs().remove(this);
        }
        this.format = format;
        if(format != null && !this.format.getCodecs().contains(this)){
            this.format.getCodecs().add(this);
        }
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        if(this.company != null){
            this.company.getCodecs().remove(this);
        }
        this.company = company;
        if(company != null && !this.company.getCodecs().contains(this)){
            this.company.getCodecs().add(this);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    /*public void addPlayer(Player player){
        if(!this.players.contains(player)){
            player.getCodecs().add(this);
            this.players.add(player);
        }
    }*/
    
    @Override
    public String toString() {
    	return getName();
    }
}
