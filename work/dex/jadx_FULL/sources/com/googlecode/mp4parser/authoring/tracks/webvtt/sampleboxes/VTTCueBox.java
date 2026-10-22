package com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.mp4parser.streaming.WriteOnlyBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class VTTCueBox extends WriteOnlyBox {
    CueIDBox cueIDBox;
    CuePayloadBox cuePayloadBox;
    CueSettingsBox cueSettingsBox;
    CueSourceIDBox cueSourceIDBox;
    CueTimeBox cueTimeBox;

    public VTTCueBox() {
        super("vtcc");
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, getSize());
        byteBufferAllocate.put(IsoFile.fourCCtoBytes(getType()));
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        CueSourceIDBox cueSourceIDBox = this.cueSourceIDBox;
        if (cueSourceIDBox != null) {
            cueSourceIDBox.getBox(writableByteChannel);
        }
        CueIDBox cueIDBox = this.cueIDBox;
        if (cueIDBox != null) {
            cueIDBox.getBox(writableByteChannel);
        }
        CueTimeBox cueTimeBox = this.cueTimeBox;
        if (cueTimeBox != null) {
            cueTimeBox.getBox(writableByteChannel);
        }
        CueSettingsBox cueSettingsBox = this.cueSettingsBox;
        if (cueSettingsBox != null) {
            cueSettingsBox.getBox(writableByteChannel);
        }
        CuePayloadBox cuePayloadBox = this.cuePayloadBox;
        if (cuePayloadBox != null) {
            cuePayloadBox.getBox(writableByteChannel);
        }
    }

    public CueIDBox getCueIDBox() {
        return this.cueIDBox;
    }

    public CuePayloadBox getCuePayloadBox() {
        return this.cuePayloadBox;
    }

    public CueSettingsBox getCueSettingsBox() {
        return this.cueSettingsBox;
    }

    public CueSourceIDBox getCueSourceIDBox() {
        return this.cueSourceIDBox;
    }

    public CueTimeBox getCueTimeBox() {
        return this.cueTimeBox;
    }

    public long getSize() {
        CueSourceIDBox cueSourceIDBox = this.cueSourceIDBox;
        long size = (cueSourceIDBox != null ? cueSourceIDBox.getSize() : 0L) + 8;
        CueIDBox cueIDBox = this.cueIDBox;
        long size2 = size + (cueIDBox != null ? cueIDBox.getSize() : 0L);
        CueTimeBox cueTimeBox = this.cueTimeBox;
        long size3 = size2 + (cueTimeBox != null ? cueTimeBox.getSize() : 0L);
        CueSettingsBox cueSettingsBox = this.cueSettingsBox;
        long size4 = size3 + (cueSettingsBox != null ? cueSettingsBox.getSize() : 0L);
        CuePayloadBox cuePayloadBox = this.cuePayloadBox;
        return size4 + (cuePayloadBox != null ? cuePayloadBox.getSize() : 0L);
    }

    public void setCueIDBox(CueIDBox cueIDBox) {
        this.cueIDBox = cueIDBox;
    }

    public void setCuePayloadBox(CuePayloadBox cuePayloadBox) {
        this.cuePayloadBox = cuePayloadBox;
    }

    public void setCueSettingsBox(CueSettingsBox cueSettingsBox) {
        this.cueSettingsBox = cueSettingsBox;
    }

    public void setCueSourceIDBox(CueSourceIDBox cueSourceIDBox) {
        this.cueSourceIDBox = cueSourceIDBox;
    }

    public void setCueTimeBox(CueTimeBox cueTimeBox) {
        this.cueTimeBox = cueTimeBox;
    }
}
