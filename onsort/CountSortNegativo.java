import java.util.Arrays;
import java.util.Scanner;

public class CountSortNegativo{

	public static int[] countSort(int[] a, int k, int menor){
		
		int[] c = new int[k-menor + 1];

		for (int i = 0; i<a.length; i++){
			c[a[i]-menor] += 1;
			System.out.println(Arrays.toString(c));
		}


		for (int i = 1; i < c.length; i++){
			c[i] += c[i-1];
		}
		
		System.out.println("Cumulativa do vetor de contagem - " +Arrays.toString(c));

		int[] b = new int[a.length];

		for (int i = a.length -1; i >= 0; i--){
			b[c[a[i]-menor]-1] = a[i];
			c[a[i]-menor] -=1;

		}
		
		System.out.println(Arrays.toString(c));

		return b;
	}
		
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

                String linha = sc.nextLine();

                int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int k = sc.nextInt();
		
		int menor  = sc.nextInt();

		sc.close();
		
		System.out.println(Arrays.toString(countSort(array, k, menor)));

	}
}
