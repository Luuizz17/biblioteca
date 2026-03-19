package Service;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class EmprestimoService {

    private Scanner scanner = new Scanner(System.in);

    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    private UsuarioService usuarioService;
    private LivroService livroService;

    public EmprestimoService(UsuarioService usuarioService, LivroService livroService) {
        this.usuarioService = usuarioService;
        this.livroService = livroService;
    }

    public void realizarEmprestimo() {

        usuarioService.listarUsuario();
        System.out.println("Digite o número do usuário:");
        int numeroUsuario = scanner.nextInt();
        scanner.nextLine();

        if (numeroUsuario <= 0) {
            System.out.println("Número inválido!");
            return;
        }

        Usuario usuarioEscolhido = usuarioService.getUsuario(numeroUsuario - 1);

        livroService.listarLivros();
        System.out.println("Digite o número do livro:");
        int numeroLivro = scanner.nextInt();
        scanner.nextLine();

        if (numeroLivro <= 0) {
            System.out.println("Número inválido!");
            return;
        }

        Livro livroEscolhido = livroService.getLivro(numeroLivro - 1);

        if (!livroEscolhido.getDisponivel()) {
            System.out.println("Livro indisponível");
            return;
        }

        Emprestimo novoEmprestimo = new Emprestimo(usuarioEscolhido, livroEscolhido);

        emprestimos.add(novoEmprestimo);

        livroEscolhido.setDisponivel(false);

        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado.");
            return;
        }

        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo emprestimoAtual = emprestimos.get(i);
            Usuario usuarioDoEmprestimo = emprestimoAtual.getUsuario();
            Livro livroDoEmprestimo = emprestimoAtual.getLivro();

            System.out.println("Empréstimo " + (i + 1));
            System.out.println("Usuário: " + usuarioDoEmprestimo.getNome());
            System.out.println("Livro: " + livroDoEmprestimo.getTitulo());
            System.out.println("-------------------");
        }
    }

    public void devolverLivro() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado.");
            return;
        }

        listarEmprestimos();

        System.out.println("Qual emprestimo deseja devolver ?");
        int numeroEmprestimo = scanner.nextInt();
        scanner.nextLine();

        if (numeroEmprestimo <= 0 || numeroEmprestimo > emprestimos.size()) {
            System.out.println("Número invalido");
            return;
        }

        Emprestimo emprestimoEscolhido = emprestimos.get(numeroEmprestimo - 1);

        Livro livroDoEmprestimo = emprestimoEscolhido.getLivro();

        livroDoEmprestimo.setDisponivel(true);

        emprestimos.remove(numeroEmprestimo - 1);

        System.out.println("Livro devolvido com sucesso");
    }
}