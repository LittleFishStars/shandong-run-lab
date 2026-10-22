package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class gi extends j3 {
    private int b;
    private List c;
    private View d;

    public gi(Context context, String str, int i, ki kiVar) {
        yi yiVar = new yi(context, str, i);
        this.f27425a = yiVar;
        yiVar.a(kiVar);
    }

    public void a(int i, View view, View view2, String str) {
        int iX = x();
        boolean zA = jl.a(iX);
        kh.c("BeiZisAd", "percent = " + iX + ",isPass = " + zA);
        if (zA) {
            this.d = w7.a(i, view, view2, str);
        }
    }

    public void b(int i) {
        this.b = i;
    }

    public int x() {
        int iIntValue;
        k3 k3Var = this.f27425a;
        if (k3Var == null || !(k3Var instanceof yi)) {
            return -1;
        }
        String strS = ((yi) k3Var).s();
        if (TextUtils.isEmpty(strS)) {
            return -1;
        }
        List<Pair> list = this.c;
        if (list != null) {
            iIntValue = -1;
            for (Pair pair : list) {
                if (strS.contains((CharSequence) pair.first)) {
                    iIntValue = ((Integer) pair.second).intValue();
                }
            }
        } else {
            iIntValue = -1;
        }
        return iIntValue == -1 ? this.b : iIntValue;
    }

    public void y() {
        View view = this.d;
        if (view != null) {
            bq.a(view);
        }
    }

    public void a(List list) {
        this.c = list;
    }

    public void a(View view, oi oiVar) {
        k3 k3Var = this.f27425a;
        if (k3Var == null || view == null || oiVar == null || !(k3Var instanceof yi)) {
            return;
        }
        ((yi) k3Var).a(view, oiVar);
    }
}
