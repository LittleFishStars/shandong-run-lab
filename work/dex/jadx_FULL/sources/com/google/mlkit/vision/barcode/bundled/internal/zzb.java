package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.Image;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.e;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.f;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.g;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzao;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzap;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzas;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzat;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzau;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzav;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaw;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzax;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzay;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaz;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbk;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbu;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb;
import com.google.android.libraries.barhopper.BarhopperV3;
import com.google.android.libraries.barhopper.RecognitionOptions;
import com.zj.adlib.bhd;
import com.zj.adlib.blc;
import com.zj.adlib.bvd;
import com.zj.adlib.c8c;
import com.zj.adlib.dm0;
import com.zj.adlib.eec;
import com.zj.adlib.em0;
import com.zj.adlib.g84;
import com.zj.adlib.g9c;
import com.zj.adlib.gpd;
import com.zj.adlib.hbc;
import com.zj.adlib.i8c;
import com.zj.adlib.koc;
import com.zj.adlib.l8c;
import com.zj.adlib.nec;
import com.zj.adlib.p7d;
import com.zj.adlib.pbc;
import com.zj.adlib.pld;
import com.zj.adlib.srd;
import com.zj.adlib.tzc;
import com.zj.adlib.v8c;
import com.zj.adlib.ydd;
import com.zj.adlib.yvc;
import com.zj.adlib.yw6;
import com.zj.adlib.z9c;
import com.zj.adlib.zgd;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class zzb extends zzbk {
    private static final int[] zza = {5, 7, 7, 7, 5, 5};
    private static final double[][] zzb = {new double[]{0.075d, 1.0d}, new double[]{0.1d, 1.0d}, new double[]{0.125d, 1.0d}, new double[]{0.2d, 2.0d}, new double[]{0.2d, 0.5d}, new double[]{0.15d, 1.0d}, new double[]{0.2d, 1.0d}, new double[]{0.25d, 1.0d}, new double[]{0.35d, 2.0d}, new double[]{0.35d, 0.5d}, new double[]{0.35d, 3.0d}, new double[]{0.35d, 0.3333d}, new double[]{0.3d, 1.0d}, new double[]{0.4d, 1.0d}, new double[]{0.5d, 1.0d}, new double[]{0.5d, 2.0d}, new double[]{0.5d, 0.5d}, new double[]{0.5d, 3.0d}, new double[]{0.5d, 0.3333d}, new double[]{0.6d, 1.0d}, new double[]{0.8d, 1.0d}, new double[]{1.0d, 1.0d}, new double[]{0.65d, 2.0d}, new double[]{0.65d, 0.5d}, new double[]{0.65d, 3.0d}, new double[]{0.65d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.8d, 2.0d}, new double[]{0.8d, 0.5d}, new double[]{0.8d, 3.0d}, new double[]{0.8d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.95d, 2.0d}, new double[]{0.95d, 0.5d}, new double[]{0.95d, 3.0d}, new double[]{0.95d, 0.3333d}};
    private final Context zzc;
    private final RecognitionOptions zzd;

    @Nullable
    private BarhopperV3 zze;

    public zzb(Context context, zzbc zzbcVar) {
        RecognitionOptions recognitionOptions = new RecognitionOptions();
        this.zzd = recognitionOptions;
        this.zzc = context;
        recognitionOptions.h(zzbcVar.zza());
        recognitionOptions.m(zzbcVar.zzb());
    }

    @Nullable
    private static zzap zze(@Nullable bhd bhdVar, @Nullable String str, String str2) {
        if (bhdVar == null || str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return new zzap(bhdVar.y(), bhdVar.w(), bhdVar.t(), bhdVar.u(), bhdVar.v(), bhdVar.x(), bhdVar.B(), matcher.find() ? matcher.group(1) : null);
    }

    private final dm0 zzf(ByteBuffer byteBuffer, zzbu zzbuVar) {
        BarhopperV3 barhopperV3 = (BarhopperV3) yw6.l(this.zze);
        if (((ByteBuffer) yw6.l(byteBuffer)).isDirect()) {
            return barhopperV3.l(zzbuVar.zzd(), zzbuVar.zza(), byteBuffer, this.zzd);
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return barhopperV3.m(zzbuVar.zzd(), zzbuVar.zza(), byteBuffer.array(), this.zzd);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return barhopperV3.m(zzbuVar.zzd(), zzbuVar.zza(), bArr, this.zzd);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbl
    public final List zzb(IObjectWrapper iObjectWrapper, zzbu zzbuVar) {
        dm0 dm0VarP;
        zzat zzatVar;
        zzaw zzawVar;
        zzax zzaxVar;
        zzaz zzazVar;
        zzay zzayVar;
        zzau zzauVar;
        zzaq zzaqVar;
        int i;
        zzar zzarVar;
        zzas zzasVar;
        int i2;
        Point[] pointArr;
        int i3;
        int i4;
        zzaw[] zzawVarArr;
        zzat[] zzatVarArr;
        zzao[] zzaoVarArr;
        int iZzb = zzbuVar.zzb();
        int i5 = -1;
        int i6 = 0;
        if (iZzb == -1) {
            dm0VarP = ((BarhopperV3) yw6.l(this.zze)).p((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), this.zzd);
        } else if (iZzb == 17) {
            dm0VarP = zzf((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzbuVar);
        } else if (iZzb != 35) {
            if (iZzb != 842094169) {
                throw new IllegalArgumentException("Unsupported image format: " + zzbuVar.zzb());
            }
            dm0VarP = zzf((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzbuVar);
        } else {
            dm0VarP = zzf(((Image) yw6.l((Image) ObjectWrapper.unwrap(iObjectWrapper))).getPlanes()[0].getBuffer(), zzbuVar);
        }
        ArrayList arrayList = new ArrayList();
        Matrix matrixE = g84.b().e(zzbuVar.zzd(), zzbuVar.zza(), zzbuVar.zzc());
        for (nec necVar : dm0VarP.v()) {
            if (necVar.u() > 0 && matrixE != null) {
                float[] fArr = new float[8];
                List listH = necVar.H();
                int iU = necVar.u();
                for (int i7 = i6; i7 < iU; i7++) {
                    int i8 = i7 + i7;
                    fArr[i8] = ((l8c) listH.get(i7)).t();
                    fArr[i8 + 1] = ((l8c) listH.get(i7)).u();
                }
                matrixE.mapPoints(fArr);
                int iZzc = zzbuVar.zzc();
                for (int i9 = i6; i9 < iU; i9++) {
                    hbc hbcVar = (hbc) necVar.f();
                    int i10 = i9 + i9;
                    i8c i8cVarV = l8c.v();
                    i8cVarV.t((int) fArr[i10]);
                    i8cVarV.u((int) fArr[i10 + 1]);
                    hbcVar.t((i9 + iZzc) % iU, (l8c) i8cVarV.L1());
                    necVar = (nec) hbcVar.L1();
                }
            }
            if (necVar.M()) {
                bvd bvdVarA = necVar.A();
                zzatVar = new zzat(bvdVarA.y() + i5, bvdVarA.v(), bvdVarA.x(), bvdVarA.w());
            } else {
                zzatVar = null;
            }
            if (necVar.O()) {
                g gVarV = necVar.v();
                zzawVar = new zzaw(gVarV.w() + i5, gVarV.v());
            } else {
                zzawVar = null;
            }
            if (necVar.P()) {
                v8c v8cVarC = necVar.C();
                zzaxVar = new zzax(v8cVarC.v(), v8cVarC.w());
            } else {
                zzaxVar = null;
            }
            if (necVar.R()) {
                z9c z9cVarE = necVar.E();
                zzazVar = new zzaz(z9cVarE.w(), z9cVarE.v(), z9cVarE.x() + i5);
            } else {
                zzazVar = null;
            }
            if (necVar.Q()) {
                g9c g9cVarD = necVar.D();
                zzayVar = new zzay(g9cVarD.v(), g9cVarD.w());
            } else {
                zzayVar = null;
            }
            if (necVar.N()) {
                c8c c8cVarB = necVar.B();
                zzauVar = new zzau(c8cVarB.t(), c8cVarB.u());
            } else {
                zzauVar = null;
            }
            if (necVar.J()) {
                pld pldVarX = necVar.x();
                zzaqVar = new zzaq(pldVarX.B(), pldVarX.x(), pldVarX.y(), pldVarX.z(), pldVarX.A(), zze(pldVarX.u(), necVar.F().zzn() ? necVar.F().zzu() : null, "DTSTART:([0-9TZ]*)"), zze(pldVarX.t(), necVar.F().zzn() ? necVar.F().zzu() : null, "DTEND:([0-9TZ]*)"));
            } else {
                zzaqVar = null;
            }
            if (necVar.K()) {
                gpd gpdVarY = necVar.y();
                f fVarT = gpdVarY.t();
                zzav zzavVar = fVarT != null ? new zzav(fVarT.w(), fVarT.A(), fVarT.z(), fVarT.v(), fVarT.y(), fVarT.x(), fVarT.B()) : null;
                String strW = gpdVarY.w();
                String strX = gpdVarY.x();
                List listA = gpdVarY.A();
                if (listA.isEmpty()) {
                    zzawVarArr = null;
                } else {
                    zzaw[] zzawVarArr2 = new zzaw[listA.size()];
                    for (int i11 = 0; i11 < listA.size(); i11++) {
                        zzawVarArr2[i11] = new zzaw(((g) listA.get(i11)).w() + i5, ((g) listA.get(i11)).v());
                    }
                    zzawVarArr = zzawVarArr2;
                }
                List listZ = gpdVarY.z();
                if (listZ.isEmpty()) {
                    zzatVarArr = null;
                } else {
                    zzat[] zzatVarArr2 = new zzat[listZ.size()];
                    int i12 = 0;
                    while (i12 < listZ.size()) {
                        zzatVarArr2[i12] = new zzat(((bvd) listZ.get(i12)).y() + i5, ((bvd) listZ.get(i12)).v(), ((bvd) listZ.get(i12)).x(), ((bvd) listZ.get(i12)).w());
                        i12++;
                        i5 = -1;
                    }
                    zzatVarArr = zzatVarArr2;
                }
                String[] strArr = (String[]) gpdVarY.B().toArray(new String[0]);
                List listY = gpdVarY.y();
                if (listY.isEmpty()) {
                    i = 0;
                    zzaoVarArr = null;
                } else {
                    zzao[] zzaoVarArr2 = new zzao[listY.size()];
                    for (int i13 = 0; i13 < listY.size(); i13++) {
                        zzaoVarArr2[i13] = new zzao(((e) listY.get(i13)).v() - 1, (String[]) ((e) listY.get(i13)).u().toArray(new String[0]));
                    }
                    i = 0;
                    zzaoVarArr = zzaoVarArr2;
                }
                zzarVar = new zzar(zzavVar, strW, strX, zzawVarArr, zzatVarArr, strArr, zzaoVarArr);
            } else {
                i = 0;
                zzarVar = null;
            }
            if (necVar.L()) {
                srd srdVarZ = necVar.z();
                zzasVar = new zzas(srdVarZ.A(), srdVarZ.C(), srdVarZ.I(), srdVarZ.G(), srdVarZ.D(), srdVarZ.x(), srdVarZ.v(), srdVarZ.w(), srdVarZ.y(), srdVarZ.H(), srdVarZ.E(), srdVarZ.B(), srdVarZ.z(), srdVarZ.F());
            } else {
                zzasVar = null;
            }
            switch (necVar.S() - 1) {
                case 0:
                    i2 = i;
                    break;
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 8;
                    break;
                case 5:
                    i2 = 16;
                    break;
                case 6:
                    i2 = 32;
                    break;
                case 7:
                    i2 = 64;
                    break;
                case 8:
                    i2 = 128;
                    break;
                case 9:
                    i2 = 256;
                    break;
                case 10:
                    i2 = 512;
                    break;
                case 11:
                    i2 = 1024;
                    break;
                case 12:
                    i2 = 2048;
                    break;
                case 13:
                    i2 = 4096;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            String strG = necVar.G();
            String strZzu = necVar.F().zzn() ? necVar.F().zzu() : null;
            byte[] bArrZzx = necVar.F().zzx();
            List listH2 = necVar.H();
            if (listH2.isEmpty()) {
                pointArr = null;
            } else {
                Point[] pointArr2 = new Point[listH2.size()];
                for (int i14 = i; i14 < listH2.size(); i14++) {
                    pointArr2[i14] = new Point(((l8c) listH2.get(i14)).t(), ((l8c) listH2.get(i14)).u());
                }
                pointArr = pointArr2;
            }
            switch (necVar.t() - 1) {
                case 1:
                    i3 = 1;
                    continue;
                    arrayList.add(new zzba(i2, strG, strZzu, bArrZzx, pointArr, i3, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                    i5 = -1;
                    i6 = i;
                    break;
                case 2:
                    i3 = 2;
                    continue;
                    arrayList.add(new zzba(i2, strG, strZzu, bArrZzx, pointArr, i3, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                    i5 = -1;
                    i6 = i;
                    break;
                case 3:
                    i4 = 3;
                    break;
                case 4:
                    i3 = 4;
                    continue;
                    arrayList.add(new zzba(i2, strG, strZzu, bArrZzx, pointArr, i3, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                    i5 = -1;
                    i6 = i;
                    break;
                case 5:
                    i4 = 5;
                    break;
                case 6:
                    i4 = 6;
                    break;
                case 7:
                    i4 = 7;
                    break;
                case 8:
                    i3 = 8;
                    continue;
                    arrayList.add(new zzba(i2, strG, strZzu, bArrZzx, pointArr, i3, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                    i5 = -1;
                    i6 = i;
                    break;
                case 9:
                    i4 = 9;
                    break;
                case 10:
                    i4 = 10;
                    break;
                case 11:
                    i4 = 11;
                    break;
                case 12:
                    i4 = 12;
                    break;
                default:
                    i3 = i;
                    continue;
                    arrayList.add(new zzba(i2, strG, strZzu, bArrZzx, pointArr, i3, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
                    i5 = -1;
                    i6 = i;
                    break;
            }
            i3 = i4;
            arrayList.add(new zzba(i2, strG, strZzu, bArrZzx, pointArr, i3, zzatVar, zzawVar, zzaxVar, zzazVar, zzayVar, zzauVar, zzaqVar, zzarVar, zzasVar));
            i5 = -1;
            i6 = i;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbl
    public final void zzc() throws IllegalAccessException, InvocationTargetException {
        if (this.zze != null) {
            return;
        }
        this.zze = new BarhopperV3();
        yvc yvcVarT = tzc.t();
        blc blcVarT = koc.t();
        int i = 16;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            pbc pbcVarT = eec.t();
            pbcVarT.v(i);
            pbcVarT.x(i);
            for (int i4 = 0; i4 < zza[i3]; i4++) {
                double[] dArr = zzb[i2];
                double d = dArr[0] * 320.0d;
                float fSqrt = (float) Math.sqrt(dArr[1]);
                float f = (float) d;
                pbcVarT.t(f / fSqrt);
                pbcVarT.u(f * fSqrt);
                i2++;
            }
            i += i;
            blcVarT.t(pbcVarT);
        }
        yvcVarT.t(blcVarT);
        try {
            InputStream inputStreamOpen = this.zzc.getAssets().open("mlkit_barcode_models/barcode_ssd_mobilenet_v1_dmp25_quant.tflite");
            try {
                InputStream inputStreamOpen2 = this.zzc.getAssets().open("mlkit_barcode_models/oned_auto_regressor_mobile.tflite");
                try {
                    InputStream inputStreamOpen3 = this.zzc.getAssets().open("mlkit_barcode_models/oned_feature_extractor_mobile.tflite");
                    try {
                        BarhopperV3 barhopperV3 = (BarhopperV3) yw6.l(this.zze);
                        p7d p7dVarT = em0.t();
                        yvcVarT.u(zzdb.zzs(inputStreamOpen));
                        p7dVarT.t(yvcVarT);
                        ydd yddVarT = zgd.t();
                        yddVarT.t(zzdb.zzs(inputStreamOpen2));
                        yddVarT.u(zzdb.zzs(inputStreamOpen3));
                        p7dVarT.u(yddVarT);
                        barhopperV3.h(p7dVarT.L1());
                        if (inputStreamOpen3 != null) {
                            inputStreamOpen3.close();
                        }
                        if (inputStreamOpen2 != null) {
                            inputStreamOpen2.close();
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                    } catch (Throwable th) {
                        if (inputStreamOpen3 != null) {
                            try {
                                inputStreamOpen3.close();
                            } catch (Throwable th2) {
                                Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (inputStreamOpen2 != null) {
                        try {
                            inputStreamOpen2.close();
                        } catch (Throwable th4) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th3, th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th6) {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th5, th6);
                    }
                }
                throw th5;
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to open Barcode models", e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbl
    public final void zzd() {
        BarhopperV3 barhopperV3 = this.zze;
        if (barhopperV3 != null) {
            barhopperV3.close();
            this.zze = null;
        }
    }
}
