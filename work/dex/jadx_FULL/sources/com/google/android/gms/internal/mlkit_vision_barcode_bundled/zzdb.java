package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.dic;
import com.zj.adlib.hgc;
import com.zj.adlib.ivc;
import com.zj.adlib.rgc;
import com.zj.adlib.rmc;
import com.zj.adlib.v39;
import com.zj.adlib.xgc;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zzdb implements Iterable, Serializable {
    private static final Comparator zza;
    public static final zzdb zzb = new zzcy(rmc.f19385a);
    private static final dic zzd;
    private int zzc = 0;

    static {
        int i = hgc.f42123a;
        zzd = new dic(null);
        zza = new xgc();
    }

    private static zzdb zzc(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return (zzdb) it.next();
        }
        int i2 = i >>> 1;
        zzdb zzdbVarZzc = zzc(it, i2);
        zzdb zzdbVarZzc2 = zzc(it, i - i2);
        if (Integer.MAX_VALUE - zzdbVarZzc.zzd() >= zzdbVarZzc2.zzd()) {
            return zzgg.zzz(zzdbVarZzc, zzdbVarZzc2);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + zzdbVarZzc.zzd() + "+" + zzdbVarZzc2.zzd());
    }

    public static int zzo(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public static zzdb zzr(byte[] bArr, int i, int i2) {
        zzo(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzcy(bArr2);
    }

    public static zzdb zzs(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i = 0;
            while (i < iMin) {
                int i2 = inputStream.read(bArr, i, iMin - i);
                if (i2 == -1) {
                    break;
                }
                i += i2;
            }
            zzdb zzdbVarZzr = i == 0 ? null : zzr(bArr, 0, i);
            if (zzdbVarZzr == null) {
                break;
            }
            arrayList.add(zzdbVarZzr);
            iMin = Math.min(iMin + iMin, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zzb : zzc(arrayList.iterator(), size);
    }

    public static void zzv(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zzc;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zzc = iZzi;
        }
        return iZzi;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? ivc.a(this) : ivc.a(zzk(0, 47)).concat(v39.CHARACTER_ELLIPSIZE);
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i, int i2, int i3);

    public abstract int zzj(int i, int i2, int i3);

    public abstract zzdb zzk(int i, int i2);

    public abstract String zzl(Charset charset);

    public abstract void zzm(rgc rgcVar) throws IOException;

    public abstract boolean zzn();

    public final int zzp() {
        return this.zzc;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public zzcw iterator() {
        return new j(this);
    }

    public final String zzt(Charset charset) {
        return zzd() == 0 ? "" : zzl(charset);
    }

    public final String zzu() {
        return zzt(rmc.b);
    }

    @Deprecated
    public final void zzw(byte[] bArr, int i, int i2, int i3) {
        zzo(0, i3, zzd());
        zzo(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }

    public final byte[] zzx() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return rmc.f19385a;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }
}
