import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Amador extends Utilizador implements Serializable {

    public Amador() {
        super();
    }

    public Amador(String codigo, String nome, String morada, String email, int altura, double peso) {
        super(codigo, nome, morada, email, altura, peso);
    }

    public Amador(Amador amador) {
        super(amador);
    }

    // Clone method
    public Amador clone() {
        return new Amador(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amador amador = (Amador) o;
        return (super.equals(amador));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Amador\n");
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
        return (this.getAltura() * 0.015 + this.getPeso() * 0.02);
    }
}
