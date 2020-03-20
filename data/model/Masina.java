package com.example.dremobil.data.model;

public class Masina {

    private String marca;
    private String model;
    private String capacitate;
    private String tractiune;
    private String caiPutere;
    private String motorizare;

    public Masina(String marca, String model, String capacitate, String tractiune, String caiPutere, String motorizare) {
        this.marca = marca;
        this.model = model;
        this.capacitate = capacitate;
        this.tractiune = tractiune;
        this.caiPutere = caiPutere;
        this.motorizare = motorizare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(String capacitate) {
        this.capacitate = capacitate;
    }

    public String getTractiune() {
        return tractiune;
    }

    public void setTractiune(String tractiune) {
        this.tractiune = tractiune;
    }

    public String getCaiPutere() {
        return caiPutere;
    }

    public void setCaiPutere(String caiPutere) {
        this.caiPutere = caiPutere;
    }

    public String getMotorizare() {
        return motorizare;
    }

    public void setMotorizare(String motorizare) {
        this.motorizare = motorizare;
    }
}
