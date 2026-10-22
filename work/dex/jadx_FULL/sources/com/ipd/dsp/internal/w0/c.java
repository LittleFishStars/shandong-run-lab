package com.ipd.dsp.internal.w0;

import androidx.annotation.Nullable;
import com.ipd.dsp.internal.c2.k;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38593a = "Files";

    public static final class b implements Comparator<File> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return Long.compare(file.lastModified(), file2.lastModified());
        }
    }

    public static List<File> a(@Nullable File file) {
        File[] fileArrListFiles;
        LinkedList linkedList = new LinkedList();
        if (file == null || (fileArrListFiles = file.listFiles()) == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new b());
        return listAsList;
    }

    public static void b(File file) throws IOException {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
            }
        } else {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " is not directory!");
        }
    }

    public static void c(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            d(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte b2 = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(b2);
        randomAccessFile.close();
    }

    public static void d(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }

    public static void e(File file) throws IOException {
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            c(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                k.f(f38593a, String.format("Last modified data %sis not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
            }
        }
    }
}
