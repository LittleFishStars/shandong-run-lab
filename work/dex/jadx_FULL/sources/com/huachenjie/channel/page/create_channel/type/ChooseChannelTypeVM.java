package com.huachenjie.channel.page.create_channel.type;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/channel/page/create_channel/type/ChooseChannelTypeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/channel/page/create_channel/type/ChooseChannelTypeAdapter;", "b", "i", "adapter", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseChannelTypeVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChooseChannelTypeAdapter> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ChooseChannelTypeAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> j() {
        return this.titleBean;
    }

    public final void k() {
        BaseViewModelExtKt.b(this, true, false, null, null, new ChooseChannelTypeVM$loadData$1(this, null), 14, null);
    }
}
