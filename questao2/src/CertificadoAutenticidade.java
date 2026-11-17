public class CertificadoAutenticidade extends ServicoAdicional {
    public CertificadoAutenticidade(Compra compra) { super(compra); }
    protected String getNomeServico() { return "Certificado de autenticidade"; }
    protected double getCustoServico() { return 300.00; }
}
