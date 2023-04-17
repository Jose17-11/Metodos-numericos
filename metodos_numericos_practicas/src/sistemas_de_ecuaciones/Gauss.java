package sistemas_de_ecuaciones;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Gauss {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Double[][] array=new Double[3][4];
		DecimalFormat deci=new DecimalFormat("#0.00");
	
		// Ciclo do while que hace que el usuario ingrese de manera correcta la matriz
		do {
			System.out.println("Ingrese la funcion que inicie con un numero diferente de cero");
			// Ciclos for anidados para ingresar los datos de la matriz
			for(int i=0; i<3; i++){
				System.out.println("Ingrese los coeficientes de la funcion: " + (i+1) + ", con su resultado");
				for(int j=0; j<4; j++) {
					Double num=sc.nextDouble();
					array[i][j]=num;
				}
				System.out.print("");
			}
			System.out.println("");
		}while(array[0][0]==0);
		
		//Condicion if que analisa si la matriz es o no es una: "matriz triangular superior unitaria"
		if((array[0][0]!=1) || (array[1][1]!=1) || (array[2][2]!=1) || (array[1][0]!=0) || (array[2][0]!=0) || (array[2][1]!=0)) {
			//Condicion if que modifica la posicion "0,0"a uno
			if(array[0][0]!=1) {
				array[0][3]=(array[0][3]/array[0][0]);
				array[0][2]=(array[0][2]/array[0][0]);
				array[0][1]=(array[0][1]/array[0][0]);
				array[0][0]=(array[0][0]/array[0][0]);
			}
			//Condiciones if que modifican la pocision "1,0" a cero
			if(array[1][0]!=0) {
				array[1][3]=(array[1][3]-(array[1][0]*array[0][3]));
				array[1][2]=(array[1][2]-(array[1][0]*array[0][2]));
				array[1][1]=(array[1][1]-(array[1][0]*array[0][1]));
				array[1][0]=(array[1][0]-(array[1][0]*array[0][0]));
			}
			
			//Condiciones if que modifican la pocision "2,0" a cero
			if(array[2][0]!=0) {
				array[2][3]=(array[2][3]-(array[2][0]*array[0][3]));
				array[2][2]=(array[2][2]-(array[2][0]*array[0][2]));
				array[2][1]=(array[2][1]-(array[2][0]*array[0][1]));
				array[2][0]=(array[2][0]-(array[2][0]*array[0][0]));
			}
			
			
			//Condicion if para modificar la posicion "1,1" a uno
			if(array[1][1]!=1) {
				array[1][3]=(array[1][3]/array[1][1]);
				array[1][2]=(array[1][2]/array[1][1]);
				array[1][1]=(array[1][1]/array[1][1]);
				array[1][0]=(array[1][0]/array[1][1]);
			}
			
			
			//Condicion if para modificar la posicion "2,1" a cero
			if(array[2][1]!=0) {
				array[2][3]=(array[2][3]-(array[2][1]*array[1][3]));
				array[2][2]=(array[2][2]-(array[2][1]*array[1][2]));
				array[2][1]=(array[2][1]-(array[2][1]*array[1][1]));
				array[2][0]=(array[2][0]-(array[2][1]*array[1][0]));
			}
			
			
			//Condicion if para modificar la posicion "2,2" a uno
			if(array[2][2]!=1) {
				array[2][3]=(array[2][3]/array[2][2]);
				array[2][2]=(array[2][2]/array[2][2]);
				array[2][1]=(array[2][1]/array[2][2]);
				array[2][0]=(array[2][0]/array[2][2]);
			}
			
			
			//Condicion if para modificar la posicion "0,1" a cero
			if(array[0][1]!=0) {
				array[0][3]=(array[0][3]-(array[0][1]*array[1][3]));
				array[0][2]=(array[0][2]-(array[0][1]*array[1][2]));
				array[0][1]=(array[0][1]-(array[0][1]*array[1][1]));
				array[0][0]=(array[0][0]-(array[0][1]*array[1][0]));
			}
			
			
			//Condicion if para modificar la posicion "0,2" a cero
			if(array[0][2]!=0) {
				array[0][3]=(array[0][3]-(array[0][2]*array[2][3]));
				array[0][2]=(array[0][2]-(array[0][2]*array[2][2]));
				array[0][1]=(array[0][1]-(array[0][2]*array[2][1]));
				array[0][0]=(array[0][0]-(array[0][2]*array[2][0]));
			}
			
			
			//Condicion if para modificar la posicion "0,2" a cero
			if(array[1][2]!=0) {
				array[1][3]=(array[1][3]-(array[1][2]*array[2][3]));
				array[1][2]=(array[1][2]-(array[1][2]*array[2][2]));
				array[1][1]=(array[1][1]-(array[1][2]*array[2][1]));
				array[1][0]=(array[1][0]-(array[1][2]*array[2][0]));
			}
			// invertidas \\ 
		}
			
		System.out.println();
		 
		//Ciclo for para imprimir la matriz con sus respectivas soluciones
		System.out.println("Matriz 3x3");
		for(int i=0; i<3; i++){
			for(int j=0; j<4; j++) {
				if(j==3) {
					System.out.print("| ");
				}
				System.out.print(array[i][j]+" ");
	
				}
			System.out.println();
		}
		
		//Se le asigna las variables x, y, z para imprimir los resultados finales
		Double x, y, z;
		x=(array[0][3]);
		y=(array[1][3]);
		z=(array[2][3]);
		System.out.println("\nEl valor de \"X\" es : " + deci.format(x));
		System.out.println("El valor de \"Y\" es : " + deci.format(y));
		System.out.println("El valor de \"Z\" es : " + deci.format(z));
		}
}
