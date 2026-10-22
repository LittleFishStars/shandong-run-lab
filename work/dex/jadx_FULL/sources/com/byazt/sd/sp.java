package com.byazt.sd;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.byazt.hu.sl;
import com.byazt.s.t;
import com.byazt.s.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 470, 91})
public class sp extends com.byazt.s.c {
    public static String c = "sp";

    @com.byazt.zqa.c(c = {0, 1, 470, 180})
    public static class c implements t {
        public Dialog c;

        public c(Dialog dialog) {
            if (dialog != null) {
                this.c = dialog;
                c();
            }
        }

        @Override // com.byazt.s.t
        public void c() {
            Dialog dialog = this.c;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.byazt.s.t
        public boolean tt() {
            Dialog dialog = this.c;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.byazt.s.c, com.byazt.s.uj
    public u c(Context context) {
        return new u(context) { // from class: com.byazt.sd.sp.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public DialogInterface.OnCancelListener f29004a;
            public final /* synthetic */ Context c;
            public DialogInterface.OnClickListener n;
            public DialogInterface.OnClickListener uj;
            public com.byazt.e.tt.c ve;

            {
                this.c = context;
                this.ve = new com.byazt.e.tt.c(context);
            }

            @Override // com.byazt.s.u
            public u c(CharSequence charSequence) {
                this.ve.c((String) charSequence);
                return this;
            }

            @Override // com.byazt.s.u
            public u tt(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
                this.ve.uj((String) charSequence);
                this.n = onClickListener;
                return this;
            }

            @Override // com.byazt.s.u
            public u c(String str) {
                this.ve.tt(str);
                return this;
            }

            @Override // com.byazt.s.u
            public u c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
                this.ve.ve((String) charSequence);
                this.uj = onClickListener;
                return this;
            }

            @Override // com.byazt.s.u
            public u c(DialogInterface.OnCancelListener onCancelListener) {
                this.f29004a = onCancelListener;
                return this;
            }

            @Override // com.byazt.s.u
            public u c(boolean z) {
                this.ve.c(z);
                return this;
            }

            @Override // com.byazt.s.u
            public t c() {
                this.ve.c(new com.byazt.e.tt.InterfaceC0394tt() { // from class: com.byazt.sd.sp.1.1
                    @Override // com.byazt.e.tt.InterfaceC0394tt
                    public void c(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.uj != null) {
                            AnonymousClass1.this.uj.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.byazt.e.tt.InterfaceC0394tt
                    public void tt(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.n != null) {
                            AnonymousClass1.this.n.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.byazt.e.tt.InterfaceC0394tt
                    public void ve(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f29004a == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f29004a.onCancel(dialogInterface);
                    }
                });
                sl.c(sp.c, "getThemedAlertDlgBuilder", null);
                this.ve.c(3);
                return new c(com.byazt.gq.t.ve().tt(this.ve.c()));
            }
        };
    }
}
