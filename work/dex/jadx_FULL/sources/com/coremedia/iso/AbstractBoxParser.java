package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractBoxParser implements BoxParser {
    private static Logger LOG = Logger.getLogger(AbstractBoxParser.class.getName());
    ThreadLocal<ByteBuffer> header = new ThreadLocal<ByteBuffer>() { // from class: com.coremedia.iso.AbstractBoxParser.1
        @Override // java.lang.ThreadLocal
        public ByteBuffer initialValue() {
            return ByteBuffer.allocate(32);
        }
    };

    public abstract Box createBox(String str, byte[] bArr, String str2);

    @Override // com.coremedia.iso.BoxParser
    public Box parseBox(DataSource dataSource, Container container) throws IOException {
        int i;
        long uInt64;
        long j;
        long jPosition = dataSource.position();
        this.header.get().rewind().limit(8);
        do {
            i = dataSource.read(this.header.get());
            if (i == 8) {
                this.header.get().rewind();
                long uInt32 = IsoTypeReader.readUInt32(this.header.get());
                long jPosition2 = 8;
                byte[] bArr = null;
                if (uInt32 < 8 && uInt32 > 1) {
                    LOG.severe("Plausibility check failed: size < 8 (size = " + uInt32 + "). Stop parsing!");
                    return null;
                }
                String str = IsoTypeReader.read4cc(this.header.get());
                if (uInt32 == 1) {
                    this.header.get().limit(16);
                    dataSource.read(this.header.get());
                    this.header.get().position(8);
                    uInt64 = IsoTypeReader.readUInt64(this.header.get()) - 16;
                } else {
                    if (uInt32 == 0) {
                        uInt32 = dataSource.size();
                        jPosition2 = dataSource.position();
                    }
                    uInt64 = uInt32 - jPosition2;
                }
                if ("uuid".equals(str)) {
                    this.header.get().limit(this.header.get().limit() + 16);
                    dataSource.read(this.header.get());
                    byte[] bArr2 = new byte[16];
                    for (int iPosition = this.header.get().position() - 16; iPosition < this.header.get().position(); iPosition++) {
                        bArr2[iPosition - (this.header.get().position() - 16)] = this.header.get().get(iPosition);
                    }
                    j = uInt64 - 16;
                    bArr = bArr2;
                } else {
                    j = uInt64;
                }
                Box boxCreateBox = createBox(str, bArr, container instanceof Box ? ((Box) container).getType() : "");
                boxCreateBox.setParent(container);
                this.header.get().rewind();
                boxCreateBox.parse(dataSource, this.header.get(), j, this);
                return boxCreateBox;
            }
        } while (i >= 0);
        dataSource.position(jPosition);
        throw new EOFException();
    }
}
