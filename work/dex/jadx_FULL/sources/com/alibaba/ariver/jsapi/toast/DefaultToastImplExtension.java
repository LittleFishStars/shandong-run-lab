package com.alibaba.ariver.jsapi.toast;

import android.content.Context;
import android.widget.Toast;
import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.point.view.ToastPoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class DefaultToastImplExtension implements ToastPoint {
    private static final String TAG = "NebulaToastPoint";
    private Toast toast;

    @Override // com.alibaba.ariver.app.api.point.view.ToastPoint
    public void hideToast() {
        Toast toast = this.toast;
        if (toast != null) {
            try {
                toast.cancel();
            } catch (Throwable th) {
                RVLogger.e(TAG, "hideToast error!", th);
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.view.ToastPoint
    public void showToast(Context context, String str, int i, String str2, int i2, int i3) {
        try {
            Toast toastMakeText = Toast.makeText(context.getApplicationContext(), str, 1);
            this.toast = toastMakeText;
            toastMakeText.setGravity(17, i2, i3);
            this.toast.show();
        } catch (Exception e) {
            RVLogger.e("", e);
        }
    }
}
