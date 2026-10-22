package com.huachenjie.mall.page.address.edit;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.api.BaseModel;
import com.huachenjie.base.bean.AddressInfo;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.fv5;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR%\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\n8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR%\u0010!\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u000b0\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000fR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\n8\u0006¢\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b$\u0010\u000fR\u001f\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\n8\u0006¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u000fR\u001f\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\n8\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b*\u0010\u000f¨\u0006."}, d2 = {"Lcom/huachenjie/mall/page/address/edit/ShippingAddressEditVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "t", "j", "u", "Lcom/huachenjie/base/api/BaseModel;", "a", "Lcom/huachenjie/base/api/BaseModel;", "baseModel", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "q", "()Landroidx/lifecycle/MutableLiveData;", "name", "c", "r", AliyunLogCommon.TERMINAL_TYPE, "d", "k", "address", "e", j.b, "detailAddress", "", "kotlin.jvm.PlatformType", "f", "n", "defaultFlag", y6b.f, "m", "addressNo", "Lcom/huachenjie/base/bean/AddressInfo;", y6b.g, "p", "mProvinceCityDistrictList", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "i", t.d, "addressBean", "s", "saveAddressBean", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ShippingAddressEditVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final BaseModel baseModel = new BaseModel();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> name = new MutableLiveData<>("");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> phone = new MutableLiveData<>("");

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> address = new MutableLiveData<>("");

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> detailAddress = new MutableLiveData<>("");

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> defaultFlag = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> addressNo = new MutableLiveData<>("");

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AddressInfo> mProvinceCityDistrictList = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ShippingAddressBean> addressBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ShippingAddressBean> saveAddressBean = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/mall/page/address/edit/ShippingAddressEditVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/base/bean/AddressInfo;", "data", "", "onCCSuccess", "onFinish", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<AddressInfo> {
        public a() {
            super(true);
        }

        public void onFinish() {
            ShippingAddressEditVM.this.c();
        }

        public void onCCSuccess(@Nullable AddressInfo data) {
            if (data != null) {
                ShippingAddressEditVM.this.p().setValue(data);
            }
        }
    }

    public final void j() {
        if (TextUtils.isEmpty(this.name.getValue())) {
            fv5.b("请输入收货人姓名");
            return;
        }
        if (TextUtils.isEmpty(this.phone.getValue())) {
            fv5.b("请输入手机号");
            return;
        }
        if (TextUtils.isEmpty(this.address.getValue())) {
            fv5.b("请选择省、市、区、街道");
        } else if (TextUtils.isEmpty(this.detailAddress.getValue())) {
            fv5.b("请输入详细地址");
        } else {
            BaseViewModelExtKt.b(this, true, false, null, null, new ShippingAddressEditVM$addAddress$1(this, null), 14, null);
        }
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.address;
    }

    @NotNull
    public final MutableLiveData<ShippingAddressBean> l() {
        return this.addressBean;
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.addressNo;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.defaultFlag;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.detailAddress;
    }

    @NotNull
    public final MutableLiveData<AddressInfo> p() {
        return this.mProvinceCityDistrictList;
    }

    @NotNull
    public final MutableLiveData<String> q() {
        return this.name;
    }

    @NotNull
    public final MutableLiveData<String> r() {
        return this.phone;
    }

    @NotNull
    public final MutableLiveData<ShippingAddressBean> s() {
        return this.saveAddressBean;
    }

    public final void t() {
        Observable<BaseEntity<AddressInfo>> observableB = this.baseModel.b();
        if (observableB == null) {
            return;
        }
        g();
        observableB.u5(Schedulers.io()).G3(d60.c()).p5(new a());
    }

    public final void u() {
        if (TextUtils.isEmpty(this.name.getValue())) {
            fv5.b("请输入收货人姓名");
            return;
        }
        if (TextUtils.isEmpty(this.phone.getValue())) {
            fv5.b("请输入手机号");
            return;
        }
        if (TextUtils.isEmpty(this.address.getValue())) {
            fv5.b("请选择省、市、区、街道");
        } else if (TextUtils.isEmpty(this.detailAddress.getValue())) {
            fv5.b("请输入详细地址");
        } else {
            BaseViewModelExtKt.b(this, true, false, null, null, new ShippingAddressEditVM$updateAddress$1(this, null), 14, null);
        }
    }
}
