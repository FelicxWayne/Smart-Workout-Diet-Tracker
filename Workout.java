import java.time.LocalDate;
public class Workout {
    private LocalDate date;
    private String muscle;

    public Workout(LocalDate date, String muscle){
        this.date = date;
        this.muscle = muscle;
    }

    public LocalDate getDate(){
        return date;
    }

    public String getMusle(){
        return muscle;
    }

    @Override
    public String toString(){
        return date.toString() + " | " + muscle;
    }
}
