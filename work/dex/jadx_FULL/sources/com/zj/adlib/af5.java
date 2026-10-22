package com.zj.adlib;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/zj/adlib/af5;", "", "", "a", "I", "()I", "b", "(I)V", "value", "<init>", "common_release"}, k = 1, mv = {1, 8, 0})
public final class af5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int value;

    public af5() {
        this(0, 1, null);
    }

    public af5(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public final void b(int i) {
        this.value = i;
    }

    public /* synthetic */ af5(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i);
    }
}
