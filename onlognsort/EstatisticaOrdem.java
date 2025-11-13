import java.util.Scanner;
import java.util.Arrays;

public class EstatisticaOrdem{

	public static int partition(int[] v, int left, int right){

		int pivot = v[left];

		int i = left;

		for (int j = left + 1; j<= right; j++){

			if (v[j] <= pivot){
				i+=1;
				int aux = v[j];
				v[j] = v[i];
				v[i] = aux;
			}
	
		}
		v[left] = v[i];
		v[i] = pivot;
		return i+1;
	}
	

	public static void swap(int[] v, int i, int j){

		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		String linha = sc.nextLine();

                int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();

		System.out.println(partition(array, 0, array.length -1));
		

	}

}
