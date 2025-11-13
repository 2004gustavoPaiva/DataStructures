import java.util.Arrays;
import java.util.Scanner;

public class QuickSort{

	public static void quickSort(int[] v,int left,int right){

		if (left < right){
			int i = partition(v, left, right);
			for (int z = 0; z < v.length; z++) {
    			System.out.print(v[z]);
    			if (z < v.length - 1) System.out.print(" ");
			}
			System.out.println();
			quickSort(v, left, i-1);
			quickSort(v, i + 1, right);
		
		}
	
	}


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
		return i;
	}
		

public static void main(String[] args){

                Scanner sc = new Scanner(System.in);

                String linha = sc.nextLine();

                int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();


                quickSort(array, 0, array.length-1);


        }
}
