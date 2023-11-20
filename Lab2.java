package edu.monmouth.lab2;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;

public class Lab2 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream("Lab2.txt");
        System.setOut(out);
        System.setErr(out);

        State newJersey = new State("New Jersey", 130,  "Eastern Goldfinch");
	    State newYork = new State("New York", 127,  "Eastern Bluebird");
	    State pennsylvania = new State("Pennsylvania", 0,  "Ruffled Grouse");
	    State delaware = new State("Delaware", 28,  "Blue Hen");
	    State maryland = new State("Maryland", 31,  "Oriole");
	    State connecticut = new State("Connecticut", 96,  "Robin");
	    State newJersey2 = new State("New Jersey", 130,  "Eastern Goldfinch");

        Governor njGov = new Governor("Murphy", 65);
	    Governor nyGov = new Governor("Hochul", 64);
	    Governor paGov = new Governor("Shapiro", 49);
	    Governor deGov = new Governor("Carney", 66);
	    Governor mdGov = new Governor("Moore", 44);
	    Governor ctGov = new Governor("Lamont", 69);

        // Verify hashCode and equals methods are consistent
        verifyConsistency(newJersey, newYork);

        // verify Governor hashCode and equals methods are consistent
        verifyConsistency(njGov, nyGov);

        // Create a HashSet that can house State objects
        HashSet<State> stateHashSet = new HashSet<>();

        // Insert the seven State objects to the HashSet and print whether or not the object was successfully inserted
        insertStates(stateHashSet, newJersey, newYork, pennsylvania, delaware, maryland, connecticut, newJersey2);

        // Iterate through the HashSet printing out each State’s attributes
        iterateAndPrint(stateHashSet);

        // Create a HashMap establishing an association between a State object and a Governor object
        HashMap<State, Governor> stateGovernorHashMap = new HashMap<>();

        // Insert corresponding State and Governor objects
        insertStateGovernorPairs(stateGovernorHashMap, newJersey, njGov, newYork, nyGov, pennsylvania, paGov, delaware, deGov, maryland, mdgov, connecticut, ctGov, newJersey2 njGov);

        // Print the number of elements in the HashMap
        System.out.println("Number of elements in HashMap: " + stateGovernorHashMap.size());

        // Print all elements in the HashMap
        iterateAndPrintHashMap(stateGovernorHashMap);

        // Print the governor for the state of New York
        Governor newYorkGovernor = stateGovernorHashMap.get(newYork);
        System.out.println("Governor for New York: " + newYorkGovernor.getName());

        // Determine if the “newJersey” State object exists in the HashMap
        if (stateGovernorHashMap.containsKey(newJersey)) {
            // If it does, print out its governor
            Governor newJerseyGovernor = stateGovernorHashMap.get(newJersey);
            System.out.println("Governor for New Jersey: " + newJerseyGovernor.getName());
        }

        State rhodeIsland = new State("Rhode Island", 40, "Rhode Island Red");
        // Determine if the State object rhodeIsland exists in the HashMap
        if (stateGovernorHashMap.containsKey(rhodeIsland)) {
            // If it does, print out its governor
            Governor rhodeIslandGovernor = stateGovernorHashMap.get(rhodeIsland);
            System.out.println("Governor for Rhode Island: " + rhodeIslandGovernor.getName());
        }
    }

    private static void verifyConsistency(Object obj1, Object obj2) {
        System.out.println("Consistency check result: " + obj1.equals(obj2));
    }

    private static void insertStates(HashSet<State> stateHashSet, State... states) {
        for (State state : states) {
            boolean added = stateHashSet.add(state);
            System.out.println("Inserting " + state.getName() + ": " + added);
        }
    }

    private static void iterateAndPrint(HashSet<State> stateHashSet) {
        System.out.println("States in HashSet:");
        for (State state : stateHashSet) {
            System.out.println(state.getName() + ",Coast Length: " + state.getcoastLength() + ", Bird: " + state.getBird());
        }
    }

    private static void insertStateGovernorPairs(HashMap<State, Governor> stateGovernorHashMap, State state, Governor governor) {
        stateGovernorHashMap.put(state, governor);
    }

    private static void iterateAndPrintHashMap(HashMap<State, Governor> stateGovernorHashMap) {
        System.out.println("State-Governor pairs in HashMap:");
        for (State state : stateGovernorHashMap.keySet()) {
            Governor governor = stateGovernorHashMap.get(state);
            System.out.println(state.getName() + " Governor: " + governor.getName() + ", Age: " + governor.getAge());
        }
    }
