package com.byazt.hr;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 72})
public class da {
    public static final String c = "TTMediationSDK_" + da.class.getSimpleName();
    public Map<String, i> tt;
    public com.byazt.jd.ve<i> ve;

    @com.byazt.zqa.c(c = {0, 1, 29, 45})
    public static class c {
        public static da c = new da();
    }

    public static da c() {
        return c.c;
    }

    public i tt(String str) {
        if (this.ve == null) {
            return null;
        }
        Map<String, i> map = this.tt;
        i iVar = map != null ? map.get(str) : null;
        if (iVar != null) {
            return iVar;
        }
        i iVarQuery = this.ve.query(str);
        if (iVarQuery != null) {
            this.tt.put(iVarQuery.tt(), iVarQuery);
        }
        return iVarQuery;
    }

    private da() {
        this.ve = new com.byazt.jd.uj(com.byazt.bp.tt.getContext());
        this.tt = new ConcurrentHashMap();
    }

    public void c(String str, long j) {
        if (this.ve != null) {
            Map<String, i> map = this.tt;
            i iVar = map != null ? map.get(str) : null;
            if (iVar != null) {
                iVar.c(j);
            }
            this.ve.c(str, j);
        }
    }

    public i tt(String str, String str2) {
        i iVar = null;
        if (this.ve == null) {
            return null;
        }
        Map<String, i> map = this.tt;
        if (map != null) {
            iVar = map.get(str + LoginConstants.UNDER_LINE + str2);
        }
        if (iVar != null) {
            return iVar;
        }
        i iVarQuery = this.ve.query(str, str2);
        if (iVarQuery != null) {
            this.tt.put(iVarQuery.uj(), iVarQuery);
        }
        return iVarQuery;
    }

    public void c(String str, String str2, long j) {
        i iVar;
        if (this.ve != null) {
            Map<String, i> map = this.tt;
            if (map != null) {
                iVar = map.get(str + LoginConstants.UNDER_LINE + str2);
            } else {
                iVar = null;
            }
            if (iVar != null) {
                iVar.c(j);
            }
            this.ve.c(str, str2, j);
        }
    }

    public void c(String str) {
        if (this.ve != null) {
            Map<String, i> map = this.tt;
            if (map != null) {
                map.remove(str);
            }
            this.ve.delete(str);
        }
    }

    public void c(String str, String str2) {
        if (this.ve != null) {
            Map<String, i> map = this.tt;
            if (map != null) {
                map.remove(str + LoginConstants.UNDER_LINE + str2);
            }
            this.ve.delete(str, str2);
        }
    }

    public void c(i iVar) {
        if (this.ve == null || TextUtils.isEmpty(iVar.da())) {
            return;
        }
        Map<String, i> map = this.tt;
        if (map != null) {
            map.put(iVar.uj(), iVar);
        }
        this.ve.tt(iVar);
    }
}
