import java.util.ArrayList;
import java.util.List;


public class Lote {
    private final String nome;
    private final String categoria;
    private final double precoInicial;
    private final double precoReserva;

    private double lanceAtual;
    private Lance maiorLance;
    private boolean aberto = true;
    private boolean vendido = false;

    private final List<Lance> lances = new ArrayList<>();
    private final List<Interessado> interessados = new ArrayList<>();
    private RegraComissao regraComissao;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva,
                RegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    
    public void acompanhar(Interessado i) {
        if (!interessados.contains(i)) {
            interessados.add(i);
        }
    }

    public void deixarDeAcompanhar(Interessado i) {
        interessados.remove(i);
    }

    private void notificar(Lance lance) {
        for (Interessado i : new ArrayList<>(interessados)) {
            if (i != lance.getLicitante()) { // não avisa quem deu o lance
                i.atualizar(nome, lance);
            }
        }
    }

    
    public boolean darLance(Licitante licitante, double valor) {
        if (!aberto) {
            System.out.println("   Lance de " + licitante.getNome() + " (" + Formato.moeda(valor)
                    + ") RECUSADO: o lote '" + nome + "' está encerrado.");
            return false;
        }
        double minimo = lanceAtual * 1.05;
        if (valor + 0.000001 < minimo) {
            System.out.println("   Lance de " + licitante.getNome() + " (" + Formato.moeda(valor)
                    + ") RECUSADO: precisa ser pelo menos 5% maior que o lance atual de "
                    + Formato.moeda(lanceAtual) + " (mínimo " + Formato.moeda(minimo) + ").");
            return false;
        }
        Lance lance = new Lance(licitante, valor);
        lances.add(lance);
        maiorLance = lance;
        lanceAtual = valor;
        System.out.println("   Lance de " + licitante.getNome() + " (" + Formato.moeda(valor)
                + ") ACEITO no lote '" + nome + "'.");
        notificar(lance);
        return true;
    }

  
    public boolean encerrar() {
        if (aberto) {
            aberto = false;
            vendido = maiorLance != null && maiorLance.getValor() >= precoReserva;
        }
        return vendido;
    }

    
    public void setRegraComissao(RegraComissao regra) { this.regraComissao = regra; }
    public RegraComissao getRegraComissao() { return regraComissao; }

    public double calcularComissao() {
        if (!vendido) {
            throw new IllegalStateException("Lote não vendido não gera comissão.");
        }
        return regraComissao.calcular(getValorVenda());
    }

    
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPrecoInicial() { return precoInicial; }
    public double getPrecoReserva() { return precoReserva; }
    public double getLanceAtual() { return lanceAtual; }
    public Lance getMaiorLance() { return maiorLance; }
    public boolean isVendido() { return vendido; }
    public double getValorVenda() { return vendido ? maiorLance.getValor() : 0; }
}
