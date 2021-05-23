package fr.eni.demonstration;

import java.util.Arrays;
import java.util.Scanner;

public class Cryptage {
	

	public static void main(String[] args) {
		String key;
		String wordToEncrypt;
		
		Scanner scanner = new Scanner(System.in);
		
		// Récupérer la clé
		System.out.println("Donne moi la clé:");
		//key = scanner.nextLine();
		key = "INRACI";
		
		// Récupérer le texte en clair
		System.out.println("Donne moi le mot en clair:");
//		wordToEncrypt = scanner.nextLine();
		wordToEncrypt = "INFORMATIQUE";
		
		
		// Vérification des données saisies par l'utilisateur
		System.out.println(key);
		System.out.println(wordToEncrypt);
		
		
		/***********************************************************************
		 * Initialiser la table de cryptage et ses valeurs
		 * C'est une table de dimension 2, c'est à dire un tableau de tableau
		 * Donc chacune des cases du tableau contient un tableau
		 * Un code correspondant pour sa création pourrait être
		 * char[][] cryptTab = new char[26][];
		 * cryptTab[0] = new char[26];
		 * cryptTab[1] = new char[26];
		 * cryptTab[2] = new char[26];
		 * .....
		 * cryptTab[25] = new char[26];
		 ***********************************************************************/
		char[][] cryptTab = new char[26][26];
		
		// Construction de la chaine "ABC....XYZ"
		// On peut le faire simplement avec 
		// String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// Ci dessous c'est une version un peu plus "sioux" de le faire:
		// Le type char est un type entier. Quand on stocke 'A' dans la variable "alphabet",
		// ce qui est réellement stocké est en fait le code du caractère.
		// Donc on peut incrémenter cet entier pour passer au caractère suivant
		String alphabet = "";
		for (char c = 'A'; c <= 'Z'; c++) {
			alphabet += c;
		}
		
		// Vérification de ce que l'on a créé
		System.out.println(alphabet);
		
		// Initialisation des valeurs du tableau à 2 dimensions à partir de l'alphabet généré
		// Je considère que la première dimension de mon tableau correspond aux lignes
		for (int lineIndex = 0; lineIndex < cryptTab.length; lineIndex++) { // Pour chaque ligne
			
			// Ligne courante que l'on veut initialiser
			char[] line = cryptTab[lineIndex];
			
			for (int colIndex = 0; colIndex < cryptTab.length; colIndex++) { // Pour chaque colonne
				// Modulo 26: quand lineIndex + colIndex dépasse 26, on retombe à 0
				line[colIndex] = alphabet.charAt((lineIndex + colIndex) % 26);
			}
			
		}
		
		// Vérification des valeurs de la table
		for (int ligne = 0; ligne < cryptTab.length; ligne++) {
			System.out.println(Arrays.toString(cryptTab[ligne]));
		}
		
		// Stockage du résultat du chiffrage
		String result = "";
		
		/***********************************************************************
		 * Parcours de chaque lettre du mot à encrypter
		 * pour trouver la lettre correspondante dans la table
		 ***********************************************************************/
		for (int i = 0; i < wordToEncrypt.length(); i++) {
			char currentWordChar = wordToEncrypt.charAt(i);
			
			// Il est probable que la taille de la clé soit inférieure à celle du mot,
			// et donc qu'à un moment la valeur "i" dépasse la longueur de la clé.
			// Le modulo sur la longueur de la clé permet de retomber à 0 (début de la clé) une fois cette longueur dépassée
			char currentKeyChar = key.charAt(i % key.length());
			
			// On récupère l'indice correspondant aux caractères trouvés (~= indice de la lettre dans l'alphabet)
			int x = alphabet.indexOf(currentWordChar); 
			int y = alphabet.indexOf(currentKeyChar);
			
			// Ces indices nous permettent de récupérer le caractère chiffré correspondant à la ligne 'y' et la colonne 'x'
			char encryptedChar = cryptTab[y][x];
			
			result += encryptedChar;
		}
		
		// Affiche le mot crypté
		System.out.println("Le mot encrypé: " + result); 

	}

}
