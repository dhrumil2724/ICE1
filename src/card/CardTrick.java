/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Random; // Import Random for random number generation
import java.util.Scanner; // Import Scanner for user input
/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Dhrumil Rana
 */
public class CardTrick {
    
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random(); // Initialize Random

        // Fill the magicHand array with random cards and print them
        System.out.println("Magic Hand:");
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Generate a random value between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Generate a random suit index between 0 and 3
            magicHand[i] = c;
            System.out.println(c.toString()); // Print each randomly generated card using toString
        }

        // Ask the user for Card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter your card suit (0 for Hearts, 1 for Diamonds, 2 for Clubs, 3 for Spades): ");
        int userSuitIndex = scanner.nextInt();

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuitIndex]);

        // Search magicHand for the user's card
        boolean cardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                cardFound = true;
                break;
            }
        }

        // Report the result of the user's card search
        if (cardFound) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        // Add one lucky card (hard-coded 2 of clubs)
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit(Card.SUITS[2]); // 2 corresponds to clubs

        // Search magicHand for the lucky card
        boolean luckyCardFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) {
                luckyCardFound = true;
                break;
            }
        }

        // Report the result of the lucky card search
        if (luckyCardFound) {
            System.out.println("You win! The lucky card (2 of Clubs) is in the magic hand!");
        } else {
            System.out.println("You lose! The lucky card (2 of Clubs) is not in the magic hand.");
        }
    }
    
}
