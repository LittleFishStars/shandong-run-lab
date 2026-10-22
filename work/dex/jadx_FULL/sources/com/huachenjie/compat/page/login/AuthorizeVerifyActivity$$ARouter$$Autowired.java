package com.huachenjie.compat.page.login;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class AuthorizeVerifyActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        AuthorizeVerifyActivity authorizeVerifyActivity = (AuthorizeVerifyActivity) obj;
        authorizeVerifyActivity.f9223a = (SchoolInfo) authorizeVerifyActivity.getIntent().getParcelableExtra(UserConstants.LOGIN_PARAMS.c);
        authorizeVerifyActivity.x = authorizeVerifyActivity.getIntent().getExtras() == null ? authorizeVerifyActivity.x : authorizeVerifyActivity.getIntent().getExtras().getString(UserConstants.LOGIN_PARAMS.d, authorizeVerifyActivity.x);
    }
}
