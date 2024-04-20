import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Utilizadores implements Serializable {
    private Map<String,Utilizador> mapUtilizadores;

    public Utilizadores() {
        this.mapUtilizadores = new TreeMap<>();
    }

    public Utilizadores(Map<String, Utilizador> map) {
        this.setUtilizadores(map);
    }

    public Utilizadores(Utilizadores us) {
        this.mapUtilizadores = us.getUtilizadores();
    }

    public Map<String, Utilizador> getUtilizadores() {
        return this.mapUtilizadores.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, TreeMap::new));
    }

    public void addUtilizador (Utilizador user) {
        this.mapUtilizadores.put(user.getCodigo(), user.clone());
    }

    public void setUtilizadores(Map<String, Utilizador> map) {
        this.mapUtilizadores = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone(), (a,b) -> a, TreeMap::new));
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Utilizadores: ").append(mapUtilizadores.toString()).append('\n');
        return sb.toString();
    }

    public Utilizadores clone(){
        return new Utilizadores(this);
    }

    public Utilizador getUtilizadorByEmail(String email){
        Utilizador conta = this.mapUtilizadores.values().stream()
                .reduce(null, (acc, x) -> x.getEmail().equals(email) ? x : acc);
        if(conta != null) return conta.clone();
        else return null;
    }

    public Utilizador getUtilizadorbyCode(String code){
        if (this.mapUtilizadores.containsKey(code))
            return this.mapUtilizadores.get(code).clone();
        return null;
    }

    public boolean existeEmail(String s){
        return this.mapUtilizadores.entrySet().stream().anyMatch(a->s.equals(a.getValue().getEmail()));
    }

    public int newCodeNumber(){
        List<Integer> l = this.mapUtilizadores.keySet().stream()
                .map(a->Integer.valueOf(a.substring(1)))
                .sorted()
                .collect(Collectors.toList());
        if (l.isEmpty()) return 1;
        Integer i = l.get(0);
        int aux = i+1;
        while (l.contains(aux)) aux++;
        return aux;
    }

}
