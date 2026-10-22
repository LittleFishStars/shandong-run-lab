package com.huachenjie.base.view.danmuku.view;

import com.zj.adlib.y52;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface IDanMuParent {
    void add(int index, y52 danMuView);

    void add(y52 danMuView);

    void addAllTouchListener(List<y52> onDanMuTouchCallBackListeners);

    void clear();

    void forceSleep();

    void forceWake();

    boolean hasCanTouchDanMus();

    void hideAllDanMuView(boolean hideAll);

    void hideNormalDanMuView(boolean hide);

    void jumpQueue(List<y52> danMuViews);

    void lockDraw();

    void release();

    void remove(y52 danMuView);
}
