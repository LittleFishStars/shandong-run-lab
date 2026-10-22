package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.b;
import com.google.android.gms.internal.mlkit_common.zzar;
import com.google.android.gms.internal.mlkit_common.zzau;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class kd6 {

    @NonNull
    @KeepForSdk
    public static final String A = "langid";

    @NonNull
    @KeepForSdk
    public static final String B = "nlclassifier";

    @NonNull
    @KeepForSdk
    public static final String C = "tflite_dynamite";

    @NonNull
    @KeepForSdk
    public static final String D = "barcode_ui";

    @NonNull
    @KeepForSdk
    public static final String E = "smart_reply";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @KeepForSdk
    public static final Feature f42794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final zzau f17640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17641a = "com.google.android.gms.vision.dynamite";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final Feature[] f17642a = new Feature[0];

    @NonNull
    @KeepForSdk
    public static final Feature b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final zzau f17643b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17644b = "com.google.android.gms.vision.barcode";

    @NonNull
    @KeepForSdk
    public static final Feature c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17645c = "com.google.android.gms.vision.custom.ica";

    @NonNull
    @KeepForSdk
    public static final Feature d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17646d = "com.google.android.gms.vision.face";

    @NonNull
    @KeepForSdk
    public static final Feature e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17647e = "com.google.android.gms.vision.ica";

    @NonNull
    @KeepForSdk
    public static final Feature f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17648f = "com.google.android.gms.vision.ocr";

    @NonNull
    @KeepForSdk
    public static final Feature g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17649g = "com.google.android.gms.mlkit_ocr_chinese";

    @NonNull
    @KeepForSdk
    public static final Feature h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17650h = "com.google.android.gms.mlkit_ocr_common";

    @NonNull
    @KeepForSdk
    public static final Feature i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17651i = "com.google.android.gms.mlkit_ocr_devanagari";

    @NonNull
    @KeepForSdk
    public static final Feature j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17652j = "com.google.android.gms.mlkit_ocr_japanese";

    @NonNull
    @KeepForSdk
    public static final Feature k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17653k = "com.google.android.gms.mlkit_ocr_korean";

    @NonNull
    @KeepForSdk
    public static final Feature l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17654l = "com.google.android.gms.mlkit.langid";

    @NonNull
    @KeepForSdk
    public static final Feature m;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17655m = "com.google.android.gms.mlkit.nlclassifier";

    @NonNull
    @KeepForSdk
    public static final Feature n;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17656n = "com.google.android.gms.tflite_dynamite";

    @NonNull
    @KeepForSdk
    public static final Feature o;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17657o = "com.google.android.gms.mlkit_smartreply";

    @NonNull
    @KeepForSdk
    public static final Feature p;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17658p = "com.google.android.gms.mlkit_image_caption";

    @NonNull
    @KeepForSdk
    public static final Feature q;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17659q = "com.google.android.gms.mlkit_quality_aesthetic";

    @NonNull
    @KeepForSdk
    public static final Feature r;

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17660r = "com.google.android.gms.mlkit_quality_technical";

    @NonNull
    @KeepForSdk
    public static final Feature s;

    /* JADX INFO: renamed from: s, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17661s = "com.google.android.gms.mlkit_docscan_detect";

    @NonNull
    @KeepForSdk
    public static final Feature t;

    /* JADX INFO: renamed from: t, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17662t = "com.google.android.gms.mlkit_docscan_crop";

    @NonNull
    @KeepForSdk
    public static final Feature u;

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final String f17663u = "com.google.android.gms.mlkit_docscan_enhance";

    @NonNull
    @KeepForSdk
    public static final String v = "barcode";

    @NonNull
    @KeepForSdk
    public static final String w = "custom_ica";

    @NonNull
    @KeepForSdk
    public static final String x = "face";

    @NonNull
    @KeepForSdk
    public static final String y = "ica";

    @NonNull
    @KeepForSdk
    public static final String z = "ocr";

    static {
        Feature feature = new Feature("vision.barcode", 1L);
        f42794a = feature;
        Feature feature2 = new Feature("vision.custom.ica", 1L);
        b = feature2;
        Feature feature3 = new Feature("vision.face", 1L);
        c = feature3;
        Feature feature4 = new Feature("vision.ica", 1L);
        d = feature4;
        Feature feature5 = new Feature("vision.ocr", 1L);
        e = feature5;
        f = new Feature("mlkit.ocr.chinese", 1L);
        g = new Feature("mlkit.ocr.common", 1L);
        h = new Feature("mlkit.ocr.devanagari", 1L);
        i = new Feature("mlkit.ocr.japanese", 1L);
        j = new Feature("mlkit.ocr.korean", 1L);
        Feature feature6 = new Feature("mlkit.langid", 1L);
        k = feature6;
        Feature feature7 = new Feature("mlkit.nlclassifier", 1L);
        l = feature7;
        Feature feature8 = new Feature(C, 1L);
        m = feature8;
        Feature feature9 = new Feature("mlkit.barcode.ui", 1L);
        n = feature9;
        Feature feature10 = new Feature("mlkit.smartreply", 1L);
        o = feature10;
        p = new Feature("mlkit.image.caption", 1L);
        q = new Feature("mlkit.docscan.detect", 1L);
        r = new Feature("mlkit.docscan.crop", 1L);
        s = new Feature("mlkit.docscan.enhance", 1L);
        t = new Feature("mlkit.quality.aesthetic", 1L);
        u = new Feature("mlkit.quality.technical", 1L);
        b bVar = new b();
        bVar.a(v, feature);
        bVar.a(w, feature2);
        bVar.a(x, feature3);
        bVar.a(y, feature4);
        bVar.a(z, feature5);
        bVar.a(A, feature6);
        bVar.a(B, feature7);
        bVar.a(C, feature8);
        bVar.a(D, feature9);
        bVar.a(E, feature10);
        f17640a = bVar.b();
        b bVar2 = new b();
        bVar2.a(f17644b, feature);
        bVar2.a(f17645c, feature2);
        bVar2.a(f17646d, feature3);
        bVar2.a(f17647e, feature4);
        bVar2.a(f17648f, feature5);
        bVar2.a(f17654l, feature6);
        bVar2.a(f17655m, feature7);
        bVar2.a(f17656n, feature8);
        bVar2.a(f17657o, feature10);
        f17643b = bVar2.b();
    }

    @KeepForSdk
    @WorkerThread
    @Deprecated
    public static boolean a(@NonNull Context context, @NonNull List<String> list) throws Throwable {
        if (qv3.i().b(context) >= 221500000) {
            return b(context, f(f17643b, list));
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                DynamiteModule.e(context, DynamiteModule.f5722a, it.next());
            }
            return true;
        } catch (DynamiteModule.LoadingException unused) {
            return false;
        }
    }

    @KeepForSdk
    @WorkerThread
    public static boolean b(@NonNull Context context, @NonNull final Feature[] featureArr) {
        try {
            return ((ModuleAvailabilityResponse) a.a(ar5.b(context).c(new OptionalModuleApi() { // from class: com.zj.adlib.hjd
                @Override // com.google.android.gms.common.api.OptionalModuleApi
                public final Feature[] g() {
                    Feature[] featureArr2 = featureArr;
                    Feature[] featureArr3 = kd6.f17642a;
                    return featureArr2;
                }
            }).h(new OnFailureListener() { // from class: com.zj.adlib.old
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Log.e("OptionalModuleUtils", "Failed to check feature availability", exc);
                }
            }))).areModulesAvailable();
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("OptionalModuleUtils", "Failed to complete the task of features availability check", e2);
            return false;
        }
    }

    @KeepForSdk
    @Deprecated
    public static void c(@NonNull Context context, @NonNull String str) {
        d(context, zzar.zzh(str));
    }

    @KeepForSdk
    @Deprecated
    public static void d(@NonNull Context context, @NonNull List<String> list) {
        if (qv3.i().b(context) >= 221500000) {
            e(context, f(f17640a, list));
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(",", list));
        intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
        context.sendBroadcast(intent);
    }

    @KeepForSdk
    public static void e(@NonNull Context context, @NonNull final Feature[] featureArr) {
        ar5.b(context).a(br5.d().a(new OptionalModuleApi() { // from class: com.zj.adlib.mnd
            @Override // com.google.android.gms.common.api.OptionalModuleApi
            public final Feature[] g() {
                Feature[] featureArr2 = featureArr;
                Feature[] featureArr3 = kd6.f17642a;
                return featureArr2;
            }
        }).b()).h(new OnFailureListener() { // from class: com.zj.adlib.fpd
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                Log.e("OptionalModuleUtils", "Failed to request modules install request", exc);
            }
        });
    }

    public static Feature[] f(Map map, List list) {
        Feature[] featureArr = new Feature[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            featureArr[i2] = (Feature) yw6.l((Feature) map.get(list.get(i2)));
        }
        return featureArr;
    }
}
