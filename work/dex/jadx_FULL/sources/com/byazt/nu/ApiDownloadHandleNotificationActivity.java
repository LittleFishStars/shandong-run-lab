package com.byazt.nu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import com.byazt.bog.a;
import com.hjq.permissions.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 137, 729})
public class ApiDownloadHandleNotificationActivity extends Activity {
    public static final String[] c = {Permission.POST_NOTIFICATIONS};
    public ApiDownloadHandlerService tt = new ApiDownloadHandlerService();

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.nu.ApiDownloadHandleNotificationActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if ("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION".equals(intent.getAction())) {
                    ApiDownloadHandleNotificationActivity.this.c();
                } else {
                    ApiDownloadHandleNotificationActivity.this.tt.onStartCommand(intent, 0, 0);
                }
                ApiDownloadHandleNotificationActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1000 || iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            a.tt("DownloadNotificationJumpActivity", "onRequestPermissionsResultNotification Permission denied");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            ActivityCompat.requestPermissions(this, c, 1000);
        } catch (Throwable th) {
            a.tt("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }
}
