package com.igexin.push.core.i.a;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b<T extends Drawable> implements l, m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f38058a;

    public b(T t) {
        this.f38058a = (T) k.a(t);
    }

    @Override // com.igexin.push.core.i.a.m
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T c() {
        Drawable.ConstantState constantState = this.f38058a.getConstantState();
        return constantState == null ? this.f38058a : (T) constantState.newDrawable();
    }

    @Override // com.igexin.push.core.i.a.l
    public void b() {
        T t = this.f38058a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof e) {
            ((e) t).a().prepareToDraw();
        }
    }
}
