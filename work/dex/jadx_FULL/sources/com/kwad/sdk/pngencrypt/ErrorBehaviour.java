package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);

    final int c;

    ErrorBehaviour(int i) {
        this.c = i;
    }
}
