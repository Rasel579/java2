package lesson1;

public class Robot implements Participants {
    private String name;
    private int maxJumpHeight;
    private int maxRunLength;
    Robot(String name, int maxJumpHeight, int maxRunLength){
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int jump() {
        return maxJumpHeight;
    }

    @Override
    public int run() {
        return maxRunLength;
    }
}
