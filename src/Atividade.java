import java.time.LocalDate;
import java.util.Objects;

public class Atividade {
    private String codigo;
    private String nome;

    public Atividade() {
        this.codigo = "N/A";
        this.nome = "N/A";
    }

    public Atividade(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Atividade(Atividade at) {
        this.codigo = at.getCodigo();
        this.nome = at.getNome();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Atividade clone() {
        return new Atividade(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return atividade.getCodigo().equals(this.codigo) &&
                atividade.getNome().equals(this.nome);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código da atividade: '").append(this.codigo).append("'\n");
        sb.append("Nome da atividade: '").append(this.nome).append("'\n");
        return sb.toString();
    }

}
