package com.byazt.yp;

import android.content.Context;
import android.location.Address;
import com.byazt.it.ve;
import com.byazt.vif.uj;
import com.byazt.vx.qy;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 215, 20})
public class c implements com.byazt.hw.tt {
    public Context c;
    public final String ve = "gm_sp_multi_ttmadnet_config";
    public final ve tt = uj.c(null, "gm_sp_multi_ttmadnet_config");

    public c(Context context) {
        this.c = context;
    }

    @Override // com.byazt.hw.tt
    public String[] a() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }

    @Override // com.byazt.hw.tt
    public int c() {
        return 4741;
    }

    @Override // com.byazt.hw.tt
    public Address c(Context context) {
        return null;
    }

    @Override // com.byazt.hw.tt
    public String c(Context context, String str, String str2) {
        return this.tt.getString(str, str2);
    }

    @Override // com.byazt.hw.tt
    public Context getContext() {
        return this.c;
    }

    @Override // com.byazt.hw.tt
    public String n() {
        return qy.c();
    }

    @Override // com.byazt.hw.tt
    public String tt() {
        return "msdk";
    }

    @Override // com.byazt.hw.tt
    public int uj() {
        return com.byazt.yl.tt.c();
    }

    @Override // com.byazt.hw.tt
    public String ve() {
        return "android";
    }

    @Override // com.byazt.hw.tt
    public void c(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.tt.put(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.tt.put(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.tt.put(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.tt.put(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.tt.put(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
