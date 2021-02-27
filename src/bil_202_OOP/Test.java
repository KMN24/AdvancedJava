package bil_202_OOP;// hw Java OOP - BIL-202

class Footballer {
    String name;
    String surname;
    String position;
    int height;
    Float weight;
    void infoAboutPlayer(){
        System.out.println( this.name + " " + this.surname + "'s height " + this.height + "cm and weight " + this.weight +"kg");

    }
    String getPosition(){
        return this.name +" is a " + this.position;
    }
    boolean isForward(){
        if (this.position.toLowerCase().equals("forward"))
            return true;
        else
            return false;
    }
}
public class Test extends Footballer {

    public static void main(String[] args) {
        Footballer footballer1 = new Footballer();
        footballer1.name = "Ronaldo";
        footballer1.surname = "Cristiano";
        footballer1.height = 189;
        footballer1.weight = 85F;
        footballer1.position = "Forward";
        footballer1.infoAboutPlayer();
        System.out.println(footballer1.getPosition());
        if (footballer1.isForward())
            System.out.println("Yes, he is");
        else
            System.out.println("No, he isn't");

        System.out.println();
        Footballer footballer2 = new Footballer();
        footballer2.name = "Messi";
        footballer2.surname = "Lionel";
        footballer2.height = 170;
        footballer2.weight = 72F;
        footballer2.position = "Forward";
        footballer2.infoAboutPlayer();
        System.out.println(footballer2.getPosition());
        if (footballer2.isForward())
            System.out.println("Yes, he is");
        else
            System.out.println("No, he isn't");
    }

}
