package com.google.android.exoplayer2.extractor.mp4;

import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.om6;
import java.nio.ByteBuffer;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30688a = "PsshAtomUtil";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30689a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final UUID f3021a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f3022a;

        public a(UUID uuid, int i, byte[] bArr) {
            this.f3021a = uuid;
            this.f30689a = i;
            this.f3022a = bArr;
        }
    }

    public static byte[] a(UUID uuid, @Nullable byte[] bArr) {
        return b(uuid, null, bArr);
    }

    public static byte[] b(UUID uuid, @Nullable UUID[] uuidArr, @Nullable byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? 16777216 : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    @Nullable
    public static a d(byte[] bArr) {
        om6 om6Var = new om6(bArr);
        if (om6Var.f() < 32) {
            return null;
        }
        om6Var.S(0);
        if (om6Var.o() != om6Var.a() + 4 || om6Var.o() != 1886614376) {
            return null;
        }
        int iC = Atom.c(om6Var.o());
        if (iC > 1) {
            Log.n(f30688a, "Unsupported pssh version: " + iC);
            return null;
        }
        UUID uuid = new UUID(om6Var.z(), om6Var.z());
        if (iC == 1) {
            om6Var.T(om6Var.K() * 16);
        }
        int iK = om6Var.K();
        if (iK != om6Var.a()) {
            return null;
        }
        byte[] bArr2 = new byte[iK];
        om6Var.k(bArr2, 0, iK);
        return new a(uuid, iC, bArr2);
    }

    @Nullable
    public static byte[] e(byte[] bArr, UUID uuid) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        if (uuid.equals(aVarD.f3021a)) {
            return aVarD.f3022a;
        }
        Log.n(f30688a, "UUID mismatch. Expected: " + uuid + ", got: " + aVarD.f3021a + Consts.DOT);
        return null;
    }

    @Nullable
    public static UUID f(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        return aVarD.f3021a;
    }

    public static int g(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return -1;
        }
        return aVarD.f30689a;
    }
}
