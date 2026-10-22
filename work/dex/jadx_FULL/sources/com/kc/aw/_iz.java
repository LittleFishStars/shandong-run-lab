package com.kc.aw;

import android.util.Pair;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _iz implements Comparator<Pair<Integer, _m8>> {
    @Override // java.util.Comparator
    public final int compare(Pair<Integer, _m8> pair, Pair<Integer, _m8> pair2) {
        return ((Integer) pair.first).intValue() - ((Integer) pair2.first).intValue();
    }
}
