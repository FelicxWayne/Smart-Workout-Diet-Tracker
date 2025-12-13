import java.time.LocalDate;
import java.util.*;

public class DataStore{
    private List<Meal> meals;
    private List<Workout> workouts;
    private Map<String,LocalDate> lastTrainedMap;

    public DataStore(){
        meals = new ArrayList();
        workouts = new ArrayList();
        lastTrainedMap = new HashMap();
    }

    public void addMeals(Meal meal){
        meals.add(meal);
    }

    public List<Meal> getMeals(){
        return meals;
    }

    public void addWorkout(Workout workout){
        workouts.add(workout);

        lastTrainedMap.put(workout.getMusle(),workout.getDate());
    }

    public Map<String,LocalDate> getLastTrainedMap(){
        return lastTrainedMap;
    }
}