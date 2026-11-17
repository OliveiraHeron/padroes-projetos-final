public class ComissaoImoveis implements RegraComissao {
    public String getDescricao() { return "Imóveis (3% do valor + R$ 1.500,00 fixos)"; }
    public double calcular(double valorVenda) { return valorVenda * 0.03 + 1500.00; }
}
