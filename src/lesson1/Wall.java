package lesson1;

public class Wall implements Obstacle {
    private int height;
    Wall(int height){
        this.height = height;
    }


    public boolean start(Participants participants){
        if(participants.jump() > height){
            System.out.println(participants.getName() + " перепрыгнул " + this.height + " m.");
            return true;
        } else {
            System.out.println(participants.getName() + " не перепрыгнул " + this.height + " m.");
            return false;
        }
    };
}
