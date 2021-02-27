class Football {
    String nameOfFootball;
    String typeOfFootball;

    void info() {
        switch (this.typeOfFootball.toLowerCase().toCharArray()[0]) {
            case 'a', 'e', 'i', 'o', 'u' -> {
                System.out.println(this.nameOfFootball + " is an " + this.typeOfFootball + " sport");
                break;
            }
            default -> System.out.println(this.nameOfFootball + " is a " + this.typeOfFootball + " sport");
        }
    }

    void category(int countPlayer) {
        switch (countPlayer) {
            case 1 -> System.out.println(this.nameOfFootball + " is a individual sport");
            case 2 -> System.out.println(this.nameOfFootball + " is a dual sport");
            default -> System.out.println(this.nameOfFootball + " is a team sport");
        }
    }
}

class SoccerClubs extends Football {
    String stadium;
    String country;
    String club;

    @Override
    void info() {
        switch (super.typeOfFootball.toLowerCase().toCharArray()[0]){
            case 'a', 'e', 'i', 'o', 'u' ->{
                System.out.println(super.nameOfFootball + " is an " + super.typeOfFootball + " sport");
                break;
            }
            default -> System.out.println(super.nameOfFootball + " is a " + super.typeOfFootball + " sport");
        }
        System.out.println("Soccer is a team sport played by a team of 11 players against another team of 11 players on a field.");
    }

    void aboutStadium(int capacity) {
        System.out.println(this.club + " Football Club is located in " + this.country);
        System.out.println("Capacity of " + this.stadium + " is " + capacity + " people");
    }

}

public class Homework2 {
    public static void main(String[] args) {
        Football americanFootball = new Football();
        americanFootball.nameOfFootball = "American football";
        americanFootball.typeOfFootball = "international";
        americanFootball.info();
        americanFootball.category(11);

        System.out.println();

        SoccerClubs mu = new SoccerClubs(); // mu - Manchester United Football Club
        mu.nameOfFootball = "Soccer";
        mu.club = "Manchester United";
        mu.stadium = "Old Trafford";
        mu.country = "United Kingdom";
        mu.typeOfFootball = "international";
        mu.info();
        mu.aboutStadium(76000);
    }
}
