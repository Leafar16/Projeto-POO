import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Estado implements Serializable {
    private Utilizadores profissionais;
    private Utilizadores amadores;
    private Utilizadores pratocasionais;
    private Atividades distalt;
    private Atividades dist;
    private Atividades reps;
    private Atividades pesos;

    public Estado() {
        this.profissionais = new Utilizadores();
        this.amadores = new Utilizadores();
        this.pratocasionais = new Utilizadores();
        this.distalt = new Atividades();
        this.dist = new Atividades();
        this.reps = new Atividades();
        this.pesos = new Atividades();
    }

    public Estado(Estado outro) {
        this.profissionais = outro.profissionais;
        this.amadores = outro.amadores;
        this.pratocasionais = outro.pratocasionais;
        this.distalt = outro.distalt;
        this.dist = outro.dist;
        this.reps = outro.reps;
        this.pesos = outro.pesos;
    }

    public boolean existeEmail(String s) {
        return this.profissionais.existeEmail(s) || this.amadores.existeEmail(s)
                || this.pratocasionais.existeEmail(s);
    }
    public String newCodeUser(TipoUtilizador tipoUtilizador) {
        if (tipoUtilizador.equals(TipoUtilizador.Profissional)) return ("P"+this.profissionais.newCodeNumber());
        else if (tipoUtilizador.equals(TipoUtilizador.Amador)) return ("A"+this.amadores.newCodeNumber());
        else return ("O"+this.pratocasionais.newCodeNumber());
    }

    public String newCodeAt(TipoAtividade tipoAtividade) {
        if (tipoAtividade.equals(TipoAtividade.DistAlt)) return ("DA"+this.distalt.newCodeNumberAt());
        else if (tipoAtividade.equals(TipoAtividade.Dist)) return ("D"+this.dist.newCodeNumberAt());
        else if (tipoAtividade.equals(TipoAtividade.Reps)) return ("R"+this.reps.newCodeNumberAt());
        else return ("P"+this.pesos.newCodeNumberAt());

    }

    public boolean freeEmail(String email){
        return this.profissionais.getUtilizadorByEmail(email) == null
                && this.amadores.getUtilizadorByEmail(email) == null
                && this.pratocasionais.getUtilizadorByEmail(email) == null;
    }

    public Utilizador getUtilizadorFromCredentials(String codigo) {
        Utilizador utilizador = this.profissionais.getUtilizadorbyCode(codigo);
        if (utilizador != null) return utilizador;

        utilizador = this.amadores.getUtilizadorbyCode(codigo);
        if (utilizador != null) return utilizador;

        utilizador = this.pratocasionais.getUtilizadorbyCode(codigo);
        if (utilizador != null) return utilizador;

        return null;
    }

    public void addUtilizador(Utilizador utilizador) {
        if (utilizador instanceof Profissional) this.profissionais.addUtilizador(utilizador);
        else if (utilizador instanceof Amador) this.amadores.addUtilizador(utilizador);
        else this.pratocasionais.addUtilizador(utilizador);
    }

    public void addAtividade(Atividade atividade) {
        if (atividade instanceof DistAlt) this.distalt.addAtividade(atividade);
        else if (atividade instanceof Dist) this.dist.addAtividade(atividade);
        else if (atividade instanceof Reps) this.reps.addAtividade(atividade);
        else this.pesos.addAtividade(atividade);
    }

    public Map<String, String> showAtividades(TipoAtividade tipoAtividade) {
        Map<String, String> atividadesMap = new HashMap<>();
        Map<String, Atividade> atividades;

        switch (tipoAtividade) {
            case DistAlt:
                atividades = this.distalt.getAtividades();
                break;
            case Dist:
                atividades = this.dist.getAtividades();
                break;
            case Reps:
                atividades = this.reps.getAtividades();
                break;
            case Pesos:
                atividades = this.pesos.getAtividades();
                break;
            default:
                return null;
        }

        for (Map.Entry<String, Atividade> entry : atividades.entrySet()) {
            String codigo = entry.getKey();
            String nome = entry.getValue().getNome();
            atividadesMap.put(codigo, nome);
        }

        return atividadesMap;
    }

    public Atividade getAtividadefromCode(String codigo, TipoAtividade ta) {
        Atividade a;
        switch (ta) {
            case DistAlt:
                a = this.distalt.getAtividadeByCodigo(codigo);
                break;
            case Dist:
                a = this.dist.getAtividadeByCodigo(codigo);
                break;
            case Reps:
                a = this.reps.getAtividadeByCodigo(codigo);
                break;
            case Pesos:
                a = this.pesos.getAtividadeByCodigo(codigo);
                break;
            default:
                return null;
        }

        return a;
    }

    public boolean atCodeValid(String cod, TipoAtividade ta) {
        switch (ta) {
            case DistAlt:
                return this.distalt.existeCode(cod);
            case Dist:
                return this.dist.existeCode(cod);
            case Reps:
                return this.reps.existeCode(cod);
            case Pesos:
                return this.pesos.existeCode(cod);
            default:
                return false;
        }

    }

    public Estado clone() {
        return new Estado(this);
    }

}
