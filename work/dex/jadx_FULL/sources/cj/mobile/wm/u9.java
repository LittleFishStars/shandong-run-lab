package cj.mobile.wm;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u9 extends s9 {
    public String dexc;

    @Override // cj.mobile.wm.s9
    public Map<String, Object> dexb() {
        return null;
    }

    public void dexb(String str) {
        this.dexc = str;
    }

    @Override // cj.mobile.wm.s9
    public String dexd() {
        if (!TextUtils.isEmpty(this.dexc)) {
            if (this.dexc.contains("__TIMESTAMP__")) {
                this.dexc = this.dexc.replaceAll("__TIMESTAMP__", String.valueOf(System.currentTimeMillis() / 1000));
            }
            if (this.dexc.contains("__MTYPE__")) {
                String str = (this.dexa.dexb() == null || !this.dexa.dexb().containsKey("type")) ? "" : (String) this.dexa.dexb().get("type");
                if (!TextUtils.isEmpty(str)) {
                    this.dexc = this.dexc.replaceAll("__MTYPE__", str);
                }
            }
        }
        f1.dexa("ExposeRequestBuilder", "getUrl : " + this.dexc);
        return this.dexc;
    }

    @Override // cj.mobile.wm.s9
    public boolean dexe() {
        return false;
    }
}
