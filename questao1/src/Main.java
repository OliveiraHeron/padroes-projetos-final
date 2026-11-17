import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SolicitacaoAmbiente[] solicitacoes = {
            new SolicitacaoAmbiente("ambiente-web", "Aws", 3, 100),
            new SolicitacaoAmbiente("ambiente-dados", "Aws", 2, 500),
            new SolicitacaoAmbiente("ambiente-api", "Azure", 2, 200),
            new SolicitacaoAmbiente("ambiente-gigante", "Aws", 50, 1000) // estoura o orçamento
        };

    
        List<Thread> threads = new ArrayList<>();
        for (SolicitacaoAmbiente s : solicitacoes) {
            Thread t = new Thread(() -> {
                FabricaNuvem fabrica = SeletorProvedor.obter(s.getProvedor());
                new MontadorAmbiente(fabrica).provisionar(s);
            });
            threads.add(t);
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        HistoricoAuditoria.getInstancia().imprimir();
    }
}
