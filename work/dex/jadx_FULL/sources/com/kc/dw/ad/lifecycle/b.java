package com.kc.dw.ad.lifecycle;

import androidx.fragment.app.Fragment;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends Fragment {
    public static final int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f39121a;

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f39121a;
        if (dVar != null) {
            dVar.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        d dVar = this.f39121a;
        if (dVar != null) {
            dVar.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        d dVar = this.f39121a;
        if (dVar != null) {
            dVar.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        d dVar = this.f39121a;
        if (dVar != null) {
            dVar.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        d dVar = this.f39121a;
        if (dVar != null) {
            dVar.onStop();
        }
    }
}
