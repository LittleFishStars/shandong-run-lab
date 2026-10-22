package com.flyco.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SlidingTabLayout extends SlidingTabLayoutBase implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f30226a;

    public class a extends FragmentPagerAdapter {
        public List<Fragment> c;
        public List<String> d;

        public a(FragmentManager fragmentManager, List<Fragment> list, List<String> list2) {
            super(fragmentManager);
            new ArrayList();
            this.c = list;
            this.d = list2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.c.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return this.c.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.d.get(i);
        }
    }

    public SlidingTabLayout(Context context) {
        super(context);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public int getCurrentItem() {
        return this.f30226a.getCurrentItem();
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public int getPageCount() {
        PagerAdapter adapter = this.f30226a.getAdapter();
        if (adapter != null) {
            return adapter.getCount();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        super.onPageScrolled(i, f, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        updateTabSelection(i);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentItem(int i) {
        this.mCurrentTab = i;
        this.f30226a.setCurrentItem(i);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentTab(int i) {
        this.mCurrentTab = i;
        this.f30226a.setCurrentItem(i);
    }

    public void setViewPager(ViewPager viewPager, List<String> list) {
        if (viewPager == null || viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
        }
        if (list == null || list.size() == 0) {
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        if (list.size() != viewPager.getAdapter().getCount()) {
            throw new IllegalStateException("Titles length must be the same as the page count !");
        }
        this.f30226a = viewPager;
        ArrayList<String> arrayList = new ArrayList<>();
        this.mTitles = arrayList;
        arrayList.addAll(list);
        this.f30226a.removeOnPageChangeListener(this);
        this.f30226a.addOnPageChangeListener(this);
        notifyDataSetChanged();
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentItem(int i, boolean z) {
        this.mCurrentTab = i;
        this.f30226a.setCurrentItem(i, z);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentTab(int i, boolean z) {
        this.mCurrentTab = i;
        this.f30226a.setCurrentItem(i, z);
    }

    public void setViewPager(ViewPager viewPager, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, strArr);
        setViewPager(viewPager, arrayList);
    }

    public void setViewPager(ViewPager viewPager, List<String> list, FragmentManager fragmentManager, List<Fragment> list2) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.mTitles = arrayList;
        arrayList.addAll(list);
        if (viewPager != null) {
            if (list != null && list.size() != 0) {
                this.f30226a = viewPager;
                viewPager.setAdapter(new a(fragmentManager, list2, list));
                this.f30226a.removeOnPageChangeListener(this);
                this.f30226a.addOnPageChangeListener(this);
                notifyDataSetChanged();
                return;
            }
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        throw new IllegalStateException("ViewPager can not be NULL !");
    }

    public void setViewPager(ViewPager viewPager, List<String> list, FragmentActivity fragmentActivity, List<Fragment> list2) {
        setViewPager(viewPager, list, fragmentActivity.getSupportFragmentManager(), list2);
    }

    public void setViewPager(ViewPager viewPager, String[] strArr, FragmentActivity fragmentActivity, List<Fragment> list) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, strArr);
        setViewPager(viewPager, arrayList, fragmentActivity, list);
    }
}
