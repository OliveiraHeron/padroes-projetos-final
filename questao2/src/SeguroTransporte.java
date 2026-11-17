public class SeguroTransporte extends ServicoAdicional {
    public SeguroTransporte(Compra compra) { super(compra); }
    protected String getNomeServico() { return "Seguro de transporte (1,5% do valor)"; }
    protected double getCustoServico() { return getValorVenda() * 0.015; }
}
