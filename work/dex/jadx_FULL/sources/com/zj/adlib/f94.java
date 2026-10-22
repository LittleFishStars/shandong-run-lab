package com.zj.adlib;

import com.contrarywind.view.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f94 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f41624a = 2.1474836E9f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WheelView f16488a;
    public final float b;

    public f94(WheelView wheelView, float f) {
        this.f16488a = wheelView;
        this.b = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f41624a == 2.1474836E9f) {
            if (Math.abs(this.b) > 2000.0f) {
                this.f41624a = this.b <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.f41624a = this.b;
            }
        }
        if (Math.abs(this.f41624a) >= 0.0f && Math.abs(this.f41624a) <= 20.0f) {
            this.f16488a.cancelFuture();
            this.f16488a.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.f41624a / 100.0f);
        WheelView wheelView = this.f16488a;
        float f = i;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f);
        if (!this.f16488a.isLoop()) {
            float itemHeight = this.f16488a.getItemHeight();
            float totalScrollY = (-this.f16488a.getInitPosition()) * itemHeight;
            float itemsCount = ((this.f16488a.getItemsCount() - 1) - this.f16488a.getInitPosition()) * itemHeight;
            double d = ((double) itemHeight) * 0.25d;
            if (((double) this.f16488a.getTotalScrollY()) - d < totalScrollY) {
                totalScrollY = this.f16488a.getTotalScrollY() + f;
            } else if (((double) this.f16488a.getTotalScrollY()) + d > itemsCount) {
                itemsCount = this.f16488a.getTotalScrollY() + f;
            }
            if (this.f16488a.getTotalScrollY() <= totalScrollY) {
                this.f41624a = 40.0f;
                this.f16488a.setTotalScrollY((int) totalScrollY);
            } else if (this.f16488a.getTotalScrollY() >= itemsCount) {
                this.f16488a.setTotalScrollY((int) itemsCount);
                this.f41624a = -40.0f;
            }
        }
        float f2 = this.f41624a;
        if (f2 < 0.0f) {
            this.f41624a = f2 + 20.0f;
        } else {
            this.f41624a = f2 - 20.0f;
        }
        this.f16488a.getHandler().sendEmptyMessage(1000);
    }
}
