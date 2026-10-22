package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Descriptor(tags = {0})
public abstract class BaseDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int sizeBytes;
    int sizeOfInstance;
    int tag;

    public abstract int getContentSize();

    public int getSize() {
        return getContentSize() + getSizeSize() + 1;
    }

    public int getSizeSize() {
        int contentSize = getContentSize();
        int i = 0;
        while (true) {
            if (contentSize <= 0 && i >= this.sizeBytes) {
                return i;
            }
            contentSize >>>= 7;
            i++;
        }
    }

    public int getTag() {
        return this.tag;
    }

    public final void parse(int i, ByteBuffer byteBuffer) throws IOException {
        this.tag = i;
        int uInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.sizeOfInstance = uInt8 & 127;
        int i2 = 1;
        while ((uInt8 >>> 7) == 1) {
            uInt8 = IsoTypeReader.readUInt8(byteBuffer);
            i2++;
            this.sizeOfInstance = (this.sizeOfInstance << 7) | (uInt8 & 127);
        }
        this.sizeBytes = i2;
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.limit(this.sizeOfInstance);
        parseDetail(byteBufferSlice);
        byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
    }

    public abstract void parseDetail(ByteBuffer byteBuffer) throws IOException;

    public abstract ByteBuffer serialize();

    public String toString() {
        return "BaseDescriptor{tag=" + this.tag + ", sizeOfInstance=" + this.sizeOfInstance + '}';
    }

    public void writeSize(ByteBuffer byteBuffer, int i) {
        int iPosition = byteBuffer.position();
        int i2 = 0;
        while (true) {
            if (i <= 0 && i2 >= this.sizeBytes) {
                byteBuffer.position(iPosition + getSizeSize());
                return;
            }
            i2++;
            if (i > 0) {
                byteBuffer.put((getSizeSize() + iPosition) - i2, (byte) (i & 127));
            } else {
                byteBuffer.put((getSizeSize() + iPosition) - i2, UnsignedBytes.f32243a);
            }
            i >>>= 7;
        }
    }
}
