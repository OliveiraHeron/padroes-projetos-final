public class ComissaoVeiculos implements RegraComissao {
    public String getDescricao() { return "Veículos (8% do valor, limite de R$ 5.000,00)"; }
    public double calcular(double valorVenda) { return Math.min(valorVenda * 0.08, 5000.00); }
}
