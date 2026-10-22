package com.huachenjie.compat.page.settings;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.NotifyConfig;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/compat/page/settings/PushSettingViewModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "n", j.b, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/compat/page/settings/PushSettingAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "c", "m", "updateFlag", "", "Lcom/huachenjie/base/bean/NotifyConfig;", "a", "Ljava/util/List;", "notifyConfigList", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class PushSettingViewModel extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public List<NotifyConfig> notifyConfigList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PushSettingAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> updateFlag = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<PushSettingAdapter> l() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.updateFlag;
    }

    public final void n() {
        BaseViewModelExtKt.b(this, true, false, null, null, new PushSettingViewModel$loadData$1(this, null), 14, null);
    }

    public final void o() {
        if (this.notifyConfigList == null) {
            return;
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new PushSettingViewModel$saveData$1(this, null), 14, null);
    }
}
