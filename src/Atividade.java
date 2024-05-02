import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public abstract class Atividade implements Serializable {
    private String codigo;
    private String descricao;
    private double tempoDispendido;
    private LocalDate data;
    private double calorias;
    private int freqCardiaca;

    public Atividade() {
        this.codigo = "N/A";
        this.descricao = "N/A";
        this.tempoDispendido = 0.0;
        this.data = LocalDate.now();
        this.calorias = 0;
        this.freqCardiaca = 0;
    }

    public Atividade(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tempoDispendido = 0;
        this.data = LocalDate.now();
        this.calorias = 0;
        this.freqCardiaca = 0;
    }

    public Atividade(String codigo, String descricao, double tempoDispendido, int freqCardiaca) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tempoDispendido = tempoDispendido;
        this.data = LocalDate.now();
        this.calorias = 0.0;
        this.freqCardiaca = freqCardiaca;
    }

    public Atividade(String codigo, String descricao, double tempoDispendido, LocalDate data, double calorias, int freqCardiaca) {
        this.codigo = codigo;
        this.tempoDispendido = tempoDispendido;
        this.data = data;
        this.calorias = calorias;
        this.freqCardiaca = freqCardiaca;
    }

    public Atividade(Atividade at) {
        this.codigo = at.getCodigo();
        this.descricao = at.getDescricao();
        this.tempoDispendido = at.getTempoDispendido();
        this.data = at.getData();
        this.calorias = at.getCalorias();
        this.freqCardiaca = at.getFreqCardiaca();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getTempoDispendido() {
        return this.tempoDispendido;
    }

    public void setTempoDispendido(double tempoDispendido) {
        this.tempoDispendido = tempoDispendido;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getCalorias() {
        return this.calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public int getFreqCardiaca() { return this.freqCardiaca; }

    public void setFreqCardiaca(int freqCardiaca) {
        this.freqCardiaca = freqCardiaca;
    }

    public abstract Atividade clone();

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return atividade.getCodigo().equals(this.codigo) &&
                atividade.getDescricao().equals(this.descricao) &&
                atividade.getTempoDispendido() == this.tempoDispendido &&
                atividade.getData().equals(this.data) &&
                atividade.getCalorias() == this.calorias &&
                atividade.getFreqCardiaca() == this.freqCardiaca;
    }

    public abstract String toString();

    public abstract double calculaCalorias(double factorCalorias);

}
