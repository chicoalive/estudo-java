package entities;

import java.util.*;

public class Escola {

    // ArrayList: É a implementação mais comum de List. É como um array redimensionável.
    List<Aluno> listaAlunos = new ArrayList<>();
    HashMap<String, Aluno> alunos = new HashMap<>();

    // Set: É uma interface que NÃO permite itens duplicados e NÃO garante a ordem de inserção.
    // HashSet: É a implementação mais comum de Set.
    HashSet<String> listaDisciplinas = new HashSet<>();


    // Adicionar aluno
    public void AddAluno(Aluno aluno) {
        listaAlunos.add(aluno);
        alunos.put(aluno.getMatricula(), aluno);
    }

    // Remover aluno
    public void removAluno(Aluno aluno) {
        listaAlunos.remove(aluno);
        alunos.remove(aluno.getMatricula());
    }

    // Exibir alunos com arraylist
    public void listarAlunos() {
        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno);

        }
    }

    // Retornar os dados do aluno pela mátricula
    // No HashMap não preciso usar for para buscar.
    // O método get(chave) já retorna o valor associado.
    //  O for com entrySet() serve apenas para percorrer todos os pares, não para buscar um único elemento específico.
    public String buscaAlunoMatricula(String matricula) {
        Aluno aluno = alunos.get(matricula);
                if (aluno != null){
                    return "Aluno encontrado: "+ aluno;
                }
                return "Aluno não encontrado.";
    }

    // Adicionar disciplinas HashSet
    public void AddDisciplina(String disciplina) {
        listaDisciplinas.add(disciplina);
    }

    // Removendo disciplinas com HashSet
    public void removDisciplina(String disciplina) {
        listaDisciplinas.remove(disciplina);
    }

    // Exibir disciplinas
    public void listarDisciplinas() {
        for (String disciplina : listaDisciplinas) {
            System.out.println(disciplina);
        }
    }

}


