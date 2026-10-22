package cj.mobile.wm;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i9 {
    public int dexa = 5000;
    public int dexb = 5000;
    public String dexc = "GET";
    public String dexd = "UTF-8";
    public int dexe = 0;
    public boolean dexf = true;
    public String dexg;
    public Map<String, String> dexh;
    public Map<String, String> dexi;
    public String dexj;

    public Map<String, String> dexa() {
        return this.dexh;
    }

    public void dexa(String str) {
        this.dexj = str;
    }

    public void dexa(Map<String, String> map) {
        this.dexh = map;
    }

    public void dexa(boolean z) {
        this.dexf = z;
    }

    public String dexb() {
        return this.dexj;
    }

    public void dexb(String str) {
        if (TextUtils.equals("GET", str) || TextUtils.equals("POST", str)) {
            this.dexc = str;
        }
    }

    public void dexb(Map<String, String> map) {
        this.dexi = map;
    }

    public String dexc() {
        return this.dexc;
    }

    public void dexc(String str) {
        this.dexg = str;
    }

    public String dexd() {
        return this.dexg;
    }
}
