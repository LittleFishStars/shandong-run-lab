package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zj.adlib.n84;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class SupportRequestBarManagerFragment extends Fragment {
    private n84 mDelegate;

    public e get(Object obj) {
        if (this.mDelegate == null) {
            this.mDelegate = new n84(obj);
        }
        return this.mDelegate.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        n84 n84Var = this.mDelegate;
        if (n84Var != null) {
            n84Var.c(getResources().getConfiguration());
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n84 n84Var = this.mDelegate;
        if (n84Var != null) {
            n84Var.d(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        n84 n84Var = this.mDelegate;
        if (n84Var != null) {
            n84Var.e();
            this.mDelegate = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        n84 n84Var = this.mDelegate;
        if (n84Var != null) {
            n84Var.f();
        }
    }

    public e get(Activity activity, Dialog dialog) {
        if (this.mDelegate == null) {
            this.mDelegate = new n84(activity, dialog);
        }
        return this.mDelegate.b();
    }
}
