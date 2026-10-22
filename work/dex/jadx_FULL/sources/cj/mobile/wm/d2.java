package cj.mobile.wm;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d2 {
    public static volatile d2 dexo = null;
    public static boolean dexp = true;
    public final m4 dexa;
    public final g3 dexb;
    public final r3 dexc;
    public final f4 dexd;
    public final com.wangmai.insightvision.openadsdk.image.b.n.a dexe;
    public final s8 dexf = new s8();
    public final i7 dexg;
    public final b8 dexh;
    public final v5 dexi;
    public final d7 dexj;
    public final z5 dexk;
    public final d7 dexl;
    public final Handler dexm;
    public final j4 dexn;

    public d2(g3 g3Var, f4 f4Var, r3 r3Var, Context context, com.wangmai.insightvision.openadsdk.image.b.n.a aVar) {
        i7 i7Var = new i7();
        this.dexg = i7Var;
        this.dexb = g3Var;
        this.dexc = r3Var;
        this.dexd = f4Var;
        this.dexe = aVar;
        this.dexa = new m4(context);
        this.dexm = new Handler(Looper.getMainLooper());
        this.dexn = new j4(f4Var, r3Var, aVar);
        b8 b8Var = new b8();
        this.dexh = b8Var;
        e6 e6Var = new e6(r3Var, aVar);
        b8Var.dexa(InputStream.class, Bitmap.class, e6Var);
        x5 x5Var = new x5(r3Var, aVar);
        b8Var.dexa(ParcelFileDescriptor.class, Bitmap.class, x5Var);
        d6 d6Var = new d6(e6Var, x5Var);
        b8Var.dexa(q4.class, Bitmap.class, d6Var);
        q6 q6Var = new q6(context, r3Var);
        b8Var.dexa(InputStream.class, p6.class, q6Var);
        b8Var.dexa(q4.class, y6.class, new e7(d6Var, q6Var, r3Var));
        b8Var.dexa(InputStream.class, File.class, new n6());
        dexa(File.class, ParcelFileDescriptor.class, new c5.dexa());
        dexa(File.class, InputStream.class, new i5.dexa());
        Class cls = Integer.TYPE;
        dexa(cls, ParcelFileDescriptor.class, new d5.dexa());
        dexa(cls, InputStream.class, new j5.dexa());
        dexa(Integer.class, ParcelFileDescriptor.class, new d5.dexa());
        dexa(Integer.class, InputStream.class, new j5.dexa());
        dexa(String.class, ParcelFileDescriptor.class, new e5.dexa());
        dexa(String.class, InputStream.class, new k5.dexa());
        dexa(Uri.class, ParcelFileDescriptor.class, new f5.dexa());
        dexa(Uri.class, InputStream.class, new l5.dexa());
        dexa(URL.class, InputStream.class, new m5.dexa());
        dexa(n4.class, InputStream.class, new g5.dexa());
        dexa(byte[].class, InputStream.class, new h5.dexa());
        i7Var.dexa(Bitmap.class, a6.class, new g7(context.getResources(), r3Var));
        i7Var.dexa(y6.class, j6.class, new f7(new g7(context.getResources(), r3Var)));
        v5 v5Var = new v5(r3Var);
        this.dexi = v5Var;
        this.dexj = new d7(r3Var, v5Var);
        z5 z5Var = new z5(r3Var);
        this.dexk = z5Var;
        this.dexl = new d7(r3Var, z5Var);
    }

    public static d2 dexa(Context context) {
        if (dexo == null) {
            synchronized (d2.class) {
                if (dexo == null) {
                    Context applicationContext = context.getApplicationContext();
                    e2 e2Var = new e2(applicationContext);
                    List<x7> listDexb = dexb(applicationContext);
                    Iterator<x7> it = listDexb.iterator();
                    while (it.hasNext()) {
                        it.next().dexa(applicationContext, e2Var);
                    }
                    dexo = e2Var.dexa();
                    Iterator<x7> it2 = listDexb.iterator();
                    while (it2.hasNext()) {
                        it2.next().dexa(applicationContext, dexo);
                    }
                }
            }
        }
        return dexo;
    }

    public static <T> v4<T, ParcelFileDescriptor> dexa(Class<T> cls, Context context) {
        return dexa(cls, ParcelFileDescriptor.class, context);
    }

    public static <T, Y> v4<T, Y> dexa(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return dexa(context).dexe().dexa(cls, cls2);
        }
        if (!Log.isLoggable("Glide", 3)) {
            return null;
        }
        f1.dexa("Glide", "Unable to load null model, setting placeholder only");
        return null;
    }

    public static void dexa(v8<?> v8Var) {
        e9.dexa();
        f8 f8VarC = v8Var.c();
        if (f8VarC != null) {
            f8VarC.clear();
            v8Var.dexa((f8) null);
        }
    }

    public static <T> v4<T, InputStream> dexb(Class<T> cls, Context context) {
        return dexa(cls, InputStream.class, context);
    }

    public static List<x7> dexb(Context context) {
        return dexp ? new y7(context).dexa() : Collections.emptyList();
    }

    public static f2 dexc(Context context) {
        return u7.dexa().dexa(context);
    }

    private m4 dexe() {
        return this.dexa;
    }

    public <T, Z> a8<T, Z> dexa(Class<T> cls, Class<Z> cls2) {
        return this.dexh.dexa(cls, cls2);
    }

    public void dexa() {
        e9.dexa();
        this.dexd.a();
        this.dexc.a();
    }

    public void dexa(int i) {
        e9.dexa();
        this.dexd.a(i);
        this.dexc.a(i);
    }

    public <T, Y> void dexa(Class<T> cls, Class<Y> cls2, w4<T, Y> w4Var) {
        w4<T, Y> w4VarDexa = this.dexa.dexa(cls, cls2, w4Var);
        if (w4VarDexa != null) {
            w4VarDexa.a();
        }
    }

    public <Z, R> h7<Z, R> dexb(Class<Z> cls, Class<R> cls2) {
        return this.dexg.dexa(cls, cls2);
    }

    public r3 dexb() {
        return this.dexc;
    }

    public com.wangmai.insightvision.openadsdk.image.b.n.a dexc() {
        return this.dexe;
    }

    public g3 dexd() {
        return this.dexb;
    }
}
