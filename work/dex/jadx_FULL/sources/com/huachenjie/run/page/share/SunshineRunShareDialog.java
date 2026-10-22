package com.huachenjie.run.page.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import com.google.android.exoplayer2.util.FileTypes;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunDialogSunshineRunShareBinding;
import com.huachenjie.run.page.share.SunshineRunShareDialog;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.fv5;
import com.zj.adlib.jg3;
import com.zj.adlib.lk0;
import com.zj.adlib.tw0;
import com.zj.adlib.wf3;
import com.zj.adlib.y88;
import huachenjie.sdk.share.FlavourName;
import huachenjie.sdk.share.ShareListener;
import huachenjie.sdk.share.sharebody.ImageBody;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/huachenjie/run/page/share/SunshineRunShareDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/run/databinding/RunDialogSunshineRunShareBinding;", "Lcom/huachenjie/run/page/share/SunshineRunShareVM;", "", "createShareFile", "ensureShareFile", "", "clearShareFile", "finishShare", "Lhuachenjie/sdk/share/FlavourName;", "flavour", "shareImage", "path", "", "toastRes", "onShareFinished", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initView", "onDestroyView", "shareFilePath", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class SunshineRunShareDialog extends BaseMVVMBottomDialogFragment<RunDialogSunshineRunShareBinding, SunshineRunShareVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CALORIE = "calorie";

    @NotNull
    private static final String KEY_DISTANCE = "distance";

    @NotNull
    private static final String KEY_DURATION = "duration";

    @NotNull
    private static final String KEY_PACE = "pace";

    @NotNull
    private static final String TAG = "SunshineRunShareDialog";

    @NotNull
    private String shareFilePath = "";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/run/page/share/SunshineRunShareDialog$a;", "Lcom/huachenjie/run/page/share/ShareActionClick;", "Landroid/view/View;", "view", "", "c", "a", "d", "b", "<init>", "(Lcom/huachenjie/run/page/share/SunshineRunShareDialog;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a implements ShareActionClick {
        public a() {
        }

        public static final void f(SunshineRunShareDialog sunshineRunShareDialog) {
            Intrinsics.checkNotNullParameter(sunshineRunShareDialog, "this$0");
            if (sunshineRunShareDialog.isAdded()) {
                String strEnsureShareFile = sunshineRunShareDialog.ensureShareFile();
                if (strEnsureShareFile.length() == 0) {
                    fv5.a(R.string.saved_failed);
                    sunshineRunShareDialog.finishShare();
                } else {
                    fv5.a(wf3.n(strEnsureShareFile, sunshineRunShareDialog.requireContext()) ? R.string.saved_succeed : R.string.saved_failed);
                    sunshineRunShareDialog.clearShareFile();
                    sunshineRunShareDialog.finishShare();
                }
            }
        }

        @Override // com.huachenjie.run.page.share.ShareActionClick
        public void a(@Nullable View view) {
            BLRelativeLayout bLRelativeLayout;
            RunDialogSunshineRunShareBinding runDialogSunshineRunShareBindingAccess$getMBinding = SunshineRunShareDialog.access$getMBinding(SunshineRunShareDialog.this);
            if (runDialogSunshineRunShareBindingAccess$getMBinding == null || (bLRelativeLayout = runDialogSunshineRunShareBindingAccess$getMBinding.f11792a) == null) {
                return;
            }
            final SunshineRunShareDialog sunshineRunShareDialog = SunshineRunShareDialog.this;
            bLRelativeLayout.post(new Runnable() { // from class: com.zj.adlib.kw8
                @Override // java.lang.Runnable
                public final void run() {
                    SunshineRunShareDialog.a.f(sunshineRunShareDialog);
                }
            });
        }

        @Override // com.huachenjie.run.page.share.ShareActionClick
        public void b(@Nullable View view) {
            SunshineRunShareDialog.this.shareImage(FlavourName.WX_MOMENT);
        }

        @Override // com.huachenjie.run.page.share.ShareActionClick
        public void c(@Nullable View view) {
            SunshineRunShareDialog.this.finishShare();
        }

        @Override // com.huachenjie.run.page.share.ShareActionClick
        public void d(@Nullable View view) {
            SunshineRunShareDialog.this.shareImage(FlavourName.WX_SESSION);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.share.SunshineRunShareDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/run/page/share/SunshineRunShareDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "", "distanceMeter", "", "paceSecond", "durationSecond", "", "calorieText", "", "a", "KEY_CALORIE", "Ljava/lang/String;", "KEY_DISTANCE", "KEY_DURATION", "KEY_PACE", "TAG", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager manager, int distanceMeter, long paceSecond, long durationSecond, @NotNull String calorieText) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(calorieText, "calorieText");
            SunshineRunShareDialog sunshineRunShareDialog = new SunshineRunShareDialog();
            sunshineRunShareDialog.setArguments(BundleKt.bundleOf(TuplesKt.to("distance", Integer.valueOf(distanceMeter)), TuplesKt.to(SunshineRunShareDialog.KEY_PACE, Long.valueOf(paceSecond)), TuplesKt.to("duration", Long.valueOf(durationSecond)), TuplesKt.to(SunshineRunShareDialog.KEY_CALORIE, calorieText)));
            sunshineRunShareDialog.show(manager, SunshineRunShareDialog.TAG);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RunDialogSunshineRunShareBinding access$getMBinding(SunshineRunShareDialog sunshineRunShareDialog) {
        return (RunDialogSunshineRunShareBinding) sunshineRunShareDialog.getMBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearShareFile() {
        if (this.shareFilePath.length() == 0) {
            return;
        }
        tw0.d(this.shareFilePath);
        this.shareFilePath = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String createShareFile() {
        RunDialogSunshineRunShareBinding runDialogSunshineRunShareBinding;
        BLRelativeLayout bLRelativeLayout;
        Bitmap bitmapC;
        if (!isAdded() || (runDialogSunshineRunShareBinding = (RunDialogSunshineRunShareBinding) getMBinding()) == null || (bLRelativeLayout = runDialogSunshineRunShareBinding.f11792a) == null || bLRelativeLayout.getWidth() <= 0 || bLRelativeLayout.getHeight() <= 0 || (bitmapC = tw0.c(bLRelativeLayout)) == null) {
            return "";
        }
        try {
            jg3 jg3Var = jg3.f42579a;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            File fileF = jg3Var.f(contextRequireContext);
            String absolutePath = fileF != null ? fileF.getAbsolutePath() : null;
            if (absolutePath == null) {
                return "";
            }
            File fileH = tw0.h(bitmapC, 1048576L, absolutePath, "sunshine_share_" + System.currentTimeMillis() + FileTypes.F);
            String absolutePath2 = fileH != null ? fileH.getAbsolutePath() : null;
            return absolutePath2 != null ? absolutePath2 : "";
        } finally {
            if (!bitmapC.isRecycled()) {
                bitmapC.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String ensureShareFile() {
        if ((this.shareFilePath.length() > 0) && new File(this.shareFilePath).exists()) {
            return this.shareFilePath;
        }
        String strCreateShareFile = createShareFile();
        this.shareFilePath = strCreateShareFile;
        return strCreateShareFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishShare() {
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onShareFinished(String path, int toastRes) {
        tw0.d(path);
        this.shareFilePath = "";
        fv5.a(toastRes);
        finishShare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void shareImage(final FlavourName flavour) {
        BLRelativeLayout bLRelativeLayout;
        RunDialogSunshineRunShareBinding runDialogSunshineRunShareBinding = (RunDialogSunshineRunShareBinding) getMBinding();
        if (runDialogSunshineRunShareBinding == null || (bLRelativeLayout = runDialogSunshineRunShareBinding.f11792a) == null) {
            return;
        }
        bLRelativeLayout.post(new Runnable() { // from class: com.zj.adlib.jw8
            @Override // java.lang.Runnable
            public final void run() {
                SunshineRunShareDialog.shareImage$lambda$0(this.f42690a, flavour);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shareImage$lambda$0(final SunshineRunShareDialog sunshineRunShareDialog, FlavourName flavourName) {
        Intrinsics.checkNotNullParameter(sunshineRunShareDialog, "this$0");
        Intrinsics.checkNotNullParameter(flavourName, "$flavour");
        if (sunshineRunShareDialog.isAdded()) {
            final String strEnsureShareFile = sunshineRunShareDialog.ensureShareFile();
            if (strEnsureShareFile.length() == 0) {
                fv5.a(R.string.run_create_screenshot_failed);
            } else {
                y88.i(sunshineRunShareDialog.requireActivity(), new ImageBody(flavourName, "", new File(strEnsureShareFile)), new ShareListener() { // from class: com.huachenjie.run.page.share.SunshineRunShareDialog$shareImage$1$1
                    public void onCancel(@Nullable FlavourName flavour) {
                        this.this$0.onShareFinished(strEnsureShareFile, R.string.share_canceled);
                    }

                    public void onFailed(@NotNull FlavourName flavour, int code, @Nullable String message) {
                        Intrinsics.checkNotNullParameter(flavour, "flavour");
                        tw0.d(strEnsureShareFile);
                        this.this$0.shareFilePath = "";
                        if (code == 1) {
                            fv5.b(message);
                        } else {
                            fv5.a(R.string.share_failed);
                        }
                        this.this$0.finishShare();
                    }

                    public void onSuccess(@NotNull FlavourName flavour) {
                        Intrinsics.checkNotNullParameter(flavour, "flavour");
                        this.this$0.onShareFinished(strEnsureShareFile, R.string.share_succeed);
                    }
                });
            }
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_dialog_sunshine_run_share;
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
        SunshineRunShareVM sunshineRunShareVM = (SunshineRunShareVM) getMViewModel();
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt("distance") : 0;
        Bundle arguments2 = getArguments();
        long j = arguments2 != null ? arguments2.getLong(KEY_PACE) : 0L;
        Bundle arguments3 = getArguments();
        long j2 = arguments3 != null ? arguments3.getLong("duration") : 0L;
        Bundle arguments4 = getArguments();
        String string = arguments4 != null ? arguments4.getString(KEY_CALORIE) : null;
        if (string == null) {
            string = "";
        }
        sunshineRunShareVM.i(i, j, j2, string);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        clearShareFile();
        super.onDestroyView();
    }
}
