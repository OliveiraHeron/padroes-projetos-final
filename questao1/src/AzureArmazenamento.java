public class AzureArmazenamento implements ArmazenamentoObjetos {
    public static final double CUSTO_POR_GB = 0.02;
    private final String id;
    private final int gb;
    public AzureArmazenamento(String id, int gb) { this.id = id; this.gb = gb; }
    public String getId() { return id; }
    public int getGb() { return gb; }
    public double getCustoPorGb() { return CUSTO_POR_GB; }
}
