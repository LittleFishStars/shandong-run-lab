package cn.jy.ad.sdk.jyact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.jy.ad.sdk.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BaseAdActivity extends Activity {
    private JYTD mJYTD = null;

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onActivityResult(i, i2, intent);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onAttachedToWindow();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        boolean z = true;
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null && jytd.onBackPressed()) {
                z = false;
            }
        } catch (Throwable unused) {
        }
        if (z) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onConfigurationChanged(configuration);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Intent intent;
        boolean z;
        boolean z2 = true;
        try {
            intent = getIntent();
            try {
                if (this.mJYTD == null) {
                    this.mJYTD = g.a().a((Activity) this);
                }
                JYTD jytd = this.mJYTD;
                if (jytd != null) {
                    jytd.setActivity(this);
                    this.mJYTD.onBeforeCreate(bundle, intent);
                }
                z = false;
            } catch (Throwable th) {
                th = th;
                g.a().a(100, th);
                z = true;
            }
        } catch (Throwable th2) {
            th = th2;
            intent = null;
        }
        super.onCreate(bundle);
        try {
            JYTD jytd2 = this.mJYTD;
            if (jytd2 != null) {
                jytd2.onAfterCreate(bundle, intent);
            }
            z2 = z;
        } catch (Throwable th3) {
            g.a().a(101, th3);
        }
        if (z2 || this.mJYTD == null) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onDestroy();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onDetachedFromWindow();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onPause();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onRestart();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onRestoreInstanceState(bundle);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onResume();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onSaveInstanceState(bundle);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onStart();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        try {
            JYTD jytd = this.mJYTD;
            if (jytd != null) {
                jytd.onStop();
            }
        } catch (Throwable unused) {
        }
    }
}
