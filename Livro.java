public class Livro{
    private String isbn;
    private String titulo;
    private String autor;
    private int anoPub;
    private boolean disponivel;

   public Livro(String isbn, String titulo, String autor, int anoPub, boolean disponivel){
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.anoPub = anoPub;
    this.disponivel = true;
   }

   public String getIsbn() {
    return isbn;
   }

   public String getTitulo() {
    return titulo;
   }

   public String getAutor() {
    return autor;
   }

   public int getAnoPub() {
    return anoPub;
   }

   public boolean isDisponivel() {
    return disponivel;
   }

   public void setTitulo(String titulo) {
    this.titulo = titulo;
   }

   public void setAutor(String autor) {
    this.autor = autor;
   }

   public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
   }

   @Override
    public String toString() {
        String status = disponivel ? "DISPONIVEL" : "EMPRESTADO";

        return "[" + isbn + "] " + titulo + " - " + autor + " (" + anoPub + ") [" + status + "]";
    }

    // Método equals() comparando pelo ISBN
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Livro outro = (Livro) obj;
        return isbn.equals(outro.isbn);
    }

}