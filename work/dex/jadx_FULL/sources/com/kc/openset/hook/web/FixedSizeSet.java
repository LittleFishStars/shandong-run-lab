package com.kc.openset.hook.web;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class FixedSizeSet<E> {
    private final LinkedHashMap<E, Boolean> map = new LinkedHashMap<E, Boolean>(this) { // from class: com.kc.openset.hook.web.FixedSizeSet.1
        final FixedSizeSet this$0;

        static {
            OSETSDKProtected.interface11(4460);
        }

        {
            this.this$0 = this;
        }

        @Override // java.util.LinkedHashMap
        public native boolean removeEldestEntry(Map.Entry<E, Boolean> entry);
    };
    private final int maxSize;

    static {
        OSETSDKProtected.interface11(4461);
    }

    public FixedSizeSet(int i) {
        this.maxSize = i;
    }

    public static native /* synthetic */ int access$000(FixedSizeSet fixedSizeSet);

    public native boolean add(E e);

    public native void clear();

    public native boolean contains(E e);

    public native boolean remove(E e);

    public native int size();

    public native Set<E> toSet();
}
