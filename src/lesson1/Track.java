    package lesson1;

    public class Track implements Obstacle{
        private int length;
        Track(int length){
            this.length = length;
        }

        @Override
        public boolean start(Participants participants) {
            if(participants.run() > length){
                System.out.println(participants.getName() + " пробежал " + this.length + " m.");
                return true;
            } else {
                System.out.println(participants.getName() + " не пробежал " + this.length + " m.");
                return false;
            }
        }

    }
