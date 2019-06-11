import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rekrutacja on 2019-06-11.
 */
public class Universe {
    private ArrayList<String> galaxiesNames;
    private ArrayList<Galaxy> galaxies;

    public Universe() {
        galaxiesNames = new ArrayList<String>();
        galaxies = new ArrayList<Galaxy>();
    }

    public boolean addGalaxy(Galaxy galaxy){
        if(galaxiesNames.contains(galaxy.getName())) return false;
        else{
            galaxies.add(galaxy);
            galaxiesNames.add(galaxy.getName());
        }
        return true;
    }

    public Galaxy getGalaxy(String name)
    {
        for(int i = 0; i < galaxies.size(); i++){
            if(galaxiesNames.get(i).equals(name)) return galaxies.get(i);
        }
        return null;
    }

    public Galaxy getGalaxy(int i)
    {
        if(i<= getNumberOfGalaxies())
            return galaxies.get(i);
        else
            return null;
    }
    public boolean doesGalaxyExist(String name)
    {
        if(galaxiesNames.contains(name)) return true;
        else return false;
    }

    public ArrayList<Galaxy> sortUniverse()
    {
        ArrayList<Galaxy> temp;
        Galaxy temporaryGalaxy;
        int counter = 0;
        if(galaxies.size() == 1 || galaxies.size() == 0) return galaxies;
        else{
            temp = galaxies;
            do {
                counter = 0;
                for (int i = 0; i < (temp.size() - 1); i++) {
                    if (temp.get(i).getStarCount() < temp.get(i + 1).getStarCount()) {
                        temporaryGalaxy = temp.get(i);
                        temp.set(i, temp.get(i + 1));
                        temp.set(i + 1, temporaryGalaxy);
                        counter++;
                    }
                }
            }while(counter != 0);
        }
        return temp;
    }

    public int getNumberOfGalaxies()
    {
        return galaxies.size();
    }
}
