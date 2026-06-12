import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GestorEmprestimos {

    private Catalogo catalogo;


    private HashMap<String, Queue<Usuario>> filasEspera;

    public GestorEmprestimos(Catalogo catalogo) {
        this.catalogo = catalogo;
        this.filasEspera = new HashMap<>();
    }


    public void solicitarEmprestimo(String isbn, Usuario usuario) {

        Livro livro = catalogo.buscar(isbn);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("Empréstimo realizado para " + usuario.getNome());
            return;
        }


        Queue<Usuario> fila = filasEspera.get(isbn);

        if (fila == null) {
            fila = new LinkedList<>();
            filasEspera.put(isbn, fila);
        }

        fila.add(usuario);

        System.out.println("Livro indisponível. Usuário adicionado à fila de espera.");
    }


    public void devolverLivro(String isbn) {

        Livro livro = catalogo.buscar(isbn);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        Queue<Usuario> fila = filasEspera.get(isbn);

  
        if (fila == null || fila.isEmpty()) {
            livro.setDisponivel(true);
            System.out.println("Livro devolvido e disponível.");
            return;
        }

 
        Usuario proximo = fila.poll();

        livro.setDisponivel(false);

        System.out.println("Livro repassado automaticamente para: "
                + proximo.getNome());
    }


    public void listarFilaDeEspera(String isbn) {

        Queue<Usuario> fila = filasEspera.get(isbn);

        if (fila == null || fila.isEmpty()) {
            System.out.println("Sem fila de espera para este livro.");
            return;
        }

        System.out.println("Fila de espera do ISBN " + isbn + ":");

        for (Usuario u : fila) {
            System.out.println(" - " + u.getNome());
        }
    }
}