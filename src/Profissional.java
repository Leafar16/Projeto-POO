import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Profissional extends Utilizador {
    private int altura;
    private double peso;
    private String modalidade;
    private List<Atividade> atividades;
    private double factorCalorias;

    public Profissional() {
        super();
        this.altura = 0;
        this.peso = 0.0;
        this.modalidade = "N/A";
        this.atividades = new ArrayList<>();
        this.factorCalorias = 0.0;
    }

    public Profissional(String codigo, String nome, String morada, String email, int freqCardiaca, int altura, double peso,
                        String modalidade, List<Atividade> atividades, double factorCalorias) {
        super(codigo, nome, morada, email, freqCardiaca);
        this.altura = altura;
        this.peso = peso;
        this.modalidade = modalidade;
        setAtividades(atividades);
        this.factorCalorias = factorCalorias;
    }

    public Profissional(String codigo, String nome, String morada, String email, int freqCardiaca, int altura, double peso, String modalidade) {
        super(codigo, nome, morada, email, freqCardiaca);
        this.altura = altura;
        this.peso = peso;
        this.modalidade = modalidade;
        this.atividades = new ArrayList<>();
        this.factorCalorias = calculaFactorCal();
    }

    public Profissional(Profissional pro) {
        super(pro);
        this.altura = pro.getAltura();
        this.peso = pro.getPeso();
        this.modalidade = pro.getModalidade();
        this.atividades = pro.getAtividades();
        this.factorCalorias = pro.getFactorCalorias();
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getModalidade() {
        return this.modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public List<Atividade> getAtividades() {
        return this.atividades.stream().map(Atividade::clone)
                .collect(Collectors.toList());
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = new ArrayList<>();
        for (Atividade at : atividades) {
            this.atividades.add(at.clone());
        }
    }

    public double getFactorCalorias() {
        return this.factorCalorias;
    }

    public void setFactorCalorias(double factorCalorias) {
        this.factorCalorias = factorCalorias;
    }

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


    // others
    public Profissional clone() {
        return new Profissional(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Profissional pro = (Profissional) obj;
        return pro.getAltura() == this.altura &&
                pro.getPeso() == this.peso &&
                this.atividades.equals(pro.getAtividades()) &&
                pro.getModalidade().equals(this.modalidade) &&
                pro.getFactorCalorias() == this.factorCalorias;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), altura, peso, modalidade, atividades, factorCalorias);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Profissional\n");
        sb.append(super.toString());
        sb.append("Altura: '").append(this.altura).append("'\n");
        sb.append("Peso: '").append(this.peso).append("'\n");
        sb.append("Atividades: ").append(this.atividades.toString()).append("\n");
        sb.append("Modalidade que pratica: '").append(this.modalidade).append("'\n");
        sb.append("Factor calórico: '").append(this.factorCalorias).append("'\n");
        return sb.toString();
    }

    public double calculaFactorCal() {
        return this.altura * 0.5 + this.peso * 0.4;
    }
}
