package com.huachenjie.compat.page.about_as;

import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.b;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.VersionUpgrade;
import com.zj.adlib.eh9;
import com.zj.adlib.fv5;
import com.zj.adlib.gq1;
import com.zj.adlib.n76;
import huachenjie.sdk.http.subscriber.BizSubscriber;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class AboutAsVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gq1 f34075a = new gq1();
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();
    public MutableLiveData<String> j;

    public class a extends BizSubscriber<VersionUpgrade> {
        public a() {
        }

        public void onCCSuccess(VersionUpgrade versionUpgrade) {
            if (versionUpgrade != null) {
                if (eh9.c(versionUpgrade)) {
                    eh9.e(versionUpgrade);
                } else {
                    fv5.b("当前为最新版本");
                }
            }
        }
    }

    public AboutAsVM() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.j = mutableLiveData;
        mutableLiveData.setValue(b.C());
    }

    public void h() {
        n76.e(this, this.f34075a.e()).p5(new a());
    }
}
