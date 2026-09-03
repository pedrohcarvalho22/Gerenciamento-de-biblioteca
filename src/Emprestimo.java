package src;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private boolean emprestado;

   public Emprestimo (Usuario usuarioEmprestimo, Livro livroEmprestimo, boolean emprestadoEmprestimo){
    usuario = usuarioEmprestimo;
    livro = livroEmprestimo;
    emprestado = emprestadoEmprestimo;
   } 

   //Getters
   public Usuario getUsuario(){
    return usuario;
   }

   public Livro getLivro(){
    return livro;
   }

   public boolean getEmprestado(){
    return emprestado;
   }

    //Metodos

    public void devolver(){
        this.emprestado=false;
   }

}
