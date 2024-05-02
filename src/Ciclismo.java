import java.io.Serializable;
import java.time.LocalDate;

public class Ciclismo extends Atividade implements Serializable {
    private double distancia;
    private double altitude;

    public Ciclismo() {
        super();
        this.distancia = 0.0;
        this.altitude = 0.0;
    }

    public Ciclismo(String codigo, String descricao) {
        super(codigo,descricao);
        this.distancia = 0.0;
        this.altitude = 0.0;
    }

    public Ciclismo(String codigo, String descricao, double distancia, double altitude) {
        super(codigo, descricao);
        this.distancia = distancia;
        this.altitude = altitude;
    }

    public Ciclismo(String codigo, String descricao, double distancia, double altitude, double tempoDispendido, int freqCardiaca) {
        super(codigo, descricao, tempoDispendido, freqCardiaca);
        this.distancia = distancia;
        this.altitude = altitude;
    }

    public Ciclismo(String codigo, String descricao, double distancia, double altitude, double tempoDispendido, LocalDate data, double calorias, int freqCardiaca) {
        super(codigo, descricao, tempoDispendido, data, calorias, freqCardiaca);
        this.distancia = distancia;
        this.altitude = altitude;
    }

    public Ciclismo(Ciclismo cl) {
        super(cl);
        this.distancia = cl.getDistancia();
        this.altitude = cl.getAltitude();
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

    public Ciclismo clone() {
        return new Ciclismo(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciclismo ciclismo = (Ciclismo) o;
        return (super.equals(ciclismo)) &&
                ciclismo.getDistancia() == this.distancia &&
                ciclismo.getAltitude() == this.altitude;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Corrida\n");
        sb.append("Código: '").append(this.getCodigo()).append("'\n");
        sb.append("Descrição: '").append(this.getDescricao()).append("'\n");
        sb.append("Distância: '").append(this.distancia).append("'\n");
        sb.append("Ciclismo: '").append(this.altitude).append("'\n");
        sb.append("Tempo dispendido a efetuá-la: '").append(this.getTempoDispendido()).append("'\n");
        sb.append("Data: '").append(this.getData()).append("'\n");
        sb.append("Calorias: ").append(this.getCalorias()).append("'\n");
        sb.append("Frequência cardíaca: '").append(this.getFreqCardiaca()).append("'\n");
        return sb.toString();
    }

    public double calculaCalorias (double factorCalorias) {
        return ((this.distancia * 0.15 + this.altitude * 0.5) * factorCalorias);
    }

}
