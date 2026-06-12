public class Fila<T> {

    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public Fila() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void enfileira(T info) {

        No<T> novo = new No<>(info);

        if (filaVazia()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }

        tamanho++;
    }

    public T desenfileira() {

        if (filaVazia()) {
            throw new FilaVaziaException("Fila vazia!");
        }

        T info = primeiro.getInfo();

        primeiro = primeiro.getProximo();

        tamanho--;

        if (primeiro == null) {
            ultimo = null;
        }

        return info;
    }

    public T primeiro() {

        if (filaVazia()) {
            throw new FilaVaziaException("Fila vazia!");
        }

        return primeiro.getInfo();
    }

    public boolean filaVazia() {
        return primeiro == null;
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        No<T> atual = primeiro;

        while (atual != null) {
            sb.append("[")
              .append(atual.getInfo())
              .append("]->");

            atual = atual.getProximo();
        }

        sb.append("\\");

        return sb.toString();
    }
}
class FilaVaziaException extends RuntimeException {
        FilaVaziaException(String mensagem) {
            super(mensagem);
        }
    }