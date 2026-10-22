package com.byazt.lw;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 133})
public class z implements com.byazt.dr.c {
    public Number c;

    public z(String str) {
        if (str.indexOf(46) < 0) {
            try {
                this.c = Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                this.c = Long.valueOf(str);
            }
        } else {
            Float fValueOf = Float.valueOf(str);
            this.c = fValueOf;
            if (Float.isInfinite(fValueOf.floatValue())) {
                this.c = Double.valueOf(str);
            }
        }
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        return this.c;
    }

    public String toString() {
        return tt();
    }

    @Override // com.byazt.dr.c
    public String tt() {
        return this.c.toString();
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.NUMBER;
    }
}
