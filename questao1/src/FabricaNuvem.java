
public interface FabricaNuvem {
    String getNome();
    MaquinaVirtual criarMaquina();
    ArmazenamentoObjetos criarArmazenamento(int gb);
    FilaMensagens criarFila();

    double custoHoraMaquina();
    double custoGbArmazenamento();
    double custoMensalFila();
}
