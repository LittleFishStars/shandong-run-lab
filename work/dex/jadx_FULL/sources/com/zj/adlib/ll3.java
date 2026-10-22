package com.zj.adlib;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ll3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FragmentManager f17986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<Fragment> f17987a;
    public int b;

    public ll3(FragmentManager fragmentManager, int i, ArrayList<Fragment> arrayList) {
        this.f17986a = fragmentManager;
        this.f43093a = i;
        this.f17987a = arrayList;
        c();
    }

    public Fragment a() {
        return this.f17987a.get(this.b);
    }

    public int b() {
        return this.b;
    }

    public final void c() {
        for (Fragment fragment : this.f17987a) {
            this.f17986a.beginTransaction().add(this.f43093a, fragment).hide(fragment).commit();
        }
        d(0);
    }

    public void d(int i) {
        for (int i2 = 0; i2 < this.f17987a.size(); i2++) {
            FragmentTransaction fragmentTransactionBeginTransaction = this.f17986a.beginTransaction();
            Fragment fragment = this.f17987a.get(i2);
            if (i2 == i) {
                fragmentTransactionBeginTransaction.show(fragment);
            } else {
                fragmentTransactionBeginTransaction.hide(fragment);
            }
            fragmentTransactionBeginTransaction.commit();
        }
        this.b = i;
    }
}
