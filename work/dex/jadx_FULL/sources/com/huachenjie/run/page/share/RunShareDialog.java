package com.huachenjie.run.page.share;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunDialogShareBinding;
import com.huachenjie.run.page.share.RunShareDialog;
import com.noober.background.view.BLTextView;
import com.shizhefei.view.largeimage.LargeImageView;
import com.zj.adlib.fv5;
import com.zj.adlib.lk0;
import com.zj.adlib.tw0;
import com.zj.adlib.vf3;
import com.zj.adlib.wf3;
import com.zj.adlib.y88;
import huachenjie.sdk.share.FlavourName;
import huachenjie.sdk.share.ShareListener;
import huachenjie.sdk.share.sharebody.ImageBody;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/huachenjie/run/page/share/RunShareDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/run/databinding/RunDialogShareBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "finishShare", "Lhuachenjie/sdk/share/FlavourName;", "flavour", "shareImage", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initView", "onDestroyView", "", "screenShotPath$delegate", "Lkotlin/Lazy;", "getScreenShotPath", "()Ljava/lang/String;", "screenShotPath", "Ljava/lang/Runnable;", "showSlideTipRunnable", "Ljava/lang/Runnable;", "<init>", "()V", "Companion", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunShareDialog extends BaseMVVMBottomDialogFragment<RunDialogShareBinding, BaseViewModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_SCREENSHOT_PATH = "screenshot_path";

    @NotNull
    private static final String TAG = "RunShareDialog";

    /* JADX INFO: renamed from: screenShotPath$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy screenShotPath = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.share.RunShareDialog$screenShotPath$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            String string = arguments != null ? arguments.getString("screenshot_path") : null;
            return string == null ? "" : string;
        }
    });

    @NotNull
    private final Runnable showSlideTipRunnable = new Runnable() { // from class: com.zj.adlib.vm7
        @Override // java.lang.Runnable
        public final void run() {
            RunShareDialog.showSlideTipRunnable$lambda$0(this.f45387a);
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/run/page/share/RunShareDialog$a;", "Lcom/huachenjie/run/page/share/ShareActionClick;", "Landroid/view/View;", "view", "", "c", "a", "d", "b", "<init>", "(Lcom/huachenjie/run/page/share/RunShareDialog;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a implements ShareActionClick {
        public a() {
        }

        @Override // com.huachenjie.run.page.share.ShareActionClick
        public void a(@Nullable View view) {
            if (wf3.n(RunShareDialog.this.getScreenShotPath(), RunShareDialog.this.requireContext())) {
                fv5.a(R.string.saved_succeed);
            } else {
                fv5.a(R.string.saved_failed);
            }
            RunShareDialog.this.finishShare();
        }

        @Override // com.huachenjie.run.page.share.ShareActionClick
        public void b(@Nullable View view) {
            RunShareDialog.this.shareImage(FlavourName.WX_MOMENT);
        }

        @Override // com.huachenjie.run.page.share.ShareActionClick
        public void c(@Nullable View view) {
            RunShareDialog.this.finishShare();
        }

        @Override // com.huachenjie.run.page.share.ShareActionClick
        public void d(@Nullable View view) {
            RunShareDialog.this.shareImage(FlavourName.WX_SESSION);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.share.RunShareDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/run/page/share/RunShareDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "", "screenshotPath", "", "a", "KEY_SCREENSHOT_PATH", "Ljava/lang/String;", "TAG", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager manager, @NotNull String screenshotPath) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(screenshotPath, "screenshotPath");
            RunShareDialog runShareDialog = new RunShareDialog();
            Bundle bundle = new Bundle();
            bundle.putString(RunShareDialog.KEY_SCREENSHOT_PATH, screenshotPath);
            runShareDialog.setArguments(bundle);
            runShareDialog.show(manager, RunShareDialog.TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishShare() {
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getScreenShotPath() {
        return (String) this.screenShotPath.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(RunShareDialog runShareDialog, View view, int i, int i2, int i3, int i4) {
        BLTextView bLTextView;
        Intrinsics.checkNotNullParameter(runShareDialog, "this$0");
        RunDialogShareBinding runDialogShareBinding = (RunDialogShareBinding) runShareDialog.getMBinding();
        if (runDialogShareBinding == null || (bLTextView = runDialogShareBinding.f11782a) == null) {
            return;
        }
        bLTextView.setVisibility(8);
        bLTextView.removeCallbacks(runShareDialog.showSlideTipRunnable);
        bLTextView.postDelayed(runShareDialog.showSlideTipRunnable, 150L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shareImage(FlavourName flavour) {
        if (getScreenShotPath().length() == 0) {
            return;
        }
        y88.i(requireActivity(), new ImageBody(flavour, "", new File(getScreenShotPath())), new ShareListener() { // from class: com.huachenjie.run.page.share.RunShareDialog.shareImage.1
            public void onCancel(@Nullable FlavourName flavour2) {
                tw0.d(RunShareDialog.this.getScreenShotPath());
                fv5.a(R.string.share_canceled);
                RunShareDialog.this.finishShare();
            }

            public void onFailed(@NotNull FlavourName flavour2, int code, @Nullable String message) {
                Intrinsics.checkNotNullParameter(flavour2, "flavour");
                tw0.d(RunShareDialog.this.getScreenShotPath());
                if (code == 1) {
                    fv5.b(message);
                } else {
                    fv5.a(R.string.share_failed);
                }
                RunShareDialog.this.finishShare();
            }

            public void onSuccess(@NotNull FlavourName flavour2) {
                Intrinsics.checkNotNullParameter(flavour2, "flavour");
                tw0.d(RunShareDialog.this.getScreenShotPath());
                fv5.a(R.string.share_succeed);
                RunShareDialog.this.finishShare();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSlideTipRunnable$lambda$0(RunShareDialog runShareDialog) {
        Intrinsics.checkNotNullParameter(runShareDialog, "this$0");
        RunDialogShareBinding runDialogShareBinding = (RunDialogShareBinding) runShareDialog.getMBinding();
        BLTextView bLTextView = runDialogShareBinding != null ? runDialogShareBinding.f11782a : null;
        if (bLTextView == null) {
            return;
        }
        bLTextView.setVisibility(0);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_share;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        RunDialogShareBinding runDialogShareBinding;
        LargeImageView largeImageView;
        LargeImageView largeImageView2;
        RunDialogShareBinding runDialogShareBinding2 = (RunDialogShareBinding) getMBinding();
        if (runDialogShareBinding2 != null && (largeImageView2 = runDialogShareBinding2.f11783a) != null) {
            largeImageView2.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.zj.adlib.wm7
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    RunShareDialog.initView$lambda$2(this.f45630a, view, i, i2, i3, i4);
                }
            });
        }
        if (TextUtils.isEmpty(getScreenShotPath()) || (runDialogShareBinding = (RunDialogShareBinding) getMBinding()) == null || (largeImageView = runDialogShareBinding.f11783a) == null) {
            return;
        }
        largeImageView.setImage(new vf3(new File(getScreenShotPath())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        BLTextView bLTextView;
        RunDialogShareBinding runDialogShareBinding = (RunDialogShareBinding) getMBinding();
        if (runDialogShareBinding != null && (bLTextView = runDialogShareBinding.f11782a) != null) {
            bLTextView.removeCallbacks(this.showSlideTipRunnable);
        }
        super.onDestroyView();
    }
}
