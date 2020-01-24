package timer;

import java.util.Timer;
import java.util.TimerTask;

public class Model {

    private int time;

    private boolean timerRunning = false;
    private Timer timer;


    public void countDown(int time) {
        timerRunning = true;
        TimerTask clockWork = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Remainder is: " + getTime());
                countDownTime();
                if (time <= 0) {
                    System.out.println("Countdown finished.");
                    reset();
                }
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(clockWork, 1000, 1000);

    }

    public void pause() {
        if (timerRunning) {
            timerRunning = false;
        } else {
            timerRunning = true;
        }
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

    public int getTime() {
        return time;
    }

    public void countDownTime() {
        time--;
    }
}
