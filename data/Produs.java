package com.example.dremobil.data;

public class Produs {

    private String nume;
    private String cantitate;
    private String pret;
    private String detalii;
    private int img;


    public Produs()
    {

    }

    public Produs(String nume, String cantitate, String pret, String detalii,int img) {
        this.nume = nume;
        this.cantitate = cantitate;
        this.pret = pret;
        this.detalii = detalii;
        this.img = img;
    }

    //geteri

    public String getNume() {
        return nume;
    }

    public String getCantitate() {
        return cantitate;
    }

    public String getPret() {
        return pret;
    }

    public String getDetalii() {
        return detalii;
    }
    public int getImg()
    {
        return img;
    }

    //seteri


    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setCantitate(String cantitate) {
        this.cantitate = cantitate;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public void setImg(int img)
    {
        this.img= img;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "nume='" + nume + '\'' +
                ", cantitate='" + cantitate + '\'' +
                ", pret='" + pret + '\'' +
                ", detalii='" + detalii + '\'' +
                '}';
    }
}
