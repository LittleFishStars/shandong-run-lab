package com.google.mlkit.vision.barcode.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.mlkit_vision_barcode.zzoq;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpk;
import com.google.android.gms.internal.mlkit_vision_barcode.zztm;
import com.google.android.gms.internal.mlkit_vision_barcode.zztw;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.zj.adlib.am0;
import com.zj.adlib.cld;
import com.zj.adlib.cnd;
import com.zj.adlib.crc;
import com.zj.adlib.ebc;
import com.zj.adlib.ew0;
import com.zj.adlib.g84;
import com.zj.adlib.hkd;
import com.zj.adlib.hq5;
import com.zj.adlib.kmd;
import com.zj.adlib.lsd;
import com.zj.adlib.nsd;
import com.zj.adlib.pkd;
import com.zj.adlib.s3d;
import com.zj.adlib.sqc;
import com.zj.adlib.ugc;
import com.zj.adlib.vqc;
import com.zj.adlib.wsd;
import com.zj.adlib.yw6;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class a extends MLTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g84 f32483a = g84.b();

    @VisibleForTesting
    public static boolean b = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzl f6690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final am0 f6691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ew0 f6692a = new ew0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lsd f6693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nsd f6694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6695a;

    public a(hq5 hq5Var, am0 am0Var, zzl zzlVar, lsd lsdVar) {
        yw6.m(hq5Var, "MlKitContext can not be null");
        yw6.m(am0Var, "BarcodeScannerOptions can not be null");
        this.f6691a = am0Var;
        this.f6690a = zzlVar;
        this.f6693a = lsdVar;
        this.f6694a = nsd.a(hq5Var.b());
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    @WorkerThread
    public final synchronized void c() throws MlKitException {
        this.f6695a = this.f6690a.r();
    }

    public final /* synthetic */ zztm j(long j, zzpj zzpjVar, ugc ugcVar, ugc ugcVar2, InputImage inputImage) {
        zzoq zzoqVar;
        cnd cndVar = new cnd();
        cld cldVar = new cld();
        cldVar.c(Long.valueOf(j));
        cldVar.d(zzpjVar);
        cldVar.e(Boolean.valueOf(b));
        Boolean bool = Boolean.TRUE;
        cldVar.a(bool);
        cldVar.b(bool);
        cndVar.h(cldVar.f());
        cndVar.i(ebc.c(this.f6691a));
        cndVar.e(ugcVar.g());
        cndVar.f(ugcVar2.g());
        int iJ = inputImage.j();
        int iD = f32483a.d(inputImage);
        pkd pkdVar = new pkd();
        if (iJ == -1) {
            zzoqVar = zzoq.BITMAP;
        } else if (iJ == 35) {
            zzoqVar = zzoq.YUV_420_888;
        } else if (iJ == 842094169) {
            zzoqVar = zzoq.YV12;
        } else if (iJ != 16) {
            zzoqVar = iJ != 17 ? zzoq.UNKNOWN_FORMAT : zzoq.NV21;
        } else {
            zzoqVar = zzoq.NV16;
        }
        pkdVar.a(zzoqVar);
        pkdVar.b(Integer.valueOf(iD));
        cndVar.g(pkdVar.d());
        kmd kmdVar = new kmd();
        kmdVar.e(this.f6695a ? zzpi.TYPE_THICK : zzpi.TYPE_THIN);
        kmdVar.g(cndVar.j());
        return wsd.e(kmdVar);
    }

    public final /* synthetic */ zztm k(crc crcVar, int i, hkd hkdVar) {
        kmd kmdVar = new kmd();
        kmdVar.e(this.f6695a ? zzpi.TYPE_THICK : zzpi.TYPE_THIN);
        sqc sqcVar = new sqc();
        sqcVar.a(Integer.valueOf(i));
        sqcVar.c(crcVar);
        sqcVar.b(hkdVar);
        kmdVar.d(sqcVar.e());
        return wsd.e(kmdVar);
    }

    @Override // com.google.mlkit.common.sdkinternal.MLTask
    @WorkerThread
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final synchronized List i(@NonNull InputImage inputImage) throws MlKitException {
        List listA;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f6692a.a(inputImage);
        try {
            listA = this.f6690a.a(inputImage);
            m(zzpj.NO_ERROR, jElapsedRealtime, inputImage, listA);
            b = false;
        } catch (MlKitException e) {
            m(e.getErrorCode() == 14 ? zzpj.MODEL_NOT_DOWNLOADED : zzpj.UNKNOWN_ERROR, jElapsedRealtime, inputImage, null);
            throw e;
        }
        return listA;
    }

    @WorkerThread
    public final void m(final zzpj zzpjVar, long j, @NonNull final InputImage inputImage, @Nullable List list) {
        final ugc ugcVar = new ugc();
        final ugc ugcVar2 = new ugc();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Barcode barcode = (Barcode) it.next();
                ugcVar.e(ebc.a(barcode.h()));
                ugcVar2.e(ebc.b(barcode.o()));
            }
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.f6693a.f(new zztw() { // from class: com.zj.adlib.vzc
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztw
            public final zztm a() {
                return this.f20351a.j(jElapsedRealtime, zzpjVar, ugcVar, ugcVar2, inputImage);
            }
        }, zzpk.ON_DEVICE_BARCODE_DETECT);
        vqc vqcVar = new vqc();
        vqcVar.e(zzpjVar);
        vqcVar.f(Boolean.valueOf(b));
        vqcVar.g(ebc.c(this.f6691a));
        vqcVar.c(ugcVar.g());
        vqcVar.d(ugcVar2.g());
        final crc crcVarH = vqcVar.h();
        final s3d s3dVar = new s3d(this);
        final lsd lsdVar = this.f6693a;
        final zzpk zzpkVar = zzpk.AGGREGATED_ON_DEVICE_BARCODE_DETECTION;
        com.google.mlkit.common.sdkinternal.b.g().execute(new Runnable() { // from class: com.zj.adlib.jsd
            @Override // java.lang.Runnable
            public final void run() {
                lsdVar.h(zzpkVar, crcVarH, jElapsedRealtime, s3dVar);
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f6694a.c(true != this.f6695a ? 24301 : 24302, zzpjVar.zza(), jCurrentTimeMillis - jElapsedRealtime, jCurrentTimeMillis);
    }

    @Override // com.google.mlkit.common.sdkinternal.ModelResource
    @WorkerThread
    public final synchronized void release() {
        this.f6690a.p();
        b = true;
        lsd lsdVar = this.f6693a;
        kmd kmdVar = new kmd();
        kmdVar.e(this.f6695a ? zzpi.TYPE_THICK : zzpi.TYPE_THIN);
        cnd cndVar = new cnd();
        cndVar.i(ebc.c(this.f6691a));
        kmdVar.g(cndVar.j());
        lsdVar.d(wsd.e(kmdVar), zzpk.ON_DEVICE_BARCODE_CLOSE);
    }
}
