package com.alibaba.triver.basic.city.widget;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.triver.basic.city.adapter.b;
import com.alibaba.triver.basic.city.b.c;
import com.alibaba.triver.basic.city.b.d;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24710a = "TRCityPicker";
    private WeakReference<FragmentManager> b;
    private boolean c;
    private int d;
    private d e;
    private List<c> f;
    private b g;
    private boolean h = true;
    private boolean i = true;

    private a(Fragment fragment) {
        this.b = new WeakReference<>(fragment.getChildFragmentManager());
    }

    public static a a(Fragment fragment) {
        return new a(fragment);
    }

    public a b(boolean z) {
        this.i = z;
        return this;
    }

    public a c(boolean z) {
        this.c = z;
        return this;
    }

    public static a a(FragmentActivity fragmentActivity) {
        return new a(fragmentActivity);
    }

    public a a(d dVar) {
        this.e = dVar;
        return this;
    }

    public a a(List<c> list) {
        this.f = list;
        return this;
    }

    private a(FragmentActivity fragmentActivity) {
        this.b = new WeakReference<>(fragmentActivity.getSupportFragmentManager());
    }

    public a a(boolean z) {
        this.h = z;
        return this;
    }

    public a a(b bVar) {
        this.g = bVar;
        return this;
    }

    public void a() {
        FragmentTransaction fragmentTransactionBeginTransaction = this.b.get().beginTransaction();
        Fragment fragmentFindFragmentByTag = this.b.get().findFragmentByTag(f24710a);
        if (fragmentFindFragmentByTag != null) {
            fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag).commit();
            fragmentTransactionBeginTransaction = this.b.get().beginTransaction();
        }
        fragmentTransactionBeginTransaction.addToBackStack(null);
        TRCityPickerDialogFragment tRCityPickerDialogFragmentNewInstance = TRCityPickerDialogFragment.newInstance(this.c);
        tRCityPickerDialogFragmentNewInstance.setLocatedCity(this.e);
        tRCityPickerDialogFragmentNewInstance.setHotCities(this.f);
        tRCityPickerDialogFragmentNewInstance.setShowLocationCity(this.i);
        tRCityPickerDialogFragmentNewInstance.setShowHotCities(this.h);
        tRCityPickerDialogFragmentNewInstance.setAnimationStyle(this.d);
        tRCityPickerDialogFragmentNewInstance.setOnPickListener(this.g);
        tRCityPickerDialogFragmentNewInstance.show(fragmentTransactionBeginTransaction, f24710a);
    }

    public void a(d dVar, int i) {
        TRCityPickerDialogFragment tRCityPickerDialogFragment = (TRCityPickerDialogFragment) this.b.get().findFragmentByTag(f24710a);
        if (tRCityPickerDialogFragment != null) {
            tRCityPickerDialogFragment.locationChanged(dVar, i);
        }
    }
}
