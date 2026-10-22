package com.huachenjie.social_contact.page.suit;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.SuitBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearSuitListVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Lcom/huachenjie/social_contact/bean/SuitBean;", "item", "", "n", "i", y6b.g, "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/social_contact/page/suit/UserWearSuitAdapter;", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", t.d, "unlockFlag", "k", "m", "wearFlag", "cancelFlag", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearSuitListVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public UniverseModel model = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<UserWearSuitAdapter> adapter = new MutableLiveData<>(new UserWearSuitAdapter());

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SuitBean> unlockFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SuitBean> wearFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SuitBean> cancelFlag = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearSuitListVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuitBean f36317a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SuitBean suitBean) {
            super(UserWearSuitListVM.this, true);
            this.f36317a = suitBean;
        }

        public void onCCSuccess(@Nullable Object data) {
            UserWearSuitAdapter value = UserWearSuitListVM.this.j().getValue();
            if (value != null) {
                value.f();
            }
            UserWearSuitListVM.this.k().setValue(this.f36317a);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearSuitListVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuitBean f36318a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SuitBean suitBean) {
            super(UserWearSuitListVM.this, true);
            this.f36318a = suitBean;
        }

        public void onCCSuccess(@Nullable Object data) {
            UserWearSuitAdapter value = UserWearSuitListVM.this.j().getValue();
            if (value != null) {
                value.g(this.f36318a);
            }
            UserWearSuitListVM.this.m().setValue(this.f36318a);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearSuitListVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuitBean f36319a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SuitBean suitBean) {
            super(UserWearSuitListVM.this, true);
            this.f36319a = suitBean;
        }

        public void onCCSuccess(@Nullable Object data) {
            UserWearSuitAdapter value = UserWearSuitListVM.this.j().getValue();
            if (value != null) {
                value.h(this.f36319a);
            }
            UserWearSuitListVM.this.l().setValue(this.f36319a);
        }
    }

    public final void h(@NotNull SuitBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        n76.e(this, this.model.c(item.getMetaverseSuitCode(), 3)).p5(new a(item));
    }

    public final void i(@NotNull SuitBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        n76.e(this, this.model.I(item.getMetaverseSuitCode())).p5(new b(item));
    }

    @NotNull
    public final MutableLiveData<UserWearSuitAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<SuitBean> k() {
        return this.cancelFlag;
    }

    @NotNull
    public final MutableLiveData<SuitBean> l() {
        return this.unlockFlag;
    }

    @NotNull
    public final MutableLiveData<SuitBean> m() {
        return this.wearFlag;
    }

    public final void n(@NotNull SuitBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        n76.e(this, this.model.E(item.getMetaverseSuitCode())).p5(new c(item));
    }
}
