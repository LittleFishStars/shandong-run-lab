package com.baidu.entity.pb;

import com.google.protobuf.micro.ByteStringMicro;
import com.google.protobuf.micro.CodedInputStreamMicro;
import com.google.protobuf.micro.CodedOutputStreamMicro;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class TransJavirsActionInfo extends MessageMicro {
    public static final int JAVIRS_ACTION_ID_FIELD_NUMBER = 4;
    public static final int JAVIRS_ACTION_MODE_FIELD_NUMBER = 2;
    public static final int JAVIRS_CAN_DISPLAY_FIELD_NUMBER = 8;
    public static final int JAVIRS_CAN_INTERRUPT_FIELD_NUMBER = 7;
    public static final int JAVIRS_SCENE_FIELD_NUMBER = 6;
    public static final int JAVIRS_TEXT_FIELD_NUMBER = 1;
    public static final int JAVIRS_VOICE_TYPE_FIELD_NUMBER = 3;
    public static final int VOICE_TEXT_ALL_FIELD_NUMBER = 5;
    private int cachedSize;
    private boolean hasJavirsActionId;
    private boolean hasJavirsActionMode;
    private boolean hasJavirsCanDisplay;
    private boolean hasJavirsCanInterrupt;
    private boolean hasJavirsScene;
    private boolean hasJavirsText;
    private boolean hasJavirsVoiceType;
    private boolean hasVoiceTextAll;
    private int javirsActionId_;
    private ByteStringMicro javirsActionMode_;
    private boolean javirsCanDisplay_;
    private boolean javirsCanInterrupt_;
    private ByteStringMicro javirsScene_;
    private ByteStringMicro javirsText_;
    private int javirsVoiceType_;
    private ByteStringMicro voiceTextAll_;

    public TransJavirsActionInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.javirsText_ = byteStringMicro;
        this.javirsActionMode_ = byteStringMicro;
        this.javirsVoiceType_ = 0;
        this.javirsActionId_ = 0;
        this.voiceTextAll_ = byteStringMicro;
        this.javirsScene_ = byteStringMicro;
        this.javirsCanInterrupt_ = false;
        this.javirsCanDisplay_ = false;
        this.cachedSize = -1;
    }

    public static TransJavirsActionInfo parseFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        return new TransJavirsActionInfo().mergeFrom(codedInputStreamMicro);
    }

    public static TransJavirsActionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferMicroException {
        return (TransJavirsActionInfo) new TransJavirsActionInfo().mergeFrom(bArr);
    }

    public final TransJavirsActionInfo clear() {
        clearJavirsText();
        clearJavirsActionMode();
        clearJavirsVoiceType();
        clearJavirsActionId();
        clearVoiceTextAll();
        clearJavirsScene();
        clearJavirsCanInterrupt();
        clearJavirsCanDisplay();
        this.cachedSize = -1;
        return this;
    }

    public TransJavirsActionInfo clearJavirsActionId() {
        this.hasJavirsActionId = false;
        this.javirsActionId_ = 0;
        return this;
    }

    public TransJavirsActionInfo clearJavirsActionMode() {
        this.hasJavirsActionMode = false;
        this.javirsActionMode_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransJavirsActionInfo clearJavirsCanDisplay() {
        this.hasJavirsCanDisplay = false;
        this.javirsCanDisplay_ = false;
        return this;
    }

    public TransJavirsActionInfo clearJavirsCanInterrupt() {
        this.hasJavirsCanInterrupt = false;
        this.javirsCanInterrupt_ = false;
        return this;
    }

    public TransJavirsActionInfo clearJavirsScene() {
        this.hasJavirsScene = false;
        this.javirsScene_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransJavirsActionInfo clearJavirsText() {
        this.hasJavirsText = false;
        this.javirsText_ = ByteStringMicro.EMPTY;
        return this;
    }

    public TransJavirsActionInfo clearJavirsVoiceType() {
        this.hasJavirsVoiceType = false;
        this.javirsVoiceType_ = 0;
        return this;
    }

    public TransJavirsActionInfo clearVoiceTextAll() {
        this.hasVoiceTextAll = false;
        this.voiceTextAll_ = ByteStringMicro.EMPTY;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getJavirsActionId() {
        return this.javirsActionId_;
    }

    public ByteStringMicro getJavirsActionMode() {
        return this.javirsActionMode_;
    }

    public boolean getJavirsCanDisplay() {
        return this.javirsCanDisplay_;
    }

    public boolean getJavirsCanInterrupt() {
        return this.javirsCanInterrupt_;
    }

    public ByteStringMicro getJavirsScene() {
        return this.javirsScene_;
    }

    public ByteStringMicro getJavirsText() {
        return this.javirsText_;
    }

    public int getJavirsVoiceType() {
        return this.javirsVoiceType_;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public int getSerializedSize() {
        int iComputeBytesSize = hasJavirsText() ? 0 + CodedOutputStreamMicro.computeBytesSize(1, getJavirsText()) : 0;
        if (hasJavirsActionMode()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(2, getJavirsActionMode());
        }
        if (hasJavirsVoiceType()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(3, getJavirsVoiceType());
        }
        if (hasJavirsActionId()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeInt32Size(4, getJavirsActionId());
        }
        if (hasVoiceTextAll()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(5, getVoiceTextAll());
        }
        if (hasJavirsScene()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBytesSize(6, getJavirsScene());
        }
        if (hasJavirsCanInterrupt()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBoolSize(7, getJavirsCanInterrupt());
        }
        if (hasJavirsCanDisplay()) {
            iComputeBytesSize += CodedOutputStreamMicro.computeBoolSize(8, getJavirsCanDisplay());
        }
        this.cachedSize = iComputeBytesSize;
        return iComputeBytesSize;
    }

    public ByteStringMicro getVoiceTextAll() {
        return this.voiceTextAll_;
    }

    public boolean hasJavirsActionId() {
        return this.hasJavirsActionId;
    }

    public boolean hasJavirsActionMode() {
        return this.hasJavirsActionMode;
    }

    public boolean hasJavirsCanDisplay() {
        return this.hasJavirsCanDisplay;
    }

    public boolean hasJavirsCanInterrupt() {
        return this.hasJavirsCanInterrupt;
    }

    public boolean hasJavirsScene() {
        return this.hasJavirsScene;
    }

    public boolean hasJavirsText() {
        return this.hasJavirsText;
    }

    public boolean hasJavirsVoiceType() {
        return this.hasJavirsVoiceType;
    }

    public boolean hasVoiceTextAll() {
        return this.hasVoiceTextAll;
    }

    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public TransJavirsActionInfo mergeFrom(CodedInputStreamMicro codedInputStreamMicro) throws IOException {
        while (true) {
            int tag = codedInputStreamMicro.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                setJavirsText(codedInputStreamMicro.readBytes());
            } else if (tag == 18) {
                setJavirsActionMode(codedInputStreamMicro.readBytes());
            } else if (tag == 24) {
                setJavirsVoiceType(codedInputStreamMicro.readInt32());
            } else if (tag == 32) {
                setJavirsActionId(codedInputStreamMicro.readInt32());
            } else if (tag == 42) {
                setVoiceTextAll(codedInputStreamMicro.readBytes());
            } else if (tag == 50) {
                setJavirsScene(codedInputStreamMicro.readBytes());
            } else if (tag == 56) {
                setJavirsCanInterrupt(codedInputStreamMicro.readBool());
            } else if (tag == 64) {
                setJavirsCanDisplay(codedInputStreamMicro.readBool());
            } else if (!parseUnknownField(codedInputStreamMicro, tag)) {
                return this;
            }
        }
    }

    public TransJavirsActionInfo setJavirsActionId(int i) {
        this.hasJavirsActionId = true;
        this.javirsActionId_ = i;
        return this;
    }

    public TransJavirsActionInfo setJavirsActionMode(ByteStringMicro byteStringMicro) {
        this.hasJavirsActionMode = true;
        this.javirsActionMode_ = byteStringMicro;
        return this;
    }

    public TransJavirsActionInfo setJavirsCanDisplay(boolean z) {
        this.hasJavirsCanDisplay = true;
        this.javirsCanDisplay_ = z;
        return this;
    }

    public TransJavirsActionInfo setJavirsCanInterrupt(boolean z) {
        this.hasJavirsCanInterrupt = true;
        this.javirsCanInterrupt_ = z;
        return this;
    }

    public TransJavirsActionInfo setJavirsScene(ByteStringMicro byteStringMicro) {
        this.hasJavirsScene = true;
        this.javirsScene_ = byteStringMicro;
        return this;
    }

    public TransJavirsActionInfo setJavirsText(ByteStringMicro byteStringMicro) {
        this.hasJavirsText = true;
        this.javirsText_ = byteStringMicro;
        return this;
    }

    public TransJavirsActionInfo setJavirsVoiceType(int i) {
        this.hasJavirsVoiceType = true;
        this.javirsVoiceType_ = i;
        return this;
    }

    public TransJavirsActionInfo setVoiceTextAll(ByteStringMicro byteStringMicro) {
        this.hasVoiceTextAll = true;
        this.voiceTextAll_ = byteStringMicro;
        return this;
    }

    @Override // com.google.protobuf.micro.MessageMicro
    public void writeTo(CodedOutputStreamMicro codedOutputStreamMicro) throws IOException {
        if (hasJavirsText()) {
            codedOutputStreamMicro.writeBytes(1, getJavirsText());
        }
        if (hasJavirsActionMode()) {
            codedOutputStreamMicro.writeBytes(2, getJavirsActionMode());
        }
        if (hasJavirsVoiceType()) {
            codedOutputStreamMicro.writeInt32(3, getJavirsVoiceType());
        }
        if (hasJavirsActionId()) {
            codedOutputStreamMicro.writeInt32(4, getJavirsActionId());
        }
        if (hasVoiceTextAll()) {
            codedOutputStreamMicro.writeBytes(5, getVoiceTextAll());
        }
        if (hasJavirsScene()) {
            codedOutputStreamMicro.writeBytes(6, getJavirsScene());
        }
        if (hasJavirsCanInterrupt()) {
            codedOutputStreamMicro.writeBool(7, getJavirsCanInterrupt());
        }
        if (hasJavirsCanDisplay()) {
            codedOutputStreamMicro.writeBool(8, getJavirsCanDisplay());
        }
    }
}
