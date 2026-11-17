public class AzureMaquinaVirtual implements MaquinaVirtual {
    public static final double CUSTO_POR_HORA = 0.12;
    private final String id;
    public AzureMaquinaVirtual(String id) { this.id = id; }
    public String getId() { return id; }
    public double getCustoPorHora() { return CUSTO_POR_HORA; }
}
