import java.time.LocalDate;

public class Pesos extends Atividade {
    private int series;
    private int reps;
    private double peso;
    private double tempoDispendido;
    private LocalDate data;
    private double calorias;

    public Pesos() {
        super();
        this.series = 0;
        this.reps = 0;
        this.peso = 0.0;
        this.tempoDispendido = 0;
        this.data = LocalDate.now();
        this.calorias = 0;
    }

    public Pesos(String codigo, String nome) {
        super(codigo,nome);
        this.series = 0;
        this.reps = 0;
        this.peso = 0;
        this.tempoDispendido = 0;
        this.data = LocalDate.now();
        this.calorias = 0;
    }

    public Pesos(String codigo, String nome, int series, int reps, double peso, double tempoDispendido) {
        super(codigo, nome);
        this.series = series;
        this.reps = reps;
        this.peso = peso;
        this.tempoDispendido = tempoDispendido;
        this.data = LocalDate.now();
        this.calorias = (5 * reps * (peso * 0.2)) * series;
    }

    public Pesos(String codigo, String nome, double tempoDispendido, LocalDate data, int series, int reps, double peso, double calorias) {
        super(codigo, nome);
        this.series = series;
        this.reps = reps;
        this.peso = peso;
        this.data = data;
        this.tempoDispendido = tempoDispendido;
        this.calorias = calorias;
    }

    public Pesos(Pesos p) {
        super(p);
        this.series = p.getSeries();
        this.reps = p.getReps();
        this.peso = p.getPeso();
        this.tempoDispendido = p.getTempoDispendido();
        this.data = p.getData();
        this.calorias = p.getCalorias();
    }

    public int getSeries() {
        return this.series;
    }

    public void setSeries(int series) {
        this.series = series;
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

    public Pesos clone() {
        return new Pesos(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pesos pesos = (Pesos) o;
        return pesos.getSeries() == this.series &&
                pesos.getReps() == this.reps &&
                pesos.getPeso() == this.peso &&
                pesos.getTempoDispendido() == this.tempoDispendido &&
                pesos.getData().equals(this.data) &&
                pesos.getCalorias() == this.calorias;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Pesos\n");
        sb.append(super.toString());
        sb.append("Séries: '").append(this.series).append("'\n");
        sb.append("Repetições: '").append(this.reps).append("'\n");
        sb.append("Peso: '").append(this.peso).append("'\n");
        sb.append("Tempo dispendido a efetuá-la: '").append(this.tempoDispendido).append("'\n");
        sb.append("Data: '").append(this.data).append("'\n");
        sb.append("Calorias: ").append(this.calorias).append("'\n");
        return sb.toString();
    }
}
