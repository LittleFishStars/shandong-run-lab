package com.acse.ottn;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t2 extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f23266a;

    public interface a {
        void a(int i);
    }

    public t2(Context context) {
        super(context);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        a aVar = this.f23266a;
        if (aVar != null) {
            aVar.a(getScrollY());
        }
    }

    public void setOnScrollListener(a aVar) {
        this.f23266a = aVar;
    }

    public t2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public t2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
