package com.czhj.wire;

import com.czhj.wire.okio.Buffer;
import com.czhj.wire.okio.BufferedSource;
import com.czhj.wire.okio.ByteString;
import com.google.common.base.a;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ProtoReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f29512a = 3;
    private static final int b = 65;
    private static final int c = 7;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 4;
    private static final int i = 5;
    private static final int j = 6;
    private static final int k = 7;
    private final BufferedSource l;
    private int o;
    private FieldEncoding s;
    private long m = 0;
    private long n = Long.MAX_VALUE;
    private int p = 2;
    private int q = -1;
    private long r = -1;

    public ProtoReader(BufferedSource bufferedSource) {
        this.l = bufferedSource;
    }

    private int a() throws IOException {
        int i2;
        this.l.require(1L);
        this.m++;
        byte b2 = this.l.readByte();
        if (b2 >= 0) {
            return b2;
        }
        int i3 = b2 & 127;
        this.l.require(1L);
        this.m++;
        byte b3 = this.l.readByte();
        if (b3 >= 0) {
            i2 = b3 << 7;
        } else {
            i3 |= (b3 & 127) << 7;
            this.l.require(1L);
            this.m++;
            byte b4 = this.l.readByte();
            if (b4 >= 0) {
                i2 = b4 << a.p;
            } else {
                i3 |= (b4 & 127) << 14;
                this.l.require(1L);
                this.m++;
                byte b5 = this.l.readByte();
                if (b5 < 0) {
                    int i4 = i3 | ((b5 & 127) << 21);
                    this.l.require(1L);
                    this.m++;
                    byte b6 = this.l.readByte();
                    int i5 = i4 | (b6 << a.F);
                    if (b6 >= 0) {
                        return i5;
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        this.l.require(1L);
                        this.m++;
                        if (this.l.readByte() >= 0) {
                            return i5;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                i2 = b5 << a.y;
            }
        }
        return i3 | i2;
    }

    private void a(int i2) throws IOException {
        while (this.m < this.n && !this.l.exhausted()) {
            int iA = a();
            if (iA == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i3 = iA >> 3;
            int i4 = iA & 7;
            if (i4 == 0) {
                this.p = 0;
                readVarint64();
            } else if (i4 == 1) {
                this.p = 1;
                readFixed64();
            } else if (i4 == 2) {
                long jA = a();
                this.m += jA;
                this.l.skip(jA);
            } else if (i4 == 3) {
                a(i3);
            } else if (i4 == 4) {
                if (i3 != i2) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else {
                if (i4 != 5) {
                    throw new ProtocolException("Unexpected field encoding: " + i4);
                }
                this.p = 5;
                readFixed32();
            }
        }
        throw new EOFException();
    }

    private void a(ProtoWriter protoWriter, int i2) throws IOException {
        ProtoAdapter<?> protoAdapterRawProtoAdapter = peekFieldEncoding().rawProtoAdapter();
        try {
            protoAdapterRawProtoAdapter.encodeWithTag(protoWriter, i2, protoAdapterRawProtoAdapter.decode(this));
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    private long b() throws IOException {
        if (this.p != 2) {
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.p);
        }
        long j2 = this.n - this.m;
        this.l.require(j2);
        this.p = 6;
        this.m = this.n;
        this.n = this.r;
        this.r = -1L;
        return j2;
    }

    private void b(int i2) throws IOException {
        if (this.p != i2) {
            long j2 = this.m;
            long j3 = this.n;
            if (j2 > j3) {
                throw new IOException("Expected to end at " + this.n + " but was " + this.m);
            }
            if (j2 != j3) {
                this.p = 7;
                return;
            } else {
                this.n = this.r;
                this.r = -1L;
            }
        }
        this.p = 6;
    }

    public long beginMessage() throws IOException {
        if (this.p != 2) {
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        int i2 = this.o + 1;
        this.o = i2;
        if (i2 > 65) {
            throw new IOException("Wire recursion limit exceeded");
        }
        long j2 = this.r;
        this.r = -1L;
        this.p = 6;
        return j2;
    }

    public void endMessage(long j2) throws IOException {
        if (this.p != 6) {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
        int i2 = this.o - 1;
        this.o = i2;
        if (i2 < 0 || this.r != -1) {
            throw new IllegalStateException("No corresponding call to beginMessage()");
        }
        if (this.m == this.n || i2 == 0) {
            this.n = j2;
            return;
        }
        throw new IOException("Expected to end at " + this.n + " but was " + this.m);
    }

    public ByteString forEachTag(TagHandler tagHandler) throws IOException {
        long jBeginMessage = beginMessage();
        Buffer buffer = null;
        ProtoWriter protoWriter = null;
        while (true) {
            int iNextTag = nextTag();
            if (iNextTag == -1) {
                break;
            }
            if (tagHandler.decodeMessage(iNextTag) == TagHandler.UNKNOWN_TAG) {
                if (buffer == null) {
                    buffer = new Buffer();
                    protoWriter = new ProtoWriter(buffer);
                }
                a(protoWriter, iNextTag);
            }
        }
        endMessage(jBeginMessage);
        return buffer != null ? buffer.readByteString() : ByteString.EMPTY;
    }

    public int nextTag() throws IOException {
        int i2 = this.p;
        if (i2 == 7) {
            this.p = 2;
            return this.q;
        }
        if (i2 != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.m < this.n && !this.l.exhausted()) {
            int iA = a();
            if (iA == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i3 = iA >> 3;
            this.q = i3;
            int i4 = iA & 7;
            if (i4 == 0) {
                this.s = FieldEncoding.VARINT;
                this.p = 0;
                return i3;
            }
            if (i4 == 1) {
                this.s = FieldEncoding.FIXED64;
                this.p = 1;
                return i3;
            }
            if (i4 == 2) {
                this.s = FieldEncoding.LENGTH_DELIMITED;
                this.p = 2;
                int iA2 = a();
                if (iA2 < 0) {
                    throw new ProtocolException("Negative length: " + iA2);
                }
                if (this.r != -1) {
                    throw new IllegalStateException();
                }
                long j2 = this.n;
                this.r = j2;
                long j3 = this.m + ((long) iA2);
                this.n = j3;
                if (j3 <= j2) {
                    return this.q;
                }
                throw new EOFException();
            }
            if (i4 != 3) {
                if (i4 == 4) {
                    throw new ProtocolException("Unexpected end group");
                }
                if (i4 == 5) {
                    this.s = FieldEncoding.FIXED32;
                    this.p = 5;
                    return i3;
                }
                throw new ProtocolException("Unexpected field encoding: " + i4);
            }
            a(i3);
        }
        return -1;
    }

    public FieldEncoding peekFieldEncoding() {
        return this.s;
    }

    public ByteString readBytes() throws IOException {
        long jB = b();
        this.l.require(jB);
        return this.l.readByteString(jB);
    }

    public int readFixed32() throws IOException {
        int i2 = this.p;
        if (i2 != 5 && i2 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.p);
        }
        this.l.require(4L);
        this.m += 4;
        int intLe = this.l.readIntLe();
        b(5);
        return intLe;
    }

    public long readFixed64() throws IOException {
        int i2 = this.p;
        if (i2 != 1 && i2 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.p);
        }
        this.l.require(8L);
        this.m += 8;
        long longLe = this.l.readLongLe();
        b(1);
        return longLe;
    }

    public String readString() throws IOException {
        long jB = b();
        this.l.require(jB);
        return this.l.readUtf8(jB);
    }

    public int readVarint32() throws IOException {
        int i2 = this.p;
        if (i2 == 0 || i2 == 2) {
            int iA = a();
            b(0);
            return iA;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.p);
    }

    public long readVarint64() throws IOException {
        int i2 = this.p;
        if (i2 != 0 && i2 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.p);
        }
        long j2 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            this.l.require(1L);
            this.m++;
            byte b2 = this.l.readByte();
            j2 |= ((long) (b2 & 127)) << i3;
            if ((b2 & UnsignedBytes.f32243a) == 0) {
                b(0);
                return j2;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public void skip() throws IOException {
        int i2 = this.p;
        if (i2 == 0) {
            readVarint64();
            return;
        }
        if (i2 == 1) {
            readFixed64();
            return;
        }
        if (i2 == 2) {
            this.l.skip(b());
        } else {
            if (i2 != 5) {
                throw new IllegalStateException("Unexpected call to skip()");
            }
            readFixed32();
        }
    }
}
