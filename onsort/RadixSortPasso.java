import java.util.Arrays;
import java.util.Scanner;

public class RadixSortPasso{

	public static void radixSort(int[] v, int d){

		if (v.length == 0){
			return;
		}



		int place = 1;


		for (int i = 0; i < d; i++){
			countingSort(v, place);
			System.out.println(Arrays.toString(v));
			place *= 10;

		}

	}
	public static void countingSort(int[] a, int place){

		int[] c = new int[10];
		
		for (int i = 0; i < a.length; i++){
			int digit = (a[i] / place) % 10;
			c[digit]+=1;
		}

		for (int i = 1; i < 10; i++){

			c[i] += c[i-1];
		}
	
		int[] b = new int[a.length];

		for (int i = a.length -1; i >= 0; i--){
			int digit = (a[i] / place) % 10;
			b[c[digit] - 1] = a[i];
			c[digit] -= 1;
		}
		

		for (int i = 0; i < a.length; i++){
			a[i] = b[i];
		}
	}


	public static void main(String[] args){

                Scanner sc = new Scanner(System.in);

                String linha = sc.nextLine();

                int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();

                int d  = sc.nextInt();

                sc.close();

		radixSort(array, d);


        }

}
