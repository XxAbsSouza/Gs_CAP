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
		Scanner le = new Scanner(System.in);
		Random gerador = new Random();

		ListaSensores sensores = new ListaSensores();

		// Valores ideais + margem de conformidade
		int valorIdealUmidade = 50;
		int valorIdealPotassio = 150;
		float valorIdealPH = 6;
		//

		String coordenadasSensores[] = { "47o55�44�W,21o00�34�S", "47o55�42�W,21o00�35�S", "47o55�39�W,21o00�37�S",
				"47o55�44�W,21o00�39�S", "47o55�40�W,21o00�40�S", "47o55�32�W,21o00�34�S", "47o55�28�W,21o00�34�S",
				"47o55�28�W,21o00�38�S", "47o55�33�W,21o00�39�S" };
		int n = coordenadasSensores.length;

		System.out.println(" Coordenadas Iniciais");
		for (int i = 0; i < n; i++) {
			// System.out.println("Sensor " + i + ": " + coordenadasSensores[i]);
			int umi = gerador.nextInt(UMIDADE_MAX) + UMIDADE_MIN;
			float ph = PH_MAX - (PH_MIN * ((float) gerador.nextInt(10) / 10));
			int pt = gerador.nextInt(POTASSIO_MAX) + POTASSIO_MIN;
			RegistroSensor sensor = new RegistroSensor(coordenadasSensores[i], umi, pt, ph);
			sensores.insere(sensor);
		}
		sensores.apresenta();

		
		do {
			int
			System.out.println("Deseja realizar alguma busca através no número de coordenada?" +  
			"\nDigite 1 para SIM, ou 0 para NÃO.");

		} while (condition:var(boolean));

	}

}