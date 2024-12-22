package threads;

public class TicketBooking {
    private int TOTAL_TICKETS = 5; // Removed static

    public void bookTicket(String threadName) {
        synchronized (this) {
            if (TOTAL_TICKETS > 0) {
                System.out.println(threadName + " is booking a ticket...");
                TOTAL_TICKETS -= 1;
                System.out.println("Tickets remaining: " + TOTAL_TICKETS);
            } else {
                System.out.println("SORRY!!! HOUSE FULL...");
                System.out.println(threadName + " is unable to book a ticket.");
            }
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {
        TicketBooking book = new TicketBooking();

        Thread app = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    book.bookTicket("App");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread web = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    book.bookTicket("Web");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        app.start();
        web.start();
    }
}
