package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.common.base.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s90 extends SimpleMetadataDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44641a = 2;
    public static final int b = 21;
    public static final int c = 3;
    public static final int d = 116;

    @Nullable
    public static Metadata b(nm6 nm6Var) {
        nm6Var.s(12);
        int iD = (nm6Var.d() + nm6Var.h(12)) - 4;
        nm6Var.s(44);
        nm6Var.t(nm6Var.h(12));
        nm6Var.s(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strM = null;
            if (nm6Var.d() >= iD) {
                break;
            }
            nm6Var.s(48);
            int iH = nm6Var.h(8);
            nm6Var.s(4);
            int iD2 = nm6Var.d() + nm6Var.h(12);
            String strM2 = null;
            while (nm6Var.d() < iD2) {
                int iH2 = nm6Var.h(8);
                int iH3 = nm6Var.h(8);
                int iD3 = nm6Var.d() + iH3;
                if (iH2 == 2) {
                    int iH4 = nm6Var.h(16);
                    nm6Var.s(8);
                    if (iH4 == 3) {
                        while (nm6Var.d() < iD3) {
                            strM = nm6Var.m(nm6Var.h(8), b.f31594a);
                            int iH5 = nm6Var.h(8);
                            for (int i = 0; i < iH5; i++) {
                                nm6Var.t(nm6Var.h(8));
                            }
                        }
                    }
                } else if (iH2 == 21) {
                    strM2 = nm6Var.m(iH3, b.f31594a);
                }
                nm6Var.q(iD3 * 8);
            }
            nm6Var.q(iD2 * 8);
            if (strM != null && strM2 != null) {
                arrayList.add(new AppInfoTable(iH, strM + strM2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    @Nullable
    public Metadata decode(xn5 xn5Var, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return b(new nm6(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
