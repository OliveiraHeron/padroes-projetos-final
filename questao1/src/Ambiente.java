import java.util.List;

public class Ambiente {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final ArmazenamentoObjetos armazenamento;
    private final FilaMensagens fila;
    private final double custoMensal;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    ArmazenamentoObjetos armazenamento, FilaMensagens fila, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public String resumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Ambiente provisionado ---\n");
        sb.append("Ambiente: ").append(nome).append("\n");
        sb.append("Provedor: ").append(provedor).append("\n");
        sb.append("Região: ").append(regiao).append("\n");
        for (MaquinaVirtual m : maquinas) {
            sb.append("  Máquina virtual: ").append(m.getId()).append("\n");
        }
        sb.append("  Armazenamento: ").append(armazenamento.getId())
          .append(" (").append(armazenamento.getGb()).append(" GB)\n");
        sb.append("  Fila: ").append(fila.getId()).append("\n");
        sb.append("Custo mensal estimado: ").append(Formato.moeda(custoMensal));
        return sb.toString();
    }
}
