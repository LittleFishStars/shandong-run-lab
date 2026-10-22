package cj.mobile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import cj.mobile.t.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class ScrollWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f22669a;

    public ScrollWebView(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void setScrollListener(a aVar) {
        this.f22669a = aVar;
    }

    public ScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ScrollWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
