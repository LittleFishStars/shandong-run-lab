package com.huachenjie.channel.page.my_channel;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelDetail;
import com.huachenjie.channel.databinding.ChannelDialogCreateSuccessBinding;
import com.huachenjie.channel.page.my_channel.CreateSuccessDialog;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.tk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0017J\b\u0010\u000e\u001a\u00020\u000bH\u0016¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/CreateSuccessDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/channel/databinding/ChannelDialogCreateSuccessBinding;", "Lcom/huachenjie/channel/page/my_channel/CreateSuccessVM;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "", "onStart", "initView", "initData", "<init>", "()V", "Companion", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CreateSuccessDialog extends BaseMVVMDialogFragment<ChannelDialogCreateSuccessBinding, CreateSuccessVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_DETAIL_DATA = "detail_data";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/CreateSuccessDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/channel/page/my_channel/CreateSuccessDialog;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", "https://mp.weixin.qq.com/s/pDJFyZy322li6JeDIOI1Gw").navigation();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.my_channel.CreateSuccessDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/CreateSuccessDialog$b;", "", "Lcom/huachenjie/channel/bean/my_channel/MyChannelDetail;", "detailData", "Lcom/huachenjie/channel/page/my_channel/CreateSuccessDialog;", "a", "", "KEY_DETAIL_DATA", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CreateSuccessDialog a(@NotNull MyChannelDetail detailData) {
            Intrinsics.checkNotNullParameter(detailData, "detailData");
            CreateSuccessDialog createSuccessDialog = new CreateSuccessDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(CreateSuccessDialog.KEY_DETAIL_DATA, detailData);
            createSuccessDialog.setArguments(bundle);
            return createSuccessDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(CreateSuccessDialog createSuccessDialog, View view) {
        Intrinsics.checkNotNullParameter(createSuccessDialog, "this$0");
        createSuccessDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$2(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_dialog_create_success;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        MyChannelDetail myChannelDetail;
        super.initData();
        Bundle arguments = getArguments();
        if (arguments == null || (myChannelDetail = (MyChannelDetail) arguments.getParcelable(KEY_DETAIL_DATA)) == null) {
            return;
        }
        getMViewModel().i().setValue(myChannelDetail);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @SuppressLint({"ClickableViewAccessibility"})
    public void initView() {
        BLRelativeLayout bLRelativeLayout;
        super.initView();
        View view = getView();
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nx1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CreateSuccessDialog.initView$lambda$1(this.f43624a, view2);
                }
            });
        }
        ChannelDialogCreateSuccessBinding mBinding = getMBinding();
        if (mBinding == null || (bLRelativeLayout = mBinding.f7731a) == null) {
            return;
        }
        bLRelativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.ox1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return CreateSuccessDialog.initView$lambda$2(view2, motionEvent);
            }
        });
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
