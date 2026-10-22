package com.baidu.b.c.d;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f26290a = new byte[0];
    private int b;
    private f d;
    private byte[] f;
    private int g;
    private int h;
    private d i;
    private OAEPParameterSpec e = null;
    private String j = "SHA-1";
    private String c = "PKCS1Padding";

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    private void a(int i, d dVar, SecureRandom secureRandom, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        boolean z;
        OAEPParameterSpec oAEPParameterSpec;
        if (i == 1) {
            z = true;
        } else {
            if (i != 2) {
                if (i == 3) {
                    z = true;
                } else if (i != 4) {
                    throw new InvalidKeyException("Unknown mode: " + i);
                }
            }
            z = false;
        }
        if (!(dVar instanceof d)) {
            throw new InvalidKeyException("only support helios key");
        }
        this.b = z ? 1 : 4;
        this.i = dVar;
        int iA = b.a(dVar.a());
        this.h = iA;
        this.g = 0;
        String str = this.c;
        if (str == "NoPadding") {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            this.d = f.a(3, iA, secureRandom);
            this.f = new byte[iA];
            return;
        }
        if (str == "PKCS1Padding") {
            if (algorithmParameterSpec != null) {
                throw new InvalidAlgorithmParameterException("Parameters not supported");
            }
            f fVarA = f.a(this.b > 2 ? 1 : 2, iA, secureRandom);
            this.d = fVarA;
            if (z) {
                this.f = new byte[fVarA.a()];
                return;
            } else {
                this.f = new byte[iA];
                return;
            }
        }
        int i2 = this.b;
        if (i2 == 3 || i2 == 4) {
            throw new InvalidKeyException("OAEP cannot be used to sign or verify signatures");
        }
        if (algorithmParameterSpec == null) {
            oAEPParameterSpec = new OAEPParameterSpec(this.j, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
        } else {
            if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Wrong Parameters for OAEP Padding");
            }
            oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
        }
        f fVarA2 = f.a(4, iA, secureRandom, oAEPParameterSpec);
        this.d = fVarA2;
        if (z) {
            this.f = new byte[fVarA2.a()];
        } else {
            this.f = new byte[iA];
        }
    }

    private byte[] a() throws BadPaddingException, IllegalBlockSizeException {
        int i = this.g;
        byte[] bArr = this.f;
        if (i > bArr.length) {
            throw new IllegalBlockSizeException("Data must not be longer than " + this.f.length + " bytes");
        }
        try {
            int i2 = this.b;
            if (i2 == 1) {
                byte[] bArrA = b.a(this.d.a(bArr, 0, i), this.i);
                this.g = 0;
                return bArrA;
            }
            if (i2 == 2) {
                throw new UnsupportedOperationException("only verify supported");
            }
            if (i2 == 3) {
                throw new UnsupportedOperationException("only verify supported");
            }
            if (i2 != 4) {
                throw new AssertionError("Internal error");
            }
            byte[] bArrB = this.d.b(b.a(b.a(bArr, 0, i), this.i));
            this.g = 0;
            return bArrB;
        } catch (Throwable th) {
            this.g = 0;
            throw th;
        }
    }

    private void b(byte[] bArr, int i, int i2) {
        int length;
        if (i2 == 0 || bArr == null) {
            return;
        }
        int i3 = this.g;
        int i4 = i3 + i2;
        byte[] bArr2 = this.f;
        if (i4 > bArr2.length) {
            length = bArr2.length + 1;
        } else {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            length = this.g + i2;
        }
        this.g = length;
    }

    public void a(int i, d dVar, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            a(i, dVar, secureRandom, null);
        } catch (InvalidAlgorithmParameterException e) {
            InvalidKeyException invalidKeyException = new InvalidKeyException("Wrong parameters");
            invalidKeyException.initCause(e);
            throw invalidKeyException;
        }
    }

    public void a(String str) throws NoSuchPaddingException {
        String str2 = "NoPadding";
        if (!str.equalsIgnoreCase("NoPadding")) {
            str2 = "PKCS1Padding";
            if (!str.equalsIgnoreCase("PKCS1Padding")) {
                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                if (lowerCase.equals("oaeppadding")) {
                    this.c = "OAEP";
                    return;
                }
                if (!lowerCase.startsWith("oaepwith") || !lowerCase.endsWith("andmgf1padding")) {
                    throw new NoSuchPaddingException("Padding " + str + " not supported");
                }
                this.c = "OAEP";
                this.j = str.substring(8, str.length() - 14);
                throw new NoSuchPaddingException("MessageDigest not available for " + str);
            }
        }
        this.c = str2;
    }

    public byte[] a(byte[] bArr, int i, int i2) throws BadPaddingException, IllegalBlockSizeException {
        b(bArr, i, i2);
        return a();
    }
}
