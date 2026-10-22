package com.huachenjie.works.page.campus_wall.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostCategoryBean;
import com.huachenjie.works.databinding.WorksDialogPublishPostBinding;
import com.huachenjie.works.databinding.WorksItemPublishPostBinding;
import com.huachenjie.works.page.campus_wall.dialog.PublishPostDialog;
import com.huachenjie.works.page.post.PublishPostActivity;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.qk0;
import com.zj.adlib.y57;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/dialog/PublishPostDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/works/databinding/WorksDialogPublishPostBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "initRecyclerView", "", "scaleX", "scaleY", "Landroid/view/animation/AnimationSet;", "createAnimation", "", "getWidth", "getHeight", "getLayoutResID", "initView", "onStart", "", "", "getVariables", "<init>", "()V", "Companion", "a", "b", "MyAdapter", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PublishPostDialog extends BaseMVVMDialogFragment<WorksDialogPublishPostBinding, BaseViewModel> {

    @NotNull
    private static final String CATEGORY_LIST = "categoryList";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TARGET_X = "targetX";

    @NotNull
    private static final String TARGET_Y = "targetY";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/dialog/PublishPostDialog$MyAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/PostCategoryBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemPublishPostBinding;", "()V", "convert", "", "holder", "item", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MyAdapter extends BaseQuickAdapter<PostCategoryBean, BaseDataBindingHolder<WorksItemPublishPostBinding>> {
        public MyAdapter() {
            super(R.layout.works_item_publish_post, null, 2, null);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(@NotNull BaseDataBindingHolder<WorksItemPublishPostBinding> holder, @NotNull PostCategoryBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            WorksItemPublishPostBinding worksItemPublishPostBinding = (WorksItemPublishPostBinding) holder.getDataBinding();
            if (worksItemPublishPostBinding != null) {
                worksItemPublishPostBinding.k(item);
                worksItemPublishPostBinding.executePendingBindings();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/dialog/PublishPostDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/works/page/campus_wall/dialog/PublishPostDialog;)V", "works_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PublishPostDialog.this.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.campus_wall.dialog.PublishPostDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/works/page/campus_wall/dialog/PublishPostDialog$b;", "", "", "targetX", "targetY", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/PostCategoryBean;", "Lkotlin/collections/ArrayList;", "categoryList", "Lcom/huachenjie/works/page/campus_wall/dialog/PublishPostDialog;", "a", "", "CATEGORY_LIST", "Ljava/lang/String;", "TARGET_X", "TARGET_Y", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PublishPostDialog a(int targetX, int targetY, @NotNull ArrayList<PostCategoryBean> categoryList) {
            Intrinsics.checkNotNullParameter(categoryList, "categoryList");
            PublishPostDialog publishPostDialog = new PublishPostDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("targetX", targetX);
            bundle.putInt("targetY", targetY);
            bundle.putParcelableArrayList("categoryList", categoryList);
            publishPostDialog.setArguments(bundle);
            return publishPostDialog;
        }
    }

    private final AnimationSet createAnimation(float scaleX, float scaleY) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, scaleX, 1, scaleY);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(300L);
        return animationSet;
    }

    private final void initRecyclerView() {
        Bundle arguments = getArguments();
        ArrayList parcelableArrayList = arguments != null ? arguments.getParcelableArrayList("categoryList") : null;
        final MyAdapter myAdapter = new MyAdapter();
        y57.d(myAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.v37
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PublishPostDialog.initRecyclerView$lambda$3(this.f20172a, myAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        myAdapter.setList(parcelableArrayList);
        WorksDialogPublishPostBinding mBinding = getMBinding();
        RecyclerView recyclerView = mBinding != null ? mBinding.f14106a : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(myAdapter);
        }
        WorksDialogPublishPostBinding mBinding2 = getMBinding();
        RecyclerView recyclerView2 = mBinding2 != null ? mBinding2.f14106a : null;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setItemAnimator(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$3(PublishPostDialog publishPostDialog, MyAdapter myAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(publishPostDialog, "this$0");
        Intrinsics.checkNotNullParameter(myAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        PublishPostActivity.Companion companion = PublishPostActivity.INSTANCE;
        Context contextRequireContext = publishPostDialog.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.a(contextRequireContext, myAdapter.getItem(i).getTypeCode(), myAdapter.getItem(i).getTagCode());
        publishPostDialog.dismissAllowingStateLoss();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_dialog_publish_post;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ImageView imageView;
        super.initView();
        initRecyclerView();
        View view = getView();
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(200L);
            view.setAnimation(alphaAnimation);
        }
        WorksDialogPublishPostBinding mBinding = getMBinding();
        if (mBinding != null && (imageView = mBinding.f36877a) != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            Bundle arguments = getArguments();
            layoutParams2.setMarginStart(arguments != null ? arguments.getInt("targetX") : 0);
            Bundle arguments2 = getArguments();
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = arguments2 != null ? arguments2.getInt("targetY") : 0;
        }
        WorksDialogPublishPostBinding mBinding2 = getMBinding();
        BLLinearLayout bLLinearLayout = mBinding2 != null ? mBinding2.f14108a : null;
        if (bLLinearLayout == null) {
            return;
        }
        bLLinearLayout.setAnimation(createAnimation(1.0f, 1.0f));
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
