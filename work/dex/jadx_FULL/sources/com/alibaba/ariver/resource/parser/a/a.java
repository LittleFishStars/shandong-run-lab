package com.alibaba.ariver.resource.parser.a;

import com.alibaba.ariver.kernel.common.utils.IOUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static long a(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        long j = 0;
        boolean z = true;
        while (i < i3) {
            byte b = bArr[i];
            if (b == 0) {
                break;
            }
            if (b != 32 && b != 48) {
                j = (j << 3) + ((long) (b - 48));
                z = false;
            } else if (z) {
                continue;
            } else {
                if (b == 32) {
                    break;
                }
                j = (j << 3) + ((long) (b - 48));
                z = false;
            }
            i++;
        }
        return j;
    }

    public static int b(long j, byte[] bArr, int i, int i2) {
        a(j, bArr, i, i2);
        int i3 = i + i2;
        bArr[i3 - 1] = 32;
        bArr[i3 - 2] = 0;
        return i3;
    }

    public static int c(long j, byte[] bArr, int i, int i2) {
        int i3 = i2 + 1;
        byte[] buf = IOUtils.getBuf(i3);
        a(j, buf, 0, i3);
        System.arraycopy(buf, 0, bArr, i, i2);
        IOUtils.returnBuf(buf);
        return i + i2;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0038 -> B:5:0x001d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public static int a(long r8, byte[] r10, int r11, int r12) {
        /*
            int r0 = r12 + (-1)
            int r1 = r11 + r0
            r2 = 0
            r10[r1] = r2
            int r0 = r0 + (-1)
            int r1 = r11 + r0
            r2 = 32
            r10[r1] = r2
            int r0 = r0 + (-1)
            r3 = 0
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            r5 = 48
            if (r1 != 0) goto L20
            int r8 = r11 + r0
            r10[r8] = r5
        L1d:
            int r0 = r0 + (-1)
            goto L36
        L20:
            if (r0 < 0) goto L36
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 <= 0) goto L36
            int r1 = r11 + r0
            r6 = 7
            long r6 = r6 & r8
            int r6 = (int) r6
            byte r6 = (byte) r6
            int r6 = r6 + r5
            byte r6 = (byte) r6
            r10[r1] = r6
            r1 = 3
            long r8 = r8 >> r1
            int r0 = r0 + (-1)
            goto L20
        L36:
            if (r0 < 0) goto L3d
            int r8 = r11 + r0
            r10[r8] = r2
            goto L1d
        L3d:
            int r11 = r11 + r12
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.resource.parser.a.a.a(long, byte[], int, int):int");
    }
}
