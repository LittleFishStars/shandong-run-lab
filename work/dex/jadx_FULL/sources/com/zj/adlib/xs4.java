package com.zj.adlib;

import com.huachenjie.base.view.danmuku.model.painter.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class xs4 extends a {
    @Override // com.huachenjie.base.view.danmuku.model.painter.a
    public void layout(y52 danMuView, t52 danMuChannel) {
        float fB = danMuView.b() * 1.5f;
        if (danMuView.m() >= danMuChannel.f19708a + danMuView.l()) {
            danMuView.t(false);
        } else {
            danMuView.A(danMuView.m() + fB);
        }
    }
}
