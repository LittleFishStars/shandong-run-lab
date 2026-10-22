package com.huachenjie.channel.page.all_organize;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.adapter.AllOrMyOrganizeAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/channel/page/all_organize/AllOrganizeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "channelNo", "", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/adapter/AllOrMyOrganizeAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "K", "I", "k", "()I", "m", "(I)V", "pageNum", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AllOrganizeVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AllOrMyOrganizeAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    @NotNull
    public final MutableLiveData<AllOrMyOrganizeAdapter> j() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    public final void l(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, false, false, null, null, new AllOrganizeVM$loadData$1(this, channelNo, null), 15, null);
    }

    public final void m(int i) {
        this.pageNum = i;
    }
}
