package timer;

public class Presenter {

    private Model model;
    private View view;
    private int time = 0;

    public void setModelAndView(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // Alles, was in der View passiert muss hier abgefangen werden. Am besten für jedes Event eine Methode.
    public void startButtonPressed(String enteredTime) {
        try {
            time = Integer.parseInt(enteredTime);
        } catch (NumberFormatException e) {
            e.fillInStackTrace();
        }

        if (isTimerReady()) {
            model.countDown(time);
            while (model.isTimerRunning()) {
                view.updateCountDownLabel();
            }
        }
        view.startB_OFF();
        view.pauseB_ON();
        view.resetB_ON();
    }

    public void pauseButtonPressed() {
        model.pause();
    }

    public void resetButtonPressed() {

        model.reset();
        view.pauseB_OFF();
        view.resetB_OFF();
        view.startB_ON();

    }

    public boolean isTimerReady() {

        // Wann darf timer überhaupt gestartet werdern?
        return !model.isTimerRunning();
    }

    public int getTime() {
        return time;
    }


}
