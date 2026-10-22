package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.widget.BZVideoView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class cj extends j3 {
    public cj(Context context, ViewGroup viewGroup, View view, String str) {
        viewGroup.setPadding(0, 0, 0, 0);
        this.f27425a = new dj(context, viewGroup, view, str);
    }

    public void a(int i, int i2, int i3, int i4) {
    }

    public void a(p1 p1Var) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof dj)) {
            ((dj) k3Var).a(p1Var);
        }
    }

    public void b(View.OnTouchListener onTouchListener) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof dj)) {
            ((dj) k3Var).b(onTouchListener);
        }
    }

    public void x() {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof dj)) {
            ((dj) k3Var).Q();
        }
    }

    public BZVideoView y() {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof dj)) {
            return ((dj) k3Var).R();
        }
        return null;
    }

    public void a(zl zlVar) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof dj)) {
            ((dj) k3Var).a(zlVar);
        }
    }

    public void a(View view) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof dj)) {
            ((dj) k3Var).a(view);
        }
    }

    public void a(int i, int i2) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof dj)) {
            ((dj) k3Var).b(i, i2);
        }
    }

    public void a(View.OnTouchListener onTouchListener) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof dj)) {
            ((dj) k3Var).a(onTouchListener);
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2) {
        k3 k3Var = this.f27425a;
        if (k3Var != null && (k3Var instanceof dj)) {
            g5 g5Var = new g5();
            if (!TextUtils.isEmpty(str)) {
                g5Var.g(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                g5Var.h(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                g5Var.e(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                g5Var.f(str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                g5Var.c(str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                g5Var.d(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                g5Var.a(str7);
            }
            if (!TextUtils.isEmpty(str8)) {
                g5Var.b(str8);
            }
            g5Var.a(i2);
            ((dj) this.f27425a).a(g5Var, i);
        }
    }
}
