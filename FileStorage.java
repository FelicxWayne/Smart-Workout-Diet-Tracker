import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileStorage{
    private static final String DATA_DIR = "data";
    private static final String MEALS_FILE = DATA_DIR + "/meals.csv";
    private static final String WORKOUTS_FILE = DATA_DIR + "/workouts.csv";

    private static void ensureDataDirectory(){
        File dir = new File(DATA_DIR);
        if (!dir.exists()){
            dir.mkdir();
        }
    }

    public static void saveMeal(Meal meal){
        ensureDataDirectory();

        try {
            FileWriter fw = new FileWriter(MEALS_FILE,true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(meal.getDate() + "," + meal.toString().replace(" | ", ","));
            bw.newLine();
            
        } catch (IOException e) {
            System.out.println("Failed to Save Meal !");
        }
    }

    public static void loadMeal(List<Meal> meals){
        ensureDataDirectory();

        File file = new File(MEALS_FILE);
        if(!file.exists()) return;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine())!=null){
                try {
                    String[] parts = line.split(",");

                    String data = parts[0];
                    String mealType = parts[1];
                    String food = parts[2];
                    int calories = Integer.parseInt(parts[3]);
                    double protein = Double.parseDouble(parts[4]);

                    meals.add(new Meal(data,mealType,food,calories,protein));
                } catch (Exception ignored) {
                }
            }

        }catch(IOException e){
            System.out.println("Failed to Load Mealsd");
        }
    }

    public static void saveWorkout(Workout workout){
        ensureDataDirectory();

        try(FileWriter fw = new FileWriter(WORKOUTS_FILE,true);
            BufferedWriter bw = new BufferedWriter(fw)){
                bw.write(workout.getDate()+","+workout.getMusle());
                bw.newLine();
            
        } catch (IOException e) {
            System.out.println("Failed to Save Workout");
        }
    }

    public static void loadWorkout(List<Workout> workout){
        File file = new File(WORKOUTS_FILE);
        if(!file.exists()) return;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;

            while((line = br.readLine())!=null){
                try {
                    String[] parts = line.split(",");

                    LocalDate date = LocalDate.parse(parts[0]);
                    String muscle = parts[1];
                } catch (Exception ignored) {
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to Load Workouts");
        }
    }


}