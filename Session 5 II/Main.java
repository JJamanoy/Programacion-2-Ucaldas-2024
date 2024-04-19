public class Main {
    public static void main(String[] args) {
        Superhero hero = new Superhero("Batman", 2, new String[] { "Be richest", "Intelligent" }, false, 1);
        Superhero hero1 = new Superhero("Superman", 3, new String[] { "Fly", "Laser eyes", "Super Strength" }, true, 1);

        hero.showSuperpowers();
        hero1.showSuperpowers();

        hero.watchSuperpowers();
        hero1.watchSuperpowers();
    }
}