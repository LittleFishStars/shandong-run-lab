package com.byazt.pn;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.byazt.ga.ve;
import com.byazt.kk.a;
import com.byazt.nb.x;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1195, 20})
public class c {
    public ve n;
    public final AssetManager uj;
    public final x<String> c = new x<>();
    public final Map<x<String>, Typeface> tt = new HashMap();
    public final Map<String, Typeface> ve = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28950a = ".ttf";

    public c(Drawable.Callback callback, ve veVar) {
        this.n = veVar;
        if (callback instanceof View) {
            this.uj = ((View) callback).getContext().getAssets();
        } else {
            a.tt("LottieDrawable must be inside of a view for images to work.");
            this.uj = null;
        }
    }

    private Typeface tt(com.byazt.nb.ve veVar) {
        Typeface typefaceCreateFromAsset;
        String strC = veVar.c();
        Typeface typeface = this.ve.get(strC);
        if (typeface != null) {
            return typeface;
        }
        String strVe = veVar.ve();
        String strTt = veVar.tt();
        ve veVar2 = this.n;
        if (veVar2 != null) {
            typefaceCreateFromAsset = veVar2.c(strC, strVe, strTt);
            if (typefaceCreateFromAsset == null) {
                typefaceCreateFromAsset = this.n.c(strC);
            }
        } else {
            typefaceCreateFromAsset = null;
        }
        ve veVar3 = this.n;
        if (veVar3 != null && typefaceCreateFromAsset == null) {
            String strTt2 = veVar3.tt(strC, strVe, strTt);
            if (strTt2 == null) {
                strTt2 = this.n.tt(strC);
            }
            if (strTt2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.uj, strTt2);
                } catch (Throwable unused) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (veVar.uj() != null) {
            return veVar.uj();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.uj, "fonts/" + strC + this.f28950a);
            } catch (Throwable unused2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.ve.put(strC, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    public void c(ve veVar) {
        this.n = veVar;
    }

    public void c(String str) {
        this.f28950a = str;
    }

    public Typeface c(com.byazt.nb.ve veVar) {
        this.c.c(veVar.c(), veVar.ve());
        Typeface typeface = this.tt.get(this.c);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceC = c(tt(veVar), veVar.ve());
        this.tt.put(this.c, typefaceC);
        return typefaceC;
    }

    private Typeface c(Typeface typeface, String str) {
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
