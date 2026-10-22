package com.kc.bw.appsdkdex;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.kc.bw.common.WMAdActListener;
import com.kc.bw.common.utils.DebugLog;
import com.kc.bw.common.utils.ReportUtils;
import com.kc.bw.dexg;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMPortraitActivity extends Activity {
    public static final String dexe = "WMPortraitActivity";
    public FrameLayout dexa;
    public String dexb;
    public WMAdActListener dexc;
    public ViewGroup dexd;

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        WMAdActListener wMAdActListener = this.dexc;
        if (wMAdActListener != null && wMAdActListener.getAdResources() != null) {
            return this.dexc.getAdResources();
        }
        return super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme themeNewTheme = getResources().newTheme();
        themeNewTheme.setTo(super.getTheme());
        return themeNewTheme;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        WMAdActListener wMAdActListener = this.dexc;
        if (wMAdActListener != null) {
            wMAdActListener.adOnActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WMAdActListener wMAdActListener = this.dexc;
        if (wMAdActListener != null) {
            wMAdActListener.adOnConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.kcbw_view_act);
        try {
            this.dexb = getIntent().getStringExtra(dexg.dexa("nbq`lfz"));
            this.dexa = (FrameLayout) findViewById(R.id.wm_reward_main);
            this.dexd = WMDexAdHelper.loadViewGroupMap.get(this.dexb);
            this.dexa.removeAllViews();
            this.dexa.addView(this.dexd);
            WMDexAdHelper.activityMap.put(this.dexb, new WeakReference<>(this));
            ViewParent viewParent = this.dexd;
            if (viewParent instanceof WMAdActListener) {
                WMAdActListener wMAdActListener = (WMAdActListener) viewParent;
                this.dexc = wMAdActListener;
                wMAdActListener.onAdCreate(bundle);
            }
        } catch (Throwable th) {
            DebugLog.release_e(dexe, dexg.dexa("poDsfbuf!fssps-") + th);
            ReportUtils.exReport(this, 999959, dexg.dexa("Bdujwjuz毺暩楅葇楲鵦"), dexg.dexa("絼择毺暩扜漻楲鵦)XNQpsusbjuBdujwjuz.poDsfbuf*-") + th);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WMAdActListener wMAdActListener = this.dexc;
        if (wMAdActListener != null) {
            wMAdActListener.onAdDestroy();
        }
        ViewGroup viewGroup = this.dexd;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.dexd = null;
        }
        FrameLayout frameLayout = this.dexa;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        WMDexAdHelper.activityMap.remove(this.dexb);
        WMDexAdHelper.loadViewGroupMap.remove(this.dexb);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean zOnKeyDown = super.onKeyDown(i, keyEvent);
        WMAdActListener wMAdActListener = this.dexc;
        return wMAdActListener != null ? !wMAdActListener.adOnKeyDown(i, keyEvent) : zOnKeyDown;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        WMAdActListener wMAdActListener = this.dexc;
        if (wMAdActListener != null) {
            wMAdActListener.onAdPause();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        WMAdActListener wMAdActListener = this.dexc;
        if (wMAdActListener != null) {
            wMAdActListener.onAdRestart();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        WMAdActListener wMAdActListener = this.dexc;
        if (wMAdActListener != null) {
            wMAdActListener.onAdResume();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        WMAdActListener wMAdActListener = this.dexc;
        if (wMAdActListener != null) {
            wMAdActListener.onAdStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        WMAdActListener wMAdActListener = this.dexc;
        if (wMAdActListener != null) {
            wMAdActListener.onAdStop();
        }
    }
}
