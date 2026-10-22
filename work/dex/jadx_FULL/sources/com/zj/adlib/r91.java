package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.ali.auth.third.login.LoginConstants;
import com.blankj.utilcode.constant.CacheConstants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class r91 implements CacheConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, r91> f44401a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final o91 f19256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z91 f19257a;

    public r91(z91 z91Var, o91 o91Var) {
        this.f19257a = z91Var;
        this.f19256a = o91Var;
    }

    public static r91 k() {
        return l(z91.e(), o91.k());
    }

    public static r91 l(@NonNull z91 z91Var, @NonNull o91 o91Var) {
        String str = o91Var.toString() + LoginConstants.UNDER_LINE + z91Var.toString();
        Map<String, r91> map = f44401a;
        r91 r91Var = map.get(str);
        if (r91Var == null) {
            synchronized (r91.class) {
                r91Var = map.get(str);
                if (r91Var == null) {
                    r91Var = new r91(z91Var, o91Var);
                    map.put(str, r91Var);
                }
            }
        }
        return r91Var;
    }

    public void A(@NonNull String str, Parcelable parcelable) {
        B(str, parcelable, -1);
    }

    public void B(@NonNull String str, Parcelable parcelable, int i) {
        this.f19257a.i(str, parcelable, i);
        this.f19256a.F(str, parcelable, i);
    }

    public void C(@NonNull String str, Serializable serializable) {
        D(str, serializable, -1);
    }

    public void D(@NonNull String str, Serializable serializable, int i) {
        this.f19257a.i(str, serializable, i);
        this.f19256a.H(str, serializable, i);
    }

    public void E(@NonNull String str, String str2) {
        F(str, str2, -1);
    }

    public void F(@NonNull String str, String str2, int i) {
        this.f19257a.i(str, str2, i);
        this.f19256a.J(str, str2, i);
    }

    public void G(@NonNull String str, JSONArray jSONArray) {
        H(str, jSONArray, -1);
    }

    public void H(@NonNull String str, JSONArray jSONArray, int i) {
        this.f19257a.i(str, jSONArray, i);
        this.f19256a.L(str, jSONArray, i);
    }

    public void I(@NonNull String str, JSONObject jSONObject) {
        J(str, jSONObject, -1);
    }

    public void J(@NonNull String str, JSONObject jSONObject, int i) {
        this.f19257a.i(str, jSONObject, i);
        this.f19256a.N(str, jSONObject, i);
    }

    public void K(@NonNull String str, byte[] bArr) {
        L(str, bArr, -1);
    }

    public void L(@NonNull String str, byte[] bArr, int i) {
        this.f19257a.i(str, bArr, i);
        this.f19256a.P(str, bArr, i);
    }

    public void M(@NonNull String str) {
        this.f19257a.j(str);
        this.f19256a.T(str);
    }

    public void a() {
        this.f19257a.a();
        this.f19256a.a();
    }

    public Bitmap b(@NonNull String str) {
        return c(str, null);
    }

    public Bitmap c(@NonNull String str, Bitmap bitmap) {
        Bitmap bitmap2 = (Bitmap) this.f19257a.b(str);
        if (bitmap2 != null) {
            return bitmap2;
        }
        Bitmap bitmapB = this.f19256a.b(str);
        if (bitmapB == null) {
            return bitmap;
        }
        this.f19257a.h(str, bitmapB);
        return bitmapB;
    }

    public byte[] d(@NonNull String str) {
        return e(str, null);
    }

    public byte[] e(@NonNull String str, byte[] bArr) {
        byte[] bArr2 = (byte[]) this.f19257a.b(str);
        if (bArr2 != null) {
            return bArr2;
        }
        byte[] bArrD = this.f19256a.d(str);
        if (bArrD == null) {
            return bArr;
        }
        this.f19257a.h(str, bArrD);
        return bArrD;
    }

    public int f() {
        return this.f19256a.f();
    }

    public long g() {
        return this.f19256a.g();
    }

    public int h() {
        return this.f19257a.d();
    }

    public Drawable i(@NonNull String str) {
        return j(str, null);
    }

    public Drawable j(@NonNull String str, Drawable drawable) {
        Drawable drawable2 = (Drawable) this.f19257a.b(str);
        if (drawable2 != null) {
            return drawable2;
        }
        Drawable drawableI = this.f19256a.i(str);
        if (drawableI == null) {
            return drawable;
        }
        this.f19257a.h(str, drawableI);
        return drawableI;
    }

    public JSONArray m(@NonNull String str) {
        return n(str, null);
    }

    public JSONArray n(@NonNull String str, JSONArray jSONArray) {
        JSONArray jSONArray2 = (JSONArray) this.f19257a.b(str);
        if (jSONArray2 != null) {
            return jSONArray2;
        }
        JSONArray jSONArrayQ = this.f19256a.q(str);
        if (jSONArrayQ == null) {
            return jSONArray;
        }
        this.f19257a.h(str, jSONArrayQ);
        return jSONArrayQ;
    }

    public JSONObject o(@NonNull String str) {
        return p(str, null);
    }

    public JSONObject p(@NonNull String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = (JSONObject) this.f19257a.b(str);
        if (jSONObject2 != null) {
            return jSONObject2;
        }
        JSONObject jSONObjectS = this.f19256a.s(str);
        if (jSONObjectS == null) {
            return jSONObject;
        }
        this.f19257a.h(str, jSONObjectS);
        return jSONObjectS;
    }

    public <T> T q(@NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return (T) r(str, creator, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T> T r(@NonNull String str, @NonNull Parcelable.Creator<T> creator, T t) {
        T t2 = (T) this.f19257a.b(str);
        if (t2 != null) {
            return t2;
        }
        T t3 = (T) this.f19256a.u(str, creator);
        if (t3 == null) {
            return t;
        }
        this.f19257a.h(str, t3);
        return t3;
    }

    public Object s(@NonNull String str) {
        return t(str, null);
    }

    public Object t(@NonNull String str, Object obj) {
        Object objB = this.f19257a.b(str);
        if (objB != null) {
            return objB;
        }
        Object objW = this.f19256a.w(str);
        if (objW == null) {
            return obj;
        }
        this.f19257a.h(str, objW);
        return objW;
    }

    public String u(@NonNull String str) {
        return v(str, null);
    }

    public String v(@NonNull String str, String str2) {
        String str3 = (String) this.f19257a.b(str);
        if (str3 != null) {
            return str3;
        }
        String strY = this.f19256a.y(str);
        if (strY == null) {
            return str2;
        }
        this.f19257a.h(str, strY);
        return strY;
    }

    public void w(@NonNull String str, Bitmap bitmap) {
        x(str, bitmap, -1);
    }

    public void x(@NonNull String str, Bitmap bitmap, int i) {
        this.f19257a.i(str, bitmap, i);
        this.f19256a.B(str, bitmap, i);
    }

    public void y(@NonNull String str, Drawable drawable) {
        z(str, drawable, -1);
    }

    public void z(@NonNull String str, Drawable drawable, int i) {
        this.f19257a.i(str, drawable, i);
        this.f19256a.D(str, drawable, i);
    }
}
