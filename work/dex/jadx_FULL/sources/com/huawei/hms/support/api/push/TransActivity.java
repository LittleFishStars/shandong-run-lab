package com.huawei.hms.support.api.push;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huawei.android.hms.push.R;
import com.huawei.hms.push.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class TransActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hwpush_trans_activity);
        getWindow().addFlags(TTAdConstant.KEY_CLICK_AREA);
        t.a(this, getIntent());
        finish();
    }
}
