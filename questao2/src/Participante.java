
public class Participante implements Licitante, Interessado {
    private final String nome;

    public Participante(String nome) { this.nome = nome; }

    public String getNome() { return nome; }

    public void atualizar(String nomeLote, Lance lance) {
        System.out.println("   [" + nome + "] Novo lance no lote '" + nomeLote + "': "
                + Formato.moeda(lance.getValor()) + " (de " + lance.getLicitante().getNome() + ")");
    }
}
