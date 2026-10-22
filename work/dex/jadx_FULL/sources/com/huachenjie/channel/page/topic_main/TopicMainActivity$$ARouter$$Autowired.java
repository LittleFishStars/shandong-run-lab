package com.huachenjie.channel.page.topic_main;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zj.adlib.yj7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class TopicMainActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        TopicMainActivity topicMainActivity = (TopicMainActivity) obj;
        topicMainActivity.com.zj.adlib.yj7.b.b java.lang.String = topicMainActivity.getIntent().getExtras() == null ? topicMainActivity.com.zj.adlib.yj7.b.b java.lang.String : topicMainActivity.getIntent().getExtras().getString(yj7.b.SUBJECT_NO, topicMainActivity.com.zj.adlib.yj7.b.b java.lang.String);
    }
}
