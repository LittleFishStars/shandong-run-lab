package cn.jy.ad.sdk.jyinter;

import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ValueSet {
    boolean containsKey(int i);

    boolean isEmpty();

    Set<Integer> keys();

    Object objectValue(int i);

    int size();
}
