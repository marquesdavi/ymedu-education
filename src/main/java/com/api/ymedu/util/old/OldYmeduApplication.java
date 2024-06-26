package com.api.ymedu.util.old;

import com.api.ymedu.model.course.Course;
import com.api.ymedu.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import java.util.Scanner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


public class OldYmeduApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OldYmeduApplication.class, args);
    }


    private ICourseRepository repository;

    @Override
    public synchronized void run(String... args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU DE CURSOS");
            System.out.println("1-Adicionar um curso");
            System.out.println("2-Listar os cursos");
            System.out.println("3-Atualizar os cursos");
            System.out.println("4-Apagar um curso");
            System.out.println("5-Sair");
            System.out.println("\nEscolha uma opção(número): ");
            String input = teclado.nextLine();
            int opc = 0;
            try {
                opc = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\n Por favor insira um número válido");
                continue;
            }

            switch (opc) {
                case 1:
                    adicionarCurso(teclado);
                    break;
                case 2:
                    System.out.println("\nOpção 2 selecionada: Listar os Cursos");
                    listarCursos();
                    break;
                case 3:
                    atualizarCurso(teclado);
                    break;
                case 4:
                    apagarCursos(teclado);
                    break;
                case 5:
                    System.out.println("\nSaindo...");
                    System.exit(0);
                    return;
                default:
                    System.out.println("\n Por favor insira um número válido.");
            }
        }
    }

    private void adicionarCurso(Scanner teclado) {
        System.out.print("Digite o nome: ");
        String name = teclado.nextLine();
        Course course = repository.findCourseByName(name);
        if(nonNull(course)) {
            System.out.println("Nome de curso já existente");
            return;
        }
        System.out.print("Digite a descriçao: ");
        String description = teclado.nextLine();
        System.out.print("Digite o conteudo: ");
        String content = teclado.nextLine();
        System.out.print("Digite quem sera o instrutor: ");
        String instructor = teclado.nextLine();
        System.out.print("Digite a duraçao do curso: ");
        String duration = teclado.nextLine();


        Course novoCurso = new Course();
        novoCurso.setName(name);
        novoCurso.setDescription(description);
        novoCurso.setContent(content);
        novoCurso.setInstructor(instructor);
        novoCurso.setDuration(duration);

        repository.save(novoCurso);
        System.out.println("Curso adicionado com sucesso!");
    }

    private void listarCursos() {
        System.out.println("==================================");
        for (Course item : repository.findAll()) {
            System.out.println("\n Nome: " + item.getName() + "\n Descrição: " + item.getDescription() +
                    "\n Conteudo: " + item.getContent() + "\n Intrutor: " +
                    item.getInstructor() + "\n Duração do curso: " + item.getDuration());
            System.out.println("\n==================================\n");
        }

    }

    private synchronized void atualizarCurso(Scanner teclado) throws InterruptedException {
        System.out.println("Opção 3 selecionada: Atualizar os Cursos");
        listarCursos();

        System.out.print("Digite o nome do curso que deseja editar: ");
        String name = teclado.nextLine();
        System.out.println("Curso selecionado: " + name);
    	Course course = repository.findCourseByName(name);

        int opc = 0;
        String field = null;

        do {
            if(isNull(course)) {
                System.out.println("\nCurso não encontrado");
                opc = 6;
            } else {
                System.out.println("""
                    			\n1 - Nome
                    2 - Descrição
                    3 - Conteúdo
                    4 - Instrutor
                    5 - Duração
                    6 - Voltar para o menu principal
                    """);
                System.out.print("\nEscolha o campo que deseja editar(numero): ");
                opc = Integer.parseInt(teclado.nextLine());
            }

            if (opc != 6) {
                System.out.print("\nDigite o novo valor do campo: ");
                field = teclado.nextLine();
            }

            if (opc == 1) {
                course.setName(field);
                repository.save(course);
            } else if (opc == 2) {
                course.setDescription(field);
                repository.save(course);
            } else if (opc == 3) {
                course.setContent(field);
                repository.save(course);
            } else if (opc == 4) {
                course.setInstructor(field);
                repository.save(course);
            } else if (opc == 5) {
                course.setDuration(field);
                repository.save(course);
            } else if (opc != 6) {
                System.out.println("\nOpção inválida! Tente novamente...");

            }
        } while (opc != 6);

    }

    private void apagarCursos(Scanner teclado) {
        System.out.println("Opção 4 selecionada: Apagar um Curso");
        System.out.print("Digite o nome: ");
        String name = teclado.nextLine();
        System.out.println(name);
        try {
            repository.deleteByName(name);
        } catch (Error err) {
            System.out.println("Erro" + err);
        }
    }
}
