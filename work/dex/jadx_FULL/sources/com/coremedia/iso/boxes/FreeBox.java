package com.coremedia.iso.boxes;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FreeBox implements Box {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "free";
    ByteBuffer data;
    private long offset;
    private Container parent;
    List<Box> replacers;

    public FreeBox() {
        this.replacers = new LinkedList();
        this.data = ByteBuffer.wrap(new byte[0]);
    }

    public void addAndReplace(Box box) {
        this.data.position(CastUtils.l2i(box.getSize()));
        this.data = this.data.slice();
        this.replacers.add(box);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FreeBox freeBox = (FreeBox) obj;
        return getData() == null ? freeBox.getData() == null : getData().equals(freeBox.getData());
    }

    @Override // com.coremedia.iso.boxes.Box
    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        Iterator<Box> it = this.replacers.iterator();
        while (it.hasNext()) {
            it.next().getBox(writableByteChannel);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        IsoTypeWriter.writeUInt32(byteBufferAllocate, this.data.limit() + 8);
        byteBufferAllocate.put(TYPE.getBytes());
        byteBufferAllocate.rewind();
        writableByteChannel.write(byteBufferAllocate);
        byteBufferAllocate.rewind();
        this.data.rewind();
        writableByteChannel.write(this.data);
        this.data.rewind();
    }

    public ByteBuffer getData() {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            return (ByteBuffer) byteBuffer.duplicate().rewind();
        }
        return null;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getOffset() {
        return this.offset;
    }

    @Override // com.coremedia.iso.boxes.Box
    public Container getParent() {
        return this.parent;
    }

    @Override // com.coremedia.iso.boxes.Box
    public long getSize() {
        Iterator<Box> it = this.replacers.iterator();
        long size = 8;
        while (it.hasNext()) {
            size += it.next().getSize();
        }
        return size + ((long) this.data.limit());
    }

    @Override // com.coremedia.iso.boxes.Box
    public String getType() {
        return TYPE;
    }

    public int hashCode() {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        this.offset = dataSource.position() - ((long) byteBuffer.remaining());
        if (j > 1048576) {
            this.data = dataSource.map(dataSource.position(), j);
            dataSource.position(dataSource.position() + j);
        } else {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(CastUtils.l2i(j));
            this.data = byteBufferAllocate;
            dataSource.read(byteBufferAllocate);
        }
    }

    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    @Override // com.coremedia.iso.boxes.Box
    public void setParent(Container container) {
        this.parent = container;
    }

    public FreeBox(int i) {
        this.replacers = new LinkedList();
        this.data = ByteBuffer.allocate(i);
    }
}
