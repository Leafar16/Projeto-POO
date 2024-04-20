import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Atividades implements Serializable {
    private Map<String, Atividade> mapAtividades;

    public Atividades() {
        this.mapAtividades = new TreeMap<>();
    }

    public Atividades(Map<String, Atividade> map) {
        this.setAtividades(map);
    }

    public Atividades(Atividades atividades) {
        this.mapAtividades = atividades.getAtividades();
    }

    public Map<String, Atividade> getAtividades() {
        return this.mapAtividades.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, TreeMap::new));
    }

    public void addAtividade(Atividade atividade) {
        this.mapAtividades.put(atividade.getCodigo(), atividade.clone());
    }

    public void setAtividades(Map<String, Atividade> map) {
        this.mapAtividades = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().clone(), (a, b) -> a, TreeMap::new));
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Atividades: ").append(mapAtividades.toString()).append('\n');
        return sb.toString();
    }

    public Atividades clone() {
        return new Atividades(this);
    }

    public Atividade getAtividadeByCodigo(String codigo) {
        if (this.mapAtividades.containsKey(codigo))
            return this.mapAtividades.get(codigo).clone();
        return null;
    }

    public boolean existeCode(String codigo) {
        return this.mapAtividades.containsKey(codigo);
    }

    public int newCodeNumberAt() {
        return this.mapAtividades.size() + 1;
    }

    /*
    public int newCodeNumberAt(){
        List<Integer> l = this.mapAtividades.keySet().stream()
                .map(a->Integer.valueOf(a.substring(1)))
                .sorted()
                .collect(Collectors.toList());
        if (l.isEmpty()) return 1;
        Integer i = l.get(0);
        int aux = i+1;
        while (l.contains(aux)) aux++;
        return aux;
    }


     */
}
