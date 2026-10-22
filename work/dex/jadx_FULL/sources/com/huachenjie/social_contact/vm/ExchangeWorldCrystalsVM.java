package com.huachenjie.social_contact.vm;

import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.CrystalPageInfo;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/social_contact/vm/ExchangeWorldCrystalsVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "isExchange", "", "i", y6b.g, "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", t.d, "()Lcom/huachenjie/social_contact/api/UniverseModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/social_contact/bean/CrystalPageInfo;", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "n", "(Landroidx/lifecycle/MutableLiveData;)V", AliyunLogCommon.LogLevel.INFO, "j", "m", "exchangeSuccess", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class ExchangeWorldCrystalsVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final UniverseModel model = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<CrystalPageInfo> info = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> exchangeSuccess = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/vm/ExchangeWorldCrystalsVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<Object> {
        public a() {
            super(ExchangeWorldCrystalsVM.this, true);
        }

        public void onCCSuccess(@Nullable Object data) {
            ExchangeWorldCrystalsVM.this.i(true);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014¨\u0006\f"}, d2 = {"com/huachenjie/social_contact/vm/ExchangeWorldCrystalsVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/CrystalPageInfo;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "onFinish", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nExchangeWorldCrystalsVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExchangeWorldCrystalsVM.kt\ncom/huachenjie/social_contact/vm/ExchangeWorldCrystalsVM$getExchangeCrystalPageInfo$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
    public static final class b extends DialogVMSubscriber<CrystalPageInfo> {
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z) {
            super(ExchangeWorldCrystalsVM.this, true);
            this.c = z;
        }

        public void onFailed(int code, @Nullable String message) {
            if (!this.c) {
                super.onFailed(code, message);
                return;
            }
            CrystalPageInfo value = ExchangeWorldCrystalsVM.this.k().getValue();
            if (value != null) {
                ExchangeWorldCrystalsVM exchangeWorldCrystalsVM = ExchangeWorldCrystalsVM.this;
                value.setStarDrill(value.getStarDrill() - value.getStarStone());
                value.setExchangeNum(value.getExchangeNum() - 1);
                exchangeWorldCrystalsVM.k().setValue(value);
            }
        }

        public void onFinish() {
            ExchangeWorldCrystalsVM.this.j().setValue(Boolean.valueOf(this.c));
        }

        public void onCCSuccess(@Nullable CrystalPageInfo data) {
            if (data != null) {
                ExchangeWorldCrystalsVM.this.k().setValue(data);
            }
        }
    }

    public final void h() {
        n76.e(this, this.model.g()).p5(new a());
    }

    public final void i(boolean isExchange) {
        n76.e(this, this.model.h()).p5(new b(isExchange));
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.exchangeSuccess;
    }

    @NotNull
    public final MutableLiveData<CrystalPageInfo> k() {
        return this.info;
    }

    @NotNull
    /* JADX INFO: renamed from: l, reason: from getter */
    public final UniverseModel getModel() {
        return this.model;
    }

    public final void m(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.exchangeSuccess = mutableLiveData;
    }

    public final void n(@NotNull MutableLiveData<CrystalPageInfo> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.info = mutableLiveData;
    }
}
