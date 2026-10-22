package com.zj.adlib;

import android.os.Handler;
import android.os.Message;
import com.contrarywind.view.WheelView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hm5 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42157a = 1000;
    public static final int b = 2000;
    public static final int c = 3000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WheelView f17024a;

    public hm5(WheelView wheelView) {
        this.f17024a = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f17024a.invalidate();
        } else if (i == 2000) {
            this.f17024a.smoothScroll(WheelView.ACTION.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.f17024a.onItemSelected();
        }
    }
}
