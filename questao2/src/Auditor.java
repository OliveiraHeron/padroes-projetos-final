import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Auditor implements Interessado {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final List<String> registros = new ArrayList<>();

    public void atualizar(String nomeLote, Lance lance) {
        String r = LocalDateTime.now().format(FMT) + " | lote: " + nomeLote
                + " | " + lance.getLicitante().getNome() + " | " + Formato.moeda(lance.getValor());
        registros.add(r);
        System.out.println("   [AUDITOR] registrado: " + r);
    }

    public void imprimirRegistros() {
        System.out.println("\n===== REGISTROS DO AUDITOR (" + registros.size() + ") =====");
        for (String r : registros) {
            System.out.println(r);
        }
    }
}
