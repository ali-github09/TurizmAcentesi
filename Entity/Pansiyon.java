package Entity;

public class Pansiyon {
    private int id;
    private int otel_id;
    private String pansiyon_name;

    public Pansiyon() {
    }

    public Pansiyon(int id, int otel_id, String pansiyon_name) {
        this.id = id;
        this.otel_id = otel_id;
        this.pansiyon_name = pansiyon_name;
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

    public String getPansiyon_name() {
        return pansiyon_name;
    }

    public void setPansiyon_name(String pansiyon_name) {
        this.pansiyon_name = pansiyon_name;
    }

    @Override
    public String toString() {
        return "Pansiyon{" +
                "id=" + id +
                ", otel_id=" + otel_id +
                ", pansiyon_name='" + pansiyon_name + '\'' +
                '}';
    }
}
