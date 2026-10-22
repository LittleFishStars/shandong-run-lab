package com.huachenjie.channel.page.channel_main.organize;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.adapter.ClubMessageAdapter;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00078\u0006¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/channel/page/channel_main/organize/ChannelMainOrganizeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", t.d, "m", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/adapter/ClubMessageAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/channel/bean/OrganizeBean;", "b", "j", "channelClubPageEntity", "", "K", "I", "k", "()I", "n", "(I)V", "pageNum", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ChannelMainOrganizeVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ClubMessageAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PageEntity<OrganizeBean>> channelClubPageEntity = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    @NotNull
    public final MutableLiveData<ClubMessageAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<PageEntity<OrganizeBean>> j() {
        return this.channelClubPageEntity;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    public final void l(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, false, false, null, null, new ChannelMainOrganizeVM$loadChannelHomeClubList$1(channelNo, this, null), 15, null);
    }

    public final void m(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, false, false, null, null, new ChannelMainOrganizeVM$loadClubMessageList$1(this, channelNo, null), 15, null);
    }

    public final void n(int i) {
        this.pageNum = i;
    }
}
