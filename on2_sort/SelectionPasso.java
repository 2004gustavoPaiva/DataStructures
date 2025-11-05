import java.util.Arrays;
import java.util.Scanner;

public class SelectionPasso{

	public static void selection(int[] v){
		for (int i = 0; i<v.length; i++){
			int menor = i;
			for (int j = i; j<v.length; j++){
				if(v[j] < v[menor]){
					menor = j;
				}
			}

			int aux = v[i];
			v[i] = v[menor];
			v[menor] = aux;
			if (menor !=  i){	
				System.out.println(Arrays.toString(v));
				
			}
		}

	}


	public static void main(String[] args){
           	Scanner sc = new Scanner(System.in);
               
               	String linha = sc.nextLine();

               	int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();

               selection(array);                
               sc.close();     
        	
	

	}

}	
