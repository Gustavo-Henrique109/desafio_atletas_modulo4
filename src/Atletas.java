import java.util.Locale;
import java.util.Scanner;

public class Atletas {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n, qtdHomens = 0, qtdMulheres = 0;
		double altura, peso, pesoMedio = 0, somaPesos = 0, maiorAltura = 0, percentHomens = 0, altMedMulheres = 0,
				somaAlturaMulheres = 0;
		String nome, sexo, maisAlto = null;

		System.out.print("Qual a quantidade de atletas? ");
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			System.out.printf("Digite os dados do atleta numero %d:\n", i + 1);
			System.out.print("Nome: ");
			sc.nextLine();
			nome = sc.nextLine();

			System.out.print("Sexo: ");
			sexo = sc.nextLine();
			while (!sexo.equals("F") && !sexo.equals("M")) {
				System.out.print("Valor invalido! Favor digitar F ou M: ");
				sexo = sc.nextLine();
			}

			System.out.print("Altura: ");
			altura = sc.nextDouble();
			while (altura <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				altura = sc.nextDouble();
			}

			System.out.print("Peso: ");
			peso = sc.nextDouble();
			while (peso <= 0) {
				System.out.print("Valor invalido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();
			}
			
			if (altura > maiorAltura) {
				maisAlto = nome;
				maiorAltura = altura;
			}

			if (sexo.equals("M")) {
				qtdHomens++;
			} else {
				qtdMulheres++;
				somaAlturaMulheres += altura;
			}
			
			somaPesos += peso;
		}

		pesoMedio = somaPesos / n;
		percentHomens = qtdHomens * 100.0 / n;

		System.out.println("\nRELATÓRIO:");
		System.out.printf("Peso médio dos atletas: %.2f\n", pesoMedio);
		System.out.printf("Atleta mais alto: %s\n", maisAlto);
		System.out.printf("Porcentagem de homens: %.1f %%\n", percentHomens);

		if (qtdMulheres == 0) {
			System.out.println("Não há mulheres cadastradas");
		} else {
			altMedMulheres = somaAlturaMulheres / qtdMulheres;
			System.out.printf("Altura média das mulheres: %.2f\n", altMedMulheres);
		}

		sc.close();
	}
}
