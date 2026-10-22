package com.googlecode.mp4parser;

import com.googlecode.mp4parser.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class FileDataSourceImpl implements DataSource {
    private static Logger LOG = Logger.getLogger(FileDataSourceImpl.class);
    FileChannel fc;
    String filename;

    public FileDataSourceImpl(File file) throws FileNotFoundException {
        this.fc = new FileInputStream(file).getChannel();
        this.filename = file.getName();
    }

    @Override // com.googlecode.mp4parser.DataSource, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.fc.close();
    }

    @Override // com.googlecode.mp4parser.DataSource
    public synchronized ByteBuffer map(long j, long j2) throws IOException {
        return this.fc.map(FileChannel.MapMode.READ_ONLY, j, j2);
    }

    @Override // com.googlecode.mp4parser.DataSource
    public synchronized long position() throws IOException {
        return this.fc.position();
    }

    @Override // com.googlecode.mp4parser.DataSource
    public synchronized int read(ByteBuffer byteBuffer) throws IOException {
        return this.fc.read(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.DataSource
    public synchronized long size() throws IOException {
        return this.fc.size();
    }

    public String toString() {
        return this.filename;
    }

    @Override // com.googlecode.mp4parser.DataSource
    public synchronized long transferTo(long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        return this.fc.transferTo(j, j2, writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.DataSource
    public synchronized void position(long j) throws IOException {
        this.fc.position(j);
    }

    public FileDataSourceImpl(String str) throws FileNotFoundException {
        File file = new File(str);
        this.fc = new FileInputStream(file).getChannel();
        this.filename = file.getName();
    }

    public FileDataSourceImpl(FileChannel fileChannel) {
        this.fc = fileChannel;
        this.filename = "unknown";
    }

    public FileDataSourceImpl(FileChannel fileChannel, String str) {
        this.fc = fileChannel;
        this.filename = str;
    }
}
