package application;

import entities.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("== Academia de muscologia! ==");
        System.out.println();
        System.out.println("Quantos alunos deseja registrar: ");
        int qtd = teclado.nextInt();
        System.out.println();

        for (int i = 0; i < qtd; i++) {
            System.out.println("Dados do " + (i + 1) + "º Aluno:");
            System.out.println("Tipo de conta (regular/comum): ");
            String type = teclado.next();
            if (type.equalsIgnoreCase("regular")) {
                System.out.println("Nome: ");
                String name = teclado.next();
                System.out.println("Data de nascimento (DD/MM/YYYY): ");
                LocalDate dateOfBirth = sdf.parse(teclado.next());

            }
        }

        teclado.close();
    }
}
