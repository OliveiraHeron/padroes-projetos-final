public class ComissaoEletronicos implements RegraComissao {
    public String getDescricao() { return "Eletrônicos (12% do valor, mínimo de R$ 50,00)"; }
    public double calcular(double valorVenda) { return Math.max(valorVenda * 0.12, 50.00); }
}
