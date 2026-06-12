import java.util.Scanner;

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
            System.out.println("ISBN já cadastrado: " + livro.getIsbn());
            return;
        }
        catalogo.cadastrar(livro);
        acervo.insereFim(livro);
        System.out.println("Livro cadastrado com sucesso.");
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

    // ── Menu de Console Principal ─────────────────────────────────────
    public static void main(String[] args) {
        BibliotecaDigital biblioteca = new BibliotecaDigital();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 8) {
            System.out.println("\n--- MENU BIBLIOTECA DIGITAL ---");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Buscar livro por ISBN");
            System.out.println("3. Listar acervo do início ao fim");
            System.out.println("4. Listar acervo do fim ao início");
            System.out.println("5. Solicitar empréstimo");
            System.out.println("6. Devolver livro");
            System.out.println("7. Ver fila de espera de um livro");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número de 1 a 8.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = Integer.parseInt(scanner.nextLine());

                    Livro novoLivro = new Livro(isbn, titulo, autor, ano);
                    biblioteca.cadastrarLivro(novoLivro);
                    break;

                case 2:
                    System.out.print("Digite o ISBN para busca: ");
                    String isbnBusca = scanner.nextLine();
                    Livro livroEncontrado = biblioteca.buscarPorIsbn(isbnBusca);
                    if (livroEncontrado != null) {
                        System.out.println("Livro encontrado: " + livroEncontrado.getTitulo() + " - " + livroEncontrado.getAutor());
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("--- Acervo (Início ao Fim) ---");
                    biblioteca.listarInicioParaFim();
                    break;

                case 4:
                    System.out.println("--- Acervo (Fim ao Início) ---");
                    biblioteca.listarFimParaInicio();
                    break;

                case 5:
                    System.out.print("Digite o ISBN do livro: ");
                    String isbnEmp = scanner.nextLine();
                    
                    System.out.print("ID do Usuário: ");
                    int idUsuario = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome do Usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Email do Usuário: ");
                    String emailUsuario = scanner.nextLine();

                    Usuario usuario = new Usuario(idUsuario, nomeUsuario, emailUsuario);
                    biblioteca.solicitarEmprestimo(isbnEmp, usuario);
                    break;

                case 6:
                    System.out.print("Digite o ISBN do livro para devolução: ");
                    String isbnDev = scanner.nextLine();
                    biblioteca.devolverLivro(isbnDev);
                    break;

                case 7:
                    System.out.print("Digite o ISBN do livro para ver a fila: ");
                    String isbnFila = scanner.nextLine();
                    System.out.println("--- Fila de Espera ---");
                    biblioteca.listarFilaDeEspera(isbnFila);
                    break;

                case 8:
                    System.out.println("Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }
}