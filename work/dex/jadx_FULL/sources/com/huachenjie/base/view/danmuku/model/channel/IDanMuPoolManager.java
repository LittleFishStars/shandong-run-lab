package com.huachenjie.base.view.danmuku.model.channel;

import com.huachenjie.base.view.danmuku.control.dispatcher.IDanMuDispatcher;
import com.huachenjie.base.view.danmuku.control.speed.SpeedController;
import com.zj.adlib.y52;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
interface IDanMuPoolManager {
    void a(boolean hideAll);

    void b(boolean hide);

    void c();

    void d(SpeedController speedController);

    void e(int width, int height);

    void f(int index, y52 iDanMuView);

    void g(IDanMuDispatcher iDanMuDispatcher);

    void jumpQueue(List<y52> danMuViews);
}
