package com.czhj.wire.okio;

import com.aliyun.openapiutil.Client;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class HashingSink extends ForwardingSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MessageDigest f29533a;
    private final Mac b;

    private HashingSink(Sink sink, ByteString byteString, String str) {
        super(sink);
        try {
            Mac mac = Mac.getInstance(str);
            this.b = mac;
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.f29533a = null;
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private HashingSink(Sink sink, String str) {
        super(sink);
        try {
            this.f29533a = MessageDigest.getInstance(str);
            this.b = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA1");
    }

    public static HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA256");
    }

    public static HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA512");
    }

    public static HashingSink md5(Sink sink) {
        return new HashingSink(sink, "MD5");
    }

    public static HashingSink sha1(Sink sink) {
        return new HashingSink(sink, "SHA-1");
    }

    public static HashingSink sha256(Sink sink) {
        return new HashingSink(sink, Client.HASH_SHA256);
    }

    public static HashingSink sha512(Sink sink) {
        return new HashingSink(sink, "SHA-512");
    }

    public final ByteString hash() {
        MessageDigest messageDigest = this.f29533a;
        return ByteString.of(messageDigest != null ? messageDigest.digest() : this.b.doFinal());
    }

    @Override // com.czhj.wire.okio.ForwardingSink, com.czhj.wire.okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        Util.checkOffsetAndCount(buffer.c, 0L, j);
        Segment segment = buffer.b;
        long j2 = 0;
        while (j2 < j) {
            int iMin = (int) Math.min(j - j2, segment.e - segment.d);
            MessageDigest messageDigest = this.f29533a;
            if (messageDigest != null) {
                messageDigest.update(segment.c, segment.d, iMin);
            } else {
                this.b.update(segment.c, segment.d, iMin);
            }
            j2 += (long) iMin;
            segment = segment.h;
        }
        super.write(buffer, j);
    }
}
