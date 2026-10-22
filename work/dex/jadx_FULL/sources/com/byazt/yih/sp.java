package com.byazt.yih;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.aas.nb;
import com.byazt.dk.z;
import com.byazt.nr.da;
import com.byazt.nr.m;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 91})
public class sp implements uj {
    public ve c;

    public sp(ve veVar) {
        this.c = veVar;
    }

    @Override // com.byazt.yih.uj
    public boolean c(final com.byazt.qt.c cVar) {
        if (!this.c.ve()) {
            return false;
        }
        long jUj = this.c.uj();
        final com.byazt.ocd.tt ttVarC = z.c();
        if (ttVarC == null || !c(1440L, this.c.sp())) {
            return false;
        }
        da.c().postDelayed(new Runnable() { // from class: com.byazt.yih.sp.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("app_name", cVar.c());
                map.put("app_icon_url", cVar.tt());
                map.put("event_id", Integer.valueOf(cVar.uj()));
                map.put("package_name", cVar.ve());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("value", cVar.x());
                    jSONObject.putOpt("log_extra", cVar.n());
                    jSONObject.putOpt("tag", cVar.sp());
                    jSONObject.putOpt("download_url", cVar.da());
                    jSONObject.putOpt("save_path", cVar.i());
                } catch (Exception unused) {
                }
                boolean zTt = nb.tt(cVar.ve());
                map.put("event_token", com.byazt.nr.c.tt(jSONObject.toString()));
                ttVarC.c(zTt ? 102 : 101, map);
            }
        }, jUj * 1000);
        return true;
    }

    @Override // com.byazt.yih.uj
    public boolean tt(com.byazt.qt.c cVar) {
        return false;
    }

    public boolean c(long j, int i) {
        try {
            Long lValueOf = -1L;
            boolean z = true;
            try {
                lValueOf = Long.valueOf(j * 60 * 1000);
            } catch (Exception e) {
                m.tt("notification", "error", e.getMessage());
                i = -1;
            }
            if (lValueOf.longValue() >= 0 && i >= 0 && lValueOf.longValue() != 0 && i != 0) {
                String strC = c();
                StringBuilder sb = new StringBuilder();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(strC)) {
                    sb.append(jCurrentTimeMillis);
                    c(sb.toString());
                    return true;
                }
                String[] strArrSplit = strC.split(LoginConstants.UNDER_LINE);
                int length = strArrSplit.length;
                if (length < i) {
                    Long.parseLong(strArrSplit[length - 1]);
                    for (String str : strArrSplit) {
                        sb.append(str);
                        sb.append(LoginConstants.UNDER_LINE);
                    }
                    sb.append(jCurrentTimeMillis);
                    c(sb.toString());
                    return true;
                }
                int i2 = length - i;
                if (jCurrentTimeMillis - Long.valueOf(Long.parseLong(strArrSplit[i2])).longValue() <= lValueOf.longValue()) {
                    z = false;
                }
                for (int i3 = i2; i3 < length; i3++) {
                    String str2 = strArrSplit[i3];
                    if (i3 != i2 && !TextUtils.isEmpty(str2)) {
                        sb.append(str2);
                        sb.append(LoginConstants.UNDER_LINE);
                    }
                }
                sb.append(jCurrentTimeMillis);
                c(sb.toString());
                return z;
            }
            return false;
        } catch (Exception e2) {
            m.c(e2);
            return false;
        }
    }

    public static String c() {
        return com.byazt.omf.tt.c().get("notification_b", "");
    }

    public static void c(String str) {
        com.byazt.omf.tt.c().put("notification_b", str);
    }
}
