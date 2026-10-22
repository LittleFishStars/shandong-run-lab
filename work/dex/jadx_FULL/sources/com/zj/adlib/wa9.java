package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class wa9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final p f20397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Object f20398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExoTrackSelection[] f20399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ue7[] f20400a;

    @Deprecated
    public wa9(ue7[] ue7VarArr, ExoTrackSelection[] exoTrackSelectionArr, @Nullable Object obj) {
        this(ue7VarArr, exoTrackSelectionArr, p.f3610a, obj);
    }

    public boolean a(@Nullable wa9 wa9Var) {
        if (wa9Var == null || wa9Var.f20399a.length != this.f20399a.length) {
            return false;
        }
        for (int i = 0; i < this.f20399a.length; i++) {
            if (!b(wa9Var, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(@Nullable wa9 wa9Var, int i) {
        return wa9Var != null && gj9.c(this.f20400a[i], wa9Var.f20400a[i]) && gj9.c(this.f20399a[i], wa9Var.f20399a[i]);
    }

    public boolean c(int i) {
        return this.f20400a[i] != null;
    }

    public wa9(ue7[] ue7VarArr, ExoTrackSelection[] exoTrackSelectionArr, p pVar, @Nullable Object obj) {
        this.f20400a = ue7VarArr;
        this.f20399a = (ExoTrackSelection[]) exoTrackSelectionArr.clone();
        this.f20397a = pVar;
        this.f20398a = obj;
        this.f45559a = ue7VarArr.length;
    }
}
