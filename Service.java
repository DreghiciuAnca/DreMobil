package com.example.dremobil;

public class Service {
    private String nume;
    private String detalii;
    private String adresa;
    private String telefon;
    private int img;

    public Service(String nume, String detalii, String adresa, String telefon, int img) {
        this.nume = nume;
        this.detalii = detalii;
        this.adresa = adresa;
        this.telefon = telefon;
        this.img = img;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
