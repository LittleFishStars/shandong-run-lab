package com.zj.adlib;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class gx7 implements ScrollBoundaryDecider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f42007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ScrollBoundaryDecider f16902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16903a = true;

    @Override // com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider
    public boolean a(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.f16902a;
        return scrollBoundaryDecider != null ? scrollBoundaryDecider.a(view) : qk8.a(view, this.f42007a, this.f16903a);
    }

    @Override // com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider
    public boolean b(View view) {
        ScrollBoundaryDecider scrollBoundaryDecider = this.f16902a;
        return scrollBoundaryDecider != null ? scrollBoundaryDecider.b(view) : qk8.b(view, this.f42007a);
    }
}
