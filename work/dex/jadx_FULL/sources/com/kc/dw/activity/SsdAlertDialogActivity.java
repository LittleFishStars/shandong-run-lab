package com.kc.dw.activity;

import android.os.Bundle;
import android.view.View;
import com.kc.dw.core.safe.SafeAppCompatActivity;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsdAlertDialogActivity extends SafeAppCompatActivity {
    private static CancelHandler cancelHandler;
    private static ConfirmHandler confirmHandler;

    @Keep
    public interface CancelHandler {
        void handle();
    }

    @Keep
    public interface ConfirmHandler {
        void handle();
    }

    public static void setCancelHandler(CancelHandler cancelHandler2) {
        cancelHandler = cancelHandler2;
    }

    public static void setConfirmHandler(ConfirmHandler confirmHandler2) {
        confirmHandler = confirmHandler2;
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnClick(View view) {
        ConfirmHandler confirmHandler2;
        int id = view.getId();
        if (id == R.id.cancel_button) {
            CancelHandler cancelHandler2 = cancelHandler;
            if (cancelHandler2 != null) {
                cancelHandler2.handle();
            }
        } else if (id == R.id.confirm_button && (confirmHandler2 = confirmHandler) != null) {
            confirmHandler2.handle();
        }
        finish();
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        supportRequestWindowFeature(1);
        setContentView(R.layout.ssd_activity_alert_dialog);
        findViewById(R.id.cancel_button).setOnClickListener(this);
        findViewById(R.id.confirm_button).setOnClickListener(this);
    }

    @Override // com.kc.dw.core.safe.SafeAppCompatActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        confirmHandler = null;
        cancelHandler = null;
    }
}
