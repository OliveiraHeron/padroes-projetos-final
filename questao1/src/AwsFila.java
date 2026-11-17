public class AwsFila implements FilaMensagens {
    public static final double CUSTO_MENSAL = 0.40;
    private final String id;
    public AwsFila(String id) { this.id = id; }
    public String getId() { return id; }
    public double getCustoMensal() { return CUSTO_MENSAL; }
}
