package com.huachenjie.base.dialog.inspiration;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR%\u0010\b\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R%\u0010\f\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\t0\t0\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/base/dialog/inspiration/InspirationVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "title", "", "j", y6b.g, "inspirationValue", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class InspirationVM extends BaseVM {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> title = new MutableLiveData<>("");

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> inspirationValue = new MutableLiveData<>(0);

    @NotNull
    public final MutableLiveData<Integer> h() {
        return this.inspirationValue;
    }

    @NotNull
    public final MutableLiveData<String> i() {
        return this.title;
    }
}
