package entities;

import java.util.HashMap;

public class Libray {

    private HashMap<String, Book> listalivros = new HashMap<>();


    // Adicionando livro com HashMap com isbn
    public void addBok(Book book) {
        // Verificando se o livro já existe.
        if (!listalivros.containsKey(book.getIsbn())) {
            listalivros.put(book.getIsbn(), book);
        } else {
            System.out.println("Livro já cadastrado");
        }

    }

    // Removendo livro com HashMap com isbn
    public void removeBook(String isbn) {
        // Verificando se o livro existe para pode remover
        if (listalivros.containsKey(isbn)){
            System.out.println("Livro removido");
            listalivros.remove(isbn);
        } else {
            System.out.println("Livro não encontrado");
        }
    }

    // Procurando o livro pelo autor
    public String listarLivrosAutor(String autor) {
        // 1. Inicia "bandeira" como falso (nada encontrado ainda)
        boolean exempl = false;

        // 2. .values() acessa os objetos Book dentro do Map para o laço
        for (Book book : listalivros.values()) {
            // 3. Compara autor ignorando maiúsculas/minúsculas
            if (book.getAuthor().equalsIgnoreCase(autor)) {
                System.out.println(book);
                exempl = true; // 4. Se achar ao menos um, "levanta a bandeira"
            }
        }

        // 5. Após percorrer TUDO, verifica se a bandeira continuou falsa
        // Usar o ! é mesmo que comparar a falso
        if (!exempl) {
            return "livro não encontrado";
        }

        return "Busca finalizada";
    }

    public void listaLivrosCadastrados() {
        for (String isbn : listalivros.keySet()) {
            System.out.println(isbn);
        }
    }

}
