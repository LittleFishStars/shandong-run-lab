package com.huachenjie.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.zj.adlib.ln6;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/pay/WXPayCallbackActivity;", "Landroid/app/Activity;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "()V", "handleIntent", "", "intent", "Landroid/content/Intent;", "handleIntentByWXClient", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onReq", HiAnalyticsConstant.Direction.REQUEST, "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "onResp", "resp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "pay_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class WXPayCallbackActivity extends Activity implements IWXAPIEventHandler {
    public void handleIntent(@Nullable Intent intent) {
        handleIntentByWXClient(intent);
    }

    public abstract void handleIntentByWXClient(@Nullable Intent intent);

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
    }

    @Override // android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    public void onReq(@Nullable BaseReq req) {
    }

    public void onResp(@Nullable BaseResp resp) {
        if (resp != null && resp.getType() == 5) {
            ln6.f18003a.e(this, resp.errCode);
        }
        finish();
    }
}
