public class AcertoVendedor {
    public static void imprimir(Lote lote) {
        double venda = lote.getValorVenda();
        double comissao = lote.calcularComissao();
        System.out.println("\n===== ACERTO DO VENDEDOR - " + lote.getNome() + " =====");
        System.out.println("Valor de venda: " + Formato.moeda(venda));
        System.out.println("Comissão (" + lote.getRegraComissao().getDescricao() + "): " + Formato.moeda(comissao));
        System.out.println("Valor líquido a repassar: " + Formato.moeda(venda - comissao));
    }
}
