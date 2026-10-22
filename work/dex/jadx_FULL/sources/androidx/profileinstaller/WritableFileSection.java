package androidx.profileinstaller;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    public WritableFileSection(@NonNull FileSectionType fileSectionType, int i, @NonNull byte[] bArr, boolean z) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i;
        this.mContents = bArr;
        this.mNeedsCompression = z;
    }
}
