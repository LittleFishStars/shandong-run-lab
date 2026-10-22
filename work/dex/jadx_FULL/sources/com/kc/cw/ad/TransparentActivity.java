package com.kc.cw.ad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.kc.cw.ad.d.b.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class TransparentActivity extends Activity {
    static {
        try {
            System.loadLibrary("shenshi");
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    public native void activityResult(int i, int i2);

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        activityResult(i, i2);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupWindow();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        pause();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable(this) { // from class: com.kc.cw.ad.TransparentActivity.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final TransparentActivity f38660a;

            {
                this.f38660a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f38660a.resume();
            }
        }, 100L);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        stop();
    }

    public native void pause();

    public native void resume();

    public native void setupWindow();

    public native void stop();
}
