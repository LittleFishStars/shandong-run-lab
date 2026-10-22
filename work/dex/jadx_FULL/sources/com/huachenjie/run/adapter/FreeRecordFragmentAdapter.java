package com.huachenjie.run.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import com.huachenjie.run.page.free_record.FreeRecordFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class FreeRecordFragmentAdapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FragmentManager f35430a;
    public List<String> c;
    public List<Fragment> d;

    public FreeRecordFragmentAdapter(FragmentManager fm) {
        super(fm);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.f35430a = fm;
    }

    public final void a(ArrayList<Fragment> fragments) {
        if (this.d != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = this.f35430a.beginTransaction();
            Iterator<Fragment> it = this.d.iterator();
            while (it.hasNext()) {
                fragmentTransactionBeginTransaction.remove(it.next());
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            this.f35430a.executePendingTransactions();
        }
        this.d.clear();
        this.d.addAll(fragments);
        notifyDataSetChanged();
    }

    public void c(List<String> data) {
        this.c.clear();
        this.c.addAll(data);
        ArrayList<Fragment> arrayList = new ArrayList<>();
        for (int i = 0; i < this.c.size(); i++) {
            if (i == 0) {
                arrayList.add(FreeRecordFragment.newInstance(1));
            } else if (i == 1) {
                arrayList.add(FreeRecordFragment.newInstance(2));
            } else if (i == 2) {
                arrayList.add(FreeRecordFragment.newInstance(3));
            }
        }
        a(arrayList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.c.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        return this.d.get(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return this.c.get(position);
    }
}
