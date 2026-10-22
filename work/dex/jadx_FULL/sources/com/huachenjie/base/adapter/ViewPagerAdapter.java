package com.huachenjie.base.adapter;

import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\"\u0010\u0013\u001a\u00020\u00122\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eR\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0017j\b\u0012\u0004\u0012\u00020\u000f`\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0017j\b\u0012\u0004\u0012\u00020\u0007`\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/base/adapter/ViewPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "getCount", "position", "", "getPageTitle", "Landroidx/fragment/app/Fragment;", "getItem", "", "item", "getItemPosition", "Landroid/os/Parcelable;", "saveState", "", "", "titles", "fragments", "", "a", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "fm", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mTitles", "b", "mFragments", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ViewPagerAdapter extends FragmentStatePagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final FragmentManager fm;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public ArrayList<String> mTitles;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public ArrayList<Fragment> mFragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPagerAdapter(@NotNull FragmentManager fragmentManager) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        this.fm = fragmentManager;
        this.mTitles = new ArrayList<>();
        this.mFragments = new ArrayList<>();
    }

    public final void a(@NotNull List<String> titles, @NotNull List<? extends Fragment> fragments) {
        FragmentManager fragmentManager;
        Intrinsics.checkNotNullParameter(titles, "titles");
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        if (this.mFragments != null && (fragmentManager = this.fm) != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fm.beginTransaction()");
            Iterator<Fragment> it = this.mFragments.iterator();
            while (it.hasNext()) {
                fragmentTransactionBeginTransaction.remove(it.next());
            }
            fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        }
        this.mTitles.clear();
        this.mTitles.addAll(titles);
        this.mFragments.clear();
        this.mFragments.addAll(fragments);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragments.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int position) {
        ArrayList<Fragment> arrayList = this.mFragments;
        Intrinsics.checkNotNull(arrayList);
        Fragment fragment = arrayList.get(position);
        Intrinsics.checkNotNullExpressionValue(fragment, "mFragments!![position]");
        return fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (CollectionsKt.contains(this.mFragments, item)) {
            return super.getItemPosition(item);
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public CharSequence getPageTitle(int position) {
        String str = this.mTitles.get(position);
        Intrinsics.checkNotNullExpressionValue(str, "mTitles[position]");
        return str;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        return null;
    }
}
