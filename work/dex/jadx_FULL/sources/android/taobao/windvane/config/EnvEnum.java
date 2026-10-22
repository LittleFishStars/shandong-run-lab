package android.taobao.windvane.config;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public enum EnvEnum {
    ONLINE(0, "m"),
    PRE(1, "wapa"),
    DAILY(2, "waptest");

    private int key;
    private String value;

    EnvEnum(int i, String str) {
        this.key = i;
        this.value = str;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(int i) {
        this.key = i;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
