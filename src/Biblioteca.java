package src;
import java.util.ArrayList;
import java.util.Optional; 

public class Biblioteca {
    private ArrayList<Livro> listalivros = new ArrayList<>();
    private ArrayList<Usuario> listausuarios = new ArrayList<>();
    private ArrayList<Emprestimo> listaemprestimos = new ArrayList<>();

    //Metodos Livro
    public void registrarLivro(Livro livro){
        listalivros.add(livro);
    }

    public void listarLivros(){
        for (int i=0; i<listalivros.size(); i++){
            System.out.printf("\nLivro %d: \nTitulo: %s \nAutor: %s \nTema: %s \nIsbn: %s \nNumero de paginas: %d \nAno de publicação: %d \nDisponivel para emprestimo: %b\n", (i+1), listalivros.get(i).getTitulo(), listalivros.get(i).getAutor(), listalivros.get(i).getTema(), listalivros.get(i).getIsbn(), listalivros.get(i).getPaginas(), listalivros.get(i).getPublicacao(), listalivros.get(i).isDisponivel());
        }
    }

    public boolean pesquisarLivro(String nome, boolean ver){
        int z = listalivros.size();
        int posicao=-1;
        for (int i=0; i<z; i++){
            if (nome.equalsIgnoreCase(listalivros.get(i).getTitulo())){
                posicao=i;
                break;
            }
        }
        if (posicao!=-1){
            if(ver==true){
                System.err.printf("\nLivro encontrado na lista: \nPosição: %d \nTitulo: %s \nAutor: %s \nTema: %s \nIsbn: %s \nNumero de paginas: %d \nAno de publicação: %d \nDisponivel para emprestimo: %b\n", (posicao+1), listalivros.get(posicao).getTitulo(), listalivros.get(posicao).getAutor(), listalivros.get(posicao).getTema(), listalivros.get(posicao).getIsbn(), listalivros.get(posicao).getPaginas(), listalivros.get(posicao).getPublicacao(), listalivros.get(posicao).isDisponivel());
            }
            return true;
        }
        else {
            if (ver==true){
                System.err.printf("Livro com o titulo %s não encontrado na lista", nome);
            }
            return false;
        }
    }

    public boolean alterarLivro(String nomeantigo, Livro novo, boolean ver){
        int z = listalivros.size();
        int posicao=-1;
        for (int i=0; i<z; i++){
            if (nomeantigo.equalsIgnoreCase(listalivros.get(i).getTitulo())){
                posicao=i;
                break;
            }
        }
        if (posicao!=-1){
            listalivros.set(posicao, novo);
            if (ver){
                System.out.println("Livro alterado");
            }
            return true;
        }
        else {
            if (!(ver)){
                System.out.println("Livro não encontrado");
            }
            return false;
        }
    }

    public boolean removerLivro(String nome){
        int z = listalivros.size();
        int posicao=-1;
        for (int i=0; i<z; i++){
            if (nome.equalsIgnoreCase(listalivros.get(i).getTitulo())){
                posicao=i;
                break;
            }
        }
        if (posicao!=-1){
            listalivros.remove(posicao);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean verificarSeEmprestavel(String nome){
        int posicao = -1;
        for (int i=0; i<listalivros.size(); i++){
                if (nome.equalsIgnoreCase(listalivros.get(i).getTitulo())){
                posicao=i;
                break;
            }
        }
        if (posicao==-1){
            return false;
        }
        else{
        return listalivros.get(posicao).isDisponivel();
        } 
    }

    public int quantidadeLivros(){
        return listalivros.size();
    }

    public Optional<Livro> retorneLivro(String titulo){
        int posicao=-1;
        for (int i=0; i<listalivros.size(); i++){
            if (titulo.equalsIgnoreCase(listalivros.get(i).getTitulo())){
                posicao=i;
            }
        }
        if (posicao==-1){
            return Optional.empty();
        }
        else{
            return Optional.of(listalivros.get(posicao));
        }
    }

    //Metodos Usuario
    public void registrarUsuario(Usuario usuario){
        listausuarios.add(usuario);
    }

    public void listarUsuarios(){
        for (int i=0; i<listausuarios.size(); i++){
            System.out.printf("\nUsuario %d: \nNome: %s \nId: %d \nEmail: %s\n",(i+1), listausuarios.get(i).getNome(), listausuarios.get(i).getId(), listausuarios.get(i).getEmail());
        }
    }

    public boolean pesquisarUsuario(int idd, boolean ver){
        int z = listausuarios.size();
        int posicao=-1;
        for (int i=0; i<z; i++){
            if (idd==listausuarios.get(i).getId()){
                posicao=i;
                break;
            }
        }
        if (posicao!=-1){
            if (ver==true){
                System.err.printf("\nUsuario encontrado na posição %d: \nNome: %s \nId: %d \nEmail: %s",(posicao+1), listausuarios.get(posicao).getNome(), listausuarios.get(posicao).getId(), listausuarios.get(posicao).getEmail());
            }
            return true;
        }
        else {
            if (ver==true){
                System.err.printf("O usuario com id %d não encontrado na lista", idd);
            }
            return false;
        }
    }

    public boolean alterarUsuario(int idantigo, Usuario novo){
        int z = listausuarios.size();
        int posicao=-1;
        for (int i=0; i<z; i++){
            if (idantigo==listausuarios.get(i).getId()){
                posicao=i;
                break;
            }
        }
        if (posicao!=-1){
            listausuarios.set(posicao, novo);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removerUsuario(int idd){
        int z = listausuarios.size();
        int posicao=-1;
        for (int i=0; i<z; i++){
            if (idd==listausuarios.get(i).getId()){
                posicao=i;
                break;
            }
        }
        if (posicao!=-1){
            listausuarios.remove(posicao);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean verificarDividas(int id){
        int verificador = 0;
        for (int i=0; i<listaemprestimos.size(); i++){
            if ((listaemprestimos.get(i).getEmprestado()==true) && (id==listaemprestimos.get(i).getUsuario().getId())){
                verificador=1;
                return false;
            }
        }
        if (verificador==0){
            return true;
        }
        else{
            return false;
        }
    }

    public Optional<Usuario> retorneUsuario(int id){
        int posicao=-1;
        for (int i=0; i<listausuarios.size(); i++){
            if (id == listausuarios.get(i).getId()){
                posicao=i;
            }
        }
        if (posicao==-1){
            return Optional.empty();
        }
        else{
            return Optional.of(listausuarios.get(posicao));
        }
    }

    //Metodos emprestimo

    public void realizarEmprestimo(String titulo, int id){
        Livro livro = retorneLivro(titulo).orElse(null);
        Usuario usuario = retorneUsuario(id).orElse(null);

        if ((livro==null)||(usuario==null)){
            System.out.println("Usuario ou livro incorretos");
        }
        else{
            if ((livro.isDisponivel()==true) && (pesquisarUsuario(usuario.getId(), false)) && (pesquisarLivro(livro.getTitulo(), false))){
                listaemprestimos.add(new Emprestimo(usuario, livro, true));
                livro.emprestar();
                System.out.println("Emprestimo realizado");
            }
            else{
                System.out.println("\nO livro ja esta emprestado");
            }
        }
    }

    public void devolverLivro(String titulo){
        Livro livro = retorneLivro(titulo).orElse(null);
        if (livro==null){
            System.out.println("Livro não encontrado");
        }
        else{
            boolean encontrado=false;
            for (int i=0; i<listaemprestimos.size(); i++){
                if(livro.equals(listaemprestimos.get(i).getLivro()) && (listaemprestimos.get(i).getEmprestado()==true)){
                    listaemprestimos.get(i).getLivro().devolver();
                    listaemprestimos.get(i).devolver();
                    encontrado=true;
                    break;
                }
            }
            if (encontrado==false){
                System.out.println("O livro nao esta emprestado");
            }
            else{
            System.out.println("Livro devolvido");
            }
        }
    }

    public void listarEmprestimos(){
        int contador=0;
        for (int i=0; i<listaemprestimos.size(); i++){
            System.out.printf("\nEmprestimo %d: \nTitulo do livro: %s \nIsbn: %s \nId do usuario: %d \nEsta emprestado: %b\n", (i+1), listaemprestimos.get(i).getLivro().getTitulo(), listaemprestimos.get(i).getLivro().getIsbn(), listaemprestimos.get(i).getUsuario().getId(), listaemprestimos.get(i).getEmprestado());
            contador = contador+1;
        }
        if (contador==0){
            System.out.println("\nNão há emprestimos");
        }
    }

    public void listarEmprestimosAtivos(){
        int posicao=0;
        int contador=0;
        for (int i=0; i<listaemprestimos.size(); i++){
            if (listaemprestimos.get(i).getEmprestado()==true){
                System.out.printf("\nEmprestimo ativo %d: \nTitulo do livro: %s \nIsbn: %s \nId do usuario: %d\n", (posicao+1), listaemprestimos.get(i).getLivro().getTitulo(), listaemprestimos.get(i).getLivro().getIsbn(), listaemprestimos.get(i).getUsuario().getId());
                posicao=posicao+1;
                contador = contador+1;
            }
        }
        if (contador==0){
            System.out.println("\nNão há emprestimos ativos");
        }
    }

    public void consultarEmprestimos(int id){
        Usuario usuario = retorneUsuario(id).orElse(null);
        if (usuario==null){
            System.out.println("Usuario não encontrado");
        }
        else{
            int contador=0;
            for(int i=0; i<listaemprestimos.size(); i++){
                if(listaemprestimos.get(i).getUsuario().getId()==(usuario.getId())){
                    System.out.printf("\nLivro %d: %s", (contador+1), listaemprestimos.get(i).getLivro().getTitulo());
                    contador=contador+1;
                }
            }
            if(contador==0){
                System.out.println("Nao ha emprestimos com esse usuario");
            }
        }
    }

    public void consultarPosseLivro(String titulo){
        Livro livro = retorneLivro(titulo).orElse(null);
        if (livro==null){
            System.out.println("Livro não encontrado");
        }
        else{
            boolean encontrado=false;
            for(int i=0; i<listaemprestimos.size(); i++){
                if((listaemprestimos.get(i).getLivro().equals(livro)) && (listaemprestimos.get(i).getEmprestado()==true)){
                    System.out.printf("\n O livro %s esta com o usuario de id %d",listaemprestimos.get(i).getLivro().getTitulo(), listaemprestimos.get(i).getUsuario().getId());
                    encontrado=true;
                }
            }
            if (encontrado==false){
                System.out.println("Ninguem esta com posse desse livro");
            }
        }
    }

}
