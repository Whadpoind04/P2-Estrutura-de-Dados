
public class BibliotecaDigital {

    private final Catalogo          catalogo;
    private final ListaDupla acervo;
    private final GestorEmprestimos gestor;

    public BibliotecaDigital() {
        catalogo = new Catalogo();
        acervo   = new ListaDupla();
        gestor   = new GestorEmprestimos(catalogo);
    }


    public void cadastrarLivro(Livro livro) {
        if (catalogo.existe(livro.getIsbn())) {
            System.out.println("  ✗ ISBN já cadastrado: " + livro.getIsbn());
            return;
        }
        catalogo.cadastrar(livro);
        acervo.insereFim(livro);
        System.out.println("  ✓ Livro cadastrado com sucesso.");
    }


    public Livro buscarPorIsbn(String isbn) {
        return catalogo.buscar(isbn);
    }


    public boolean existeIsbn(String isbn) {
        return catalogo.existe(isbn);
    }


    public void listarInicioParaFim() {
        System.out.println();
        acervo.listarDoInicio();
    }

  
    public void listarFimParaInicio() {
        System.out.println();
        acervo.listarDoFim();
    }

 

    public void solicitarEmprestimo(String isbn, Usuario usuario) {
        gestor.solicitarEmprestimo(isbn, usuario);
    }


    public void devolverLivro(String isbn) {
        gestor.devolverLivro(isbn);
    }

 
    public void listarFilaDeEspera(String isbn) {
        gestor.listarFilaDeEspera(isbn);
    }
}
