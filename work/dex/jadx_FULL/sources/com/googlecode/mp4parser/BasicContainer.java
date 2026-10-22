package com.googlecode.mp4parser;

import com.alipay.sdk.m.y.l;
import com.coremedia.iso.BoxParser;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.LazyList;
import com.googlecode.mp4parser.util.Logger;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BasicContainer implements Container, Iterator<Box>, Closeable {
    private static final Box EOF = new AbstractBox("eof ") { // from class: com.googlecode.mp4parser.BasicContainer.1
        @Override // com.googlecode.mp4parser.AbstractBox
        public void _parseDetails(ByteBuffer byteBuffer) {
        }

        @Override // com.googlecode.mp4parser.AbstractBox
        public void getContent(ByteBuffer byteBuffer) {
        }

        @Override // com.googlecode.mp4parser.AbstractBox
        public long getContentSize() {
            return 0L;
        }
    };
    private static Logger LOG = Logger.getLogger(BasicContainer.class);
    protected BoxParser boxParser;
    protected DataSource dataSource;
    Box lookahead = null;
    long parsePosition = 0;
    long startPosition = 0;
    long endPosition = 0;
    private List<Box> boxes = new ArrayList();

    public void addBox(Box box) {
        if (box != null) {
            this.boxes = new ArrayList(getBoxes());
            box.setParent(this);
            this.boxes.add(box);
        }
    }

    public void close() throws IOException {
        this.dataSource.close();
    }

    @Override // com.coremedia.iso.boxes.Container
    public List<Box> getBoxes() {
        return (this.dataSource == null || this.lookahead == EOF) ? this.boxes : new LazyList(this.boxes, this);
    }

    @Override // com.coremedia.iso.boxes.Container
    public ByteBuffer getByteBuffer(long j, long j2) throws IOException {
        ByteBuffer map;
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            synchronized (dataSource) {
                map = this.dataSource.map(this.startPosition + j, j2);
            }
            return map;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(CastUtils.l2i(j2));
        long j3 = j + j2;
        long j4 = 0;
        for (Box box : this.boxes) {
            long size = box.getSize() + j4;
            if (size > j && j4 < j3) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(byteArrayOutputStream);
                box.getBox(writableByteChannelNewChannel);
                writableByteChannelNewChannel.close();
                if (j4 >= j && size <= j3) {
                    byteBufferAllocate.put(byteArrayOutputStream.toByteArray());
                } else if (j4 < j && size > j3) {
                    long j5 = j - j4;
                    byteBufferAllocate.put(byteArrayOutputStream.toByteArray(), CastUtils.l2i(j5), CastUtils.l2i((box.getSize() - j5) - (size - j3)));
                } else if (j4 < j && size <= j3) {
                    long j6 = j - j4;
                    byteBufferAllocate.put(byteArrayOutputStream.toByteArray(), CastUtils.l2i(j6), CastUtils.l2i(box.getSize() - j6));
                } else if (j4 >= j && size > j3) {
                    byteBufferAllocate.put(byteArrayOutputStream.toByteArray(), 0, CastUtils.l2i(box.getSize() - (size - j3)));
                }
            }
            j4 = size;
        }
        return (ByteBuffer) byteBufferAllocate.rewind();
    }

    public long getContainerSize() {
        long size = 0;
        for (int i = 0; i < getBoxes().size(); i++) {
            size += this.boxes.get(i).getSize();
        }
        return size;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Box box = this.lookahead;
        if (box == EOF) {
            return false;
        }
        if (box != null) {
            return true;
        }
        try {
            this.lookahead = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.lookahead = EOF;
            return false;
        }
    }

    public void initContainer(DataSource dataSource, long j, BoxParser boxParser) throws IOException {
        this.dataSource = dataSource;
        long jPosition = dataSource.position();
        this.startPosition = jPosition;
        this.parsePosition = jPosition;
        dataSource.position(dataSource.position() + j);
        this.endPosition = dataSource.position();
        this.boxParser = boxParser;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // com.coremedia.iso.boxes.Container
    public void setBoxes(List<Box> list) {
        this.boxes = new ArrayList(list);
        this.lookahead = EOF;
        this.dataSource = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.boxes.size(); i++) {
            if (i > 0) {
                sb.append(l.b);
            }
            sb.append(this.boxes.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.coremedia.iso.boxes.Container
    public final void writeContainer(WritableByteChannel writableByteChannel) throws IOException {
        Iterator<Box> it = getBoxes().iterator();
        while (it.hasNext()) {
            it.next().getBox(writableByteChannel);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Box next() {
        Box box;
        Box box2 = this.lookahead;
        if (box2 != null && box2 != EOF) {
            this.lookahead = null;
            return box2;
        }
        DataSource dataSource = this.dataSource;
        if (dataSource == null || this.parsePosition >= this.endPosition) {
            this.lookahead = EOF;
            throw new NoSuchElementException();
        }
        try {
            synchronized (dataSource) {
                this.dataSource.position(this.parsePosition);
                box = this.boxParser.parseBox(this.dataSource, this);
                this.parsePosition = this.dataSource.position();
            }
            return box;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    @Override // com.coremedia.iso.boxes.Container
    public <T extends Box> List<T> getBoxes(Class<T> cls) {
        List<Box> boxes = getBoxes();
        ArrayList arrayList = null;
        Box box = null;
        for (int i = 0; i < boxes.size(); i++) {
            Box box2 = boxes.get(i);
            if (cls.isInstance(box2)) {
                if (box == null) {
                    box = box2;
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                        arrayList.add(box);
                    }
                    arrayList.add(box2);
                }
            }
        }
        if (arrayList != null) {
            return arrayList;
        }
        if (box != null) {
            return Collections.singletonList(box);
        }
        return Collections.emptyList();
    }

    @Override // com.coremedia.iso.boxes.Container
    public <T extends Box> List<T> getBoxes(Class<T> cls, boolean z) {
        ArrayList arrayList = new ArrayList(2);
        List<Box> boxes = getBoxes();
        for (int i = 0; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            if (cls.isInstance(box)) {
                arrayList.add(box);
            }
            if (z && (box instanceof Container)) {
                arrayList.addAll(((Container) box).getBoxes(cls, z));
            }
        }
        return arrayList;
    }
}
