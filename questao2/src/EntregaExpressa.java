public class EntregaExpressa extends ServicoAdicional {
    public EntregaExpressa(Compra compra) { super(compra); }
    protected String getNomeServico() { return "Entrega expressa"; }
    protected double getCustoServico() { return 450.00; }
}
