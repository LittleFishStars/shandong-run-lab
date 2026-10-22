package com.huachenjie.sport.page.mine.exam;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.sport.bean.ExamDetailData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        ExamDetailActivity examDetailActivity = (ExamDetailActivity) obj;
        examDetailActivity.f36654a = (ExamDetailData) examDetailActivity.getIntent().getParcelableExtra("detail");
    }
}
