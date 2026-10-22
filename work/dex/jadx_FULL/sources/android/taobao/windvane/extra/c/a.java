package android.taobao.windvane.extra.c;

import android.taobao.windvane.util.TaoLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21223a = "ProcessLockUtil";
    private File b;
    private RandomAccessFile c;
    private FileChannel d;
    private FileLock e;

    public a(String str) {
        this.b = new File(str);
    }

    public void a() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.b, "rw");
            this.c = randomAccessFile;
            if (this.b == null) {
                TaoLog.e(f21223a, "lock error lockRaf = " + this.c + " lockFile = " + this.b);
                return;
            }
            this.d = randomAccessFile.getChannel();
            TaoLog.d(f21223a, "Blocking on lock " + this.b.getPath());
            try {
                this.e = this.d.lock();
                TaoLog.d(f21223a, this.b.getPath() + " locked");
            } catch (IOException e) {
                TaoLog.e(f21223a, "lock error ", e, new Object[0]);
            }
        } catch (FileNotFoundException e2) {
            TaoLog.e(f21223a, "ProcessLock error", e2, new Object[0]);
        }
    }

    public void b() {
        FileLock fileLock = this.e;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (IOException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to release lock on ");
                File file = this.b;
                sb.append(file != null ? file.getPath() : "");
                TaoLog.e(f21223a, sb.toString());
            }
        }
        FileChannel fileChannel = this.d;
        if (fileChannel != null) {
            a(fileChannel);
        }
        a(this.c);
        if (this.b != null) {
            TaoLog.d(f21223a, this.b.getPath() + " unlocked");
        }
    }

    public a(File file) {
        this.b = file;
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                TaoLog.e(f21223a, "Failed to close resource", e, new Object[0]);
            }
        }
    }
}
