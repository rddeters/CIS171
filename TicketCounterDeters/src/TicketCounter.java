/**  
* River Deters - mddeters  
* CIS171 22149
* Jul 16, 2023
* Windows 10 Operating System Eclipse Version - 2023-03
*/

public class TicketCounter {
    private static final int MAX_TICKETS = 28;
    private static final int MAX_TICKETS_PER_BUYER = 4;

    private int remainingTickets; // Number of tickets still available for sale
    private int totalBuyers; // Number of buyers who purchased tickets

    // Constructor to initialize the ticket counter with the maximum number of tickets
    public TicketCounter() {
        this.remainingTickets = MAX_TICKETS;
        this.totalBuyers = 0;
    }

    // Getter method to retrieve the number of remaining tickets
    public int getRemainingTickets() {
        return remainingTickets;
    }

    // Getter method to retrieve the total number of buyers
    public int getTotalBuyers() {
        return totalBuyers;
    }

    // Method to sell tickets to a buyer, taking the number of tickets they want as input
    public boolean sellTickets(int numTickets) {
        // Check if the requested number of tickets is valid:
        // 1. The number of tickets requested must be between 1 and 4 (inclusive).
        // 2. The number of tickets requested must not exceed the number of remaining tickets.
        if (numTickets <= 0 || numTickets > MAX_TICKETS_PER_BUYER || numTickets > remainingTickets) {
            // If the request is invalid, return false to indicate the tickets were not sold.
            return false;
        } else {
            // If the request is valid, increase the total number of buyers and decrease the number of remaining tickets.
            totalBuyers++;
            remainingTickets -= numTickets;
            // Return true to indicate that the tickets were sold successfully.
            return true;
        }
    }

    // Method to check if the tickets are sold out.
    // Returns true if there are no remaining tickets, otherwise returns false.
    public boolean isSoldOut() {
        return remainingTickets == 0;
    }
}
