package com.huachenjie.channel.page.add_friend;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.adapter.AddFriendAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/channel/page/add_friend/AddFriendVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/adapter/AddFriendAdapter;", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "C", "(Landroidx/lifecycle/MutableLiveData;)V", "adapter", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AddFriendVM extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<AddFriendAdapter> adapter = new MutableLiveData<>(new AddFriendAdapter());

    @NotNull
    public final MutableLiveData<AddFriendAdapter> B() {
        return this.adapter;
    }

    public final void C(@NotNull MutableLiveData<AddFriendAdapter> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.adapter = mutableLiveData;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, isRefreshData, false, q(), null, new AddFriendVM$loadMoreData$1(this, null), 10, null);
    }
}
