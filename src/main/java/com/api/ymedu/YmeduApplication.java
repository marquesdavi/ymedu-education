package com.api.ymedu;

import com.api.ymedu.persistence.entities.CourseEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class YmeduApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(YmeduApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner teclado = new Scanner(System.in);

		while (true) {
			System.out.println("MENU DE CURSOS");
			System.out.println("1-Adicionar um curso");
			System.out.println("2-Listar os cursos");
			System.out.println("3-Atualizar os cursos");
			System.out.println("4-Apagar um curso");
			System.out.println("5-Sair");
			int opc = Integer.parseInt(teclado.nextLine());

			switch (opc) {
				case 1:
					adicionarCurso(teclado);
					break;
				case 2:
					listarCursos();
					break;
				case 3:
					atualizarCursos();
					break;
				case 4:
					apagarCursos();
					break;
				case 5:
					System.out.println("Saindo...");
					return;
				default:
					System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
			}
		}
	}

	private void adicionarCurso(Scanner teclado) {
		System.out.print("Digite o nome: ");
		String name = teclado.nextLine();
		System.out.print("Digite a descriçao: ");
		String description = teclado.nextLine();
		System.out.print("Digite o conteudo: ");
		String content = teclado.nextLine();
		System.out.print("Digite quem sera o instrutor: ");
		String instructor = teclado.nextLine();
		System.out.print("Digite a duraçao do curso: ");
		String duration = teclado.nextLine();


		/*
		novo.setName(name);
		novo.setDescription(description);
		novo.setContent(content);
		novo.setInstructor(instructor);
		novo.setDuration(duration);
		*/

		System.out.println("Curso adicionado com sucesso!");
	}

	private void listarCursos() {
		System.out.println("Opção 2 selecionada: Listar os Cursos");

	}

	private void atualizarCursos() {
		System.out.println("Opção 3 selecionada: Atualizar os Cursos");
	}

	private void apagarCursos() {
		System.out.println("Opção 4 selecionada: Apagar um Curso");
	}
}
