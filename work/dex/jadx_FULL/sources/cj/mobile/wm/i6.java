package cj.mobile.wm;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class i6<T extends Drawable> implements n3<T> {
    public final T dexa;

    public i6(T t) {
        if (t == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.dexa = t;
    }

    @Override // cj.mobile.wm.n3
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public final T get() {
        return (T) this.dexa.getConstantState().newDrawable();
    }
}
