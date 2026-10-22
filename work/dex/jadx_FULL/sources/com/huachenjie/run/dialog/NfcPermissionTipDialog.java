package com.huachenjie.run.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.NfcPermissionTipDialog;
import com.zj.adlib.fx7;
import com.zj.adlib.yy5;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/run/dialog/NfcPermissionTipDialog;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "", "closeIfEnabled", "", "refreshNfcStatus", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "", "getWidth", "getHeight", "getLayoutResID", "initView", "Landroid/widget/TextView;", "tvStatus", "Landroid/widget/TextView;", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nNfcPermissionTipDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NfcPermissionTipDialog.kt\ncom/huachenjie/run/dialog/NfcPermissionTipDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,81:1\n1#2:82\n*E\n"})
public final class NfcPermissionTipDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private TextView tvStatus;

    /* JADX INFO: renamed from: com.huachenjie.run.dialog.NfcPermissionTipDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/dialog/NfcPermissionTipDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/huachenjie/run/dialog/NfcPermissionTipDialog;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final NfcPermissionTipDialog a(@NotNull FragmentManager fragmentManager) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            NfcPermissionTipDialog nfcPermissionTipDialog = new NfcPermissionTipDialog();
            nfcPermissionTipDialog.show(fragmentManager, Reflection.getOrCreateKotlinClass(NfcPermissionTipDialog.class).getSimpleName());
            return nfcPermissionTipDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(NfcPermissionTipDialog nfcPermissionTipDialog, View view) {
        Intrinsics.checkNotNullParameter(nfcPermissionTipDialog, "this$0");
        nfcPermissionTipDialog.refreshNfcStatus(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(NfcPermissionTipDialog nfcPermissionTipDialog, View view) {
        Intrinsics.checkNotNullParameter(nfcPermissionTipDialog, "this$0");
        Context context = nfcPermissionTipDialog.getContext();
        if (context != null) {
            yy5.d(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(NfcPermissionTipDialog nfcPermissionTipDialog, View view) {
        Intrinsics.checkNotNullParameter(nfcPermissionTipDialog, "this$0");
        nfcPermissionTipDialog.dismissAllowingStateLoss();
    }

    private final void refreshNfcStatus(boolean closeIfEnabled) {
        boolean zB = yy5.b(getContext());
        TextView textView = this.tvStatus;
        if (textView != null) {
            textView.setText(zB ? getString(R.string.run_nfc_permission_status_on) : getString(R.string.run_nfc_permission_status_off));
        }
        if (closeIfEnabled && zB) {
            dismissAllowingStateLoss();
        }
    }

    @JvmStatic
    @NotNull
    public static final NfcPermissionTipDialog show(@NotNull FragmentManager fragmentManager) {
        return INSTANCE.a(fragmentManager);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_nfc_permission_tip;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return fx7.j() - SizeUtils.b(76.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ImageView imageView;
        TextView textView;
        View viewFindViewById;
        super.initView();
        setCancelable(false);
        View view = getView();
        this.tvStatus = view != null ? (TextView) view.findViewById(R.id.tv_nfc_status) : null;
        refreshNfcStatus(false);
        View view2 = getView();
        if (view2 != null && (viewFindViewById = view2.findViewById(R.id.ll_nfc_status)) != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.vy5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    NfcPermissionTipDialog.initView$lambda$0(this.f45488a, view3);
                }
            });
        }
        View view3 = getView();
        if (view3 != null && (textView = (TextView) view3.findViewById(R.id.tv_open)) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wy5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    NfcPermissionTipDialog.initView$lambda$2(this.f45713a, view4);
                }
            });
        }
        View view4 = getView();
        if (view4 == null || (imageView = (ImageView) view4.findViewById(R.id.iv_close)) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.xy5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                NfcPermissionTipDialog.initView$lambda$3(this.f45920a, view5);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setType(1000);
        }
        Window window2 = dialogOnCreateDialog.getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.5f);
        }
        return dialogOnCreateDialog;
    }
}
