import java.util.concurrent.atomic.AtomicInteger;


public class AwsFabrica implements FabricaNuvem {
    private final AtomicInteger seqMaquina = new AtomicInteger();
    private final AtomicInteger seqArmazenamento = new AtomicInteger();
    private final AtomicInteger seqFila = new AtomicInteger();

    public String getNome() { return "Aws"; }
    public MaquinaVirtual criarMaquina() {
        return new AwsMaquinaVirtual("i-" + seqMaquina.incrementAndGet());
    }
    public ArmazenamentoObjetos criarArmazenamento(int gb) {
        return new AwsArmazenamento("s3://" + seqArmazenamento.incrementAndGet(), gb);
    }
    public FilaMensagens criarFila() {
        return new AwsFila("sqs-" + seqFila.incrementAndGet());
    }
    public double custoHoraMaquina() { return AwsMaquinaVirtual.CUSTO_POR_HORA; }
    public double custoGbArmazenamento() { return AwsArmazenamento.CUSTO_POR_GB; }
    public double custoMensalFila() { return AwsFila.CUSTO_MENSAL; }
}
