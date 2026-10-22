package com.kc.aw.lib.doodle;

import com.kc.aw._az;
import com.kc.aw._bn;
import com.kc.aw._fu;
import com.kc.aw._o2;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _b {
    public static final _a _a;

    static {
        String str = _bn._a;
        _a = new _a(4096, 268435456L, "/doodle/source/");
    }

    public static File _a(InputStream inputStream, _az _azVar, boolean z) throws Throwable {
        File file;
        _a _aVar = _a;
        File file2 = new File(_aVar._c(_azVar));
        if (file2.exists()) {
            return file2;
        }
        try {
            file = new File(file2.getParent(), file2.getName() + ".tmp");
            try {
                if (_o2._a(inputStream, file)) {
                    if (!z) {
                        if (z) {
                            _o2._a(file);
                        }
                        return file;
                    }
                    if (file.renameTo(file2) || file2.exists()) {
                        _aVar._a(_azVar, file2, false);
                        if (z) {
                            _o2._a(file);
                        }
                        return file2;
                    }
                }
                throw new IOException("Download failed");
            } catch (Throwable th) {
                th = th;
                if (z) {
                    _o2._a(file);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            file = null;
        }
    }

    public static File _a(final String str) {
        final _az _azVar = new _az(str);
        FutureTask futureTask = new FutureTask(new Callable(str, _azVar) { // from class: com.kc.aw.lib.doodle._b$$ExternalSyntheticLambda0
            public final String f$0;
            public final _az f$1;

            {
                this.f$0 = str;
                this.f$1 = _azVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return _b._a(this.f$0, this.f$1);
            }
        });
        _d._b _bVar = _d._c;
        synchronized (_bVar) {
            _e _eVar = new _e(_bVar, futureTask, true, _azVar);
            HashSet hashSet = _d._b._a;
            if (hashSet.contains(_azVar)) {
                HashMap map = _d._b._b;
                LinkedList linkedList = (LinkedList) map.get(_azVar);
                if (linkedList == null) {
                    linkedList = new LinkedList();
                    map.put(_azVar, linkedList);
                }
                linkedList.offer(_eVar);
            } else {
                hashSet.add(_azVar);
                _d._b.execute(_eVar);
            }
        }
        try {
            return (File) futureTask.get();
        } catch (Throwable th) {
            _fu._a("Doodle", th);
            return null;
        }
    }

    public static File _a(String str, _az _azVar) {
        String str2 = _bn._a;
        return _a(_a(1, str), _azVar, true);
    }

    public static InputStream _a(int i, String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return httpURLConnection.getInputStream();
        }
        if (responseCode < 300 || responseCode >= 400) {
            throw new IOException("Request failed, status code:" + responseCode);
        }
        if (i > 5) {
            httpURLConnection.disconnect();
            throw new IOException("Redirect too much");
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        if (headerField == null || headerField.isEmpty()) {
            throw new IOException("Empty redirect url");
        }
        if (str.equals(headerField)) {
            throw new IOException("Redirect loop");
        }
        return _a(i + 1, headerField);
    }
}
