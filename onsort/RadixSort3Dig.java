import java.util.Arrays;
import java.util.Scanner;

public class RadixSort3Dig{

	public static void radixSort(int[] v, int d){

		if (v.length == 0){
			return;
		}

		int max = v[0];

		for (int i = 0; i < v.length; i++){

			if (v[i] > max){
				max = v[i];
			}
		}

		int place = 1;


		while(max/place > 0){

			countingSort(v, place);
			place *= 1000;
			System.out.println(Arrays.toString(v));

		}

	}
	public static void countingSort(int[] a, int place){

		int[] c = new int[1000];
		
		for (int i = 0; i < a.length; i++){
			int digit = (a[i] / place) % 1000;
			c[digit]+=1;
		}

		for (int i = 1; i < 1000; i++){

			c[i] += c[i-1];
		}
	
		int[] b = new int[a.length];

		for (int i = a.length -1; i >= 0; i--){
			int digit = (a[i] / place) % 1000;
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
