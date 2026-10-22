package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class n91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static o91 f43475a;

    public static JSONObject A(@NonNull String str, @Nullable JSONObject jSONObject, @NonNull o91 o91Var) {
        return o91Var.t(str, jSONObject);
    }

    public static <T> T B(@NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return (T) C(str, creator, o());
    }

    public static <T> T C(@NonNull String str, @NonNull Parcelable.Creator<T> creator, @NonNull o91 o91Var) {
        return (T) o91Var.u(str, creator);
    }

    public static <T> T D(@NonNull String str, @NonNull Parcelable.Creator<T> creator, @Nullable T t) {
        return (T) E(str, creator, t, o());
    }

    public static <T> T E(@NonNull String str, @NonNull Parcelable.Creator<T> creator, @Nullable T t, @NonNull o91 o91Var) {
        return (T) o91Var.v(str, creator, t);
    }

    public static Object F(@NonNull String str) {
        return G(str, o());
    }

    public static Object G(@NonNull String str, @NonNull o91 o91Var) {
        return o91Var.w(str);
    }

    public static Object H(@NonNull String str, @Nullable Object obj) {
        return I(str, obj, o());
    }

    public static Object I(@NonNull String str, @Nullable Object obj, @NonNull o91 o91Var) {
        return o91Var.x(str, obj);
    }

    public static String J(@NonNull String str) {
        return K(str, o());
    }

    public static String K(@NonNull String str, @NonNull o91 o91Var) {
        return o91Var.y(str);
    }

    public static String L(@NonNull String str, @Nullable String str2) {
        return M(str, str2, o());
    }

    public static String M(@NonNull String str, @Nullable String str2, @NonNull o91 o91Var) {
        return o91Var.z(str, str2);
    }

    public static void N(@NonNull String str, @Nullable Bitmap bitmap) {
        Q(str, bitmap, o());
    }

    public static void O(@NonNull String str, @Nullable Bitmap bitmap, int i) {
        P(str, bitmap, i, o());
    }

    public static void P(@NonNull String str, @Nullable Bitmap bitmap, int i, @NonNull o91 o91Var) {
        o91Var.B(str, bitmap, i);
    }

    public static void Q(@NonNull String str, @Nullable Bitmap bitmap, @NonNull o91 o91Var) {
        o91Var.A(str, bitmap);
    }

    public static void R(@NonNull String str, @Nullable Drawable drawable) {
        U(str, drawable, o());
    }

    public static void S(@NonNull String str, @Nullable Drawable drawable, int i) {
        T(str, drawable, i, o());
    }

    public static void T(@NonNull String str, @Nullable Drawable drawable, int i, @NonNull o91 o91Var) {
        o91Var.D(str, drawable, i);
    }

    public static void U(@NonNull String str, @Nullable Drawable drawable, @NonNull o91 o91Var) {
        o91Var.C(str, drawable);
    }

    public static void V(@NonNull String str, @Nullable Parcelable parcelable) {
        Y(str, parcelable, o());
    }

    public static void W(@NonNull String str, @Nullable Parcelable parcelable, int i) {
        X(str, parcelable, i, o());
    }

    public static void X(@NonNull String str, @Nullable Parcelable parcelable, int i, @NonNull o91 o91Var) {
        o91Var.F(str, parcelable, i);
    }

    public static void Y(@NonNull String str, @Nullable Parcelable parcelable, @NonNull o91 o91Var) {
        o91Var.E(str, parcelable);
    }

    public static void Z(@NonNull String str, @Nullable Serializable serializable) {
        c0(str, serializable, o());
    }

    public static boolean a() {
        return b(o());
    }

    public static void a0(@NonNull String str, @Nullable Serializable serializable, int i) {
        b0(str, serializable, i, o());
    }

    public static boolean b(@NonNull o91 o91Var) {
        return o91Var.a();
    }

    public static void b0(@NonNull String str, @Nullable Serializable serializable, int i, @NonNull o91 o91Var) {
        o91Var.H(str, serializable, i);
    }

    public static Bitmap c(@NonNull String str) {
        return f(str, o());
    }

    public static void c0(@NonNull String str, @Nullable Serializable serializable, @NonNull o91 o91Var) {
        o91Var.G(str, serializable);
    }

    public static Bitmap d(@NonNull String str, @Nullable Bitmap bitmap) {
        return e(str, bitmap, o());
    }

    public static void d0(@NonNull String str, @Nullable String str2) {
        g0(str, str2, o());
    }

    public static Bitmap e(@NonNull String str, @Nullable Bitmap bitmap, @NonNull o91 o91Var) {
        return o91Var.c(str, bitmap);
    }

    public static void e0(@NonNull String str, @Nullable String str2, int i) {
        f0(str, str2, i, o());
    }

    public static Bitmap f(@NonNull String str, @NonNull o91 o91Var) {
        return o91Var.b(str);
    }

    public static void f0(@NonNull String str, @Nullable String str2, int i, @NonNull o91 o91Var) {
        o91Var.J(str, str2, i);
    }

    public static byte[] g(@NonNull String str) {
        return h(str, o());
    }

    public static void g0(@NonNull String str, @Nullable String str2, @NonNull o91 o91Var) {
        o91Var.I(str, str2);
    }

    public static byte[] h(@NonNull String str, @NonNull o91 o91Var) {
        return o91Var.d(str);
    }

    public static void h0(@NonNull String str, @Nullable JSONArray jSONArray) {
        k0(str, jSONArray, o());
    }

    public static byte[] i(@NonNull String str, @Nullable byte[] bArr) {
        return j(str, bArr, o());
    }

    public static void i0(@NonNull String str, @Nullable JSONArray jSONArray, int i) {
        j0(str, jSONArray, i, o());
    }

    public static byte[] j(@NonNull String str, @Nullable byte[] bArr, @NonNull o91 o91Var) {
        return o91Var.e(str, bArr);
    }

    public static void j0(@NonNull String str, @Nullable JSONArray jSONArray, int i, @NonNull o91 o91Var) {
        o91Var.L(str, jSONArray, i);
    }

    public static int k() {
        return l(o());
    }

    public static void k0(@NonNull String str, @Nullable JSONArray jSONArray, @NonNull o91 o91Var) {
        o91Var.K(str, jSONArray);
    }

    public static int l(@NonNull o91 o91Var) {
        return o91Var.f();
    }

    public static void l0(@NonNull String str, @Nullable JSONObject jSONObject) {
        o0(str, jSONObject, o());
    }

    public static long m() {
        return n(o());
    }

    public static void m0(@NonNull String str, @Nullable JSONObject jSONObject, int i) {
        n0(str, jSONObject, i, o());
    }

    public static long n(@NonNull o91 o91Var) {
        return o91Var.g();
    }

    public static void n0(@NonNull String str, @Nullable JSONObject jSONObject, int i, @NonNull o91 o91Var) {
        o91Var.N(str, jSONObject, i);
    }

    @NonNull
    public static o91 o() {
        o91 o91Var = f43475a;
        return o91Var != null ? o91Var : o91.k();
    }

    public static void o0(@NonNull String str, @Nullable JSONObject jSONObject, @NonNull o91 o91Var) {
        o91Var.M(str, jSONObject);
    }

    public static Drawable p(@NonNull String str) {
        return s(str, o());
    }

    public static void p0(@NonNull String str, @Nullable byte[] bArr) {
        s0(str, bArr, o());
    }

    public static Drawable q(@NonNull String str, @Nullable Drawable drawable) {
        return r(str, drawable, o());
    }

    public static void q0(@NonNull String str, @Nullable byte[] bArr, int i) {
        r0(str, bArr, i, o());
    }

    public static Drawable r(@NonNull String str, @Nullable Drawable drawable, @NonNull o91 o91Var) {
        return o91Var.j(str, drawable);
    }

    public static void r0(@NonNull String str, @Nullable byte[] bArr, int i, @NonNull o91 o91Var) {
        o91Var.P(str, bArr, i);
    }

    public static Drawable s(@NonNull String str, @NonNull o91 o91Var) {
        return o91Var.i(str);
    }

    public static void s0(@NonNull String str, @Nullable byte[] bArr, @NonNull o91 o91Var) {
        o91Var.O(str, bArr);
    }

    public static JSONArray t(@NonNull String str) {
        return u(str, o());
    }

    public static boolean t0(@NonNull String str) {
        return u0(str, o());
    }

    public static JSONArray u(@NonNull String str, @NonNull o91 o91Var) {
        return o91Var.q(str);
    }

    public static boolean u0(@NonNull String str, @NonNull o91 o91Var) {
        return o91Var.T(str);
    }

    public static JSONArray v(@NonNull String str, @Nullable JSONArray jSONArray) {
        return w(str, jSONArray, o());
    }

    public static void v0(@Nullable o91 o91Var) {
        f43475a = o91Var;
    }

    public static JSONArray w(@NonNull String str, @Nullable JSONArray jSONArray, @NonNull o91 o91Var) {
        return o91Var.r(str, jSONArray);
    }

    public static JSONObject x(@NonNull String str) {
        return y(str, o());
    }

    public static JSONObject y(@NonNull String str, @NonNull o91 o91Var) {
        return o91Var.s(str);
    }

    public static JSONObject z(@NonNull String str, @Nullable JSONObject jSONObject) {
        return A(str, jSONObject, o());
    }
}
