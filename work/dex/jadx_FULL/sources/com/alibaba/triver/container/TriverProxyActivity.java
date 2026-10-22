package com.alibaba.triver.container;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.R;
import com.alibaba.triver.Triver;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverProxyActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24771a;
    private boolean b;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        ActivityOptionsCompat activityOptionsCompatMakeCustomAnimation;
        super.onCreate(bundle);
        try {
            RVInitializer.init(getApplicationContext());
            ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).skipPage(this);
            Intent intent = getIntent();
            if (intent == null) {
                TriverToastUtils.showToast(this, getString(R.string.triver_system_error_and_retry));
                RVLogger.e(Triver.TAG, "proxyActivity onCreate fail no intent");
                finish();
                return;
            }
            Intent intent2 = (Intent) intent.getParcelableExtra("targetIntent");
            if (intent2 == null) {
                TriverToastUtils.showToast(this, "系统错误，请重试！");
                RVLogger.e(Triver.TAG, "proxyActivity onCreate fail no targetIntent");
                finish();
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(TRiverConstants.KEY_CONTAINER_ANIM);
            if (serializableExtra != null) {
                ContainerAnimModel containerAnimModel = (ContainerAnimModel) serializableExtra;
                activityOptionsCompatMakeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, containerAnimModel.frontEnterAnim, containerAnimModel.backgroundEnterAnim);
            } else {
                activityOptionsCompatMakeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.triver_pri_enter_up_in, R.anim.triver_pri_enter_scale);
            }
            startActivity(intent2, activityOptionsCompatMakeCustomAnimation.toBundle());
            String stringExtra = intent.getStringExtra("appId");
            this.f24771a = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                TriverToastUtils.showToast(this, getString(R.string.triver_system_error_and_retry));
                RVLogger.e(Triver.TAG, "proxyActivity onCreate fail no appId");
                finish();
                return;
            }
            a.a(this.f24771a, this);
            RVLogger.d(Triver.TAG, "proxyActivity onCreate:" + this.f24771a);
            this.b = true;
            View view = new View(this);
            setContentView(view);
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.alibaba.triver.container.TriverProxyActivity.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    RVLogger.e(Triver.TAG, "proxyActivity onTouch to finish");
                    TriverProxyActivity.this.finish();
                    return false;
                }
            });
        } catch (Exception e) {
            TriverToastUtils.showToast(this, getString(R.string.triver_system_error_and_retry));
            RVLogger.e(Triver.TAG, "proxyActivity onCreate error:" + this.f24771a, e);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (this.b) {
                this.b = false;
                return;
            }
            long jC = a.a().c(this.f24771a);
            if (jC > 0) {
                RVAppRecord appRecord = RVMain.getAppRecord(jC);
                if (appRecord == null) {
                    RVLogger.e(Triver.TAG, "reShow app error:" + this.f24771a + ", no record");
                    finish();
                    return;
                }
                if (Triver.reShowAppTask(this, appRecord)) {
                    RVLogger.d(Triver.TAG, "use proxyActivity to reShow app:" + this.f24771a);
                    return;
                }
                RVLogger.e(Triver.TAG, "reShow app error:" + this.f24771a);
                finish();
            }
        } catch (Exception e) {
            RVLogger.e(Triver.TAG, "proxyActivity onResume error:" + this.f24771a, e);
            finish();
        }
    }
}
