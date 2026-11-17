/** Observer: qualquer um que queira ser avisado dos lances aceitos de um lote. */
public interface Interessado {
    void atualizar(String nomeLote, Lance lance);
}
