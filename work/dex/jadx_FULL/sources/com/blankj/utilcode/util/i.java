package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.hjq.permissions.Permission;
import com.zj.adlib.bp4;
import com.zj.adlib.dr7;
import com.zj.adlib.ds9;
import com.zj.adlib.fx7;
import com.zj.adlib.h69;
import com.zj.adlib.i33;
import com.zj.adlib.k68;
import com.zj.adlib.m13;
import com.zj.adlib.nt7;
import com.zj.adlib.p07;
import com.zj.adlib.qv1;
import com.zj.adlib.t72;
import com.zj.adlib.uh9;
import com.zj.adlib.uz;
import com.zj.adlib.v79;
import com.zj.adlib.vw3;
import com.zj.adlib.wc4;
import com.zj.adlib.wl0;
import com.zj.adlib.ys8;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f28236a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LinkedHashMap<String, String> f1463a = new LinkedHashMap<>();
        public LinkedHashMap<String, String> b = new LinkedHashMap<>();

        public a(String str) {
            this.f28236a = str;
        }

        public void a(String str, String str2) {
            d(this.f1463a, str, str2);
        }

        public void b(String str, String str2) {
            d(this.b, str, str2);
        }

        public void c(Map<String, String> map) {
            e(this.b, map);
        }

        public final void d(Map<String, String> map, String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            int length = 19 - str.length();
            if (length > 0) {
                str = str + "                   ".substring(0, length);
            }
            map.put(str, str2);
        }

        public final void e(Map<String, String> map, Map<String, String> map2) {
            if (map2 == null || map2.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                d(map, entry.getKey(), entry.getValue());
            }
        }

        public String f() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : this.b.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\n");
            }
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = "************* " + this.f28236a + " Head ****************\n";
            sb.append(str);
            for (Map.Entry<String, String> entry : this.f1463a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(": ");
                sb.append(entry.getValue());
                sb.append("\n");
            }
            sb.append("Rom Info           : ");
            sb.append(e.c());
            sb.append("\n");
            sb.append("Device Manufacturer: ");
            sb.append(Build.MANUFACTURER);
            sb.append("\n");
            sb.append("Device Model       : ");
            sb.append(Build.MODEL);
            sb.append("\n");
            sb.append("Android Version    : ");
            sb.append(Build.VERSION.RELEASE);
            sb.append("\n");
            sb.append("Android SDK        : ");
            sb.append(Build.VERSION.SDK_INT);
            sb.append("\n");
            sb.append("App VersionName    : ");
            sb.append(b.C());
            sb.append("\n");
            sb.append("App VersionCode    : ");
            sb.append(b.A());
            sb.append("\n");
            sb.append(f());
            sb.append(str);
            sb.append("\n");
            return sb.toString();
        }
    }

    public static g.b A(String str, boolean z) {
        return g.c(str, z);
    }

    public static boolean A0() {
        return e.x();
    }

    public static Uri B(File file) {
        return uh9.b(file);
    }

    public static boolean B0(String str) {
        return k68.c(str);
    }

    public static void C() {
        com.blankj.utilcode.util.a.i();
    }

    public static boolean C0(String str) {
        return ys8.i(str);
    }

    public static void D(Activity activity) {
        KeyboardUtils.f(activity);
    }

    public static boolean D0(@NonNull View view, long j) {
        return t72.c(view, j);
    }

    public static String E(@Nullable String str, Object... objArr) {
        return ys8.c(str, objArr);
    }

    public static byte[] E0(JSONArray jSONArray) {
        return qv1.K(jSONArray);
    }

    public static String F(String str) {
        return bp4.a(str);
    }

    public static byte[] F0(JSONObject jSONObject) {
        return qv1.L(jSONObject);
    }

    public static <T> T G(String str, Type type) {
        return (T) vw3.i(str, type);
    }

    public static View G0(@LayoutRes int i) {
        return ds9.c(i);
    }

    public static Activity H(Context context) {
        return com.blankj.utilcode.util.a.x(context);
    }

    public static String H0(long j, int i) {
        return v79.O0(j, i);
    }

    public static List<Activity> I() {
        return h.f1451a.j();
    }

    public static void I0(File file) {
        FileUtils.H0(file);
    }

    public static int J() {
        return fx7.e();
    }

    public static byte[] J0(Parcelable parcelable) {
        return qv1.S(parcelable);
    }

    public static Application K() {
        return h.f1451a.n();
    }

    public static void K0() {
        L0(uz.k());
    }

    @RequiresPermission(Permission.CALL_PHONE)
    public static Intent L(String str) {
        return wc4.a(str);
    }

    public static void L0(Runnable... runnableArr) {
        for (Runnable runnable : runnableArr) {
            ThreadUtils.d0().execute(runnable);
        }
    }

    public static String M() {
        return p07.b();
    }

    public static int M0(float f) {
        return SizeUtils.g(f);
    }

    public static Intent N(String str) {
        return wc4.h(str);
    }

    public static int N0(float f) {
        return SizeUtils.h(f);
    }

    public static File O(String str) {
        return FileUtils.A(str);
    }

    public static byte[] O0(File file) {
        return FileIOUtils.a(file);
    }

    public static String P() {
        return p07.f();
    }

    public static void P0() {
        b.X();
    }

    public static long Q(String str) {
        return FileUtils.U(str);
    }

    public static void Q0(Activity activity) {
        h.f1451a.t(activity);
    }

    public static long R(String str) {
        return FileUtils.V(str);
    }

    public static void R0(Activity activity, Utils.a aVar) {
        h.f1451a.u(activity, aVar);
    }

    public static String S(Throwable th) {
        return h69.a(th);
    }

    public static void S0(Utils.a aVar) {
        h.f1451a.v(aVar);
    }

    public static Gson T() {
        return vw3.m();
    }

    public static void T0(Runnable runnable) {
        ThreadUtils.s0(runnable);
    }

    public static Intent U(Uri uri) {
        return wc4.i(uri);
    }

    public static void U0(Runnable runnable, long j) {
        ThreadUtils.t0(runnable, j);
    }

    public static Intent V(File file) {
        return wc4.j(file);
    }

    public static byte[] V0(Serializable serializable) {
        return qv1.V(serializable);
    }

    public static Intent W(String str, boolean z) {
        return wc4.n(str, z);
    }

    public static int W0(float f) {
        return SizeUtils.i(f);
    }

    public static Intent X(String str) {
        return wc4.o(str);
    }

    public static void X0() {
        com.blankj.utilcode.util.a.h0();
    }

    public static String Y(String str) {
        return com.blankj.utilcode.util.a.I(str);
    }

    public static byte[] Y0(String str) {
        return qv1.X(str);
    }

    public static int Z() {
        return wl0.i();
    }

    public static String Z0(Object obj) {
        return vw3.u(obj);
    }

    public static void a(Activity activity, Utils.a aVar) {
        h.f1451a.d(activity, aVar);
    }

    public static Notification a0(NotificationUtils.a aVar, Utils.Consumer<NotificationCompat.Builder> consumer) {
        return NotificationUtils.e(aVar, consumer);
    }

    public static void a1() {
        ToastUtils.l();
    }

    public static void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        h.f1451a.addOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    public static void b(Utils.a aVar) {
        h.f1451a.e(aVar);
    }

    public static Intent b0(String str, String str2) {
        return wc4.p(str, str2);
    }

    public static void b1(CharSequence charSequence) {
        ToastUtils.V(charSequence);
    }

    public static byte[] c(byte[] bArr) {
        return m13.b(bArr);
    }

    public static nt7 c0() {
        return nt7.k("Utils");
    }

    public static void c1(Application application) {
        h.f1451a.z(application);
    }

    public static byte[] d(byte[] bArr) {
        return m13.d(bArr);
    }

    public static int d0() {
        return wl0.k();
    }

    public static File d1(Uri uri, Context context) {
        return uh9.f(context, uri);
    }

    public static byte[] e(Bitmap bitmap) {
        return ImageUtils.o(bitmap);
    }

    public static String e0(@StringRes int i) {
        return ys8.e(i);
    }

    public static Bitmap e1(View view) {
        return ImageUtils.i1(view);
    }

    public static byte[] f(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        return ImageUtils.p(bitmap, compressFormat, i);
    }

    public static String f0(@StringRes int i, Object... objArr) {
        return ys8.f(i, objArr);
    }

    public static boolean f1(File file, byte[] bArr) {
        return FileIOUtils.v(file, bArr, true);
    }

    public static Drawable g(Bitmap bitmap) {
        return ImageUtils.q(bitmap);
    }

    public static Activity g0() {
        return h.f1451a.o();
    }

    public static boolean g1(String str, InputStream inputStream) {
        return FileIOUtils.P(str, inputStream);
    }

    public static String h(long j) {
        return qv1.e(j);
    }

    public static Intent h0(String str) {
        return wc4.E(str);
    }

    public static boolean h1(String str, String str2, boolean z) {
        return FileIOUtils.W(str, str2, z);
    }

    public static Bitmap i(byte[] bArr) {
        return ImageUtils.r(bArr);
    }

    public static byte[] i0(byte[] bArr, String str) {
        return i33.r0(bArr, str);
    }

    public static Drawable j(byte[] bArr) {
        return ImageUtils.s(bArr);
    }

    public static byte[] j0(String str) {
        return qv1.C(str);
    }

    public static String k(byte[] bArr) {
        return qv1.l(bArr);
    }

    public static void k0(Application application) {
        h.f1451a.p(application);
    }

    public static JSONArray l(byte[] bArr) {
        return qv1.o(bArr);
    }

    public static ByteArrayOutputStream l0(InputStream inputStream) {
        return qv1.E(inputStream);
    }

    public static JSONObject m(byte[] bArr) {
        return qv1.p(bArr);
    }

    public static byte[] m0(InputStream inputStream) {
        return qv1.F(inputStream);
    }

    public static Object n(byte[] bArr) {
        return qv1.q(bArr);
    }

    public static List<String> n0(InputStream inputStream, String str) {
        return qv1.H(inputStream, str);
    }

    public static <T> T o(byte[] bArr, Parcelable.Creator<T> creator) {
        return (T) qv1.s(bArr, creator);
    }

    public static boolean o0(Activity activity) {
        return com.blankj.utilcode.util.a.R(activity);
    }

    public static String p(byte[] bArr) {
        return qv1.t(bArr);
    }

    public static boolean p0() {
        return b.J();
    }

    public static boolean q(File file) {
        return FileUtils.i(file);
    }

    public static boolean q0() {
        return h.f1451a.q();
    }

    public static boolean r(File file) {
        return FileUtils.k(file);
    }

    public static boolean r0(String str) {
        return b.N(str);
    }

    public static void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        h.f1451a.removeOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    public static boolean s(File file) {
        return FileUtils.m(file);
    }

    public static boolean s0(@NonNull String str) {
        return b.P(str);
    }

    public static boolean t(File file) {
        return FileUtils.o(file);
    }

    public static boolean t0(File file) {
        return FileUtils.e0(file);
    }

    public static <T> Utils.Task<T> u(Utils.Task<T> task) {
        ThreadUtils.d0().execute(task);
        return task;
    }

    public static boolean u0(String... strArr) {
        return PermissionUtils.z(strArr);
    }

    public static int v(float f) {
        return SizeUtils.b(f);
    }

    @RequiresApi(api = 23)
    public static boolean v0() {
        return PermissionUtils.A();
    }

    public static Bitmap w(Drawable drawable) {
        return ImageUtils.K(drawable);
    }

    public static boolean w0(Intent intent) {
        return wc4.F(intent);
    }

    public static byte[] x(Drawable drawable) {
        return ImageUtils.L(drawable);
    }

    public static boolean x0() {
        return ds9.b();
    }

    public static byte[] y(Drawable drawable, Bitmap.CompressFormat compressFormat, int i) {
        return ImageUtils.M(drawable, compressFormat, i);
    }

    public static boolean y0() {
        return p07.g();
    }

    public static boolean z(CharSequence charSequence, CharSequence charSequence2) {
        return ys8.a(charSequence, charSequence2);
    }

    public static boolean z0() {
        return dr7.h();
    }
}
