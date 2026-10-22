package com.fl.saas.base.inner.spread;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.fl.saas.base.inner.YdAdTempHelper;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.common.util.YdImmersiveUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class YdSpreadActivity extends Activity {
    private String id;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        YdImmersiveUtils.setImmersiveStatusBar(this);
        YdImmersiveUtils.setStatusBarLightMode(this, true);
        setContentView(R.layout.yd_activity_spread);
        this.id = getIntent().getStringExtra("id");
        YdAdTempHelper.getInstance().addSpreadListener(this.id, new YdAdTempHelper.SpreadActivityListener() { // from class: com.zj.adlib.z7a
            @Override // com.fl.saas.base.inner.YdAdTempHelper.SpreadActivityListener
            public final void closeActivity() {
                this.f46206a.finish();
            }
        });
        try {
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
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_root);
        SpreadLoadListener.SpreadAd spreadAd = YdAdTempHelper.getInstance().getSpreadAd();
        if (spreadAd != null) {
            spreadAd.show(frameLayout);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        YdAdTempHelper.getInstance().removeSpreadListener(this.id);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
