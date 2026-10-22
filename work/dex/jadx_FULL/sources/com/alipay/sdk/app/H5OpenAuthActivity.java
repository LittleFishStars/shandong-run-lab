package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.m.b;
import com.alipay.sdk.m.w.a;
import com.zj.adlib.i40;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class H5OpenAuthActivity extends H5PayActivity {
    public boolean j = false;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.j) {
            try {
                a aVarA = a.C0210a.a(getIntent());
                if (aVarA != null) {
                    com.alipay.sdk.m.m.a.b(this, aVarA, "", aVarA.d);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            a aVarA = a.C0210a.a(intent);
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data == null || !data.toString().startsWith(i40.PREFIX)) {
                    return;
                }
                finish();
            } catch (Throwable th) {
                String string = (intent == null || intent.getData() == null) ? "null" : intent.getData().toString();
                if (aVarA != null) {
                    com.alipay.sdk.m.m.a.a(aVarA, b.l, b.p0, th, string);
                }
                this.j = true;
                throw th;
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
