package com.huachenjie.mine.page.home;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class FriendInfoActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        FriendInfoActivity friendInfoActivity = (FriendInfoActivity) obj;
        friendInfoActivity.appUserCode = friendInfoActivity.getIntent().getExtras() == null ? friendInfoActivity.appUserCode : friendInfoActivity.getIntent().getExtras().getString("appUserCode", friendInfoActivity.appUserCode);
        friendInfoActivity.com.huachenjie.mine.page.home.MineFragment.SKIP_TARGET java.lang.String = friendInfoActivity.getIntent().getExtras() == null ? friendInfoActivity.com.huachenjie.mine.page.home.MineFragment.SKIP_TARGET java.lang.String : friendInfoActivity.getIntent().getExtras().getString("target", friendInfoActivity.com.huachenjie.mine.page.home.MineFragment.SKIP_TARGET java.lang.String);
    }
}
