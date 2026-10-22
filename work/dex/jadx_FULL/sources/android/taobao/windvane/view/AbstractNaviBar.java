package android.taobao.windvane.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class AbstractNaviBar extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21242a = 110;

    public AbstractNaviBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public AbstractNaviBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbstractNaviBar(Context context) {
        super(context);
    }
}
