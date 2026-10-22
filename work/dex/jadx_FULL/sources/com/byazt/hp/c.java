package com.byazt.hp;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1019, 20})
public abstract class c {
    public JSONObject c;
    public com.byazt.xj.ve tt;
    public String ve;

    /* JADX INFO: renamed from: com.byazt.hp.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1019, 44})
    public static class C0424c {
        public static c c(com.byazt.xj.ve veVar, JSONObject jSONObject) {
            if (veVar == null || jSONObject == null) {
                return null;
            }
            String strOptString = jSONObject.optString("type");
            strOptString.hashCode();
            switch (strOptString) {
                case "stretch":
                    return new n(veVar, jSONObject);
                case "ripple":
                    return new tt(veVar, jSONObject);
                case "rub_in":
                    return new ve(veVar, jSONObject);
                case "shine":
                    return new uj(veVar, jSONObject);
                default:
                    return null;
            }
        }
    }

    public c(com.byazt.xj.ve veVar, JSONObject jSONObject) {
        this.c = jSONObject;
        this.tt = veVar;
        c();
    }

    public void c() {
        this.ve = this.c.optString("type");
        tt();
    }

    public abstract void c(int i, int i2);

    public abstract void c(Canvas canvas);

    public abstract void tt();

    public abstract void tt(Canvas canvas);

    public String uj() {
        return this.ve;
    }

    public abstract List<PropertyValuesHolder> ve();
}
