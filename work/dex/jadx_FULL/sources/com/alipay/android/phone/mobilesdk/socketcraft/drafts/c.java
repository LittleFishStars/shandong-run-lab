package com.alipay.android.phone.mobilesdk.socketcraft.drafts;

import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.c.f;
import com.alipay.android.phone.mobilesdk.socketcraft.c.h;
import com.alipay.android.phone.mobilesdk.socketcraft.c.i;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.IncompleteHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidFrameException;
import com.alipay.android.phone.mobilesdk.socketcraft.exceptions.InvalidHandshakeException;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.zj.adlib.l82;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends b {
    private static final byte[] n = {-1, 0};
    private boolean m = false;
    private final Random o = new Random();

    public static byte[] a(String str, String str2, byte[] bArr) throws InvalidHandshakeException {
        byte[] bArrA = a(str);
        byte[] bArrA2 = a(str2);
        try {
            return MessageDigest.getInstance("MD5").digest(new byte[]{bArrA[0], bArrA[1], bArrA[2], bArrA[3], bArrA2[0], bArrA2[1], bArrA2[2], bArrA2[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String f() {
        Random random = new Random();
        long jNextInt = random.nextInt(12) + 1;
        String string = Long.toString(((long) (random.nextInt(Math.abs(new Long(4294967295L / jNextInt).intValue())) + 1)) * jNextInt);
        int iNextInt = random.nextInt(12) + 1;
        for (int i = 0; i < iNextInt; i++) {
            int iAbs = Math.abs(random.nextInt(string.length()));
            char cNextInt = (char) (random.nextInt(95) + 33);
            if (cNextInt >= '0' && cNextInt <= '9') {
                cNextInt = (char) (cNextInt + l82.b);
            }
            string = new StringBuilder(string).insert(iAbs, cNextInt).toString();
        }
        for (int i2 = 0; i2 < jNextInt; i2++) {
            string = new StringBuilder(string).insert(Math.abs(random.nextInt(string.length() - 1) + 1), " ").toString();
        }
        return string;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.b, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.CloseHandshakeType b() {
        return Draft.CloseHandshakeType.ONEWAY;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.b, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public List<Framedata> c(ByteBuffer byteBuffer) throws InvalidFrameException {
        byteBuffer.mark();
        List<Framedata> listE = super.e(byteBuffer);
        if (listE != null) {
            return listE;
        }
        byteBuffer.reset();
        List<Framedata> list = this.k;
        this.j = true;
        if (this.l != null) {
            throw new InvalidFrameException();
        }
        this.l = ByteBuffer.allocate(2);
        if (byteBuffer.remaining() > this.l.remaining()) {
            throw new InvalidFrameException();
        }
        this.l.put(byteBuffer);
        if (this.l.hasRemaining()) {
            this.k = new LinkedList();
            return list;
        }
        if (!Arrays.equals(this.l.array(), n)) {
            throw new InvalidFrameException();
        }
        list.add(new com.alipay.android.phone.mobilesdk.socketcraft.framing.b(1000));
        return list;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public f d(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        com.alipay.android.phone.mobilesdk.socketcraft.c.c cVarA = Draft.a(byteBuffer, this.d);
        if ((cVarA.c("Sec-WebSocket-Key1") || this.d == WebSocket.Role.CLIENT) && !cVarA.c(com.google.common.net.b.R1)) {
            byte[] bArr = new byte[this.d == WebSocket.Role.SERVER ? 8 : 16];
            try {
                byteBuffer.get(bArr);
                cVarA.a(bArr);
            } catch (BufferUnderflowException unused) {
                throw new IncompleteHandshakeException(byteBuffer.capacity() + 16);
            }
        }
        return cVarA;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.b, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft c() {
        return new c();
    }

    private static byte[] a(String str) throws InvalidHandshakeException {
        try {
            long j = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = str.split(" ").length - 1;
            if (length != 0) {
                long jLongValue = new Long(j / length).longValue();
                return new byte[]{(byte) (jLongValue >> 24), (byte) ((jLongValue << 8) >> 24), (byte) ((jLongValue << 16) >> 24), (byte) ((jLongValue << 24) >> 24)};
            }
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key2/)");
        } catch (NumberFormatException unused) {
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.b, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, h hVar) {
        if (this.m) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        try {
            if (hVar.b("Sec-WebSocket-Origin").equals(aVar.b(com.google.common.net.b.F)) && a(hVar)) {
                byte[] bArrD = hVar.d();
                if (bArrD != null && bArrD.length != 0) {
                    if (Arrays.equals(bArrD, a(aVar.b("Sec-WebSocket-Key1"), aVar.b("Sec-WebSocket-Key2"), aVar.d()))) {
                        return Draft.HandshakeState.MATCHED;
                    }
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                throw new IncompleteHandshakeException();
            }
            return Draft.HandshakeState.NOT_MATCHED;
        } catch (InvalidHandshakeException e) {
            throw new RuntimeException("bad handshakerequest", e);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.b, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public Draft.HandshakeState a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar) {
        if (aVar.b(com.google.common.net.b.N).equals("WebSocket") && aVar.b("Connection").contains(com.google.common.net.b.N) && aVar.b("Sec-WebSocket-Key1").length() > 0 && !aVar.b("Sec-WebSocket-Key2").isEmpty() && aVar.c(com.google.common.net.b.F)) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.b, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public com.alipay.android.phone.mobilesdk.socketcraft.c.b a(com.alipay.android.phone.mobilesdk.socketcraft.c.b bVar) {
        bVar.a(com.google.common.net.b.N, "WebSocket");
        bVar.a("Connection", com.google.common.net.b.N);
        bVar.a("Sec-WebSocket-Key1", f());
        bVar.a("Sec-WebSocket-Key2", f());
        if (!bVar.c(com.google.common.net.b.F)) {
            bVar.a(com.google.common.net.b.F, "random" + this.o.nextInt());
        }
        byte[] bArr = new byte[8];
        this.o.nextBytes(bArr);
        bVar.a(bArr);
        return bVar;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.b, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public com.alipay.android.phone.mobilesdk.socketcraft.c.c a(com.alipay.android.phone.mobilesdk.socketcraft.c.a aVar, i iVar) throws InvalidHandshakeException {
        iVar.a("WebSocket Protocol Handshake");
        iVar.a(com.google.common.net.b.N, "WebSocket");
        iVar.a("Connection", aVar.b("Connection"));
        iVar.a("Sec-WebSocket-Origin", aVar.b(com.google.common.net.b.F));
        iVar.a("Sec-WebSocket-Location", "ws://" + aVar.b("Host") + aVar.a());
        String strB = aVar.b("Sec-WebSocket-Key1");
        String strB2 = aVar.b("Sec-WebSocket-Key2");
        byte[] bArrD = aVar.d();
        if (strB != null && strB2 != null && bArrD != null && bArrD.length == 8) {
            iVar.a(a(strB, strB2, bArrD));
            return iVar;
        }
        throw new InvalidHandshakeException("Bad keys");
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.drafts.b, com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft
    public ByteBuffer a(Framedata framedata) {
        if (framedata.f() == Framedata.Opcode.CLOSING) {
            return ByteBuffer.wrap(n);
        }
        return super.a(framedata);
    }
}
