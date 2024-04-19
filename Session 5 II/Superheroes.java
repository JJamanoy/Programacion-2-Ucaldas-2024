import java.util.ArrayList;

public class Superheroes {
    ArrayList<Superhero> dc_superheroes = new ArrayList<>();

    public void addSuperheroes() {
        dc_superheroes.add(new Superhero("Batman", 2, new String[] {
                "Be richest", "Intelligent" }, false, 1));

        dc_superheroes.add(new Superhero("Superman", 3, new String[] {
                "Fly", "Laser eyes", "Super Strength" }, true, 1));
    }

    public void showSuperheroesInformation() {
        for (int i = 0; i < dc_superheroes.size(); i++) {
            System.out.println(dc_superheroes.get(i).superhero_name);
        }
    }
}