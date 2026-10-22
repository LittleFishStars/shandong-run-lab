package com.fl.saas.adx.base.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.fl.saas.C1439v;
import com.fl.saas.D;
import com.fl.saas.K;
import com.fl.saas.R;
import com.fl.saas.adx.api.mixNative.NativeAdView;
import com.fl.saas.adx.base.inner.FLAdTempHelper;
import com.fl.saas.adx.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLInterstitialActivity extends Activity {
    private FrameLayout fl_ad;
    private String id;
    private InterstitialViewHelper interstitialHelper;
    private RelativeLayout rl_root;

    public static void startMe(Context context, String str) {
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) FLInterstitialActivity.class);
            intent.putExtra("id", str);
            context.startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        D.a().a(i, i2, this);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            K.a(this);
            K.a(this, true);
            if (Build.VERSION.SDK_INT != 26) {
                if (DeviceUtil.getOrientation(this) == 2) {
                    setRequestedOrientation(6);
                } else {
                    setRequestedOrientation(7);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentView(R.layout.fl_adx_activity_interstitial);
        this.rl_root = (RelativeLayout) findViewById(R.id.rl_root);
        this.fl_ad = (FrameLayout) findViewById(R.id.fl_ad);
        this.id = getIntent().getStringExtra("id");
        InterstitialViewHelper interstitialHelper = FLAdTempHelper.getInstance().getInterstitialHelper(this.id);
        this.interstitialHelper = interstitialHelper;
        if (interstitialHelper != null) {
            try {
                this.rl_root.setBackgroundColor(Color.argb((int) ((Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(100.0d, interstitialHelper.getAlpha())) / 100.0d) * 255.0d), 0, 0, 0));
                this.interstitialHelper.setOnAdCloseListener(new InterstitialViewHelper.OnAdCloseListener() { // from class: com.zj.adlib.xc3
                    @Override // com.fl.saas.adx.base.inner.interstitial.InterstitialViewHelper.OnAdCloseListener
                    public final void onClose() {
                        this.f45792a.finish();
                    }
                });
                this.interstitialHelper.readerAdView();
                NativeAdView nativeAdView = this.interstitialHelper.getNativeAdView();
                if (nativeAdView != null) {
                    this.fl_ad.addView(nativeAdView);
                    this.interstitialHelper.onActivityStart(this);
                } else {
                    finish();
                }
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FLAdTempHelper.getInstance().removeInterstitialHelper(this.id);
        C1439v.b().a();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
