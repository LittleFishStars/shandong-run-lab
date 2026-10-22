package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.zj.adlib.ax6;
import com.zj.adlib.ft3;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SimpleDraweeView extends GenericDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Supplier<? extends SimpleDraweeControllerBuilder> f29979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SimpleDraweeControllerBuilder f1633a;

    public SimpleDraweeView(Context context, ft3 ft3Var) {
        super(context, ft3Var);
        b();
    }

    public static void initialize(Supplier<? extends SimpleDraweeControllerBuilder> supplier) {
        f29979a = supplier;
    }

    public static void shutDown() {
        f29979a = null;
    }

    public final void b() {
        if (isInEditMode()) {
            return;
        }
        ax6.j(f29979a, "SimpleDraweeView was not initialized!");
        this.f1633a = f29979a.get();
    }

    public SimpleDraweeControllerBuilder getControllerBuilder() {
        return this.f1633a;
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        setImageURI(uri, null);
    }

    public void setImageURI(Uri uri, @Nullable Object obj) {
        setController(this.f1633a.a(obj).c(uri).b(getController()).d());
    }

    public SimpleDraweeView(Context context) {
        super(context);
        b();
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    @TargetApi(21)
    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b();
    }
}
