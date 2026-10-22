package cj.mobile.wm;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class da {
    public final int dexa;
    public final byte[] dexb;
    public final Map<String, String> dexc;
    public final List<aa> dexd;
    public final boolean dexe;
    public final long dexf;

    public da(int i, byte[] bArr, Map<String, String> map, List<aa> list, boolean z, long j) {
        this.dexa = i;
        this.dexb = bArr;
        this.dexc = map;
        this.dexd = list == null ? null : Collections.unmodifiableList(list);
        this.dexe = z;
        this.dexf = j;
    }

    public da(int i, byte[] bArr, boolean z, long j, List<aa> list) {
        this(i, bArr, dexa(list), list, z, j);
    }

    public static Map<String, String> dexa(List<aa> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (aa aaVar : list) {
            treeMap.put(aaVar.dexa(), aaVar.dexb());
        }
        return treeMap;
    }
}
