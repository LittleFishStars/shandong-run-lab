package com.huachenjie.channel.page.my_channel.organize;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.zj.adlib.j64;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R#\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00188\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize/OrganizeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", j.b, "m", "Lcom/huachenjie/channel/bean/OrganizeTeamBean;", "team", "Lcom/netease/nimlib/sdk/msg/model/RecentContact;", "recent", "p", "n", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/my_channel/organize/OrganizeAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "K", "I", "pageNum", "", "Ljava/util/Map;", t.d, "()Ljava/util/Map;", "chatMap", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<OrganizeAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Map<String, OrganizeTeamBean> chatMap = new LinkedHashMap();

    @NotNull
    public final MutableLiveData<OrganizeAdapter> k() {
        return this.adapter;
    }

    @NotNull
    public final Map<String, OrganizeTeamBean> l() {
        return this.chatMap;
    }

    public final void m(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        n(channelNo);
    }

    public final void n(String channelNo) {
        if (this.pageNum == 1) {
            this.chatMap.clear();
        }
        BaseViewModelExtKt.b(this, false, false, null, null, new OrganizeVM$queryChannelClubList$1(channelNo, this, null), 15, null);
    }

    public final void o(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        this.pageNum = 1;
        n(channelNo);
    }

    public final void p(@NotNull OrganizeTeamBean team, @NotNull RecentContact recent) {
        Intrinsics.checkNotNullParameter(team, "team");
        Intrinsics.checkNotNullParameter(recent, "recent");
        String strB = j64.b(recent.getMsgType(), recent.getContent(), recent.getAttachment(), Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(strB, "convertMessageContent(\n …          false\n        )");
        team.setMessage(strB);
        team.setMessageCount(recent.getUnreadCount());
    }
}
