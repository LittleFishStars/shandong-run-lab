package com.byazt.eli;

import com.byazt.bwm.sp;
import com.byazt.bzd.u;
import com.byazt.bzd.x;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.wu.tt;
import com.huachenjie.common.constants.UserConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, UserConstants.LOGIN_ERROR.b, 20})
public class c {
    public final int c;

    public c(int i) {
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        x.c(new sp("csj-plugin-check") { // from class: com.byazt.eli.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.tt() == 5) {
                    tt.c();
                }
            }
        });
    }

    public void n() {
        JSONObject jSONObjectNq = gt.tt().nq();
        if (jSONObjectNq == null) {
            return;
        }
        try {
            c(jSONObjectNq, "com.byted.live.lite", 4, true);
            c(jSONObjectNq, "com.byted.csj.ext", 8, true);
            c(jSONObjectNq, "com.byted.mixed", 0, true);
            c(jSONObjectNq, "com.byted.pangle", 0, false);
        } catch (Throwable th) {
            m.tt("onReceiveServerStatus", th);
        }
    }

    public String toString() {
        return String.valueOf(this.c);
    }

    public int tt() {
        return c(4);
    }

    public int uj() {
        return 2;
    }

    public int ve() {
        return c(8);
    }

    public int c(int i) {
        int i2 = this.c >> i;
        int i3 = i2 & 7;
        if (i3 == 0) {
            return uj();
        }
        return ((i2 & 8) >> 3) == 1 ? -i3 : i3;
    }

    public c(int i, boolean z) {
        this.c = i;
        da.c().postDelayed(new Runnable() { // from class: com.byazt.eli.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.a();
            }
        }, 5000L);
    }

    public int c() {
        return c(0);
    }

    public int c(String str) {
        if ("com.byted.live.lite".equals(str)) {
            if (gt.tt().fb()) {
                return tt();
            }
            return 4;
        }
        if ("com.byted.csj.ext".equals(str)) {
            return ve();
        }
        if ("com.byted.pangle".equals(str)) {
            return c();
        }
        return uj();
    }

    private void c(JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        int iOptInt = jSONObjectOptJSONObject.optInt("state", 2);
        int iOptInt2 = jSONObjectOptJSONObject.optInt("plugin_v", 0);
        if (iOptInt == 5) {
            int iTt = u.tt(str);
            int iVe = u.ve(str);
            int iN = u.n(str);
            String strOptString = jSONObjectOptJSONObject.optString("api_rule", "=");
            String strOptString2 = jSONObjectOptJSONObject.optString("plugin_rule", "=");
            if (c(iTt, jSONObjectOptJSONObject.optInt("api_v", 0), strOptString)) {
                if ((z || iVe > iN) && c(iVe, iOptInt2, strOptString2)) {
                    u.c(str, 0);
                }
                List<Integer> listUj = u.uj(str);
                if (listUj != null) {
                    for (Integer num : listUj) {
                        if (num.intValue() != iVe && c(num.intValue(), iOptInt2, strOptString2)) {
                            u.c(str, num.intValue());
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (iOptInt == -1 && c(i) == 5 && u.ve(str) > u.n(str)) {
            u.c(str, iOptInt2);
        }
    }

    private boolean c(int i, int i2, String str) {
        str.hashCode();
        switch (str) {
            case "<":
                return i < i2;
            case "=":
            case "==":
                return i == i2;
            case ">":
                return i > i2;
            case "<=":
                return i <= i2;
            case ">=":
                return i >= i2;
            default:
                return false;
        }
    }
}
