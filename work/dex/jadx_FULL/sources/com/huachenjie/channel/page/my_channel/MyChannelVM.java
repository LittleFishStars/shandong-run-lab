package com.huachenjie.channel.page.my_channel;

import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelDetail;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/MyChannelVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", "m", "i", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/bean/my_channel/MyChannelDetail;", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "channelDetail", "", "b", "k", "cancelFlag", "Lcom/bumptech/glide/request/RequestOptions;", "Lcom/bumptech/glide/request/RequestOptions;", "j", "()Lcom/bumptech/glide/request/RequestOptions;", "bgOption", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class MyChannelVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final RequestOptions bgOption;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<MyChannelDetail> channelDetail = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> cancelFlag = new MutableLiveData<>();

    public MyChannelVM() {
        RequestOptions requestOptions = new RequestOptions();
        int i = R.drawable.channel_bg_my_channel;
        RequestOptions requestOptionsDiskCacheStrategy = requestOptions.placeholder(i).error(i).diskCacheStrategy(DiskCacheStrategy.ALL);
        Intrinsics.checkNotNullExpressionValue(requestOptionsDiskCacheStrategy, "RequestOptions()\n       …gy(DiskCacheStrategy.ALL)");
        this.bgOption = requestOptionsDiskCacheStrategy;
    }

    public final void i(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new MyChannelVM$cancelChannel$1(channelNo, this, null), 14, null);
    }

    @NotNull
    /* JADX INFO: renamed from: j, reason: from getter */
    public final RequestOptions getBgOption() {
        return this.bgOption;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.cancelFlag;
    }

    @NotNull
    public final MutableLiveData<MyChannelDetail> l() {
        return this.channelDetail;
    }

    public final void m(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.my_channel.MyChannelVM$queryChannelDetail$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (resultException.getCode() == 2999) {
                    this.this$0.k().setValue(Boolean.TRUE);
                }
                return Boolean.FALSE;
            }
        }, null, new MyChannelVM$queryChannelDetail$2(channelNo, this, null), 11, null);
    }
}
