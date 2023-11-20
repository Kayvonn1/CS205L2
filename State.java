package edu.monmouth.lab2;

import java.util.Objects;

public class State {
    private String name;
    private int coastLength;
    private String bird;

    public State(String name, int coastLength, String bird) {
        this.name = name;
        this.coastLength = coastLength;
        this.bird = bird;
    }

    public String getName() {
        return name;
    }

    public int getcoastLength() {
        return coastLength;
    }

    public String getBird() {
        return bird;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State state = (State) obj;
        return coastLength == state.coastLength && Objects.equals(name, state.name) && Objects.equals(bird, state.bird);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + coastLength;
        result = 31 * result + bird.hashCode();
        return result;
    }
}
