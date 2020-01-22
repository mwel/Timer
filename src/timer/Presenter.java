package timer;

public class Presenter {

    private Model model;
    private View view;
    private double time = 0.0;

    public void setModelAndView(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void countDown (int time){}

}
