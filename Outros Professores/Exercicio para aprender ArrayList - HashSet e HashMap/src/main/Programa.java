package main;

import entities.Aluno;
import entities.Escola;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Escola escola = new Escola();
        String respostaMatriAluno, repostaDisciplina;
        System.out.println("=== Matricula de Alunos ===");

        do {
            System.out.print("Nome: ");
            String nomeAluno = teclado.nextLine().trim();
            System.out.print("Matricula: ");
            String matriculaAluno = teclado.nextLine().trim();
            Aluno aluno = new Aluno(nomeAluno, matriculaAluno);
            escola.AddAluno(aluno);
            System.out.println();
            
            System.out.print("Deseja cadastrar outro aluno (sim/não): ");
            respostaMatriAluno = teclado.nextLine().trim();
            
            // Validação para garantir que digite "sim", "não" ou "nao"
            while (!respostaMatriAluno.equalsIgnoreCase("sim") && !respostaMatriAluno.equalsIgnoreCase("não") && !respostaMatriAluno.equalsIgnoreCase("nao")) {
                System.out.print("Resposta inválida! Digite 'sim' ou 'não': ");
                respostaMatriAluno = teclado.nextLine().trim();
            }
            
            System.out.println();
        } while (!respostaMatriAluno.equalsIgnoreCase("não") && !respostaMatriAluno.equalsIgnoreCase("nao"));

        System.out.println("=== Adicionando disciplinas ===");
        do {
            System.out.print("Disciplina: ");
            String nomeDisciplina = teclado.nextLine().trim();
            System.out.println();
            
            System.out.print("Deseja adicionar outra disciplina (sim/não): ");
            repostaDisciplina = teclado.nextLine().trim();
            
            // Validação para garantir que digite "sim", "não" ou "nao"
            while (!repostaDisciplina.equalsIgnoreCase("sim") && !repostaDisciplina.equalsIgnoreCase("não") && !repostaDisciplina.equalsIgnoreCase("nao")) {
                System.out.print("Resposta inválida! Digite 'sim' ou 'não': ");
                repostaDisciplina = teclado.nextLine().trim();
            }
            
            System.out.println();
            escola.AddDisciplina(nomeDisciplina);
        } while (!repostaDisciplina.equalsIgnoreCase("não") && !repostaDisciplina.equalsIgnoreCase("nao"));

        System.out.println("=== Encontrando aluno pela matrícula ===");
        System.out.print("Digite a matricula do aluno: ");
        String matricula = teclado.nextLine().trim();
        System.out.println();
        
        System.out.println("=== Lista de Alunos ===");
        escola.listarAlunos();
        System.out.println();
        
        System.out.println("=== Lista de Disciplinas ===");
        escola.listarDisciplinas();
        System.out.println();
        
        System.out.println("=== Resultado da Busca ===");
        System.out.println(escola.buscaAlunoMatricula(matricula));

        System.out.println();
        teclado.close();
    }
}