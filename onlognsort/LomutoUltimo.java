import java.util.Arrays;
import java.util.Scanner;

public class LomutoUltimo{

	
	public static int partition(int[] v, int left, int right){

		int pivot = v[right];
		int i = right;
		for (int j = right - 1; j >= left; j--){

			if (v[j]>=pivot){
				i-=1;
				int aux = v[j];
				v[j] = v[i];
				v[i] = aux;
			System.out.println(Arrays.toString(v));
			}
		}
	
		v[right] = v[i];
		v[i] = pivot;
		System.out.println(Arrays.toString(v));
		return i;
	}



	public static void main(String[] args){

                Scanner sc = new Scanner(System.in);

                String linha = sc.nextLine();

                int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();


                partition(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));

        }

}
