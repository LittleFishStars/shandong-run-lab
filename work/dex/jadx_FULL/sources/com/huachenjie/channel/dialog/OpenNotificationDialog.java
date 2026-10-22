package com.huachenjie.channel.dialog;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelDialogOpenNotificationBinding;
import com.huachenjie.channel.dialog.OpenNotificationDialog;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.zj.adlib.r90;
import com.zj.adlib.t47;
import com.zj.adlib.tk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/channel/dialog/OpenNotificationDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/channel/databinding/ChannelDialogOpenNotificationBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "getWidth", "getHeight", "getLayoutResID", "", "getVariables", "", "onStart", "initView", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OpenNotificationDialog extends BaseMVVMDialogFragment<ChannelDialogOpenNotificationBinding, BaseViewModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.channel.dialog.OpenNotificationDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/channel/dialog/OpenNotificationDialog$a;", "", "Lcom/huachenjie/channel/dialog/OpenNotificationDialog;", "a", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OpenNotificationDialog a() {
            return new OpenNotificationDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(OpenNotificationDialog openNotificationDialog, View view) {
        Intrinsics.checkNotNullParameter(openNotificationDialog, "this$0");
        r90.c0();
        openNotificationDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$2(OpenNotificationDialog openNotificationDialog, View view) {
        Intrinsics.checkNotNullParameter(openNotificationDialog, "this$0");
        r90.c0();
        openNotificationDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(OpenNotificationDialog openNotificationDialog, View view) {
        Intrinsics.checkNotNullParameter(openNotificationDialog, "this$0");
        t47.e(view.getContext());
        openNotificationDialog.dismiss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_dialog_open_notification;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, BaseViewModel> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        View view = getView();
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.da6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OpenNotificationDialog.initView$lambda$1(this.f41140a, view2);
                }
            });
        }
        ChannelDialogOpenNotificationBinding mBinding = getMBinding();
        if (mBinding != null) {
            mBinding.f7741a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ea6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OpenNotificationDialog.initView$lambda$4$lambda$2(this.f41391a, view2);
                }
            });
            mBinding.f7742b.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.fa6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OpenNotificationDialog.initView$lambda$4$lambda$3(this.f41633a, view2);
                }
            });
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.getAttributes().dimAmount = 0.0f;
        window.setAttributes(window.getAttributes());
    }
}
