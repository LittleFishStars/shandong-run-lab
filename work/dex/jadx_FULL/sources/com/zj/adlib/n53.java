package com.zj.adlib;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n53 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f43453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataOutputStream f18358a;

    public n53() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f43453a = byteArrayOutputStream;
        this.f18358a = new DataOutputStream(byteArrayOutputStream);
    }

    public static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f43453a.reset();
        try {
            b(this.f18358a, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            b(this.f18358a, str);
            this.f18358a.writeLong(eventMessage.durationMs);
            this.f18358a.writeLong(eventMessage.id);
            this.f18358a.write(eventMessage.messageData);
            this.f18358a.flush();
            return this.f43453a.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
