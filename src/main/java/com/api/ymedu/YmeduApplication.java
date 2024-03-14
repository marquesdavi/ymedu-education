package com.api.ymedu;

import com.api.ymedu.model.course.Course;
import com.api.ymedu.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class YmeduApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(YmeduApplication.class, args);
	}
	@Autowired
	private ICourseRepository IcouseRepository;
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
					apagarCursos(teclado);
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


		Course novoCurso = new Course();
		novoCurso.setName(name);
		novoCurso.setDescription(description);
		novoCurso.setContent(content);
		novoCurso.setInstructor(instructor);
		novoCurso.setDuration(duration);

			IcouseRepository.save(novoCurso);
		System.out.println("Curso adicionado com sucesso!");
	}

	private void listarCursos() {
		System.out.println("Opção 2 selecionada: Listar os Cursos");
		for(Course item : IcouseRepository.findAll()) {
			System.out.println("\n Nome: " + item.getName() + "\n Descrição: " + item.getDescription() +
					"\n Conteudo: " + item.getContent() + "\n Intrutor: " +
					item.getInstructor() + "\n Duração do curso: " + item.getDuration());
		}
	}
	private void atualizarCursos() {
		System.out.println("Opção 3 selecionada: Atualizar os Cursos");
	}

	private void apagarCursos(Scanner teclado) {
		System.out.println("Opção 4 selecionada: Apagar um Curso");
		System.out.print("Digite o nome: ");
		String name = teclado.nextLine();
		System.out.println(name);
		try{
			IcouseRepository.deleteByName(name);
		} catch (Error err) {
			System.out.println("Erro" + err);
		}
	}
}
