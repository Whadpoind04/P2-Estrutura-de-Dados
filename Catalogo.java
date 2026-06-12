
public class Catalogo {

    private NossoHash<String, Livro> hash;

    public Catalogo() {
        hash = new NossoHash<>();
    }


    public void cadastrar(Livro livro) {
        hash.put(livro.getIsbn(), livro);
        System.out.println("[Catálogo] Livro cadastrado: " + livro.getTitulo() +
                           " (ISBN: " + livro.getIsbn() + ")");
    }

 
    public Livro buscar(String isbn) {
        return hash.get(isbn);
    }


    public boolean existe(String isbn) {
        return hash.containsKey(isbn);
    }


    public void exibirCatalogo() {
        System.out.println("\n========== CATÁLOGO ==========");
        hash.exibeMap();
    }
}
