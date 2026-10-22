package cj.mobile.wm;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.security.MessageDigest;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t6 {
    public final dexc dexa;
    public final j2 dexb;
    public final Handler dexc;
    public boolean dexd;
    public boolean dexe;
    public b2<j2, j2, Bitmap, Bitmap> dexf;
    public dexb dexg;
    public boolean dexh;

    public static class dexb extends t8<Bitmap> {
        public final Handler dexd;
        public final int dexe;
        public final long dexf;
        public Bitmap dexg;

        public dexb(Handler handler, int i, long j) {
            this.dexd = handler;
            this.dexe = i;
            this.dexf = j;
        }

        public Bitmap dexa() {
            return this.dexg;
        }

        public void dexa(Bitmap bitmap, m8<? super Bitmap> m8Var) {
            this.dexg = bitmap;
            this.dexd.sendMessageAtTime(this.dexd.obtainMessage(1, this), this.dexf);
        }

        @Override // cj.mobile.wm.v8
        public /* bridge */ /* synthetic */ void dexa(Object obj, m8 m8Var) {
            dexa((Bitmap) obj, (m8<? super Bitmap>) m8Var);
        }
    }

    public interface dexc {
        void a(int i);
    }

    public class dexd implements Handler.Callback {
        public dexd() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                t6.this.dexa((dexb) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            d2.dexa((dexb) message.obj);
            return false;
        }
    }

    public static class dexe implements r2 {
        public final UUID dexa;

        public dexe() {
            this(UUID.randomUUID());
        }

        public dexe(UUID uuid) {
            this.dexa = uuid;
        }

        @Override // cj.mobile.wm.r2
        public void dexa(MessageDigest messageDigest) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // cj.mobile.wm.r2
        public boolean equals(Object obj) {
            if (obj instanceof dexe) {
                return ((dexe) obj).dexa.equals(this.dexa);
            }
            return false;
        }

        @Override // cj.mobile.wm.r2
        public int hashCode() {
            return this.dexa.hashCode();
        }
    }

    public t6(Context context, dexc dexcVar, j2 j2Var, int i, int i2) {
        this(dexcVar, j2Var, null, dexa(context, j2Var, i, i2, d2.dexa(context).dexb()));
    }

    public t6(dexc dexcVar, j2 j2Var, Handler handler, b2<j2, j2, Bitmap, Bitmap> b2Var) {
        this.dexd = false;
        this.dexe = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new dexd()) : handler;
        this.dexa = dexcVar;
        this.dexb = j2Var;
        this.dexc = handler;
        this.dexf = b2Var;
    }

    public static b2<j2, j2, Bitmap, Bitmap> dexa(Context context, j2 j2Var, int i, int i2, r3 r3Var) {
        v6 v6Var = new v6(r3Var);
        u6 u6Var = new u6();
        return d2.dexc(context).dexa(u6Var, j2.class).dexa(j2Var).dexa(Bitmap.class).dexa(n5.dexa()).dexa((t2) v6Var).dexa(true).dexa(com.wangmai.insightvision.openadsdk.image.b.n.i.b.b).dexa(i, i2);
    }

    private void dexe() {
        if (!this.dexd || this.dexe) {
            return;
        }
        this.dexe = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.dexb.dexe());
        this.dexb.dexa();
        this.dexf.dexa(new dexe()).dexa(new dexb(this.dexc, this.dexb.dexc(), jUptimeMillis));
    }

    public void dexa() {
        dexd();
        dexb dexbVar = this.dexg;
        if (dexbVar != null) {
            d2.dexa(dexbVar);
            this.dexg = null;
        }
        this.dexh = true;
    }

    public void dexa(dexb dexbVar) {
        if (this.dexh) {
            this.dexc.obtainMessage(2, dexbVar).sendToTarget();
            return;
        }
        dexb dexbVar2 = this.dexg;
        this.dexg = dexbVar;
        this.dexa.a(dexbVar.dexe);
        if (dexbVar2 != null) {
            this.dexc.obtainMessage(2, dexbVar2).sendToTarget();
        }
        this.dexe = false;
        dexe();
    }

    public void dexa(v2<Bitmap> v2Var) {
        if (v2Var == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.dexf = this.dexf.dexa(v2Var);
    }

    public Bitmap dexb() {
        dexb dexbVar = this.dexg;
        if (dexbVar != null) {
            return dexbVar.dexa();
        }
        return null;
    }

    public void dexc() {
        if (this.dexd) {
            return;
        }
        this.dexd = true;
        this.dexh = false;
        dexe();
    }

    public void dexd() {
        this.dexd = false;
    }
}
