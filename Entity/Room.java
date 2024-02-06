package Entity;

public class Room {
    private int id;
    private int otel_id;
    private String pansiyon;
    private String dönem;
    private String oda_tipi;
    private int stok;
    private int yetişkin_fiyat;
    private int çocuk_fiyat;
    private int yatak_kapasitesi;
    private int alan;
    private boolean tv;
    private boolean minibar;
    private boolean oyun_konsolu;
    private boolean kasa;
    private boolean projeksiyon;

    public Room() {
    }

    public Room(int id, int otel_id, String pansiyon, String dönem, String oda_tipi, int stok, int yetişkin_fiyat, int çocuk_fiyat,
                int yatak_kapasitesi, int alan, boolean tv, boolean minibar, boolean oyun_konsolu, boolean kasa, boolean projeksiyon) {
        this.id = id;
        this.otel_id = otel_id;
        this.pansiyon = pansiyon;
        this.dönem = dönem;
        this.oda_tipi = oda_tipi;
        this.stok = stok;
        this.yetişkin_fiyat = yetişkin_fiyat;
        this.çocuk_fiyat = çocuk_fiyat;
        this.yatak_kapasitesi = yatak_kapasitesi;
        this.alan = alan;
        this.tv = tv;
        this.minibar = minibar;
        this.oyun_konsolu = oyun_konsolu;
        this.kasa = kasa;
        this.projeksiyon = projeksiyon;
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

    public String getPansiyon() {
        return pansiyon;
    }

    public void setPansiyon(String pansiyon) {
        this.pansiyon = pansiyon;
    }

    public String getDönem() {
        return dönem;
    }

    public void setDönem(String dönem) {
        this.dönem = dönem;
    }

    public String getOda_tipi() {
        return oda_tipi;
    }

    public void setOda_tipi(String oda_tipi) {
        this.oda_tipi = oda_tipi;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getYetişkin_fiyat() {
        return yetişkin_fiyat;
    }

    public void setYetişkin_fiyat(int yetişkin_fiyat) {
        this.yetişkin_fiyat = yetişkin_fiyat;
    }

    public int getÇocuk_fiyat() {
        return çocuk_fiyat;
    }

    public void setÇocuk_fiyat(int çocuk_fiyat) {
        this.çocuk_fiyat = çocuk_fiyat;
    }

    public int getYatak_kapasitesi() {
        return yatak_kapasitesi;
    }

    public void setYatak_kapasitesi(int yatak_kapasitesi) {
        this.yatak_kapasitesi = yatak_kapasitesi;
    }

    public int getAlan() {
        return alan;
    }

    public void setAlan(int alan) {
        this.alan = alan;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isOyun_konsolu() {
        return oyun_konsolu;
    }

    public void setOyun_konsolu(boolean oyun_konsolu) {
        this.oyun_konsolu = oyun_konsolu;
    }

    public boolean isKasa() {
        return kasa;
    }

    public void setKasa(boolean kasa) {
        this.kasa = kasa;
    }

    public boolean isProjeksiyon() {
        return projeksiyon;
    }

    public void setProjeksiyon(boolean projeksiyon) {
        this.projeksiyon = projeksiyon;
    }
}
