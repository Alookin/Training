import java.util.Scanner;

public class TempsCuisson {
	
	static final int BOEUF = 1;
	static final int PORC = 2;
	
	static final int BLEU = 1;
	static final int APOINT = 2;
	static final int BIENCUIT = 3;
	
	public static void main(String[] args) {

		
		int tempsCuisson = 0;
		
		System.out.println("Type de viande ? :");
		System.out.println("1 = Boeuf, 2 = Porc");
		
		int typeViande = saisirInt();
		
		System.out.println("Mode de cuisson ? :");
		System.out.println("1 = Bleu, 2 = A point, 3 = Bien cuit");
		
		int modeCuisson = saisirInt();
		
		System.out.println("Poids en grammes ? :");
		int poids = saisirInt();
		
		if(typeViande == BOEUF) 
		{
			switch(modeCuisson)
			{
			case BLEU:
				tempsCuisson = (int)(poids * 10 / 500f * 60);
				break;
				
			case APOINT:
				tempsCuisson = (int)(poids * 17 / 500f * 60);
				break;
				
			case BIENCUIT:
				tempsCuisson = (int)(poids * 25 / 500f * 60);
				break;
				
			default:
				System.out.println("Mode de cuisson invalide");
			}
		}
		else if(typeViande == PORC)
		{
			switch(modeCuisson)
			{
			case BLEU:
				tempsCuisson = (int)(poids * 15 / 400f * 60);
				break;
				
			case APOINT:
				tempsCuisson = (int)(poids * 25 / 400f * 60);
				
				break;
				
			case BIENCUIT:
				tempsCuisson = (int)(poids * 40 / 400f * 60);
				break;
				
			default:
				System.out.println("Mode de cuisson invalide");
			}
		}
		else System.out.println("Type de viande invalide");
		
		if(tempsCuisson > 0) System.out.println("Il vous faut " + tempsCuisson + " secondes");
	}

	public static int saisirInt()
	{
		Scanner scan = new Scanner(System.in);
		int result = scan.nextInt();
		return result;
	}
	
}
