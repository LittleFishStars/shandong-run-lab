package com.fl.saas.adx.base.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.fl.saas.K;
import com.fl.saas.R;
import com.fl.saas.adx.base.inner.FLAdTempHelper;
import com.fl.saas.adx.base.interfaces.SpreadLoadListener;
import com.fl.saas.adx.util.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLSpreadActivity extends Activity {
    private String id;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fl_adx_activity_spread);
        this.id = getIntent().getStringExtra("id");
        FLAdTempHelper.getInstance().addSpreadListener(this.id, new FLAdTempHelper.SpreadActivityListener() { // from class: com.zj.adlib.zc3
            @Override // com.fl.saas.adx.base.inner.FLAdTempHelper.SpreadActivityListener
            public final void closeActivity() {
                this.f46232a.finish();
            }
        });
        try {
            K.a(this);
            K.a(this, false);
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
        SpreadLoadListener.SpreadAd spreadAd = FLAdTempHelper.getInstance().getSpreadAd();
        if (spreadAd != null) {
            spreadAd.show(frameLayout);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FLAdTempHelper.getInstance().removeSpreadListener(this.id);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
