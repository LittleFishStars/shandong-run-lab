package com.huachenjie.run.page.rule;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.bean.SchoolRule;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RuleV3Activity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object target) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        RuleV3Activity ruleV3Activity = (RuleV3Activity) target;
        ruleV3Activity.com.huachenjie.run.page.rule.RuleV3Activity.x java.lang.String = (SchoolRule) ruleV3Activity.getIntent().getParcelableExtra(RuleV3Activity.x);
    }
}
