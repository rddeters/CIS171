/**  
* River Deters - mddeters  
* CIS171 22149
* Jul 16, 2023
* Windows 10 Operating System Eclipse Version - 2023-03
*/

import org.junit.Assert;
import org.junit.Test;

public class TicketCounterTest {
    int MAX_TICKETS = 28;
    int MAX_PER_BUYER = 4;
    
    @Test
    public void testInitialRemainingTickets() {
        TicketCounter ticketCounter = new TicketCounter();
        int initialRemainingTickets = ticketCounter.getRemainingTickets();
        Assert.assertEquals(MAX_TICKETS, initialRemainingTickets);
    }

    @Test
    public void testInitialTotalBuyers() {
        TicketCounter ticketCounter = new TicketCounter();
        int initialTotalBuyers = ticketCounter.getTotalBuyers();
        Assert.assertEquals(0, initialTotalBuyers);
    }

    @Test
    public void testSellTicketsSuccess() {
        TicketCounter ticketCounter = new TicketCounter();
        int numTicketsToSell = 4;
        boolean result = ticketCounter.sellTickets(numTicketsToSell);
        Assert.assertEquals(true, result);
        Assert.assertEquals(MAX_TICKETS - numTicketsToSell, ticketCounter.getRemainingTickets());
        Assert.assertEquals(1, ticketCounter.getTotalBuyers());
    }

    @Test
    public void testSellTicketsInvalid() {
        TicketCounter ticketCounter = new TicketCounter();
        // Attempt to sell more tickets than allowed per buyer
        int numTicketsToSell = MAX_PER_BUYER + 1;
        boolean result = ticketCounter.sellTickets(numTicketsToSell);
        Assert.assertEquals(false, result);
        Assert.assertEquals(MAX_TICKETS, ticketCounter.getRemainingTickets());
        Assert.assertEquals(0, ticketCounter.getTotalBuyers());

        // Attempt to sell zero tickets
        result = ticketCounter.sellTickets(0);
        Assert.assertEquals(false, result);
        Assert.assertEquals(MAX_TICKETS, ticketCounter.getRemainingTickets());
        Assert.assertEquals(0, ticketCounter.getTotalBuyers());

        // Attempt to sell negative tickets
        result = ticketCounter.sellTickets(-3);
        Assert.assertEquals(false, result);
        Assert.assertEquals(MAX_TICKETS, ticketCounter.getRemainingTickets());
        Assert.assertEquals(0, ticketCounter.getTotalBuyers());
    }

    @Test
    public void testSellTicketsNotEnoughRemaining() {
        TicketCounter ticketCounter = new TicketCounter();
        int ticketsRemaining = MAX_TICKETS;
        while (ticketsRemaining > 0) {
            ticketCounter.sellTickets(MAX_PER_BUYER);
            ticketsRemaining -= MAX_PER_BUYER;
        }
        
        // Attempt to sell more tickets than available/when sold out
        boolean result = ticketCounter.sellTickets(1);
        Assert.assertEquals(false, result);
        Assert.assertEquals(0, ticketCounter.getRemainingTickets());
    }

    @Test
    public void testIsSoldOut() {
        TicketCounter ticketCounter = new TicketCounter();
        int ticketsRemaining = MAX_TICKETS;
        Assert.assertFalse(ticketCounter.isSoldOut());
        
        while (ticketsRemaining > 0) {
            ticketCounter.sellTickets(MAX_PER_BUYER);
            ticketsRemaining -= MAX_PER_BUYER;
        }
        Assert.assertTrue(ticketCounter.isSoldOut());
    }
}
