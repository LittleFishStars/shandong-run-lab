package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class q91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static r91 f44155a;

    public static JSONObject A(@NonNull String str, @NonNull r91 r91Var) {
        return r91Var.o(str);
    }

    public static JSONObject B(@NonNull String str, JSONObject jSONObject) {
        return C(str, jSONObject, q());
    }

    public static JSONObject C(@NonNull String str, JSONObject jSONObject, @NonNull r91 r91Var) {
        return r91Var.p(str, jSONObject);
    }

    public static <T> T D(@NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return (T) E(str, creator, q());
    }

    public static <T> T E(@NonNull String str, @NonNull Parcelable.Creator<T> creator, @NonNull r91 r91Var) {
        return (T) r91Var.q(str, creator);
    }

    public static <T> T F(@NonNull String str, @NonNull Parcelable.Creator<T> creator, T t) {
        return (T) G(str, creator, t, q());
    }

    public static <T> T G(@NonNull String str, @NonNull Parcelable.Creator<T> creator, T t, @NonNull r91 r91Var) {
        return (T) r91Var.r(str, creator, t);
    }

    public static Object H(@NonNull String str) {
        return I(str, q());
    }

    public static Object I(@NonNull String str, @NonNull r91 r91Var) {
        return r91Var.s(str);
    }

    public static Object J(@NonNull String str, Object obj) {
        return K(str, obj, q());
    }

    public static Object K(@NonNull String str, Object obj, @NonNull r91 r91Var) {
        return r91Var.t(str, obj);
    }

    public static String L(@NonNull String str) {
        return M(str, q());
    }

    public static String M(@NonNull String str, @NonNull r91 r91Var) {
        return r91Var.u(str);
    }

    public static String N(@NonNull String str, String str2) {
        return O(str, str2, q());
    }

    public static String O(@NonNull String str, String str2, @NonNull r91 r91Var) {
        return r91Var.v(str, str2);
    }

    public static void P(@NonNull String str, Bitmap bitmap) {
        S(str, bitmap, q());
    }

    public static void Q(@NonNull String str, Bitmap bitmap, int i) {
        R(str, bitmap, i, q());
    }

    public static void R(@NonNull String str, Bitmap bitmap, int i, @NonNull r91 r91Var) {
        r91Var.x(str, bitmap, i);
    }

    public static void S(@NonNull String str, Bitmap bitmap, @NonNull r91 r91Var) {
        r91Var.w(str, bitmap);
    }

    public static void T(@NonNull String str, Drawable drawable) {
        W(str, drawable, q());
    }

    public static void U(@NonNull String str, Drawable drawable, int i) {
        V(str, drawable, i, q());
    }

    public static void V(@NonNull String str, Drawable drawable, int i, @NonNull r91 r91Var) {
        r91Var.z(str, drawable, i);
    }

    public static void W(@NonNull String str, Drawable drawable, @NonNull r91 r91Var) {
        r91Var.y(str, drawable);
    }

    public static void X(@NonNull String str, Parcelable parcelable) {
        a0(str, parcelable, q());
    }

    public static void Y(@NonNull String str, Parcelable parcelable, int i) {
        Z(str, parcelable, i, q());
    }

    public static void Z(@NonNull String str, Parcelable parcelable, int i, @NonNull r91 r91Var) {
        r91Var.B(str, parcelable, i);
    }

    public static void a() {
        b(q());
    }

    public static void a0(@NonNull String str, Parcelable parcelable, @NonNull r91 r91Var) {
        r91Var.A(str, parcelable);
    }

    public static void b(@NonNull r91 r91Var) {
        r91Var.a();
    }

    public static void b0(@NonNull String str, Serializable serializable) {
        e0(str, serializable, q());
    }

    public static Bitmap c(@NonNull String str) {
        return f(str, q());
    }

    public static void c0(@NonNull String str, Serializable serializable, int i) {
        d0(str, serializable, i, q());
    }

    public static Bitmap d(@NonNull String str, Bitmap bitmap) {
        return e(str, bitmap, q());
    }

    public static void d0(@NonNull String str, Serializable serializable, int i, @NonNull r91 r91Var) {
        r91Var.D(str, serializable, i);
    }

    public static Bitmap e(@NonNull String str, Bitmap bitmap, @NonNull r91 r91Var) {
        return r91Var.c(str, bitmap);
    }

    public static void e0(@NonNull String str, Serializable serializable, @NonNull r91 r91Var) {
        r91Var.C(str, serializable);
    }

    public static Bitmap f(@NonNull String str, @NonNull r91 r91Var) {
        return r91Var.b(str);
    }

    public static void f0(@NonNull String str, String str2) {
        i0(str, str2, q());
    }

    public static byte[] g(@NonNull String str) {
        return h(str, q());
    }

    public static void g0(@NonNull String str, String str2, int i) {
        h0(str, str2, i, q());
    }

    public static byte[] h(@NonNull String str, @NonNull r91 r91Var) {
        return r91Var.d(str);
    }

    public static void h0(@NonNull String str, String str2, int i, @NonNull r91 r91Var) {
        r91Var.F(str, str2, i);
    }

    public static byte[] i(@NonNull String str, byte[] bArr) {
        return j(str, bArr, q());
    }

    public static void i0(@NonNull String str, String str2, @NonNull r91 r91Var) {
        r91Var.E(str, str2);
    }

    public static byte[] j(@NonNull String str, byte[] bArr, @NonNull r91 r91Var) {
        return r91Var.e(str, bArr);
    }

    public static void j0(@NonNull String str, JSONArray jSONArray) {
        m0(str, jSONArray, q());
    }

    public static int k() {
        return l(q());
    }

    public static void k0(@NonNull String str, JSONArray jSONArray, int i) {
        l0(str, jSONArray, i, q());
    }

    public static int l(@NonNull r91 r91Var) {
        return r91Var.f();
    }

    public static void l0(@NonNull String str, JSONArray jSONArray, int i, @NonNull r91 r91Var) {
        r91Var.H(str, jSONArray, i);
    }

    public static long m() {
        return n(q());
    }

    public static void m0(@NonNull String str, JSONArray jSONArray, @NonNull r91 r91Var) {
        r91Var.G(str, jSONArray);
    }

    public static long n(@NonNull r91 r91Var) {
        return r91Var.g();
    }

    public static void n0(@NonNull String str, JSONObject jSONObject) {
        q0(str, jSONObject, q());
    }

    public static int o() {
        return p(q());
    }

    public static void o0(@NonNull String str, JSONObject jSONObject, int i) {
        p0(str, jSONObject, i, q());
    }

    public static int p(@NonNull r91 r91Var) {
        return r91Var.h();
    }

    public static void p0(@NonNull String str, JSONObject jSONObject, int i, @NonNull r91 r91Var) {
        r91Var.J(str, jSONObject, i);
    }

    public static r91 q() {
        r91 r91Var = f44155a;
        return r91Var != null ? r91Var : r91.k();
    }

    public static void q0(@NonNull String str, JSONObject jSONObject, @NonNull r91 r91Var) {
        r91Var.I(str, jSONObject);
    }

    public static Drawable r(@NonNull String str) {
        return u(str, q());
    }

    public static void r0(@NonNull String str, byte[] bArr) {
        u0(str, bArr, q());
    }

    public static Drawable s(@NonNull String str, Drawable drawable) {
        return t(str, drawable, q());
    }

    public static void s0(@NonNull String str, byte[] bArr, int i) {
        t0(str, bArr, i, q());
    }

    public static Drawable t(@NonNull String str, Drawable drawable, @NonNull r91 r91Var) {
        return r91Var.j(str, drawable);
    }

    public static void t0(@NonNull String str, byte[] bArr, int i, @NonNull r91 r91Var) {
        r91Var.L(str, bArr, i);
    }

    public static Drawable u(@NonNull String str, @NonNull r91 r91Var) {
        return r91Var.i(str);
    }

    public static void u0(@NonNull String str, byte[] bArr, @NonNull r91 r91Var) {
        r91Var.K(str, bArr);
    }

    public static JSONArray v(@NonNull String str) {
        return w(str, q());
    }

    public static void v0(@NonNull String str) {
        w0(str, q());
    }

    public static JSONArray w(@NonNull String str, @NonNull r91 r91Var) {
        return r91Var.m(str);
    }

    public static void w0(@NonNull String str, @NonNull r91 r91Var) {
        r91Var.M(str);
    }

    public static JSONArray x(@NonNull String str, JSONArray jSONArray) {
        return y(str, jSONArray, q());
    }

    public static void x0(r91 r91Var) {
        f44155a = r91Var;
    }

    public static JSONArray y(@NonNull String str, JSONArray jSONArray, @NonNull r91 r91Var) {
        return r91Var.n(str, jSONArray);
    }

    public static JSONObject z(@NonNull String str) {
        return A(str, q());
    }
}
