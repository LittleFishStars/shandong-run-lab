package com.kwad.components.core.t;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.KeyEvent;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class m {
    public static void a(com.kwad.components.core.widget.e eVar, ViewGroup viewGroup) {
        if (eVar == null || viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            KeyEvent.Callback childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.d) {
                ((com.kwad.components.core.widget.d) childAt).a(eVar);
            } else if (childAt instanceof ViewGroup) {
                a(eVar, (ViewGroup) childAt);
            }
        }
    }

    public static void b(com.kwad.components.core.widget.e eVar, Drawable drawable) {
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(eVar.zX());
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(eVar.zX());
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(eVar.zX());
        }
    }
}
