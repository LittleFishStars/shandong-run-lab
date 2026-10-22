package com.zj.adlib;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.utils.Consts;
import com.gyf.immersionbar.RequestBarManagerFragment;
import com.gyf.immersionbar.SupportRequestBarManagerFragment;
import com.gyf.immersionbar.e;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class mf7 implements Handler.Callback {
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;
    public static final int N = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f43288a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<FragmentManager, RequestBarManagerFragment> f18187a;
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestBarManagerFragment> b;
    public final Map<String, RequestBarManagerFragment> c;
    public final Map<String, SupportRequestBarManagerFragment> d;
    public final String f;
    public final String g;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final mf7 f43289a = new mf7();
    }

    public static <T> void a(@Nullable T t, @NonNull String str) {
        if (t == null) {
            throw new NullPointerException(str);
        }
    }

    public static mf7 k() {
        return b.f43289a;
    }

    public void b(Activity activity, Dialog dialog, boolean z) {
        if (activity == null || dialog == null) {
            return;
        }
        String str = this.f + dialog.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        if (activity instanceof FragmentActivity) {
            m(((FragmentActivity) activity).getSupportFragmentManager(), str, true);
        } else {
            j(activity.getFragmentManager(), str, true);
        }
    }

    @RequiresApi(api = 17)
    public void c(Fragment fragment, boolean z) {
        if (fragment == null) {
            return;
        }
        String str = this.f + fragment.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        j(fragment.getChildFragmentManager(), str, true);
    }

    public void d(androidx.fragment.app.Fragment fragment, boolean z) {
        if (fragment == null) {
            return;
        }
        String str = this.f + fragment.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        m(fragment.getChildFragmentManager(), str, true);
    }

    public e e(Activity activity, Dialog dialog, boolean z) {
        a(activity, "activity is null");
        a(dialog, "dialog is null");
        String str = this.f + dialog.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(dialog) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? l(((FragmentActivity) activity).getSupportFragmentManager(), str).get(activity, dialog) : i(activity.getFragmentManager(), str).a(activity, dialog);
    }

    public e f(Activity activity, boolean z) {
        a(activity, "activity is null");
        String str = this.f + activity.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(activity) + ".tag.notOnly.";
        }
        return activity instanceof FragmentActivity ? l(((FragmentActivity) activity).getSupportFragmentManager(), str).get(activity) : i(activity.getFragmentManager(), str).b(activity);
    }

    @RequiresApi(api = 17)
    public e g(Fragment fragment, boolean z) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            a(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.f + fragment.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return i(fragment.getChildFragmentManager(), str).b(fragment);
    }

    public e h(androidx.fragment.app.Fragment fragment, boolean z) {
        a(fragment, "fragment is null");
        a(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof androidx.fragment.app.DialogFragment) {
            a(((androidx.fragment.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.f + fragment.getClass().getName();
        if (!z) {
            str = str + System.identityHashCode(fragment) + ".tag.notOnly.";
        }
        return l(fragment.getChildFragmentManager(), str).get(fragment);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.f18187a.remove((FragmentManager) message.obj);
            return true;
        }
        if (i == 2) {
            this.b.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
        if (i == 3) {
            this.c.remove((String) message.obj);
            return true;
        }
        if (i != 4) {
            return false;
        }
        this.d.remove((String) message.obj);
        return true;
    }

    public final RequestBarManagerFragment i(FragmentManager fragmentManager, String str) {
        return j(fragmentManager, str, false);
    }

    public final RequestBarManagerFragment j(FragmentManager fragmentManager, String str, boolean z) {
        RequestBarManagerFragment requestBarManagerFragment = (RequestBarManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestBarManagerFragment == null && (requestBarManagerFragment = this.f18187a.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            for (Fragment fragment : fragmentManager.getFragments()) {
                if (fragment instanceof RequestBarManagerFragment) {
                    String tag = fragment.getTag();
                    if (tag == null) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    } else if (tag.contains(".tag.notOnly.")) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    }
                }
            }
            requestBarManagerFragment = new RequestBarManagerFragment();
            this.f18187a.put(fragmentManager, requestBarManagerFragment);
            fragmentManager.beginTransaction().add(requestBarManagerFragment, str).commitAllowingStateLoss();
            this.f43288a.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z) {
            return requestBarManagerFragment;
        }
        if (this.c.get(str) == null) {
            this.c.put(str, requestBarManagerFragment);
            fragmentManager.beginTransaction().remove(requestBarManagerFragment).commitAllowingStateLoss();
            this.f43288a.obtainMessage(3, str).sendToTarget();
        }
        return null;
    }

    public final SupportRequestBarManagerFragment l(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return m(fragmentManager, str, false);
    }

    public final SupportRequestBarManagerFragment m(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z) {
        SupportRequestBarManagerFragment supportRequestBarManagerFragment = (SupportRequestBarManagerFragment) fragmentManager.findFragmentByTag(str);
        if (supportRequestBarManagerFragment == null && (supportRequestBarManagerFragment = this.b.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            for (androidx.fragment.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment instanceof SupportRequestBarManagerFragment) {
                    String tag = fragment.getTag();
                    if (tag == null) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    } else if (tag.contains(".tag.notOnly.")) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                    }
                }
            }
            supportRequestBarManagerFragment = new SupportRequestBarManagerFragment();
            this.b.put(fragmentManager, supportRequestBarManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestBarManagerFragment, str).commitAllowingStateLoss();
            this.f43288a.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z) {
            return supportRequestBarManagerFragment;
        }
        if (this.d.get(str) == null) {
            this.d.put(str, supportRequestBarManagerFragment);
            fragmentManager.beginTransaction().remove(supportRequestBarManagerFragment).commitAllowingStateLoss();
            this.f43288a.obtainMessage(4, str).sendToTarget();
        }
        return null;
    }

    public mf7() {
        this.f = e.class.getName() + Consts.DOT;
        this.g = ".tag.notOnly.";
        this.f18187a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.f43288a = new Handler(Looper.getMainLooper(), this);
    }
}
