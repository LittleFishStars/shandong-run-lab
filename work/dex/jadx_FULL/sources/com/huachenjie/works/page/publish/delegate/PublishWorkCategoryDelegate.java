package com.huachenjie.works.page.publish.delegate;

import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.material.tabs.TabLayout;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.huachenjie.works.databinding.WorksActivityPulishWorkBinding;
import com.huachenjie.works.page.publish.PublishWorkActivity;
import com.huachenjie.works.page.publish.PublishWorkTagAdapter;
import com.huachenjie.works.page.publish.PublishWorkViewModel;
import com.huachenjie.works.page.publish.delegate.PublishWorkCategoryDelegate;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/page/publish/delegate/PublishWorkCategoryDelegate;", "", "", y6b.g, "f", y6b.f, "Lcom/huachenjie/works/page/publish/PublishWorkActivity;", "a", "Lcom/huachenjie/works/page/publish/PublishWorkActivity;", "workActivity", "Lcom/huachenjie/works/page/publish/PublishWorkViewModel;", "Lcom/huachenjie/works/page/publish/PublishWorkViewModel;", "mViewModel", "Lcom/huachenjie/works/databinding/WorksActivityPulishWorkBinding;", "Lcom/huachenjie/works/databinding/WorksActivityPulishWorkBinding;", "mBinding", "", "Z", "isFilterTabCallback", "<init>", "(Lcom/huachenjie/works/page/publish/PublishWorkActivity;Lcom/huachenjie/works/page/publish/PublishWorkViewModel;Lcom/huachenjie/works/databinding/WorksActivityPulishWorkBinding;)V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PublishWorkCategoryDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final WorksActivityPulishWorkBinding mBinding;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final PublishWorkActivity workActivity;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final PublishWorkViewModel mViewModel;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isFilterTabCallback;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/works/page/publish/delegate/PublishWorkCategoryDelegate$a", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements TabLayout.OnTabSelectedListener {
        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            if (PublishWorkCategoryDelegate.this.isFilterTabCallback || tab == null) {
                return;
            }
            List<RecommendWorksBean> value = PublishWorkCategoryDelegate.this.mViewModel.u().getValue();
            RecommendWorksBean recommendWorksBean = value != null ? (RecommendWorksBean) CollectionsKt.getOrNull(value, tab.getPosition()) : null;
            PublishWorkCategoryDelegate publishWorkCategoryDelegate = PublishWorkCategoryDelegate.this;
            publishWorkCategoryDelegate.mViewModel.y().setValue(recommendWorksBean);
            PublishWorkViewModel.r(publishWorkCategoryDelegate.mViewModel, null, 1, null);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37295a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37295a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37295a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37295a.invoke(obj);
        }
    }

    public PublishWorkCategoryDelegate(@NotNull PublishWorkActivity publishWorkActivity, @NotNull PublishWorkViewModel publishWorkViewModel, @NotNull WorksActivityPulishWorkBinding worksActivityPulishWorkBinding) {
        Intrinsics.checkNotNullParameter(publishWorkActivity, "workActivity");
        Intrinsics.checkNotNullParameter(publishWorkViewModel, "mViewModel");
        Intrinsics.checkNotNullParameter(worksActivityPulishWorkBinding, "mBinding");
        this.workActivity = publishWorkActivity;
        this.mViewModel = publishWorkViewModel;
        this.mBinding = worksActivityPulishWorkBinding;
    }

    public static final void i(PublishWorkCategoryDelegate publishWorkCategoryDelegate, PublishWorkTagAdapter publishWorkTagAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(publishWorkCategoryDelegate, "this$0");
        Intrinsics.checkNotNullParameter(publishWorkTagAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        publishWorkCategoryDelegate.mViewModel.I(publishWorkTagAdapter.getItem(i));
        publishWorkTagAdapter.j(i);
        RecommendWorksBean value = publishWorkCategoryDelegate.mViewModel.y().getValue();
        if (value != null) {
            publishWorkCategoryDelegate.mViewModel.t().put(value.getCategoryNo(), Integer.valueOf(i));
        }
    }

    public final void f() {
        Intent intent = this.workActivity.getIntent();
        this.mViewModel.p(intent.getParcelableArrayListExtra(yj7.g.WORKS_PUBLISH_CATEGORY_LIST), intent.getStringExtra(yj7.g.WORKS_PUBLISH_CATEGORY_NO), null);
    }

    public final void g() {
        this.mViewModel.u().observe(this.workActivity, new b(new PublishWorkCategoryDelegate$initDataObserve$1(this)));
    }

    public final void h() {
        this.mBinding.f13911a.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
        this.mBinding.f36795a.setItemAnimator(null);
        this.mBinding.f36795a.setLayoutManager(new LinearLayoutManager(this.workActivity, 0, false));
        final PublishWorkTagAdapter value = this.mViewModel.C().getValue();
        if (value != null) {
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.c47
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    PublishWorkCategoryDelegate.i(this.f15730a, value, baseQuickAdapter, view, i);
                }
            });
        }
    }
}
