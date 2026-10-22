package com.kwad.sdk.k.a;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a implements c {
    protected List<c> bms;
    protected boolean enabled;

    public a(boolean z) {
        this.enabled = z;
    }

    private List<c> getChildren() {
        return this.bms;
    }

    @Override // com.kwad.sdk.k.a.c
    public final boolean cG(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children == null || children.size() <= 0) {
            try {
                return cH(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        Iterator<c> it = children.iterator();
        while (it.hasNext()) {
            if (it.next().cG(context)) {
                return true;
            }
        }
        return false;
    }

    public boolean cH(Context context) {
        return false;
    }

    public a() {
        this.enabled = true;
    }
}
