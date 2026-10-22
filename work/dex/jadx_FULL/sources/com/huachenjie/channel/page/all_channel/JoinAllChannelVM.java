package com.huachenjie.channel.page.all_channel;

import androidx.collection.ArrayMap;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.bean.JoinAllChannelEntity;
import com.huachenjie.channel.bean.JoinChannelCategoryListBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/channel/page/all_channel/JoinAllChannelVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/bean/JoinChannelCategoryListBean;", "b", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "category", "Landroidx/collection/ArrayMap;", "", "Lcom/huachenjie/channel/bean/JoinAllChannelEntity;", "a", "Landroidx/collection/ArrayMap;", "j", "()Landroidx/collection/ArrayMap;", "cacheBeanMap", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class JoinAllChannelVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<JoinChannelCategoryListBean> category = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayMap<String, JoinAllChannelEntity> cacheBeanMap = new ArrayMap<>();

    @NotNull
    public final ArrayMap<String, JoinAllChannelEntity> j() {
        return this.cacheBeanMap;
    }

    @NotNull
    public final MutableLiveData<JoinChannelCategoryListBean> k() {
        return this.category;
    }

    public final void l() {
        BaseViewModelExtKt.b(this, true, false, null, null, new JoinAllChannelVM$queryCategory$1(this, null), 14, null);
    }
}
