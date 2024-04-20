import java.time.LocalDate;

public class Reps extends Atividade {
    private int series;
    private int reps;
    private double tempoDispendido;
    private LocalDate data;
    private double calorias;

    public Reps() {
        super();
        this.series = 0;
        this.reps = 0;
        this.tempoDispendido = 0;
        this.data = LocalDate.now();
        this.calorias = 0;
    }

    public Reps(String codigo, String nome) {
        super(codigo,nome);
        this.series = 0;
        this.reps = 0;
        this.tempoDispendido = 0;
        this.data = LocalDate.now();
        this.calorias = 0;
    }

    public Reps(String codigo, String nome, int series, int reps, double tempoDispendido) {
        super(codigo, nome);
        this.series = series;
        this.reps = reps;
        this.tempoDispendido = tempoDispendido;
        this.data = LocalDate.now();
        this.calorias = (5 * reps) * series;
    }

    public Reps(String codigo, String nome, double tempoDispendido, LocalDate data, int series, int reps, double calorias) {
        super(codigo, nome);
        this.series = series;
        this.reps = reps;
        this.tempoDispendido = tempoDispendido;
        this.data = data;
        this.calorias = calorias;
    }

    public Reps(Reps r) {
        super(r);
        this.series = r.getSeries();
        this.reps = r.getReps();
        this.tempoDispendido = r.getTempoDispendido();
        this.data = r.getData();
        this.calorias = r.getCalorias();
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

    public Reps clone() {
        return new Reps(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reps reps = (Reps) o;
        return reps.getSeries() == this.series &&
                reps.getReps() == this.reps &&
                reps.getTempoDispendido() == this.tempoDispendido &&
                reps.getData().equals(this.data) &&
                reps.getCalorias() == this.calorias;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Reps\n");
        sb.append(super.toString());
        sb.append("Séries: '").append(this.series).append("'\n");
        sb.append("Repetições: '").append(this.reps).append("'\n");
        sb.append("Tempo dispendido a efetuá-la: '").append(this.tempoDispendido).append("'\n");
        sb.append("Data: '").append(this.data).append("'\n");
        sb.append("Calorias: ").append(this.calorias).append("'\n");
        return sb.toString();
    }
}
