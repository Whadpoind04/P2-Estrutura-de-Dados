public class ListaDupla {

    private NoDuplo primeiro;
    private NoDuplo ultimo;
    private int tamanho;

    public ListaDupla() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void insereInicio(Livro livro) {

        NoDuplo novo = new NoDuplo(livro);

        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
            primeiro = novo;
        }

        tamanho++;
    }

    public void insereFim(Livro livro) {

        NoDuplo novo = new NoDuplo(livro);

        if (ultimo == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            ultimo = novo;
        }

        tamanho++;
    }

    public Livro removePrimeiro() {

        if (primeiro == null) {
            return null;
        }

        Livro removido = primeiro.getLivro();

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            primeiro = primeiro.getProximo();
            primeiro.setAnterior(null);
        }

        tamanho--;
        return removido;
    }

    public Livro removeUltimo() {

        if (ultimo == null) {
            return null;
        }

        Livro removido = ultimo.getLivro();

        if (primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            ultimo = ultimo.getAnterior();
            ultimo.setProximo(null);
        }

        tamanho--;
        return removido;
    }

    public Livro buscarPorIsbn(String isbn) {

        NoDuplo atual = primeiro;

        while (atual != null) {

            if (atual.getLivro().getIsbn().equals(isbn)) {
                return atual.getLivro();
            }

            atual = atual.getProximo();
        }

        return null;
    }

    public void listarDoInicio() {

        NoDuplo atual = primeiro;

        while (atual != null) {
            System.out.println(atual.getLivro());
            atual = atual.getProximo();
        }
    }

    public void listarDoFim() {

        NoDuplo atual = ultimo;

        while (atual != null) {
            System.out.println(atual.getLivro());
            atual = atual.getAnterior();
        }
    }

    public int tamanho() {
        return tamanho;
    }
}