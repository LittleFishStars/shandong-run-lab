package com.flyco.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SlidingTabLayout2 extends SlidingTabLayoutBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2 f30228a;
    b vpListener;

    public class b extends ViewPager2.OnPageChangeCallback {
        public b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i, float f, int i2) {
            SlidingTabLayout2 slidingTabLayout2 = SlidingTabLayout2.this;
            slidingTabLayout2.mCurrentTab = i;
            slidingTabLayout2.mCurrentPositionOffset = f;
            slidingTabLayout2.tabScaleTransformer.onPageScrolled(i, f, i2);
            SlidingTabLayout2.this.scrollToCurrentTab();
            SlidingTabLayout2.this.invalidate();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            SlidingTabLayout2.this.updateTabSelection(i);
        }
    }

    public SlidingTabLayout2(Context context) {
        this(context, null, 0);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public int getCurrentItem() {
        return this.f30228a.getCurrentItem();
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public int getPageCount() {
        RecyclerView.Adapter adapter = this.f30228a.getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public final void h(ViewPager2 viewPager2) {
        ViewPager2 viewPager3 = this.f30228a;
        if (viewPager3 != null) {
            viewPager3.unregisterOnPageChangeCallback(this.vpListener);
        }
        this.f30228a = viewPager2;
        viewPager2.registerOnPageChangeCallback(this.vpListener);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentItem(int i) {
        this.f30228a.setCurrentItem(i);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        this.f30228a.setCurrentItem(i);
    }

    public void setViewPager(ViewPager2 viewPager2, List<String> list) {
        if (viewPager2 == null || viewPager2.getAdapter() == null) {
            throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
        }
        if (list == null || list.size() == 0) {
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        if (list.size() != viewPager2.getAdapter().getItemCount()) {
            throw new IllegalStateException("Titles length must be the same as the page count !");
        }
        this.f30228a = viewPager2;
        ArrayList<String> arrayList = new ArrayList<>();
        this.mTitles = arrayList;
        arrayList.addAll(list);
        h(viewPager2);
        notifyDataSetChanged();
    }

    public SlidingTabLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentItem(int i, boolean z) {
        this.f30228a.setCurrentItem(i, z);
    }

    public SlidingTabLayout2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vpListener = new b();
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentTab(int i, boolean z) {
        this.mCurrentTab = i;
        this.f30228a.setCurrentItem(i, z);
    }

    public class a extends FragmentStateAdapter {
        public List<Fragment> f;

        public a(FragmentActivity fragmentActivity, List<Fragment> list) {
            super(fragmentActivity);
            new ArrayList();
            this.f = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            return this.f.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f.size();
        }

        public a(FragmentActivity fragmentActivity, List<Fragment> list, Lifecycle lifecycle) {
            super(fragmentActivity.getSupportFragmentManager(), lifecycle);
            new ArrayList();
            this.f = list;
        }

        public a(List<Fragment> list, FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            new ArrayList();
            this.f = list;
        }
    }

    public void setViewPager(ViewPager2 viewPager2, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, strArr);
        setViewPager(viewPager2, arrayList);
    }

    public void setViewPager(ViewPager2 viewPager2, List<String> list, FragmentManager fragmentManager, FragmentActivity fragmentActivity, List<Fragment> list2) {
        if (viewPager2 != null) {
            if (list != null && list.size() != 0) {
                h(viewPager2);
                this.f30228a.setAdapter(new a(list2, fragmentManager, fragmentActivity.getLifecycle()));
                ArrayList<String> arrayList = new ArrayList<>();
                this.mTitles = arrayList;
                arrayList.addAll(list);
                notifyDataSetChanged();
                return;
            }
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        throw new IllegalStateException("ViewPager can not be NULL !");
    }

    public void setViewPager(ViewPager2 viewPager2, List<String> list, FragmentActivity fragmentActivity, List<Fragment> list2) {
        if (viewPager2 != null) {
            if (list != null && list.size() != 0) {
                h(viewPager2);
                this.f30228a.setAdapter(new a(fragmentActivity, list2, fragmentActivity.getLifecycle()));
                ArrayList<String> arrayList = new ArrayList<>();
                this.mTitles = arrayList;
                arrayList.addAll(list);
                notifyDataSetChanged();
                return;
            }
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        throw new IllegalStateException("ViewPager can not be NULL !");
    }

    public void setViewPager(ViewPager2 viewPager2, String[] strArr, FragmentActivity fragmentActivity, List<Fragment> list) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, strArr);
        setViewPager(viewPager2, arrayList, fragmentActivity, list);
    }
}
