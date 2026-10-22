package com.kc.dw.core.bquery;

import com.kc.dw.core.safe.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f39237a;
    public final long b;

    public b(File file, long j) {
        this.f39237a = file;
        this.b = j;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        File file = this.f39237a;
        long j = this.b;
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            Arrays.sort(fileArrListFiles);
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    file2.length();
                    if (System.currentTimeMillis() - file2.lastModified() >= j) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
