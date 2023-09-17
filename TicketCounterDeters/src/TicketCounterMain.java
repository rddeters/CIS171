/**  
* River Deters - mddeters  
* CIS171 22149
* Jul 16, 2023
* Windows 10 Operating System Eclipse Version - 2023-03
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicketCounterMain {
    public static void main(String[] args) {
        final int MAX_TICKETS_PER_BUYER = 4;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the concert ticket sale!");

        // Set the initial number of tickets
        TicketCounter ticketManager = new TicketCounter();

        while (!ticketManager.isSoldOut()) {
            System.out.println("Remaining tickets: " + ticketManager.getRemainingTickets());
            System.out.print("Enter the number of tickets you want to purchase (1-4): ");
            try {
                int numTickets = scanner.nextInt();

                // Attempt to sell tickets to the buyer and get the purchase status
                boolean purchaseSuccess = ticketManager.sellTickets(numTickets);

                if (purchaseSuccess) {
                    System.out.println("Tickets purchased successfully!");
                } else if (numTickets > MAX_TICKETS_PER_BUYER) {
                    // If the user tries to buy more than the allowed tickets per buyer, display a message.
                    System.out.println("Sorry, at this time, you are only able to purchase up to 4 tickets!");
                } else if (numTickets <= 0) {
                    // If the user tries to buy zero or a negative number of tickets, display a message.
                    System.out.println("Please enter a number greater than zero!");
                } else {
                    // If the user requests more tickets than available, display a message with the remaining tickets.
                    System.out.println("Sorry, at this time, we only have " + ticketManager.getRemainingTickets() + " tickets left!");
                }
            } catch (InputMismatchException e) {
                // User entered something other than an integer
                System.out.println("Please enter a valid number between 1 and 4!");
                // Clear the scanner buffer to prevent an infinite loop caused by invalid input
                scanner.nextLine();
            }
        }

        System.out.println("Sorry, the show is sold out!");
        System.out.println("Total number of buyers: " + ticketManager.getTotalBuyers());

        scanner.close();
    }
}
