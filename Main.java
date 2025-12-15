import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DataStore datastore = new DataStore();

        while(true){
            System.out.println("\n=====YOUR FITNESS TRACKER====");
            System.out.println("1. Add Meal ");
            System.out.println("2. Add Workout");
            System.out.println("3. Suggest Next Workout");
            System.out.println("4. Daily Summary");
            System.out.println("5. Exit ");
            System.out.print("Choose an option :");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    addMeal(sc,datastore);
                    break;
                case 2:
                    addWorkout(sc,datastore);
                    break;
                case 3:
                    suggestWorkout(datastore);
                    break;
                case 4:
                    showDailySummary(datastore);
                    break;
                case 5:
                    System.out.println("Bye, Stay consistent! ");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
    private static void addMeal(Scanner sc, DataStore datastore){
        System.out.print("Meal Type :");
        String mealType = sc.nextLine();

        System.out.print("Food Name :");
        String food = sc.nextLine();

        System.out.print("Calories :");
        int calories = sc.nextInt();

        System.out.print("Protein(g) :");
        double protein = sc.nextDouble(); 
        sc.nextLine();

        String date = LocalDate.now().toString();
        Meal meal = new Meal(date,mealType,food,calories,protein);
        datastore.addMeal(meal);
        System.out.println("Meal Added Successfully !");
    }
    private static void addWorkout(Scanner sc, DataStore datastore){
        System.out.print("Muscle Area(Chest/Back/Shoulders/Arms/Legs/Core)");
        String muscle = sc.nextLine();

        Workout workout = new Workout(LocalDate.now(), muscle);
        datastore.addWorkout(workout);
        System.out.println("Workout added successfully");
    }
    private static void suggestWorkout(DataStore datastore){
        String suggestion = WorkoutRecommender.suggestNextWorkout(datastore.getLastTrainedMap());
        System.out.println("Suggested Area :" + suggestion);
    }
    private static void showDailySummary(DataStore datastore){
        int totalCalories = 0;
        double totalProtein = 0;
        String today = LocalDate.now().toString();

        for(Meal meal:datastore.getMeal()){
            if(meal.getDate().equals(today)){
                totalCalories += meal.getCalories();
                totalProtein += meal.getProtein();
            }
        }
        System.out.println("Today's summary");
        System.out.println("Calories :"+totalCalories);
        System.out.println("Protein :"+totalProtein+"g ");
    }
}
