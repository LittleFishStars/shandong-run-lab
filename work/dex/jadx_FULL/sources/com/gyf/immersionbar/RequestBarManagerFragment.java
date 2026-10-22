package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.zj.adlib.n84;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class RequestBarManagerFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n84 f32544a;

    public e a(Activity activity, Dialog dialog) {
        if (this.f32544a == null) {
            this.f32544a = new n84(activity, dialog);
        }
        return this.f32544a.b();
    }

    public e b(Object obj) {
        if (this.f32544a == null) {
            this.f32544a = new n84(obj);
        }
        return this.f32544a.b();
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        n84 n84Var = this.f32544a;
        if (n84Var != null) {
            n84Var.c(getResources().getConfiguration());
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n84 n84Var = this.f32544a;
        if (n84Var != null) {
            n84Var.d(configuration);
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        n84 n84Var = this.f32544a;
        if (n84Var != null) {
            n84Var.e();
            this.f32544a = null;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        n84 n84Var = this.f32544a;
        if (n84Var != null) {
            n84Var.f();
        }
    }
}
