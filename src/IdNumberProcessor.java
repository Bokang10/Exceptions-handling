import java.util.Scanner;

public class IdNumberProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProcessing = true;

        while (continueProcessing) {
            System.out.print("Enter your Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your ID Number format 'xxxxxx xxxx xxx': ");
            String idNumber = scanner.nextLine();

            try {
                // Validate the ID number
                if (isValid(idNumber)) {
                    System.out.println(name + " " + idNumber + " is valid.");
                }
            } catch (IdNumberException e) {
                System.out.println(name + " " + idNumber + " is invalid.");
                System.out.println(e.getMessage());
            }

            System.out.print("Continue? (y/N): ");
            String response = scanner.nextLine();
            continueProcessing = response.equalsIgnoreCase("y");
        }

        scanner.close();
    }

    // Static method to validate an ID number
    public static boolean isValid(String id) throws IdNumberException {
        // ID should be 15 characters long
        if (id.length() != 15) {
            throw new IdNumberException("wrong number of characters");
        }

        // Expected format: "xxxxxx xxxx xxx"
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);

            // Spaces should be in the 7th and 12th positions
            if ((i == 6 || i == 11) && c != ' ') {
                throw new IdNumberException("spaces in the wrong spots");
            }

            // Other characters should be digits
            if (i != 6 && i != 11 && !Character.isDigit(c)) {
                throw new IdNumberException("non-digits in the ID");
            }
        }

        return true; // ID is valid
    }
}
