package com.byazt.rpt;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.dna.qp;
import com.byazt.ete.ic;
import com.byazt.ete.to;
import com.byazt.nr.d;
import com.byazt.omf.gt;
import com.byazt.vfu.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 311, 13})
public class tt extends AlertDialog implements qp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f28998a;
    public com.byazt.hkv.tt c;
    public boolean da;
    public long i;
    public TextView n;
    public final String sp;
    public final d tt;
    public TextView uj;
    public Context ve;
    public final c x;

    public interface c {
        void c(Dialog dialog);

        void tt(Dialog dialog);
    }

    public tt(Context context, ic icVar, c cVar) {
        super(context);
        this.tt = new d(Looper.getMainLooper(), this);
        this.da = false;
        this.ve = context;
        if (context == null) {
            this.ve = gt.getContext();
        }
        this.sp = to.a(icVar);
        this.x = cVar;
        if (to.n(icVar) != 3) {
            this.i = to.x(icVar);
        } else {
            this.da = true;
            this.i = 5L;
        }
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        c cVar;
        if (message.what == 101) {
            long j = this.i - 1;
            this.i = j;
            if (j > 0) {
                if (this.da) {
                    pf.c(this.f28998a, "残忍拒绝");
                } else {
                    pf.c(this.f28998a, String.format("残忍拒绝(%1$s)", String.valueOf(j)));
                }
                this.tt.sendEmptyMessageDelayed(101, 1000L);
                return;
            }
            if (this.da && (cVar = this.x) != null) {
                cVar.tt(this);
            }
            c cVar2 = this.x;
            if (cVar2 != null) {
                cVar2.c(this);
            }
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.qp(this.ve));
        setCanceledOnTouchOutside(false);
        c();
        this.tt.sendEmptyMessageDelayed(101, 1000L);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            this.tt.removeMessages(101);
        } else {
            this.tt.removeMessages(101);
            this.tt.sendEmptyMessageDelayed(101, 1000L);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        pf.c(this.uj, this.sp);
    }

    private void c() {
        this.uj = (TextView) findViewById(2114387826);
        this.n = (TextView) findViewById(2114387638);
        this.f28998a = (TextView) findViewById(2114387833);
        if (this.x == null) {
            return;
        }
        pf.c((View) this.n, (View.OnClickListener) this.c, "goLiveListener");
        pf.c(this.f28998a, new View.OnClickListener() { // from class: com.byazt.rpt.tt.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tt.this.x.c(tt.this);
            }
        }, "cancelTv");
    }

    public void c(com.byazt.hkv.tt ttVar) {
        this.c = ttVar;
    }
}
