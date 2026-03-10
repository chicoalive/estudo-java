package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Criando o cliente
        System.out.println("Dados do cliente: ");
        System.out.println("Nome: ");
        String nome = teclado.nextLine();
        System.out.println("Email: ");
        String email = teclado.nextLine();
        System.out.println("Nascimento (DD/MM/YYYY): ");
        // Convertendo String em Date.
        Date nascimento = sdf.parse(teclado.next());

    }
}
