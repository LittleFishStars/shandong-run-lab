package com.huachenjie.channel.page.notify.buddy;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.bean.notify.BuddyDetailBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/channel/page/notify/buddy/BuddyChatRoomVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "buddyCode", "", "k", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "title", "Lcom/huachenjie/channel/bean/notify/BuddyDetailBean;", "b", "i", "buddyDetail", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class BuddyChatRoomVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> title = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BuddyDetailBean> buddyDetail = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<BuddyDetailBean> i() {
        return this.buddyDetail;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.title;
    }

    public final void k(@NotNull String buddyCode) {
        Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
        BaseViewModelExtKt.b(this, true, false, null, null, new BuddyChatRoomVM$queryBuddyDetail$1(buddyCode, this, null), 14, null);
    }
}
