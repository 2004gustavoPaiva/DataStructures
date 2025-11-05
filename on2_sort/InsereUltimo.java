import java.util.Arrays;
import java.util.Scanner;


private class InsereUltimo{

	public static void insereUltimo(int[] v){

		int i = v.length - 1;
		while (i>0 && v[i] < v[i-1]){
			int aux = v[i];
			v[i] = v[i-1];
			v[i-1] = aux;
			i-=1;
		}
	
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String linha = sc.nextLine();

		int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();



		insereUltimo(array);

		System.out.println(Arrays.toString(array));

	
	}
}
