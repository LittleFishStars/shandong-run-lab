package cj.mobile.wm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u3 implements r3 {
    public static final Bitmap.Config dexk = Bitmap.Config.ARGB_8888;
    public final v3 dexa;
    public final Set<Bitmap.Config> dexb;
    public final int dexc;
    public final dexb dexd;
    public int dexe;
    public int dexf;
    public int dexg;
    public int dexh;
    public int dexi;
    public int dexj;

    public interface dexb {
        void a(Bitmap bitmap);

        void dexa(Bitmap bitmap);
    }

    public static class dexc implements dexb {
        public dexc() {
        }

        @Override // cj.mobile.wm.u3.dexb
        public void a(Bitmap bitmap) {
        }

        @Override // cj.mobile.wm.u3.dexb
        public void dexa(Bitmap bitmap) {
        }
    }

    public u3(int i) {
        this(i, dexe(), dexd());
    }

    public u3(int i, v3 v3Var, Set<Bitmap.Config> set) {
        this.dexc = i;
        this.dexe = i;
        this.dexa = v3Var;
        this.dexb = set;
        this.dexd = new dexc();
    }

    private void dexa() {
        if (Log.isLoggable(com.ipd.dsp.internal.j.k.k, 2)) {
            dexb();
        }
    }

    private synchronized void dexa(int i) {
        while (this.dexf > i) {
            Bitmap bitmapA = this.dexa.a();
            if (bitmapA == null) {
                if (Log.isLoggable(com.ipd.dsp.internal.j.k.k, 5)) {
                    Log.w(com.ipd.dsp.internal.j.k.k, "Size mismatch, resetting");
                    dexb();
                }
                this.dexf = 0;
                return;
            }
            this.dexd.dexa(bitmapA);
            this.dexf -= this.dexa.dexb(bitmapA);
            bitmapA.recycle();
            this.dexj++;
            if (Log.isLoggable(com.ipd.dsp.internal.j.k.k, 3)) {
                f1.dexa(com.ipd.dsp.internal.j.k.k, "Evicting bitmap=" + this.dexa.dexa(bitmapA));
            }
            dexa();
        }
    }

    private void dexb() {
        Log.v(com.ipd.dsp.internal.j.k.k, "Hits=" + this.dexg + ", misses=" + this.dexh + ", puts=" + this.dexi + ", evictions=" + this.dexj + ", currentSize=" + this.dexf + ", maxSize=" + this.dexe + "\nStrategy=" + this.dexa);
    }

    private void dexc() {
        dexa(this.dexe);
    }

    public static Set<Bitmap.Config> dexd() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        return Collections.unmodifiableSet(hashSet);
    }

    public static v3 dexe() {
        return new x3();
    }

    @Override // cj.mobile.wm.r3
    public void a() {
        if (Log.isLoggable(com.ipd.dsp.internal.j.k.k, 3)) {
            f1.dexa(com.ipd.dsp.internal.j.k.k, "clearMemory");
        }
        dexa(0);
    }

    @Override // cj.mobile.wm.r3
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable(com.ipd.dsp.internal.j.k.k, 3)) {
            f1.dexa(com.ipd.dsp.internal.j.k.k, "trimMemory, level=" + i);
        }
        if (i >= 60) {
            a();
        } else if (i >= 40) {
            dexa(this.dexe / 2);
        }
    }

    @Override // cj.mobile.wm.r3
    public synchronized boolean a(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isMutable() && this.dexa.dexb(bitmap) <= this.dexe && this.dexb.contains(bitmap.getConfig())) {
                int iDexb = this.dexa.dexb(bitmap);
                this.dexa.a(bitmap);
                this.dexd.a(bitmap);
                this.dexi++;
                this.dexf += iDexb;
                if (Log.isLoggable(com.ipd.dsp.internal.j.k.k, 2)) {
                    Log.v(com.ipd.dsp.internal.j.k.k, "Put bitmap in pool=" + this.dexa.dexa(bitmap));
                }
                dexa();
                dexc();
                return true;
            }
            if (Log.isLoggable(com.ipd.dsp.internal.j.k.k, 2)) {
                Log.v(com.ipd.dsp.internal.j.k.k, "Reject bitmap from pool, bitmap: " + this.dexa.dexa(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.dexb.contains(bitmap.getConfig()));
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // cj.mobile.wm.r3
    public synchronized Bitmap dexa(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapDexb;
        bitmapDexb = dexb(i, i2, config);
        if (bitmapDexb != null) {
            bitmapDexb.eraseColor(0);
        }
        return bitmapDexb;
    }

    @Override // cj.mobile.wm.r3
    @TargetApi(12)
    public synchronized Bitmap dexb(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapDexa;
        bitmapDexa = this.dexa.dexa(i, i2, config != null ? config : dexk);
        if (bitmapDexa == null) {
            if (Log.isLoggable(com.ipd.dsp.internal.j.k.k, 3)) {
                f1.dexa(com.ipd.dsp.internal.j.k.k, "Missing bitmap=" + this.dexa.dexb(i, i2, config));
            }
            this.dexh++;
        } else {
            this.dexg++;
            this.dexf -= this.dexa.dexb(bitmapDexa);
            this.dexd.dexa(bitmapDexa);
            bitmapDexa.setHasAlpha(true);
        }
        if (Log.isLoggable(com.ipd.dsp.internal.j.k.k, 2)) {
            Log.v(com.ipd.dsp.internal.j.k.k, "Get bitmap=" + this.dexa.dexb(i, i2, config));
        }
        dexa();
        return bitmapDexa;
    }
}
