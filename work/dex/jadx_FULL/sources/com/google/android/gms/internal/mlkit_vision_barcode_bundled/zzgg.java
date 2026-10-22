package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.qsc;
import com.zj.adlib.rgc;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzgg extends zzdb {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzdb zzd;
    private final zzdb zze;
    private final int zzf;
    private final int zzg;

    private zzgg(zzdb zzdbVar, zzdb zzdbVar2) {
        this.zzd = zzdbVar;
        this.zze = zzdbVar2;
        int iZzd = zzdbVar.zzd();
        this.zzf = iZzd;
        this.zzc = iZzd + zzdbVar2.zzd();
        this.zzg = Math.max(zzdbVar.zzf(), zzdbVar2.zzf()) + 1;
    }

    private static zzdb zzA(zzdb zzdbVar, zzdb zzdbVar2) {
        int iZzd = zzdbVar.zzd();
        int iZzd2 = zzdbVar2.zzd();
        byte[] bArr = new byte[iZzd + iZzd2];
        zzdbVar.zzw(bArr, 0, 0, iZzd);
        zzdbVar2.zzw(bArr, 0, iZzd, iZzd2);
        return new zzcy(bArr);
    }

    public static int zzc(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public static zzdb zzz(zzdb zzdbVar, zzdb zzdbVar2) {
        if (zzdbVar2.zzd() == 0) {
            return zzdbVar;
        }
        if (zzdbVar.zzd() == 0) {
            return zzdbVar2;
        }
        int iZzd = zzdbVar.zzd() + zzdbVar2.zzd();
        if (iZzd < 128) {
            return zzA(zzdbVar, zzdbVar2);
        }
        if (zzdbVar instanceof zzgg) {
            zzgg zzggVar = (zzgg) zzdbVar;
            if (zzggVar.zze.zzd() + zzdbVar2.zzd() < 128) {
                return new zzgg(zzggVar.zzd, zzA(zzggVar.zze, zzdbVar2));
            }
            if (zzggVar.zzd.zzf() > zzggVar.zze.zzf() && zzggVar.zzg > zzdbVar2.zzf()) {
                return new zzgg(zzggVar.zzd, new zzgg(zzggVar.zze, zzdbVar2));
            }
        }
        return iZzd >= zzc(Math.max(zzdbVar.zzf(), zzdbVar2.zzf()) + 1) ? new zzgg(zzdbVar, zzdbVar2) : k0.a(new k0(null), zzdbVar, zzdbVar2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdb)) {
            return false;
        }
        zzdb zzdbVar = (zzdb) obj;
        if (this.zzc != zzdbVar.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int iZzp = zzp();
        int iZzp2 = zzdbVar.zzp();
        if (iZzp != 0 && iZzp2 != 0 && iZzp != iZzp2) {
            return false;
        }
        qsc qscVar = null;
        l0 l0Var = new l0(this, qscVar);
        zzcx zzcxVarA = l0Var.next();
        l0 l0Var2 = new l0(zzdbVar, qscVar);
        zzcx zzcxVarA2 = l0Var2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int iZzd = zzcxVarA.zzd() - i;
            int iZzd2 = zzcxVarA2.zzd() - i2;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i == 0 ? zzcxVarA.zzg(zzcxVarA2, i2, iMin) : zzcxVarA2.zzg(zzcxVarA, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.zzc;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                zzcxVarA = l0Var.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == iZzd2) {
                zzcxVarA = zzcxVarA;
                zzcxVarA2 = l0Var2.next();
                i2 = 0;
            } else {
                zzcxVarA = zzcxVarA;
                i2 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new j0(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final byte zza(int i) {
        zzdb.zzv(i, this.zzc);
        return zzb(i);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final byte zzb(int i) {
        int i2 = this.zzf;
        return i < i2 ? this.zzd.zzb(i) : this.zze.zzb(i - i2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zze.zze(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzi(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzi(this.zzd.zzi(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final zzdb zzk(int i, int i2) {
        int iZzo = zzdb.zzo(i, i2, this.zzc);
        if (iZzo == 0) {
            return zzdb.zzb;
        }
        if (iZzo == this.zzc) {
            return this;
        }
        int i3 = this.zzf;
        if (i2 <= i3) {
            return this.zzd.zzk(i, i2);
        }
        if (i >= i3) {
            return this.zze.zzk(i - i3, i2 - i3);
        }
        zzdb zzdbVar = this.zzd;
        return new zzgg(zzdbVar.zzk(i, zzdbVar.zzd()), this.zze.zzk(0, i2 - this.zzf));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final String zzl(Charset charset) {
        return new String(zzx(), charset);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final void zzm(rgc rgcVar) throws IOException {
        this.zzd.zzm(rgcVar);
        this.zze.zzm(rgcVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final boolean zzn() {
        int iZzj = this.zzd.zzj(0, 0, this.zzf);
        zzdb zzdbVar = this.zze;
        return zzdbVar.zzj(iZzj, 0, zzdbVar.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    /* JADX INFO: renamed from: zzq */
    public final zzcw iterator() {
        return new j0(this);
    }
}
