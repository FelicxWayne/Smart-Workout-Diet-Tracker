import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class WorkoutRecommender {
    private static final List<String> MUSCLES = Arrays.asList("Chest" ," Back" , "Arms" , "Shoulders", "Legs", "Core");

    private static String suggestNextWorkout(Map<String,LocalDate> lastTrainedMap){
        LocalDate today = LocalDate.now();
        PriorityQueue<MuscleGap> pq = new PriorityQueue<>((a,b)->Long.compare(b.daysGap,a.daysGap));
        
        for(String muscle:MUSCLES){
            LocalDate lastDate = lastTrainedMap.get(muscle);
            long gap;
            if(lastDate == null){
                gap = Long.MAX_VALUE;
            }else{
                gap = ChronoUnit.DAYS.between(lastDate, today);
            }
            pq.add(new MuscleGap(muscle,gap));
        }
        return pq.peek().muscle;
    }
    static class MuscleGap{
        String muscle;
        long daysGap;
        MuscleGap(String muscle,long daysGap){
            this.muscle = muscle;
            this.daysGap = daysGap;
        }
    }
}
