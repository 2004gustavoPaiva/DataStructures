import java.util.Arrays;
import java.util.Scanner;

public class MelhorPivot{

	public static int verificaMelhorPivot(int[] v, int i, int j){

		int maxi = 0;
		int mini = 0;
		int maxj = 0;
		int minj = 0;
		for (int z = 0; z < v.length; z++){

			if (v[z] < v[j]){
				minj +=1;
			}else if (v[z] > v[j]){
				maxj +=1;
			}

			if (v[z] < v[i]){
				mini += 1;
			}else if (v[z] > v[i]){
				maxi += 1;
			}
		}

		int difI = Math.abs(maxi - mini);
		int difJ = Math.abs(maxj - minj);
	
		if (difI <= difJ){
			return i;
		}else{
			return j;
		}
	}
public static void main(String[] args){

                Scanner sc = new Scanner(System.in);

                String linha = sc.nextLine();

                int[] array = Arrays.stream(linha.split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int i = sc.nextInt();
		int j = sc.nextInt();

                System.out.println(verificaMelhorPivot(array, i, j));
		

        }
}
