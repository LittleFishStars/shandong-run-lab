package com.huachenjie.works.page.alumni.original;

import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.OriginalCategoryBean;
import com.huachenjie.works.bean.OriginalCategoryListBean;
import com.huachenjie.works.bean.OriginalPageEntity;
import com.huachenjie.works.databinding.WorksFragmentOriginalChannelBinding;
import com.igexin.push.g.o;
import com.zj.adlib.qk0;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0011¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/works/page/alumni/original/OriginalChannelFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentOriginalChannelBinding;", "Lcom/huachenjie/works/page/alumni/original/OriginalChannelVM;", "()V", "getLayoutResID", "", "getVariables", "", "", "initData", "", "initDataObservable", "initTab", "listBean", "Lcom/huachenjie/works/bean/OriginalCategoryListBean;", "queryCachePageEntity", "Lcom/huachenjie/works/bean/OriginalPageEntity;", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "", "saveCachePageEntity", "pageEntity", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOriginalChannelFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OriginalChannelFragment.kt\ncom/huachenjie/works/page/alumni/original/OriginalChannelFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,76:1\n1549#2:77\n1620#2,3:78\n*S KotlinDebug\n*F\n+ 1 OriginalChannelFragment.kt\ncom/huachenjie/works/page/alumni/original/OriginalChannelFragment\n*L\n55#1:77\n55#1:78,3\n*E\n"})
public final class OriginalChannelFragment extends BaseMVVMFragment<WorksFragmentOriginalChannelBinding, OriginalChannelVM> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37180a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37180a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37180a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37180a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initTab(final OriginalCategoryListBean listBean) {
        ViewPager2 viewPager2;
        SelectBoldTabLayout selectBoldTabLayout;
        WorksFragmentOriginalChannelBinding mBinding = getMBinding();
        if (mBinding == null || (viewPager2 = mBinding.f14224a) == null) {
            return;
        }
        viewPager2.setAdapter(new FragmentStateAdapter() { // from class: com.huachenjie.works.page.alumni.original.OriginalChannelFragment$initTab$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.f14867a);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                String categoryNo;
                List<OriginalCategoryBean> list;
                OriginalCategoryBean originalCategoryBean;
                OriginalCategoryListBean value = this.f14867a.getMViewModel().j().getValue();
                if (value == null || (list = value.getList()) == null || (originalCategoryBean = list.get(position)) == null || (categoryNo = originalCategoryBean.getCategoryNo()) == null) {
                    categoryNo = "";
                }
                return OriginalChannelSubFragment.Companion.a(categoryNo);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return listBean.getList().size();
            }
        });
        WorksFragmentOriginalChannelBinding mBinding2 = getMBinding();
        if (mBinding2 == null || (selectBoldTabLayout = mBinding2.f14225a) == null) {
            return;
        }
        List<OriginalCategoryBean> list = listBean.getList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((OriginalCategoryBean) it.next()).getCategoryName());
        }
        selectBoldTabLayout.attachViewPager(viewPager2, arrayList);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_original_channel;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().k();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().j().observe(this, new a(new Function1<OriginalCategoryListBean, Unit>() { // from class: com.huachenjie.works.page.alumni.original.OriginalChannelFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OriginalCategoryListBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(OriginalCategoryListBean originalCategoryListBean) {
                OriginalChannelFragment originalChannelFragment = OriginalChannelFragment.this;
                Intrinsics.checkNotNullExpressionValue(originalCategoryListBean, o.f);
                originalChannelFragment.initTab(originalCategoryListBean);
            }
        }));
    }

    @Nullable
    public final OriginalPageEntity queryCachePageEntity(@NotNull String categoryNo) {
        Intrinsics.checkNotNullParameter(categoryNo, yj7.g.WORKS_PUBLISH_CATEGORY_NO);
        return getMViewModel().i().get(categoryNo);
    }

    public final void saveCachePageEntity(@NotNull String categoryNo, @NotNull OriginalPageEntity pageEntity) {
        Intrinsics.checkNotNullParameter(categoryNo, yj7.g.WORKS_PUBLISH_CATEGORY_NO);
        Intrinsics.checkNotNullParameter(pageEntity, "pageEntity");
        getMViewModel().i().put(categoryNo, pageEntity);
    }
}
