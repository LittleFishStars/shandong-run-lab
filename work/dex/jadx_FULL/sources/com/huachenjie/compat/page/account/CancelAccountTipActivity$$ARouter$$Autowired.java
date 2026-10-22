package com.huachenjie.compat.page.account;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CancelAccountTipActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        CancelAccountTipActivity cancelAccountTipActivity = (CancelAccountTipActivity) obj;
        cancelAccountTipActivity.ticket = cancelAccountTipActivity.getIntent().getExtras() == null ? cancelAccountTipActivity.ticket : cancelAccountTipActivity.getIntent().getExtras().getString(UserConstants.MINE_PARAMS.b, cancelAccountTipActivity.ticket);
        cancelAccountTipActivity.com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE java.lang.String = cancelAccountTipActivity.getIntent().getExtras() == null ? cancelAccountTipActivity.com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE java.lang.String : cancelAccountTipActivity.getIntent().getExtras().getString(UserConstants.MINE_PARAMS.c, cancelAccountTipActivity.com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE java.lang.String);
    }
}
