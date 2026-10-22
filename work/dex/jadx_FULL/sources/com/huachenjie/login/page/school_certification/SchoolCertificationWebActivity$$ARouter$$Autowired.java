package com.huachenjie.login.page.school_certification;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class SchoolCertificationWebActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        SchoolCertificationWebActivity schoolCertificationWebActivity = (SchoolCertificationWebActivity) obj;
        schoolCertificationWebActivity.url = schoolCertificationWebActivity.getIntent().getExtras() == null ? schoolCertificationWebActivity.url : schoolCertificationWebActivity.getIntent().getExtras().getString("url", schoolCertificationWebActivity.url);
        schoolCertificationWebActivity.type = schoolCertificationWebActivity.getIntent().getExtras() == null ? schoolCertificationWebActivity.type : schoolCertificationWebActivity.getIntent().getExtras().getString("type", schoolCertificationWebActivity.type);
    }
}
