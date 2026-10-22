package com.baidu.location.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class NaviContent extends MessageMicro {
    public static final int CTL_FIELD_NUMBER = 4;
    public static final int ETA_FIELD_NUMBER = 5;
    public static final int INFO_FIELD_NUMBER = 3;
    public static final int OUTTYPE_FIELD_NUMBER = 2;
    public static final int OUT_FIELD_NUMBER = 1;
    public static final int VUI_FIELD_NUMBER = 6;
    private int cachedSize;
    private ByteStringMicro ctl_;
    private ByteStringMicro eta_;
    private boolean hasCtl;
    private boolean hasEta;
    private boolean hasInfo;
    private boolean hasOut;
    private boolean hasOuttype;
    private boolean hasVui;
    private ByteStringMicro info_;
    private ByteStringMicro out_;
    private String outtype_;
    private ByteStringMicro vui_;

    public NaviContent() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.out_ = byteStringMicro;
        this.outtype_ = "";
        this.info_ = byteStringMicro;
        this.ctl_ = byteStringMicro;
        this.eta_ = byteStringMicro;
        this.vui_ = byteStringMicro;
        this.cachedSize = -1;
    }

    public static NaviContent parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new NaviContent().mergeFrom(codedInputStreamMicro);
    }

    public static NaviContent parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (NaviContent) new NaviContent().mergeFrom(bArr);
    }

    public final NaviContent clear() {
        clearOut();
        clearOuttype();
        clearInfo();
        clearCtl();
        clearEta();
        clearVui();
        this.cachedSize = -1;
        return this;
    }

    public NaviContent clearCtl() {
        this.hasCtl = false;
        this.ctl_ = ByteStringMicro.EMPTY;
        return this;
    }

    public NaviContent clearEta() {
        this.hasEta = false;
        this.eta_ = ByteStringMicro.EMPTY;
        return this;
    }

    public NaviContent clearInfo() {
        this.hasInfo = false;
        this.info_ = ByteStringMicro.EMPTY;
        return this;
    }

    public NaviContent clearOut() {
        this.hasOut = false;
        this.out_ = ByteStringMicro.EMPTY;
        return this;
    }

    public NaviContent clearOuttype() {
        this.hasOuttype = false;
        this.outtype_ = "";
        return this;
    }

    public NaviContent clearVui() {
        this.hasVui = false;
        this.vui_ = ByteStringMicro.EMPTY;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public ByteStringMicro getCtl() {
        return this.ctl_;
    }

    public ByteStringMicro getEta() {
        return this.eta_;
    }

    public ByteStringMicro getInfo() {
        return this.info_;
    }

    public ByteStringMicro getOut() {
        return this.out_;
    }

    public String getOuttype() {
        return this.outtype_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeBytesSize = hasOut() ? 0 + CodedOutputStreamMicro.computeBytesSize(1, getOut()) : 0;
        if (hasOuttype()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeStringSize(2, getOuttype());
        }
        if (hasInfo()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(3, getInfo());
        }
        if (hasCtl()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(4, getCtl());
        }
        if (hasEta()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(5, getEta());
        }
        if (hasVui()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(6, getVui());
        }
        this.cachedSize = iComputeBytesSize;
        return iComputeBytesSize;
    }

    public ByteStringMicro getVui() {
        return this.vui_;
    }

    public boolean hasCtl() {
        return this.hasCtl;
    }

    public boolean hasEta() {
        return this.hasEta;
    }

    public boolean hasInfo() {
        return this.hasInfo;
    }

    public boolean hasOut() {
        return this.hasOut;
    }

    public boolean hasOuttype() {
        return this.hasOuttype;
    }

    public boolean hasVui() {
        return this.hasVui;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public NaviContent mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                setOut(codedInputStreamMicro.readBytes());
            } else if (tag == 18) {
                setOuttype(codedInputStreamMicro.readString());
            } else if (tag == 26) {
                setInfo(codedInputStreamMicro.readBytes());
            } else if (tag == 34) {
                setCtl(codedInputStreamMicro.readBytes());
            } else if (tag == 42) {
                setEta(codedInputStreamMicro.readBytes());
            } else if (tag == 50) {
                setVui(codedInputStreamMicro.readBytes());
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public NaviContent setCtl(ByteStringMicro byteStringMicro) {
        this.hasCtl = true;
        this.ctl_ = byteStringMicro;
        return this;
    }

    public NaviContent setEta(ByteStringMicro byteStringMicro) {
        this.hasEta = true;
        this.eta_ = byteStringMicro;
        return this;
    }

    public NaviContent setInfo(ByteStringMicro byteStringMicro) {
        this.hasInfo = true;
        this.info_ = byteStringMicro;
        return this;
    }

    public NaviContent setOut(ByteStringMicro byteStringMicro) {
        this.hasOut = true;
        this.out_ = byteStringMicro;
        return this;
    }

    public NaviContent setOuttype(String str) {
        this.hasOuttype = true;
        this.outtype_ = str;
        return this;
    }

    public NaviContent setVui(ByteStringMicro byteStringMicro) {
        this.hasVui = true;
        this.vui_ = byteStringMicro;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasOut()) {
            codedOutputStreamMicro.writeBytes(1, getOut());
        }
        if (hasOuttype()) {
            codedOutputStreamMicro.writeString(2, getOuttype());
        }
        if (hasInfo()) {
            codedOutputStreamMicro.writeBytes(3, getInfo());
        }
        if (hasCtl()) {
            codedOutputStreamMicro.writeBytes(4, getCtl());
        }
        if (hasEta()) {
            codedOutputStreamMicro.writeBytes(5, getEta());
        }
        if (hasVui()) {
            codedOutputStreamMicro.writeBytes(6, getVui());
        }
    }
}
