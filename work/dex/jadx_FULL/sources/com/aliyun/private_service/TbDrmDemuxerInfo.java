package com.aliyun.private_service;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TbDrmDemuxerInfo {
    private long contextAddr;
    private long createAddr;
    private long releaseAddr;

    private void setContextAddr(long j) {
        this.contextAddr = j;
    }

    private void setCreateAddr(long j) {
        this.createAddr = j;
    }

    private void setReleaseAddr(long j) {
        this.releaseAddr = j;
    }

    public long getContextAddr() {
        return this.contextAddr;
    }

    public long getCreateAddr() {
        return this.createAddr;
    }

    public long getReleaseAddr() {
        return this.releaseAddr;
    }
}
