package com.byazt.eg;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public enum gr {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    public final String n;

    gr(String str) {
        this.n = str;
    }

    public static gr c(String str) throws IOException {
        gr grVar = HTTP_1_0;
        if (str.equals(grVar.n)) {
            return grVar;
        }
        gr grVar2 = HTTP_1_1;
        if (str.equals(grVar2.n)) {
            return grVar2;
        }
        gr grVar3 = HTTP_2;
        if (str.equals(grVar3.n)) {
            return grVar3;
        }
        gr grVar4 = SPDY_3;
        if (str.equals(grVar4.n)) {
            return grVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.n;
    }
}
