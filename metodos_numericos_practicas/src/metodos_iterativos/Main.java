package metodos_iterativos;
import java.util.Scanner;
import org.nfunk.jep.JEP;
import com.singularsys.jep.JepException;

public class Main {
	Double re;

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int x = 0;

		do {

			System.out.println("-----------------------------------------------------");
			System.out.println("|**********    Menu de metodos numericos   **********|");
			System.out.println("-----------------------------------------------------");
			System.out.println("|1. Metodo de Biseccion:                             |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|2. Metodo de Newton Raphson:                        |");
			System.out.println("-----------------------------------------------------");
			System.out.println("|3. Salir:                                           |");
			System.out.println("-----------------------------------------------------");
			x = leer.nextInt();

			Biseccion metodoB = new Biseccion();
			NewtonRaphson metodoN = new NewtonRaphson();
			switch (x) {
			case 1:
				System.out.println("\nMetodo de Biseccion");
				try {
					metodoB.Principal();
				} catch (JepException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("\nMetodo de Newton Raphson");
				try {
					metodoN.Principal();
				} catch (JepException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:

				System.out.println("-----------------------------------------------------");
				System.out.println("|                 Adios vuelva pronto                |");
				System.out.println("-----------------------------------------------------");
				break;
			default:

				System.out.println("\n\n-----------------------------------------------------");
				System.out.println("|         Elige una de las opciones: 1, 2 o 3        |");
				System.out.println("-----------------------------------------------------");
			}
		} while (x != 3);

	}

	// Funcion que se encarga de evaluar las diferentes funciones mediante
	// parametros de otros metodos
	public double evaluar(String f, double p) throws JepException {
		String fu = f;
		double pa = p;
		JEP j = new JEP();
		j.addStandardConstants();
		j.addStandardFunctions();
		j.addVariable("x", pa);
		j.parseExpression(fu);

		// Si existiere algun error.
		if (j.hasError()) {
			// System.out.println(j.getErrorInfo()); // Imprimir error.
		}

		// System.out.println(j.getValue()); //Imprimir resultado.
		re = j.getValue();
		return re;
	}

}
