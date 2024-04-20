import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PratOcasional extends Utilizador {
    private int vezesSemana;
    private List<Atividade> atividades;
    private double factorCalorias;

    public PratOcasional() {
        super();
        this.vezesSemana = 0;
        this.atividades = new ArrayList<>();
        this.factorCalorias = 0.0;
    }

    public PratOcasional(String codigo, String nome, String morada, String email, int freqCardiaca,
                         int vezesSemana, List<Atividade> atividades, double factorCalorias) {
        super(codigo, nome, morada, email, freqCardiaca);
        this.vezesSemana = vezesSemana;
        setAtividades(atividades);
        this.factorCalorias = factorCalorias;
    }

    public PratOcasional(PratOcasional pratOcasional) {
        super(pratOcasional);
        this.vezesSemana = pratOcasional.getVezesSemana();
        this.atividades = pratOcasional.getAtividades();
        this.factorCalorias = pratOcasional.getFactorCalorias();
    }

    public int getVezesSemana() {
        return this.vezesSemana;
    }

    public void setVezesSemana(int vezesSemana) {
        this.vezesSemana = vezesSemana;
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
    public PratOcasional clone() {
        return new PratOcasional(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        PratOcasional pratOcasional = (PratOcasional) obj;
        return pratOcasional.getVezesSemana() == this.vezesSemana &&
                this.atividades.equals(pratOcasional.getAtividades()) &&
                pratOcasional.getFactorCalorias() == this.factorCalorias;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), vezesSemana, atividades, factorCalorias);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PratOcasional\n");
        sb.append(super.toString());
        sb.append("Vezes por semana: '").append(this.vezesSemana).append("'\n");
        sb.append("Atividades: ").append(this.atividades.toString()).append("\n");
        sb.append("Factor calórico: '").append(this.factorCalorias).append("'\n");
        return sb.toString();
    }
}
