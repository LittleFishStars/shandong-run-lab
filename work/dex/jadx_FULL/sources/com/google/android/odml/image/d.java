package com.google.android.odml.image;

import com.zj.adlib.dec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class d extends zzh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f31543a;
    public Integer b;

    @Override // com.google.android.odml.image.zzh
    public final zzh a(int i) {
        this.f31543a = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.android.odml.image.zzh
    public final zzh b(int i) {
        this.b = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.android.odml.image.zzh
    public final ImageProperties c() {
        Integer num = this.f31543a;
        if (num != null && this.b != null) {
            return new dec(num.intValue(), this.b.intValue(), null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f31543a == null) {
            sb.append(" imageFormat");
        }
        if (this.b == null) {
            sb.append(" storageType");
        }
        String strValueOf = String.valueOf(sb);
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 28);
        sb2.append("Missing required properties:");
        sb2.append(strValueOf);
        throw new IllegalStateException(sb2.toString());
    }
}
