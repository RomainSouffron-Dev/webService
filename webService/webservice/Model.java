package com.a3wa.webservice.webservice;

import java.io.Serializable;

public class Model implements Serializable{

    private int id;
    private String titre;
    private String photo;
    private String desc;
    private String carac;
    private float tarif;

    public Model(int id, String titre, String photo) {
        this.id = id;
        this.titre = titre;
        this.photo = photo;
    }

    public Model(int id, String titre, String photo, String desc, String carac, float tarif) {
        this.id = id;
        this.titre = titre;
        this.photo = photo;
        this.desc = desc;
        this.carac = carac;
        this.tarif = tarif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCarac() {
        return carac;
    }

    public void setCarac(String carac) {
        this.carac = carac;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }
}
