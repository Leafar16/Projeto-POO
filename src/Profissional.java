import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Profissional extends Utilizador implements Serializable {

    public Profissional() {
        super();
    }

    public Profissional(String codigo, String nome, String morada, String email, int altura, double peso) {
        super(codigo, nome, morada, email, altura, peso);
    }

    public Profissional(Profissional pro) {
        super(pro);
    }

    /*
    public Atividade addAtividade(Atividade a, TipoAtividade ta) {
        Atividade add;
        switch (ta) {
            case DistAlt:
                add = Menu.menuSetDistAlt(a.getCodigo(), a.getNome());
                break;
            case Dist:
                add = Menu.menuSetDist(a.getCodigo(), a.getNome());
                break;
            case Reps:
                add = Menu.menuSetReps(a.getCodigo(), a.getNome());
                break;
            case Pesos:
                add = Menu.menuSetPesos(a.getCodigo(), a.getNome());
                break;
            default:
                return null;
        }

        this.atividades.add(add);
        return add;
    }
    */


    // others
    public Profissional clone() {
        return new Profissional(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profissional pro = (Profissional) o;
        return (super.equals(pro));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Profissional\n");
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
        return (this.getAltura() * 0.02 + this.getPeso() * 0.04);
    }
}
