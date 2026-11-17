public class Main {
    public static void main(String[] args) {
        Lote quadro = new Lote("Paisagem a Óleo", "Arte", 10000.00, 12000.00, new ComissaoArte());
        Lote notebook = new Lote("Notebook Gamer", "Eletrônicos", 2000.00, 3500.00, new ComissaoEletronicos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        System.out.println("=== Participantes passam a acompanhar os lotes ===");
        for (Interessado i : new Interessado[] {ana, bruno, carla, painel, auditor}) {
            quadro.acompanhar(i);
        }
        for (Interessado i : new Interessado[] {ana, bruno, painel, auditor}) {
            notebook.acompanhar(i);
        }

        System.out.println("\n=== Lances no lote '" + quadro.getNome() + "' ===");
        quadro.darLance(ana, 10600.00);    
        quadro.darLance(bruno, 10700.00);  
        quadro.darLance(bruno, 12000.00);  

        System.out.println("\n=== Carla deixa de acompanhar o lote ===");
        quadro.deixarDeAcompanhar(carla);
        quadro.darLance(ana, 13000.00);    

        System.out.println("\n=== Campanha: troca da regra de comissão do lote de Arte ===");
        System.out.println("   Regra antes: " + quadro.getRegraComissao().getDescricao());
        quadro.setRegraComissao(new ComissaoEletronicos());
        System.out.println("   Regra depois: " + quadro.getRegraComissao().getDescricao());

        System.out.println("\n=== Lances no lote '" + notebook.getNome() + "' ===");
        notebook.darLance(ana, 2200.00);   

        System.out.println("\n=== Encerramento dos lotes ===");
        boolean vendido1 = quadro.encerrar();
        System.out.println("Lote '" + quadro.getNome() + "': " + (vendido1 ? "VENDIDO" : "NÃO VENDIDO"));
        boolean vendido2 = notebook.encerrar();
        System.out.println("Lote '" + notebook.getNome() + "': " + (vendido2 ? "VENDIDO" : "NÃO VENDIDO"));
        System.out.println("Tentativa de lance em lote encerrado:");
        notebook.darLance(bruno, 5000.00); 

        
        Compra compra = new VendaLote(quadro.getNome(),
                quadro.getMaiorLance().getLicitante().getNome(), quadro.getValorVenda());
        compra = new SeguroTransporte(compra);
        compra = new CertificadoAutenticidade(compra);
        compra = new EmbalagemEspecial(compra);
        compra = new EmbalagemEspecial(compra);
        compra = new EntregaExpressa(compra);
        Fatura.imprimir(compra);

        AcertoVendedor.imprimir(quadro);

        auditor.imprimirRegistros();
    }
}
