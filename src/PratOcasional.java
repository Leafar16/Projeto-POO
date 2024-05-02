import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PratOcasional extends Utilizador implements Serializable {

    public PratOcasional() {
        super();
    }

    public PratOcasional(String codigo, String nome, String morada, String email, int altura, double peso) {
        super(codigo, nome, morada, email, altura, peso);
    }

    public PratOcasional(PratOcasional pratOcasional) {
        super(pratOcasional);
    }

    public PratOcasional clone() {
        return new PratOcasional(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PratOcasional prat = (PratOcasional) o;
        return (super.equals(prat));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Praticante Ocasional\n");
        sb.append("Código: '").append(this.getCodigo()).append("'\n");
        sb.append("Nome: '").append(this.getNome()).append("'\n");
        sb.append("Morada: '").append(this.getMorada()).append("'\n");
        sb.append("E-mail: '").append(this.getEmail()).append("'\n");
        sb.append("Frequência cardíaca média: '").append(this.getFreqCardiaca()).append("'\n");
        sb.append("Altura: '").append(this.getAltura()).append(" cm'\n");
        sb.append("Peso: '").append(this.getPeso()).append(" kg'\n");
        sb.append("Atividades: ").append(this.getAtividades().toString()).append("\n");
        sb.append("Factor calórico: '").append(this.getFactorCalorias()).append("'\n");
        return sb.toString();
    }

    public double calculaFactorCalorias() {
        return (this.getAltura() * 0.005 + this.getPeso() * 0.01);
    }
}
