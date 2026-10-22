package com.byazt.r;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.byazt.s.t;
import com.byazt.s.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 957, 20})
public class c extends com.byazt.s.tt {
    public AlertDialog.Builder c;

    /* JADX INFO: renamed from: com.byazt.r.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 957, 44})
    public static class C0513c implements t {
        public AlertDialog c;

        public C0513c(AlertDialog.Builder builder) {
            if (builder != null) {
                this.c = builder.show();
            }
        }

        @Override // com.byazt.s.t
        public void c() {
            AlertDialog alertDialog = this.c;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.byazt.s.t
        public boolean tt() {
            AlertDialog alertDialog = this.c;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public c(Context context) {
        this.c = new AlertDialog.Builder(context);
    }

    @Override // com.byazt.s.u
    public u c(CharSequence charSequence) {
        AlertDialog.Builder builder = this.c;
        if (builder != null) {
            builder.setTitle(charSequence);
        }
        return this;
    }

    @Override // com.byazt.s.u
    public u tt(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.c;
        if (builder != null) {
            builder.setNegativeButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.byazt.s.u
    public u c(String str) {
        AlertDialog.Builder builder = this.c;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.byazt.s.u
    public u c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.c;
        if (builder != null) {
            builder.setPositiveButton(charSequence, onClickListener);
        }
        return this;
    }

    @Override // com.byazt.s.u
    public u c(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.c;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.byazt.s.u
    public t c() {
        return new C0513c(this.c);
    }
}
