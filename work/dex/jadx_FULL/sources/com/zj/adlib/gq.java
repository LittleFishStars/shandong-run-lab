package com.zj.adlib;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.androidquery.util.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class gq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41963a = 4096;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Context f16837a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Handler f16838a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static File f16839a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Object f16840a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Thread.UncaughtExceptionHandler f16841a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Map<String, Long> f16842a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ScheduledExecutorService f16843a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f16844a = false;
    public static File b;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f41964a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Class[] f16845a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object[] f16846a;
        public final /* synthetic */ String f;

        public a(Object obj, String str, Class[] clsArr, Object[] objArr) {
            this.f41964a = obj;
            this.f = str;
            this.f16845a = clsArr;
            this.f16846a = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            gq.B(this.f41964a, this.f, false, true, this.f16845a, this.f16846a);
        }
    }

    public static class b extends AsyncTask<Void, Void, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f41965a;

        public b(Runnable runnable) {
            this.f41965a = runnable;
        }

        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            try {
                this.f41965a.run();
                return null;
            } catch (Exception e) {
                gq.Q(e);
                return null;
            }
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f41966a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Class[] f16847a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object[] f16848a;
        public final /* synthetic */ String f;

        public c(Object obj, String str, Class[] clsArr, Object[] objArr) {
            this.f41966a = obj;
            this.f = str;
            this.f16847a = clsArr;
            this.f16848a = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            gq.B(this.f41966a, this.f, false, true, this.f16847a, this.f16848a);
        }
    }

    public static Object A(Object obj, String str, boolean z, boolean z2, Class<?>[] clsArr, Class<?>[] clsArr2, Object... objArr) {
        try {
            return C(obj, str, z, clsArr, clsArr2, objArr);
        } catch (Exception e) {
            if (z2) {
                Q(e);
                return null;
            }
            k(e);
            return null;
        }
    }

    public static Object B(Object obj, String str, boolean z, boolean z2, Class<?>[] clsArr, Object... objArr) {
        return A(obj, str, z, z2, clsArr, null, objArr);
    }

    public static Object C(Object obj, String str, boolean z, Class<?>[] clsArr, Class<?>[] clsArr2, Object... objArr) throws Exception {
        if (obj != null && str != null) {
            if (clsArr == null) {
                try {
                    clsArr = new Class[0];
                } catch (NoSuchMethodException unused) {
                    if (z) {
                        try {
                            return clsArr2 == null ? obj.getClass().getMethod(str, new Class[0]).invoke(obj, new Object[0]) : obj.getClass().getMethod(str, clsArr2).invoke(obj, objArr);
                        } catch (NoSuchMethodException unused2) {
                        }
                    }
                }
            }
            return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        }
        return null;
    }

    public static boolean D() {
        return f16844a;
    }

    public static boolean E() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    public static void F(File file) {
        file.setLastModified(System.currentTimeMillis());
    }

    public static File G(File file, String str) {
        return new File(file, str);
    }

    public static float H(Context context, float f) {
        return f / (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    public static void I(Object obj, String str) {
        J(obj, str, new Class[0], new Object[0]);
    }

    public static void J(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        K(new a(obj, str, clsArr, objArr));
    }

    public static void K(Runnable runnable) {
        w().post(runnable);
    }

    public static void L(Object obj, String str) {
        M(obj, str, new Class[0], new Object[0]);
    }

    public static void M(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        N(new c(obj, str, clsArr, objArr));
    }

    public static void N(Runnable runnable) {
        new b(runnable).execute(new Void[0]);
    }

    public static void O(Runnable runnable, long j) {
        w().postDelayed(runnable, j);
    }

    public static void P(Runnable runnable) {
        w().removeCallbacks(runnable);
    }

    public static void Q(Throwable th) {
        if (th == null) {
            return;
        }
        try {
            d0("reporting", Log.getStackTraceString(th));
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f16841a;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void R(View view, float f) {
        if (f == 1.0f) {
            view.clearAnimation();
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public static void S(File file) {
        f16839a = file;
        if (file != null) {
            file.mkdirs();
        }
    }

    public static void T(Application application) {
        f16837a = application.getApplicationContext();
    }

    public static void U(boolean z) {
        f16844a = z;
    }

    public static void V(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        f16841a = uncaughtExceptionHandler;
    }

    public static void W(File file, byte[] bArr) {
        if (file != null) {
            try {
                e0(file, bArr);
            } catch (Exception e) {
                Q(e);
            }
        }
    }

    public static void X(File file, byte[] bArr, long j) {
        v().schedule(new vp1().g(1, file, bArr), j, TimeUnit.MILLISECONDS);
    }

    public static boolean Y(File[] fileArr, long j) {
        long length = 0;
        for (File file : fileArr) {
            length += file.length();
            if (length > j) {
                return true;
            }
        }
        return false;
    }

    public static void Z(String str) {
        f16842a.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void a(SharedPreferences.Editor editor) {
        if (Constants.y >= 9) {
            B(editor, "apply", false, true, null, null);
        } else {
            editor.commit();
        }
    }

    public static long a0(String str, long j) {
        Long l = f16842a.get(str);
        if (l == null) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - l.longValue();
        if (j == 0 || jCurrentTimeMillis > j) {
            j(str, Long.valueOf(jCurrentTimeMillis));
        }
        return jCurrentTimeMillis;
    }

    public static void b(File file, long j, long j2) {
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            Arrays.sort(fileArrListFiles, new vp1());
            if (Y(fileArrListFiles, j)) {
                c(fileArrListFiles, j2);
            }
            File fileZ = z();
            if (fileZ == null || !fileZ.exists()) {
                return;
            }
            c(fileZ.listFiles(), 0L);
        } catch (Exception e) {
            Q(e);
        }
    }

    public static byte[] b0(InputStream inputStream) {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g(inputStream, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            Q(e);
            byteArray = null;
        }
        f(inputStream);
        return byteArray;
    }

    public static void c(File[] fileArr, long j) {
        long length = 0;
        int i = 0;
        for (File file : fileArr) {
            if (file.isFile()) {
                length += file.length();
                if (length >= j) {
                    file.delete();
                    i++;
                }
            }
        }
        j("deleted", Integer.valueOf(i));
    }

    public static void c0(View view, boolean z) {
        R(view, z ? 0.5f : 1.0f);
    }

    public static void d(Context context) {
        e(context, 3000000L, 2000000L);
    }

    public static void d0(Object obj, Object obj2) {
        Log.w("AQuery", obj + u15.f19942b + obj2);
    }

    public static void e(Context context, long j, long j2) {
        try {
            v().schedule(new vp1().g(2, p(context), Long.valueOf(j), Long.valueOf(j2)), 0L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            Q(e);
        }
    }

    public static void e0(File file, byte[] bArr) {
        try {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    j("file create fail", file);
                    Q(e);
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception e2) {
            Q(e2);
        }
    }

    public static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void g(InputStream inputStream, OutputStream outputStream) throws IOException {
        h(inputStream, outputStream, 0, null);
    }

    public static Context getContext() {
        if (f16837a == null) {
            d0(AliyunLogCommon.LogLevel.WARN, "getContext with null");
            k(new IllegalStateException());
        }
        return f16837a;
    }

    public static void h(InputStream inputStream, OutputStream outputStream, int i, g17 g17Var) throws IOException {
        if (g17Var != null) {
            g17Var.e();
            g17Var.f(i);
        }
        byte[] bArr = new byte[4096];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                break;
            }
            outputStream.write(bArr, 0, i2);
            if (g17Var != null) {
                g17Var.d(i2);
            }
        }
        if (g17Var != null) {
            g17Var.b();
        }
    }

    public static void i(Object obj) {
        if (f16844a) {
            Log.w("AQuery", obj + "");
        }
    }

    public static void j(Object obj, Object obj2) {
        if (f16844a) {
            Log.w("AQuery", obj + u15.f19942b + obj2);
        }
    }

    public static void k(Throwable th) {
        if (f16844a) {
            Log.w("AQuery", Log.getStackTraceString(th));
        }
    }

    public static void l() {
        Object obj;
        if (!f16844a || (obj = f16840a) == null) {
            return;
        }
        synchronized (obj) {
            f16840a.notifyAll();
        }
    }

    public static void m(long j) {
        if (f16844a) {
            if (f16840a == null) {
                f16840a = new Object();
            }
            synchronized (f16840a) {
                try {
                    f16840a.wait(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int n(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static void o() {
        if (E()) {
            return;
        }
        Q(new IllegalStateException("Not UI Thread"));
    }

    public static File p(Context context) {
        if (f16839a == null) {
            File file = new File(context.getCacheDir(), "aquery");
            f16839a = file;
            file.mkdirs();
        }
        return f16839a;
    }

    public static File q(Context context, int i) {
        if (i != 1) {
            return p(context);
        }
        File file = b;
        if (file != null) {
            return file;
        }
        File file2 = new File(p(context), "persistent");
        b = file2;
        file2.mkdirs();
        return b;
    }

    public static File r(File file, String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith(File.separator) ? new File(str) : G(file, s(str));
    }

    public static String s(String str) {
        return y(str);
    }

    public static File t(File file, String str) {
        File fileR = r(file, str);
        if (fileR == null || !fileR.exists()) {
            return null;
        }
        return fileR;
    }

    public static File u(File file, String str) {
        File fileT = t(file, str);
        if (fileT != null) {
            F(fileT);
        }
        return fileT;
    }

    public static ScheduledExecutorService v() {
        if (f16843a == null) {
            f16843a = Executors.newSingleThreadScheduledExecutor();
        }
        return f16843a;
    }

    public static Handler w() {
        if (f16838a == null) {
            f16838a = new Handler(Looper.getMainLooper());
        }
        return f16838a;
    }

    public static byte[] x(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            Q(e);
            return null;
        }
    }

    public static String y(String str) {
        return new BigInteger(x(str.getBytes())).abs().toString(36);
    }

    public static File z() {
        File file = new File(Environment.getExternalStorageDirectory(), "aquery/temp");
        file.mkdirs();
        if (file.exists() && file.canWrite()) {
            return file;
        }
        return null;
    }
}
