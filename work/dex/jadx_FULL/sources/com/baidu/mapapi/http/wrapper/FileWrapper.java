package com.baidu.mapapi.http.wrapper;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class FileWrapper {
    private byte[] file;
    private String mimeType;
    private String name;
    private File rawFile;

    public FileWrapper(File file) {
        this.rawFile = file;
    }

    public byte[] getFile() {
        return this.file;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return this.name;
    }

    public File getRawFile() {
        return this.rawFile;
    }

    public void setFile(byte[] bArr) {
        this.file = bArr;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRawFile(File file) {
        this.rawFile = file;
    }

    public FileWrapper(byte[] bArr, String str, String str2) {
        this.file = bArr;
        this.name = str;
        this.mimeType = str2;
    }
}
