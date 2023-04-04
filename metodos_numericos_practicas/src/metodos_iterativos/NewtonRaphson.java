package metodos_iterativos;
import java.text.DecimalFormat;
import java.util.Scanner;
import org.nfunk.jep.JEP;
import com.singularsys.jep.JepException;
public class NewtonRaphson {
	double re;
	public void Principal() throws JepException {
		//Primer paso asignarles los valores requeridos para poder resolver las ecuaciones no lineales mediante el metodo de Newton Raphson
		Scanner leer = new Scanner(System.in);
		Double xi,xf;
		String funcion, derivada, S_derivada;
		
		
        
        System.out.println("Ingrese la funcion: ");
        funcion=leer.nextLine();
        System.out.println("Ingrese la derivada de la funcion: ");
        derivada=leer.nextLine();
        System.out.println("Ingrese la segunda derivada de la funcion: ");
        S_derivada=leer.nextLine();
		
		System.out.println("Ingrese el intervalo [a, b]: \n");
        System.out.print("Ingrese el intervalo [a]: ");
        xi = leer.nextDouble();
        System.out.print("Ingrese el intervalo [b]: ");
        xf = leer.nextDouble();
        System.out.print("Ingrese el numero de iteraciones: ");
        int nIteraciones = leer.nextInt();
        

		System.out.println("\n\n-----------------------------------------------------");
		System.out.println("|              Metodo de Newton Raphson              |");
		System.out.println("-----------------------------------------------------");
        //Se crea el objeto respuesta para poder pasarle los parametros al metodo newton 
        NewtonRaphson respuesta=new NewtonRaphson();
        respuesta.newton(funcion, derivada, S_derivada , xi, xf, nIteraciones);
	}
	
	/*
		El metodo recibe los parametros ingresados en el metodo main o principal
	*/
	public void newton(String funcion, String derivada, String S_derivada,  double x_i, double x_f, int n)throws JepException{
		//Se crea el objeto function para poder mandarle los parametros que se requieran al metodo evaluar para poder evaluar todas las funciones requeridas
		//en nuestro metodo numerico
		Main function=new Main();
		//Inicializar variables
		double solucion=0;
		int contador=0;
		double x0=0;
		double xu=0;
		//Se mandan los primeros parametros al metodo evaluar para evaluar la funcion de xi y la funcion de xf
		double f_xi=function.evaluar(funcion, x_i);
		double f_xf=function.evaluar(funcion, x_f);
		//Evaluar si esta la raiz dentro de los intervalos
		if(f_xi*f_xf<0) {
			
			
			while(contador<=n) {
				double j=x_i;
				//Se evaluan la funcion la primer derivada y la segunda derivada con respecto a x_i
				double f_solucion=function.evaluar(funcion, x_i);
				double f_derivada=function.evaluar(derivada, x_i);
				double f_s_derivada=function.evaluar(S_derivada, x_i);
				
				
				//Se evalua la solucion aproximada mediante la formula vista en clase
				solucion=1-((f_derivada*f_derivada)-(f_solucion*f_s_derivada))/(f_derivada*f_derivada);
				solucion=Math.abs(solucion);
				
				
				//Creamos el objeto de la libreria DecimalFormat que nos ayuda a elegir cuantos decimales quedremos
				DecimalFormat deci=new DecimalFormat("#0.00000000000000000000");
				//Dentro del ciclo nos ira mostrando cada calculo miestras mas se acerca a la solucion mas aproximada
				System.out.println("-----------------------------------------------------");
				System.out.println("|           Encontrada en: "+contador+" iteraciones            |");
				System.out.println("-----------------------------------------------------");
				System.out.println("|Punto inicial:                           "+deci.format(j));
				System.out.println("-----------------------------------------------------");
				System.out.println("|Valor de (xi+1):                         "+deci.format(x0));
				System.out.println("-----------------------------------------------------");
				System.out.println("|Valor de (xi+1-xi):                      "+deci.format(xu));
				System.out.println("-----------------------------------------------------");
				
				x_i=x_i-(f_solucion/f_derivada);
				x0=x_i-(f_solucion/f_derivada);
				xu=Math.abs(x0-x_i);
				
				System.out.println("|Funcion evaluada:                        "+deci.format(f_solucion));
				System.out.println("-----------------------------------------------------");
				System.out.println("|Derivada evaluada:                       "+deci.format(f_derivada));
				System.out.println("-----------------------------------------------------");
				System.out.println("|Segunda derivada evaluada:               "+deci.format(f_s_derivada));
				System.out.println("-----------------------------------------------------");
				System.out.println("|La solucion aproximada es:               "+solucion);
				System.out.println("-----------------------------------------------------\n\n");
				
				contador +=1;
			}
		}else {
			System.out.println("La raiz no se encuentra entre esos intervalos");
		}
		
	}
	/*
	 * Fuentes informativas 
	 * Pagina de la libreria: https://codigosdeabner.blogspot.com/2017/03/evaluar-funciones-en-java.html?m=1
	 * Libro: Metodos numericos para ingenieros
	 * Autor: Steven C. Chapra, Raymond P. Canale
	 * Pagina: 124
	 * Explicacion en clase por Ing. Electrico Saul Ulloa Mondragon
	 * Y esta basado en el programa de biseccion realiado antes
	 * 
	 * 
	 * */
	
}




		
		/*
		 * Metodo de Newton Raphson
		 * 
		 * Es un metodo de segundo orden de convergencia cuando se trata de raices reales no repetidas. Lleva la ecuacion: f(x)=0 a la forma x=g(x), de modo 
		 * que g´ de Xi.
		 * 
		 * 
		 * f(x)=0
		 * 
		 * x=g(x)
		 * 
		 * g´=(Xi-) Guion arriba o x barra
		 * 
		 * se supone un valor inicial X0 que se situa en el eje horizontal; Se traza una tangente a la curva en el punto (X0, f(X0))
		 * 
		 * y a partir de ese punto se sigue por la tangente hasta intersectar al eje x; el punto de corte X1 es una nueva aproximacion a X-. El proceso 
		 * se repite con X1 obteniendo una nueva aproximacion a X2 y asi sucesivamente, hasta que un valor X1 satisfaga |f(Xi)<=E|, |Xi+1-Xi|<E o ambos
		 * 
		 * 
		 * Algoritmo
		 * 
		 * 1.	X1=X0-deltaX		
		 * 2.	F´(X0)= F(X0)/deltaX
		 * 
		 * 3.	X1=X0-F(X0)/F´(X0)
		 * 
		 * 
		 * Este metodo es de orden 2, porque g´(X-)
		 * 
		 * Ejemplo: Encuentre una raiz real de la ecuacion: 
		 * 
		 * F(x)=x^3+2x^2+10x-20 mediante el metodo de Newton rapzhon
		 * 
		 * X0=1
		 * 
		 * E=0.001
		 *
		 * |Xi+1-Xi|<E
		 *
		 * 		i		Xi				|Xi+i|		|g´(Xi)|
		 * 
		 * 		0		1.00000			0			0.2421
		 * 		1		1.41176			0.41176
		 * 		2		1.36934			0.04242
		 * 		3
		 * 		4
		 * 
		 * 		
		 * 		Formulas para implementar en el proceso
		 * 		xi+1=	xi-(f(xi)/f´(xi))
		 * 
		 * 		abs(xi+1-xi)=	abs(xi+1-xi)
		 * 
		 * 		Valores que se le pediran al usuario:
		 * 		xi, funcion, derivada y segunda derivada
		 * 		
		 * 		i	xi				xi+1		abs(xi+1-xi)		f(xi)		f´(xi)			f''(xi)			       valor absoluto
		 * 		0	1												-7			17				10						0.24221							
		 * 		1	1.41176			1.82353		0.41176				0.91757		21.62630		12.47059				0.02447																				
		 * 		2	1.36934			1.32691		0.04243				0.01115		21.10259		12.21203				0.00031																													
		 * 		3	1.36881			1.36828		0.00053				0.00000		21.09614		12.21285				0.00000									
		 * 		4	1.36881			1.36881		0.00000				0.00000		21.09614		12.21285				0.00000									
		 * 		5	1.36881			1.36881		0.00000				0.00000		21.09614		12.21285				0.00000		
		 * 	
		 * 		Datos: 		x^3+2x^2+10x-20 	3x^2+4x+10		6x+4
		 * 
		 */
		
		
		/*
		 * Regla falsa, secante y newton rapzon
		 */
	


   