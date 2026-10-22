package cj.mobile.wm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex01 implements dexz {
    public int dexa;
    public String dexb;

    @Override // cj.mobile.wm.dexz
    public int a() {
        return this.dexa;
    }

    public void dexa(int i) {
        this.dexa = i;
    }

    public void dexa(String str) {
        this.dexb = str;
    }

    @Override // cj.mobile.wm.dexz
    public String getUrl() {
        return this.dexb;
    }
}
