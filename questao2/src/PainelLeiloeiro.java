import java.util.HashMap;
import java.util.Map;


public class PainelLeiloeiro implements Interessado {
    private final Map<String, Double> maiorLance = new HashMap<>();
    private final Map<String, Integer> totalLances = new HashMap<>();

    public void atualizar(String nomeLote, Lance lance) {
        Double atual = maiorLance.get(nomeLote);
        if (atual == null || lance.getValor() > atual) {
            maiorLance.put(nomeLote, lance.getValor());
        }
        totalLances.merge(nomeLote, 1, Integer::sum);
        System.out.println("   [PAINEL] " + nomeLote + " | maior lance: "
                + Formato.moeda(maiorLance.get(nomeLote))
                + " | total de lances: " + totalLances.get(nomeLote));
    }
}
