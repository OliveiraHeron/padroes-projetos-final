import java.util.ArrayList;
import java.util.List;


public class HistoricoAuditoria {
    private static final HistoricoAuditoria INSTANCIA = new HistoricoAuditoria();
    private final List<RegistroAuditoria> registros = new ArrayList<>();

    private HistoricoAuditoria() { }

    public static HistoricoAuditoria getInstancia() { return INSTANCIA; }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        registros.add(new RegistroAuditoria(ambiente, provedor, resultado));
    }

    public synchronized void imprimir() {
        System.out.println("\n===== HISTÓRICO DE AUDITORIA (" + registros.size() + " registros) =====");
        for (RegistroAuditoria r : registros) {
            System.out.println(r);
        }
    }
}
