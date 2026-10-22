package com.amap.api.col.p0003l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.maps.AMapException;
import com.zj.adlib.a7b;
import com.zj.adlib.i9b;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class w extends hl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w f26061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f1113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z f1114a;

    public static class a extends Handler {
        public /* synthetic */ a(Looper looper, byte b) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        public a() {
        }
    }

    public w(boolean z) {
        if (z) {
            try {
                this.f1114a = z.h(new x.b().c("amap-netmanger-threadpool-%d").g());
            } catch (Throwable th) {
                a7b.m(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f1113a = new a(Looper.getMainLooper(), (byte) 0);
        } else {
            this.f1113a = new a();
        }
    }

    public static synchronized w h(boolean z) {
        try {
            w wVar = f26061a;
            if (wVar == null) {
                f26061a = new w(z);
            } else if (z && wVar.f1114a == null) {
                wVar.f1114a = z.h(new x.b().c("amap-netmanger-threadpool-%d").g());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f26061a;
    }

    public static Map<String, String> i(hs hsVar, hs.b bVar, int i) throws ff {
        try {
            hl.d(hsVar);
            hsVar.setDegradeType(bVar);
            hsVar.setReal_max_timeout(i);
            return new u().i(hsVar);
        } catch (ff e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new ff(AMapException.ERROR_UNKNOWN);
        }
    }

    public static w j() {
        return h(true);
    }

    public static i9b k(hs hsVar, hs.b bVar, int i) throws ff {
        try {
            hl.d(hsVar);
            hsVar.setDegradeType(bVar);
            hsVar.setReal_max_timeout(i);
            return new u().q(hsVar);
        } catch (ff e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new ff(AMapException.ERROR_UNKNOWN);
        }
    }

    public static w l() {
        return h(false);
    }

    @Deprecated
    public static Map<String, String> m(hs hsVar, boolean z) throws ff {
        hl.d(hsVar);
        hsVar.setHttpProtocol(z ? hs.c.HTTPS : hs.c.HTTP);
        Map<String, String> mapI = null;
        long jElapsedRealtime = 0;
        boolean z2 = false;
        if (hl.b(hsVar)) {
            boolean zC = hl.c(hsVar);
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                mapI = i(hsVar, hl.a(hsVar, zC), hl.c(hsVar, zC));
            } catch (ff e) {
                if (!zC) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (mapI != null) {
            return mapI;
        }
        try {
            return i(hsVar, hl.b(hsVar, z2), hl.a(hsVar, jElapsedRealtime));
        } catch (ff e2) {
            throw e2;
        }
    }

    public static i9b n(hs hsVar) throws ff {
        return o(hsVar, hsVar.isHttps());
    }

    @Deprecated
    public static i9b o(hs hsVar, boolean z) throws ff {
        byte[] bArr;
        hl.d(hsVar);
        hsVar.setHttpProtocol(z ? hs.c.HTTPS : hs.c.HTTP);
        i9b i9bVarK = null;
        long jElapsedRealtime = 0;
        boolean z2 = false;
        if (hl.b(hsVar)) {
            boolean zC = hl.c(hsVar);
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                i9bVarK = k(hsVar, hl.a(hsVar, zC), hl.c(hsVar, zC));
            } catch (ff e) {
                if ((e.f() == 21 && hsVar.getDegradeAbility() == hs.a.INTERRUPT_IO) || !zC) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (i9bVarK != null && (bArr = i9bVarK.f17171a) != null && bArr.length > 0) {
            return i9bVarK;
        }
        try {
            return k(hsVar, hl.b(hsVar, z2), hl.a(hsVar, jElapsedRealtime));
        } catch (ff e2) {
            throw e2;
        }
    }
}
