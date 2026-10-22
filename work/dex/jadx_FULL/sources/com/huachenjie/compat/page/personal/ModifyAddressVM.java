package com.huachenjie.compat.page.personal;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huachenjie.base.api.BaseModel;
import com.huachenjie.base.bean.AddressInfo;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.AddressBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.rq1;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/compat/page/personal/ModifyAddressVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "m", "Lcom/huachenjie/common/bean/AddressBean;", "addressBean", "n", "Lcom/huachenjie/base/api/BaseModel;", "a", "Lcom/huachenjie/base/api/BaseModel;", "baseModel", "Lcom/zj/adlib/rq1;", "Lcom/zj/adlib/rq1;", "mode", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "", "j", RequestParameters.SUBRESOURCE_LOCATION, "k", "detailAddress", "Lcom/huachenjie/base/bean/AddressInfo;", "mProvinceCityDistrictList", y6b.g, "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class ModifyAddressVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final BaseModel baseModel = new BaseModel();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public rq1 mode = new rq1();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> location = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> detailAddress = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AddressInfo> mProvinceCityDistrictList = new MutableLiveData<>();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AddressBean> addressBean = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/compat/page/personal/ModifyAddressVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/base/bean/AddressInfo;", "data", "", "onCCSuccess", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<AddressInfo> {
        public a() {
            super(ModifyAddressVM.this, true);
        }

        public void onCCSuccess(@Nullable AddressInfo data) {
            if (data != null) {
                ModifyAddressVM.this.k().setValue(data);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/compat/page/personal/ModifyAddressVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<Object> {
        public b() {
            super(ModifyAddressVM.this, true);
        }

        public void onCCSuccess(@Nullable Object data) {
            fv5.b("修改成功");
            ModifyAddressVM.this.h.setValue(Boolean.TRUE);
        }
    }

    @NotNull
    public final MutableLiveData<AddressBean> h() {
        return this.addressBean;
    }

    @NotNull
    public final MutableLiveData<String> i() {
        return this.detailAddress;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.location;
    }

    @NotNull
    public final MutableLiveData<AddressInfo> k() {
        return this.mProvinceCityDistrictList;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> l() {
        return this.titleBean;
    }

    public final void m() {
        n76.e(this, this.baseModel.b()).p5(new a());
    }

    public final void n(@Nullable AddressBean addressBean) {
        if (addressBean == null) {
            return;
        }
        n76.e(this, this.mode.o(null, null, null, addressBean, null, null)).p5(new b());
    }
}
