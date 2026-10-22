package com.acse.ottn.service;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.b;
import com.acse.ottn.d;
import com.acse.ottn.d4;
import com.acse.ottn.h2;
import com.acse.ottn.n3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ShopHelperService extends AccessibilityService {
    private static String TAG = "acse_ShopHelperService";
    public static ShopHelperService mService;
    String activityName = "";

    private boolean getCurrentAppLocation(String str) {
        str.hashCode();
        switch (str) {
            case "com.miui.home.launcher.Launcher":
            case "com.bbk.launcher2.Launcher":
            case "com.huawei.android.launcher.unihome.UniHomeLauncher":
            case "com.android.launcher.Launcher":
            case "com.hihonor.android.launcher.unihome.UniHomeLauncher":
                return true;
            default:
                return false;
        }
    }

    public static boolean isStart() {
        return mService != null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 0) {
            h2.a(TAG, "CONTENT_CHANGE_TYPE_UNDEFINED");
            return;
        }
        if (eventType != 1) {
            if (eventType == 2) {
                h2.a(TAG, "TYPE_VIEW_LONG_CLICKED");
                return;
            }
            switch (eventType) {
                case 4:
                    h2.a(TAG, "TYPE_VIEW_SELECTED");
                    break;
                case 8:
                    break;
                case 16:
                    h2.a(TAG, "TYPE_VIEW_TEXT_CHANGED");
                    break;
                case 32:
                    h2.a(TAG, "TYPE_WINDOW_STATE_CHANGED");
                    d.d().a(this, accessibilityEvent);
                    break;
                case 64:
                    h2.a(TAG, "TYPE_NOTIFICATION_STATE_CHANGED");
                    break;
                case 128:
                    h2.a(TAG, "TYPE_VIEW_HOVER_ENTER");
                    break;
                case 256:
                    h2.a(TAG, "TYPE_VIEW_HOVER_EXIT");
                    break;
                case 500:
                    h2.a(TAG, "MAX_TEXT_LENGTH");
                    break;
                case 512:
                    h2.a(TAG, "TYPE_TOUCH_EXPLORATION_GESTURE_START");
                    break;
                case 1024:
                    h2.a(TAG, "TYPE_TOUCH_EXPLORATION_GESTURE_END");
                    break;
                case 4096:
                    d4.c().a(this);
                    break;
                case 8192:
                    h2.a(TAG, "TYPE_VIEW_TEXT_SELECTION_CHANGED");
                    if (AcseHelpManager.mIsDebug) {
                        h2.a(TAG, "当前页面--》" + ((Object) accessibilityEvent.getPackageName()) + "----" + ((Object) accessibilityEvent.getClassName()));
                        if (accessibilityEvent.getPackageName() != null && accessibilityEvent.getClassName() != null && accessibilityEvent.getPackageName().equals("com.tencent.mm") && accessibilityEvent.getClassName().equals("android.widget.TextView")) {
                            b.c().a(2000L);
                            d.d().e();
                            break;
                        }
                    }
                    break;
                case 16384:
                    h2.a(TAG, "TYPE_ANNOUNCEMENT");
                    break;
                case 32768:
                    h2.a(TAG, "TYPE_VIEW_ACCESSIBILITY_FOCUSED");
                    break;
                case 65536:
                    h2.a(TAG, "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED");
                    break;
                case 131072:
                    h2.a(TAG, "TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY");
                    break;
                case 262144:
                    h2.a(TAG, "TYPE_GESTURE_DETECTION_START");
                    break;
                case 524288:
                    h2.a(TAG, "TYPE_GESTURE_DETECTION_END");
                    break;
                case 1048576:
                    h2.a(TAG, "TYPE_TOUCH_INTERACTION_START");
                    break;
                case 2097152:
                    h2.a(TAG, "TYPE_TOUCH_INTERACTION_END");
                    break;
                case 4194304:
                    h2.a(TAG, "TYPE_WINDOWS_CHANGED");
                    d.d().h(this);
                    break;
            }
            return;
        }
        d.d().b(this, accessibilityEvent);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        h2.a(TAG, "关闭");
        mService = null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        mService = null;
        h2.a(TAG, "断开");
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        mService = this;
        h2.a(TAG, "被锁定");
        super.onServiceConnected();
        if (n3.a() == null) {
            new AcseHelpManager.InitSdk().setContext(getApplication()).build();
        }
        d.d().e(this);
        d.d().a(this);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        h2.a(TAG, "onUnbind");
        return super.onUnbind(intent);
    }
}
