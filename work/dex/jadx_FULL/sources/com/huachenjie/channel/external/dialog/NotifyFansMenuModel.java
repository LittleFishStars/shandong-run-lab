package com.huachenjie.channel.external.dialog;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/external/dialog/NotifyFansMenuModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/external/bean/FansBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "fansBean", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class NotifyFansMenuModel extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<FansBean> fansBean = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<FansBean> i() {
        return this.fansBean;
    }
}
