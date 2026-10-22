package com.kc.dw.ad.lifecycle;

import android.app.Fragment;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a extends Fragment {
    public static final int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f39120a;

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f39120a;
        if (dVar != null) {
            dVar.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        d dVar = this.f39120a;
        if (dVar != null) {
            dVar.onPause();
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        d dVar = this.f39120a;
        if (dVar != null) {
            dVar.onResume();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d dVar = this.f39120a;
        if (dVar != null) {
            dVar.onStart();
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        d dVar = this.f39120a;
        if (dVar != null) {
            dVar.onStop();
        }
    }
}
