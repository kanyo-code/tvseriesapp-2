import java.util.Scanner;

public class Main {
    private static final SeriesManager manager = new SeriesManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (scanner) {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("**********************************************************************");
            System.out.print("Enter (1) to launch menu or any other key to exit: ");
            
            String launch = scanner.nextLine();
            
            if (launch.equals("1")) {
                showMenu();
            } else {
                System.out.println("Exiting application.");
            }
        }
    }
    
    private static void showMenu() {
        int choice;
        
        do {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter your choice: ");
            
            choice = Integer.parseInt(scanner.nextLine());
            
            switch (choice) {
                case 1 -> manager.CaptureSeries();
                case 2 -> manager.SearchSeries();
                case 3 -> manager.UpdateSeries();
                case 4 -> manager.DeleteSeries();
                case 5 -> manager.SeriesReport();
                case 6 -> System.out.println("Exiting application. Goodbye!");
                default -> System.out.println("Invalid choice. Please enter 1-6.");
            }
            
            if (choice != 6) {
                System.out.print("\nEnter (1) to launch menu or any other key to exit: ");
                String again = scanner.nextLine();
                if (!again.equals("1")) {
                    choice = 6; // Exit
                }
            }
            
        } while (choice != 6);
    }
}