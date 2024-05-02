import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Estado implements Serializable {
    private Utilizadores profissionais;
    private Utilizadores amadores;
    private Utilizadores pratocasionais;

    // private Atividades distalt;

    // private Atividades dist;

    // private Atividades reps;

    // private Atividades pesos;
    private Atividades atividades;

    public Estado() {
        this.profissionais = new Utilizadores();
        this.amadores = new Utilizadores();
        this.pratocasionais = new Utilizadores();
        /*
        this.distalt = new Atividades();
        this.dist = new Atividades();
        this.reps = new Atividades();
        this.pesos = new Atividades();
         */
        this.atividades = new Atividades();
    }

    public Estado(Estado outro) {
        this.profissionais = outro.profissionais;
        this.amadores = outro.amadores;
        this.pratocasionais = outro.pratocasionais;
        /*
        this.distalt = outro.distalt;
        this.dist = outro.dist;
        this.reps = outro.reps;
        this.pesos = outro.pesos;
         */
        this.atividades = outro.atividades;
    }

    public boolean existeEmail(String s) {
        return this.profissionais.existeEmail(s) || this.amadores.existeEmail(s)
                || this.pratocasionais.existeEmail(s);
    }
    public String newCodeUser(String tipoUtilizador) {
        if (tipoUtilizador.equals("Profissional")) return ("P"+this.profissionais.newCodeNumber());
        else if (tipoUtilizador.equals("Amador")) return ("A"+this.amadores.newCodeNumber());
        else return ("PO"+this.pratocasionais.newCodeNumber());
    }

    public String newCodeAt() {
        return ("A"+this.atividades.newCodeNumberAt());
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
        this.atividades.addAtividade(atividade);
    }

    public void updateUser(Utilizador user, String tipoUtilizador) {
        switch (tipoUtilizador) {
            case ("Profissional"):
                this.profissionais.updateUtilizador(user);
            default: return;
        }
    }

    /*
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

     */

    /*
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

         */

    public Estado clone() {
        return new Estado(this);
    }

    public void guardaEstado(String ficheiro) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(ficheiro);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace(); // Or handle the exception appropriately
        }
    }

    public void carregaEstado(String ficheiro) throws IOException, ClassNotFoundException {
        Estado e = carregaEstadoAux(ficheiro);
        this.profissionais = e.profissionais;
        this.amadores = e.amadores;
        this.pratocasionais = e.pratocasionais;
        this.atividades = e.atividades;
    }
    public static Estado carregaEstadoAux(String ficheiro) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(ficheiro);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Estado e = (Estado) ois.readObject();
        ois.close();
        return e;
    }

}
