package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.google.android.exoplayer2.util.FileTypes;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x35 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, h45<k35>> f45739a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f20601a = {80, 75, 3, 4};

    @WorkerThread
    public static f45<k35> A(String str, @Nullable String str2) {
        return x(JsonReader.w(Okio.buffer(Okio.source(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    @WorkerThread
    @Deprecated
    public static f45<k35> B(JSONObject jSONObject, @Nullable String str) {
        return A(jSONObject.toString(), str);
    }

    public static h45<k35> C(Context context, @RawRes int i) {
        return D(context, i, a0(context, i));
    }

    public static h45<k35> D(Context context, @RawRes final int i, @Nullable final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return l(str, new Callable() { // from class: com.zj.adlib.n35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x35.X(weakReference, applicationContext, i, str);
            }
        });
    }

    @WorkerThread
    public static f45<k35> E(Context context, @RawRes int i) {
        return F(context, i, a0(context, i));
    }

    @WorkerThread
    public static f45<k35> F(Context context, @RawRes int i, @Nullable String str) {
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i)));
            return O(bufferedSourceBuffer).booleanValue() ? L(new ZipInputStream(bufferedSourceBuffer.inputStream()), str) : u(bufferedSourceBuffer.inputStream(), str);
        } catch (Resources.NotFoundException e) {
            return new f45<>((Throwable) e);
        }
    }

    public static h45<k35> G(Context context, String str) {
        return H(context, str, "url_" + str);
    }

    public static h45<k35> H(final Context context, final String str, @Nullable final String str2) {
        return l(str2, new Callable() { // from class: com.zj.adlib.o35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x35.Y(context, str, str2);
            }
        });
    }

    @WorkerThread
    public static f45<k35> I(Context context, String str) {
        return J(context, str, str);
    }

    @WorkerThread
    public static f45<k35> J(Context context, String str, @Nullable String str2) {
        f45<k35> f45VarC = vs4.d(context).c(str, str2);
        if (str2 != null && f45VarC.b() != null) {
            l35.c().d(str2, f45VarC.b());
        }
        return f45VarC;
    }

    public static h45<k35> K(final ZipInputStream zipInputStream, @Nullable final String str) {
        return l(str, new Callable() { // from class: com.zj.adlib.v35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x35.L(zipInputStream, str);
            }
        });
    }

    @WorkerThread
    public static f45<k35> L(ZipInputStream zipInputStream, @Nullable String str) {
        try {
            return M(zipInputStream, str);
        } finally {
            vj9.c(zipInputStream);
        }
    }

    @WorkerThread
    public static f45<k35> M(ZipInputStream zipInputStream, @Nullable String str) {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            k35 k35VarB = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase(qt1.c)) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    k35VarB = y(JsonReader.w(Okio.buffer(Okio.source(zipInputStream))), null, false).b();
                } else if (name.contains(".png") || name.contains(".webp") || name.contains(FileTypes.F) || name.contains(".jpeg")) {
                    String[] strArrSplit = name.split(WVNativeCallbackUtil.SEPERATER);
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (k35VarB == null) {
                return new f45<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                b45 b45VarN = n(k35VarB, (String) entry.getKey());
                if (b45VarN != null) {
                    b45VarN.h(vj9.m((Bitmap) entry.getValue(), b45VarN.f(), b45VarN.d()));
                }
            }
            for (Map.Entry<String, b45> entry2 : k35VarB.j().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new f45<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().c()));
                }
            }
            if (str != null) {
                l35.c().d(str, k35VarB);
            }
            return new f45<>(k35VarB);
        } catch (IOException e) {
            return new f45<>((Throwable) e);
        }
    }

    public static boolean N(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static Boolean O(BufferedSource bufferedSource) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b : f20601a) {
                if (bufferedSourcePeek.readByte() != b) {
                    return Boolean.FALSE;
                }
            }
            bufferedSourcePeek.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            g25.c("Failed to check zip file header", e);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ void P(String str, AtomicBoolean atomicBoolean, Throwable th) {
        f45739a.remove(str);
        atomicBoolean.set(true);
    }

    public static /* synthetic */ f45 Q(k35 k35Var) throws Exception {
        return new f45(k35Var);
    }

    public static /* synthetic */ void R(String str, AtomicBoolean atomicBoolean, k35 k35Var) {
        f45739a.remove(str);
        atomicBoolean.set(true);
    }

    public static /* synthetic */ f45 X(WeakReference weakReference, Context context, int i, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return F(context, i, str);
    }

    public static /* synthetic */ f45 Y(Context context, String str, String str2) throws Exception {
        f45<k35> f45VarC = vs4.d(context).c(str, str2);
        if (str2 != null && f45VarC.b() != null) {
            l35.c().d(str2, f45VarC.b());
        }
        return f45VarC;
    }

    public static String a0(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(N(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    public static void b0(int i) {
        l35.c().e(i);
    }

    public static h45<k35> l(@Nullable final String str, Callable<f45<k35>> callable) {
        final k35 k35VarB = str == null ? null : l35.c().b(str);
        if (k35VarB != null) {
            return new h45<>(new Callable() { // from class: com.zj.adlib.q35
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return x35.Q(k35VarB);
                }
            });
        }
        if (str != null) {
            Map<String, h45<k35>> map = f45739a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        h45<k35> h45Var = new h45<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            h45Var.d(new LottieListener() { // from class: com.zj.adlib.r35
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    x35.R(str, atomicBoolean, (k35) obj);
                }
            });
            h45Var.c(new LottieListener() { // from class: com.zj.adlib.s35
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    x35.P(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                f45739a.put(str, h45Var);
            }
        }
        return h45Var;
    }

    public static void m(Context context) {
        f45739a.clear();
        l35.c().a();
        vs4.c(context).a();
    }

    @Nullable
    public static b45 n(k35 k35Var, String str) {
        for (b45 b45Var : k35Var.j().values()) {
            if (b45Var.c().equals(str)) {
                return b45Var;
            }
        }
        return null;
    }

    public static h45<k35> o(Context context, String str) {
        return p(context, str, "asset_" + str);
    }

    public static h45<k35> p(Context context, final String str, @Nullable final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return l(str2, new Callable() { // from class: com.zj.adlib.w35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x35.r(applicationContext, str, str2);
            }
        });
    }

    @WorkerThread
    public static f45<k35> q(Context context, String str) {
        return r(context, str, "asset_" + str);
    }

    @WorkerThread
    public static f45<k35> r(Context context, String str, @Nullable String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return u(context.getAssets().open(str), str2);
            }
            return L(new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new f45<>((Throwable) e);
        }
    }

    @Deprecated
    public static h45<k35> s(final JSONObject jSONObject, @Nullable final String str) {
        return l(str, new Callable() { // from class: com.zj.adlib.p35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x35.B(jSONObject, str);
            }
        });
    }

    public static h45<k35> t(final InputStream inputStream, @Nullable final String str) {
        return l(str, new Callable() { // from class: com.zj.adlib.u35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x35.u(inputStream, str);
            }
        });
    }

    @WorkerThread
    public static f45<k35> u(InputStream inputStream, @Nullable String str) {
        return v(inputStream, str, true);
    }

    @WorkerThread
    public static f45<k35> v(InputStream inputStream, @Nullable String str, boolean z) {
        try {
            return x(JsonReader.w(Okio.buffer(Okio.source(inputStream))), str);
        } finally {
            if (z) {
                vj9.c(inputStream);
            }
        }
    }

    public static h45<k35> w(final JsonReader jsonReader, @Nullable final String str) {
        return l(str, new Callable() { // from class: com.zj.adlib.m35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x35.x(jsonReader, str);
            }
        });
    }

    @WorkerThread
    public static f45<k35> x(JsonReader jsonReader, @Nullable String str) {
        return y(jsonReader, str, true);
    }

    public static f45<k35> y(JsonReader jsonReader, @Nullable String str, boolean z) {
        try {
            k35 k35VarA = y35.a(jsonReader);
            if (str != null) {
                l35.c().d(str, k35VarA);
            }
            return new f45<>(k35VarA);
        } catch (Exception e) {
            return new f45<>((Throwable) e);
        } finally {
            if (z) {
                vj9.c(jsonReader);
            }
        }
    }

    public static h45<k35> z(final String str, @Nullable final String str2) {
        return l(str2, new Callable() { // from class: com.zj.adlib.t35
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return x35.A(str, str2);
            }
        });
    }
}
