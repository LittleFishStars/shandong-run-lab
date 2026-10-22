package com.huachenjie.run.page.activities_run.dialog;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.run.R;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002R%\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/run/page/activities_run/dialog/DanmuDialogVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/run/page/activities_run/dialog/DanmuDialogAdapter;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "<set-?>", "Z", "k", "()Z", "hasBrandFirstRow", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class DanmuDialogVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<DanmuDialogAdapter> adapter = new MutableLiveData<>(new DanmuDialogAdapter(R.layout.run_item_danmu));

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean hasBrandFirstRow;

    @NotNull
    public final MutableLiveData<DanmuDialogAdapter> j() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final boolean getHasBrandFirstRow() {
        return this.hasBrandFirstRow;
    }

    public final void l() {
        BaseViewModelExtKt.b(this, false, false, null, null, new DanmuDialogVM$loadDefaultBarrage$1(this, null), 15, null);
    }
}
