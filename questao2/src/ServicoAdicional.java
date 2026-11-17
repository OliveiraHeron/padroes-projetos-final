
public abstract class ServicoAdicional implements Compra {
    private final Compra compra;

    protected ServicoAdicional(Compra compra) { this.compra = compra; }

    protected abstract String getNomeServico();
    protected abstract double getCustoServico();

    public String getDescricao() {
        return compra.getDescricao() + "\n  + " + getNomeServico() + ": " + Formato.moeda(getCustoServico());
    }
    public double getCusto() { return compra.getCusto() + getCustoServico(); }
    public double getValorVenda() { return compra.getValorVenda(); }
}
