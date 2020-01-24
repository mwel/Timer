package timer;

import java.util.Timer;
import java.util.TimerTask;

public class Model {

    private static int time;
    private Timer timer = new Timer();
    private TimerTask task;
    private boolean timerRunning = false;

    public void countDown(int time) {
        timerRunning = true;
        task = new TimerTask() {
            @Override
            public void run() {
                int remainder = time;
                System.out.println("Remaining: " + remainder);
                remainder--;
                if (remainder < 0) {
                    System.out.println("Countdown finished.");
                    reset();
                }
            }
        };
    }

    public void start() {
        timer.scheduleAtFixedRate(task, 1000, 1000);

    }

    public void pause() {


    }

    public void reset() {

        timer.cancel();
        time = 0;
        timerRunning = false;

    }

    public boolean isTimerRunning() {

        if (timerRunning)
            return true;
        else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        Model countDown = new Model();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Set timer: ");
//        time = scanner.nextInt();
//        System.out.println("Time set is: " + time + " seconds.");
//        countDown.start();
//
//    }


}
