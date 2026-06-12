
public class TesteGestorEmprestimos {

    public static void main(String[] args) {
        System.out.println("PREPARAÇÃO Catálogo e Gestor");

        Catalogo catalogo = new Catalogo();

        
        Livro livro = new Livro(
                "978-85-430-0067-8",
                "Estruturas de Dados em Java",
                "Vinicus de Assis",
                2009);

        
        Livro livro2 = new Livro(
                "978-0-13-468599-1",
                "Clean Code",
                "Luis Eduardo",
                2005);

        catalogo.cadastrar(livro);
        catalogo.cadastrar(livro2);

        GestorEmprestimos gestor = new GestorEmprestimos(catalogo);

        // Usuários
        Usuario alice   = new Usuario(1001, "Alice",   "alice@email.com");
        Usuario bruno   = new Usuario(1002, "Bruno",   "bruno@email.com");
        Usuario carla   = new Usuario(1003, "Carla",   "carla@email.com");
        Usuario daniel  = new Usuario(1004, "Daniel",  "daniel@email.com");

        System.out.println("ISBN em teste: " + livro.getIsbn());
        System.out.println("Situação inicial: " + (livro.isDisponivel() ? "DISPONÍVEL" : "EMPRESTADO"));


        System.out.println("\n--- CENÁRIO 1 Empréstimo de livro disponível ---");
        System.out.println("Passo 1: Alice solicita empréstimo (livro DISPONÍVEL)");
        
        gestor.solicitarEmprestimo(livro.getIsbn(), alice);
        System.out.println("Situação atual: " + (livro.isDisponivel() ? "DISPONÍVEL" : "EMPRESTADO"));


        System.out.println("\n--- CENÁRIO 2  Livro indisponível -> fila de espera ---");

        System.out.println("Passo 2: Bruno solicita o mesmo livro");
        gestor.solicitarEmprestimo(livro.getIsbn(), bruno);

        System.out.println("Passo 3: Carla solicita o mesmo livro");
        gestor.solicitarEmprestimo(livro.getIsbn(), carla);

        System.out.println("Passo 4: Daniel solicita o mesmo livro");
        gestor.solicitarEmprestimo(livro.getIsbn(), daniel);

        System.out.println("Passo 5: Exibindo fila de espera atual (Esperado: Bruno -> Carla -> Daniel):");
        gestor.listarFilaDeEspera(livro.getIsbn());


        System.out.println("\n--- CENÁRIO 3 Devolução com atendimento automático ---");
        System.out.println("Passo 6: Alice devolve o livro (Bruno deve receber automaticamente)");
        gestor.devolverLivro(livro.getIsbn());
        System.out.println("Situação atual: " + (livro.isDisponivel() ? "DISPONÍVEL" : "EMPRESTADO"));

        System.out.println("Passo 7: Fila após a 1ª devolução (Esperado: Carla -> Daniel):");
        gestor.listarFilaDeEspera(livro.getIsbn());

        System.out.println("Passo 8: Bruno devolve o livro (Carla deve receber automaticamente)");
        gestor.devolverLivro(livro.getIsbn());

        System.out.println("Passo 9: Fila após a 2ª devolução (Esperado: Daniel):");
        gestor.listarFilaDeEspera(livro.getIsbn());

        System.out.println("Passo 10: Carla devolve o livro (Daniel deve receber automaticamente)");
        gestor.devolverLivro(livro.getIsbn());

        System.out.println("Passo 11: Fila após a 3ª devolução (Esperado: VAZIA):");
        gestor.listarFilaDeEspera(livro.getIsbn());


        System.out.println("\n--- CENÁRIO 4  Devolução com fila já vazia ---");
        System.out.println("Passo 12: Daniel devolve o livro");
        gestor.devolverLivro(livro.getIsbn());
        System.out.println("Situação atual: " + (livro.isDisponivel() ? "DISPONÍVEL" : "EMPRESTADO"));

        System.out.println("Passo 13: Confirma fila vazia:");
        gestor.listarFilaDeEspera(livro.getIsbn());

        System.out.println("Passo 14: Confirmação final de disponibilidade:");
        if (livro.isDisponivel()) {
            System.out.println("Sucesso: Livro DISPONÍVEL para novo empréstimo.");
        } else {
            System.out.println("Erro: Livro deveria estar disponível.");
        }

 
    }
}