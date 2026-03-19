package Service;

import model.Livro;

import java.util.ArrayList;
import java.util.Scanner;

public class LivroService {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Livro> listaLivros = new ArrayList<>();

    public void cadastrarLivro() {
        Livro livro = new Livro();

        System.out.println("Qual titulo do livro ?");
        String titulo = scanner.nextLine();
        livro.setTitulo(titulo);

        System.out.println("Qual o autor deste livro");
        String autor = scanner.nextLine();
        livro.setAutor(autor);

        livro.setDisponivel(true);

        listaLivros.add(livro);
    }

    public void listarLivros() {
        for (int i = 0; i < listaLivros.size(); i++) {
            Livro livro = listaLivros.get(i);

            System.out.println("Livro " + (i + 1));
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Disponível: " + livro.getDisponivel());
            System.out.println("-------------------");

            if (listaLivros.isEmpty()) {
                System.out.println("Nenhum livro cadastrado.");
                return;
            }
        }
    }

    public void removerLivro() {
        System.out.println("Digite o número do livro que deseja remover : ");
        int numeroLivro = scanner.nextInt();
        scanner.nextLine();

        if (numeroLivro <= 0 || numeroLivro > listaLivros.size()) {
            System.out.println("Número invalido");
            return;
        }

        listaLivros.remove(numeroLivro - 1);
    }

    public void atualizarLivro() {
        System.out.println("Deseja atualizar qual livro ? ");
        int indiceLivro = scanner.nextInt();

        if (indiceLivro <= 0 || indiceLivro > listaLivros.size()) {
            System.out.println("Número invalido");
            return;
        }

        scanner.nextLine();
        Livro livro = listaLivros.get(indiceLivro - 1);

        System.out.println("Qual nome deseja colocar?");
        String novoTitulo = scanner.nextLine();
        livro.setTitulo(novoTitulo);

        System.out.println("Qual nome do Autor ?");
        String novoAutor = scanner.nextLine();
        livro.setAutor(novoAutor);
    }

    public Livro getLivro(int indiceLivro) {
        return listaLivros.get(indiceLivro);
    }
}