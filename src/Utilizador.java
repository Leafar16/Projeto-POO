import java.util.Objects;

public class Utilizador {
    private String codigo;
    private String nome;
    private String morada;
    private String email;
    private int freqCardiaca;

    public Utilizador() {
        this.codigo = "N/A";
        this.nome = "N/A";
        this.morada = "N/A";
        this.email = "N/A";
        this.freqCardiaca = 0;
    }

    public Utilizador(String codigo, String nome, String morada, String email, int freqCardiaca) {
        this.codigo = codigo;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.freqCardiaca = freqCardiaca;
    }

    public Utilizador(Utilizador user) {
        this.codigo = user.getCodigo();
        this.nome = user.getNome();
        this.morada = user.getMorada();
        this.email = user.getEmail();
        this.freqCardiaca = user.getFreqCardiaca();
    }

    // GETTERS

    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMorada() {
        return this.morada;
    }

    public String getEmail() {
        return this.email;
    }

    public int getFreqCardiaca() {
        return this.freqCardiaca;
    }

    // SETTERS

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFreqCardiaca(int freqCardiaca) {
        this.freqCardiaca = freqCardiaca;
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Utilizador user = (Utilizador) obj;
        return user.getCodigo().equals(this.codigo) &&
                user.getNome().equals(this.nome) &&
                user.getMorada().equals(this.morada) &&
                user.getEmail().equals(this.email) &&
                user.getFreqCardiaca() == this.freqCardiaca;
    }

    public int hashCode() {
        return Objects.hash(codigo, nome, morada, email, freqCardiaca);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código do utilizador: '").append(this.codigo).append("'\n");
        sb.append("Nome: '").append(this.nome).append("'\n");
        sb.append("Morada: ").append(this.morada).append("\n");
        sb.append("Email: '").append(this.email).append("'\n");
        sb.append("Frequência Cardíaca: '").append(this.freqCardiaca).append("'\n");
        return sb.toString();
    }
}