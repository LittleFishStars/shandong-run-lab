package com.huachenjie.run.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.AlipayBindTipDialog;
import com.zj.adlib.fx7;
import com.zj.adlib.h40;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/huachenjie/run/dialog/AlipayBindTipDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "", "getWidth", "getHeight", "getLayoutResID", "", "initView", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class AlipayBindTipDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.AlipayBindTipDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/dialog/AlipayBindTipDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/huachenjie/run/dialog/AlipayBindTipDialog;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AlipayBindTipDialog a(@NotNull FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            AlipayBindTipDialog alipayBindTipDialog = new AlipayBindTipDialog();
            alipayBindTipDialog.show(fragmentManager, Reflection.getOrCreateKotlinClass(AlipayBindTipDialog.class).getSimpleName());
            return alipayBindTipDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(AlipayBindTipDialog alipayBindTipDialog, View view) {
        Intrinsics.checkNotNullParameter(alipayBindTipDialog, "this$0");
        alipayBindTipDialog.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(AlipayBindTipDialog alipayBindTipDialog, View view) {
        Intrinsics.checkNotNullParameter(alipayBindTipDialog, "this$0");
        Context contextRequireContext = alipayBindTipDialog.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        h40.a(contextRequireContext);
        alipayBindTipDialog.dismissAllowingStateLoss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_alipay_bind_tip;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - SizeUtils.b(76.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        TextView textView;
        TextView textView2;
        super.initView();
        setCancelable(false);
        View view = getView();
        if (view != null && (textView2 = (TextView) view.findViewById(R.id.tv_close)) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.f40
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AlipayBindTipDialog.initView$lambda$0(this.f41589a, view2);
                }
            });
        }
        View view2 = getView();
        if (view2 == null || (textView = (TextView) view2.findViewById(R.id.tv_bind)) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.g40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                AlipayBindTipDialog.initView$lambda$1(this.f41816a, view3);
            }
        });
    }
}
