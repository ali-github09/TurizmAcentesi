package Entity;

import Core.ComboItem;

public class Season {
    private int id;
    private int otel_id;
    private String start_date;
    private String finish_date;

    public Season() {
    }

    public Season(int id, int otel_id, String start_date, String finish_date) {
        this.id = id;
        this.otel_id = otel_id;
        this.start_date = start_date;
        this.finish_date = finish_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOtel_id() {
        return otel_id;
    }

    public void setOtel_id(int otel_id) {
        this.otel_id = otel_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(String finish_date) {
        this.finish_date = finish_date;
    }

    public ComboItem getComboItem(){
        return new ComboItem(this.getId(), "( Start Date: -> " + this.getStart_date() + " - "+" Finish Date: -> " + this.getFinish_date() + ")");
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
                ", otel_id=" + otel_id +
                ", start_date='" + start_date + '\'' +
                ", finish_date='" + finish_date + '\'' +
                '}';
    }
}
