import java.util.HashMap;
import java.util.Map;


public class SeletorProvedor {
    private static final Map<String, FabricaNuvem> FABRICAS = new HashMap<>();

    static {
        FABRICAS.put("aws", new AwsFabrica());
        FABRICAS.put("azure", new AzureFabrica());
    }

    public static FabricaNuvem obter(String provedor) {
        FabricaNuvem fabrica = FABRICAS.get(provedor.toLowerCase());
        if (fabrica == null) {
            throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
        }
        return fabrica;
    }
}
