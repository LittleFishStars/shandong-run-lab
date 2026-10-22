package com.fl.saas.base.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SplashContainer extends RelativeLayout {
    private boolean isStand;
    private Context mContext;
    private String standText;

    public SplashContainer(Context context) {
        super(context);
        this.standText = "";
        this.mContext = context;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (DeviceUtil.isViewRange(motionEvent, this, "跳过")) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (this.isStand && !TextUtils.isEmpty(this.standText)) {
                return DeviceUtil.isViewRange(motionEvent, this, this.standText) ? super.onInterceptTouchEvent(motionEvent) : !DeviceUtil.isViewRange(motionEvent, this, this.standText);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Throwable unused) {
        }
    }

    public void setStand(boolean z) {
        this.isStand = this.isStand;
    }

    public void setStandInfo(String str) {
        this.standText = str;
    }
}
