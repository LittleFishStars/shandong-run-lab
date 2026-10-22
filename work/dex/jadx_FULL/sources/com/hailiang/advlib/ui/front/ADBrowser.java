package com.hailiang.advlib.ui.front;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import com.hailiang.advlib.core.IADBrowser;
import com.hailiang.advlib.core.c;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import hl.hl.hl.hl.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class ADBrowser extends Activity {
    private IADBrowser adBrowserImp;

    private void loadInstance() {
        IADBrowser iADBrowserA = c.a();
        this.adBrowserImp = iADBrowserA;
        if (iADBrowserA == null) {
            Log.i("ADBrowser", "Well, our remote class didn't load yet, invoke _bootstrap() ...");
            a.a(getApplicationContext());
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        IADBrowser iADBrowser = this.adBrowserImp;
        if (iADBrowser != null) {
            iADBrowser.onActivityResultRef(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            loadInstance();
            IADBrowser iADBrowser = this.adBrowserImp;
            if (iADBrowser != null) {
                iADBrowser.doWhenReflect(this, bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IADBrowser iADBrowser = this.adBrowserImp;
        if (iADBrowser == null || !Boolean.valueOf(iADBrowser.onKeyEvent(i, keyEvent)).booleanValue()) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        IADBrowser iADBrowser = this.adBrowserImp;
        if (iADBrowser != null) {
            iADBrowser.whenPermDialogReturns(i, strArr, iArr);
        }
    }
}
