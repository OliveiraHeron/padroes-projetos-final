public class ComissaoArte implements RegraComissao {
    public String getDescricao() { return "Arte (20% do valor)"; }
    public double calcular(double valorVenda) { return valorVenda * 0.20; }
}
