package com.bytedance.pangle.fragment;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import androidx.annotation.Keep;
import com.byazt.jna.ve;
import com.bytedance.pangle.Zeus;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
@SuppressLint({"NewApi"})
public class ReportBaseFragment extends Fragment {
    public Application.ActivityLifecycleCallbacks callbacks = new ve(this);

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
    }
}
