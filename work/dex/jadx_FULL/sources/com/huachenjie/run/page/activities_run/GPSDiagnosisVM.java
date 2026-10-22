package com.huachenjie.run.page.activities_run;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.zj.adlib.y6b;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/run/page/activities_run/GPSDiagnosisVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "", "hasLocation", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "k", y6b.g, "addressInfo", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class GPSDiagnosisVM extends BaseVM {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> hasLocation = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<HCJAddressInfo> addressInfo = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<HCJAddressInfo> h() {
        return this.addressInfo;
    }

    @NotNull
    public final MutableLiveData<Boolean> i() {
        return this.hasLocation;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> j() {
        return this.titleBean;
    }
}
