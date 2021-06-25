package hr.java.covid_tracker.dashboard;

public class Dashboard {

    private String label;
    private int y;

    public Dashboard(String label, int y) {
        this.label = label;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
