//Antoni Urbaniak - projekt 'Universe'

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class Main {
    private static Universe universe;
    static boolean on;

    public static void main(String[] args) {
        universe = new Universe();
        Scanner scanner = new Scanner(System.in);
        String request;
        on = true;
        //TODO: XML!!!!
//        universe.addGalaxy(new Galaxy("a", Type.ELLIPTICAL, 5));
//        universe.addGalaxy(new Galaxy("b", Type.ELLIPTICAL, 5999));
//        universe.addGalaxy(new Galaxy("c", Type.ELLIPTICAL, 2));
//        universe.addGalaxy(new Galaxy("d", Type.ELLIPTICAL, 1));
//        universe.addGalaxy(new Galaxy("e", Type.ELLIPTICAL, 453));
//        universe.addGalaxy(new Galaxy("f", Type.ELLIPTICAL, 234));
//        universe.addGalaxy(new Galaxy("g", Type.ELLIPTICAL, 52343));
//        universe.addGalaxy(new Galaxy("h", Type.ELLIPTICAL, 44));
//        ArrayList<Galaxy> sortedGalaxies;
//        sortedGalaxies = universe.sortUniverse();
//        System.out.println(sortedGalaxies);
//        for(Galaxy g : sortedGalaxies)
//        {
//            System.out.println(g.getName() + "| stars: " + g.getStarCount());
//        }

        System.out.println("Welcome Almighty One to CreateTheUniverse1.0 alpha!");
        System.out.println("Here, use these commands as You desire!\n");
        showCommands();
        while(on) {
            request = scanner.nextLine();
            proceedRequest(request);
            System.out.println("Anything else?");
        }
    }

    private static void showCommands() {

        //System.out.println("ShowCommands - Show all available commands again!");
        System.out.println("AddNewGalaxy - Create galaxy of Yours choosing");
        System.out.println("AddNewStar - Add a star to present galaxy");
        System.out.println("ListGalaxies - List all galaxies that You have created");
        System.out.println("ListGalaxiesSorted - Same as above, but sorted!");
        System.out.println("ListStars - List all stars of given galaxy from oldest to youngest");
        System.out.println("Exit - :(!");
    }

    private static void proceedRequest(String request) {
        Scanner scanner = new Scanner(System.in);
        if (request.equals("AddNewGalaxy")){
            Galaxy newGalaxy;
            String galaxyName;
            String stringGalaxyType;
            Type galaxyType;

            System.out.println("Please, enter name for the Galaxy!");
            galaxyName = scanner.nextLine();
            System.out.println("Please, enter it's type! (Available types: Spiral, Elliptical, Irregular");
            stringGalaxyType = scanner.nextLine();
            if(stringGalaxyType.equals("Spiral"))
                galaxyType = Type.SPIRAL;
            else if (stringGalaxyType.equals("Elliptical"))
                galaxyType = Type.ELLIPTICAL;
            else if (stringGalaxyType.equals("Irregular"))
                galaxyType = Type.IRREGULAR;
            else{
                System.out.println("INCORRECT TYPE!");
                return;
            }
            newGalaxy = new Galaxy(galaxyName, galaxyType);
            if(universe.addGalaxy(newGalaxy))
                System.out.println("Galaxy successfully created and added to the universe! Praise the sun!");
            else
                System.out.println("Something went wrong! The galaxy might already exist in the universe!");

        }
        else if (request.equals("AddNewStar")){
            String galaxyName;
            Galaxy galaxy;
            Star newStar;
            String starName;
            BigInteger starAge;


            System.out.println("The star needs a mom-galaxy! Enter name of the galaxy for the star");
            galaxyName = scanner.nextLine();
            if(!universe.doesGalaxyExist(galaxyName)){
                System.out.println("No such galaxy!");
                return;
            }else{
                galaxy = universe.getGalaxy(galaxyName);
                System.out.println("Please, enter the name of the star");
                starName = scanner.nextLine();
                System.out.println("Please, enter star's age");
                starAge = new BigInteger(scanner.nextLine());

                newStar = new Star(starName, starAge);
                if(galaxy.addStar(newStar))
                    System.out.println("Star successfully created and added to the galaxy! Praise the sun!");
                else
                    System.out.println("Something went wrong! The star might already exist in the universe!");
            }
        }else if(request.equals("ListGalaxies")){
            Galaxy currentGalaxy;
            System.out.println("These are all galaxies that You have created:");
            for(int i = 0; i < universe.getNumberOfGalaxies(); i++)
            {
                currentGalaxy = universe.getGalaxy(i);
                System.out.printf("Galaxy name: " + currentGalaxy.getName() +"\nType: "+currentGalaxy.getType()+"\nNumber of stars: "+currentGalaxy.getStarCount()+"\n\n");
            }

        }else if(request.equals("ListGalaxiesSorted")){
            Galaxy currentGalaxy;
            ArrayList<Galaxy> sortedGalaxies = universe.sortUniverse();
            System.out.println("These are all galaxies that You have created - and sorted! From biggest to smallest:");
            for(int i = 0; i < sortedGalaxies.size(); i++)
            {
                currentGalaxy = sortedGalaxies.get(i);
                System.out.printf("Galaxy name: " + currentGalaxy.getName() +"\nType: "+currentGalaxy.getType()+"\nNumber of stars: "+currentGalaxy.getStarCount()+"\n\n");
            }
        }else if(request.equals("ListStars")){
            String galaxyName;
            Galaxy galaxy;
            Star currentStar;

            System.out.println("Of course! Just tell me of which galaxy");
            galaxyName = scanner.nextLine();
            if(!universe.doesGalaxyExist(galaxyName)){
                System.out.println("No such galaxy!");
                return;
            }else{
                galaxy = universe.getGalaxy(galaxyName);
                ArrayList<Star> sortedStars = galaxy.sortGalaxy();
                System.out.println("These are all stars of "+ galaxyName +" galaxy - and sorted! From oldest to youngest:");
                for(int i = 0; i < sortedStars.size(); i++)
                {
                    currentStar = sortedStars.get(i);
                    System.out.printf("Galaxy name: " + currentStar.getName() +"\nAge: "+currentStar.getAge() +"\n\n");
                }
            }
        }else if(request.equals("Exit")) {
            System.out.println("Goodbye, farewell!");
            on = false;
        }else {
            System.out.println("I don't understand, can You repeat?");
        }
    }

//    public boolean readXML(String xml) {
//
//        return false;
//    }
//
//    public void storeToXML(String xml) {
//        Document dom;
//        Element e = null;
//
//        DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance()
//    }
//
//    private String getTextValue(String def, Element doc, String tag)
//    {
//        String value = def;
//        NodeList nl;
//        nl = doc.getElementsByTagName(tag);
//        if(nl.getLength() >0 && nl.item(0).hasChildNodes()){
//            value = nl.item(0).getFirstChild().getNodeValue();
//        }
//        return value;
//    }
}
