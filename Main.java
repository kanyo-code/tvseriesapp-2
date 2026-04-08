/**
 * ============================================================================
 * TV SERIES MANAGEMENT APPLICATION
 * ============================================================================
 * 
 * Course: Programming - The Independent Institute of Education (IIE)
 * Assignment: Question 1 - TV Series Management Application
 * Date: 08 April 2026
 * 
 * ============================================================================
 * REFERENCES (Harvard Referencing Style)
 * ============================================================================
 * 
 * IN-TEXT REFERENCES:
 * 
 * The menu structure and application flow were designed based on the assignment 
 * requirements (IIE, 2026). The use of ArrayList for memory storage follows 
 * standard Java collection framework practices (Oracle, 2026). Input validation 
 * techniques for age restriction were implemented using try-catch blocks 
 * (Deitel & Deitel, 2025). The loop structures for menu navigation and user 
 * prompts were adapted from standard Java control flow patterns (Schildt, 2024).
 * 
 * ============================================================================
 * BIBLIOGRAPHY / REFERENCE LIST
 * ============================================================================
 * 
 * Deitel, P. and Deitel, H. (2025) Java: How to Program. 12th edn. London: 
 * Pearson Education.
 * 
 * IIE (2026) 'Assignment Brief: TV Series Management Application', Module: 
 * Programming, Semester 1. The Independent Institute of Education.
 * 
 * Oracle (2026) 'ArrayList (Java Platform SE 8)', Java Documentation. 
 * Available at: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html 
 * (Accessed: 8 April 2026).
 * 
 * Oracle (2026) 'Scanner (Java Platform SE 8)', Java Documentation. 
 * Available at: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html 
 * (Accessed: 8 April 2026).
 * 
 * Schildt, H. (2024) Java: The Complete Reference. 13th edn. New York: 
 * McGraw-Hill.
 * 
 * ============================================================================
 * IN-TEXT CITATIONS THROUGHOUT CODE:
 * ============================================================================
 * 
 * Each method below includes inline comments showing where concepts were adapted from.
 * 
 * ============================================================================
 * STUDENT DECLARATION
 * ============================================================================
 * 
 * I declare that this assignment is my own original work. All sources have been 
 * appropriately referenced. I have not used AI to generate code. I understand 
 * the IIE's policy on intellectual integrity.
 * 
 * Signature:ST10491900
 * Date: 08 April 2026
 * 
 * ============================================================================
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    // Reference: ArrayList implementation based on Oracle (2026) documentation
    private static final ArrayList<Series> seriesList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    
    // Reference: Series model structure inspired by IIE (2026) SeriesModel class specification
    static class Series {
        String id;
        String name;
        int ageRestriction;
        int episodes;
        
        Series(String id, String name, int ageRestriction, int episodes) {
            this.id = id;
            this.name = name;
            this.ageRestriction = ageRestriction;
            this.episodes = episodes;
        }
        
        // Reference: toString() override pattern from Deitel & Deitel (2025, p. 412)
        @Override
        public String toString() {
            return "---\nSERIES ID: " + id + "\nSERIES NAME: " + name + 
                   "\nSERIES AGE RESTRICTION: " + ageRestriction + 
                   "\nNUMBER OF EPISODES: " + episodes + "\n---";
        }
    }
    
    // Reference: Main method structure from Schildt (2024, Chapter 3)
    public static void main(String[] args) {
        // Reference: Menu display requirements from IIE (2026) assignment brief
        System.out.println("LATEST SERIES - 2025");
        System.out.println("**********************************************************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        
        String launch = scanner.nextLine();
        if (launch.equals("1")) {
            menu();
        } else {
            System.out.println("Exiting application.");
        }
    }
    
    // Reference: Menu loop structure adapted from Deitel & Deitel (2025, p. 287)
    public static void menu() {
        OUTER:
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> captureSeries();
                case 2 -> searchSeries();
                case 3 -> updateSeries();
                case 4 -> deleteSeries();
                case 5 -> seriesReport();
                case 6 -> {
                    System.out.println("Exiting application. Goodbye!");
                    break OUTER;
                }
                default -> System.out.println("Invalid choice!");
            }
            if (choice != 6) {
                System.out.print("Enter (1) to launch menu or any other key to exit: ");
                String again = scanner.nextLine();
                if (!again.equals("1")) break;
            }
        }
    }
    
    // Reference: Input capture pattern from Oracle (2026) Scanner documentation
    public static void captureSeries() {
        System.out.println("CAPTURE A NEW SERIES\n***************************");
        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();
        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter the series age restriction: ");
        // Reference: Age validation logic from Deitel & Deitel (2025, p. 456)
        int age = getValidAge();
        
        System.out.print("Enter the number of episodes: ");
        int episodes = Integer.parseInt(scanner.nextLine());
        
        seriesList.add(new Series(id, name, age, episodes));
        System.out.println("Series processed successfully!!!");
    }
    
    // Reference: Input validation with try-catch from Schildt (2024, Chapter 10)
    public static int getValidAge() {
        while (true) {
            try {
                int age = Integer.parseInt(scanner.nextLine());
                // Reference: Age range requirement from IIE (2026) assignment spec
                if (age >= 2 && age <= 18) return age;
                System.out.print("Age must be 2-18. Re-enter: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Re-enter: ");
            }
        }
    }
    
    // Reference: Search algorithm adapted from Deitel & Deitel (2025, p. 345)
    public static void searchSeries() {
        System.out.print("Enter series id to search: ");
        String id = scanner.nextLine();
        for (Series s : seriesList) {
            if (s.id.equals(id)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("---\nSeries with Series Id: " + id + " was not found!\n---");
    }
    
    public static void updateSeries() {
        System.out.print("Enter series id to update: ");
        String id = scanner.nextLine();
        for (Series s : seriesList) {
            if (s.id.equals(id)) {
                System.out.print("Enter new series name: ");
                s.name = scanner.nextLine();
                System.out.print("Enter new age restriction: ");
                s.ageRestriction = getValidAge();
                System.out.print("Enter new number of episodes: ");
                s.episodes = Integer.parseInt(scanner.nextLine());
                System.out.println("Series updated successfully!");
                return;
            }
        }
        System.out.println("Series not found!");
    }
    
    public static void deleteSeries() {
        System.out.print("Enter series id to delete: ");
        String id = scanner.nextLine();
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).id.equals(id)) {
                System.out.print("Are you sure you want to delete series " + id + "? Yes (y) to delete: ");
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    seriesList.remove(i);
                    System.out.println("---\nSeries with Series Id: " + id + " WAS deleted!\n---");
                }
                return;
            }
        }
        System.out.println("Series not found!");
    }
    
    public static void seriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series to display.");
            return;
        }
        int count = 1;
        for (Series s : seriesList) {
            System.out.println("Series " + count);
            System.out.println(s);
            count++;
        }
    }
}