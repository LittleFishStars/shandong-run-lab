package com.byazt.vd;

import android.text.TextUtils;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1582, 20})
public abstract class c {
    public static final HashSet<String> c = new HashSet<>(Arrays.asList("convert", com.byazt.dyf.tt.AD_TAG_DISLIKE, "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", "close", FreeSpaceBox.TYPE, "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f29129a;
    public String n;
    public String sp;
    public com.byazt.pm.a.c tt;
    public String uj;
    public com.byazt.xj.ve ve;
    public String x;

    /* JADX INFO: renamed from: com.byazt.vd.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1582, 44})
    public static class C0556c {
        public static c c(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
            c cVarC;
            if (cVar == null) {
                return null;
            }
            com.byazt.pm.tt ttVarC = com.byazt.pm.uj.c(cVar.tt());
            if (ttVarC == null && (TextUtils.isEmpty(cVar.c()) || !TextUtils.equals(cVar.c(), "global"))) {
                ttVarC = com.byazt.pm.uj.c(cVar.n());
            }
            return (ttVarC == null || (cVarC = ttVarC.c(veVar, str, cVar)) == null) ? new ve(veVar, str, cVar) : cVarC;
        }
    }

    public c(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        this.ve = veVar;
        this.tt = cVar;
        this.sp = str;
        n();
    }

    private void n() {
        com.byazt.pm.a.c cVar = this.tt;
        if (cVar == null) {
            return;
        }
        this.uj = cVar.c();
        this.n = this.tt.tt();
        Map<String, Object> mapVe = this.tt.ve();
        this.f29129a = mapVe;
        if (mapVe == null || mapVe.isEmpty() || !this.f29129a.containsKey("emitCustomEvent") || !(this.f29129a.get("emitCustomEvent") instanceof String)) {
            return;
        }
        this.x = (String) this.f29129a.get("emitCustomEvent");
    }

    public abstract void c();

    public void tt() {
        ve();
    }

    public boolean uj() {
        return !TextUtils.isEmpty(this.x);
    }

    public void ve() {
        if (uj()) {
            com.byazt.pm.a.c cVar = new com.byazt.pm.a.c();
            cVar.c("custom");
            cVar.tt("emit");
            HashMap map = new HashMap();
            map.put("name", this.x);
            cVar.c(map);
            new tt(this.ve, this.n, cVar).c();
        }
    }
}
