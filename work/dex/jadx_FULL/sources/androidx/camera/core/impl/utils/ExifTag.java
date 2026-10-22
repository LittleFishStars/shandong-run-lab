package androidx.camera.core.impl.utils;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
class ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    public ExifTag(String str, int i, int i2) {
        this.name = str;
        this.number = i;
        this.primaryFormat = i2;
        this.secondaryFormat = -1;
    }

    public boolean isFormatCompatible(int i) {
        int i2;
        int i3 = this.primaryFormat;
        if (i3 == 7 || i == 7 || i3 == i || (i2 = this.secondaryFormat) == i) {
            return true;
        }
        if ((i3 == 4 || i2 == 4) && i == 3) {
            return true;
        }
        if ((i3 == 9 || i2 == 9) && i == 8) {
            return true;
        }
        return (i3 == 12 || i2 == 12) && i == 11;
    }

    public ExifTag(String str, int i, int i2, int i3) {
        this.name = str;
        this.number = i;
        this.primaryFormat = i2;
        this.secondaryFormat = i3;
    }
}
