package com.huachenjie.channel.page.manage_channel.basic;

import android.content.Context;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.bean.ChannelBasicInfo;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/basic/ManageBasicInfoVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", t.d, "Landroid/content/Context;", "context", "m", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/bean/ChannelBasicInfo;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "channelBasicInfo", "b", "j", "channelName", "", "c", "k", "updateFlag", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageBasicInfoVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChannelBasicInfo> channelBasicInfo = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> channelName = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> updateFlag = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ChannelBasicInfo> i() {
        return this.channelBasicInfo;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.channelName;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.updateFlag;
    }

    public final void l(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new ManageBasicInfoVM$loadData$1(channelNo, this, null), 14, null);
    }

    public final void m(@NotNull Context context, @NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoVM$saveData$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.c();
                return Boolean.FALSE;
            }
        }, null, new ManageBasicInfoVM$saveData$2(this, channelNo, context, null), 11, null);
    }
}
