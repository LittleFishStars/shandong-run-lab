package com.huachenjie.run.dialog;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.run.adapter.GeoFenceListV2Adapter;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/dialog/AllFenceListVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/run/adapter/GeoFenceListV2Adapter;", "i", "Landroidx/lifecycle/MutableLiveData;", y6b.g, "()Landroidx/lifecycle/MutableLiveData;", "j", "(Landroidx/lifecycle/MutableLiveData;)V", "adapter", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "k", "mMySelectFence", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class AllFenceListVM extends BaseVM {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<GeoFenceListV2Adapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<GeoFenceDetail> mMySelectFence = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<GeoFenceListV2Adapter> h() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<GeoFenceDetail> i() {
        return this.mMySelectFence;
    }

    public final void j(@NotNull MutableLiveData<GeoFenceListV2Adapter> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.adapter = mutableLiveData;
    }

    public final void k(@NotNull MutableLiveData<GeoFenceDetail> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mMySelectFence = mutableLiveData;
    }
}
