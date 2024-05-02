import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrazAqui implements Serializable {
    private Utilizador utilizadorLoggedIn;
    private Estado estado;

    public TrazAqui() {
        this.estado = new Estado();
        this.utilizadorLoggedIn = null;
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
    }

    public String getCodLoggedIn() {
        return this.utilizadorLoggedIn.getCodigo();
    }

    public double getFCUser() {
        return this.utilizadorLoggedIn.getFreqCardiaca();
    }

    // alterar utilizadorLoggedIn para user
    public String getTipoConta(Utilizador user) {
        if (this.utilizadorLoggedIn instanceof Profissional) return "Profissional";
        else if (this.utilizadorLoggedIn instanceof Amador) return "Amador";
        else return "PratOcasional";
    }
    /*
    public Map<String,String> AtInfo (TipoAtividade ta) {
        return new HashMap<>(this.estado.showAtividades(ta));
    }

    public Atividade AtAdd (String codigo, TipoAtividade ta) {
        return new Atividade(this.estado.getAtividadefromCode(codigo,ta));
    }
     */
    public Atividade addAtividadeUtilizador(Atividade atividade) {
        Utilizador user = utilizadorLoggedIn;
        Atividade add = atividade;
        // modifica o parâmetro das calorias na atividade de acordo com o FC do user
        add.setCalorias(add.calculaCalorias(user.getFactorCalorias()));

        if (user != null) {
                user.updateFreqCardiaca(add.getFreqCardiaca());
                user.addAtividade(add);
                this.estado.updateUser(user, getTipoConta(user));

        } else {
            return null;
        }

        return add;
    }


    public boolean existeEmail(String s) {
        return this.estado.existeEmail(s);
    }

    /* public boolean isValidCodeAt(String at, TipoAtividade tipo) {
        return this.estado.atCodeValid(at, tipo);
    }

     */

    public String getUserAtividades() {
        Utilizador user = utilizadorLoggedIn;
        String ats;
        if (user != null) {
            ats = user.getAtividades().toString();
        } else {
            return null;
        }

        return ats;
    }

    public String getNewCodeUser(String t) {
        return estado.newCodeUser(t);
    }

    public String getNewCodeAt() {
        return estado.newCodeAt();
    }

    public void guardaEstadoObj(String ficheiro) throws IOException {
        this.estado.guardaEstado(ficheiro);
    }

    public void carregaEstadoObj(String ficheiro) throws IOException, ClassNotFoundException {
        this.estado.carregaEstado(ficheiro);
    }

}
