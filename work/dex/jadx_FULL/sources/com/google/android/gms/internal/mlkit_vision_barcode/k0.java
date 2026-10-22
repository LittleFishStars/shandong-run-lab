package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_vision_barcode.k0;
import com.google.mlkit.vision.barcode.ZoomSuggestionOptions;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerImpl;
import com.zj.adlib.e98;
import com.zj.adlib.fsd;
import com.zj.adlib.gac;
import com.zj.adlib.kmd;
import com.zj.adlib.ktd;
import com.zj.adlib.lsd;
import com.zj.adlib.mtd;
import com.zj.adlib.nqd;
import com.zj.adlib.ooc;
import com.zj.adlib.oqd;
import com.zj.adlib.qmc;
import com.zj.adlib.su3;
import com.zj.adlib.wrc;
import com.zj.adlib.wsd;
import com.zj.adlib.ybc;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final su3 f31353a = new su3("AutoZoom");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f5757a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public int f5758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzbf f5760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final zzbz f5761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public final zzuu f5762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lsd f5763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ooc f5764a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Executor f5767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ScheduledExecutorService f5768a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    @VisibleForTesting
    public ScheduledFuture f5769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicBoolean f5770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5771a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5772b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    @VisibleForTesting
    public String f5773b;

    public k0(Context context, zzuu zzuuVar, String str) {
        wrc.a();
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(2));
        zzbf zzbfVarA = gac.a();
        lsd lsdVar = new lsd(context, new e98(context), new fsd(context, zztp.d("scanner-auto-zoom").c()), "scanner-auto-zoom");
        this.f5765a = new Object();
        this.f5762a = zzuuVar;
        this.f5770a = new AtomicBoolean(false);
        this.f5761a = zzbz.zzz();
        this.f5768a = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
        this.f5760a = zzbfVarA;
        this.f5763a = lsdVar;
        this.f5766a = str;
        this.f5758a = 1;
        this.f5757a = 1.0f;
        this.b = -1.0f;
        this.f5759a = zzbfVarA.a();
    }

    public static k0 d(Context context, String str) {
        return new k0(context, zzuu.b, str);
    }

    public static /* synthetic */ void f(k0 k0Var) {
        ScheduledFuture scheduledFuture;
        synchronized (k0Var.f5765a) {
            if (k0Var.f5758a == 2 && !k0Var.f5770a.get() && (scheduledFuture = k0Var.f5769a) != null && !scheduledFuture.isCancelled()) {
                if (k0Var.f5757a > 1.0f && k0Var.a() >= k0Var.f5762a.i()) {
                    f31353a.h("AutoZoom", "Reset zoom = 1");
                    k0Var.l(1.0f, zzpk.SCANNER_AUTO_ZOOM_AUTO_RESET, null);
                }
            }
        }
    }

    public static /* bridge */ /* synthetic */ void g(k0 k0Var, float f) {
        synchronized (k0Var.f5765a) {
            k0Var.f5757a = f;
            k0Var.r(false);
        }
    }

    @VisibleForTesting
    public final long a() {
        long jConvert;
        synchronized (this.f5765a) {
            jConvert = TimeUnit.MILLISECONDS.convert(this.f5760a.a() - this.f5759a, TimeUnit.NANOSECONDS);
        }
        return jConvert;
    }

    public final /* synthetic */ zzev c(float f) throws Exception {
        ooc oocVar = this.f5764a;
        float fP = p(f);
        ZoomSuggestionOptions zoomSuggestionOptions = oocVar.f43796a;
        int i = BarcodeScannerImpl.M;
        if (true != zoomSuggestionOptions.b().a(fP)) {
            fP = 0.0f;
        }
        return qmc.a(Float.valueOf(fP));
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0244 A[Catch: all -> 0x0264, TryCatch #0 {, blocks: (B:49:0x0189, B:51:0x0197, B:53:0x019a, B:54:0x01c5, B:56:0x01cb, B:59:0x01f4, B:61:0x0203, B:63:0x0212, B:65:0x021d, B:66:0x0242, B:68:0x0244, B:69:0x0261), top: B:80:0x0189, outer: #1 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x0244, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final void i(int i, zzuv zzuvVar) {
        float f;
        synchronized (this.f5765a) {
            if (this.f5758a != 2) {
                return;
            }
            if (!zzuvVar.h() || (this.f5762a.l() && this.f5762a.b() > 0.0f)) {
                return;
            }
            if (!this.f5771a) {
                zzpk zzpkVar = zzpk.SCANNER_AUTO_ZOOM_FIRST_ATTEMPT;
                float f2 = this.f5757a;
                q(zzpkVar, f2, f2, zzuvVar);
                this.f5771a = true;
            }
            su3 su3Var = f31353a;
            Locale locale = Locale.getDefault();
            Integer numValueOf = Integer.valueOf(i);
            su3Var.h("AutoZoom", String.format(locale, "Process PredictedArea: [%.2f, %.2f, %.2f, %.2f, %.2f], frameIndex = %d", Float.valueOf(zzuvVar.c()), Float.valueOf(zzuvVar.e()), Float.valueOf(zzuvVar.b()), Float.valueOf(zzuvVar.d()), Float.valueOf(0.0f), numValueOf));
            this.f5761a.zzt(numValueOf, zzuvVar);
            Set setZzw = this.f5761a.zzw();
            if (setZzw.size() - 1 > this.f5762a.h()) {
                Iterator it = setZzw.iterator();
                int i2 = i;
                while (it.hasNext()) {
                    int iIntValue = ((Integer) it.next()).intValue();
                    if (i2 > iIntValue) {
                        i2 = iIntValue;
                    }
                }
                f31353a.h("AutoZoom", "Removing recent frameIndex = " + i2);
                this.f5761a.zzf(Integer.valueOf(i2));
            }
            HashSet hashSet = new HashSet();
            for (Map.Entry entry : this.f5761a.zzu()) {
                if (((Integer) entry.getKey()).intValue() != i) {
                    zzuv zzuvVar2 = (zzuv) entry.getValue();
                    if (zzuvVar2.h() && zzuvVar.h()) {
                        zzuv zzuvVarG = zzuv.g(Math.max(zzuvVar2.c(), zzuvVar.c()), Math.max(zzuvVar2.e(), zzuvVar.e()), Math.min(zzuvVar2.b(), zzuvVar.b()), Math.min(zzuvVar2.d(), zzuvVar.d()), 0.0f);
                        f = zzuvVarG.f() / ((zzuvVar2.f() + zzuvVar.f()) - zzuvVarG.f());
                    } else {
                        f = 0.0f;
                    }
                    if (f >= this.f5762a.d()) {
                        hashSet.add((Integer) entry.getKey());
                    }
                }
            }
            if (hashSet.size() >= this.f5762a.g() || (this.f5762a.l() && this.f5762a.a() <= 0.0f)) {
                synchronized (this.f5765a) {
                    if (a() >= this.f5762a.j()) {
                        zzdy zzdyVarListIterator = zzcv.zzi(Float.valueOf(zzuvVar.c()), Float.valueOf(zzuvVar.e()), Float.valueOf(zzuvVar.b()), Float.valueOf(zzuvVar.d())).listIterator(0);
                        float f3 = 1.0E9f;
                        while (zzdyVarListIterator.hasNext()) {
                            float fC = (this.f5762a.c() / 2.0f) / Math.max(Math.abs(((Float) zzdyVarListIterator.next()).floatValue() - 0.5f), 0.001f);
                            if (f3 > fC) {
                                f3 = fC;
                            }
                        }
                        float fP = p(this.f5757a * f3);
                        if (this.f5762a.k()) {
                            float f4 = this.f5757a;
                            float f5 = (fP - f4) / f4;
                            if (f5 > this.f5762a.e() || f5 < (-this.f5762a.f())) {
                                f31353a.h("AutoZoom", "Going to set zoom = " + fP);
                                l(fP, zzpk.SCANNER_AUTO_ZOOM_AUTO_ZOOM, zzuvVar);
                            } else {
                                f31353a.h("AutoZoom", "Auto zoom to " + fP + " is filtered by threshold");
                                this.f5759a = this.f5760a.a();
                            }
                        } else {
                            f31353a.h("AutoZoom", "Going to set zoom = " + fP);
                            l(fP, zzpk.SCANNER_AUTO_ZOOM_AUTO_ZOOM, zzuvVar);
                        }
                    }
                }
            }
        }
    }

    public final void j() {
        synchronized (this.f5765a) {
            if (this.f5758a == 4) {
                return;
            }
            n(false);
            this.f5768a.shutdown();
            this.f5758a = 4;
        }
    }

    public final void k(float f) {
        synchronized (this.f5765a) {
            ybc.c(f >= 1.0f);
            this.b = f;
        }
    }

    @VisibleForTesting
    public final void l(float f, zzpk zzpkVar, @Nullable zzuv zzuvVar) {
        synchronized (this.f5765a) {
            if (this.f5767a != null && this.f5764a != null && this.f5758a == 2) {
                if (this.f5770a.compareAndSet(false, true)) {
                    qmc.b(qmc.c(new ktd(this, f), this.f5767a), new mtd(this, zzpkVar, this.f5757a, zzuvVar, f), h0.a());
                }
            }
        }
    }

    public final void m() {
        synchronized (this.f5765a) {
            int i = this.f5758a;
            if (i != 2 && i != 4) {
                r(true);
                this.f5769a = this.f5768a.scheduleWithFixedDelay(new Runnable() { // from class: com.zj.adlib.ltd
                    @Override // java.lang.Runnable
                    public final void run() {
                        k0.f(this.f43148a);
                    }
                }, 500L, 500L, TimeUnit.MILLISECONDS);
                if (this.f5758a == 1) {
                    this.f5773b = UUID.randomUUID().toString();
                    this.f5772b = this.f5760a.a();
                    this.f5771a = false;
                    zzpk zzpkVar = zzpk.SCANNER_AUTO_ZOOM_START;
                    float f = this.f5757a;
                    q(zzpkVar, f, f, null);
                } else {
                    zzpk zzpkVar2 = zzpk.SCANNER_AUTO_ZOOM_RESUME;
                    float f2 = this.f5757a;
                    q(zzpkVar2, f2, f2, null);
                }
                this.f5758a = 2;
            }
        }
    }

    public final void n(boolean z) {
        synchronized (this.f5765a) {
            int i = this.f5758a;
            if (i != 1 && i != 4) {
                r(true);
                if (z) {
                    if (!this.f5771a) {
                        zzpk zzpkVar = zzpk.SCANNER_AUTO_ZOOM_FIRST_ATTEMPT;
                        float f = this.f5757a;
                        q(zzpkVar, f, f, null);
                    }
                    zzpk zzpkVar2 = zzpk.SCANNER_AUTO_ZOOM_SCAN_SUCCESS;
                    float f2 = this.f5757a;
                    q(zzpkVar2, f2, f2, null);
                } else {
                    zzpk zzpkVar3 = zzpk.SCANNER_AUTO_ZOOM_SCAN_FAILED;
                    float f3 = this.f5757a;
                    q(zzpkVar3, f3, f3, null);
                }
                this.f5771a = false;
                this.f5758a = 1;
                this.f5773b = null;
            }
        }
    }

    public final void o(ooc oocVar, Executor executor) {
        this.f5764a = oocVar;
        this.f5767a = executor;
    }

    public final float p(float f) {
        float f2 = this.b;
        if (f < 1.0f) {
            f = 1.0f;
        }
        return (f2 <= 0.0f || f <= f2) ? f : f2;
    }

    public final void q(zzpk zzpkVar, float f, float f2, @Nullable zzuv zzuvVar) {
        long jConvert;
        if (this.f5773b != null) {
            nqd nqdVar = new nqd();
            nqdVar.a(this.f5766a);
            String str = this.f5773b;
            str.getClass();
            nqdVar.e(str);
            nqdVar.f(Float.valueOf(f));
            nqdVar.c(Float.valueOf(f2));
            synchronized (this.f5765a) {
                jConvert = TimeUnit.MILLISECONDS.convert(this.f5760a.a() - this.f5772b, TimeUnit.NANOSECONDS);
            }
            nqdVar.b(Long.valueOf(jConvert));
            if (zzuvVar != null) {
                oqd oqdVar = new oqd();
                oqdVar.c(Float.valueOf(zzuvVar.c()));
                oqdVar.e(Float.valueOf(zzuvVar.e()));
                oqdVar.b(Float.valueOf(zzuvVar.b()));
                oqdVar.d(Float.valueOf(zzuvVar.d()));
                oqdVar.a(Float.valueOf(0.0f));
                nqdVar.d(oqdVar.f());
            }
            lsd lsdVar = this.f5763a;
            kmd kmdVar = new kmd();
            kmdVar.i(nqdVar.h());
            lsdVar.d(wsd.e(kmdVar), zzpkVar);
        }
    }

    public final void r(boolean z) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f5765a) {
            this.f5761a.zzs();
            this.f5759a = this.f5760a.a();
            if (z && (scheduledFuture = this.f5769a) != null) {
                scheduledFuture.cancel(false);
                this.f5769a = null;
            }
        }
    }
}
