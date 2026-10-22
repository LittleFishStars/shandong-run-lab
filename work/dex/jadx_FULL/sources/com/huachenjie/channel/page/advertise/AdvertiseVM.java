package com.huachenjie.channel.page.advertise;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\n\u001a\u00020\u0002H\u0002R%\u0010\u0006\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00050\u00050\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00110\u00110\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R%\u0010\u0018\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00150\u00150\u000b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00190\u00190\u000b8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR%\u0010\"\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00150\u00150\u000b8\u0006¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010¨\u0006%"}, d2 = {"Lcom/huachenjie/channel/page/advertise/AdvertiseVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "t", "r", "", "channelNo", "channelAdCode", t.d, "m", "s", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "", "c", "getType", "type", "", "d", "q", "isRefreshing", "Lcom/huachenjie/channel/page/advertise/AdvertiseAdapter;", "e", "n", "adapter", "K", "I", "pageNum", "f", "p", "finishAd", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AdvertiseVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> channelNo = new MutableLiveData<>("");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> type = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AdvertiseAdapter> adapter = new MutableLiveData<>(new AdvertiseAdapter());

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> finishAd = new MutableLiveData<>(Boolean.FALSE);

    @NotNull
    public final MutableLiveData<Integer> getType() {
        return this.type;
    }

    public final void l(@NotNull String channelNo, @NotNull String channelAdCode) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(channelAdCode, "channelAdCode");
        BaseViewModelExtKt.b(this, true, false, null, null, new AdvertiseVM$deleteChannelAd$1(channelNo, channelAdCode, this, null), 14, null);
    }

    public final void m(@NotNull String channelNo, @NotNull String channelAdCode) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(channelAdCode, "channelAdCode");
        BaseViewModelExtKt.b(this, true, false, null, null, new AdvertiseVM$finishChannelAd$1(channelNo, channelAdCode, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<AdvertiseAdapter> n() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.channelNo;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.finishAd;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.isRefreshing;
    }

    public final void r() {
        this.pageNum++;
        s();
    }

    public final void s() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.advertise.AdvertiseVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.pageNum == 1) {
                    this.this$0.q().setValue(Boolean.FALSE);
                    AdvertiseAdapter value = this.this$0.n().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    AdvertiseAdapter value2 = this.this$0.n().getValue();
                    if (value2 != null) {
                        value2.i();
                    }
                } else {
                    this.this$0.pageNum--;
                }
                AdvertiseAdapter value3 = this.this$0.n().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new AdvertiseVM$queryPageList$2(this, null), 11, null);
    }

    public final void t() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        s();
    }
}
