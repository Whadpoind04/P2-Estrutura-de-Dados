public class TesteListaDupla {

    public static void main(String[] args) {

        ListaDupla acervo = new ListaDupla();

        Livro l1 = new Livro(
                "978-85-430-0067-8",
                "Estruturas de Dados",
                "Goodrich",
                2013);

        Livro l2 = new Livro(
                "978-85-7522-199-5",
                "Java Como Programar",
                "Deitel",
                2017);

        Livro l3 = new Livro(
                "978-85-333-0227-3",
                "Algoritmos",
                "Cormen",
                2009);

        Livro l4 = new Livro(
                "978-85-1111-2222-3",
                "Clean Code",
                "Robert Martin",
                2008);

   
        System.out.println("=== INSERINDO LIVROS ===");
        acervo.insereInicio(l1);
        acervo.insereFim(l2);
        acervo.insereFim(l3);
        acervo.insereInicio(l4);

     
        System.out.println("\n=== LISTAGEM DO INÍCIO PARA O FIM ===");
        acervo.listarDoInicio();

  
        System.out.println("\n=== LISTAGEM DO FIM PARA O INÍCIO ===");
        acervo.listarDoFim();

      
        System.out.println("\nQuantidade de livros: " + acervo.tamanho());

   
        System.out.println("\n=== BUSCA POR ISBN ===");
        Livro encontrado = acervo.buscarPorIsbn("978-85-7522-199-5");

        if (encontrado != null) {
            System.out.println("Livro encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("Livro não encontrado.");
        }

     
        System.out.println("\n=== BUSCA POR ISBN INEXISTENTE===");
        encontrado = acervo.buscarPorIsbn("0000");

        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("ISBN 0000 não encontrado.");
        }

     
        System.out.println("\n=== REMOVENDO PRIMEIRO ===");
        Livro removido = acervo.removePrimeiro();
        System.out.println("Removido: " + removido);


        System.out.println("\n=== REMOVENDO ÚLTIMO ===");
        removido = acervo.removeUltimo();
        System.out.println("Removido: " + removido);

     
        System.out.println("\n=== LISTA APÓS REMOÇÕES ===");
        acervo.listarDoInicio();

        System.out.println("\nQuantidade final de livros: " + acervo.tamanho());
    }
}