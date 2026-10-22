package com.huachenjie.base.adapter;

import androidx.annotation.IntRange;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Deprecated(message = "存在内存泄漏问题，后续项目请勿使用")
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b'\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0014\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0004\u001a\u00020\u0002J\u0014\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001cj\b\u0012\u0004\u0012\u00020\u0005`\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001eR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001cj\b\u0012\u0004\u0012\u00020\u0007`\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00070\"j\b\u0012\u0004\u0012\u00020\u0007`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010$¨\u0006,"}, d2 = {"Lcom/huachenjie/base/adapter/ViewPager2Adapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "", "getItemId", ALPParamConstant.ITMEID, "", "containsItem", "", "fragments", "", y6b.f, "d", "removeAt", "", "newData", "a", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "f", "()Landroidx/fragment/app/FragmentManager;", y6b.g, "(Landroidx/fragment/app/FragmentManager;)V", "fragmentManager", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "fragmentList", "b", "fragmentIds", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "createIds", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ViewPager2Adapter extends FragmentStateAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public FragmentManager fragmentManager;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ArrayList<Fragment> fragmentList;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final HashSet<Long> createIds;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<Long> fragmentIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2Adapter(@NotNull Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragmentList = new ArrayList<>();
        this.fragmentIds = new ArrayList<>();
        this.createIds = new HashSet<>();
        this.fragmentManager = fragment.getChildFragmentManager();
    }

    public final void a(@NotNull Collection<? extends Fragment> newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        for (Fragment fragment : newData) {
            this.fragmentList.add(fragment);
            this.fragmentIds.add(Long.valueOf(fragment.hashCode()));
        }
        notifyItemRangeInserted(this.fragmentList.size() - newData.size(), newData.size());
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long itemId) {
        return this.createIds.contains(Long.valueOf(itemId));
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        Long l = this.fragmentIds.get(position);
        Intrinsics.checkNotNullExpressionValue(l, "fragmentIds[position]");
        this.createIds.add(Long.valueOf(l.longValue()));
        Fragment fragment = this.fragmentList.get(position);
        Intrinsics.checkNotNullExpressionValue(fragment, "fragmentList[position]");
        return fragment;
    }

    @Nullable
    public final Fragment d(int position) {
        return (Fragment) CollectionsKt.getOrNull(this.fragmentList, position);
    }

    @Nullable
    /* JADX INFO: renamed from: f, reason: from getter */
    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final void g(@NotNull List<? extends Fragment> fragments) {
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager != null) {
            Intrinsics.checkNotNull(fragmentManager);
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager!!.beginTransaction()");
            Iterator<Fragment> it = this.fragmentList.iterator();
            while (it.hasNext()) {
                fragmentTransactionBeginTransaction.remove(it.next());
            }
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        }
        this.fragmentList.clear();
        this.fragmentIds.clear();
        for (Fragment fragment : fragments) {
            this.fragmentList.add(fragment);
            this.fragmentIds.add(Long.valueOf(fragment.hashCode()));
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.fragmentList.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        Long l = this.fragmentIds.get(position);
        Intrinsics.checkNotNullExpressionValue(l, "fragmentIds[position]");
        return l.longValue();
    }

    public final void h(@Nullable FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public final void removeAt(@IntRange(from = 0) int position) {
        if (position >= this.fragmentList.size()) {
            return;
        }
        this.fragmentList.remove(position);
        this.fragmentIds.remove(position);
        notifyItemRemoved(position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2Adapter(@NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        this.fragmentList = new ArrayList<>();
        this.fragmentIds = new ArrayList<>();
        this.createIds = new HashSet<>();
        this.fragmentManager = fragmentActivity.getSupportFragmentManager();
    }
}
