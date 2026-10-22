package com.kwad.sdk.api.core.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.kwad.sdk.api.core.ComponentDestroyer;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkDynamicApi
@Keep
public class KsFragmentActivity extends FragmentActivity {
    private KsFragmentManager mFragmentManager;

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @Keep
    public final KsFragmentManager getSupportFragmentManager2() {
        if (this.mFragmentManager == null) {
            this.mFragmentManager = new KsFragmentManager(super.getSupportFragmentManager());
        }
        return this.mFragmentManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof IDelegateFragment) {
            onAttachFragment(((IDelegateFragment) fragment).getBase());
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onAttachFragment(KsFragment ksFragment) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ComponentDestroyer.destroyActivity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i) {
        super.startActivityFromFragment(fragment, intent, i);
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public void supportFinishAfterTransition() {
        super.supportFinishAfterTransition();
    }

    @Override // androidx.fragment.app.FragmentActivity
    @Keep
    public final void startActivityFromFragment(@NonNull Fragment fragment, Intent intent, int i, @Nullable Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i, bundle);
    }
}
