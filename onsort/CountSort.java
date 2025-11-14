import java.util.Arrays;
import java.util.Scanner;

public class CountSort{

	public static int[] countSort(int[] a, int k){
		
		int[] c = new int[k+1];

		for (int i = 0; i<a.length; i++){
			c[a[i]] += 1;
			for (int j = 0; j < c.length; j++){
				System.out.print(c[j]);		
				if (j < c.length - 1) System.out.print(" ");
                        }
			System.out.println();
		}

		for (int i = 1; i < c.length; i++){
			c[i] += c[i-1];
		}
		
		System.out.print("Cumulativa do vetor de contagem - ");

		for (int j = 0; j < c.length; j++){
                                System.out.print(c[j]);
                                if (j < c.length - 1) System.out.print(" ");
                        }
                        System.out.println();

		int[] b = new int[a.length];

		for (int i = a.length -1; i >= 0; i--){
			b[c[a[i]]-1] = a[i];
			c[a[i]] -=1;

		}
		
		for (int j = 0; j < c.length; j++){
                                System.out.print(c[j]);
                                if (j < c.length - 1) System.out.print(" ");
                        }
                        System.out.println();
		return b;
	}
		
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

                String linha = sc.nextLine();

                int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int k = sc.nextInt();

		sc.close();
		
		int[] c = countSort(array, k);
		
		for (int j = 0; j < c.length; j++){
                                System.out.print(c[j]);
                                if (j < c.length - 1) System.out.print(" ");
                        }
                        System.out.println();
		

	}
}
