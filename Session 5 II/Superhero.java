public class Superhero {
    public String superhero_name = "";
    public int superpowers_number;
    public String[] superpowers = new String[superpowers_number];
    public boolean isAlive = false;
    public int universe = 0;

    public Superhero(String superhero_name_param, int superpowers_number, String[] superpowers_param,
            boolean isAlive_param, int universe_param) {
        this.superhero_name = superhero_name_param;
        this.superpowers_number = superpowers_number;
        this.superpowers = superpowers_param;
        this.isAlive = isAlive_param;
        this.universe = universe_param;
    }

    public String[] getSuperpowers() {
        return superpowers;
    }

    public void setSuperpowers(String[] superpowers) {
        this.superpowers = superpowers;
    }

    public void showSuperpowers() {
        for (String powers : superpowers) {
            System.out.print(powers + " ");
        }
        System.out.println();
    }

    public void watchSuperpowers() {
        for (int i = 0; i < this.superpowers.length; i++) {
            System.out.println(this.superpowers[i]);
        }
    }
}
