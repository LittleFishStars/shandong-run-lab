package com.byazt.vnu;

import com.hzchengdun.securityguard.SecExceptionCode;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f29138a = Logger.getLogger(c.class.getName());
    public final byte[] c;
    public C0559c n;
    public final x tt;
    public final n uj;
    public final sp ve;

    /* JADX INFO: renamed from: com.byazt.vnu.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, 44})
    public static class C0559c {
        public final short c;
        public final int n;
        public final int tt;
        public final int uj;
        public final int ve;

        public C0559c(short s, int i, int i2, int i3) {
            this.c = s;
            this.tt = i;
            this.ve = i2;
            this.uj = i3;
            this.n = i3 + i2;
        }

        public static C0559c c(sp spVar, n nVar) throws IOException {
            int iC = nVar.c();
            try {
                return new C0559c(spVar.readShort(), spVar.readShort(), spVar.readInt(), iC);
            } catch (EOFException unused) {
                return new C0559c((short) -1, 0, 0, nVar.c());
            }
        }
    }

    public c(byte[] bArr, x xVar) {
        n nVar = new n(new ByteArrayInputStream(bArr));
        this.uj = nVar;
        this.ve = new sp(new i(nVar));
        this.c = bArr;
        this.tt = xVar;
    }

    private void a() throws IOException {
        tt(513);
        this.ve.readUnsignedByte();
        this.ve.readByte();
        this.ve.skipBytes(2);
        int i = this.ve.readInt();
        int i2 = this.ve.readInt();
        da();
        int i3 = (this.n.uj + i2) - (i * 4);
        if (i3 != this.uj.c()) {
            f29138a.warning("Invalid data detected. Skipping: " + (i3 - this.uj.c()) + " byte(s)");
            this.ve.skipBytes(i3 - this.uj.c());
        }
        int[] iArrC = this.ve.c(i);
        HashSet hashSet = new HashSet();
        for (int i4 : iArrC) {
            if (i4 != -1 && !hashSet.contains(Integer.valueOf(i4))) {
                sp();
                hashSet.add(Integer.valueOf(i4));
            }
        }
    }

    private void da() throws IOException {
        int i = this.ve.readInt();
        int i2 = 28;
        if (i < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.ve.readShort();
        this.ve.readShort();
        this.ve.readByte();
        this.ve.readByte();
        this.ve.readByte();
        this.ve.readByte();
        this.ve.readByte();
        this.ve.readByte();
        this.ve.readUnsignedShort();
        this.ve.readByte();
        this.ve.readByte();
        this.ve.readByte();
        this.ve.skipBytes(1);
        this.ve.readShort();
        this.ve.readShort();
        this.ve.readShort();
        this.ve.skipBytes(2);
        if (i >= 32) {
            this.ve.readByte();
            this.ve.readByte();
            this.ve.readShort();
            i2 = 32;
        }
        if (i >= 36) {
            this.ve.readShort();
            this.ve.readShort();
            i2 = 36;
        }
        if (i >= 48) {
            c(4).toCharArray();
            c(8).toCharArray();
            i2 = 48;
        }
        if (i >= 52) {
            this.ve.readByte();
            this.ve.readByte();
            this.ve.skipBytes(2);
            i2 = 52;
        }
        if (i >= 56) {
            this.ve.skipBytes(4);
            i2 = 56;
        }
        int i3 = i - 56;
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            i2 += i3;
            this.ve.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                f29138a.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                f29138a.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(i), bigInteger));
            }
        }
        int i4 = i - i2;
        if (i4 > 0) {
            this.ve.skipBytes(i4);
        }
    }

    private void i() throws IOException {
        this.ve.c((short) 8);
        this.ve.c((byte) 0);
        byte b = this.ve.readByte();
        int iC = sl.c(this.ve);
        int i = this.ve.readInt();
        if (b == 1) {
            sl.c(this.c, i, iC, this.tt);
        }
        if (b == 2) {
            sl.c(this.c, i, iC, this.tt);
        }
    }

    private void n() throws IOException {
        tt(514);
        this.ve.readUnsignedByte();
        this.ve.skipBytes(3);
        this.ve.skipBytes(this.ve.readInt() * 4);
    }

    private C0559c sl() throws IOException {
        C0559c c0559cC = C0559c.c(this.ve, this.uj);
        this.n = c0559cC;
        return c0559cC;
    }

    private void sp() throws IOException {
        if (this.ve.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short s = this.ve.readShort();
        this.ve.readInt();
        if ((s & 1) == 0) {
            i();
        } else {
            x();
        }
    }

    private void tt() throws IOException {
        tt(512);
        this.ve.readInt();
        this.ve.skipBytes(256);
        this.ve.c();
        this.ve.c();
        this.ve.c();
        this.ve.c();
        if (this.n.tt == 288 && this.ve.readInt() > 0) {
            throw new RuntimeException("don't support");
        }
        t.c(this.ve);
        t.c(this.ve);
        sl();
        boolean z = true;
        while (z) {
            short s = this.n.c;
            if (s == 514) {
                uj();
            } else if (s != 515) {
                z = false;
            } else {
                ve();
            }
        }
    }

    private void uj() throws IOException {
        n();
        short s = sl().c;
        while (s == 514) {
            n();
            s = sl().c;
        }
        while (s == 513) {
            a();
            if (this.uj.c() < this.n.n) {
                f29138a.warning("Unknown data detected. Skipping: " + (this.n.n - this.uj.c()) + " byte(s)");
                n nVar = this.uj;
                nVar.skip((long) (this.n.n - nVar.c()));
            }
            s = sl().c;
        }
    }

    private void ve() throws IOException {
        tt(515);
        int i = this.ve.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.ve.readInt();
            this.ve.skipBytes(256);
        }
        while (sl().c == 513) {
            uj();
        }
    }

    private void x() throws IOException {
        int iC = sl.c(this.ve);
        sl.c(this.c, this.ve.readInt(), iC, this.tt);
        int i = this.ve.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            int iC2 = sl.c(this.ve);
            sl.c(this.c, this.ve.readInt(), iC2, this.tt);
            i();
        }
    }

    public void c() throws IOException {
        ve(2);
        int i = this.ve.readInt();
        t.c(this.ve);
        sl();
        for (int i2 = 0; i2 < i; i2++) {
            tt();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SimplifyVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v6 short, still in use, count: 1, list:
          (r3v6 short) from 0x0014: CAST (char) (r3v6 short)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:148)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:101)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyArgs(SimplifyVisitor.java:117)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:132)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
        	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
        */
    private java.lang.String c(int r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 16
            r0.<init>(r1)
        L7:
            int r1 = r3 + (-1)
            if (r3 == 0) goto L1a
            com.byazt.vnu.sp r3 = r2.ve
            byte r3 = r3.readByte()
            short r3 = (short) r3
            if (r3 == 0) goto L1a
            char r3 = (char) r3
            r0.append(r3)
            r3 = r1
            goto L7
        L1a:
            com.byazt.vnu.sp r3 = r2.ve
            r3.skipBytes(r1)
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.vnu.c.c(int):java.lang.String");
    }

    private void ve(int i) throws IOException {
        sl();
        tt(i);
    }

    private void tt(int i) {
        if (this.n.c != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.n.c)));
        }
    }
}
