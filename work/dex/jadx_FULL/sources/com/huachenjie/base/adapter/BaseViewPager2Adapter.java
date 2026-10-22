package com.huachenjie.base.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'B\u0011\b\u0016\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b&\u0010*B\u0019\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b&\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0003J\u0014\u0010\u0018\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010#¨\u0006."}, d2 = {"Lcom/huachenjie/base/adapter/BaseViewPager2Adapter;", "T", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "c", "(ILjava/lang/Object;)Landroidx/fragment/app/Fragment;", "", "getItemId", ALPParamConstant.ITMEID, "", "containsItem", "", GoodsSpecificationPreviewActivity.z, "", "setList", "d", "removeAt", "", "newData", "b", "Landroidx/fragment/app/FragmentManager;", "a", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "f", "Ljava/util/List;", "dataList", y6b.f, "fragmentId", "J", "indexId", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "Landroidx/lifecycle/Lifecycle;", RequestParameters.SUBRESOURCE_LIFECYCLE, "(Landroidx/fragment/app/FragmentManager;Landroidx/lifecycle/Lifecycle;)V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBaseViewPager2Adapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseViewPager2Adapter.kt\ncom/huachenjie/base/adapter/BaseViewPager2Adapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,85:1\n1855#2,2:86\n1855#2,2:88\n*S KotlinDebug\n*F\n+ 1 BaseViewPager2Adapter.kt\ncom/huachenjie/base/adapter/BaseViewPager2Adapter\n*L\n58#1:86,2\n79#1:88,2\n*E\n"})
public abstract class BaseViewPager2Adapter<T> extends FragmentStateAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long indexId;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final FragmentManager fragmentManager;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final List<T> dataList;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final List<Long> fragmentId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewPager2Adapter(@NotNull Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.dataList = new ArrayList();
        this.fragmentId = new ArrayList();
        this.indexId = System.nanoTime();
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        this.fragmentManager = childFragmentManager;
    }

    public final void b(@NotNull List<? extends T> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        for (T t : newData) {
            List<Long> list = this.fragmentId;
            long j = this.indexId + 1;
            this.indexId = j;
            list.add(Long.valueOf(j));
            this.dataList.add(t);
        }
        notifyItemRangeInserted(this.dataList.size() - newData.size(), newData.size());
    }

    @NotNull
    public abstract Fragment c(int position, T bean);

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long itemId) {
        return this.fragmentId.contains(Long.valueOf(itemId));
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        return c(position, this.dataList.get(position));
    }

    @Nullable
    public final Fragment d(int position) {
        FragmentManager fragmentManager = this.fragmentManager;
        StringBuilder sb = new StringBuilder();
        sb.append('f');
        sb.append(getItemId(position));
        return fragmentManager.findFragmentByTag(sb.toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.fragmentId.get(position).longValue();
    }

    public final void removeAt(int position) {
        if (position >= this.dataList.size()) {
            return;
        }
        this.fragmentId.remove(position);
        this.dataList.remove(position);
        notifyItemRemoved(position);
    }

    public final void setList(@Nullable Collection<? extends T> list) {
        this.dataList.clear();
        this.fragmentId.clear();
        if (list != null) {
            for (T t : list) {
                List<Long> list2 = this.fragmentId;
                long j = this.indexId + 1;
                this.indexId = j;
                list2.add(Long.valueOf(j));
                this.dataList.add(t);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewPager2Adapter(@NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        this.dataList = new ArrayList();
        this.fragmentId = new ArrayList();
        this.indexId = System.nanoTime();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        this.fragmentManager = supportFragmentManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewPager2Adapter(@NotNull FragmentManager fragmentManager, @NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        this.dataList = new ArrayList();
        this.fragmentId = new ArrayList();
        this.indexId = System.nanoTime();
        this.fragmentManager = fragmentManager;
    }
}
