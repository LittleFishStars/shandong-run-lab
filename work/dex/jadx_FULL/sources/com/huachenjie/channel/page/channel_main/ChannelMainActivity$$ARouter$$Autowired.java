package com.huachenjie.channel.page.channel_main;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelMainActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        ChannelMainActivity channelMainActivity = (ChannelMainActivity) obj;
        channelMainActivity.channelNo = channelMainActivity.getIntent().getExtras() == null ? channelMainActivity.channelNo : channelMainActivity.getIntent().getExtras().getString("channelNo", channelMainActivity.channelNo);
    }
}
