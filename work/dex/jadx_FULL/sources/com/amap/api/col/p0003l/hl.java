package com.amap.api.col.p0003l;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.maps.AMapException;
import com.zj.adlib.i9b;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class hl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f25967a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static hl f923a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f924a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static HashMap<String, String> f925a;
    public static HashMap<String, String> b;
    public static HashMap<String, String> c;

    public interface a {
        URLConnection a();
    }

    public hl() {
        fh.O();
    }

    public static hs.b a(hs hsVar, boolean z) {
        if (hsVar.getDegradeAbility() == hs.a.FIX) {
            return hs.b.FIX_NONDEGRADE;
        }
        if (hsVar.getDegradeAbility() == hs.a.SINGLE) {
            return hs.b.NEVER_GRADE;
        }
        return z ? hs.b.FIRST_NONDEGRADE : hs.b.NEVER_GRADE;
    }

    public static hl b() {
        if (f923a == null) {
            f923a = new hl();
        }
        return f923a;
    }

    public static boolean c(hs hsVar) throws ff {
        d(hsVar);
        try {
            if (!b(hsVar)) {
                return true;
            }
            if (hsVar.getURL().equals(hsVar.getIPV6URL()) || hsVar.getDegradeAbility() == hs.a.SINGLE || !fh.f857f) {
                return false;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public static void d(hs hsVar) throws ff {
        if (hsVar == null) {
            throw new ff("requeust is null");
        }
        if (hsVar.getURL() == null || "".equals(hsVar.getURL())) {
            throw new ff("request url is empty");
        }
    }

    public static i9b e(hs hsVar) throws ff {
        return g(hsVar, hsVar.isHttps());
    }

    public static i9b f(hs hsVar, hs.b bVar, int i) throws ff {
        try {
            d(hsVar);
            hsVar.setDegradeType(bVar);
            hsVar.setReal_max_timeout(i);
            return new u().x(hsVar);
        } catch (ff e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new ff(AMapException.ERROR_UNKNOWN);
        }
    }

    @Deprecated
    public static i9b g(hs hsVar, boolean z) throws ff {
        byte[] bArr;
        d(hsVar);
        hsVar.setHttpProtocol(z ? hs.c.HTTPS : hs.c.HTTP);
        i9b i9bVarF = null;
        long jElapsedRealtime = 0;
        boolean z2 = false;
        if (b(hsVar)) {
            boolean zC = c(hsVar);
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                i9bVarF = f(hsVar, a(hsVar, zC), c(hsVar, zC));
            } catch (ff e) {
                if ((e.f() == 21 && hsVar.getDegradeAbility() == hs.a.INTERRUPT_IO) || !zC) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (i9bVarF != null && (bArr = i9bVarF.f17171a) != null && bArr.length > 0) {
            return i9bVarF;
        }
        try {
            return f(hsVar, b(hsVar, z2), a(hsVar, jElapsedRealtime));
        } catch (ff e2) {
            throw e2;
        }
    }

    public static hs.b b(hs hsVar, boolean z) {
        if (hsVar.getDegradeAbility() == hs.a.FIX) {
            return z ? hs.b.FIX_DEGRADE_BYERROR : hs.b.FIX_DEGRADE_ONLY;
        }
        return z ? hs.b.DEGRADE_BYERROR : hs.b.DEGRADE_ONLY;
    }

    public static int a(hs hsVar, long j) {
        try {
            d(hsVar);
            long jElapsedRealtime = 0;
            if (j != 0) {
                jElapsedRealtime = SystemClock.elapsedRealtime() - j;
            }
            int conntectionTimeout = hsVar.getConntectionTimeout();
            if (hsVar.getDegradeAbility() != hs.a.FIX && hsVar.getDegradeAbility() != hs.a.SINGLE) {
                long j2 = conntectionTimeout;
                if (jElapsedRealtime < j2) {
                    long j3 = j2 - jElapsedRealtime;
                    if (j3 >= 1000) {
                        return (int) j3;
                    }
                }
                return Math.min(1000, hsVar.getConntectionTimeout());
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    public static boolean b(hs hsVar) throws ff {
        d(hsVar);
        try {
            String ipv6url = hsVar.getIPV6URL();
            if (TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            String host = new URL(ipv6url).getHost();
            if (!TextUtils.isEmpty(hsVar.getIPDNSName())) {
                host = hsVar.getIPDNSName();
            }
            return fh.T(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static int c(hs hsVar, boolean z) {
        try {
            d(hsVar);
            int conntectionTimeout = hsVar.getConntectionTimeout();
            int i = fh.b;
            return (hsVar.getDegradeAbility() == hs.a.FIX || hsVar.getDegradeAbility() == hs.a.SINGLE || conntectionTimeout < i || !z) ? conntectionTimeout : i;
        } catch (Throwable unused) {
            return 5000;
        }
    }
}
