package com.zj.adlib;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class mk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f43320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public lk3 f18233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final gu5<String> f18232a = new gu5<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<gu5<String>, Typeface> f18235a = new HashMap();
    public final Map<String, Typeface> b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18234a = ".ttf";

    public mk3(Drawable.Callback callback, @Nullable lk3 lk3Var) {
        this.f18233a = lk3Var;
        if (callback instanceof View) {
            this.f43320a = ((View) callback).getContext().getAssets();
        } else {
            g25.e("LottieDrawable must be inside of a view for images to work.");
            this.f43320a = null;
        }
    }

    public final Typeface a(String str) {
        String strB;
        Typeface typeface = this.b.get(str);
        if (typeface != null) {
            return typeface;
        }
        lk3 lk3Var = this.f18233a;
        Typeface typefaceA = lk3Var != null ? lk3Var.a(str) : null;
        lk3 lk3Var2 = this.f18233a;
        if (lk3Var2 != null && typefaceA == null && (strB = lk3Var2.b(str)) != null) {
            typefaceA = Typeface.createFromAsset(this.f43320a, strB);
        }
        if (typefaceA == null) {
            typefaceA = Typeface.createFromAsset(this.f43320a, "fonts/" + str + this.f18234a);
        }
        this.b.put(str, typefaceA);
        return typefaceA;
    }

    public Typeface b(String str, String str2) {
        this.f18232a.b(str, str2);
        Typeface typeface = this.f18235a.get(this.f18232a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceE = e(a(str), str2);
        this.f18235a.put(this.f18232a, typefaceE);
        return typefaceE;
    }

    public void c(String str) {
        this.f18234a = str;
    }

    public void d(@Nullable lk3 lk3Var) {
        this.f18233a = lk3Var;
    }

    public final Typeface e(Typeface typeface, String str) {
        int i;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i = 3;
        } else if (zContains) {
            i = 2;
        } else {
            i = zContains2 ? 1 : 0;
        }
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
