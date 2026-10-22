package com.kc.dw.core.safe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SafeActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "SafeActivity";

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            safeOnActivityResult(i, i2, intent);
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtil.e(TAG, "onActivityResult error. finish");
            com.kc.dw.base.middleware.a.a(th);
            safeFinish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onAttachedToWindow() {
        try {
            safeOnAttachedToWindow();
        } catch (Throwable th) {
            th.printStackTrace();
            com.kc.dw.base.middleware.a.a(th);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            safeOnClick(view);
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        try {
            safeOnCreate(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtil.e(TAG, "onCreate error. finish");
            com.kc.dw.base.middleware.a.a(th);
            safeFinish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        try {
            safeOnDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
            com.kc.dw.base.middleware.a.a(th);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        try {
            safeOnDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
            com.kc.dw.base.middleware.a.a(th);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return safeOnKeyDown(i, keyEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            com.kc.dw.base.middleware.a.a(th);
            return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        try {
            safeOnPause();
        } catch (Throwable th) {
            th.printStackTrace();
            com.kc.dw.base.middleware.a.a(th);
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        try {
            safeOnResume();
        } catch (Throwable th) {
            th.printStackTrace();
            com.kc.dw.base.middleware.a.a(th);
        }
    }

    public void safeFinish() {
        try {
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
        }
    }

    public void safeOnActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void safeOnAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void safeOnClick(View view) {
    }

    public void safeOnCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void safeOnDestroy() {
        super.onDestroy();
    }

    public void safeOnDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public boolean safeOnKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public void safeOnPause() {
        super.onPause();
    }

    public void safeOnResume() {
        super.onResume();
    }
}
