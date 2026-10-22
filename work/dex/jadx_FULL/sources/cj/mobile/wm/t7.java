package cj.mobile.wm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@TargetApi(11)
public class t7 extends Fragment {
    public final k7 dexa;
    public final v7 dexb;
    public f2 dexc;
    public final HashSet<t7> dexd;
    public t7 dexe;

    public class dexb implements v7 {
        public dexb() {
        }
    }

    public t7() {
        this(new k7());
    }

    @SuppressLint({"ValidFragment"})
    public t7(k7 k7Var) {
        this.dexb = new dexb();
        this.dexd = new HashSet<>();
        this.dexa = k7Var;
    }

    private void dexa(t7 t7Var) {
        this.dexd.add(t7Var);
    }

    private void dexb(t7 t7Var) {
        this.dexd.remove(t7Var);
    }

    public k7 dexa() {
        return this.dexa;
    }

    public void dexa(f2 f2Var) {
        this.dexc = f2Var;
    }

    public f2 dexb() {
        return this.dexc;
    }

    public v7 dexc() {
        return this.dexb;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            t7 t7VarDexa = u7.dexa().dexa(getActivity().getFragmentManager());
            this.dexe = t7VarDexa;
            if (t7VarDexa != this) {
                t7VarDexa.dexa(this);
            }
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dexa.dexa();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        t7 t7Var = this.dexe;
        if (t7Var != null) {
            t7Var.dexb(this);
            this.dexe = null;
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        f2 f2Var = this.dexc;
        if (f2Var != null) {
            f2Var.dexb();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.dexa.dexb();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.dexa.dexc();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        f2 f2Var = this.dexc;
        if (f2Var != null) {
            f2Var.dexa(i);
        }
    }
}
