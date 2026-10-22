package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.video.AudioStats;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class zzep {
    public static final zzep zza;
    public static final zzep zzb;
    public static final zzep zzc;
    public static final zzep zzd;
    public static final zzep zze;
    public static final zzep zzf;
    public static final zzep zzg;
    public static final zzep zzh;
    public static final zzep zzi;
    public static final zzep zzj;
    private static final /* synthetic */ zzep[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzep zzepVar = new zzep("VOID", 0, Void.class, Void.class, null);
        zza = zzepVar;
        Class cls = Integer.TYPE;
        zzep zzepVar2 = new zzep("INT", 1, cls, Integer.class, 0);
        zzb = zzepVar2;
        zzep zzepVar3 = new zzep("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzepVar3;
        zzep zzepVar4 = new zzep("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzepVar4;
        zzep zzepVar5 = new zzep("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        zze = zzepVar5;
        zzep zzepVar6 = new zzep("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzepVar6;
        zzep zzepVar7 = new zzep("STRING", 6, String.class, String.class, "");
        zzg = zzepVar7;
        zzep zzepVar8 = new zzep("BYTE_STRING", 7, zzdb.class, zzdb.class, zzdb.zzb);
        zzh = zzepVar8;
        zzep zzepVar9 = new zzep("ENUM", 8, cls, Integer.class, null);
        zzi = zzepVar9;
        zzep zzepVar10 = new zzep("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzepVar10;
        zzk = new zzep[]{zzepVar, zzepVar2, zzepVar3, zzepVar4, zzepVar5, zzepVar6, zzepVar7, zzepVar8, zzepVar9, zzepVar10};
    }

    private zzep(String str, int i, Class cls, Class cls2, Object obj) {
        super(str, i);
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzep[] values() {
        return (zzep[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
