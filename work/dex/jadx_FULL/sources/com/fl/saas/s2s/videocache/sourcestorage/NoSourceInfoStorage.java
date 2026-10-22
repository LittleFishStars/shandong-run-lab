package com.fl.saas.s2s.videocache.sourcestorage;

import com.fl.saas.s2s.videocache.SourceInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NoSourceInfoStorage implements SourceInfoStorage {
    @Override // com.fl.saas.s2s.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String str) {
        return null;
    }

    @Override // com.fl.saas.s2s.videocache.sourcestorage.SourceInfoStorage
    public void put(String str, SourceInfo sourceInfo) {
    }

    @Override // com.fl.saas.s2s.videocache.sourcestorage.SourceInfoStorage
    public void release() {
    }
}
