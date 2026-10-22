package com.huachenjie.compat.page.personal;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.bean.AddressBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ModifyAddressActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        ModifyAddressActivity modifyAddressActivity = (ModifyAddressActivity) obj;
        modifyAddressActivity.addressBean = (AddressBean) modifyAddressActivity.getIntent().getParcelableExtra("address");
    }
}
