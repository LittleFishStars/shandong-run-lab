package com.getui.gtc.dim.b;

import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.db.DbManager;
import com.getui.gtc.dim.Caller;
import com.zj.adlib.u15;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f30306a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f30307a = new d(0);
    }

    private d() {
        this.f30306a = new HashMap();
        try {
            DbManager.init(GtcProvider.context(), com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class);
            ((com.getui.gtc.dim.a.b) DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a();
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public static h a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ((com.getui.gtc.dim.a.b) DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a(str);
    }

    public static boolean a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((com.getui.gtc.dim.a.b) DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a(str, obj);
    }

    private Long b(String str) {
        try {
            if (this.f30306a.containsKey(str)) {
                return this.f30306a.get(str);
            }
            d unused = a.f30307a;
            h hVarA = a(str);
            Long l = hVarA != null ? (Long) hVarA.f30314a : null;
            com.getui.gtc.dim.e.b.a("dim interval from db : " + str + " : " + l);
            this.f30306a.put(str, l);
            return l;
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("interval", th);
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static long c(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 320892099:
                if (str.equals("dim-2-1-14-1")) {
                    b = 0;
                }
                break;
            case 320894021:
                if (str.equals("dim-2-1-16-1")) {
                    b = 1;
                }
                break;
            case 320894022:
                if (str.equals("dim-2-1-16-2")) {
                    b = 2;
                }
                break;
            case 320894982:
                if (str.equals("dim-2-1-17-1")) {
                    b = 3;
                }
                break;
            case 320894983:
                if (str.equals("dim-2-1-17-2")) {
                    b = 4;
                }
                break;
            case 320894984:
                if (str.equals("dim-2-1-17-3")) {
                    b = 5;
                }
                break;
            case 320894985:
                if (str.equals("dim-2-1-17-4")) {
                    b = 6;
                }
                break;
            case 320895943:
                if (str.equals("dim-2-1-18-1")) {
                    b = 7;
                }
                break;
            case 320895944:
                if (str.equals("dim-2-1-18-2")) {
                    b = 8;
                }
                break;
            case 320895945:
                if (str.equals("dim-2-1-18-3")) {
                    b = 9;
                }
                break;
            case 320895946:
                if (str.equals("dim-2-1-18-4")) {
                    b = 10;
                }
                break;
            case 320896904:
                if (str.equals("dim-2-1-19-1")) {
                    b = 11;
                }
                break;
            case 320896905:
                if (str.equals("dim-2-1-19-2")) {
                    b = 12;
                }
                break;
            case 320919007:
                if (str.equals("dim-2-1-21-1")) {
                    b = 13;
                }
                break;
            case 320919008:
                if (str.equals("dim-2-1-21-2")) {
                    b = com.google.common.base.a.p;
                }
                break;
            case 320919009:
                if (str.equals("dim-2-1-21-3")) {
                    b = com.google.common.base.a.q;
                }
                break;
            case 320919011:
                if (str.equals("dim-2-1-21-5")) {
                    b = com.google.common.base.a.r;
                }
                break;
            case 1672919129:
                if (str.equals("dim-2-1-1-1")) {
                    b = 17;
                }
                break;
            case 1672919131:
                if (str.equals("dim-2-1-1-3")) {
                    b = com.google.common.base.a.u;
                }
                break;
            case 1672919132:
                if (str.equals("dim-2-1-1-4")) {
                    b = 19;
                }
                break;
            case 1672920090:
                if (str.equals("dim-2-1-2-1")) {
                    b = com.google.common.base.a.x;
                }
                break;
            case 1672920092:
                if (str.equals("dim-2-1-2-3")) {
                    b = com.google.common.base.a.y;
                }
                break;
            case 1672920093:
                if (str.equals("dim-2-1-2-4")) {
                    b = com.google.common.base.a.z;
                }
                break;
            case 1672921051:
                if (str.equals("dim-2-1-3-1")) {
                    b = com.google.common.base.a.A;
                }
                break;
            case 1672921052:
                if (str.equals("dim-2-1-3-2")) {
                    b = com.google.common.base.a.B;
                }
                break;
            case 1672922012:
                if (str.equals("dim-2-1-4-1")) {
                    b = com.google.common.base.a.C;
                }
                break;
            case 1672922973:
                if (str.equals("dim-2-1-5-1")) {
                    b = com.google.common.base.a.D;
                }
                break;
            case 1672922974:
                if (str.equals("dim-2-1-5-2")) {
                    b = com.google.common.base.a.E;
                }
                break;
            case 1672923934:
                if (str.equals("dim-2-1-6-1")) {
                    b = com.google.common.base.a.F;
                }
                break;
            case 1672923936:
                if (str.equals("dim-2-1-6-3")) {
                    b = com.google.common.base.a.G;
                }
                break;
            case 1672923937:
                if (str.equals("dim-2-1-6-4")) {
                    b = com.google.common.base.a.H;
                }
                break;
            case 1672924895:
                if (str.equals("dim-2-1-7-1")) {
                    b = 31;
                }
                break;
            case 1672925856:
                if (str.equals("dim-2-1-8-1")) {
                    b = 32;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return 5000L;
            case 13:
            case 14:
            case 15:
            case 16:
                return ConfigStorage.DEFAULT_MAX_AGE;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                return 86400000L;
            default:
                return 0L;
        }
    }

    public final Long a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return b(str + u15.f19942b + Caller.valueOf(str2).name());
        }
        g gVarD = g.d();
        int iC = gVarD.c();
        com.getui.gtc.dim.b.a aVarA = com.getui.gtc.dim.b.a.a(str);
        if (aVarA == null) {
            return null;
        }
        Long l = null;
        for (Caller caller : Caller.values()) {
            if (caller.containAt(iC)) {
                Boolean boolB = gVarD.b(aVarA.f30301a, caller.name());
                Long lB = b(str + u15.f19942b + caller.name());
                com.getui.gtc.dim.e.b.a("dim check interval for " + str + ", inited caller = " + caller + ", callable = " + boolB + ", interval = " + lB);
                if (boolB == null || boolB.booleanValue()) {
                    if (lB == null) {
                        return null;
                    }
                    if (l == null || lB.longValue() < l.longValue()) {
                        l = lB;
                    }
                }
            }
        }
        return l;
    }

    public final void a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f30306a.put(str, Long.valueOf(j));
        com.getui.gtc.dim.e.b.a("dim storage globalValidTime set: " + str + " : " + j);
    }

    public final boolean a(h hVar, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jC = c(str);
        Long l = this.f30306a.get(str);
        if (l == null) {
            l = this.f30306a.get("dim-2-2-0-1");
        }
        long jLongValue = l != null ? l.longValue() : jC;
        Long lA = null;
        if ((g.d().a() & 2) != 0) {
            com.getui.gtc.dim.b.a aVarA = com.getui.gtc.dim.b.a.a(str);
            if (aVarA != null) {
                lA = a(aVarA.b, (String) null);
            }
        } else {
            com.getui.gtc.dim.e.b.a("dim ig in");
        }
        if (lA != null) {
            jLongValue = lA.longValue();
        }
        com.getui.gtc.dim.e.b.a("dim storageValidTime check for " + str + ", dycValue = " + l + ", localValue = " + jC + ", interval = " + lA + ", use " + jLongValue);
        boolean z = jCurrentTimeMillis - hVar.b > jLongValue;
        if (z) {
            com.getui.gtc.dim.e.b.b("dim storage source expired for ".concat(String.valueOf(str)));
        }
        return z;
    }
}
