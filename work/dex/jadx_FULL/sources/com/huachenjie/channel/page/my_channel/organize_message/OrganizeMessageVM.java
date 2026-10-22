package com.huachenjie.channel.page.my_channel.organize_message;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.bean.ClubMessageBean;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u00158\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_message/OrganizeMessageVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "", "position", "B", "", y6b.f, "Ljava/lang/String;", "D", "()Ljava/lang/String;", "F", "(Ljava/lang/String;)V", "channelNo", y6b.g, "E", "G", "clubCode", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/my_channel/organize_message/OrganizeMessageAdapter;", "kotlin.jvm.PlatformType", "f", "Landroidx/lifecycle/MutableLiveData;", "C", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeMessageVM extends BaseStateRequestModel {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String channelNo = "";

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public String clubCode = "";

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrganizeMessageAdapter> adapter = new MutableLiveData<>(new OrganizeMessageAdapter());

    public final void B(int position) {
        List<ClubMessageBean> data;
        ClubMessageBean clubMessageBean;
        OrganizeMessageAdapter value = this.adapter.getValue();
        if (value == null || (data = value.getData()) == null || (clubMessageBean = (ClubMessageBean) CollectionsKt.getOrNull(data, position)) == null) {
            return;
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new OrganizeMessageVM$deleteMessage$1(clubMessageBean, this, position, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<OrganizeMessageAdapter> C() {
        return this.adapter;
    }

    @NotNull
    /* JADX INFO: renamed from: D, reason: from getter */
    public final String getChannelNo() {
        return this.channelNo;
    }

    @NotNull
    /* JADX INFO: renamed from: E, reason: from getter */
    public final String getClubCode() {
        return this.clubCode;
    }

    public final void F(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelNo = str;
    }

    public final void G(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clubCode = str;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, isRefreshData, false, q(), null, new OrganizeMessageVM$loadMoreData$1(this, null), 10, null);
    }
}
