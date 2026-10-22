package com.huachenjie.run.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.huachenjie.common.bean.ViewItem;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class TargetPagerAdapter extends PagerAdapter {
    public List<ViewItem> c;

    public TargetPagerAdapter(List<ViewItem> data) {
        this.c = data;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(this.c.get(position).getPageView());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.c.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int position) {
        return this.c.get(position).getTitle();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(this.c.get(position).getPageView());
        return this.c.get(position).getPageView();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }
}
