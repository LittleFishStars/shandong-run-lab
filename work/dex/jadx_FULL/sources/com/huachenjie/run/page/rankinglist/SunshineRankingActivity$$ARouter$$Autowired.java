package com.huachenjie.run.page.rankinglist;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class SunshineRankingActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object target) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        SunshineRankingActivity sunshineRankingActivity = (SunshineRankingActivity) target;
        sunshineRankingActivity.com.huachenjie.run.page.rankinglist.SunshineRankingActivity.x java.lang.String = (ArrayList) sunshineRankingActivity.getIntent().getSerializableExtra(SunshineRankingActivity.x);
    }
}
