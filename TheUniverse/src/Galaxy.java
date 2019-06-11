import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    private String name; //unique
    private Type type;



    private int starCount;

    private ArrayList<String> starsNames;
    private ArrayList<Star> stars;

    public Galaxy(String name, Type type) {
        this.name = name;
        this.type = type;
        starsNames = new ArrayList<String>();
        stars = new ArrayList<Star>();
    }

    //for testing, no time for JUnit;
    public Galaxy(String name, Type type, int starCount) {
        this.name = name;
        this.type = type;
        this.starCount = starCount;
        starsNames = new ArrayList<String>();
        stars = new ArrayList<Star>();
    }


    public boolean addStar(Star star)
    {
        if(starsNames.contains(star.getName())) return false;
        else{
            stars.add(star);
            starsNames.add(star.getName());
            starCount++;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getStarCount() {
        return starCount;
    }

    public ArrayList<Star> sortGalaxy()
    {
        ArrayList<Star> temp;
        Star temporaryStar;
        int counter = 0;
        if(stars.size() == 1 || stars.size() == 0) return stars;
        else{
            temp = stars;
            do {
                counter = 0;
                for (int i = 0; i < (temp.size() - 1); i++) {
                    if (temp.get(i).getAge().compareTo(temp.get(i + 1).getAge()) == -1) {
                        temporaryStar = temp.get(i);
                        temp.set(i, temp.get(i + 1));
                        temp.set(i + 1, temporaryStar);
                        counter++;
                    }
                }
            }while(counter != 0);
        }
        return temp;
    }
}
