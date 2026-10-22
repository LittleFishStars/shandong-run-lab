package com.huachenjie.social_contact.page.suit;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.GameBean;
import com.huachenjie.social_contact.bean.GameDataBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR%\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearGameVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "k", "Lcom/huachenjie/social_contact/bean/GameBean;", "item", t.d, "m", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "mUniverseModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/social_contact/page/suit/UserWearGameAdapter;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", y6b.g, "()Landroidx/lifecycle/MutableLiveData;", "adapter", "j", "unlockFlag", "wearFlag", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearGameVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public UniverseModel mUniverseModel = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<UserWearGameAdapter> adapter = new MutableLiveData<>(new UserWearGameAdapter());

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GameBean> unlockFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GameBean> wearFlag = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearGameVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/GameDataBean;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<GameDataBean> {
        public a() {
            super(UserWearGameVM.this, true);
        }

        public void onCCSuccess(@Nullable GameDataBean data) {
            UserWearGameAdapter value;
            if (data == null || (value = UserWearGameVM.this.h().getValue()) == null) {
                return;
            }
            value.setList(data.getGameIconList());
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearGameVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameBean f36306a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GameBean gameBean) {
            super(UserWearGameVM.this, true);
            this.f36306a = gameBean;
        }

        public void onCCSuccess(@Nullable Object data) {
            UserWearGameAdapter value = UserWearGameVM.this.h().getValue();
            if (value != null) {
                value.f(this.f36306a);
            }
            UserWearGameVM.this.i().setValue(this.f36306a);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/suit/UserWearGameVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameBean f36307a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GameBean gameBean) {
            super(UserWearGameVM.this, true);
            this.f36307a = gameBean;
        }

        public void onCCSuccess(@Nullable Object data) {
            UserWearGameAdapter value = UserWearGameVM.this.h().getValue();
            if (value != null) {
                value.e(this.f36307a);
            }
            UserWearGameVM.this.j().setValue(this.f36307a);
        }
    }

    @NotNull
    public final MutableLiveData<UserWearGameAdapter> h() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<GameBean> i() {
        return this.unlockFlag;
    }

    @NotNull
    public final MutableLiveData<GameBean> j() {
        return this.wearFlag;
    }

    public final void k() {
        n76.e(this, this.mUniverseModel.u()).p5(new a());
    }

    public final void l(@NotNull GameBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        n76.e(this, this.mUniverseModel.D(item.getMetaverseGameIconCode())).p5(new b(item));
    }

    public final void m(@NotNull GameBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        n76.e(this, this.mUniverseModel.G(item.getMetaverseGameIconCode())).p5(new c(item));
    }
}
