package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.media.Image;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.zzcv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwc;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import com.zj.adlib.aed;
import com.zj.adlib.am0;
import com.zj.adlib.ebc;
import com.zj.adlib.eq1;
import com.zj.adlib.g84;
import com.zj.adlib.kd6;
import com.zj.adlib.lsd;
import com.zj.adlib.yw6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class b implements zzl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzcv f32484a = zzcv.zzh(kd6.f17644b, kd6.f17656n);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f6696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public zzvt f6697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final am0 f6698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lsd f6699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f6700a;
    public boolean b;
    public boolean c;

    public b(Context context, am0 am0Var, lsd lsdVar) {
        this.f6696a = context;
        this.f6698a = am0Var;
        this.f6699a = lsdVar;
    }

    public static boolean b(Context context) {
        return DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) > 0;
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzl
    @WorkerThread
    public final List a(InputImage inputImage) throws MlKitException {
        if (this.f6697a == null) {
            r();
        }
        zzvt zzvtVar = (zzvt) yw6.l(this.f6697a);
        if (!this.f6700a) {
            try {
                zzvtVar.zze();
                this.f6700a = true;
            } catch (RemoteException e) {
                throw new MlKitException("Failed to init barcode scanner.", 13, e);
            }
        }
        int iO = inputImage.o();
        if (inputImage.j() == 35) {
            iO = ((Image.Plane[]) yw6.l(inputImage.m()))[0].getRowStride();
        }
        try {
            List listZzd = zzvtVar.zzd(g84.b().a(inputImage), new zzwc(inputImage.j(), iO, inputImage.k(), eq1.c(inputImage.n()), SystemClock.elapsedRealtime()));
            ArrayList arrayList = new ArrayList();
            Iterator it = listZzd.iterator();
            while (it.hasNext()) {
                arrayList.add(new Barcode(new aed((zzvj) it.next()), inputImage.i()));
            }
            return arrayList;
        } catch (RemoteException e2) {
            throw new MlKitException("Failed to run barcode scanner.", 13, e2);
        }
    }

    @VisibleForTesting
    public final zzvt c(DynamiteModule.VersionPolicy versionPolicy, String str, String str2) throws RemoteException, DynamiteModule.LoadingException {
        zzvw zzvwVarZza = zzvv.zza(DynamiteModule.e(this.f6696a, versionPolicy, str).d(str2));
        IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(this.f6696a);
        int iA = this.f6698a.a();
        boolean z = true;
        if (!this.f6698a.d() && this.f6698a.b() == null) {
            z = false;
        }
        return zzvwVarZza.zzd(iObjectWrapperWrap, new zzvl(iA, z));
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzl
    @WorkerThread
    public final void p() {
        zzvt zzvtVar = this.f6697a;
        if (zzvtVar != null) {
            try {
                zzvtVar.zzf();
            } catch (RemoteException e) {
                Log.e("DecoupledBarcodeScanner", "Failed to release barcode scanner.", e);
            }
            this.f6697a = null;
            this.f6700a = false;
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.zzl
    @WorkerThread
    public final boolean r() throws MlKitException {
        if (this.f6697a != null) {
            return this.b;
        }
        if (b(this.f6696a)) {
            this.b = true;
            try {
                this.f6697a = c(DynamiteModule.f5729b, ModuleDescriptor.MODULE_ID, "com.google.mlkit.vision.barcode.bundled.internal.ThickBarcodeScannerCreator");
            } catch (RemoteException e) {
                throw new MlKitException("Failed to create thick barcode scanner.", 13, e);
            } catch (DynamiteModule.LoadingException e2) {
                throw new MlKitException("Failed to load the bundled barcode module.", 13, e2);
            }
        } else {
            this.b = false;
            if (!kd6.a(this.f6696a, f32484a)) {
                if (!this.c) {
                    kd6.d(this.f6696a, zzcv.zzh(kd6.v, kd6.C));
                    this.c = true;
                }
                ebc.e(this.f6699a, zzpj.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new MlKitException("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            try {
                this.f6697a = c(DynamiteModule.f5722a, kd6.f17644b, "com.google.android.gms.vision.barcode.mlkit.BarcodeScannerCreator");
            } catch (RemoteException | DynamiteModule.LoadingException e3) {
                ebc.e(this.f6699a, zzpj.OPTIONAL_MODULE_INIT_ERROR);
                throw new MlKitException("Failed to create thin barcode scanner.", 13, e3);
            }
        }
        ebc.e(this.f6699a, zzpj.NO_ERROR);
        return this.b;
    }
}
