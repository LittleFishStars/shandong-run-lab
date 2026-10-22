package cj.mobile.wm;

import android.text.TextUtils;
import com.zj.adlib.ze1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class s9 {
    public q9 dexa;
    public final Map<String, String> dexb = new HashMap();

    private void dexa(i9 i9Var) {
        Map<String, Object> mapDexc = dexc();
        HashMap map = new HashMap();
        if (mapDexc != null && !mapDexc.isEmpty()) {
            map.putAll(mapDexc);
        }
        Map<String, Object> mapDexb = dexb();
        if (mapDexb != null && !mapDexb.isEmpty()) {
            map.putAll(mapDexb);
        }
        if (dexe()) {
            i9Var.dexa(dex04.b(map));
            return;
        }
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            map2.put(str, String.valueOf(map.get(str)));
        }
        i9Var.dexb(map2);
    }

    private void dexb(i9 i9Var) {
        i9Var.dexa(true);
        i9Var.dexb(dexe() ? "POST" : "GET");
    }

    private void dexc(i9 i9Var) {
        this.dexb.put("Content-Type", ze1.g);
        i9Var.dexa(this.dexb);
    }

    public i9 dexa(q9 q9Var) {
        this.dexa = q9Var;
        i9 i9Var = new i9();
        dexc(i9Var);
        i9Var.dexc(dexd());
        dexa(i9Var);
        dexb(i9Var);
        return i9Var;
    }

    public String dexa() {
        return ge.dexa(String.format("funtee_android_%s_%d_%d", tc.dexa(g1.dexc().dexa()), Long.valueOf(System.currentTimeMillis()), Integer.valueOf((int) (Math.random() * 10000.0d))));
    }

    public String dexa(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public abstract Map<String, Object> dexb();

    public Map<String, Object> dexc() {
        return new HashMap();
    }

    public abstract String dexd();

    public abstract boolean dexe();
}
