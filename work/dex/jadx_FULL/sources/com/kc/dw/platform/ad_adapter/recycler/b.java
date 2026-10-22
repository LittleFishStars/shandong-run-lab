package com.kc.dw.platform.ad_adapter.recycler;

import com.kc.dw.core.ad.IAd;
import com.kc.dw.core.view.TouchPositionListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.sql.Timestamp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {
    public static void a(IAd iAd, float f, float f2, long j, float f3, float f4) {
        if (iAd == null) {
            return;
        }
        try {
            Timestamp timestamp = new Timestamp(j);
            TouchPositionListener.TouchPosition touchPosition = iAd.getTouchData().getTouchPosition();
            if (touchPosition == null) {
                touchPosition = new TouchPositionListener.TouchPosition();
                iAd.getTouchData().setTouchPosition(touchPosition);
            }
            touchPosition.setTouchTime(timestamp);
            touchPosition.setDownX((int) f);
            touchPosition.setDownY((int) f2);
            touchPosition.setDownTime(timestamp);
            int i = (int) f3;
            if (i <= 0) {
                i = Integer.MIN_VALUE;
            }
            touchPosition.setUpX(i);
            int i2 = (int) f4;
            touchPosition.setUpY(i2 > 0 ? i2 : Integer.MIN_VALUE);
            touchPosition.setUpTime(new Timestamp(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
