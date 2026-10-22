package com.google.android.inner_exoplayer2.upstream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface TransferListener {
    void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i);

    void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z);

    void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z);

    void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z);
}
