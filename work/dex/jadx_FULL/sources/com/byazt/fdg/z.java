package com.byazt.fdg;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 133})
public final class z {
    public static final z c = new z(null, 0, null, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final int[] f28538a;

    @Nullable
    public final Signature[] n;

    @Nullable
    public final Signature[] tt;

    @Nullable
    public final ArraySet<PublicKey> uj;
    public final int ve;

    public z(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.tt = signatureArr;
        this.ve = i;
        this.uj = arraySet;
        this.n = signatureArr2;
        this.f28538a = iArr;
    }

    public static ArraySet<PublicKey> c(Signature[] signatureArr) throws CertificateException {
        Method method;
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e) {
                com.byazt.bog.a.c(e);
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    com.byazt.bog.a.c(e2);
                } catch (InvocationTargetException e3) {
                    com.byazt.bog.a.c(e3);
                } catch (Exception e4) {
                    com.byazt.bog.a.c(e4);
                }
            }
        }
        return arraySet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        if (this.ve != zVar.ve || !c(this.tt, zVar.tt)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.uj;
        if (arraySet != null) {
            if (!arraySet.equals(zVar.uj)) {
                return false;
            }
        } else if (zVar.uj != null) {
            return false;
        }
        return Arrays.equals(this.n, zVar.n) && Arrays.equals(this.f28538a, zVar.f28538a);
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.tt) * 31) + this.ve) * 31;
        ArraySet<PublicKey> arraySet = this.uj;
        return ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.n)) * 31) + Arrays.hashCode(this.f28538a);
    }

    public z(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) throws CertificateException {
        this(signatureArr, i, c(signatureArr), signatureArr2, iArr);
    }

    public z(Signature[] signatureArr, int i) throws CertificateException {
        this(signatureArr, i, null, null);
    }

    public static boolean c(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.byazt.uq.uj.c((Object[]) signatureArr, (Object[]) signatureArr2) && com.byazt.uq.uj.c((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean c(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
