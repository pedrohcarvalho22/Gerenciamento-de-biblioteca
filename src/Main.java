package src;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        boolean continuar=true;
        
        while (continuar==true) {
            
            
            System.out.println("\nSistema de gerenciamento de biblioteca!\n");
            System.out.println("\nEscolha uma das opções:");
            System.out.println("1 - Gerenciar livros");
            System.out.println("2 - Gerenciar usuários");
            System.out.println("3 - Realizar empréstimo");
            System.out.println("4 - Registrar devolução");
            System.out.println("5 - Opções empréstimos");
            System.out.println("0 - Sair");

            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("\nEscolha uma das opções:");
                    System.out.println("1 - Registrar livro");
                    System.out.println("2 - Remover livro");
                    System.out.println("3 - Listar livros");
                    System.out.println("4 - Pesquisar livro");
                    System.out.println("5 - Alterar livro");
                    System.out.println("0 - Voltar");
                    int oplivro = sc.nextInt();
                    sc.nextLine();
                    switch (oplivro) {
                        case 1:
                            System.out.println("\nDigite o titulo: ");
                            String t = sc.nextLine();
                            System.out.println("\nDigite o autor: ");
                            String a = sc.nextLine();
                            System.out.println("\nDigite o tema: ");
                            String te = sc.nextLine();
                            System.out.println("\nDigite o isbn: ");
                            String is = sc.nextLine();
                            System.out.println("\nDigite o numero de paginas: ");
                            int p = sc.nextInt();
                            System.out.println("\nDigite o ano de publicacao: ");
                            int pu = sc.nextInt();
                            biblioteca.registrarLivro(new Livro(t, a, te, is, p, pu, true));
                            System.out.println("\nLivro registrado");
                            break;

                        case 2:
                            System.out.println("Digite o titulo do livro que voce deseja remover: ");
                            String ti = sc.nextLine();
                            if(biblioteca.pesquisarLivro(ti, false) && (biblioteca.verificarSeEmprestavel(ti))){
                               biblioteca.removerLivro(ti);
                               System.out.println("Livro removido");
                            }
                            else if(!(biblioteca.verificarSeEmprestavel(ti))){
                                System.out.println("Livro emprestado, logo não é possivel retirar");
                            }
                            else{
                                System.out.println("Livro não encontrado");
                            }
                            break;

                        case 3:
                            biblioteca.listarLivros();
                            break;

                        case 4:
                            System.out.println("Digite o titulo do livro que voce deseja pesquisar: ");
                            String tit = sc.nextLine();
                            biblioteca.pesquisarLivro(tit, true);
                            break;

                        case 5:
                            System.out.println("Digite o titulo do livro que voce deseja alterar: ");
                            String titu = sc.nextLine();
                            if((biblioteca.pesquisarLivro(titu, false)) && (biblioteca.verificarSeEmprestavel(titu))){
                                System.out.println("\nDigite o titulo do novo livro: ");
                                String t1 = sc.nextLine();
                                System.out.println("\nDigite o autor o novo livro: ");
                                String a1 = sc.nextLine();
                                System.out.println("\nDigite o tema o novo livro: ");
                                String te1 = sc.nextLine();
                                System.out.println("\nDigite o isbn o novo livro: ");
                                String is1 = sc.nextLine();
                                System.out.println("\nDigite o numero de paginas o novo livro: ");
                                int p1 = sc.nextInt();
                                System.out.println("\nDigite o ano de publicacao o novo livro: ");
                                int pu1 = sc.nextInt();
                                sc.nextLine();
                                biblioteca.alterarLivro(titu, new Livro(t1, a1, te1, is1, p1, pu1, true), true);
                            }
                            else if (!(biblioteca.pesquisarLivro(titu, false))){
                                System.out.println("Livro não encontrado");
                            }
                            else {
                                System.out.println("O livro esta emprestado por isso nao pode ser alterado");
                            }
                            break;

                        case 0:
                            
                            break;
                    
                        default:
                            System.out.println("\nOpção indisponivel, tente um digito de 0 a 5");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("\nEscolha uma das opções:");
                    System.out.println("1 - Registrar usuario");
                    System.out.println("2 - Remover usuario");
                    System.out.println("3 - Listar usuario");
                    System.out.println("4 - Pesquisar usuario");
                    System.out.println("5 - Alterar usuario");
                    System.out.println("0 - Voltar");
                    int opusuario = sc.nextInt();
                    sc.nextLine();
                    switch (opusuario) {
                        case 1:
                            System.out.println("\nDigite o Nome: ");
                            String n = sc.nextLine();
                            System.out.println("\nDigite o id: ");
                            int idd = sc.nextInt();
                            sc.nextLine();
                            System.out.println("\nDigite o email: ");
                            String ema = sc.nextLine();
                            biblioteca.registrarUsuario(new Usuario(n, idd, ema));
                            System.out.println("\nUsuario registrado");
                            break;

                        case 2:
                            System.out.println("Digite o id do usuario que voce deseja remover: ");
                            int idd1 = sc.nextInt();
                            sc.nextLine();
                            if(biblioteca.pesquisarUsuario(idd1, false) && (biblioteca.verificarDividas(idd1))){
                               biblioteca.removerUsuario(idd1);
                               System.out.println("Usuario removido");
                            }
                            else if(!(biblioteca.verificarDividas(idd1))){
                                System.out.println("Usuario com dividas, logo não é possivel retirar");
                            }
                            else{
                                System.out.println("Usuario não encontrado");
                            }
                            break;

                        case 3:
                            biblioteca.listarUsuarios();
                            break;

                        case 4:
                            System.out.println("Digite o id do usuario que voce deseja pesquisar: ");
                            int idd2 = sc.nextInt();
                            sc.nextLine();
                            biblioteca.pesquisarUsuario(idd2, true);
                            break;

                        case 5:
                            System.out.println("Digite o id do usuario que voce deseja alterar: ");
                            int idd3 = sc.nextInt();
                            sc.nextLine();
                            if((biblioteca.pesquisarUsuario(idd3, false)) && (biblioteca.verificarDividas(idd3))){
                                System.out.println("\nDigite o Nome: ");
                                String n1 = sc.nextLine();
                                System.out.println("\nDigite o id: ");
                                int idd4 = sc.nextInt();
                                sc.nextLine();
                                System.out.println("\nDigite o email: ");
                                String ema1 = sc.nextLine();
                                biblioteca.alterarUsuario(idd3, new Usuario(n1, idd4, ema1));
                                System.out.println("\nUsuario registrado");
                            }
                            else if (!(biblioteca.pesquisarUsuario(idd3, false))){
                                System.out.println("Usuario não encontrado");
                            }
                            else {
                                System.out.println("O usuario tem pendencias nos emprestimos por isso nao pode ser alterado");
                            }
                            break;

                        case 0:
                            
                            break;
                    
                        default:
                            System.out.println("\nOpção indisponivel, tente um digito de 0 a 5");
                            break;
                    }
                    
                    break;

                case 3:
                    System.out.println("Digite o id do Usuario que vai realizar o emprestimo: ");
                    int idd5 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o titulo do livro que sera emprestado: ");
                    String titulo = sc.nextLine();
                    biblioteca.realizarEmprestimo(titulo, idd5);
                    break;

                case 4:
                    System.out.println("Digite o titulo do livro que sera devolvido: ");
                    sc.nextLine();
                    String titulo1 = sc.nextLine();
                    biblioteca.devolverLivro(titulo1);
                    break;

                case 5:
                    System.out.println("\nEscolha uma das opções:");
                    System.out.println("1 - Listar emprestimos");
                    System.out.println("2 - Listar emprestimos ativos");
                    System.out.println("3 - Consultar posse de um livro");
                    System.out.println("4 - Consultar quais livros um usuario possui");
                    System.out.println("0 - Voltar");
                    int opemprestimo = sc.nextInt();
                    sc.nextLine();
                    switch (opemprestimo) {
                        case 1:
                            biblioteca.listarEmprestimos();
                            break;

                        case 2:
                            biblioteca.listarEmprestimosAtivos();
                            break;

                        case 3:
                            System.out.println("Digite o titulo do livro que voce quer conferir com quem está emprestado: ");
                            String titulot = sc.nextLine();
                            biblioteca.consultarPosseLivro(titulot);
                            break;

                        case 4:
                            System.out.println("Digite o id do usuario que voce deseja ver quais livros estão emprestados com ele: ");
                            int idd6 = sc.nextInt();
                            sc.nextLine();
                            biblioteca.consultarEmprestimos(idd6);
                            break;

                        case 0:
                            
                            break;
                    
                        default:
                            System.out.println("Opção indisponivel, tente um digito de 0 a 5");
                            break;
                    }
                    
                    break;

                case 0:
                    continuar=false;
                    break;
            
                default:
                    System.out.println("Opção indisponivel, tente um digito de 0 a 5");
                    break;
            }
        }

        sc.close();
    }
}
