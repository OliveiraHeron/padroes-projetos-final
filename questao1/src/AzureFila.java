public class AzureFila implements FilaMensagens {
    public static final double CUSTO_MENSAL = 0.50;
    private final String id;
    public AzureFila(String id) { this.id = id; }
    public String getId() { return id; }
    public double getCustoMensal() { return CUSTO_MENSAL; }
}
