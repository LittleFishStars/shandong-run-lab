package com.huachenjie.channel.page.channel_main;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.bean.AdvertiseBean;
import com.huachenjie.channel.bean.ChannelMainBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R#\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001a0\f8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0011R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0011¨\u0006#"}, d2 = {"Lcom/huachenjie/channel/page/channel_main/ChannelMainVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", "q", "r", j.b, "p", "Lcom/huachenjie/channel/bean/AdvertiseBean;", "advertiseBean", "i", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/bean/ChannelMainBean;", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "channelBean", "", "b", "n", "joinFlag", "c", "k", "cancelFlag", "", "d", "j", "adList", "e", "m", "checkAdvertiseBean", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ChannelMainVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChannelMainBean> channelBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> joinFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> cancelFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<AdvertiseBean>> adList = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AdvertiseBean> checkAdvertiseBean = new MutableLiveData<>();

    public final void i(@NotNull AdvertiseBean advertiseBean) {
        Intrinsics.checkNotNullParameter(advertiseBean, "advertiseBean");
        BaseViewModelExtKt.b(this, true, false, null, null, new ChannelMainVM$checkChannelAd$1(advertiseBean, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<List<AdvertiseBean>> j() {
        return this.adList;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.cancelFlag;
    }

    @NotNull
    public final MutableLiveData<ChannelMainBean> l() {
        return this.channelBean;
    }

    @NotNull
    public final MutableLiveData<AdvertiseBean> m() {
        return this.checkAdvertiseBean;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.joinFlag;
    }

    public final void o(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new ChannelMainVM$joinChannel$1(channelNo, this, null), 14, null);
    }

    public final void p(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new ChannelMainVM$leaveChannel$1(channelNo, this, null), 14, null);
    }

    public final void q(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new ChannelMainVM$loadData$1(channelNo, this, null), 14, null);
    }

    public final void r(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, false, false, null, null, new ChannelMainVM$queryChannelAdList$1(channelNo, this, null), 15, null);
    }
}
