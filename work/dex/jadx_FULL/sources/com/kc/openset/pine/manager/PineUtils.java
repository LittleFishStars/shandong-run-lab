package com.kc.openset.pine.manager;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.hook.AdSensorConfigBean;
import com.kc.openset.hook.ClickRangeBean;
import com.kc.openset.hook.LogoInfoBean;
import com.kc.openset.hook.SensitivityBean;
import com.kc.openset.pine.Pine;
import com.kc.openset.pine.callback.MethodHook;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class PineUtils {
    private static final int RANDOM_TRY_NUM = 10;
    private static final String SECOND_DIALOG_MARK = OSETSDKProtected.getString2(2111);
    private static final String TAG = OSETSDKProtected.getString2(2081);
    private static String[] ignoreArr;
    private static ClickExtBean mClickExtBean;
    private static String mCurrentRequestID;
    private static boolean mFlowFinish;
    private static boolean mIsRewardStartTouch;
    private static WeakReference<View> mKsInterstitialViewWeakReference;
    private static WeakReference<View> mKsRewardSecondDialogViewWeakReference;
    private static float mNewInterstitialPointX;
    private static float mNewInterstitialPointY;
    private static float mNewRewardPointX;
    private static float mNewRewardPointY;
    private static float mRewardTouchDixY;
    private static float mSecondRewardNewPointX;
    private static float mSecondRewardNewPointY;
    private static final Map<SsSensorEventListener, SensorConfigBean> mSensorConfigBeanMap;

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.PineUtils$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4598);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void afterCall(Pine.CallFrame callFrame) throws Throwable;

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.PineUtils$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4599);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void afterCall(Pine.CallFrame callFrame) throws Throwable;

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.PineUtils$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4600);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void afterCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.PineUtils$4, reason: invalid class name */
    @Keep
    public class AnonymousClass4 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4601);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.PineUtils$5, reason: invalid class name */
    @Keep
    public class AnonymousClass5 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4602);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void afterCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.PineUtils$6, reason: invalid class name */
    @Keep
    public class AnonymousClass6 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4603);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void afterCall(Pine.CallFrame callFrame) throws Throwable;

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.PineUtils$7, reason: invalid class name */
    @Keep
    public class AnonymousClass7 extends MethodHook {
        final Class val$ksSceneClass;

        static {
            OSETSDKProtected.interface11(4604);
        }

        public AnonymousClass7(Class cls) {
            this.val$ksSceneClass = cls;
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void afterCall(Pine.CallFrame callFrame) throws Throwable;

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.PineUtils$8, reason: invalid class name */
    @Keep
    public class AnonymousClass8 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4605);
        }

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void afterCall(Pine.CallFrame callFrame) throws Throwable;

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    @Keep
    public static class SsSensorEventListener implements SensorEventListener {
        static {
            OSETSDKProtected.interface11(4606);
        }

        @Override // android.hardware.SensorEventListener
        public native void onAccuracyChanged(Sensor sensor, int i);

        @Override // android.hardware.SensorEventListener
        public native void onSensorChanged(SensorEvent sensorEvent);
    }

    static {
        OSETSDKProtected.interface11(4607);
        mCurrentRequestID = "";
        ignoreArr = new String[]{OSETSDKProtected.getString2(2160), OSETSDKProtected.getString2(2161), OSETSDKProtected.getString2(2158), OSETSDKProtected.getString2(2159)};
        mFlowFinish = false;
        mKsInterstitialViewWeakReference = null;
        mKsRewardSecondDialogViewWeakReference = null;
        mSensorConfigBeanMap = new HashMap();
        mRewardTouchDixY = 0.0f;
        mIsRewardStartTouch = false;
    }

    public static native /* synthetic */ boolean access$000();

    public static native /* synthetic */ boolean access$002(boolean z);

    public static native /* synthetic */ ClickExtBean access$100();

    public static native /* synthetic */ WeakReference access$1000();

    public static native /* synthetic */ WeakReference access$1002(WeakReference weakReference);

    public static native /* synthetic */ ClickExtBean access$102(ClickExtBean clickExtBean);

    public static native /* synthetic */ float access$1100();

    public static native /* synthetic */ float access$1102(float f);

    public static native /* synthetic */ float access$1200();

    public static native /* synthetic */ float access$1202(float f);

    public static native /* synthetic */ Map access$1300();

    public static native /* synthetic */ WeakReference access$1402(WeakReference weakReference);

    public static native /* synthetic */ String access$200();

    public static native /* synthetic */ String access$202(String str);

    public static native /* synthetic */ String[] access$300();

    public static native /* synthetic */ String[] access$302(String[] strArr);

    public static native /* synthetic */ float access$400();

    public static native /* synthetic */ float access$402(float f);

    public static native /* synthetic */ int access$500(List list, int i);

    public static native /* synthetic */ float access$600();

    public static native /* synthetic */ float access$602(float f);

    public static native /* synthetic */ boolean access$700();

    public static native /* synthetic */ boolean access$702(boolean z);

    public static native /* synthetic */ float access$800();

    public static native /* synthetic */ float access$802(float f);

    public static native /* synthetic */ void access$900(MotionEvent motionEvent, Object[] objArr, AdSensorConfigBean adSensorConfigBean, DisplayMetrics displayMetrics);

    public static native void clearKsInterstitialView();

    public static native void clearKsRewardSecondDialogView();

    public static native boolean containsViewWithIdName(View view, String str);

    public static native View findTopmostViewAtPoint(View view, float f, float f2);

    private static native View findTopmostViewAtPointInternal(View view, float f, float f2);

    public static native View findViewByIdName(View view, String str);

    public static native ClickExtBean getClickExtBean();

    private static native String getIdName(View view);

    private static native int getRandomPoint(List<ClickRangeBean> list, int i);

    private static native void hookKsAdLoad(Class<?> cls, Class<?> cls2, String str, String str2);

    private static native void hookRegisterListener(Method method);

    private static native void hookUnRegisterListener(Method method);

    public static native void init(List<SensitivityBean> list);

    private static native void initDialogShowMethod();

    public static native void initHap();

    private static native void initHook();

    public static native void initKsInitHook();

    public static native void initKsInterstitialHook();

    private static native void initKsInterstitialTouch();

    public static native void initKsLoadHook();

    public static native void initKsLogo(LogoInfoBean logoInfoBean);

    private static native void initKsLogoView();

    public static native void initKsRewardHook();

    private static native void initKsRewardTouch();

    public static native void initSensorHook();

    public static native void initTaKu(double d, int i);

    public static native void initToBid(double d, int i);

    private static native boolean isPointInsideView(float f, float f2, View view);

    private static native void rewardSecondDialogClick(MotionEvent motionEvent, Object[] objArr, AdSensorConfigBean adSensorConfigBean, DisplayMetrics displayMetrics);
}
