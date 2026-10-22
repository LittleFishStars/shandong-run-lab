package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import com.google.common.base.a;
import com.google.common.base.b;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r54 extends SimpleMetadataDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44376a = "streamtitle";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f19237a = Pattern.compile("(.+?)='(.*?)';", 32);
    public static final String b = "streamurl";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharsetDecoder f19238a = b.c.newDecoder();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final CharsetDecoder f19239b = b.b.newDecoder();

    @Nullable
    public final String b(ByteBuffer byteBuffer) {
        try {
            String string = this.f19238a.decode(byteBuffer).toString();
            this.f19238a.reset();
            byteBuffer.rewind();
            return string;
        } catch (CharacterCodingException unused) {
            this.f19238a.reset();
            byteBuffer.rewind();
            try {
                return this.f19239b.decode(byteBuffer).toString();
            } catch (CharacterCodingException unused2) {
                return null;
            } finally {
                this.f19239b.reset();
                byteBuffer.rewind();
            }
        } catch (Throwable th) {
            this.f19238a.reset();
            byteBuffer.rewind();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.metadata.SimpleMetadataDecoder
    public Metadata decode(xn5 xn5Var, ByteBuffer byteBuffer) {
        String strB = b(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strB == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = f19237a.matcher(strB);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String strG = a.g(strGroup);
                strG.hashCode();
                if (strG.equals(b)) {
                    str2 = strGroup2;
                } else if (strG.equals(f44376a)) {
                    str = strGroup2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}
