package com.huachenjie.mall.page.test;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/page/test/TestPlayVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "m", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/mall/page/test/TestVideoAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "Lcom/huachenjie/mall/page/test/TestVideoDetailBean;", "c", t.d, "lastPlayVideo", "", "K", "I", "k", "()I", "n", "(I)V", "currentPlayIndex", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class TestPlayVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int currentPlayIndex;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<TestVideoAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<TestVideoDetailBean> lastPlayVideo = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<TestVideoAdapter> j() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getCurrentPlayIndex() {
        return this.currentPlayIndex;
    }

    @NotNull
    public final MutableLiveData<TestVideoDetailBean> l() {
        return this.lastPlayVideo;
    }

    public final void m() {
        BaseViewModelExtKt.b(this, false, false, null, null, new TestPlayVM$queryPageList$1(this, null), 15, null);
    }

    public final void n(int i) {
        this.currentPlayIndex = i;
    }
}
