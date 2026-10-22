package com.facebook.binaryresource;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface BinaryResource {
    byte[] a() throws IOException;

    InputStream b() throws IOException;

    long size();
}
