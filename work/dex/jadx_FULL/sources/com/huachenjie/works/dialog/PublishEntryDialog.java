package com.huachenjie.works.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.huachenjie.works.databinding.WorksDialogPublishEntryBinding;
import com.huachenjie.works.utils.PublishUtil;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.qk0;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%&B\u0007¢\u0006\u0004\b\"\u0010#J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u00060\u0013R\u00020\u00000\u0012H\u0016R+\u0010\u001c\u001a\u0012\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/huachenjie/works/dialog/PublishEntryDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogPublishEntryBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "scaleX", "scaleY", "translateX", "translateY", "Landroid/view/animation/AnimationSet;", "createAnimation", "", "getWidth", "getHeight", "getLayoutResID", "", "initView", "onStart", "", "Lcom/huachenjie/works/dialog/PublishEntryDialog$ClickProxy;", "getVariables", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/RecommendWorksBean;", "kotlin.jvm.PlatformType", "categoryList$delegate", "Lkotlin/Lazy;", "getCategoryList", "()Ljava/util/ArrayList;", "categoryList", "", "categoryNo$delegate", "getCategoryNo", "()Ljava/lang/String;", "categoryNo", "<init>", "()V", "Companion", "ClickProxy", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PublishEntryDialog extends BaseMVVMDialogFragment<WorksDialogPublishEntryBinding, BaseViewModel> {

    @NotNull
    private static final String CATEGORY_LIST = "categoryList";

    @NotNull
    private static final String CATEGORY_NO = "categoryNo";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TARGET_X = "targetX";

    @NotNull
    private static final String TARGET_Y = "targetY";

    /* JADX INFO: renamed from: categoryList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy categoryList = LazyKt.lazy(new Function0<ArrayList<RecommendWorksBean>>() { // from class: com.huachenjie.works.dialog.PublishEntryDialog$categoryList$2
        {
            super(0);
        }

        @Nullable
        public final ArrayList<RecommendWorksBean> invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getParcelableArrayList(yj7.g.WORKS_PUBLISH_CATEGORY_LIST);
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: categoryNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy categoryNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.dialog.PublishEntryDialog$categoryNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString(yj7.g.WORKS_PUBLISH_CATEGORY_NO);
            }
            return null;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/dialog/PublishEntryDialog$ClickProxy;", "", "Landroid/view/View;", "view", "", "a", "b", "c", "<init>", "(Lcom/huachenjie/works/dialog/PublishEntryDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PublishEntryDialog.this.dismissAllowingStateLoss();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (PublishEntryDialog.this.getActivity() == null) {
                return;
            }
            PublishUtil publishUtil = PublishUtil.f37344a;
            FragmentActivity activity = PublishEntryDialog.this.getActivity();
            Intrinsics.checkNotNull(activity);
            ArrayList<RecommendWorksBean> categoryList = PublishEntryDialog.this.getCategoryList();
            String categoryNo = PublishEntryDialog.this.getCategoryNo();
            BaseViewModel mViewModel = PublishEntryDialog.this.getMViewModel();
            final PublishEntryDialog publishEntryDialog = PublishEntryDialog.this;
            publishUtil.b(activity, 1, categoryList, categoryNo, mViewModel, new Function0<Unit>() { // from class: com.huachenjie.works.dialog.PublishEntryDialog$ClickProxy$clickPublishPicture$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m812invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m812invoke() {
                    publishEntryDialog.dismissAllowingStateLoss();
                }
            });
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (PublishEntryDialog.this.getActivity() == null) {
                return;
            }
            PublishUtil publishUtil = PublishUtil.f37344a;
            FragmentActivity activity = PublishEntryDialog.this.getActivity();
            Intrinsics.checkNotNull(activity);
            ArrayList<RecommendWorksBean> categoryList = PublishEntryDialog.this.getCategoryList();
            String categoryNo = PublishEntryDialog.this.getCategoryNo();
            BaseViewModel mViewModel = PublishEntryDialog.this.getMViewModel();
            final PublishEntryDialog publishEntryDialog = PublishEntryDialog.this;
            publishUtil.b(activity, 2, categoryList, categoryNo, mViewModel, new Function0<Unit>() { // from class: com.huachenjie.works.dialog.PublishEntryDialog$ClickProxy$clickPublishVideo$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m813invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m813invoke() {
                    publishEntryDialog.dismissAllowingStateLoss();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.dialog.PublishEntryDialog$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/works/dialog/PublishEntryDialog$a;", "", "", "targetX", "targetY", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/RecommendWorksBean;", "Lkotlin/collections/ArrayList;", "categoryList", "", "categoryNo", "Lcom/huachenjie/works/dialog/PublishEntryDialog;", "a", "CATEGORY_LIST", "Ljava/lang/String;", "CATEGORY_NO", "TARGET_X", "TARGET_Y", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PublishEntryDialog a(int targetX, int targetY, @NotNull ArrayList<RecommendWorksBean> categoryList, @NotNull String categoryNo) {
            Intrinsics.checkNotNullParameter(categoryList, "categoryList");
            Intrinsics.checkNotNullParameter(categoryNo, "categoryNo");
            PublishEntryDialog publishEntryDialog = new PublishEntryDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("targetX", targetX);
            bundle.putInt("targetY", targetY);
            bundle.putParcelableArrayList("categoryList", categoryList);
            bundle.putString("categoryNo", categoryNo);
            publishEntryDialog.setArguments(bundle);
            return publishEntryDialog;
        }
    }

    private final AnimationSet createAnimation(float scaleX, float scaleY, float translateX, float translateY) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, scaleX, 1, scaleY);
        TranslateAnimation translateAnimation = new TranslateAnimation(translateX, 0.0f, translateY, 0.0f);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(300L);
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<RecommendWorksBean> getCategoryList() {
        return (ArrayList) this.categoryList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCategoryNo() {
        return (String) this.categoryNo.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_publish_entry;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, ClickProxy> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.k), new ClickProxy()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ImageView imageView;
        super.initView();
        View view = getView();
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200L);
            view.setAnimation(alphaAnimation);
        }
        WorksDialogPublishEntryBinding mBinding = getMBinding();
        if (mBinding != null && (imageView = mBinding.f36872a) != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            Bundle arguments = getArguments();
            layoutParams2.setMarginStart(arguments != null ? arguments.getInt("targetX") : 0);
            Bundle arguments2 = getArguments();
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = arguments2 != null ? arguments2.getInt("targetY") : 0;
        }
        WorksDialogPublishEntryBinding mBinding2 = getMBinding();
        RelativeLayout relativeLayout = mBinding2 != null ? mBinding2.f14096a : null;
        if (relativeLayout != null) {
            relativeLayout.setAnimation(createAnimation(0.5f, 1.0f, 0.0f, SizeUtils.b(20.0f)));
        }
        WorksDialogPublishEntryBinding mBinding3 = getMBinding();
        BLLinearLayout bLLinearLayout = mBinding3 != null ? mBinding3.f14098a : null;
        if (bLLinearLayout == null) {
            return;
        }
        bLLinearLayout.setAnimation(createAnimation(1.0f, 0.5f, SizeUtils.b(20.0f), 0.0f));
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
        int i = window.getAttributes().flags;
        window.setAttributes(window.getAttributes());
    }
}
