package com.zj.adlib;

import com.google.android.odml.image.ImageProperties;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class dec extends ImageProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41166a;
    public final int b;

    public /* synthetic */ dec(int i, int i2, n6c n6cVar) {
        this.f41166a = i;
        this.b = i2;
    }

    @Override // com.google.android.odml.image.ImageProperties
    public final int a() {
        return this.f41166a;
    }

    @Override // com.google.android.odml.image.ImageProperties
    public final int b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImageProperties) {
            ImageProperties imageProperties = (ImageProperties) obj;
            if (this.f41166a == imageProperties.a() && this.b == imageProperties.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f41166a ^ 1000003) * 1000003) ^ this.b;
    }

    public final String toString() {
        int i = this.f41166a;
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(65);
        sb.append("ImageProperties{imageFormat=");
        sb.append(i);
        sb.append(", storageType=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
