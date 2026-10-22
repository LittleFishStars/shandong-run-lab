package com.kwad.sdk.utils.a;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
final class g implements c.b<Set<String>> {
    static final g bsE = new g();

    private g() {
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int iGh = 0;
        int i = 0;
        for (String str : set) {
            if (str == null) {
                iGh += 5;
                iArr[i] = -1;
            } else {
                int iIu = b.iu(str);
                strArr[i] = str;
                iArr[i] = iIu;
                iGh += b.gh(iIu) + iIu;
            }
            i++;
        }
        b bVar = new b(iGh);
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = iArr[i2];
            bVar.gg(i3);
            if (i3 >= 0) {
                bVar.it(strArr[i2]);
            }
        }
        return bVar.brM;
    }

    private static Set<String> g(byte[] bArr, int i, int i2) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            b bVar = new b(bArr, i);
            int i4 = i + i2;
            while (true) {
                i3 = bVar.position;
                if (i3 >= i4) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.Xj()));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final String XD() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> f(byte[] bArr, int i, int i2) {
        return g(bArr, i, i2);
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] u(Set<String> set) {
        return e(set);
    }
}
