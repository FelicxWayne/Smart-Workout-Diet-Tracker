public class Meal{
    private String date;
    private String mealType;
    private String foodName;
    private int calories;
    private double protein;

    public Meal(String date,String mealType,String foodName, int calories, double protein ){
        this.date = date;
        this.mealType = mealType;
        this.foodName = foodName;
        this.calories = calories;
        this.protein = protein;
    }

    public String getDate(){
        return date;
    }

    public int getCalories(){
        return calories;
    }

    public double getProtein(){
        return protein;
    }

    @Override
    public String toString(){
        return date +" | "+ mealType + " | " + foodName + " | " + calories + "cal | " + protein + "g protein";
    }
}