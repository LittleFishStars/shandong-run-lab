package com.ipd.dsp.internal.components.glide.manager;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ipd.dsp.internal.b.h;
import com.ipd.dsp.internal.d0.m;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.q.z;
import com.ipd.dsp.internal.w.f;
import com.ipd.dsp.internal.w.g;
import com.ipd.dsp.internal.w.i;
import com.ipd.dsp.internal.w.j;
import com.ipd.dsp.internal.w.n;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements Handler.Callback {
    public static final InterfaceC0873b f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile h f38266a;
    public final InterfaceC0873b b;
    public final ArrayMap<View, Fragment> c = new ArrayMap<>();
    public final i d;
    public final com.ipd.dsp.internal.components.glide.manager.a e;

    public class a implements InterfaceC0873b {
        @Override // com.ipd.dsp.internal.components.glide.manager.b.InterfaceC0873b
        @NonNull
        public h a(@NonNull com.ipd.dsp.internal.components.glide.a aVar, @NonNull j jVar, @NonNull n nVar, @NonNull Context context) {
            return new h(aVar, jVar, nVar, context);
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.components.glide.manager.b$b, reason: collision with other inner class name */
    public interface InterfaceC0873b {
        @NonNull
        h a(@NonNull com.ipd.dsp.internal.components.glide.a aVar, @NonNull j jVar, @NonNull n nVar, @NonNull Context context);
    }

    public b(@Nullable InterfaceC0873b interfaceC0873b) {
        interfaceC0873b = interfaceC0873b == null ? f : interfaceC0873b;
        this.b = interfaceC0873b;
        this.e = new com.ipd.dsp.internal.components.glide.manager.a(interfaceC0873b);
        this.d = a();
    }

    public static i a() {
        return (z.g && z.f) ? new com.ipd.dsp.internal.w.h() : new f();
    }

    public static boolean d(Context context) {
        Activity activityA = a(context);
        return activityA == null || !activityA.isFinishing();
    }

    @NonNull
    public h b(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (o.e() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return a((FragmentActivity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        return c(context);
    }

    @NonNull
    public final h c(@NonNull Context context) {
        if (this.f38266a == null) {
            synchronized (this) {
                if (this.f38266a == null) {
                    this.f38266a = this.b.a(com.ipd.dsp.internal.components.glide.a.a(context.getApplicationContext()), new com.ipd.dsp.internal.w.a(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f38266a;
    }

    @Override // android.os.Handler.Callback
    @Deprecated
    public boolean handleMessage(Message message) {
        return false;
    }

    @NonNull
    public h a(@NonNull FragmentActivity fragmentActivity) {
        if (o.d()) {
            return b(fragmentActivity.getApplicationContext());
        }
        a((Activity) fragmentActivity);
        this.d.a(fragmentActivity);
        boolean zD = d(fragmentActivity);
        return this.e.a(fragmentActivity, com.ipd.dsp.internal.components.glide.a.a(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), zD);
    }

    @NonNull
    @Deprecated
    public h b(@NonNull Activity activity) {
        return b(activity.getApplicationContext());
    }

    @NonNull
    public h a(@NonNull Fragment fragment) {
        m.a(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (o.d()) {
            return b(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.d.a(fragment.getActivity());
        }
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Context context = fragment.getContext();
        return this.e.a(context, com.ipd.dsp.internal.components.glide.a.a(context.getApplicationContext()), fragment.getLifecycle(), childFragmentManager, fragment.isVisible());
    }

    @NonNull
    public h a(@NonNull View view) {
        if (o.d()) {
            return b(view.getContext().getApplicationContext());
        }
        m.a(view);
        m.a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityA = a(view.getContext());
        if (activityA == null) {
            return b(view.getContext().getApplicationContext());
        }
        if (activityA instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activityA;
            Fragment fragmentA = a(view, fragmentActivity);
            return fragmentA != null ? a(fragmentA) : a(fragmentActivity);
        }
        return b(view.getContext().getApplicationContext());
    }

    public static void a(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                a(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    public final Fragment a(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.c.clear();
        a(fragmentActivity.getSupportFragmentManager().getFragments(), this.c);
        View viewFindViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.c.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.c.clear();
        return fragment;
    }

    @Nullable
    public static Activity a(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void a(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @NonNull
    @Deprecated
    public h a(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            return b(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
}
