package com.huachenjie.sport.page.mine.signin;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.zj.adlib.gq1;
import com.zj.adlib.n76;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BaseSubscriber;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class NumberSignInVM extends BaseVM {
    public MutableLiveData<String> i = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gq1 f36714a = new gq1();

    public void h(HCJAddressInfo hCJAddressInfo, BaseSubscriber<BaseEntity<JSONObject>> baseSubscriber) {
        n76.e(this, this.f36714a.s(this.i.getValue(), hCJAddressInfo)).p5(baseSubscriber);
    }
}
