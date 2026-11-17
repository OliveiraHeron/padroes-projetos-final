import java.util.concurrent.atomic.AtomicInteger;


public class AzureFabrica implements FabricaNuvem {
    private final AtomicInteger seqMaquina = new AtomicInteger();
    private final AtomicInteger seqArmazenamento = new AtomicInteger();
    private final AtomicInteger seqFila = new AtomicInteger();

    public String getNome() { return "Azure"; }
    public MaquinaVirtual criarMaquina() {
        return new AzureMaquinaVirtual("vm-" + seqMaquina.incrementAndGet());
    }
    public ArmazenamentoObjetos criarArmazenamento(int gb) {
        return new AzureArmazenamento("blob://" + seqArmazenamento.incrementAndGet(), gb);
    }
    public FilaMensagens criarFila() {
        return new AzureFila("sb-" + seqFila.incrementAndGet());
    }
    public double custoHoraMaquina() { return AzureMaquinaVirtual.CUSTO_POR_HORA; }
    public double custoGbArmazenamento() { return AzureArmazenamento.CUSTO_POR_GB; }
    public double custoMensalFila() { return AzureFila.CUSTO_MENSAL; }
}
