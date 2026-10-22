package anetwork.network.cache;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CacheBlockConfig implements Serializable {
    private static final long serialVersionUID = -2567271693706129850L;
    public String blockName;
    public long blockSize;
    public boolean isCompress;
    public boolean isEncrypt;
    public boolean isRemovable;

    public CacheBlockConfig(String str, long j, boolean z, boolean z2, boolean z3) {
    }

    public String toString() {
    }

    public CacheBlockConfig() {
    }
}
