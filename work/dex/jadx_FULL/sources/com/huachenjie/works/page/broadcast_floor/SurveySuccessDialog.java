package com.huachenjie.works.page.broadcast_floor;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksDialogSurveySuccessBinding;
import com.huachenjie.works.page.broadcast_floor.SurveySuccessDialog;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/SurveySuccessDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogSurveySuccessBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "getWidth", "getHeight", "getLayoutResID", "", "getVariables", "", "onStart", "initView", "", "resultTitle$delegate", "Lkotlin/Lazy;", "getResultTitle", "()Ljava/lang/String;", SurveySuccessDialog.KEY_TITLE, "resultImage$delegate", "getResultImage", SurveySuccessDialog.KEY_IMAGE, "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class SurveySuccessDialog extends BaseMVVMDialogFragment<WorksDialogSurveySuccessBinding, BaseViewModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_IMAGE = "resultImage";

    @NotNull
    private static final String KEY_TITLE = "resultTitle";

    /* JADX INFO: renamed from: resultTitle$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy resultTitle = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.broadcast_floor.SurveySuccessDialog$resultTitle$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("resultTitle")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: resultImage$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy resultImage = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.broadcast_floor.SurveySuccessDialog$resultImage$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("resultImage")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.page.broadcast_floor.SurveySuccessDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/SurveySuccessDialog$a;", "", "", SurveySuccessDialog.KEY_TITLE, SurveySuccessDialog.KEY_IMAGE, "Lcom/huachenjie/works/page/broadcast_floor/SurveySuccessDialog;", "a", "KEY_IMAGE", "Ljava/lang/String;", "KEY_TITLE", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SurveySuccessDialog a(@NotNull String resultTitle, @NotNull String resultImage) {
            Intrinsics.checkNotNullParameter(resultTitle, SurveySuccessDialog.KEY_TITLE);
            Intrinsics.checkNotNullParameter(resultImage, SurveySuccessDialog.KEY_IMAGE);
            SurveySuccessDialog surveySuccessDialog = new SurveySuccessDialog();
            Bundle bundle = new Bundle();
            bundle.putString(SurveySuccessDialog.KEY_TITLE, resultTitle);
            bundle.putString(SurveySuccessDialog.KEY_IMAGE, resultImage);
            surveySuccessDialog.setArguments(bundle);
            return surveySuccessDialog;
        }
    }

    private final String getResultImage() {
        return (String) this.resultImage.getValue();
    }

    private final String getResultTitle() {
        return (String) this.resultTitle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(SurveySuccessDialog surveySuccessDialog, View view) {
        Intrinsics.checkNotNullParameter(surveySuccessDialog, "this$0");
        surveySuccessDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$2(SurveySuccessDialog surveySuccessDialog, View view) {
        Intrinsics.checkNotNullParameter(surveySuccessDialog, "this$0");
        surveySuccessDialog.dismiss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_survey_success;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, BaseViewModel> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
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
            view.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.tx8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SurveySuccessDialog.initView$lambda$1(this.f45023a, view2);
                }
            });
        }
        WorksDialogSurveySuccessBinding mBinding = getMBinding();
        if (mBinding != null) {
            mBinding.f14135a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ux8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SurveySuccessDialog.initView$lambda$4$lambda$2(this.f45247a, view2);
                }
            });
            mBinding.f14133a.setText(getResultTitle());
            ImageView imageView = mBinding.f36887a;
            Glide.with(imageView).load(getResultImage()).into(imageView);
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
