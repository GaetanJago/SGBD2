package model;

import javax.persistence.*;

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

    public Codec() {
    }

    public Codec(String name, String dllFileName){
        this.name = name;
        this.dllFileName = dllFileName;
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
        this.format = format;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
