public class Usuario {
    private int matricula;
    private String nome;
    private String email;

    public Usuario(int matricula, String nome, String emial){
        this.matricula = matricula;
        this.nome = nome;
        this.email=email;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Matrícula: " + matricula +
               " | Nome: " + nome +
               " | E-mail: " + email;
    }

 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Usuario other = (Usuario) obj;
        return matricula == other.matricula;
    }
}
