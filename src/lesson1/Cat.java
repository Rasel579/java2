package lesson1;

public class Cat implements Participants{
    private String name;
    private int maxJumpHeight;
    private int maxRunLength;
    Cat(String name, int maxJumpHeight, int maxRunLength){
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunLength = maxRunLength;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int run() {
        return maxRunLength;
    }

    @Override
    public int jump() {
        return maxJumpHeight;
    }
}
