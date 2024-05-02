import java.io.Serializable;
import java.time.LocalDate;

public class Abdominais extends Atividade implements Serializable {
    private int reps;

    public Abdominais() {
        super();
        this.reps = 0;
    }

    public Abdominais(String codigo, String descricao) {
        super(codigo,descricao);
        this.reps = 0;
    }

    public Abdominais(String codigo, String descricao, int reps) {
        super(codigo, descricao);
        this.reps = reps;
    }

    public Abdominais(String codigo, String descricao, int reps, double tempoDispendido, int freqCardiaca) {
        super(codigo, descricao, tempoDispendido, freqCardiaca);
        this.reps = reps;
    }

    public Abdominais(String codigo, String descricao, int reps, double tempoDispendido, LocalDate data, double calorias, int freqCardiaca) {
        super(codigo, descricao, tempoDispendido, data, calorias, freqCardiaca);
        this.reps = reps;
    }

    public Abdominais(Abdominais ab) {
        super(ab);
        this.reps = ab.getReps();
    }

    public int getReps() {
        return this.reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public Abdominais clone() {
        return new Abdominais(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abdominais ab = (Abdominais) o;
        return (super.equals(ab)) &&
                ab.getReps() == this.reps;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Abdominais\n");
        sb.append("Código: '").append(this.getCodigo()).append("'\n");
        sb.append("Descrição: '").append(this.getDescricao()).append("'\n");
        sb.append("Repetições: '").append(this.reps).append("'\n");
        sb.append("Tempo dispendido a efetuá-la: '").append(this.getTempoDispendido()).append("'\n");
        sb.append("Data: '").append(this.getData()).append("'\n");
        sb.append("Calorias: ").append(this.getCalorias()).append("'\n");
        sb.append("Frequência cardíaca: '").append(this.getFreqCardiaca()).append("'\n");
        return sb.toString();
    }

    public double calculaCalorias(double factorCalorias) {
        return (this.reps * 5 * factorCalorias);
    }
}
