package com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.util.CastUtils;
import com.mp4parser.streaming.WriteOnlyBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class AbstractCueBox extends WriteOnlyBox {
    String content;

    public AbstractCueBox(String str) {
        super(str);
        this.content = "";
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(CastUtils.l2i(getSize()));
        IsoTypeWriter.writeUInt32(byteBufferAllocate, getSize());
        byteBufferAllocate.put(IsoFile.fourCCtoBytes(getType()));
        byteBufferAllocate.put(Utf8.convert(this.content));
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
    }

    public String getContent() {
        return this.content;
    }

    public long getSize() {
        return Utf8.utf8StringLengthInBytes(this.content) + 8;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
