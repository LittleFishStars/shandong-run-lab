package com.zj.adlib;

import com.facebook.binaryresource.BinaryResource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class uf3 implements BinaryResource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f45137a;

    public uf3(File file) {
        this.f45137a = (File) ax6.i(file);
    }

    public static uf3 c(File file) {
        if (file != null) {
            return new uf3(file);
        }
        return null;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public byte[] a() throws IOException {
        return ng3.b(this.f45137a);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream b() throws IOException {
        return new FileInputStream(this.f45137a);
    }

    public File d() {
        return this.f45137a;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof uf3)) {
            return false;
        }
        return this.f45137a.equals(((uf3) obj).f45137a);
    }

    public int hashCode() {
        return this.f45137a.hashCode();
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.f45137a.length();
    }
}
