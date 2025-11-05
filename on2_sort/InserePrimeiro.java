import java.util.Arrays;
import java.util.Scanner;


public class InserePrimeiro{

	public static void inserePrimeiro(int[] v){

		int i = 0;
		while (i<v.length-1 && v[i] > v[i+1]){
			int aux = v[i];
			v[i] = v[i+1];
			v[i+1] = aux;
			i+=1;
		}
	
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String linha = sc.nextLine();

		int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();



		inserePrimeiro(array);

		System.out.println(Arrays.toString(array));

	
	}
}
