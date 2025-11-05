import java.util.Arrays;
import java.util.Scanner;


public  class InsertionRecursivo{

	public  static void  insereUltimo(int[] v, int i, int j){
		if (i == v.length){
			return;
		}
		
		
		if(j>0 && v[j-1]>v[j]){
			int aux = v[j];
			v[j] = v[j-1];
			v[j-1] = aux;
			insereUltimo(v, i, j-1);
		}else{
			System.out.println(Arrays.toString(v));
			insereUltimo(v, i+1, i+1);
		}
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String linha = sc.nextLine();

		int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();


		insereUltimo(array, 1, 1);
		
		sc.close();	
	}
}
