import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContatoDAO dao = new ContatoDAO();
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n--- Lista Telefônica ---");
            System.out.println("1. Listar todos os contatos");
            System.out.println("2. Cadastrar novo contato");
            System.out.println("3. Alterar contato por ID");
            System.out.println("4. Deletar contato por ID");
            System.out.println("5. Pesquisar contato por nome");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    List<Contato> contatos = dao.listarTodos();
                    contatos.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    dao.inserir(new Contato(nome, telefone));
                    break;

                case 3:
                    dao.listarTodos().forEach(System.out::println);
                    System.out.print("ID do contato para alterar: ");

                    int idAlterar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    System.out.print("Novo telefone: ");
                    String novoTelefone = sc.nextLine();

                    dao.atualizar(new Contato(idAlterar, novoNome, novoTelefone));
                    break;

                case 4:
                    dao.listarTodos().forEach(System.out::println);
                    System.out.print("ID do contato para deletar: ");

                    int idDeletar = sc.nextInt();
                    dao.deletar(idDeletar);
                    break;

                case 5:
                    System.out.print("Digite o nome para pesquisar: ");
                    String nomeBusca = sc.nextLine();
                    dao.buscarPorNome(nomeBusca).forEach(System.out::println);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;


                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
