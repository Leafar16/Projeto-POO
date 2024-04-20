import java.time.LocalDate;

public class Dist extends Atividade {
    private double distancia;
    private double tempoDispendido;
    private LocalDate data;
    private double calorias;

    public Dist() {
        super();
        this.distancia = 0;
        this.tempoDispendido = 0;
        this.data = LocalDate.now();
        this.calorias = 0;
    }

    public Dist(String codigo, String nome) {
        super(codigo,nome);
        this.distancia = 0;
        this.tempoDispendido = 0;
        this.data = LocalDate.now();
        this.calorias = 0;
    }

    public Dist(String codigo, String nome, double distancia, double tempoDispendido) {
        super(codigo, nome);
        this.distancia = distancia;
        this.tempoDispendido = tempoDispendido;
        this.data = LocalDate.now();
        this.calorias = 0.1 * distancia;
    }

    public Dist(String codigo, String nome, double tempoDispendido, LocalDate data, double distancia, double calorias) {
        super(codigo, nome);
        this.distancia = distancia;
        this.tempoDispendido = tempoDispendido;
        this.data = data;
        this.calorias = calorias;
    }

    public Dist(Dist d) {
        super(d);
        this.distancia = d.getDistancia();
        this.tempoDispendido = d.getTempoDispendido();
        this.data = d.getData();
        this.calorias = d.getCalorias();
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
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

    public Dist clone() {
        return new Dist(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dist dist = (Dist) o;
        return dist.getDistancia() == this.distancia &&
                dist.getTempoDispendido() == this.tempoDispendido &&
                dist.getData().equals(this.data) &&
                dist.getCalorias() == this.calorias;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dist\n");
        sb.append(super.toString());
        sb.append("Distância: '").append(this.distancia).append("'\n");
        sb.append("Tempo dispendido a efetuá-la: '").append(this.tempoDispendido).append("'\n");
        sb.append("Data: '").append(this.data).append("'\n");
        sb.append("Calorias: ").append(this.calorias).append("'\n");
        return sb.toString();
    }
}
