package com.google.android.gms.dynamic;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.zj.adlib.b2c;
import com.zj.adlib.pv3;
import com.zj.adlib.s3c;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Bundle f31317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LifecycleDelegate f5710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnDelegateCreatedListener f5711a = new a(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinkedList f5712a;

    @KeepForSdk
    public DeferredLifecycleHelper() {
    }

    @KeepForSdk
    public static void m(@NonNull FrameLayout frameLayout) {
        pv3 pv3VarX = pv3.x();
        Context context = frameLayout.getContext();
        int iJ = pv3VarX.j(context);
        String strD = b2c.d(context, iJ);
        String strC = b2c.c(context, iJ);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(strD);
        linearLayout.addView(textView);
        Intent intentE = pv3VarX.e(context, iJ, null);
        if (intentE != null) {
            Button button = new Button(context);
            button.setId(R.id.button1);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(strC);
            linearLayout.addView(button);
            button.setOnClickListener(new s3c(context, intentE));
        }
    }

    @NonNull
    @KeepForSdk
    public T a() {
        return (T) this.f5710a;
    }

    @KeepForSdk
    public void b(@Nullable Bundle bundle) {
        s(bundle, new c(this, bundle));
    }

    @NonNull
    @KeepForSdk
    public View c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        s(bundle, new d(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f5710a == null) {
            handleGooglePlayUnavailable(frameLayout);
        }
        return frameLayout;
    }

    @KeepForSdk
    public abstract void createDelegate(@NonNull OnDelegateCreatedListener<T> onDelegateCreatedListener);

    @KeepForSdk
    public void d() {
        LifecycleDelegate lifecycleDelegate = this.f5710a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroy();
        } else {
            r(1);
        }
    }

    @KeepForSdk
    public void e() {
        LifecycleDelegate lifecycleDelegate = this.f5710a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroyView();
        } else {
            r(2);
        }
    }

    @KeepForSdk
    public void f(@NonNull Activity activity, @NonNull Bundle bundle, @Nullable Bundle bundle2) {
        s(bundle2, new b(this, activity, bundle, bundle2));
    }

    @KeepForSdk
    public void g() {
        LifecycleDelegate lifecycleDelegate = this.f5710a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onLowMemory();
        }
    }

    @KeepForSdk
    public void h() {
        LifecycleDelegate lifecycleDelegate = this.f5710a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onPause();
        } else {
            r(5);
        }
    }

    @KeepForSdk
    public void handleGooglePlayUnavailable(@NonNull FrameLayout frameLayout) {
        m(frameLayout);
    }

    @KeepForSdk
    public void i() {
        s(null, new f(this));
    }

    @KeepForSdk
    public void j(@NonNull Bundle bundle) {
        LifecycleDelegate lifecycleDelegate = this.f5710a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f31317a;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @KeepForSdk
    public void k() {
        s(null, new e(this));
    }

    @KeepForSdk
    public void l() {
        LifecycleDelegate lifecycleDelegate = this.f5710a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onStop();
        } else {
            r(4);
        }
    }

    public final void r(int i) {
        while (!this.f5712a.isEmpty() && ((zah) this.f5712a.getLast()).zaa() >= i) {
            this.f5712a.removeLast();
        }
    }

    public final void s(@Nullable Bundle bundle, zah zahVar) {
        LifecycleDelegate lifecycleDelegate = this.f5710a;
        if (lifecycleDelegate != null) {
            zahVar.a(lifecycleDelegate);
            return;
        }
        if (this.f5712a == null) {
            this.f5712a = new LinkedList();
        }
        this.f5712a.add(zahVar);
        if (bundle != null) {
            Bundle bundle2 = this.f31317a;
            if (bundle2 == null) {
                this.f31317a = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.f5711a);
    }
}
