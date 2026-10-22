package com.huachenjie.channel.page.manage_channel.topic_chat;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/TopicListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "channelNo", "", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/manage_channel/topic_chat/TopicListAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class TopicListVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<TopicListAdapter> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<TopicListAdapter> j() {
        return this.adapter;
    }

    public final void k(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        BaseViewModelExtKt.b(this, false, false, null, null, new TopicListVM$loadData$1(channelNo, this, null), 15, null);
    }
}
