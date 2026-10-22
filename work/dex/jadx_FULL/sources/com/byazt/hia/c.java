package com.byazt.hia;

import com.byazt.mk.my;
import com.byazt.mk.rh;
import com.byazt.mk.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface c {
    public static final c c = new c() { // from class: com.byazt.hia.c.1
        @Override // com.byazt.hia.c
        public void a(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    a(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                }
            }
        }

        @Override // com.byazt.hia.c
        public my c(File file) throws FileNotFoundException {
            return t.c(file);
        }

        @Override // com.byazt.hia.c
        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.byazt.hia.c
        public long n(File file) {
            return file.length();
        }

        @Override // com.byazt.hia.c
        public rh tt(File file) throws FileNotFoundException {
            try {
                return t.tt(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return t.tt(file);
            }
        }

        @Override // com.byazt.hia.c
        public boolean uj(File file) {
            return file.exists();
        }

        @Override // com.byazt.hia.c
        public rh ve(File file) throws FileNotFoundException {
            try {
                return t.ve(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return t.ve(file);
            }
        }

        @Override // com.byazt.hia.c
        public void c(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    void a(File file) throws IOException;

    my c(File file) throws FileNotFoundException;

    void c(File file, File file2) throws IOException;

    void delete(File file) throws IOException;

    long n(File file);

    rh tt(File file) throws FileNotFoundException;

    boolean uj(File file);

    rh ve(File file) throws FileNotFoundException;
}
