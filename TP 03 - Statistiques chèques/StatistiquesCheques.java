import java.util.Scanner;

public class StatistiquesCheques {

	public static void main(String[] args) {

		
		int totalNbCheques = 0;
		float totalMtCheques = 0;
		
		int nbInf = 0;
		float mtInf = 0;
		
		int noPetit = 0;
		float mtPetit = 0;
		
		int noGrand = 0;
		float mtGrand = 0;
		
		int numCheque = saisirInt("Saisir le num�ro de ch�que : ");
		while(numCheque > 0)
		{
			float mtCheque = saisirFloat("Saisir le montant du ch�que " + numCheque + " : ");
			
			totalNbCheques++;
			totalMtCheques += mtCheque;
			
			if(mtCheque < 200f) 
			{
				nbInf++;
				mtInf += mtCheque;
			}
			
			if((mtPetit == 0) || (mtCheque < mtPetit))
			{
				noPetit = numCheque;
				mtPetit = mtCheque;
			}
			
			if((mtGrand == 0) || (mtCheque > mtGrand))
			{
				noGrand = numCheque;
				mtGrand = mtCheque;
			}
			
			numCheque = saisirInt("Saisir le num�ro de ch�que : ");
		}
		
		if(totalNbCheques > 0)
		{
			System.out.println("");
			System.out.println("Nombre de ch�ques introduits : " + totalNbCheques);
			System.out.println("Montant total des ch�ques : " + totalMtCheques);
			System.out.println("Moyenne des montants : " + (totalMtCheques / totalNbCheques));
			System.out.println("");
			System.out.println("Nombre de ch�ques < 200 : " + nbInf);
			System.out.println("Montant des ch�ques < 200 : " + mtInf);
			System.out.println("");
			System.out.println("Nombre de ch�ques >= 200 : " + (totalNbCheques - nbInf));
			System.out.println("Montant des ch�ques >= 200 : " + (totalMtCheques - mtInf));
			System.out.println("");
			System.out.println("Ch�que le plus petit : " + noPetit + " = " + mtPetit);
			System.out.println("Ch�que le plus grand : " + noGrand + " = " + mtGrand);
		}
		else 
		{
			System.out.println("");
			System.out.println("Aucun ch�que n'a �t� entr�");
		}
		
	}

	private static String saisirString(String message)
	{
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	private static int saisirInt(String message)
	{
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	private static float saisirFloat(String message)
	{
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextFloat();
	}
	
}
