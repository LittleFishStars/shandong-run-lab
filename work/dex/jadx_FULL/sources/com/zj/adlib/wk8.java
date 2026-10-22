package com.zj.adlib;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class wk8 extends TimerTask {
    public int K = Integer.MAX_VALUE;
    public int L = 0;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f45617a;

    public wk8(WheelView wheelView, int i) {
        this.f45617a = wheelView;
        this.M = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.K == Integer.MAX_VALUE) {
            this.K = this.M;
        }
        int i = this.K;
        int i2 = (int) (i * 0.1f);
        this.L = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.L = -1;
            } else {
                this.L = 1;
            }
        }
        if (Math.abs(i) <= 1) {
            this.f45617a.cancelFuture();
            this.f45617a.getHandler().sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f45617a;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.L);
        if (!this.f45617a.isLoop()) {
            float itemHeight = this.f45617a.getItemHeight();
            float f = (-this.f45617a.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f45617a.getItemsCount() - 1) - this.f45617a.getInitPosition()) * itemHeight;
            if (this.f45617a.getTotalScrollY() <= f || this.f45617a.getTotalScrollY() >= itemsCount) {
                WheelView wheelView2 = this.f45617a;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.L);
                this.f45617a.cancelFuture();
                this.f45617a.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.f45617a.getHandler().sendEmptyMessage(1000);
        this.K -= this.L;
    }
}
