package com.flyco.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SlideTabLayout extends SlidingTabLayoutBase {
    public SlideTabLayout(Context context) {
        super(context);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public int getCurrentItem() {
        return this.mCurrentTab;
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public int getPageCount() {
        ArrayList<String> arrayList = this.mTitles;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentItem(int i) {
        onPageScrolled(i, this.mCurrentTab - i, 0);
    }

    public void setTabTitles(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        this.mTitles = arrayList;
        arrayList.addAll(list);
        if (list == null || list.size() == 0) {
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        notifyDataSetChanged();
    }

    public SlideTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.flyco.tablayout.SlidingTabLayoutBase
    public void setCurrentItem(int i, boolean z) {
        setCurrentItem(i);
    }

    public SlideTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
