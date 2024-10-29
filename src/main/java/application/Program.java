package application;

import dominio.Producer;
import service.ProducerService;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//ProducerService.save(new Producer());
        int menu;

        do {
            System.out.println("\nMenu");
            System.out.println("1 - inserir");
            System.out.println("2 - deletar");
            System.out.println("3 - atualizar");
            System.out.println("4 - lista todos");

            System.out.print("Escolha uma opção: ");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Insira o nome: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    ProducerService.save(nome);
                    break;
                case 2:
                    System.out.print("Insira o id: ");
                    int id = sc.nextInt();
                    ProducerService.delete(id);
                    break;
                case 3:
                    System.out.print("Insira o id do produto que deseja atualizar: ");
                    int ids = sc.nextInt();
                    System.out.print("Atualize: ");
                    sc.nextLine();
                    String nomes = sc.nextLine();
                    ProducerService.update(ids, nomes);
                    break;
                case 4:
                    List<Producer> producers = ProducerService.findAll();
                    System.out.print(producers);
                    break;
                default:
                    break;
            }
        } while (menu != 0);
    }
}
