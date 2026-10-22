package com.huachenjie.channel.page.manage_channel.chat;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\t8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000e¨\u0006 "}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/chat/CreateChatTeamVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "teamGroupCode", "", "i", "k", "j", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "p", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeam;", "b", "m", "chatTeam", "", "c", t.d, "addFlag", "d", j.b, "editFlag", "e", "n", "deleteFlag", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CreateChatTeamVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<MyChannelChatTeam> chatTeam = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> addFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> editFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> deleteFlag = new MutableLiveData<>();

    public final void i(@NotNull String channelNo, @NotNull String teamGroupCode) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(teamGroupCode, "teamGroupCode");
        MyChannelChatTeam value = this.chatTeam.getValue();
        if (value != null) {
            value.setTeamTitle(StringsKt.trim(value.getTeamTitle()).toString());
        }
        MyChannelChatTeam value2 = this.chatTeam.getValue();
        if (ys8.h(value2 != null ? value2.getTeamTitle() : null)) {
            fv5.b(ys8.e(R.string.channel_manage_chat_team_hint));
        } else {
            BaseViewModelExtKt.b(this, true, false, null, null, new CreateChatTeamVM$addChannelTeam$2(channelNo, teamGroupCode, this, null), 14, null);
        }
    }

    public final void j(@NotNull String channelNo, @NotNull String teamGroupCode) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(teamGroupCode, "teamGroupCode");
        BaseViewModelExtKt.b(this, true, false, null, null, new CreateChatTeamVM$deleteChannelTeam$1(channelNo, teamGroupCode, this, null), 14, null);
    }

    public final void k(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new CreateChatTeamVM$editChannelTeam$1(channelNo, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.addFlag;
    }

    @NotNull
    public final MutableLiveData<MyChannelChatTeam> m() {
        return this.chatTeam;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.deleteFlag;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.editFlag;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> p() {
        return this.titleBean;
    }
}
