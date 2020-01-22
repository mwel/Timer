package timer;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Model {

    private static int time;
    Timer timer = new Timer();
    TimerTask task;

    public void countDown(int time) {
        task = new TimerTask() {
            @Override
            public void run() {
                int remainder = time;
                System.out.println("Remaining: " + remainder);
                remainder--;
                if (remainder < 0) {
                    System.out.println("Countdown finished.");
                    timer.cancel();
                }
            }
        };
    }

    public void start() {
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public static void main(String[] args) {
        Model countDown = new Model();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Set timer: ");
        time = scanner.nextInt();
        System.out.println("Time set is: " + time + " seconds.");
        countDown.start();

    }

}
