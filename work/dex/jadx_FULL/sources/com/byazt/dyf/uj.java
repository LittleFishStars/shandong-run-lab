package com.byazt.dyf;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.byazt.ff.TTDislikeLayout;
import com.byazt.ff.TTDislikeScrollListView;
import com.byazt.nc.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 746, 15})
public class uj extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f28439a;
    public com.byazt.sif.ve c;
    public TextView n;
    public final boolean sp;
    public TTDislikeLayout tt;
    public boolean uj;
    public final com.byazt.vo.tt ve;

    public uj(Context context, com.byazt.vo.tt ttVar, c cVar) {
        super(context);
        this.uj = false;
        getWindow().addFlags(1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.ve = ttVar;
        this.sp = ttVar != null ? ttVar.tt() : false;
        this.f28439a = cVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.byazt.sif.ve veVar = this.c;
        if (veVar == null || this.uj) {
            return;
        }
        veVar.ve();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        setContentView(com.byazt.vfu.uj.c(getContext(), this.sp), c());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        tt();
        ve();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.uj = false;
            com.byazt.sif.ve veVar = this.c;
            if (veVar != null) {
                veVar.tt();
            }
        } catch (Exception unused) {
        }
    }

    private void tt() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.34f);
        }
    }

    private void ve() {
        TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(2047279103);
        this.tt = tTDislikeLayout;
        c(tTDislikeLayout);
    }

    public void c(com.byazt.sif.ve veVar) {
        this.c = veVar;
    }

    public ViewGroup.LayoutParams c() {
        return new ViewGroup.LayoutParams(com.byazt.pr.c.tt().c(getContext(), 345.0f), -2);
    }

    public void c(com.byazt.vo.tt ttVar) {
        TTDislikeLayout tTDislikeLayout;
        if (ttVar == null || (tTDislikeLayout = this.tt) == null) {
            return;
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) tTDislikeLayout.findViewById(2047279097);
        n nVar = (n) tTDislikeScrollListView.getAdapter();
        if (nVar != null) {
            tTDislikeScrollListView.setDislikeController(new com.byazt.pr.tt(ttVar));
            nVar.c(ttVar.c());
        }
    }

    private void c(View view) {
        if (view == null) {
            return;
        }
        if (!this.sp) {
            TextView textView = (TextView) view.findViewById(2047279095);
            this.n = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.dyf.uj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (uj.this.c != null) {
                        uj.this.c.c();
                    }
                    uj.this.dismiss();
                }
            });
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) view.findViewById(2047279097);
        tTDislikeScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.byazt.dyf.uj.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                try {
                    a aVar = uj.this.ve.c().get(i);
                    if (uj.this.sp && "99:1".equals(aVar.getId())) {
                        return;
                    }
                    if (uj.this.c != null) {
                        uj.this.c.c(i, aVar);
                        uj.this.uj = true;
                    }
                    uj.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        com.byazt.vo.tt ttVar = this.ve;
        n nVar = new n(getContext(), ttVar == null ? new ArrayList<>(0) : ttVar.c(), this.sp, this.f28439a);
        nVar.c(new n.c() { // from class: com.byazt.dyf.uj.3
            @Override // com.byazt.dyf.n.c
            public void c(int i, a aVar) {
                if (uj.this.c != null) {
                    uj.this.c.c(i, aVar);
                    uj.this.uj = true;
                }
                uj.this.dismiss();
                com.byazt.pr.c.c().c(uj.this.ve, aVar);
            }
        });
        tTDislikeScrollListView.setAdapter((ListAdapter) nVar);
        com.byazt.vo.tt ttVar2 = this.ve;
        if (ttVar2 != null) {
            tTDislikeScrollListView.setDislikeController(new com.byazt.pr.tt(ttVar2));
        }
    }

    public void c(String str) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
