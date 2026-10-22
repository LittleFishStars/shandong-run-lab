package com.huachenjie.sport.page.mine.appeallist;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AppealListFragmentAdapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f36571a;
    public final List<String> c;
    public final List<Fragment> d;

    public AppealListFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.f36571a = fragmentManager;
    }

    public final void a(ArrayList<Fragment> arrayList) {
        if (this.d != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = this.f36571a.beginTransaction();
            Iterator<Fragment> it = this.d.iterator();
            while (it.hasNext()) {
                fragmentTransactionBeginTransaction.remove(it.next());
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            this.f36571a.executePendingTransactions();
        }
        this.d.clear();
        this.d.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void c(List<String> list) {
        this.c.clear();
        this.c.addAll(list);
        ArrayList<Fragment> arrayList = new ArrayList<>();
        for (int i = 0; i < this.c.size(); i++) {
            if (i == 0) {
                arrayList.add(AppealListFragment.newInstance(100));
            } else if (i == 1) {
                arrayList.add(AppealListFragment.newInstance(10));
            }
        }
        a(arrayList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.c.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.d.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.c.get(i);
    }
}
