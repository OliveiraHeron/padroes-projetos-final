import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfiguracaoSistema {
    private static final ConfiguracaoSistema INSTANCIA = new ConfiguracaoSistema();

    private final String regiaoPadrao;
    private final double orcamentoMaximo;

    private ConfiguracaoSistema() {
        Properties p = new Properties();
        String[] caminhos = {"config.properties", "questao1/config.properties"};
        boolean lido = false;
        for (String caminho : caminhos) {
            try (FileInputStream in = new FileInputStream(caminho)) {
                p.load(in);
                lido = true;
                System.out.println("[Configuracao] Arquivo lido (uma única vez): " + caminho);
                break;
            } catch (IOException e) {
                // tenta o próximo caminho
            }
        }
        if (!lido) {
            System.out.println("[Configuracao] config.properties não encontrado; usando valores padrão.");
        }
        this.regiaoPadrao = p.getProperty("regiao.padrao", "us-east-1");
        this.orcamentoMaximo = Double.parseDouble(p.getProperty("orcamento.maximo", "1000.00"));
    }

    public static ConfiguracaoSistema getInstancia() { return INSTANCIA; }
    public String getRegiaoPadrao() { return regiaoPadrao; }
    public double getOrcamentoMaximo() { return orcamentoMaximo; }
}
