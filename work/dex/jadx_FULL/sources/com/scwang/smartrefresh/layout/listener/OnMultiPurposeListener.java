package com.scwang.smartrefresh.layout.listener;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public interface OnMultiPurposeListener extends OnRefreshLoadMoreListener, OnStateChangedListener {
    void a(RefreshHeader refreshHeader, boolean z);

    void b(RefreshHeader refreshHeader, boolean z, float f, int i, int i2, int i3);

    void c(RefreshHeader refreshHeader, int i, int i2);

    void d(RefreshFooter refreshFooter, boolean z);

    void e(RefreshHeader refreshHeader, int i, int i2);

    void f(RefreshFooter refreshFooter, int i, int i2);

    void g(RefreshFooter refreshFooter, int i, int i2);

    void h(RefreshFooter refreshFooter, boolean z, float f, int i, int i2, int i3);
}
