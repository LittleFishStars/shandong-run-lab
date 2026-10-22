package com.byazt.mk;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface n extends my, ReadableByteChannel {
    InputStream a();

    long c(byte b) throws IOException;

    String c(Charset charset) throws IOException;

    void c(long j) throws IOException;

    void c(byte[] bArr) throws IOException;

    boolean c(long j, a aVar) throws IOException;

    int da() throws IOException;

    short i() throws IOException;

    String m() throws IOException;

    String n(long j) throws IOException;

    boolean n() throws IOException;

    byte[] nu() throws IOException;

    short sl() throws IOException;

    byte[] sp(long j) throws IOException;

    int t() throws IOException;

    long u() throws IOException;

    a ve(long j) throws IOException;

    @Deprecated
    ve ve();

    byte x() throws IOException;

    void x(long j) throws IOException;
}
