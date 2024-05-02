import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Utilizador implements Serializable {
    private String codigo;
    private String nome;
    private String morada;
    private String email;
    private int freqCardiaca;
    private int altura;
    private double peso;
    private List<Atividade> atividades;
    private double factorCalorias;

    public Utilizador() {
        this.codigo = "N/A";
        this.nome = "N/A";
        this.morada = "N/A";
        this.email = "N/A";
        this.freqCardiaca = 0;
        this.altura = 0;
        this.peso = 0.0;
        this.atividades = new ArrayList<>();
        this.factorCalorias = 0.0;
    }

    public Utilizador(String codigo, String nome, String morada, String email, int altura, double peso) {
        this.codigo = codigo;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.freqCardiaca = 0;
        this.altura = altura;
        this.peso = peso;
        this.atividades = new ArrayList<>();
        this.factorCalorias = calculaFactorCalorias();

    }

    public Utilizador(Utilizador user) {
        this.codigo = user.getCodigo();
        this.nome = user.getNome();
        this.morada = user.getMorada();
        this.email = user.getEmail();
        this.freqCardiaca = user.getFreqCardiaca();
        this.altura = user.getAltura();
        this.peso = user.getPeso();
        this.atividades = user.getAtividades();
        this.factorCalorias = user.getFactorCalorias();
    }

    // GETTERS

    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public String getEmail() {
        return this.email;
    }

    public int getFreqCardiaca() {
        return this.freqCardiaca;
    }

    // SETTERS

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFreqCardiaca(int freqCardiaca) {
        this.freqCardiaca = freqCardiaca;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public List<Atividade> getAtividades() {
        return this.atividades.stream().map(Atividade::clone)
                .collect(Collectors.toList());
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = new ArrayList<>();
        for (Atividade at : atividades) {
            this.atividades.add(at.clone());
        }
    }

    public double getFactorCalorias() {
        return this.factorCalorias;
    }

    public void setFactorCalorias(double factorCalorias) {
        this.factorCalorias = factorCalorias;
    }

    public abstract Utilizador clone();

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Utilizador user = (Utilizador) obj;
        return user.getCodigo().equals(this.codigo) &&
                user.getNome().equals(this.nome) &&
                user.getMorada().equals(this.morada) &&
                user.getEmail().equals(this.email) &&
                user.getFreqCardiaca() == this.freqCardiaca &&
                user.getAltura() == this.altura &&
                user.getPeso() == this.peso &&
                this.atividades.equals(user.getAtividades()) &&
                user.getFactorCalorias() == this.factorCalorias;
    }

    public abstract String toString();

    public abstract double calculaFactorCalorias();

    public void addAtividade(Atividade at) {
        this.atividades.add(at);
    }

    public void updateFreqCardiaca(int newFreqCardiaca) {
        if (this.freqCardiaca != 0) {
            this.freqCardiaca = (this.freqCardiaca + newFreqCardiaca)/2;
        } else this.freqCardiaca = newFreqCardiaca;
    }
}