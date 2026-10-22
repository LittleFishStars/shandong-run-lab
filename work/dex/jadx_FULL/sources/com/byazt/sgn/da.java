package com.byazt.sgn;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.byazt.aas.pf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 72})
public class da extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f29009a;
    public TextView c;
    public Drawable da;
    public String i;
    public Context n;
    public c sl;
    public String sp;
    public TextView tt;
    public Button uj;
    public Button ve;
    public String x;

    public interface c {
        void c(Dialog dialog);

        void tt(Dialog dialog);
    }

    public da(Context context) {
        super(context, R.style.Theme.Dialog);
        com.byazt.vfu.sp.c(this);
        this.n = context;
    }

    private void tt() {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(this.f29009a);
            Drawable drawable = this.da;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.da.getIntrinsicHeight();
                int iVe = pf.ve(this.n, 45.0f);
                if (intrinsicWidth > iVe || intrinsicWidth < iVe) {
                    intrinsicWidth = iVe;
                }
                if (intrinsicHeight > iVe || intrinsicHeight < iVe) {
                    intrinsicHeight = iVe;
                }
                this.da.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.c.setCompoundDrawables(this.da, null, null, null);
                this.c.setCompoundDrawablePadding(pf.ve(this.n, 10.0f));
            }
        }
        TextView textView2 = this.tt;
        if (textView2 != null) {
            textView2.setText(this.sp);
        }
        Button button = this.ve;
        if (button != null) {
            button.setText(this.x);
        }
        Button button2 = this.uj;
        if (button2 != null) {
            button2.setText(this.i);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.vfu.a.b(this.n));
        setCanceledOnTouchOutside(true);
        c();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        tt();
    }

    public da uj(String str) {
        this.i = str;
        return this;
    }

    public da ve(String str) {
        this.x = str;
        return this;
    }

    private void c() {
        this.c = (TextView) findViewById(2114387852);
        this.tt = (TextView) findViewById(2114387654);
        this.ve = (Button) findViewById(2114387751);
        this.uj = (Button) findViewById(2114387889);
        this.ve.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.da.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                da.this.dismiss();
                if (da.this.sl != null) {
                    da.this.sl.c(da.this);
                }
            }
        });
        this.uj.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.da.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                da.this.dismiss();
                if (da.this.sl != null) {
                    da.this.sl.tt(da.this);
                }
            }
        });
    }

    public da c(String str) {
        this.f29009a = str;
        return this;
    }

    public da c(Drawable drawable) {
        this.da = drawable;
        return this;
    }

    public da c(c cVar) {
        this.sl = cVar;
        return this;
    }

    public da c(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }

    public da tt(String str) {
        this.sp = str;
        return this;
    }
}
