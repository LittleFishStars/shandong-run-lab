package com.alibaba.triver.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f25274a;
    private int b;
    private a c;
    private ViewTreeObserver.OnGlobalLayoutListener d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.alibaba.triver.utils.f.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            f.this.f25274a.getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height();
            System.out.println("" + iHeight);
            if (f.this.b == 0) {
                f.this.b = iHeight;
                return;
            }
            if (f.this.b == iHeight) {
                return;
            }
            if (f.this.b - iHeight > 200) {
                if (f.this.c != null) {
                    f.this.c.a(f.this.b - iHeight);
                }
                f.this.b = iHeight;
            } else if (iHeight - f.this.b > 200) {
                if (f.this.c != null) {
                    f.this.c.b(iHeight - f.this.b);
                }
                f.this.b = iHeight;
            }
        }
    };

    public interface a {
        void a(int i);

        void b(int i);
    }

    public f(Activity activity) {
        this.f25274a = activity.getWindow().getDecorView();
        this.f25274a.getViewTreeObserver().addOnGlobalLayoutListener(this.d);
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a() {
        this.f25274a.getViewTreeObserver().removeOnGlobalLayoutListener(this.d);
        this.d = null;
        this.c = null;
    }
}
