package aplicacao;

import entidades.RegistroSensor;
import listas.ListaSensores;

import java.util.Random;
import java.util.Scanner;

public class Monitora {
	public static final float PH_MIN = 4;
	public static final float PH_MAX = 8;
	public static final int POTASSIO_MIN = 100;
	public static final int POTASSIO_MAX = 110;
	public static final int UMIDADE_MIN = 20;
	public static final int UMIDADE_MAX = 70 - UMIDADE_MIN;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random gerador = new Random();

		ListaSensores sensores = new ListaSensores();

		// // Valores ideais + margem de conformidade
		// int valorIdealUmidade = 50;
		// int valorIdealPotassio = 150;
		// float valorIdealPH = 6;
		// //

		String coordenadasSensores[] = { "47o55�44�W,21o00�34�S",
				"47o55�42�W,21o00�35�S",
				"47o55�39�W,21o00�37�S",
				"47o55�44�W,21o00�39�S",
				"47o55�40�W,21o00�40�S",
				"47o55�32�W,21o00�34�S",
				"47o55�28�W,21o00�34�S",
				"47o55�28�W,21o00�38�S",
				"47o55�33�W,21o00�39�S" };
		int n = coordenadasSensores.length;

		for (int i = 0; i < n; i++) {
			// System.out.println("Sensor " + i + ": " + coordenadasSensores[i]);
			int umi = gerador.nextInt(UMIDADE_MAX) + UMIDADE_MIN;
			float ph = PH_MAX - (PH_MIN * ((float) gerador.nextInt(10) / 10));
			int pt = gerador.nextInt(POTASSIO_MAX) + POTASSIO_MIN;
			RegistroSensor sensor = new RegistroSensor(coordenadasSensores[i], umi, pt, ph);
			sensores.insere(sensor);
		}

		int option;
		do {
			System.out.println();
			System.out.println("-------Meu de Opções-------");
			System.out.println("0 - Encerrar o atendimento");
			System.out.println("1 - Mostrar lista de registros");
			System.out.println("2 - Verificar se há alguma coordenada com alerta");
			System.out.println("3 - Pesquisar coordenada");
			System.out.println("4 - Remover coordenada");
			System.out.println("5 - Adicionar nova coordenada");
			option = sc.nextInt();

			switch (option) {
				case 0:
					System.out.println("Programa encerrado.");
					break;
				case 1:
					sc.nextLine();
					sensores.apresenta();
					break;
				case 2:
					sensores.apresentarAlertas();
					break;
				case 3:
					String scCoordenada;
					System.out.println();
					sc.nextLine();
					System.out.print("Qual a Coordenada desejada? ");
					scCoordenada = sc.nextLine();
					sensores.pesquisaCoordenada(scCoordenada);
					break;
				case 4:
					System.out.println();
					sc.nextLine();
					System.out.print("Qual coordenada que deseja remover? ");
					scCoordenada = sc.nextLine();
					sensores.remove(scCoordenada);
					System.out.println("A coordenada foi removida!");
					break;
				case 5:
					int optionAddCoordenada;
					System.out.println();
					System.out.println("Digite o que deseja");
					System.out.println("1 - Adicionar MANUALMENTE a coordenada E os valores de seus atributos");
					System.out.println("2 - Adicionar APENAS a coordenada e deixar a AI adicionar seus atributos");
					optionAddCoordenada = sc.nextInt();
					switch (optionAddCoordenada) {
						case 1:
							sc.nextLine();
							System.out.print("Qual é a localização da nova coordenada? ");
							scCoordenada = sc.nextLine();
							System.out.print("Qual o valor da umidade do local? ");
							int umi = sc.nextInt();
							System.out.print("Qual o valor do PH do local? ");
							float ph = sc.nextFloat();
							System.out.print("Qual o valor da Concentração de Potássio do local? ");
							int pt = sc.nextInt();
							RegistroSensor sensor = new RegistroSensor(scCoordenada, umi, pt, ph);
							sensores.insere(sensor);
							System.out.println("A nova coordenada foi inserida!");
							break;
						case 2:
							sc.nextLine();
							System.out.print("Qual é a localização da nova coordenada? ");
							scCoordenada = sc.nextLine();
							umi = gerador.nextInt(UMIDADE_MAX) + UMIDADE_MIN;
							ph = PH_MAX - (PH_MIN * ((float) gerador.nextInt(10) / 10));
							pt = gerador.nextInt(POTASSIO_MAX) + POTASSIO_MIN;
							RegistroSensor sensor1 = new RegistroSensor(scCoordenada, umi, pt, ph);
							sensores.insere(sensor1);
							System.out.println("A nova coordenada foi inserida!");
							break;

						default:
							System.out.println("Opção inválida!");
							break;
					}
				default:
					System.out.println("Opção inválida!");
					break;
			}
		} while (option != 0);

	}

}