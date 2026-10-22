package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class zzeo extends IOException {
    private zzfo zza;

    public zzeo(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    public static zzen zza() {
        return new zzen("Protocol message tag had invalid wire type.");
    }

    public static zzeo zzb() {
        return new zzeo("Protocol message contained an invalid tag (zero).");
    }

    public static zzeo zzc() {
        return new zzeo("Protocol message had invalid UTF-8.");
    }

    public static zzeo zzd() {
        return new zzeo("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static zzeo zze() {
        return new zzeo("Failed to parse the message.");
    }

    public static zzeo zzg() {
        return new zzeo("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzeo zzf(zzfo zzfoVar) {
        this.zza = zzfoVar;
        return this;
    }

    public zzeo(String str) {
        super(str);
        this.zza = null;
    }
}
