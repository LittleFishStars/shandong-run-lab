package com.getui.gtc.base.http;

import com.getui.gtc.base.util.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class ResponseBody implements Closeable {
    public static ResponseBody create(final MediaType mediaType, final long j, final InputStream inputStream) {
        if (inputStream != null) {
            return new ResponseBody() { // from class: com.getui.gtc.base.http.ResponseBody.1
                @Override // com.getui.gtc.base.http.ResponseBody
                public final InputStream byteStream() {
                    return inputStream;
                }

                @Override // com.getui.gtc.base.http.ResponseBody
                public final long contentLength() {
                    return j;
                }

                @Override // com.getui.gtc.base.http.ResponseBody
                public final MediaType contentType() {
                    return mediaType;
                }
            };
        }
        throw new NullPointerException("byte stream is null");
    }

    public static ResponseBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static ResponseBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr.length, new ByteArrayInputStream(bArr));
    }

    public abstract InputStream byteStream();

    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(jContentLength)));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStreamByteStream = byteStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int i = inputStreamByteStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (Throwable th) {
                Util.closeQuietly(inputStreamByteStream);
                throw th;
            }
        }
        Util.closeQuietly(inputStreamByteStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (jContentLength == -1 || jContentLength == byteArray.length) {
            return byteArray;
        }
        throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + byteArray.length + ") disagree");
    }

    public final Reader charStream() {
        return new InputStreamReader(byteStream(), charset());
    }

    public Charset charset() {
        MediaType mediaTypeContentType = contentType();
        return mediaTypeContentType != null ? mediaTypeContentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(byteStream());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public final void file(File file) throws Throwable {
        IOUtils.saveToFile(byteStream(), file);
    }

    public final String string() throws IOException {
        return new String(bytes(), charset());
    }
}
