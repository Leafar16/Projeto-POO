import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TrazAqui implements Serializable {
    private Utilizador utilizadorLoggedIn;
    private Atividade atividadeAdicionar;
    private Estado estado;

    public TrazAqui() {
        this.estado = new Estado();
        this.utilizadorLoggedIn = null;
        this.atividadeAdicionar = null;
    }

    public boolean login(String codigo) {
        Utilizador utilizador = this.estado.getUtilizadorFromCredentials(codigo);
        if (utilizador != null) {
            this.utilizadorLoggedIn = utilizador;
            return true;
        } else return false;
    }

    public String getCod(){
        return this.utilizadorLoggedIn.getCodigo();
    }

    public boolean freeEmail(String email){
        return this.estado.freeEmail(email);
    }

    public void registoUser(Utilizador utilizador) {
        this.estado.addUtilizador(utilizador);
        this.utilizadorLoggedIn = utilizador.clone();
    }

    public void registoAtividade(Atividade atividade) {
        this.estado.addAtividade(atividade);
        // this.atividadeAdicionar = atividade.clone();
    }

    public String getCodLoggedIn() {
        return this.utilizadorLoggedIn.getCodigo();
    }

    public TipoUtilizador getTipoConta() {
        if (this.utilizadorLoggedIn instanceof Profissional) return TipoUtilizador.Profissional;
        else if (this.utilizadorLoggedIn instanceof Amador) return TipoUtilizador.Amador;
        else return TipoUtilizador.PratOcasional;
    }

    public TipoAtividade getTipoAtividade() {
        if (this.atividadeAdicionar instanceof DistAlt) return TipoAtividade.DistAlt;
        else if (this.atividadeAdicionar instanceof Dist) return TipoAtividade.Dist;
        else if (this.atividadeAdicionar instanceof Reps) return TipoAtividade.Reps;
        else return TipoAtividade.Pesos;
    }

    public Map<String,String> AtInfo (TipoAtividade ta) {
        return new HashMap<>(this.estado.showAtividades(ta));
    }

    public Atividade AtAdd (String codigo, TipoAtividade ta) {
        return new Atividade(this.estado.getAtividadefromCode(codigo,ta));
    }

    public Atividade addAtividadePro(Atividade atividade, TipoAtividade ta) {
        Profissional profissional = (Profissional) utilizadorLoggedIn;
        Atividade a;
        if (profissional != null) {
            a = profissional.addAtividade(atividade, ta);
        } else {
            return null;
        }

        return a;
    }


    public boolean existeEmail(String s) {
        return this.estado.existeEmail(s);
    }

    public boolean isValidCodeAt(String at, TipoAtividade tipo) {
        return this.estado.atCodeValid(at, tipo);
    }

    public String getNewCodeUser(TipoUtilizador t) {
        return estado.newCodeUser(t);
    }

    public String getNewCodeAt(TipoAtividade at) {
        return estado.newCodeAt(at);
    }

}
