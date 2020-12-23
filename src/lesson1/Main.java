package lesson1;

public class Main {

    public static void main(String[] args) {
       Human bob = new Human("bob", 1, 12);
       Cat harfield = new Cat("harfield", 2, 15);
       Robot boston = new Robot("boston", 4, 16);
       Participants[] participants = {bob, harfield, boston};
       Wall wallFirst = new Wall(1);
       Wall wallSecond = new Wall(2);
       Wall wallThird =  new Wall(3);
       Track trackFirst = new Track(1);
       Track trackSecond = new Track(2);
       Track trackThird =  new Track(10);
       Obstacle[] obstacles = {wallFirst, wallSecond, wallThird, trackFirst, trackSecond,trackThird };

        for (Participants participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (obstacle.start(participant)) {
                } else {
                    break;
                }
            }

        }

    }
}
