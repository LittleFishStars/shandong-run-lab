package com.huachenjie.shandong_school.wxapi;

import android.content.Intent;
import androidx.annotation.Nullable;
import com.huachenjie.pay.WXPayCallbackActivity;
import com.zj.adlib.it9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class WXPayEntryActivity extends WXPayCallbackActivity {
    @Override // com.huachenjie.pay.WXPayCallbackActivity
    public void handleIntentByWXClient(@Nullable Intent intent) {
        it9 it9Var = it9.a;
        if (it9Var == null) {
            return;
        }
        it9Var.m().handleIntent(intent, this);
    }
}
