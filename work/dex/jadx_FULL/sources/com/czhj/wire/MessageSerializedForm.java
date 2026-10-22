package com.czhj.wire;

import com.czhj.wire.Message;
import com.czhj.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class MessageSerializedForm<M extends Message<M, B>, B extends Message.Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f29507a;
    private final Class<M> b;

    public MessageSerializedForm(byte[] bArr, Class<M> cls) {
        this.f29507a = bArr;
        this.b = cls;
    }

    public Object readResolve() throws ObjectStreamException {
        try {
            return ProtoAdapter.get(this.b).decode(this.f29507a);
        } catch (IOException e) {
            throw new StreamCorruptedException(e.getMessage());
        }
    }
}
