package com.coremedia.iso.boxes;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.zj.adlib.nv1;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.runtime.reflect.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ItemLocationBox extends AbstractFullBox {
    public static final String TYPE = "iloc";
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_10 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_11 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public int baseOffsetSize;
    public int indexSize;
    public List<Item> items;
    public int lengthSize;
    public int offsetSize;

    static {
        ajc$preClinit();
    }

    public ItemLocationBox() {
        super(TYPE);
        this.offsetSize = 8;
        this.lengthSize = 8;
        this.baseOffsetSize = 8;
        this.indexSize = 0;
        this.items = new LinkedList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        d dVar = new d("ItemLocationBox.java", ItemLocationBox.class);
        ajc$tjp_0 = dVar.H("method-execution", dVar.E("1", "getOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 119);
        ajc$tjp_1 = dVar.H("method-execution", dVar.E("1", "setOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "offsetSize", "", "void"), 123);
        ajc$tjp_10 = dVar.H("method-execution", dVar.E("1", "createItem", "com.coremedia.iso.boxes.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "com.coremedia.iso.boxes.ItemLocationBox$Item"), 160);
        ajc$tjp_11 = dVar.H("method-execution", dVar.E("1", "createExtent", "com.coremedia.iso.boxes.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "com.coremedia.iso.boxes.ItemLocationBox$Extent"), MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL);
        ajc$tjp_2 = dVar.H("method-execution", dVar.E("1", "getLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 127);
        ajc$tjp_3 = dVar.H("method-execution", dVar.E("1", "setLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "lengthSize", "", "void"), 131);
        ajc$tjp_4 = dVar.H("method-execution", dVar.E("1", "getBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 135);
        ajc$tjp_5 = dVar.H("method-execution", dVar.E("1", "setBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "baseOffsetSize", "", "void"), 139);
        ajc$tjp_6 = dVar.H("method-execution", dVar.E("1", "getIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 143);
        ajc$tjp_7 = dVar.H("method-execution", dVar.E("1", "setIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "indexSize", "", "void"), 147);
        ajc$tjp_8 = dVar.H("method-execution", dVar.E("1", "getItems", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "java.util.List"), 151);
        ajc$tjp_9 = dVar.H("method-execution", dVar.E("1", "setItems", "com.coremedia.iso.boxes.ItemLocationBox", "java.util.List", "items", "", "void"), 155);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int uInt8 = IsoTypeReader.readUInt8(byteBuffer);
        this.offsetSize = uInt8 >>> 4;
        this.lengthSize = uInt8 & 15;
        int uInt9 = IsoTypeReader.readUInt8(byteBuffer);
        this.baseOffsetSize = uInt9 >>> 4;
        if (getVersion() == 1) {
            this.indexSize = uInt9 & 15;
        }
        int uInt16 = IsoTypeReader.readUInt16(byteBuffer);
        for (int i = 0; i < uInt16; i++) {
            this.items.add(new Item(byteBuffer));
        }
    }

    public Extent createExtent(long j, long j2, long j3) {
        RequiresParseDetailAspect.aspectOf().before(d.y(ajc$tjp_11, this, this, new Object[]{nv1.m(j), nv1.m(j2), nv1.m(j3)}));
        return new Extent(j, j2, j3);
    }

    public Item createItem(int i, int i2, int i3, long j, List<Extent> list) {
        RequiresParseDetailAspect.aspectOf().before(d.y(ajc$tjp_10, this, this, new Object[]{nv1.k(i), nv1.k(i2), nv1.k(i3), nv1.m(j), list}));
        return new Item(i, i2, i3, j, list);
    }

    public int getBaseOffsetSize() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_4, this, this));
        return this.baseOffsetSize;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.writeUInt8(byteBuffer, (this.offsetSize << 4) | this.lengthSize);
        if (getVersion() == 1) {
            IsoTypeWriter.writeUInt8(byteBuffer, (this.baseOffsetSize << 4) | this.indexSize);
        } else {
            IsoTypeWriter.writeUInt8(byteBuffer, this.baseOffsetSize << 4);
        }
        IsoTypeWriter.writeUInt16(byteBuffer, this.items.size());
        Iterator<Item> it = this.items.iterator();
        while (it.hasNext()) {
            it.next().getContent(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        Iterator<Item> it = this.items.iterator();
        long size = 8;
        while (it.hasNext()) {
            size += (long) it.next().getSize();
        }
        return size;
    }

    public int getIndexSize() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_6, this, this));
        return this.indexSize;
    }

    public List<Item> getItems() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_8, this, this));
        return this.items;
    }

    public int getLengthSize() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_2, this, this));
        return this.lengthSize;
    }

    public int getOffsetSize() {
        RequiresParseDetailAspect.aspectOf().before(d.v(ajc$tjp_0, this, this));
        return this.offsetSize;
    }

    public void setBaseOffsetSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_5, this, this, nv1.k(i)));
        this.baseOffsetSize = i;
    }

    public void setIndexSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_7, this, this, nv1.k(i)));
        this.indexSize = i;
    }

    public void setItems(List<Item> list) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_9, this, this, list));
        this.items = list;
    }

    public void setLengthSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_3, this, this, nv1.k(i)));
        this.lengthSize = i;
    }

    public void setOffsetSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(d.w(ajc$tjp_1, this, this, nv1.k(i)));
        this.offsetSize = i;
    }

    public Extent createExtent(ByteBuffer byteBuffer) {
        return new Extent(byteBuffer);
    }

    public Item createItem(ByteBuffer byteBuffer) {
        return new Item(byteBuffer);
    }

    public class Extent {
        public long extentIndex;
        public long extentLength;
        public long extentOffset;

        public Extent(long j, long j2, long j3) {
            this.extentOffset = j;
            this.extentLength = j2;
            this.extentIndex = j3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Extent extent = (Extent) obj;
            return this.extentIndex == extent.extentIndex && this.extentLength == extent.extentLength && this.extentOffset == extent.extentOffset;
        }

        public void getContent(ByteBuffer byteBuffer) {
            int i;
            if (ItemLocationBox.this.getVersion() == 1 && (i = ItemLocationBox.this.indexSize) > 0) {
                IsoTypeWriterVariable.write(this.extentIndex, byteBuffer, i);
            }
            IsoTypeWriterVariable.write(this.extentOffset, byteBuffer, ItemLocationBox.this.offsetSize);
            IsoTypeWriterVariable.write(this.extentLength, byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public int getSize() {
            ItemLocationBox itemLocationBox = ItemLocationBox.this;
            int i = itemLocationBox.indexSize;
            if (i <= 0) {
                i = 0;
            }
            return i + itemLocationBox.offsetSize + itemLocationBox.lengthSize;
        }

        public int hashCode() {
            long j = this.extentOffset;
            long j2 = this.extentLength;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.extentIndex;
            return i + ((int) ((j3 >>> 32) ^ j3));
        }

        public String toString() {
            return "Extent{extentOffset=" + this.extentOffset + ", extentLength=" + this.extentLength + ", extentIndex=" + this.extentIndex + '}';
        }

        public Extent(ByteBuffer byteBuffer) {
            int i;
            if (ItemLocationBox.this.getVersion() == 1 && (i = ItemLocationBox.this.indexSize) > 0) {
                this.extentIndex = IsoTypeReaderVariable.read(byteBuffer, i);
            }
            this.extentOffset = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.offsetSize);
            this.extentLength = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.lengthSize);
        }
    }

    public class Item {
        public long baseOffset;
        public int constructionMethod;
        public int dataReferenceIndex;
        public List<Extent> extents;
        public int itemId;

        public Item(ByteBuffer byteBuffer) {
            this.extents = new LinkedList();
            this.itemId = IsoTypeReader.readUInt16(byteBuffer);
            if (ItemLocationBox.this.getVersion() == 1) {
                this.constructionMethod = IsoTypeReader.readUInt16(byteBuffer) & 15;
            }
            this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBuffer);
            int i = ItemLocationBox.this.baseOffsetSize;
            if (i > 0) {
                this.baseOffset = IsoTypeReaderVariable.read(byteBuffer, i);
            } else {
                this.baseOffset = 0L;
            }
            int uInt16 = IsoTypeReader.readUInt16(byteBuffer);
            for (int i2 = 0; i2 < uInt16; i2++) {
                this.extents.add(ItemLocationBox.this.new Extent(byteBuffer));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Item item = (Item) obj;
            if (this.baseOffset != item.baseOffset || this.constructionMethod != item.constructionMethod || this.dataReferenceIndex != item.dataReferenceIndex || this.itemId != item.itemId) {
                return false;
            }
            List<Extent> list = this.extents;
            List<Extent> list2 = item.extents;
            return list == null ? list2 == null : list.equals(list2);
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.writeUInt16(byteBuffer, this.itemId);
            if (ItemLocationBox.this.getVersion() == 1) {
                IsoTypeWriter.writeUInt16(byteBuffer, this.constructionMethod);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.dataReferenceIndex);
            int i = ItemLocationBox.this.baseOffsetSize;
            if (i > 0) {
                IsoTypeWriterVariable.write(this.baseOffset, byteBuffer, i);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.extents.size());
            Iterator<Extent> it = this.extents.iterator();
            while (it.hasNext()) {
                it.next().getContent(byteBuffer);
            }
        }

        public int getSize() {
            int size = (ItemLocationBox.this.getVersion() == 1 ? 4 : 2) + 2 + ItemLocationBox.this.baseOffsetSize + 2;
            Iterator<Extent> it = this.extents.iterator();
            while (it.hasNext()) {
                size += it.next().getSize();
            }
            return size;
        }

        public int hashCode() {
            int i = ((((this.itemId * 31) + this.constructionMethod) * 31) + this.dataReferenceIndex) * 31;
            long j = this.baseOffset;
            int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
            List<Extent> list = this.extents;
            return i2 + (list != null ? list.hashCode() : 0);
        }

        public void setBaseOffset(long j) {
            this.baseOffset = j;
        }

        public String toString() {
            return "Item{baseOffset=" + this.baseOffset + ", itemId=" + this.itemId + ", constructionMethod=" + this.constructionMethod + ", dataReferenceIndex=" + this.dataReferenceIndex + ", extents=" + this.extents + '}';
        }

        public Item(int i, int i2, int i3, long j, List<Extent> list) {
            new LinkedList();
            this.itemId = i;
            this.constructionMethod = i2;
            this.dataReferenceIndex = i3;
            this.baseOffset = j;
            this.extents = list;
        }
    }
}
