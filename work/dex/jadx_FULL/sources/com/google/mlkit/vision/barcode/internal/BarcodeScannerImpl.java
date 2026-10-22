package com.google.mlkit.vision.barcode.internal;

import android.graphics.Point;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_barcode.h0;
import com.google.android.gms.internal.mlkit_vision_barcode.k0;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuv;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.ZoomSuggestionOptions;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.zj.adlib.am0;
import com.zj.adlib.cnd;
import com.zj.adlib.ebc;
import com.zj.adlib.gnd;
import com.zj.adlib.hq5;
import com.zj.adlib.kd6;
import com.zj.adlib.kmd;
import com.zj.adlib.lsd;
import com.zj.adlib.ooc;
import com.zj.adlib.wsd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BarcodeScannerImpl extends MobileVisionBase<List<Barcode>> implements BarcodeScanner {
    public static final /* synthetic */ int M = 0;
    public static final am0 b = new am0.a().a();
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    @VisibleForTesting
    public final k0 f32482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final am0 f6687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6688a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f6689b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public BarcodeScannerImpl(@NonNull am0 am0Var, @NonNull a aVar, @NonNull Executor executor, @NonNull lsd lsdVar, @NonNull hq5 hq5Var) {
        k0 k0VarD;
        super(aVar, executor);
        ZoomSuggestionOptions zoomSuggestionOptionsB = am0Var.b();
        if (zoomSuggestionOptionsB == null) {
            k0VarD = null;
        } else {
            k0VarD = k0.d(hq5Var.b(), hq5Var.b().getPackageName());
            k0VarD.o(new ooc(zoomSuggestionOptionsB), h0.a());
            if (zoomSuggestionOptionsB.a() >= 1.0f) {
                k0VarD.k(zoomSuggestionOptionsB.a());
            }
            k0VarD.m();
        }
        this.f6687a = am0Var;
        boolean zF = ebc.f();
        this.f6688a = zF;
        cnd cndVar = new cnd();
        cndVar.i(ebc.c(am0Var));
        gnd gndVarJ = cndVar.j();
        kmd kmdVar = new kmd();
        kmdVar.e(zF ? zzpi.TYPE_THICK : zzpi.TYPE_THIN);
        kmdVar.g(gndVarJ);
        lsdVar.d(wsd.f(kmdVar, 1), zzpk.ON_DEVICE_BARCODE_CREATE);
        this.f32482a = k0VarD;
    }

    @Override // com.google.mlkit.vision.barcode.BarcodeScanner
    @NonNull
    public final Task<List<Barcode>> a0(@NonNull MlImage mlImage) {
        return v(super.k(mlImage), mlImage.getWidth(), mlImage.getHeight());
    }

    @Override // com.google.mlkit.vision.common.internal.MobileVisionBase, java.io.Closeable, java.lang.AutoCloseable, com.google.mlkit.vision.barcode.BarcodeScanner
    public final synchronized void close() {
        k0 k0Var = this.f32482a;
        if (k0Var != null) {
            k0Var.n(this.f6689b);
            this.f32482a.j();
        }
        super.close();
    }

    @Override // com.google.android.gms.common.api.OptionalModuleApi
    @NonNull
    public final Feature[] g() {
        return this.f6688a ? kd6.f17642a : new Feature[]{kd6.f42794a};
    }

    public final /* synthetic */ Task r(int i, int i2, List list) throws Exception {
        if (this.f32482a == null) {
            return com.google.android.gms.tasks.a.e(list);
        }
        boolean z = true;
        this.L++;
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Barcode barcode = (Barcode) it.next();
            if (barcode.h() == -1) {
                arrayList2.add(barcode);
            } else {
                arrayList.add(barcode);
            }
        }
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Point[] pointArrD = ((Barcode) arrayList2.get(i3)).d();
                if (pointArrD != null) {
                    k0 k0Var = this.f32482a;
                    int i4 = this.L;
                    int iMin = i;
                    int iMin2 = i2;
                    int iMax = 0;
                    int iMax2 = 0;
                    for (Point point : Arrays.asList(pointArrD)) {
                        iMin = Math.min(iMin, point.x);
                        iMin2 = Math.min(iMin2, point.y);
                        iMax = Math.max(iMax, point.x);
                        iMax2 = Math.max(iMax2, point.y);
                    }
                    float f = i;
                    float f2 = i2;
                    k0Var.i(i4, zzuv.g((iMin + 0.0f) / f, (iMin2 + 0.0f) / f2, (iMax + 0.0f) / f, (iMax2 + 0.0f) / f2, 0.0f));
                }
                i3++;
                z = true;
            }
        } else {
            this.f6689b = true;
        }
        if (z == this.f6687a.d()) {
            arrayList = list;
        }
        return com.google.android.gms.tasks.a.e(arrayList);
    }

    @Override // com.google.mlkit.vision.interfaces.Detector
    public final int t0() {
        return 1;
    }

    public final Task v(@NonNull Task task, final int i, final int i2) {
        return task.w(new SuccessContinuation() { // from class: com.zj.adlib.tkc
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task a(Object obj) {
                return this.f19849a.r(i, i2, (List) obj);
            }
        });
    }

    @Override // com.google.mlkit.vision.barcode.BarcodeScanner
    @NonNull
    public final Task<List<Barcode>> x(@NonNull InputImage inputImage) {
        return v(super.l(inputImage), inputImage.o(), inputImage.k());
    }
}
