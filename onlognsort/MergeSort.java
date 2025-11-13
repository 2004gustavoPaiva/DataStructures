import java.util.Arrays;
import java.util.Scanner;

public class MergeSort{


	public static void mergeSort(int[] v, int left, int right){
		System.out.println(Arrays.toString(Arrays.copyOfRange(v, left, right + 1)));

		

		if (left >= right){
			return;
		}else{
	
			int mid = (right + left)/ 2;
		
			mergeSort(v, left, mid);
			mergeSort(v, mid + 1, right);

			merge(v, left, right);
		}

		System.out.println(Arrays.toString(Arrays.copyOfRange(v, left, right + 1)));
	}

	public static void merge(int[] v, int left, int right){
		
		int rightHelper = right - left;
		int[] aux = new int[rightHelper + 1];
		for (int i = 0; i<= rightHelper; i++){
			aux[i] = v[left+i];
		}

		int mid = rightHelper / 2;
		int i = 0;
		int j = mid + 1;
		int k = left;

		while (i<=mid && j<=rightHelper){

			if (aux[i] <= aux[j]){
				v[k] = aux[i];
				i++;
			}else{
				v[k] = aux[j];
				j++;
			}
			k++;
		}

		while (i<=mid){
			v[k] = aux[i];
			i++;
			k++;
		}
	}
	
	
	public static void main(String[] args){

                Scanner sc = new Scanner(System.in);

                String linha = sc.nextLine();

                int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();


		mergeSort(array, 0, array.length-1);


        }

}
