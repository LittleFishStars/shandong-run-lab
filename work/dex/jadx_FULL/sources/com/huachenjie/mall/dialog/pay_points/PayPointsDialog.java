package com.huachenjie.mall.dialog.pay_points;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallDialogPayPointsBinding;
import com.zj.adlib.hk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0011\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/mall/dialog/pay_points/PayPointsDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/mall/databinding/MallDialogPayPointsBinding;", "Lcom/huachenjie/mall/dialog/pay_points/PayPointsVM;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "", "initData", "payPoints$delegate", "Lkotlin/Lazy;", "getPayPoints", "()I", "payPoints", "Lkotlin/Function0;", "onPaySureCallback", "Lkotlin/jvm/functions/Function0;", "<init>", "()V", "Companion", "a", "b", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class PayPointsDialog extends BaseMVVMBottomDialogFragment<MallDialogPayPointsBinding, PayPointsVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_PAY_POINTS = "pay_points";

    @Nullable
    private Function0<Unit> onPaySureCallback;

    /* JADX INFO: renamed from: payPoints$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy payPoints = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.dialog.pay_points.PayPointsDialog$payPoints$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m472invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("pay_points") : 0);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/dialog/pay_points/PayPointsDialog$a;", "", "Landroid/view/View;", "v", "", "a", "view", "b", "<init>", "(Lcom/huachenjie/mall/dialog/pay_points/PayPointsDialog;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            PayPointsDialog.this.dismiss();
        }

        public final void b(@Nullable View view) {
            Function0 function0 = PayPointsDialog.this.onPaySureCallback;
            if (function0 != null) {
                function0.invoke();
            }
            PayPointsDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.dialog.pay_points.PayPointsDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/dialog/pay_points/PayPointsDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "payPoints", "Lkotlin/Function0;", "", "onPaySure", "a", "", "KEY_PAY_POINTS", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, int payPoints, @NotNull Function0<Unit> onPaySure) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(onPaySure, "onPaySure");
            PayPointsDialog payPointsDialog = new PayPointsDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(PayPointsDialog.KEY_PAY_POINTS, payPoints);
            payPointsDialog.setArguments(bundle);
            payPointsDialog.onPaySureCallback = onPaySure;
            payPointsDialog.show(fragmentManager, "PayPointsDialog");
        }
    }

    private final int getPayPoints() {
        return ((Number) this.payPoints.getValue()).intValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_dialog_pay_points;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        ((PayPointsVM) getMViewModel()).i().setValue(Integer.valueOf(getPayPoints()));
    }
}
