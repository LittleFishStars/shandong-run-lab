package com.huachenjie.channel.page.notify.base;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR%\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/notify/base/BaseNotifyNextModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public class BaseNotifyNextModel extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BaseQuickAdapter<?, ?>> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<BaseQuickAdapter<?, ?>> B() {
        return this.adapter;
    }
}
