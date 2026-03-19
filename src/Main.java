import Service.LivroService;
import Service.UsuarioService;
import Service.EmprestimoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LivroService service = new LivroService();
        UsuarioService usuarioService = new UsuarioService();
        EmprestimoService emprestimoService = new EmprestimoService(usuarioService, service);
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Atualizar livro");
            System.out.println("4 - Remover livro");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){
                case 1:
                    service.cadastrarLivro();
                    break;
                case 2:
                    service.listarLivros();
                    break;
                case 3:
                    service.atualizarLivro();
                    break;
                case 4:
                    service.removerLivro();
                    break;
                case 5:
                    usuarioService.cadastrarUsuario();
                    break;

                case 6:
                    usuarioService.listarUsuario();
                    break;

                case 7:
                    usuarioService.atualizarUsuario();
                    break;

                case 8:
                    usuarioService.removerUsuario();
                    break;
                case 9:
                    emprestimoService.realizarEmprestimo();
                    break;
                case 10:
                    emprestimoService.listarEmprestimos();
                    break;
                case 11:
                    emprestimoService.devolverLivro();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while(opcao != 0);
    }
}