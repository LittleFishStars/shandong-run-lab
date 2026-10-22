package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class VisualSampleEntry extends AbstractSampleEntry implements Container {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE1 = "mp4v";
    public static final String TYPE2 = "s263";
    public static final String TYPE3 = "avc1";
    public static final String TYPE4 = "avc3";
    public static final String TYPE5 = "drmi";
    public static final String TYPE6 = "hvc1";
    public static final String TYPE7 = "hev1";
    public static final String TYPE_ENCRYPTED = "encv";
    private String compressorname;
    private int depth;
    private int frameCount;
    private int height;
    private double horizresolution;
    private long[] predefined;
    private double vertresolution;
    private int width;

    public VisualSampleEntry() {
        super("avc1");
        this.horizresolution = 72.0d;
        this.vertresolution = 72.0d;
        this.frameCount = 1;
        this.compressorname = "";
        this.depth = 24;
        this.predefined = new long[3];
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(78);
        byteBufferAllocate.position(6);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, this.dataReferenceIndex);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, 0);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, 0);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.predefined[0]);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.predefined[1]);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.predefined[2]);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, getWidth());
        IsoTypeWriter.writeUInt16(byteBufferAllocate, getHeight());
        IsoTypeWriter.writeFixedPoint1616(byteBufferAllocate, getHorizresolution());
        IsoTypeWriter.writeFixedPoint1616(byteBufferAllocate, getVertresolution());
        IsoTypeWriter.writeUInt32(byteBufferAllocate, 0L);
        IsoTypeWriter.writeUInt16(byteBufferAllocate, getFrameCount());
        IsoTypeWriter.writeUInt8(byteBufferAllocate, Utf8.utf8StringLengthInBytes(getCompressorname()));
        byteBufferAllocate.put(Utf8.convert(getCompressorname()));
        int iUtf8StringLengthInBytes = Utf8.utf8StringLengthInBytes(getCompressorname());
        while (iUtf8StringLengthInBytes < 31) {
            iUtf8StringLengthInBytes++;
            byteBufferAllocate.put((byte) 0);
        }
        IsoTypeWriter.writeUInt16(byteBufferAllocate, getDepth());
        IsoTypeWriter.writeUInt16(byteBufferAllocate, 65535);
        writableByteChannel.write((ByteBuffer) byteBufferAllocate.rewind());
        writeContainer(writableByteChannel);
    }

    public String getCompressorname() {
        return this.compressorname;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getFrameCount() {
        return this.frameCount;
    }

    public int getHeight() {
        return this.height;
    }

    public double getHorizresolution() {
        return this.horizresolution;
    }

    @Override // com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public long getSize() {
        long containerSize = getContainerSize() + 78;
        return containerSize + ((long) ((this.largeBox || 8 + containerSize >= 4294967296L) ? 16 : 8));
    }

    public double getVertresolution() {
        return this.vertresolution;
    }

    public int getWidth() {
        return this.width;
    }

    @Override // com.coremedia.iso.boxes.sampleentry.AbstractSampleEntry, com.googlecode.mp4parser.AbstractContainerBox, com.coremedia.iso.boxes.Box
    public void parse(final DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        final long jPosition = dataSource.position() + j;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(78);
        dataSource.read(byteBufferAllocate);
        byteBufferAllocate.position(6);
        this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBufferAllocate);
        IsoTypeReader.readUInt16(byteBufferAllocate);
        IsoTypeReader.readUInt16(byteBufferAllocate);
        this.predefined[0] = IsoTypeReader.readUInt32(byteBufferAllocate);
        this.predefined[1] = IsoTypeReader.readUInt32(byteBufferAllocate);
        this.predefined[2] = IsoTypeReader.readUInt32(byteBufferAllocate);
        this.width = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.height = IsoTypeReader.readUInt16(byteBufferAllocate);
        this.horizresolution = IsoTypeReader.readFixedPoint1616(byteBufferAllocate);
        this.vertresolution = IsoTypeReader.readFixedPoint1616(byteBufferAllocate);
        IsoTypeReader.readUInt32(byteBufferAllocate);
        this.frameCount = IsoTypeReader.readUInt16(byteBufferAllocate);
        int uInt8 = IsoTypeReader.readUInt8(byteBufferAllocate);
        if (uInt8 > 31) {
            uInt8 = 31;
        }
        byte[] bArr = new byte[uInt8];
        byteBufferAllocate.get(bArr);
        this.compressorname = Utf8.convert(bArr);
        if (uInt8 < 31) {
            byteBufferAllocate.get(new byte[31 - uInt8]);
        }
        this.depth = IsoTypeReader.readUInt16(byteBufferAllocate);
        IsoTypeReader.readUInt16(byteBufferAllocate);
        initContainer(new DataSource() { // from class: com.coremedia.iso.boxes.sampleentry.VisualSampleEntry.1
            @Override // com.googlecode.mp4parser.DataSource, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                dataSource.close();
            }

            @Override // com.googlecode.mp4parser.DataSource
            public ByteBuffer map(long j2, long j3) throws IOException {
                return dataSource.map(j2, j3);
            }

            @Override // com.googlecode.mp4parser.DataSource
            public long position() throws IOException {
                return dataSource.position();
            }

            @Override // com.googlecode.mp4parser.DataSource
            public int read(ByteBuffer byteBuffer2) throws IOException {
                if (jPosition == dataSource.position()) {
                    return -1;
                }
                if (byteBuffer2.remaining() <= jPosition - dataSource.position()) {
                    return dataSource.read(byteBuffer2);
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(CastUtils.l2i(jPosition - dataSource.position()));
                dataSource.read(byteBufferAllocate2);
                byteBuffer2.put((ByteBuffer) byteBufferAllocate2.rewind());
                return byteBufferAllocate2.capacity();
            }

            @Override // com.googlecode.mp4parser.DataSource
            public long size() throws IOException {
                return jPosition;
            }

            @Override // com.googlecode.mp4parser.DataSource
            public long transferTo(long j2, long j3, WritableByteChannel writableByteChannel) throws IOException {
                return dataSource.transferTo(j2, j3, writableByteChannel);
            }

            @Override // com.googlecode.mp4parser.DataSource
            public void position(long j2) throws IOException {
                dataSource.position(j2);
            }
        }, j - 78, boxParser);
    }

    public void setCompressorname(String str) {
        this.compressorname = str;
    }

    public void setDepth(int i) {
        this.depth = i;
    }

    public void setFrameCount(int i) {
        this.frameCount = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setHorizresolution(double d) {
        this.horizresolution = d;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVertresolution(double d) {
        this.vertresolution = d;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public VisualSampleEntry(String str) {
        super(str);
        this.horizresolution = 72.0d;
        this.vertresolution = 72.0d;
        this.frameCount = 1;
        this.compressorname = "";
        this.depth = 24;
        this.predefined = new long[3];
    }
}
