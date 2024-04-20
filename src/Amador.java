import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Amador extends Utilizador {
    private int altura;
    private double peso;
    private List<Atividade> atividades;
    private double factorCalorias;

    public Amador() {
        super();
        this.altura = 0;
        this.peso = 0.0;
        this.atividades = new ArrayList<>();
        this.factorCalorias = 0.0;
    }

    public Amador(String codigo, String nome, String morada, String email, int freqCardiaca, int altura, double peso,
                  List<Atividade> atividades, double factorCalorias) {
        super(codigo, nome, morada, email, freqCardiaca);
        this.altura = altura;
        this.peso = peso;
        setAtividades(atividades);
        this.factorCalorias = factorCalorias;
    }

    public Amador(Amador amador) {
        super(amador);
        this.altura = amador.getAltura();
        this.peso = amador.getPeso();
        this.atividades = amador.getAtividades();
        this.factorCalorias = amador.getFactorCalorias();
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

    // Clone method
    public Amador clone() {
        return new Amador(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Amador amador = (Amador) obj;
        return amador.getAltura() == this.altura &&
                amador.getPeso() == this.peso &&
                this.atividades.equals(amador.getAtividades()) &&
                amador.getFactorCalorias() == this.factorCalorias;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), altura, peso, atividades, factorCalorias);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Amador\n");
        sb.append(super.toString());
        sb.append("Altura: '").append(this.altura).append("'\n");
        sb.append("Peso: '").append(this.peso).append("'\n");
        sb.append("Atividades: ").append(this.atividades.toString()).append("\n");
        sb.append("Factor calórico: '").append(this.factorCalorias).append("'\n");
        return sb.toString();
    }
}
