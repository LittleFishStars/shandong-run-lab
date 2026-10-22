package com.fl.saas.base.inner.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.fl.saas.base.inner.YdAdTempHelper;
import com.fl.saas.common.util.YdImmersiveUtils;
import com.fl.saas.config.utils.DeepLinkJumpUtil;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class YdInterstitialActivity extends Activity {
    private String id;

    public static void startMe(Context context, String str) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) YdInterstitialActivity.class);
        intent.putExtra("id", str);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        DeepLinkJumpUtil.getInstance().reportActivityResult(i, i2, this);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        YdImmersiveUtils.setImmersiveStatusBar(this);
        YdImmersiveUtils.setStatusBarLightMode(this, true);
        super.onCreate(bundle);
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
        this.id = getIntent().getStringExtra("id");
        YdAdTempHelper.getInstance().notify(this.id, this);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        YdAdTempHelper.getInstance().removeListener(this.id);
    }
}
