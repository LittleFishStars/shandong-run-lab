package com.byazt.sgn;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 20})
public class c extends AlertDialog {
    public Context c;
    public String tt;

    public c(Context context, String str) {
        super(context, R.style.Theme.Dialog);
        com.byazt.vfu.sp.c(this);
        this.c = context == null ? gt.getContext() : context;
        this.tt = str;
    }

    private void c() {
        ((TextView) findViewById(2114387699)).setText(this.tt);
        findViewById(2114387755).setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.vfu.a.bx(getContext()));
        c();
    }
}
