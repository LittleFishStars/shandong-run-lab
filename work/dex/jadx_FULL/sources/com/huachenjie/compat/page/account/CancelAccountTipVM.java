package com.huachenjie.compat.page.account;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/compat/page/account/CancelAccountTipVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "k", "(Landroidx/lifecycle/MutableLiveData;)V", "titleBean", "", "kotlin.jvm.PlatformType", "j", y6b.g, "mAgreement", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class CancelAccountTipVM extends BaseVM {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> mAgreement = new MutableLiveData<>(Boolean.FALSE);

    @NotNull
    public final MutableLiveData<Boolean> h() {
        return this.mAgreement;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> i() {
        return this.titleBean;
    }

    public final void j(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mAgreement = mutableLiveData;
    }

    public final void k(@NotNull MutableLiveData<BindingTitleBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.titleBean = mutableLiveData;
    }
}
