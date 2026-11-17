
public class VendaLote implements Compra {
    private final String nomeLote;
    private final String comprador;
    private final double valorVenda;

    public VendaLote(String nomeLote, String comprador, double valorVenda) {
        this.nomeLote = nomeLote;
        this.comprador = comprador;
        this.valorVenda = valorVenda;
    }
    public String getDescricao() {
        return "Lote: " + nomeLote + " (comprador: " + comprador + ")\n"
                + "  Valor de venda: " + Formato.moeda(valorVenda);
    }
    public double getCusto() { return valorVenda; }
    public double getValorVenda() { return valorVenda; }
}
