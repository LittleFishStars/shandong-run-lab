package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzaj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzal;
import com.google.android.gms.internal.mlkit_vision_barcode.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.zj.adlib.am0;
import com.zj.adlib.ebc;
import com.zj.adlib.eq1;
import com.zj.adlib.ijd;
import com.zj.adlib.kd6;
import com.zj.adlib.lsd;
import com.zj.adlib.w64;
import com.zj.adlib.yw6;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class c implements zzl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f32485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzah f6701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public zzaj f6702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lsd f6703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6704a;

    public c(Context context, am0 am0Var, lsd lsdVar) {
        zzah zzahVar = new zzah();
        this.f6701a = zzahVar;
        this.f32485a = context;
        zzahVar.zza = am0Var.a();
        this.f6703a = lsdVar;
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzl
    @WorkerThread
    public final List a(InputImage inputImage) throws MlKitException {
        zzu[] zzuVarArrZzf;
        if (this.f6702a == null) {
            r();
        }
        zzaj zzajVar = this.f6702a;
        if (zzajVar == null) {
            throw new MlKitException("Error initializing the legacy barcode scanner.", 14);
        }
        zzaj zzajVar2 = (zzaj) yw6.l(zzajVar);
        zzan zzanVar = new zzan(inputImage.o(), inputImage.k(), 0, 0L, eq1.c(inputImage.n()));
        try {
            int iJ = inputImage.j();
            if (iJ == -1) {
                zzuVarArrZzf = zzajVar2.zzf(ObjectWrapper.wrap(inputImage.g()), zzanVar);
            } else if (iJ == 17) {
                zzuVarArrZzf = zzajVar2.zze(ObjectWrapper.wrap(inputImage.h()), zzanVar);
            } else if (iJ == 35) {
                Image.Plane[] planeArr = (Image.Plane[]) yw6.l(inputImage.m());
                zzanVar.zza = planeArr[0].getRowStride();
                zzuVarArrZzf = zzajVar2.zze(ObjectWrapper.wrap(planeArr[0].getBuffer()), zzanVar);
            } else {
                if (iJ != 842094169) {
                    throw new MlKitException("Unsupported image format: " + inputImage.j(), 3);
                }
                zzuVarArrZzf = zzajVar2.zze(ObjectWrapper.wrap(w64.g().e(inputImage, false)), zzanVar);
            }
            ArrayList arrayList = new ArrayList();
            for (zzu zzuVar : zzuVarArrZzf) {
                arrayList.add(new Barcode(new ijd(zzuVar), inputImage.i()));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to detect with legacy barcode detector", 13, e);
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzl
    @WorkerThread
    public final void p() {
        zzaj zzajVar = this.f6702a;
        if (zzajVar != null) {
            try {
                zzajVar.zzd();
            } catch (RemoteException e) {
                Log.e("LegacyBarcodeScanner", "Failed to release legacy barcode detector.", e);
            }
            this.f6702a = null;
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzl
    @WorkerThread
    public final boolean r() throws MlKitException {
        if (this.f6702a != null) {
            return false;
        }
        try {
            zzaj zzajVarZzd = zzal.zza(DynamiteModule.e(this.f32485a, DynamiteModule.f5722a, kd6.f17641a).d("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator")).zzd(ObjectWrapper.wrap(this.f32485a), this.f6701a);
            this.f6702a = zzajVarZzd;
            if (zzajVarZzd == null && !this.f6704a) {
                Log.d("LegacyBarcodeScanner", "Request optional module download.");
                kd6.c(this.f32485a, kd6.v);
                this.f6704a = true;
                ebc.e(this.f6703a, zzpj.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            ebc.e(this.f6703a, zzpj.NO_ERROR);
            return false;
        } catch (RemoteException e) {
            throw new MlKitException("Failed to create legacy barcode detector.", 13, e);
        } catch (DynamiteModule.LoadingException e2) {
            throw new MlKitException("Failed to load deprecated vision dynamite module.", 13, e2);
        }
    }
}
