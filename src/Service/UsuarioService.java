package Service;

import model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioService {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario() {
        Usuario usuario = new Usuario();

        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();
        usuario.setNome(nome);
        usuarios.add(usuario);
    }

    public void listarUsuario() {

        if (!usuarios.isEmpty()) {
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario usuario = usuarios.get(i);

                System.out.println("Usuario " + (i + 1));
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("-------------------");
            }
        } else {
            System.out.println("Nenhum usuario cadastrado.");
        }
    }

    public void removerUsuario() {
        System.out.println("Digite o numero que deseja remover o usuario");
        int numeroUsuario = scanner.nextInt();
        scanner.nextLine();

        if (numeroUsuario <= 0 || numeroUsuario > usuarios.size()) {
            System.out.println("Número invalido");
            return;
        }

        usuarios.remove(numeroUsuario - 1);
        System.out.println("Usuário removido com sucesso!");
    }

    public void atualizarUsuario() {
        System.out.println("Deseja atualizar algum usuario?");
        int indiceUsuario = scanner.nextInt();
        scanner.nextLine();

        if (indiceUsuario <= 0 || indiceUsuario > usuarios.size()) {
            System.out.println("Indice errado");
            return;
        }

        Usuario usuario = usuarios.get(indiceUsuario - 1);

        System.out.println("Digite o novo nome do usuário:");
        String novoNome = scanner.nextLine();
        usuario.setNome(novoNome);

        System.out.println("Usuário atualizado com sucesso!");
    }

    public Usuario getUsuario(int indiceUsuario) {
        return usuarios.get(indiceUsuario);
    }
}