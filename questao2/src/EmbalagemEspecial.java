public class EmbalagemEspecial extends ServicoAdicional {
    public EmbalagemEspecial(Compra compra) { super(compra); }
    protected String getNomeServico() { return "Embalagem especial"; }
    protected double getCustoServico() { return 180.00; }
}
