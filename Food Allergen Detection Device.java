import java.util.Scanner;

// Class to represent food items
class FoodItem {
    private String name;
    private String[] allergens;

    public FoodItem(String name, String[] allergens) {
        this.name = name;
        this.allergens = allergens;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String[] getAllergens() {
        return allergens;
    }
}

// Class to represent the food allergen detection device
public class FoodAllergenDetectionDevice {
    private FoodItem[] foodItems;

    public FoodAllergenDetectionDevice() {
        // Initialize food items with their allergens
        this.foodItems = new FoodItem[] {
            new FoodItem("Apple", new String[]{"None"}),
            new FoodItem("Peanut Butter", new String[]{"Peanuts"}),
            new FoodItem("Milk", new String[]{"Dairy"}),
            // Add more food items with allergens as needed
        };
    }

    // Method to detect allergens in a food item
    public String detectAllergens(String itemName) {
        for (FoodItem item : foodItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return String.join(", ", item.getAllergens());
            }
        }
        return "Unknown";
    }

    public static void main(String[] args) {
        FoodAllergenDetectionDevice device = new FoodAllergenDetectionDevice();
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a food item
        System.out.print("Enter the name of the food item: ");
        String itemName = scanner.nextLine();

        // Detect allergens in the entered food item
        String allergens = device.detectAllergens(itemName);

        // Display detected allergens
        System.out.println("Detected Allergens: " + allergens);

        scanner.close();
    }
}
