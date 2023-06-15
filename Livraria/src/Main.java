import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InserirLivros inserir = new InserirLivros();
        ExcluirLivros excluir = new ExcluirLivros();
        ConsultaLivro consultar = new ConsultaLivro();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("<1> Cadastrar Livro");
            System.out.println("<2> Pesquisar Livro por Preço");
            System.out.println("<3> Pesquisar Livro por Título");
            System.out.println("<4> Excluir Livro");
            System.out.println("<5> Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o preço do livro:");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    Livro livro = new Livro(titulo, autor, preco);
                    inserir.inserirLivro(livro);
                    break;

                case 2:
                    System.out.println("Digite o valor mínimo do preço:");
                    double precoMinimo = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    List<Livro> livrosPorPreco = consultar.buscarLivroPorPreco(precoMinimo);
                    System.out.println("Livros encontrados:");
                    for (Livro livroPreco : livrosPorPreco) {
                        System.out.println(livroPreco);
                    }
                    break;

                case 3:
                    System.out.println("Digite o início do título do livro:");
                    String inicioTitulo = scanner.nextLine();

                    List<Livro> livrosPorTitulo = consultar.buscarLivroPorTitulo(inicioTitulo);
                    System.out.println("Livros encontrados:");
                    for (Livro livroTitulo : livrosPorTitulo) {
                        System.out.println(livroTitulo);
                    }
                    break;

                case 4:
                    System.out.println("Digite o ID do livro a ser excluído:");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    excluir.excluirLivro(idLivro);
                    break;

                case 5:
                    System.out.println("Encerrando o programa...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
