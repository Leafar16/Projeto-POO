import java.io.Serializable;
import java.time.LocalDate;

public class Corrida extends Atividade implements Serializable {
    private double distancia;

    public Corrida() {
        super();
        this.distancia = 0.0;
    }

    public Corrida(String codigo, String descricao) {
        super(codigo,descricao);
        this.distancia = 0.0;
    }

    public Corrida(String codigo, String descricao, double distancia) {
        super(codigo, descricao);
        this.distancia = distancia;
    }

    public Corrida(String codigo, String descricao, double distancia, double tempoDispendido, int freqCardiaca) {
        super(codigo, descricao, tempoDispendido, freqCardiaca);
        this.distancia = distancia;
    }

    public Corrida(String codigo, String descricao, double distancia, double tempoDispendido, LocalDate data, double calorias, int freqCardiaca) {
        super(codigo, descricao, tempoDispendido, data, calorias, freqCardiaca);
        this.distancia = distancia;
    }

    public Corrida(Corrida co) {
        super(co);
        this.distancia = co.getDistancia();
    }

    public double getDistancia() {
        return this.distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Corrida clone() {
        return new Corrida(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corrida corrida = (Corrida) o;
        return (super.equals(corrida)) && corrida.getDistancia() == this.distancia;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Corrida\n");
        sb.append("Código: '").append(this.getCodigo()).append("'\n");
        sb.append("Descrição: '").append(this.getDescricao()).append("'\n");
        sb.append("Distância: '").append(this.distancia).append("'\n");
        sb.append("Tempo dispendido a efetuá-la: '").append(this.getTempoDispendido()).append("'\n");
        sb.append("Data: '").append(this.getData()).append("'\n");
        sb.append("Calorias: ").append(this.getCalorias()).append("'\n");
        sb.append("Frequência cardíaca: '").append(this.getFreqCardiaca()).append("'\n");
        return sb.toString();
    }

    public double calculaCalorias(double factorCalorias) {
        return (this.distancia * 0.1 * factorCalorias);
    }
}
