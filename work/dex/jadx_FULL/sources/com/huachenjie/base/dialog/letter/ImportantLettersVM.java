package com.huachenjie.base.dialog.letter;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/base/dialog/letter/ImportantLettersVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "code", "", "i", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "skipNext", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ImportantLettersVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> skipNext = new MutableLiveData<>(Boolean.FALSE);

    public final void i(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        BaseViewModelExtKt.b(this, true, false, null, null, new ImportantLettersVM$getImportantLetterList$1(code, this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.skipNext;
    }
}
