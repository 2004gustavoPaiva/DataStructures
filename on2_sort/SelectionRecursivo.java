import java.util.Arrays;
import java.util.Scanner;

public class SelectionRecursivo{

	public static void selection(int[] v, int i, int j, int menor){
		if (i == v.length-1) return;

		if (j<v.length){
			if (v[j] < v[menor]){
				selection(v, i, j+1, j); 
			}else{
				selection(v, i, j+1, menor);
			}

		}else{
			int aux = v[i];
			v[i] = v[menor];
			v[menor] = aux;
			System.out.println(Arrays.toString(v));
			int prox = i + 1;
			selection(v, prox, prox+1, prox);
		}

	}

	public static void main(String[] args){
           	Scanner sc = new Scanner(System.in);
               
               	String linha = sc.nextLine();

               	int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();

               selection(array, 0, 1, 0);                
               sc.close();     
        	
	

	}

}
