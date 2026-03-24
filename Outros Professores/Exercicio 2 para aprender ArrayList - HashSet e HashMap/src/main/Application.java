package main;

import entities.Book;
import entities.Libray;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);
        Libray libray = new Libray();

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("=== Menu ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Buscar por autor");
            System.out.println("3 - Remover livro");
            System.out.println("4 - Listar livros cadastrados (ISBNs");
            System.out.println("5 - Sair");
            System.out.println();
            System.out.print("Escolha: ");
            String opcaoString = teclado.nextLine().trim();
            opcao = Integer.parseInt(opcaoString);
            // Se usa-se o do while teria problema com as escolha
            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String title = teclado.nextLine().trim();
                    System.out.print("Autor: ");
                    String author = teclado.nextLine().trim();
                    System.out.print("ISBN: ");
                    String isbn = teclado.nextLine().trim();
                    Book book = new Book(title, author, isbn);
                    libray.addBok(book);
                    break;
                case 2:
                    System.out.print("Autor: ");
                    String autor = teclado.nextLine().trim();
                    System.out.println(libray.listarLivrosAutor(autor));
                    break;
                case 3:
                    System.out.print("ISBN: ");
                    String isbnRemove = teclado.nextLine().trim();
                    libray.removeBook(isbnRemove);
                    break;
                case 4:
                    libray.listaLivrosCadastrados();
                    break;
                case 5:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Digite um número valido");
            }
            System.out.println();

        }

        teclado.close();
    }
}
