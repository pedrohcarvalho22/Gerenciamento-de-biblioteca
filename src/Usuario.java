package src;

public class Usuario {
    private String nome;
    private int id;
    private String email;

    //Construtor
    public Usuario(String nomeUsuario, int idUsuario, String emailUsuario){
        nome = nomeUsuario;
        id = idUsuario;
        email = emailUsuario;
    }

    //Setters

    public void setNome(String novonome){
        this.nome= novonome;
    }

    public void setId(int novoid){
        if (novoid>=0){
            this.id= novoid;
        }
    }

    public void setEmail(String novoemail){
        this.email= novoemail;
    }

    //Getters

    public String getNome(){
        return this.nome;
    }

    public int getId(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }

}
