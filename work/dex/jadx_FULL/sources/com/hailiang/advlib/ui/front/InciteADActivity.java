package com.hailiang.advlib.ui.front;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import com.hailiang.advlib.core.IInciteAd;
import com.hailiang.advlib.core.c;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import hl.hl.hl.hl.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class InciteADActivity extends Activity {
    private static final int b = 64222;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IInciteAd f32600a;

    private void a() {
        if (c.a(IInciteAd.class)) {
            Log.i("ADBrowser", "Well, our remote class didn't load yet, invoke _bootstrap() ...");
            a.a(getApplicationContext());
        }
        this.f32600a = c.d();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IInciteAd iInciteAd = this.f32600a;
        if (iInciteAd != null) {
            iInciteAd.onActivityResultRef(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            a();
            IInciteAd iInciteAd = this.f32600a;
            if (iInciteAd != null) {
                iInciteAd.doWhenReflect(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        IInciteAd iInciteAd = this.f32600a;
        if (iInciteAd != null) {
            iInciteAd.onDestroyRef(this);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IInciteAd iInciteAd = this.f32600a;
        if (iInciteAd == null || !Boolean.valueOf(iInciteAd.onKeyEvent(i, keyEvent)).booleanValue()) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        IInciteAd iInciteAd = this.f32600a;
        if (iInciteAd != null) {
            iInciteAd.onPauseRef(this);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IInciteAd iInciteAd = this.f32600a;
        if (iInciteAd != null) {
            iInciteAd.whenPermDialogReturns(i, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        IInciteAd iInciteAd = this.f32600a;
        if (iInciteAd != null) {
            iInciteAd.onResumeRef(this);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        IInciteAd iInciteAd = this.f32600a;
        if (iInciteAd != null) {
            iInciteAd.onStartRef(this);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        IInciteAd iInciteAd = this.f32600a;
        if (iInciteAd != null) {
            iInciteAd.onStopRef(this);
        }
    }
}
