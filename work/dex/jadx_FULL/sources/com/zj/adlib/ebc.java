package com.zj.adlib;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpk;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzpw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzte;
import com.google.android.gms.internal.mlkit_vision_barcode.zztm;
import com.google.android.gms.internal.mlkit_vision_barcode.zztw;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.internal.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ebc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray f41397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @SuppressLint({"UseSparseArrays"})
    public static final Map f16281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final AtomicReference f16282a;
    public static final SparseArray b;

    static {
        SparseArray sparseArray = new SparseArray();
        f41397a = sparseArray;
        SparseArray sparseArray2 = new SparseArray();
        b = sparseArray2;
        f16282a = new AtomicReference();
        sparseArray.put(-1, zzpv.FORMAT_UNKNOWN);
        sparseArray.put(1, zzpv.FORMAT_CODE_128);
        sparseArray.put(2, zzpv.FORMAT_CODE_39);
        sparseArray.put(4, zzpv.FORMAT_CODE_93);
        sparseArray.put(8, zzpv.FORMAT_CODABAR);
        sparseArray.put(16, zzpv.FORMAT_DATA_MATRIX);
        sparseArray.put(32, zzpv.FORMAT_EAN_13);
        sparseArray.put(64, zzpv.FORMAT_EAN_8);
        sparseArray.put(128, zzpv.FORMAT_ITF);
        sparseArray.put(256, zzpv.FORMAT_QR_CODE);
        sparseArray.put(512, zzpv.FORMAT_UPC_A);
        sparseArray.put(1024, zzpv.FORMAT_UPC_E);
        sparseArray.put(2048, zzpv.FORMAT_PDF417);
        sparseArray.put(4096, zzpv.FORMAT_AZTEC);
        sparseArray2.put(0, zzpw.TYPE_UNKNOWN);
        sparseArray2.put(1, zzpw.TYPE_CONTACT_INFO);
        sparseArray2.put(2, zzpw.TYPE_EMAIL);
        sparseArray2.put(3, zzpw.TYPE_ISBN);
        sparseArray2.put(4, zzpw.TYPE_PHONE);
        sparseArray2.put(5, zzpw.TYPE_PRODUCT);
        sparseArray2.put(6, zzpw.TYPE_SMS);
        sparseArray2.put(7, zzpw.TYPE_TEXT);
        sparseArray2.put(8, zzpw.TYPE_URL);
        sparseArray2.put(9, zzpw.TYPE_WIFI);
        sparseArray2.put(10, zzpw.TYPE_GEO);
        sparseArray2.put(11, zzpw.TYPE_CALENDAR_EVENT);
        sparseArray2.put(12, zzpw.TYPE_DRIVER_LICENSE);
        HashMap map = new HashMap();
        f16281a = map;
        map.put(1, zzte.CODE_128);
        map.put(2, zzte.CODE_39);
        map.put(4, zzte.CODE_93);
        map.put(8, zzte.CODABAR);
        map.put(16, zzte.DATA_MATRIX);
        map.put(32, zzte.EAN_13);
        map.put(64, zzte.EAN_8);
        map.put(128, zzte.ITF);
        map.put(256, zzte.QR_CODE);
        map.put(512, zzte.UPC_A);
        map.put(1024, zzte.UPC_E);
        map.put(2048, zzte.PDF417);
        map.put(4096, zzte.AZTEC);
    }

    public static zzpv a(@Barcode.BarcodeFormat int i) {
        zzpv zzpvVar = (zzpv) f41397a.get(i);
        return zzpvVar == null ? zzpv.FORMAT_UNKNOWN : zzpvVar;
    }

    public static zzpw b(@Barcode.BarcodeValueType int i) {
        zzpw zzpwVar = (zzpw) b.get(i);
        return zzpwVar == null ? zzpw.TYPE_UNKNOWN : zzpwVar;
    }

    public static asd c(am0 am0Var) {
        int iA = am0Var.a();
        ugc ugcVar = new ugc();
        if (iA == 0) {
            ugcVar.f(f16281a.values());
        } else {
            for (Map.Entry entry : f16281a.entrySet()) {
                if ((((Integer) entry.getKey()).intValue() & iA) != 0) {
                    ugcVar.e((zzte) entry.getValue());
                }
            }
        }
        yrd yrdVar = new yrd();
        yrdVar.b(ugcVar.g());
        return yrdVar.c();
    }

    public static String d() {
        return true != f() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning";
    }

    public static void e(lsd lsdVar, final zzpj zzpjVar) {
        lsdVar.f(new zztw() { // from class: com.zj.adlib.x6c
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zztw
            public final zztm a() {
                zzpj zzpjVar2 = zzpjVar;
                kmd kmdVar = new kmd();
                kmdVar.e(ebc.f() ? zzpi.TYPE_THICK : zzpi.TYPE_THIN);
                pnd pndVar = new pnd();
                pndVar.b(zzpjVar2);
                kmdVar.h(pndVar.c());
                return wsd.e(kmdVar);
            }
        }, zzpk.ON_DEVICE_BARCODE_LOAD);
    }

    public static boolean f() {
        AtomicReference atomicReference = f16282a;
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        boolean zB = b.b(hq5.c().b());
        atomicReference.set(Boolean.valueOf(zB));
        return zB;
    }
}
