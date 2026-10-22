package com.zj.adlib;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class kl3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42848a = "fragment_";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final FragmentManager f17743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<Fragment> f17744a;
    public int b = -1;

    public kl3(FragmentManager fm, int containerViewId, ArrayList<Fragment> fragments) {
        this.f17743a = fm;
        this.f17742a = containerViewId;
        this.f17744a = fragments;
        g();
        h(0);
    }

    public void a(Fragment fragment) {
        this.f17744a.add(fragment);
    }

    public Fragment b() {
        return this.f17744a.get(this.b);
    }

    public int c() {
        return this.b;
    }

    public Object d(int position) {
        if (position < 0 || position >= this.f17744a.size()) {
            return null;
        }
        return this.f17744a.get(position);
    }

    public ArrayList<Fragment> e() {
        return this.f17744a;
    }

    public void f(int index) {
        FragmentTransaction fragmentTransactionBeginTransaction = this.f17743a.beginTransaction();
        fragmentTransactionBeginTransaction.remove(this.f17744a.get(index));
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
        this.f17744a.remove(index);
    }

    public final void g() {
        List<Fragment> fragments = this.f17743a.getFragments();
        if (fragments.isEmpty()) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = this.f17743a.beginTransaction();
        for (Fragment fragment : fragments) {
            if (fragment != null && fragment.isAdded()) {
                fragmentTransactionBeginTransaction.remove(fragment);
            }
        }
        fragmentTransactionBeginTransaction.commitNowAllowingStateLoss();
    }

    public void h(int index) {
        Fragment fragment;
        if (this.b == index) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = this.f17743a.beginTransaction();
        String str = f42848a + index;
        Fragment fragmentFindFragmentByTag = this.f17743a.findFragmentByTag(str);
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag);
        } else {
            fragmentTransactionBeginTransaction.add(this.f17742a, this.f17744a.get(index), str);
        }
        int i = this.b;
        if (i >= 0 && (fragment = this.f17744a.get(i)) != null) {
            fragmentTransactionBeginTransaction.hide(fragment);
        }
        fragmentTransactionBeginTransaction.commit();
        this.b = index;
    }
}
