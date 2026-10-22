package com.huachenjie.social_contact.page.suit;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.SuitDataBean;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearSuitVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "metaverseModelCode", "", "i", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "mUniverseModel", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/huachenjie/social_contact/bean/SuitDataBean;", "Landroidx/lifecycle/MutableLiveData;", y6b.g, "()Landroidx/lifecycle/MutableLiveData;", "suitModeList", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearSuitVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public UniverseModel mUniverseModel = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<SuitDataBean>> suitModeList = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearSuitVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "Lcom/huachenjie/social_contact/bean/SuitDataBean;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<List<? extends SuitDataBean>> {
        public a() {
            super(UserWearSuitVM.this, true);
        }

        public void onCCSuccess(@Nullable List<SuitDataBean> data) {
            if (data != null) {
                UserWearSuitVM.this.h().setValue(data);
            }
        }
    }

    @NotNull
    public final MutableLiveData<List<SuitDataBean>> h() {
        return this.suitModeList;
    }

    public final void i(@NotNull String metaverseModelCode) {
        Intrinsics.checkNotNullParameter(metaverseModelCode, "metaverseModelCode");
        n76.e(this, this.mUniverseModel.o(metaverseModelCode)).p5(new a());
    }
}
