package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface x extends s.a {

    public interface a {
        t Bf();

        boolean a(MessageSnapshot messageSnapshot);

        boolean b(MessageSnapshot messageSnapshot);

        boolean c(MessageSnapshot messageSnapshot);

        boolean d(MessageSnapshot messageSnapshot);

        MessageSnapshot n(Throwable th);
    }

    public interface b {
        void start();
    }

    byte AH();

    Throwable AJ();

    int AL();

    boolean AN();

    void Bg();

    long Bh();

    void free();

    long getStatusUpdateTime();

    long getTotalBytes();

    boolean pause();

    void reset();
}
