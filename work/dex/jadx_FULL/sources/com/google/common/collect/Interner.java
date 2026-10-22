package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@DoNotMock("Use Interners.new*Interner")
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public interface Interner<E> {
    @CanIgnoreReturnValue
    E a(E e);
}
