
public class Fatura {
    public static void imprimir(Compra compra) {
        System.out.println("\n===== FATURA DO COMPRADOR =====");
        System.out.println(compra.getDescricao());
        System.out.println("TOTAL A PAGAR: " + Formato.moeda(compra.getCusto()));
    }
}
