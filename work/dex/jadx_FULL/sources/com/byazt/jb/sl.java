package com.byazt.jb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.constants.ErrorCode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 158})
public class sl {
    public static final int[] c = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, ErrorCode.CHECK_START_RUN_ERROR.n, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    public static final byte[] tt = {13, com.google.common.base.a.A, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.B, com.google.common.base.a.H, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.H, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.H, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, com.google.common.base.a.F, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, com.google.common.base.a.q, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, com.google.common.base.a.p, 6, com.google.common.base.a.q, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, com.google.common.base.a.q, 11, com.google.common.base.a.p, 13, com.google.common.base.a.F, com.google.common.base.a.x, com.google.common.base.a.z, com.google.common.base.a.x, com.google.common.base.a.x, com.google.common.base.a.z, com.google.common.base.a.z, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.B, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.B, com.google.common.base.a.z, com.google.common.base.a.y, com.google.common.base.a.x, com.google.common.base.a.z, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.y, com.google.common.base.a.A, com.google.common.base.a.z, com.google.common.base.a.z, com.google.common.base.a.B, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.y, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.y, com.google.common.base.a.A, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.A, com.google.common.base.a.x, com.google.common.base.a.z, com.google.common.base.a.z, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.z, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.D, com.google.common.base.a.D, com.google.common.base.a.x, 19, com.google.common.base.a.z, com.google.common.base.a.A, com.google.common.base.a.z, com.google.common.base.a.C, com.google.common.base.a.D, com.google.common.base.a.D, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.D, com.google.common.base.a.B, com.google.common.base.a.C, 19, com.google.common.base.a.y, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.B, com.google.common.base.a.y, com.google.common.base.a.y, com.google.common.base.a.D, com.google.common.base.a.D, com.google.common.base.a.F, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.x, com.google.common.base.a.B, com.google.common.base.a.x, com.google.common.base.a.y, com.google.common.base.a.z, com.google.common.base.a.y, com.google.common.base.a.y, com.google.common.base.a.A, com.google.common.base.a.z, com.google.common.base.a.z, com.google.common.base.a.C, com.google.common.base.a.C, com.google.common.base.a.B, com.google.common.base.a.B, com.google.common.base.a.D, com.google.common.base.a.A, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.D, com.google.common.base.a.D, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.F, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.E, com.google.common.base.a.D};
    public static final sl ve = new sl();
    public final c uj = new c();

    private sl() {
        tt();
    }

    public static sl c() {
        return ve;
    }

    private void tt() {
        int i = 0;
        while (true) {
            byte[] bArr = tt;
            if (i >= bArr.length) {
                return;
            }
            c(i, c[i], bArr[i]);
            i++;
        }
    }

    public void c(com.byazt.mk.a aVar, com.byazt.mk.uj ujVar) throws IOException {
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < aVar.sp(); i2++) {
            int iC = aVar.c(i2) & 255;
            int i3 = c[iC];
            byte b = tt[iC];
            j = (j << b) | ((long) i3);
            i += b;
            while (i >= 8) {
                i -= 8;
                ujVar.i((int) (j >> i));
            }
        }
        if (i > 0) {
            ujVar.i((int) ((j << (8 - i)) | ((long) (255 >>> i))));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 63, 925})
    public static final class c {
        public final c[] c;
        public final int tt;
        public final int ve;

        public c() {
            this.c = new c[256];
            this.tt = 0;
            this.ve = 0;
        }

        public c(int i, int i2) {
            this.c = null;
            this.tt = i;
            int i3 = i2 & 7;
            this.ve = i3 == 0 ? 8 : i3;
        }
    }

    public int c(com.byazt.mk.a aVar) {
        long j = 0;
        for (int i = 0; i < aVar.sp(); i++) {
            j += (long) tt[aVar.c(i) & 255];
        }
        return (int) ((j + 7) >> 3);
    }

    public byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c cVar = this.uj;
        int i = 0;
        int i2 = 0;
        for (byte b : bArr) {
            i = (i << 8) | (b & 255);
            i2 += 8;
            while (i2 >= 8) {
                cVar = cVar.c[(i >>> (i2 - 8)) & 255];
                if (cVar.c == null) {
                    byteArrayOutputStream.write(cVar.tt);
                    i2 -= cVar.ve;
                    cVar = this.uj;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            c cVar2 = cVar.c[(i << (8 - i2)) & 255];
            if (cVar2.c != null || cVar2.ve > i2) {
                break;
            }
            byteArrayOutputStream.write(cVar2.tt);
            i2 -= cVar2.ve;
            cVar = this.uj;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void c(int i, int i2, byte b) {
        c cVar = new c(i, b);
        c cVar2 = this.uj;
        while (b > 8) {
            b = (byte) (b - 8);
            int i3 = (i2 >>> b) & 255;
            c[] cVarArr = cVar2.c;
            if (cVarArr != null) {
                if (cVarArr[i3] == null) {
                    cVarArr[i3] = new c();
                }
                cVar2 = cVar2.c[i3];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i4 = 8 - b;
        int i5 = (i2 << i4) & 255;
        int i6 = 1 << i4;
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            cVar2.c[i7] = cVar;
        }
    }
}
