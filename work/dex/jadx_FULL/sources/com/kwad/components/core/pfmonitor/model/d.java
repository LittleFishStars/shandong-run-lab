package com.kwad.components.core.pfmonitor.model;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    private final boolean aiw;
    private final File file;
    private final String fileName;
    private final String filePath;
    private final long size;

    public d(File file, long j, boolean z) {
        this.file = file;
        this.size = j;
        this.aiw = z;
        this.fileName = file.getName();
        this.filePath = file.getAbsolutePath();
    }

    public final File getFile() {
        return this.file;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final boolean isDirectory() {
        return this.aiw;
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = this.aiw ? "[DIR] " : "[FILE] ";
        objArr[1] = this.filePath;
        objArr[2] = com.kwad.components.core.pfmonitor.d.P(this.size);
        return String.format("%s%s - %s", objArr);
    }
}
