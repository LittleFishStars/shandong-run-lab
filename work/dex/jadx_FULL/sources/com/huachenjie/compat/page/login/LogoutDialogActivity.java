package com.huachenjie.compat.page.login;

import android.content.Intent;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.zj.adlib.ai9;
import com.zj.adlib.m25;
import com.zj.adlib.zj7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.b)
public class LogoutDialogActivity extends BaseActivity {
    public String t;
    public String x;

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return 0;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
        this.t = intent.getStringExtra("title");
        this.x = intent.getStringExtra("content");
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        if (!ai9.l()) {
            finish();
            return;
        }
        m25.b(((BaseActivity) this).c);
        ActivityLifecycleManager.l().h();
        ARouter.getInstance().build(zj7.f.LOGIN).addFlags(268468224).withString("title", this.t).withString("content", this.x).navigation();
        finish();
    }
}
