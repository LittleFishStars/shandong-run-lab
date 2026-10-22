package com.beizi.fusion;

import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ig extends fg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eh f27408a = new eh(false);

    public void a(String str, fg fgVar) {
        eh ehVar = this.f27408a;
        if (fgVar == null) {
            fgVar = hg.f27365a;
        }
        ehVar.put(str, fgVar);
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof ig) && ((ig) obj).f27408a.equals(this.f27408a);
        }
        return true;
    }

    public Set h() {
        return this.f27408a.entrySet();
    }

    public int hashCode() {
        return this.f27408a.hashCode();
    }

    public fg a(String str) {
        return (fg) this.f27408a.remove(str);
    }

    public void a(String str, String str2) {
        a(str, str2 == null ? hg.f27365a : new lg(str2));
    }

    public void a(String str, Number number) {
        a(str, number == null ? hg.f27365a : new lg(number));
    }
}
