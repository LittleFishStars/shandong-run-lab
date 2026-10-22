package cn.hzjizhun.admin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RootTouchViewGroup extends RelativeLayout {
    public String akdsd;
    public String ddksa;
    public String dkkd;
    public boolean kdsksdda;

    public RootTouchViewGroup(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.ddksa = getWidth() + "," + getHeight();
            this.dkkd = motionEvent.getRawX() + "," + motionEvent.getRawY();
            this.akdsd = motionEvent.getX() + "," + motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public RootTouchViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RootTouchViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdsksdda = false;
    }
}
