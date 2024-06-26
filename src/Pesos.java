import java.io.Serializable;
import java.time.LocalDate;

public class Pesos extends Atividade implements Serializable {
    private int reps;
    private double peso;

    public Pesos() {
        super();
        this.reps = 0;
        this.peso = 0.0;
    }

    public Pesos(String codigo, String descricao) {
        super(codigo,descricao);
        this.reps = 0;
        this.peso = 0.0;
    }

    public Pesos(String codigo, String descricao, int reps, double peso) {
        super(codigo, descricao);
        this.reps = reps;
        this.peso = peso;
    }

    public Pesos(String codigo, String descricao, int reps, double peso, double tempoDispendido, int freqCardiaca) {
        super(codigo, descricao, tempoDispendido, freqCardiaca);
        this.reps = reps;
        this.peso = peso;
    }

    public Pesos(String codigo, String descricao, int reps, double peso, double tempoDispendido, LocalDate data, double calorias, int freqCardiaca) {
        super(codigo, descricao, tempoDispendido, data, calorias, freqCardiaca);
        this.reps = reps;
        this.peso = peso;
    }

    public Pesos(Pesos p) {
        super(p);
        this.reps = p.getReps();
        this.peso = p.getPeso();
    }

    public int getReps() {
        return this.reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Pesos clone() {
        return new Pesos(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pesos p = (Pesos) o;
        return (super.equals(p)) &&
                p.getReps() == this.reps &&
                p.getPeso() == this.peso;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Pesos\n");
        sb.append("Código: '").append(this.getCodigo()).append("'\n");
        sb.append("Descrição: '").append(this.getDescricao()).append("'\n");
        sb.append("Repetições: '").append(this.reps).append("'\n");
        sb.append("Peso: '").append(this.peso).append("'\n");
        sb.append("Tempo dispendido a efetuá-la: '").append(this.getTempoDispendido()).append("'\n");
        sb.append("Data: '").append(this.getData()).append("'\n");
        sb.append("Calorias: ").append(this.getCalorias()).append("'\n");
        sb.append("Frequência cardíaca: '").append(this.getFreqCardiaca()).append("'\n");
        return sb.toString();
    }

    public double calculaCalorias(double factorCalorias) {
        return (this.reps * 5 * this.peso * 0.25 * factorCalorias);
    }
}
