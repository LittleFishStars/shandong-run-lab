package com.ipd.dsp.internal.components.glide.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Lifecycle;
import com.ipd.dsp.internal.b.h;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.w.k;
import com.ipd.dsp.internal.w.n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Lifecycle, h> f38264a = new HashMap();

    @NonNull
    public final com.ipd.dsp.internal.components.glide.manager.b.InterfaceC0873b b;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.components.glide.manager.a$a, reason: collision with other inner class name */
    public class C0872a implements k {
        public final /* synthetic */ Lifecycle f;

        public C0872a(Lifecycle lifecycle) {
            this.f = lifecycle;
        }

        @Override // com.ipd.dsp.internal.w.k
        public void onDestroy() {
            a.this.f38264a.remove(this.f);
        }

        @Override // com.ipd.dsp.internal.w.k
        public void onStart() {
        }

        @Override // com.ipd.dsp.internal.w.k
        public void onStop() {
        }
    }

    public a(@NonNull com.ipd.dsp.internal.components.glide.manager.b.InterfaceC0873b interfaceC0873b) {
        this.b = interfaceC0873b;
    }

    public h a(Lifecycle lifecycle) {
        o.b();
        return this.f38264a.get(lifecycle);
    }

    public final class b implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FragmentManager f38265a;

        public b(FragmentManager fragmentManager) {
            this.f38265a = fragmentManager;
        }

        @Override // com.ipd.dsp.internal.w.n
        @NonNull
        public Set<h> a() {
            HashSet hashSet = new HashSet();
            a(this.f38265a, hashSet);
            return hashSet;
        }

        public final void a(FragmentManager fragmentManager, Set<h> set) {
            List<Fragment> fragments = fragmentManager.getFragments();
            int size = fragments.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragments.get(i);
                a(fragment.getChildFragmentManager(), set);
                h hVarA = a.this.a(fragment.getLifecycle());
                if (hVarA != null) {
                    set.add(hVarA);
                }
            }
        }
    }

    public h a(Context context, com.ipd.dsp.internal.components.glide.a aVar, Lifecycle lifecycle, FragmentManager fragmentManager, boolean z) {
        o.b();
        h hVarA = a(lifecycle);
        if (hVarA != null) {
            return hVarA;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(lifecycle);
        h hVarA2 = this.b.a(aVar, lifecycleLifecycle, new b(fragmentManager), context);
        this.f38264a.put(lifecycle, hVarA2);
        lifecycleLifecycle.a(new C0872a(lifecycle));
        if (z) {
            hVarA2.onStart();
        }
        return hVarA2;
    }
}
