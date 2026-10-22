package com.byazt.pct;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, 110})
public class qy {
    public final Collection<String> c;
    public final Map<String, rl> tt;
    public final Set<c> uj;
    public final sl ve;

    public interface c {
    }

    public rl c(String str) {
        if (this.c.contains(str) || TextUtils.equals(str, com.alipay.sdk.m.n.c.f)) {
            return c(str, null);
        }
        throw new IllegalArgumentException("Namespace: " + str + " not registered.");
    }

    public void tt(c cVar) {
        this.uj.remove(cVar);
    }

    public void c(c cVar) {
        this.uj.add(cVar);
    }

    private rl c(String str, JSONObject jSONObject) {
        rl rlVar = this.tt.get(str);
        if (rlVar == null) {
            rl rlVar2 = new rl(str, this.ve.ve(), this.ve.c(), this.ve.tt(), jSONObject);
            this.tt.put(str, rlVar2);
            return rlVar2;
        }
        if (jSONObject == null) {
            return rlVar;
        }
        rlVar.update(jSONObject);
        return rlVar;
    }
}
