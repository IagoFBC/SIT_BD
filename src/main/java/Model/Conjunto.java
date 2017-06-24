package main.java.Model;

import java.util.Date;

public class Conjunto {

    private int id_conj;
    private int id_org;
    private int serie;
    private String titulo;
    private String dataset;
    private Date data_modif;
    private Date data_ini;
    private Date data_final;
    private String json;

    public Conjunto() {
    }

    public Conjunto(int id_conj, int id_org, int serie, String titulo, String dataset, Date data_modif, Date data_ini, Date data_final, String json) {
        this.id_conj = id_conj;
        this.id_org = id_org;
        this.serie = serie;
        this.titulo = titulo;
        this.dataset = dataset;
        this.data_modif = data_modif;
        this.data_ini = data_ini;
        this.data_final = data_final;
        this.json = json;
    }

    public int getId_conj() {
        return id_conj;
    }

    public void setId_conj(int id_conj) {
        this.id_conj = id_conj;
    }

    public int getId_org() {
        return id_org;
    }

    public void setId_org(int id_org) {
        this.id_org = id_org;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getNome() {
        return titulo;
    }

    public void setNome(String nome) {
        this.titulo = nome;
    }

    public Date getData_modif() {
        return data_modif;
    }

    public void setData_modif(Date data_modif) {
        this.data_modif = data_modif;
    }

    public Date getData_ini() {
        return data_ini;
    }

    public void setData_ini(Date data_ini) {
        this.data_ini = data_ini;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }
}


