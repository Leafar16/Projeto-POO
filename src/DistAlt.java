import java.time.LocalDate;

public class DistAlt extends Atividade {
    private double altitude;
    private double distancia;
    private double tempoDispendido;
    private LocalDate data;
    private double calorias;

    public DistAlt() {
        super();
        this.altitude = 0;
        this.distancia = 0;
        this.tempoDispendido = 0;
        this.data = LocalDate.now();
        this.calorias = 0;
    }

    public DistAlt(String codigo, String nome) {
        super(codigo,nome);
        this.altitude = 0;
        this.distancia = 0;
        this.tempoDispendido = 0;
        this.data = LocalDate.now();
        this.calorias = 0;
    }

    public DistAlt(String codigo, String nome, double altitude, double distancia, double tempoDispendido) {
        super(codigo, nome);
        this.altitude = altitude;
        this.distancia = distancia;
        this.tempoDispendido = tempoDispendido;
        this.data = LocalDate.now();
        this.calorias = altitude * 0.2 + distancia * 0.1;
    }

    public DistAlt(String codigo, String nome, double altitude, double distancia, double tempoDispendido, LocalDate data, double calorias) {
        super(codigo, nome);
        this.altitude = altitude;
        this.distancia = distancia;
        this.tempoDispendido = tempoDispendido;
        this.data = data;
        this.calorias = calorias;
    }

    public DistAlt(DistAlt da) {
        super(da);
        this.altitude = da.getAltitude();
        this.distancia = da.getDistancia();
        this.tempoDispendido = da.getTempoDispendido();
        this.data = da.getData();
        this.calorias = da.getCalorias();
    }

    public double getAltitude() {
        return this.altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
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

    public DistAlt clone() {
        return new DistAlt(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DistAlt distAlt = (DistAlt) o;
        return distAlt.getAltitude() == this.altitude &&
                distAlt.getDistancia() == this.distancia &&
                distAlt.getTempoDispendido() == this.tempoDispendido &&
                distAlt.getData().equals(this.data) &&
                distAlt.getCalorias() == this.calorias;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DistAlt\n");
        sb.append(super.toString());
        sb.append("Altitude: '").append(this.altitude).append("'\n");
        sb.append("Distância: '").append(this.distancia).append("'\n");
        sb.append("Tempo dispendido a efetuá-la: '").append(this.tempoDispendido).append("'\n");
        sb.append("Data: '").append(this.data).append("'\n");
        sb.append("Calorias: ").append(this.calorias).append("'\n");
        return sb.toString();
    }
}
