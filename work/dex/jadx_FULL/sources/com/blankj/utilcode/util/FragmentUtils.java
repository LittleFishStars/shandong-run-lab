package com.blankj.utilcode.util;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.zj.adlib.c25;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class FragmentUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28137a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1265a = "args_id";
    public static final int b = 2;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f1266b = "args_is_hide";
    public static final int c = 4;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f1267c = "args_is_add_stack";
    public static final int d = 8;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f1268d = "args_tag";
    public static final int e = 16;
    public static final int f = 32;
    public static final int g = 64;

    public interface OnBackClickListener {
        boolean a();
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f28138a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1269a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f1270a;
        public final boolean b;

        public a(int i, boolean z, boolean z2) {
            this(i, null, z, z2);
        }

        public a(int i, String str, boolean z, boolean z2) {
            this.f28138a = i;
            this.f1269a = str;
            this.f1270a = z;
            this.b = z2;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Fragment f28139a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<b> f1271a;

        public b(Fragment fragment, List<b> list) {
            this.f28139a = fragment;
            this.f1271a = list;
        }

        public Fragment a() {
            return this.f28139a;
        }

        public List<b> b() {
            return this.f1271a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f28139a.getClass().getSimpleName());
            sb.append(c25.j);
            List<b> list = this.f1271a;
            sb.append((list == null || list.isEmpty()) ? "no child" : this.f1271a.toString());
            return sb.toString();
        }
    }

    public FragmentUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Fragment A(@NonNull FragmentManager fragmentManager, Class<? extends Fragment> cls) {
        return fragmentManager.findFragmentByTag(cls.getName());
    }

    public static void A0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        D0(fragmentManager, fragment, i, str, false, i2, i3, i4, i5);
    }

    public static Fragment B(@NonNull FragmentManager fragmentManager, @NonNull String str) {
        return fragmentManager.findFragmentByTag(str);
    }

    public static void B0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, boolean z) {
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        a0(fragment, new a(i, str, false, z));
        S(16, fragmentManager, fragmentTransactionBeginTransaction, null, fragment);
    }

    public static List<b> C(@NonNull FragmentManager fragmentManager) {
        return D(fragmentManager, new ArrayList());
    }

    public static void C0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, boolean z, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        D0(fragmentManager, fragment, i, str, z, i2, i3, 0, 0);
    }

    public static List<b> D(@NonNull FragmentManager fragmentManager, List<b> list) {
        List<Fragment> listH = H(fragmentManager);
        for (int size = listH.size() - 1; size >= 0; size--) {
            Fragment fragment = listH.get(size);
            if (fragment != null) {
                list.add(new b(fragment, D(fragment.getChildFragmentManager(), new ArrayList())));
            }
        }
        return list;
    }

    public static void D0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, boolean z, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        a0(fragment, new a(i, str, false, z));
        w(fragmentTransactionBeginTransaction, i2, i3, i4, i5);
        S(16, fragmentManager, fragmentTransactionBeginTransaction, null, fragment);
    }

    public static List<b> E(@NonNull FragmentManager fragmentManager) {
        return F(fragmentManager, new ArrayList());
    }

    public static void E0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, boolean z, View... viewArr) {
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        a0(fragment, new a(i, str, false, z));
        x(fragmentTransactionBeginTransaction, viewArr);
        S(16, fragmentManager, fragmentTransactionBeginTransaction, null, fragment);
    }

    public static List<b> F(@NonNull FragmentManager fragmentManager, List<b> list) {
        Bundle arguments;
        List<Fragment> listH = H(fragmentManager);
        for (int size = listH.size() - 1; size >= 0; size--) {
            Fragment fragment = listH.get(size);
            if (fragment != null && (arguments = fragment.getArguments()) != null && arguments.getBoolean(f1267c)) {
                list.add(new b(fragment, F(fragment.getChildFragmentManager(), new ArrayList())));
            }
        }
        return list;
    }

    public static void F0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, View... viewArr) {
        E0(fragmentManager, fragment, i, str, false, viewArr);
    }

    public static a G(Fragment fragment) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = Bundle.EMPTY;
        }
        return new a(arguments.getInt(f1265a, fragment.getId()), arguments.getBoolean(f1266b), arguments.getBoolean(f1267c));
    }

    public static void G0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, boolean z) {
        B0(fragmentManager, fragment, i, null, z);
    }

    public static List<Fragment> H(@NonNull FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        return (fragments == null || fragments.isEmpty()) ? Collections.emptyList() : fragments;
    }

    public static void H0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, boolean z, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        D0(fragmentManager, fragment, i, null, z, i2, i3, 0, 0);
    }

    public static List<Fragment> I(@NonNull FragmentManager fragmentManager) {
        Bundle arguments;
        List<Fragment> listH = H(fragmentManager);
        ArrayList arrayList = new ArrayList();
        for (Fragment fragment : listH) {
            if (fragment != null && (arguments = fragment.getArguments()) != null && arguments.getBoolean(f1267c)) {
                arrayList.add(fragment);
            }
        }
        return arrayList;
    }

    public static void I0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, boolean z, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        D0(fragmentManager, fragment, i, null, z, i2, i3, i4, i5);
    }

    public static String J(Fragment fragment) {
        return fragment == null ? "null" : fragment.getClass().getSimpleName();
    }

    public static void J0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, boolean z, View... viewArr) {
        E0(fragmentManager, fragment, i, null, z, viewArr);
    }

    public static Fragment K(@NonNull FragmentManager fragmentManager) {
        return M(fragmentManager, null, false);
    }

    public static void K0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, View... viewArr) {
        E0(fragmentManager, fragment, i, null, false, viewArr);
    }

    public static Fragment L(@NonNull FragmentManager fragmentManager) {
        return M(fragmentManager, null, true);
    }

    public static void L0(@NonNull Fragment fragment, Drawable drawable) {
        View view = fragment.getView();
        if (view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public static Fragment M(@NonNull FragmentManager fragmentManager, Fragment fragment, boolean z) {
        List<Fragment> listH = H(fragmentManager);
        for (int size = listH.size() - 1; size >= 0; size--) {
            Fragment fragment2 = listH.get(size);
            if (fragment2 != null) {
                if (!z) {
                    return M(fragment2.getChildFragmentManager(), fragment2, false);
                }
                Bundle arguments = fragment2.getArguments();
                if (arguments != null && arguments.getBoolean(f1267c)) {
                    return M(fragment2.getChildFragmentManager(), fragment2, true);
                }
            }
        }
        return fragment;
    }

    public static void M0(@NonNull Fragment fragment, @ColorInt int i) {
        View view = fragment.getView();
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public static Fragment N(@NonNull FragmentManager fragmentManager) {
        return P(fragmentManager, null, false);
    }

    public static void N0(@NonNull Fragment fragment, @DrawableRes int i) {
        View view = fragment.getView();
        if (view != null) {
            view.setBackgroundResource(i);
        }
    }

    public static Fragment O(@NonNull FragmentManager fragmentManager) {
        return P(fragmentManager, null, true);
    }

    public static void O0(@NonNull Fragment fragment) {
        b0(fragment, false);
        T(2, fragment.getFragmentManager(), null, fragment);
    }

    public static Fragment P(@NonNull FragmentManager fragmentManager, Fragment fragment, boolean z) {
        List<Fragment> listH = H(fragmentManager);
        for (int size = listH.size() - 1; size >= 0; size--) {
            Fragment fragment2 = listH.get(size);
            if (fragment2 != null && fragment2.isResumed() && fragment2.isVisible() && fragment2.getUserVisibleHint()) {
                if (!z) {
                    return P(fragment2.getChildFragmentManager(), fragment2, false);
                }
                Bundle arguments = fragment2.getArguments();
                if (arguments != null && arguments.getBoolean(f1267c)) {
                    return P(fragment2.getChildFragmentManager(), fragment2, true);
                }
            }
        }
        return fragment;
    }

    public static void P0(@NonNull FragmentManager fragmentManager) {
        List<Fragment> listH = H(fragmentManager);
        Iterator<Fragment> it = listH.iterator();
        while (it.hasNext()) {
            b0(it.next(), false);
        }
        T(2, fragmentManager, null, (Fragment[]) listH.toArray(new Fragment[0]));
    }

    public static void Q(@NonNull Fragment fragment) {
        b0(fragment, true);
        T(4, fragment.getFragmentManager(), null, fragment);
    }

    public static void Q0(int i, @NonNull List<Fragment> list) {
        V0(list.get(i), list);
    }

    public static void R(@NonNull FragmentManager fragmentManager) {
        List<Fragment> listH = H(fragmentManager);
        Iterator<Fragment> it = listH.iterator();
        while (it.hasNext()) {
            b0(it.next(), true);
        }
        T(4, fragmentManager, null, (Fragment[]) listH.toArray(new Fragment[0]));
    }

    public static void R0(int i, @NonNull List<Fragment> list, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        W0(list.get(i), list, i2, i3, i4, i5);
    }

    public static void S(int i, @NonNull FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, Fragment fragment, Fragment... fragmentArr) {
        if (fragment != null && fragment.isRemoving()) {
            Log.e("FragmentUtils", fragment.getClass().getName() + " is isRemoving");
            return;
        }
        int i2 = 0;
        if (i == 1) {
            int length = fragmentArr.length;
            while (i2 < length) {
                Fragment fragment2 = fragmentArr[i2];
                Bundle arguments = fragment2.getArguments();
                if (arguments == null) {
                    return;
                }
                String string = arguments.getString(f1268d, fragment2.getClass().getName());
                Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(string);
                if (fragmentFindFragmentByTag != null && fragmentFindFragmentByTag.isAdded()) {
                    fragmentTransaction.remove(fragmentFindFragmentByTag);
                }
                fragmentTransaction.add(arguments.getInt(f1265a), fragment2, string);
                if (arguments.getBoolean(f1266b)) {
                    fragmentTransaction.hide(fragment2);
                }
                if (arguments.getBoolean(f1267c)) {
                    fragmentTransaction.addToBackStack(string);
                }
                i2++;
            }
        } else if (i == 2) {
            int length2 = fragmentArr.length;
            while (i2 < length2) {
                fragmentTransaction.show(fragmentArr[i2]);
                i2++;
            }
        } else if (i == 4) {
            int length3 = fragmentArr.length;
            while (i2 < length3) {
                fragmentTransaction.hide(fragmentArr[i2]);
                i2++;
            }
        } else if (i == 8) {
            fragmentTransaction.show(fragment);
            int length4 = fragmentArr.length;
            while (i2 < length4) {
                Fragment fragment3 = fragmentArr[i2];
                if (fragment3 != fragment) {
                    fragmentTransaction.hide(fragment3);
                }
                i2++;
            }
        } else if (i == 16) {
            Bundle arguments2 = fragmentArr[0].getArguments();
            if (arguments2 == null) {
                return;
            }
            String string2 = arguments2.getString(f1268d, fragmentArr[0].getClass().getName());
            fragmentTransaction.replace(arguments2.getInt(f1265a), fragmentArr[0], string2);
            if (arguments2.getBoolean(f1267c)) {
                fragmentTransaction.addToBackStack(string2);
            }
        } else if (i == 32) {
            int length5 = fragmentArr.length;
            while (i2 < length5) {
                Fragment fragment4 = fragmentArr[i2];
                if (fragment4 != fragment) {
                    fragmentTransaction.remove(fragment4);
                }
                i2++;
            }
        } else if (i == 64) {
            for (int length6 = fragmentArr.length - 1; length6 >= 0; length6--) {
                Fragment fragment5 = fragmentArr[length6];
                if (fragment5 == fragmentArr[0]) {
                    if (fragment == null) {
                        break;
                    }
                    fragmentTransaction.remove(fragment5);
                    break;
                }
                fragmentTransaction.remove(fragment5);
            }
        }
        fragmentTransaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }

    public static void S0(int i, @NonNull Fragment... fragmentArr) {
        X0(fragmentArr[i], fragmentArr);
    }

    public static void T(int i, @Nullable FragmentManager fragmentManager, Fragment fragment, Fragment... fragmentArr) {
        if (fragmentManager == null) {
            return;
        }
        S(i, fragmentManager, fragmentManager.beginTransaction(), fragment, fragmentArr);
    }

    public static void T0(@NonNull Fragment fragment, @NonNull Fragment fragment2) {
        V0(fragment, Collections.singletonList(fragment2));
    }

    public static void U(@NonNull FragmentManager fragmentManager) {
        V(fragmentManager, true);
    }

    public static void U0(@NonNull Fragment fragment, @NonNull Fragment fragment2, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        W0(fragment, Collections.singletonList(fragment2), i, i2, i3, i4);
    }

    public static void V(@NonNull FragmentManager fragmentManager, boolean z) {
        if (z) {
            fragmentManager.popBackStackImmediate();
        } else {
            fragmentManager.popBackStack();
        }
    }

    public static void V0(@NonNull Fragment fragment, @NonNull List<Fragment> list) {
        Iterator<Fragment> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                T(8, fragment.getFragmentManager(), fragment, (Fragment[]) list.toArray(new Fragment[0]));
                return;
            }
            Fragment next = it.next();
            if (next != fragment) {
                z = true;
            }
            b0(next, z);
        }
    }

    public static void W(@NonNull FragmentManager fragmentManager) {
        X(fragmentManager, true);
    }

    public static void W0(@NonNull Fragment fragment, @NonNull List<Fragment> list, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        Iterator<Fragment> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Fragment next = it.next();
            if (next != fragment) {
                z = true;
            }
            b0(next, z);
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
            w(fragmentTransactionBeginTransaction, i, i2, i3, i4);
            S(8, fragmentManager, fragmentTransactionBeginTransaction, fragment, (Fragment[]) list.toArray(new Fragment[0]));
        }
    }

    public static void X(@NonNull FragmentManager fragmentManager, boolean z) {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(0);
            if (z) {
                fragmentManager.popBackStackImmediate(backStackEntryAt.getId(), 1);
            } else {
                fragmentManager.popBackStack(backStackEntryAt.getId(), 1);
            }
        }
    }

    public static void X0(@NonNull Fragment fragment, @NonNull Fragment... fragmentArr) {
        V0(fragment, Arrays.asList(fragmentArr));
    }

    public static void Y(@NonNull FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z) {
        Z(fragmentManager, cls, z, true);
    }

    public static void Z(@NonNull FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z, boolean z2) {
        if (z2) {
            fragmentManager.popBackStackImmediate(cls.getName(), z ? 1 : 0);
        } else {
            fragmentManager.popBackStack(cls.getName(), z ? 1 : 0);
        }
    }

    public static void a(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i) {
        j(fragmentManager, fragment, i, null, false, false);
    }

    public static void a0(Fragment fragment, a aVar) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragment.setArguments(arguments);
        }
        arguments.putInt(f1265a, aVar.f28138a);
        arguments.putBoolean(f1266b, aVar.f1270a);
        arguments.putBoolean(f1267c, aVar.b);
        arguments.putString(f1268d, aVar.f1269a);
    }

    public static void b(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        i(fragmentManager, fragment, i, null, false, i2, i3, 0, 0);
    }

    public static void b0(Fragment fragment, boolean z) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragment.setArguments(arguments);
        }
        arguments.putBoolean(f1266b, z);
    }

    public static void c(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        i(fragmentManager, fragment, i, null, false, i2, i3, i4, i5);
    }

    public static void c0(@NonNull Fragment fragment) {
        T(32, fragment.getFragmentManager(), null, fragment);
    }

    public static void d(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str) {
        j(fragmentManager, fragment, i, str, false, false);
    }

    public static void d0(@NonNull FragmentManager fragmentManager) {
        T(32, fragmentManager, null, (Fragment[]) H(fragmentManager).toArray(new Fragment[0]));
    }

    public static void e(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        i(fragmentManager, fragment, i, str, false, i2, i3, 0, 0);
    }

    public static void e0(@NonNull Fragment fragment, boolean z) {
        T(64, fragment.getFragmentManager(), z ? fragment : null, fragment);
    }

    public static void f(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        i(fragmentManager, fragment, i, str, false, i2, i3, i4, i5);
    }

    public static void f0(@NonNull Fragment fragment, @NonNull Fragment fragment2) {
        l0(fragment, fragment2, null, false);
    }

    public static void g(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, boolean z) {
        j(fragmentManager, fragment, i, str, z, false);
    }

    public static void g0(@NonNull Fragment fragment, @NonNull Fragment fragment2, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2) {
        n0(fragment, fragment2, null, false, i, i2, 0, 0);
    }

    public static void h(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, boolean z, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        i(fragmentManager, fragment, i, str, z, i2, i3, 0, 0);
    }

    public static void h0(@NonNull Fragment fragment, @NonNull Fragment fragment2, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        n0(fragment, fragment2, null, false, i, i2, i3, i4);
    }

    public static void i(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, boolean z, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        a0(fragment, new a(i, str, false, z));
        w(fragmentTransactionBeginTransaction, i2, i3, i4, i5);
        S(1, fragmentManager, fragmentTransactionBeginTransaction, null, fragment);
    }

    public static void i0(@NonNull Fragment fragment, @NonNull Fragment fragment2, String str) {
        l0(fragment, fragment2, str, false);
    }

    public static void j(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, boolean z, boolean z2) {
        a0(fragment, new a(i, str, z, z2));
        T(1, fragmentManager, null, fragment);
    }

    public static void j0(@NonNull Fragment fragment, @NonNull Fragment fragment2, String str, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2) {
        n0(fragment, fragment2, str, false, i, i2, 0, 0);
    }

    public static void k(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, boolean z, @NonNull View... viewArr) {
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        a0(fragment, new a(i, str, false, z));
        x(fragmentTransactionBeginTransaction, viewArr);
        S(1, fragmentManager, fragmentTransactionBeginTransaction, null, fragment);
    }

    public static void k0(@NonNull Fragment fragment, @NonNull Fragment fragment2, String str, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        n0(fragment, fragment2, str, false, i, i2, i3, i4);
    }

    public static void l(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, @NonNull View... viewArr) {
        k(fragmentManager, fragment, i, str, false, viewArr);
    }

    public static void l0(@NonNull Fragment fragment, @NonNull Fragment fragment2, String str, boolean z) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        B0(fragmentManager, fragment2, G(fragment).f28138a, str, z);
    }

    public static void m(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, boolean z) {
        j(fragmentManager, fragment, i, null, z, false);
    }

    public static void m0(@NonNull Fragment fragment, @NonNull Fragment fragment2, String str, boolean z, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2) {
        n0(fragment, fragment2, str, z, i, i2, 0, 0);
    }

    public static void n(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, boolean z, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        i(fragmentManager, fragment, i, null, z, i2, i3, 0, 0);
    }

    public static void n0(@NonNull Fragment fragment, @NonNull Fragment fragment2, String str, boolean z, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        D0(fragmentManager, fragment2, G(fragment).f28138a, str, z, i, i2, i3, i4);
    }

    public static void o(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, boolean z, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        i(fragmentManager, fragment, i, null, z, i2, i3, i4, i5);
    }

    public static void o0(@NonNull Fragment fragment, @NonNull Fragment fragment2, String str, boolean z, View... viewArr) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        E0(fragmentManager, fragment2, G(fragment).f28138a, str, z, viewArr);
    }

    public static void p(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, boolean z, boolean z2) {
        j(fragmentManager, fragment, i, null, z, z2);
    }

    public static void p0(@NonNull Fragment fragment, @NonNull Fragment fragment2, String str, View... viewArr) {
        o0(fragment, fragment2, str, false, viewArr);
    }

    public static void q(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, boolean z, @NonNull View... viewArr) {
        k(fragmentManager, fragment, i, null, z, viewArr);
    }

    public static void q0(@NonNull Fragment fragment, @NonNull Fragment fragment2, boolean z) {
        l0(fragment, fragment2, null, z);
    }

    public static void r(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, @NonNull View... viewArr) {
        k(fragmentManager, fragment, i, null, false, viewArr);
    }

    public static void r0(@NonNull Fragment fragment, @NonNull Fragment fragment2, boolean z, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2) {
        n0(fragment, fragment2, null, z, i, i2, 0, 0);
    }

    public static void s(@NonNull FragmentManager fragmentManager, @NonNull List<Fragment> list, @IdRes int i, int i2) {
        v(fragmentManager, (Fragment[]) list.toArray(new Fragment[0]), i, null, i2);
    }

    public static void s0(@NonNull Fragment fragment, @NonNull Fragment fragment2, boolean z, @AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        n0(fragment, fragment2, null, z, i, i2, i3, i4);
    }

    public static void t(@NonNull FragmentManager fragmentManager, @NonNull List<Fragment> list, @IdRes int i, String[] strArr, int i2) {
        v(fragmentManager, (Fragment[]) list.toArray(new Fragment[0]), i, strArr, i2);
    }

    public static void t0(@NonNull Fragment fragment, @NonNull Fragment fragment2, boolean z, View... viewArr) {
        o0(fragment, fragment2, null, z, viewArr);
    }

    public static void u(@NonNull FragmentManager fragmentManager, @NonNull Fragment[] fragmentArr, @IdRes int i, int i2) {
        v(fragmentManager, fragmentArr, i, null, i2);
    }

    public static void u0(@NonNull Fragment fragment, @NonNull Fragment fragment2, View... viewArr) {
        o0(fragment, fragment2, null, false, viewArr);
    }

    public static void v(@NonNull FragmentManager fragmentManager, @NonNull Fragment[] fragmentArr, @IdRes int i, String[] strArr, int i2) {
        if (strArr == null) {
            int length = fragmentArr.length;
            int i3 = 0;
            while (i3 < length) {
                a0(fragmentArr[i3], new a(i, null, i2 != i3, false));
                i3++;
            }
        } else {
            int length2 = fragmentArr.length;
            int i4 = 0;
            while (i4 < length2) {
                a0(fragmentArr[i4], new a(i, strArr[i4], i2 != i4, false));
                i4++;
            }
        }
        T(1, fragmentManager, null, fragmentArr);
    }

    public static void v0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i) {
        B0(fragmentManager, fragment, i, null, false);
    }

    public static void w(FragmentTransaction fragmentTransaction, int i, int i2, int i3, int i4) {
        fragmentTransaction.setCustomAnimations(i, i2, i3, i4);
    }

    public static void w0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        D0(fragmentManager, fragment, i, null, false, i2, i3, 0, 0);
    }

    public static void x(FragmentTransaction fragmentTransaction, View... viewArr) {
        for (View view : viewArr) {
            fragmentTransaction.addSharedElement(view, view.getTransitionName());
        }
    }

    public static void x0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5) {
        D0(fragmentManager, fragment, i, null, false, i2, i3, i4, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean y(@NonNull Fragment fragment) {
        return fragment.isResumed() && fragment.isVisible() && fragment.getUserVisibleHint() && (fragment instanceof OnBackClickListener) && ((OnBackClickListener) fragment).a();
    }

    public static void y0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str) {
        B0(fragmentManager, fragment, i, str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean z(@NonNull FragmentManager fragmentManager) {
        List<Fragment> listH = H(fragmentManager);
        if (listH != null && !listH.isEmpty()) {
            for (int size = listH.size() - 1; size >= 0; size--) {
                Fragment fragment = listH.get(size);
                if (fragment != 0 && fragment.isResumed() && fragment.isVisible() && fragment.getUserVisibleHint() && (fragment instanceof OnBackClickListener) && ((OnBackClickListener) fragment).a()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void z0(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @IdRes int i, String str, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3) {
        D0(fragmentManager, fragment, i, str, false, i2, i3, 0, 0);
    }
}
