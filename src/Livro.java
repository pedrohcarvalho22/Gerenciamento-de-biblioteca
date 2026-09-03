package src;

//Classe livro
public class Livro {
    private String titulo;
    private String autor;
    private String tema;
    private String isbn;
    private int paginas;
    private int publicacao;
    private boolean disponivel;


//Construtor livro
public Livro (String tituloLivro, String autorLivro, String temaLivro, String isbnLivro, int paginasLivro, int publicacaoLivro, boolean disponivelLivro){
    titulo = tituloLivro;
    autor = autorLivro;
    tema = temaLivro;
    isbn = isbnLivro;
    paginas = paginasLivro;
    publicacao = publicacaoLivro;
    disponivel = disponivelLivro;
}

//Getters
public String getTitulo(){
	return titulo;
}

public String getAutor(){
	return autor;
}

public String getTema(){
	return tema;
}

public String getIsbn(){
	return isbn;
}

public int getPaginas(){
	return paginas;
}

public int getPublicacao(){
	return publicacao;
}

public boolean isDisponivel(){
	return disponivel;
}

//Setters
public void setTitulo(String novotitulo){
	this.titulo=novotitulo;
}

public void setAutor(String novoautor){
	this.autor=novoautor;
}

public void setTema(String novotema){
	this.tema=novotema;
}

public void setIsbn(String novoisbn){
	this.isbn=novoisbn;
}

public void setPaginas(int novapagina){
	if (novapagina>=0){
    this.paginas=novapagina;
    }
    else{
        System.out.println("\nNumero de paginas tem que ser positivo");
    }
}

public void setPublicacao(int novapublicacao){
	if (novapublicacao>=0){
    this.publicacao=novapublicacao;
    }
    else{
        System.out.println("\nAno da publicação tem que ser positivo");
    }
}

public void setDisponivel(boolean troca){
        this.disponivel=troca;
}

//Metodos
public void emprestar(){
    if (this.disponivel==true){
        this.disponivel=false;
    }
    else{
        System.out.printf("\nO livro %s ja esta emprestado", this.titulo);
    }
}

public void devolver(){
    if (this.disponivel==false){
        this.disponivel=true;
    }
    else{
        System.out.printf("\nO livro %s nao esta emprestado", this.titulo);
    }
}

}
