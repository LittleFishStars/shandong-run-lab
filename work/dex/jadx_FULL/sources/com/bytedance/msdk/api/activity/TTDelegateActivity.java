package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.triver.basic.api.RequestPermission;
import com.baidu.mapapi.UIMsg;
import com.byazt.bp.tt;
import com.byazt.eu.n;
import com.byazt.ka.uj;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class TTDelegateActivity extends Activity {
    private Intent c;

    @com.byazt.zqa.c(c = {0, 80, 2350, 2351, 331, UIMsg.f_FUN.FUN_ID_UTIL_ACTION})
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }
    }

    private void c() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void tt() {
        try {
            int intExtra = this.c.getIntExtra("type", 0);
            if (intExtra == 1) {
                c(intExtra, this.c.getIntArrayExtra(RequestPermission.PERMISSIONS));
                return;
            }
            if (intExtra == 2) {
                c(this.c.getStringExtra("permission_id_key"), this.c.getStringArrayExtra("permission_content_key"));
            } else if (intExtra != 3) {
                finish();
            } else {
                c(intExtra, (int[]) null);
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        c();
        this.c = getIntent();
        if (tt.getContext() == null) {
            tt.c(this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (tt.getContext() == null) {
            tt.c(this);
        }
        try {
            setIntent(intent);
            this.c = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        uj.c().c(this, strArr, iArr);
        n.uj(new c());
        finish();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (getIntent() != null) {
            tt();
        }
    }

    private void c(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            try {
                uj.c().c(this, strArr, new com.byazt.ka.n() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                    @Override // com.byazt.ka.n
                    public void c() {
                        com.byazt.ka.c.c(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.byazt.ka.n
                    public void c(String str2) {
                        com.byazt.ka.c.c(str, str2);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        finish();
    }

    private void c(int i, int[] iArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (i != 1) {
                if (i == 3) {
                    arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                    arrayList.add("android.permission.READ_PHONE_STATE");
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            } else if (iArr != null && iArr.length > 0) {
                for (int i2 : iArr) {
                    if (i2 == 1) {
                        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                    } else if (i2 == 2) {
                        arrayList.add("android.permission.READ_PHONE_STATE");
                    } else if (i2 == 3) {
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                }
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            uj.c().c(this, strArr, new com.byazt.ka.n() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                @Override // com.byazt.ka.n
                public void c() {
                    com.byazt.eu.tt.c("TMe", "-------=----- onGranted");
                    n.uj(new c());
                    TTDelegateActivity.this.finish();
                }

                @Override // com.byazt.ka.n
                public void c(String str) {
                    com.byazt.eu.tt.c("TMe", "-------=----- onDenied: ".concat(String.valueOf(str)));
                    "android.permission.READ_PHONE_STATE".equals(str);
                    n.uj(new c());
                    TTDelegateActivity.this.finish();
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }
}
