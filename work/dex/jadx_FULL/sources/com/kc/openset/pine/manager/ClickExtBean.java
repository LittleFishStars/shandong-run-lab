package com.kc.openset.pine.manager;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ClickExtBean {
    private BtnLocation btnLocation;
    private int btnType;
    private ChangeDownPoint changeDownPoint;
    private ChangeUpPoint changeUpPoint;
    private OriginalDownPoint originalDownPoint;
    private OriginalUpPoint originalUpPoint;
    private ScreenSize screenSize;
    private int showTime;

    @Keep
    public static class BtnLocation {
        private float bottom;
        private float left;
        private float right;
        private float top;

        static {
            OSETSDKProtected.interface11(4590);
        }

        public native float getBottom();

        public native float getLeft();

        public native float getRight();

        public native float getTop();

        public native void setBottom(float f);

        public native void setLeft(float f);

        public native void setRight(float f);

        public native void setTop(float f);
    }

    @Keep
    public static class ChangeDownPoint {
        private float x;
        private float y;

        static {
            OSETSDKProtected.interface11(4591);
        }

        public native float getX();

        public native float getY();

        public native void setX(float f);

        public native void setY(float f);
    }

    @Keep
    public static class ChangeUpPoint {
        private float x;
        private float y;

        static {
            OSETSDKProtected.interface11(4592);
        }

        public native float getX();

        public native float getY();

        public native void setX(float f);

        public native void setY(float f);
    }

    @Keep
    public static class OriginalDownPoint {
        private float x;
        private float y;

        static {
            OSETSDKProtected.interface11(4593);
        }

        public native float getX();

        public native float getY();

        public native void setX(float f);

        public native void setY(float f);
    }

    @Keep
    public static class OriginalUpPoint {
        private float x;
        private float y;

        static {
            OSETSDKProtected.interface11(4594);
        }

        public native float getX();

        public native float getY();

        public native void setX(float f);

        public native void setY(float f);
    }

    @Keep
    public static class ScreenSize {
        private int height;
        private int width;

        static {
            OSETSDKProtected.interface11(4595);
        }

        public native int getHeight();

        public native int getWidth();

        public native void setHeight(int i);

        public native void setWidth(int i);
    }

    static {
        OSETSDKProtected.interface11(4596);
    }

    public native BtnLocation getBtnLocation();

    public native int getBtnType();

    public native ChangeDownPoint getChangeDownPoint();

    public native ChangeUpPoint getChangeUpPoint();

    public native OriginalDownPoint getOriginalDownPoint();

    public native OriginalUpPoint getOriginalUpPoint();

    public native ScreenSize getScreenSize();

    public native int getShowTime();

    public native void setBtnLocation(BtnLocation btnLocation);

    public native void setBtnType(int i);

    public native void setChangeDownPoint(ChangeDownPoint changeDownPoint);

    public native void setChangeUpPoint(ChangeUpPoint changeUpPoint);

    public native void setOriginalDownPoint(OriginalDownPoint originalDownPoint);

    public native void setOriginalUpPoint(OriginalUpPoint originalUpPoint);

    public native void setScreenSize(ScreenSize screenSize);

    public native void setShowTime(int i);
}
