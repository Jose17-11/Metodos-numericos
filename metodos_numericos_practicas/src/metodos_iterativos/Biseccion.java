package metodos_iterativos;
import java.text.DecimalFormat;
import java.util.Scanner;
import org.nfunk.jep.JEP;
import com.singularsys.jep.JepException;
public class Biseccion {
	double re;
	public void Principal() throws JepException {
		//Primer paso asignarles los valores requeridos para poder resolver las ecuaciones no lineales mediante el metodo de biseccion
		Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la funcion: ");
        String funcion=sc.nextLine();
        System.out.println("Ingrese el intervalo [a, b]: \n");
        System.out.print("Ingrese el intervalo [a]: ");
        double xi = sc.nextDouble();
        System.out.print("Ingrese el intervalo [b]: ");
        double xf = sc.nextDouble();
        System.out.print("Ingrese el numero de iteraciones: ");
        int nIteraciones = sc.nextInt();
        System.out.print("Ingrese el error permitido: ");
        double errorPermitido = sc.nextDouble();

		System.out.println("\n\n-----------------------------------------------------");
		System.out.println("|                 Metodo de Biseccion                |");
		System.out.println("-----------------------------------------------------");
        //Se crea el objeto respuesta para poder pasarle los parametros a los metodos biseccion 
        Biseccion respuesta=new Biseccion();
        respuesta.biseccion(funcion, xi, xf, nIteraciones, errorPermitido);
	}
	
	/*Metodo biseccion que nos resolvera las ecuaciones no lineales mediante el metodo de biseccion aplicado en el mismo
		
		El metodo recibe los parametros ingresados en el metodo main o principal
	*/
	public void biseccion(String funcion, double x_i, double x_f, int n, double error_permitido)throws JepException{
		//Se crea el objeto function para poder mandarle los parametros que se requieran al metodo evaluar para poder evaluar todas las funciones requeridas
		Main function=new Main();
		//Inicializar variables
		double solucion=0;
		int contador=0;
		double error_calculado=100;
		//Se mandan los primeros parametros al metodo evaluar para evaluar la funcion de xi y la funcion de xf
		double f_xi=function.evaluar(funcion, x_i);
		double f_xf=function.evaluar(funcion, x_f);
		//Evaluar si esta la raiz dentro de lo intervalos
		if(f_xi*f_xf<0) {
			/*Calcular la solucion haciendo un ciclo que es "mientras el contador sea menor al numero de iteraciones permitidas y el error calculado 
			 * sea mayor al error permitido seguir con el ciclo"
			 */
			while(contador<=n && error_calculado>=error_permitido) {
				//El contador acumulara las iteraciones que se vayan aumentando hasta conseguir la raiz 
				contador +=1;
				
				solucion=(x_i+x_f)/2;
				error_calculado=((solucion-x_i)/solucion)*100;
				error_calculado=(Math.abs(error_calculado));
				//Redefinir el nuevo intervalo calculando primero la funcion de la solucion
				double f_solucion=function.evaluar(funcion, solucion);
				if(f_xi*f_solucion>0) {
					x_i=solucion;
				}else {
					x_f=solucion;
				}
				f_solucion=Math.abs(f_solucion);
				//Creamos el objeto de la libreria DecimalFormat que nos ayuda a elegir cuantos decimales quedremos
				DecimalFormat deci=new DecimalFormat("#0.00000000000000000000000000000");
				//Dentro del ciclo nos ira mostrando cada calculo miestras mas se acerca a la solucion mas aproximada
				
				System.out.println("-----------------------------------------------------");
				System.out.println("|           Encontrada en: "+contador+" iteraciones            |");
				System.out.println("-----------------------------------------------------");
				System.out.println("|Punto inicial:                            "+deci.format(x_i));
				System.out.println("-----------------------------------------------------");
				System.out.println("|Punto final:                              "+deci.format(x_f));
				System.out.println("-----------------------------------------------------");
				System.out.println("|La solucion aproximada es:                "+deci.format(solucion));
				System.out.println("-----------------------------------------------------");
				System.out.println("|Funcion evaluada:                         "+deci.format(f_solucion));
				System.out.println("-----------------------------------------------------");
				System.out.println("|Funcion evaluada en valor absoluto:       "+deci.format((f_solucion)));
				System.out.println("-----------------------------------------------------");
				System.out.println("|Con un error relativo de:                 "+deci.format(error_calculado)+"%");
				System.out.println("-----------------------------------------------------\n\n");
				
				
			}
		}else {
			System.out.println("Funcion evaluada en xi: "+f_xi);
			System.out.println("Funcion evaluada en xf: "+f_xf);
			System.out.println("La raiz no se encuentra entre esos intervalos");
		}
		
	}
	
	/*
	 * Fuentes informativas
	 * Diseño de algoritmo:	https://www.youtube.com/watch?v=8KuOrn2j2rw		https://www.youtube.com/watch?v=9fGsN33nEng&t=346s
	 * Libro: Metodos numericos para ingenieros
	 * Autor: Steven C. Chapra, Raymond P. Canale
	 * Pagina: 124
	 * Explicacion en clase por Ing. Electrico Saul Ulloa Mondragon
	 * */
	
	
}


/**
 * Metodo de biseccion
 * 
 * F(x)=X^3+2X^2+10x-20
 * 		x^3+2x^2+10x-20
 * La tabla va a tener cabeceras 	i,	Xi,		Xd, 	Xm,	Abs	Xmi-Xmi+1	f(Xm)  Absf(Xm)
 * 
 * 
 * 
 * */



