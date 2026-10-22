package com.baidu.location.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class LinkAttrt extends MessageMicro {
    public static final int ATTR_FIELD_NUMBER = 6;
    public static final int DIREC_FIELD_NUMBER = 5;
    public static final int ENODE_ID_FIELD_NUMBER = 2;
    public static final int GEO_FIELD_NUMBER = 7;
    public static final int LENGTH_FIELD_NUMBER = 4;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int PARKING_FLOOR_FIELD_NUMBER = 8;
    public static final int PARKING_THEME_FIELD_NUMBER = 9;
    public static final int SNODE_ID_FIELD_NUMBER = 1;
    private int cachedSize;
    private ByteStringMicro geo_;
    private boolean hasAttr;
    private boolean hasDirec;
    private boolean hasEnodeId;
    private boolean hasGeo;
    private boolean hasLength;
    private boolean hasLevel;
    private boolean hasParkingFloor;
    private boolean hasParkingTheme;
    private boolean hasSnodeId;
    private ByteStringMicro parkingFloor_;
    private int parkingTheme_;
    private int snodeId_ = 0;
    private int enodeId_ = 0;
    private int level_ = 0;
    private int length_ = 0;
    private int direc_ = 0;
    private int attr_ = 0;

    public LinkAttrt() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.geo_ = byteStringMicro;
        this.parkingFloor_ = byteStringMicro;
        this.parkingTheme_ = 0;
        this.cachedSize = -1;
    }

    public static LinkAttrt parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new LinkAttrt().mergeFrom(codedInputStreamMicro);
    }

    public static LinkAttrt parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (LinkAttrt) new LinkAttrt().mergeFrom(bArr);
    }

    public final LinkAttrt clear() {
        clearSnodeId();
        clearEnodeId();
        clearLevel();
        clearLength();
        clearDirec();
        clearAttr();
        clearGeo();
        clearParkingFloor();
        clearParkingTheme();
        this.cachedSize = -1;
        return this;
    }

    public LinkAttrt clearAttr() {
        this.hasAttr = false;
        this.attr_ = 0;
        return this;
    }

    public LinkAttrt clearDirec() {
        this.hasDirec = false;
        this.direc_ = 0;
        return this;
    }

    public LinkAttrt clearEnodeId() {
        this.hasEnodeId = false;
        this.enodeId_ = 0;
        return this;
    }

    public LinkAttrt clearGeo() {
        this.hasGeo = false;
        this.geo_ = ByteStringMicro.EMPTY;
        return this;
    }

    public LinkAttrt clearLength() {
        this.hasLength = false;
        this.length_ = 0;
        return this;
    }

    public LinkAttrt clearLevel() {
        this.hasLevel = false;
        this.level_ = 0;
        return this;
    }

    public LinkAttrt clearParkingFloor() {
        this.hasParkingFloor = false;
        this.parkingFloor_ = ByteStringMicro.EMPTY;
        return this;
    }

    public LinkAttrt clearParkingTheme() {
        this.hasParkingTheme = false;
        this.parkingTheme_ = 0;
        return this;
    }

    public LinkAttrt clearSnodeId() {
        this.hasSnodeId = false;
        this.snodeId_ = 0;
        return this;
    }

    public int getAttr() {
        return this.attr_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getDirec() {
        return this.direc_;
    }

    public int getEnodeId() {
        return this.enodeId_;
    }

    public ByteStringMicro getGeo() {
        return this.geo_;
    }

    public int getLength() {
        return this.length_;
    }

    public int getLevel() {
        return this.level_;
    }

    public ByteStringMicro getParkingFloor() {
        return this.parkingFloor_;
    }

    public int getParkingTheme() {
        return this.parkingTheme_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeUInt32Size = hasSnodeId() ? 0 + CodedOutputStreamMicro.computeUInt32Size(1, getSnodeId()) : 0;
        if (hasEnodeId()) {
            iComputeUInt32Size += CodedOutputStreamMicro.computeUInt32Size(2, getEnodeId());
        }
        if (hasLevel()) {
            iComputeUInt32Size += CodedOutputStreamMicro.computeUInt32Size(3, getLevel());
        }
        if (hasLength()) {
            iComputeUInt32Size += CodedOutputStreamMicro.computeUInt32Size(4, getLength());
        }
        if (hasDirec()) {
            iComputeUInt32Size += CodedOutputStreamMicro.computeUInt32Size(5, getDirec());
        }
        if (hasAttr()) {
            iComputeUInt32Size += CodedOutputStreamMicro.computeUInt32Size(6, getAttr());
        }
        if (hasGeo()) {
            iComputeUInt32Size += CodedOutputStreamMicro.computeBytesSize(7, getGeo());
        }
        if (hasParkingFloor()) {
            iComputeUInt32Size += CodedOutputStreamMicro.computeBytesSize(8, getParkingFloor());
        }
        if (hasParkingTheme()) {
            iComputeUInt32Size += CodedOutputStreamMicro.computeInt32Size(9, getParkingTheme());
        }
        this.cachedSize = iComputeUInt32Size;
        return iComputeUInt32Size;
    }

    public int getSnodeId() {
        return this.snodeId_;
    }

    public boolean hasAttr() {
        return this.hasAttr;
    }

    public boolean hasDirec() {
        return this.hasDirec;
    }

    public boolean hasEnodeId() {
        return this.hasEnodeId;
    }

    public boolean hasGeo() {
        return this.hasGeo;
    }

    public boolean hasLength() {
        return this.hasLength;
    }

    public boolean hasLevel() {
        return this.hasLevel;
    }

    public boolean hasParkingFloor() {
        return this.hasParkingFloor;
    }

    public boolean hasParkingTheme() {
        return this.hasParkingTheme;
    }

    public boolean hasSnodeId() {
        return this.hasSnodeId;
    }

    public final boolean isInitialized() {
        return this.hasSnodeId && this.hasEnodeId && this.hasLevel && this.hasLength && this.hasDirec && this.hasGeo;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public LinkAttrt mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                setSnodeId(codedInputStreamMicro.readUInt32());
            } else if (tag == 16) {
                setEnodeId(codedInputStreamMicro.readUInt32());
            } else if (tag == 24) {
                setLevel(codedInputStreamMicro.readUInt32());
            } else if (tag == 32) {
                setLength(codedInputStreamMicro.readUInt32());
            } else if (tag == 40) {
                setDirec(codedInputStreamMicro.readUInt32());
            } else if (tag == 48) {
                setAttr(codedInputStreamMicro.readUInt32());
            } else if (tag == 58) {
                setGeo(codedInputStreamMicro.readBytes());
            } else if (tag == 66) {
                setParkingFloor(codedInputStreamMicro.readBytes());
            } else if (tag == 72) {
                setParkingTheme(codedInputStreamMicro.readInt32());
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public LinkAttrt setAttr(int i) {
        this.hasAttr = true;
        this.attr_ = i;
        return this;
    }

    public LinkAttrt setDirec(int i) {
        this.hasDirec = true;
        this.direc_ = i;
        return this;
    }

    public LinkAttrt setEnodeId(int i) {
        this.hasEnodeId = true;
        this.enodeId_ = i;
        return this;
    }

    public LinkAttrt setGeo(ByteStringMicro byteStringMicro) {
        this.hasGeo = true;
        this.geo_ = byteStringMicro;
        return this;
    }

    public LinkAttrt setLength(int i) {
        this.hasLength = true;
        this.length_ = i;
        return this;
    }

    public LinkAttrt setLevel(int i) {
        this.hasLevel = true;
        this.level_ = i;
        return this;
    }

    public LinkAttrt setParkingFloor(ByteStringMicro byteStringMicro) {
        this.hasParkingFloor = true;
        this.parkingFloor_ = byteStringMicro;
        return this;
    }

    public LinkAttrt setParkingTheme(int i) {
        this.hasParkingTheme = true;
        this.parkingTheme_ = i;
        return this;
    }

    public LinkAttrt setSnodeId(int i) {
        this.hasSnodeId = true;
        this.snodeId_ = i;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasSnodeId()) {
            codedOutputStreamMicro.writeUInt32(1, getSnodeId());
        }
        if (hasEnodeId()) {
            codedOutputStreamMicro.writeUInt32(2, getEnodeId());
        }
        if (hasLevel()) {
            codedOutputStreamMicro.writeUInt32(3, getLevel());
        }
        if (hasLength()) {
            codedOutputStreamMicro.writeUInt32(4, getLength());
        }
        if (hasDirec()) {
            codedOutputStreamMicro.writeUInt32(5, getDirec());
        }
        if (hasAttr()) {
            codedOutputStreamMicro.writeUInt32(6, getAttr());
        }
        if (hasGeo()) {
            codedOutputStreamMicro.writeBytes(7, getGeo());
        }
        if (hasParkingFloor()) {
            codedOutputStreamMicro.writeBytes(8, getParkingFloor());
        }
        if (hasParkingTheme()) {
            codedOutputStreamMicro.writeInt32(9, getParkingTheme());
        }
    }
}
