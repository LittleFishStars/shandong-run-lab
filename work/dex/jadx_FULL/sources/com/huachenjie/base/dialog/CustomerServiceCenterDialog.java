package com.huachenjie.base.dialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import com.huachenjie.base.R;
import com.huachenjie.base.bean.CommonSwitchConfig;
import com.huachenjie.base.dialog.CustomerServiceCenterDialog;
import com.huachenjie.common.reconfig.baseView.BaseBottomDialogFragment;
import com.zj.adlib.dq1;
import com.zj.adlib.su9;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/base/dialog/CustomerServiceCenterDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseBottomDialogFragment;", "", "getWidth", "getHeight", "getLayoutResID", "", "initView", "Lkotlin/Function0;", "onClickOfficial", "Lkotlin/jvm/functions/Function0;", "<init>", "()V", "Companion", "a", "base_release"}, k = 1, mv = {1, 8, 0})
public final class CustomerServiceCenterDialog extends BaseBottomDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private Function0<Unit> onClickOfficial;

    /* JADX INFO: renamed from: com.huachenjie.base.dialog.CustomerServiceCenterDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\n"}, d2 = {"Lcom/huachenjie/base/dialog/CustomerServiceCenterDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lkotlin/Function0;", "", "onClickOfficial", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull Function0<Unit> onClickOfficial) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(onClickOfficial, "onClickOfficial");
            CustomerServiceCenterDialog customerServiceCenterDialog = new CustomerServiceCenterDialog();
            customerServiceCenterDialog.onClickOfficial = onClickOfficial;
            customerServiceCenterDialog.show(fragmentManager, Reflection.getOrCreateKotlinClass(CustomerServiceCenterDialog.class).getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CustomerServiceCenterDialog customerServiceCenterDialog, View view) {
        Intrinsics.checkNotNullParameter(customerServiceCenterDialog, "this$0");
        customerServiceCenterDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(CustomerServiceCenterDialog customerServiceCenterDialog, View view) {
        String dedicatedSupportLinkUrl;
        Intrinsics.checkNotNullParameter(customerServiceCenterDialog, "this$0");
        CommonSwitchConfig commonSwitchConfigD = dq1.d();
        if (commonSwitchConfigD != null && (dedicatedSupportLinkUrl = commonSwitchConfigD.getDedicatedSupportLinkUrl()) != null) {
            su9.q(customerServiceCenterDialog.requireContext(), dedicatedSupportLinkUrl);
        }
        customerServiceCenterDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(CustomerServiceCenterDialog customerServiceCenterDialog, View view) {
        Intrinsics.checkNotNullParameter(customerServiceCenterDialog, "this$0");
        Function0<Unit> function0 = customerServiceCenterDialog.onClickOfficial;
        if (function0 != null) {
            function0.invoke();
        }
        customerServiceCenterDialog.dismissAllowingStateLoss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.dialog_customer_service_center;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ImageView imageView;
        super.initView();
        View view = getView();
        if (view != null && (imageView = (ImageView) view.findViewById(R.id.iv_close)) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wz1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CustomerServiceCenterDialog.initView$lambda$0(this.f45718a, view2);
                }
            });
        }
        View view2 = getView();
        if (view2 != null && (linearLayout2 = (LinearLayout) view2.findViewById(R.id.ll_girl)) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.xz1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    CustomerServiceCenterDialog.initView$lambda$2(this.f45924a, view3);
                }
            });
        }
        View view3 = getView();
        if (view3 == null || (linearLayout = (LinearLayout) view3.findViewById(R.id.ll_boy)) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.yz1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                CustomerServiceCenterDialog.initView$lambda$3(this.f46146a, view4);
            }
        });
    }
}
