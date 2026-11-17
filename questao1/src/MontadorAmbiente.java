import java.util.ArrayList;
import java.util.List;


public class MontadorAmbiente {
    private static final int HORAS_MES = 730;
    private final FabricaNuvem fabrica;

    public MontadorAmbiente(FabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    
    public Ambiente provisionar(SolicitacaoAmbiente s) {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstancia();
        HistoricoAuditoria historico = HistoricoAuditoria.getInstancia();

        double custo = s.getQtdMaquinas() * fabrica.custoHoraMaquina() * HORAS_MES
                + s.getGbArmazenamento() * fabrica.custoGbArmazenamento()
                + fabrica.custoMensalFila();

        if (custo > config.getOrcamentoMaximo()) {
            String motivo = "RECUSADO - custo estimado " + Formato.moeda(custo)
                    + " ultrapassa o orçamento de " + Formato.moeda(config.getOrcamentoMaximo());
            historico.registrar(s.getNome(), fabrica.getNome(), motivo);
            System.out.println("\n[RECUSADO] " + s.getNome() + " (" + fabrica.getNome() + "): " + motivo);
            return null;
        }

        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < s.getQtdMaquinas(); i++) {
            maquinas.add(fabrica.criarMaquina());
        }
        ArmazenamentoObjetos armazenamento = fabrica.criarArmazenamento(s.getGbArmazenamento());
        FilaMensagens fila = fabrica.criarFila();

        Ambiente ambiente = new Ambiente(s.getNome(), fabrica.getNome(), config.getRegiaoPadrao(),
                maquinas, armazenamento, fila, custo);

        System.out.println(ambiente.resumo());
        historico.registrar(s.getNome(), fabrica.getNome(), "ACEITO");
        return ambiente;
    }
}
