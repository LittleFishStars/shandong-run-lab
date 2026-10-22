package com.kwad.components.core.page.widget.a;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.kwad.components.core.proxy.j;
import com.kwad.components.core.t.q;
import com.kwad.components.core.t.w;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class b extends j implements DialogInterface.OnKeyListener {

    @StyleRes
    private int agB;
    protected a agC;
    protected Fragment agD;
    protected int agx;
    protected int agy;
    private boolean agz;
    protected View mRootView;
    protected boolean agv = false;
    protected boolean agw = true;
    protected boolean agA = true;
    private boolean agE = true;
    private int agF = -1;
    private float agG = -1.0f;
    private final com.kwad.sdk.l.a.a mBackPressDelete = new com.kwad.sdk.l.a.a();
    private boolean agH = true;
    protected int agI = R.style.ksad_Theme_Dialog_Translucent;

    public interface a {
        Fragment vj();
    }

    private void b(Dialog dialog) {
        int iK;
        Window window = dialog == null ? null : dialog.getWindow();
        if (window != null) {
            int i = -2;
            if (vd()) {
                iK = -2;
            } else {
                iK = this.agy;
                if (iK == 0) {
                    iK = com.kwad.sdk.c.a.a.k(getActivity());
                }
            }
            if (!ve() && (i = this.agx) == 0) {
                i = -1;
            }
            window.setLayout(i, iK);
            window.setGravity(17);
            if (!this.agA) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.setDimAmount(0.0f);
            }
            boolean zVh = vh();
            int i2 = this.agB;
            if (i2 != 0) {
                window.setWindowAnimations(i2);
            } else if (vg()) {
                window.setWindowAnimations(vf());
            }
            window.setGravity((this.agz && zVh) ? 21 : 81);
        }
    }

    private boolean vd() {
        return this.agw;
    }

    private boolean ve() {
        return this.agv;
    }

    private static int vf() {
        return R.style.ksad_Theme_Slide;
    }

    private boolean vg() {
        return this.agE;
    }

    private boolean vh() {
        Activity activity = getActivity();
        if (q.isInMultiWindowMode(activity)) {
            return q.e(activity);
        }
        Resources resources = ServiceProvider.getContext().getApplicationContext().getResources();
        return (resources == null || resources.getConfiguration() == null || resources.getConfiguration().orientation != 2) ? false : true;
    }

    private void vi() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, this.agF);
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        a aVar = this.agC;
        if (aVar != null) {
            this.agD = aVar.vj();
            try {
                getChildFragmentManager().beginTransaction().replace(R.id.ksad_half_container_content_fragment, this.agD).commitAllowingStateLoss();
                getChildFragmentManager().executePendingTransactions();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(getLayoutId(), viewGroup, true);
        }
        return this.mRootView;
    }

    public final b bB(@StyleRes int i) {
        this.agB = i;
        return this;
    }

    public final void bC(int i) {
        this.agF = i;
        vi();
    }

    public int getLayoutId() {
        return R.layout.ksad_half_container_dialog_fragment;
    }

    public final void j(float f) {
        this.agG = f;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Dialog dialog = getDialog();
        b(dialog);
        Window window = dialog != null ? dialog.getWindow() : null;
        super.onActivityCreated(bundle);
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (this.agF < 0 && !Objects.equals(getTag(), "sensitive_words")) {
                this.agF = w.aR(ServiceProvider.getContext().getApplicationContext()) ? -2 : -1;
            }
            window.setLayout(-1, this.agF);
            if (this.agG > -1.0f) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.dimAmount = this.agG;
                window.setAttributes(attributes);
            }
        }
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.page.widget.a.b.1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    ComponentCallbacks2 componentCallbacks2 = b.this.agD;
                    if (!(componentCallbacks2 instanceof DialogInterface.OnKeyListener)) {
                        return false;
                    }
                    ((DialogInterface.OnKeyListener) componentCallbacks2).onKey(dialogInterface, i, keyEvent);
                    return false;
                }
            });
        }
    }

    @Override // android.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        dialogOnCreateDialog.setOnKeyListener(this);
        dialogOnCreateDialog.setCanceledOnTouchOutside(this.agH);
        if (uW() != 0) {
            setStyle(1, uW());
        }
        return dialogOnCreateDialog;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4) {
            return this.mBackPressDelete.onBackPressed();
        }
        return false;
    }

    public final void setCanceledOnTouchOutside(boolean z) {
        this.agH = z;
        if (getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(this.agH);
        }
    }

    public int uW() {
        return this.agI;
    }

    public final void a(a aVar) {
        this.agC = aVar;
    }
}
