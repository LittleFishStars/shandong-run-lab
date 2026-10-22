package com.kwad.components.core.e.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.proxy.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e extends j {
    private com.kwad.components.core.e.d.a.C1201a RL;
    private boolean RP = false;
    private Activity mActivity;

    public static void a(Activity activity, com.kwad.components.core.e.d.a.C1201a c1201a) {
        if (activity == null || c1201a == null) {
            return;
        }
        e eVar = new e();
        eVar.RL = c1201a;
        eVar.mActivity = activity;
        eVar.show(activity.getFragmentManager(), "second_confirm_dialog");
    }

    @Override // android.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(Bundle bundle) {
        g.qK().qL();
        com.kwad.components.core.e.d.a.C1201a c1201a = this.RL;
        if (c1201a != null) {
            com.kwad.sdk.core.adlog.c.b(c1201a.getAdTemplate(), 229, (JSONObject) null);
        }
        return super.onCreateDialog(bundle);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        g.qK().qM();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.RP) {
            return;
        }
        dismiss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        try {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getDialog().setCanceledOnTouchOutside(false);
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.e.e.e.1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return i == 4;
                }
            });
            if (this.mActivity != null && this.RL != null) {
                this.RP = true;
                return new a(this.mActivity, this, this.RL);
            }
            this.RP = false;
            return null;
        } catch (Exception e) {
            this.RP = false;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }
}
