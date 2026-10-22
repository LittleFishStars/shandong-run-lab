package com.kc.openset.sdk.apiad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.adv.listener.ADVEventListener;
import com.kc.openset.sdk.adv.report.b;
import com.kc.openset.sdk.apiad.tools.OSETClicksData;
import com.kc.openset.sdk.apiad.tools.c;
import com.kc.openset.util.ShakeItUtils;
import com.kc.openset.util.TiltSensorUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.y38;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public abstract class OSETAPIBaseActivity extends Activity implements ShakeItUtils.OnShakeListener, TiltSensorUtils.OnTiltListener {
    public static final String KEY_API_DATA = OSETSDKProtected.getString2(2809);
    public static final String KEY_IS_FULL_AD = OSETSDKProtected.getString2(2810);
    private static final String TAG = OSETSDKProtected.getString2(y38.h);
    protected c adData;
    protected boolean isFullAd;
    private ADVEventListener listener;
    private ShakeItUtils shakeItUtils;
    private TiltSensorUtils tiltSensorUtils;
    private boolean mUnblockAutoOperateControl = false;
    private boolean isActivityPaused = false;
    protected boolean isTriggerClicked = false;

    static {
        OSETSDKProtected.interface11(4773);
    }

    private native void initAdData();

    public native void configStatusBar();

    public native boolean displayFullScreen();

    @Override // android.app.Activity
    public native void finish();

    public native ADVBaseListener getAdListener();

    public native String getAppInfo(c cVar);

    public native String getRequestId();

    public native boolean isActivityInvalid(Activity activity);

    public native boolean isDownloadApp();

    public native boolean isUnblockAutoOperateControl();

    public native boolean needToAutomaticallyClick();

    public native void onAdClick(boolean z, OSETClicksData oSETClicksData);

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onDestroy();

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public native boolean onKeyDown(int i, KeyEvent keyEvent);

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public native boolean onKeyUp(int i, KeyEvent keyEvent);

    public native void onNeedAutomaticTrigger();

    @Override // android.app.Activity
    public native void onPause();

    @Override // android.app.Activity
    public native void onRestoreInstanceState(Bundle bundle);

    @Override // android.app.Activity
    public native void onResume();

    @Override // android.app.Activity
    public native void onSaveInstanceState(Bundle bundle);

    @Override // com.kc.openset.util.ShakeItUtils.OnShakeListener
    public native void onShake(int i, int i2, int i3);

    @Override // com.kc.openset.util.TiltSensorUtils.OnTiltListener
    public native void onTilt(int i, int i2, int i3, long j, boolean z);

    public native void onUnblockAutoOperateControl(boolean z);

    public native void registerSensor();

    public native void reportAdEvent(int i);

    public native void reportAdEvent(b bVar);

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public native void startActivity(Intent intent);

    public native void unRegisterSensor();
}
