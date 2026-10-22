package com.huachenjie.home.dialog.task;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.ad.interfaces.RewardVideoAdListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.databinding.HomeDialogDoubleRewardBinding;
import com.igexin.push.g.o;
import com.zj.adlib.ew;
import com.zj.adlib.fv5;
import com.zj.adlib.fx7;
import com.zj.adlib.r90;
import com.zj.adlib.vb8;
import com.zj.adlib.xk0;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016RH\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/home/dialog/task/DoubleRewardDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/home/databinding/HomeDialogDoubleRewardBinding;", "Lcom/huachenjie/home/dialog/task/DoubleRewardVM;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "", "initDataObserve", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "forceClose", "isDouble", RenderCallContext.TYPE_CALLBACK, "Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Companion", "a", "b", "home_release"}, k = 1, mv = {1, 8, 0})
public final class DoubleRewardDialog extends BaseMVVMDialogFragment<HomeDialogDoubleRewardBinding, DoubleRewardVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Function2<? super Boolean, ? super Boolean, Unit> callback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/home/dialog/task/DoubleRewardDialog$a;", "", "Landroid/view/View;", "view", "", "a", "b", "<init>", "(Lcom/huachenjie/home/dialog/task/DoubleRewardDialog;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.home.dialog.task.DoubleRewardDialog$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"com/huachenjie/home/dialog/task/DoubleRewardDialog$a$a", "Lcom/huachenjie/ad/interfaces/RewardVideoAdListener;", "", "loadSupplier", "", "platform", "", "e", "code", "message", "c", "d", "b", "", "a", "Z", "isReward", "home_release"}, k = 1, mv = {1, 8, 0})
        public static final class C0803a extends RewardVideoAdListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DoubleRewardDialog f34323a;

            /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
            public boolean isReward;

            public C0803a(DoubleRewardDialog doubleRewardDialog) {
                this.f34323a = doubleRewardDialog;
            }

            @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
            public void b(int loadSupplier) {
                DoubleRewardDialog.access$getMViewModel(this.f34323a).c();
                Function2 function2 = this.f34323a.callback;
                if (function2 != null) {
                    function2.invoke(Boolean.FALSE, Boolean.valueOf(this.isReward));
                }
                this.f34323a.dismissAllowingStateLoss();
            }

            @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
            public void c(int loadSupplier, @Nullable String code, @Nullable String message) {
                this.isReward = false;
                DoubleRewardDialog.access$getMViewModel(this.f34323a).c();
                fv5.b("广告加载失败，请稍后再试");
            }

            @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
            public void d(int loadSupplier, @Nullable String platform) {
                this.isReward = true;
            }

            @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
            public void e(int loadSupplier, @Nullable String platform) {
                DoubleRewardDialog.access$getMViewModel(this.f34323a).c();
            }
        }

        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Function2 function2 = DoubleRewardDialog.this.callback;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, Boolean.FALSE);
            }
            DoubleRewardDialog.this.dismissAllowingStateLoss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            DoubleRewardDialog.access$getMViewModel(DoubleRewardDialog.this).g();
            ew.j().i(vb8.j, DoubleRewardDialog.this.requireActivity(), DoubleRewardDialog.this.getLifecycle(), new C0803a(DoubleRewardDialog.this));
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.home.dialog.task.DoubleRewardDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ(\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/home/dialog/task/DoubleRewardDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function2;", "", "", RenderCallContext.TYPE_CALLBACK, "a", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull Function2<? super Boolean, ? super Boolean, Unit> callback) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            DoubleRewardDialog doubleRewardDialog = new DoubleRewardDialog();
            doubleRewardDialog.setCancelable(false);
            doubleRewardDialog.callback = callback;
            doubleRewardDialog.show(fragmentManager, Reflection.getOrCreateKotlinClass(DoubleRewardDialog.class).getSimpleName());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34324a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34324a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34324a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34324a.invoke(obj);
        }
    }

    public static final /* synthetic */ DoubleRewardVM access$getMViewModel(DoubleRewardDialog doubleRewardDialog) {
        return doubleRewardDialog.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_dialog_double_reward;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - (SizeUtils.b(38.0f) * 2);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        super.initDataObserve();
        getMViewModel().i().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.home.dialog.task.DoubleRewardDialog.initDataObserve.1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                r90.Q(bool.booleanValue() ? LocalDate.now().atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() : System.currentTimeMillis());
            }
        }));
    }
}
