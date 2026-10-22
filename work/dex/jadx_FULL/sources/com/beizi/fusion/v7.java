package com.beizi.fusion;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class v7 implements dp, Cloneable {
    public static final v7 e = new v7();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f27860a = 136;
    private boolean b = true;
    private List c;
    private List d;

    public v7() {
        List list = Collections.EMPTY_LIST;
        this.c = list;
        this.d = list;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public v7 m169clone() {
        try {
            return (v7) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}
