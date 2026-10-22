package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.bytedata.ByteOrderDataUtil;
import com.alibaba.ariver.kernel.api.extension.registry.NebulaConfigBase;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class NebulaConfigBase<T extends NebulaConfigBase<T>> {
    protected byte mFormatVersion;

    public NebulaConfigBase(byte b) {
        this.mFormatVersion = b;
    }

    public T deserialize(BufferedInputStream bufferedInputStream) {
        this.mFormatVersion = ByteOrderDataUtil.readByte(bufferedInputStream);
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof NebulaConfigBase) && obj.hashCode() == hashCode();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public T serialize(BufferedOutputStream bufferedOutputStream) throws IOException {
        ByteOrderDataUtil.writeByte(bufferedOutputStream, this.mFormatVersion);
        return this;
    }
}
