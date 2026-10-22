package cj.mobile.wm.okhttp.model;

import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.utils.HttpUtils;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HttpParams implements Serializable {
    public static final boolean IS_REPLACE = true;
    public static final long serialVersionUID = 7369819159227055048L;
    public LinkedHashMap<String, List<FileWrapper>> fileParamsMap;
    public LinkedHashMap<String, List<String>> urlParamsMap;
    public static final MediaType MEDIA_TYPE_PLAIN = MediaType.parse(dexc.dexa("ufyu0qmbjo<dibstfu>vug.9"));
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse(dexc.dexa("bqqmjdbujpo0ktpo<dibstfu>vug.9"));
    public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse(dexc.dexa("bqqmjdbujpo0pdufu.tusfbn"));

    public static class FileWrapper implements Serializable {
        public static final long serialVersionUID = -2356139899636767776L;
        public transient MediaType contentType;
        public File file;
        public String fileName;
        public long fileSize;

        public FileWrapper(File file, String str, MediaType mediaType) {
            this.file = file;
            this.fileName = str;
            this.contentType = mediaType;
            this.fileSize = file.length();
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.contentType = MediaType.parse((String) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.contentType.toString());
        }

        public String toString() {
            return dexc.dexa("GjmfXsbqqfs|gjmf>") + this.file + dexc.dexa("-!gjmfObnf>") + this.fileName + dexc.dexa("-!dpoufouUzqf>") + this.contentType + dexc.dexa("-!gjmfTj{f>") + this.fileSize + dexc.dexa("~");
        }
    }

    public HttpParams() {
        init();
    }

    public HttpParams(String str, File file) {
        init();
        put(str, file);
    }

    public HttpParams(String str, String str2) {
        init();
        put(str, str2, true);
    }

    private void init() {
        this.urlParamsMap = new LinkedHashMap<>();
        this.fileParamsMap = new LinkedHashMap<>();
    }

    private void put(String str, String str2, boolean z) {
        if (str == null || str2 == null) {
            return;
        }
        List<String> arrayList = this.urlParamsMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.urlParamsMap.put(str, arrayList);
        }
        if (z) {
            arrayList.clear();
        }
        arrayList.add(str2);
    }

    public void clear() {
        this.urlParamsMap.clear();
        this.fileParamsMap.clear();
    }

    public void put(HttpParams httpParams) {
        if (httpParams != null) {
            LinkedHashMap<String, List<String>> linkedHashMap = httpParams.urlParamsMap;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                this.urlParamsMap.putAll(httpParams.urlParamsMap);
            }
            LinkedHashMap<String, List<FileWrapper>> linkedHashMap2 = httpParams.fileParamsMap;
            if (linkedHashMap2 == null || linkedHashMap2.isEmpty()) {
                return;
            }
            this.fileParamsMap.putAll(httpParams.fileParamsMap);
        }
    }

    public void put(String str, char c, boolean... zArr) {
        String strValueOf;
        boolean z;
        if (zArr == null || zArr.length <= 0) {
            strValueOf = String.valueOf(c);
            z = true;
        } else {
            strValueOf = String.valueOf(c);
            z = zArr[0];
        }
        put(str, strValueOf, z);
    }

    public void put(String str, double d, boolean... zArr) {
        String strValueOf;
        boolean z;
        if (zArr == null || zArr.length <= 0) {
            strValueOf = String.valueOf(d);
            z = true;
        } else {
            strValueOf = String.valueOf(d);
            z = zArr[0];
        }
        put(str, strValueOf, z);
    }

    public void put(String str, float f, boolean... zArr) {
        String strValueOf;
        boolean z;
        if (zArr == null || zArr.length <= 0) {
            strValueOf = String.valueOf(f);
            z = true;
        } else {
            strValueOf = String.valueOf(f);
            z = zArr[0];
        }
        put(str, strValueOf, z);
    }

    public void put(String str, int i, boolean... zArr) {
        String strValueOf;
        boolean z;
        if (zArr == null || zArr.length <= 0) {
            strValueOf = String.valueOf(i);
            z = true;
        } else {
            strValueOf = String.valueOf(i);
            z = zArr[0];
        }
        put(str, strValueOf, z);
    }

    public void put(String str, long j, boolean... zArr) {
        String strValueOf;
        boolean z;
        if (zArr == null || zArr.length <= 0) {
            strValueOf = String.valueOf(j);
            z = true;
        } else {
            strValueOf = String.valueOf(j);
            z = zArr[0];
        }
        put(str, strValueOf, z);
    }

    public void put(String str, FileWrapper fileWrapper) {
        if (str == null || fileWrapper == null) {
            return;
        }
        put(str, fileWrapper.file, fileWrapper.fileName, fileWrapper.contentType);
    }

    public void put(String str, File file) {
        put(str, file, file.getName());
    }

    public void put(String str, File file, String str2) {
        put(str, file, str2, HttpUtils.guessMimeType(str2));
    }

    public void put(String str, File file, String str2, MediaType mediaType) {
        if (str != null) {
            List<FileWrapper> arrayList = this.fileParamsMap.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.fileParamsMap.put(str, arrayList);
            }
            arrayList.add(new FileWrapper(file, str2, mediaType));
        }
    }

    public void put(String str, String str2, boolean... zArr) {
        put(str, str2, (zArr == null || zArr.length <= 0) ? true : zArr[0]);
    }

    public void put(String str, boolean z, boolean... zArr) {
        String strValueOf;
        boolean z2;
        if (zArr == null || zArr.length <= 0) {
            strValueOf = String.valueOf(z);
            z2 = true;
        } else {
            strValueOf = String.valueOf(z);
            z2 = zArr[0];
        }
        put(str, strValueOf, z2);
    }

    public void put(Map<String, String> map, boolean... zArr) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue(), zArr);
        }
    }

    public void putFileParams(String str, List<File> list) {
        if (str == null || list == null || list.isEmpty()) {
            return;
        }
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            put(str, it.next());
        }
    }

    public void putFileWrapperParams(String str, List<FileWrapper> list) {
        if (str == null || list == null || list.isEmpty()) {
            return;
        }
        Iterator<FileWrapper> it = list.iterator();
        while (it.hasNext()) {
            put(str, it.next());
        }
    }

    public void putUrlParams(String str, List<String> list) {
        if (str == null || list == null || list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            put(str, it.next(), false);
        }
    }

    public void remove(String str) {
        removeUrl(str);
        removeFile(str);
    }

    public void removeFile(String str) {
        this.fileParamsMap.remove(str);
    }

    public void removeUrl(String str) {
        this.urlParamsMap.remove(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : this.urlParamsMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append(dexc.dexa("'"));
            }
            sb.append(entry.getKey());
            sb.append(dexc.dexa(">"));
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, List<FileWrapper>> entry2 : this.fileParamsMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append(dexc.dexa("'"));
            }
            sb.append(entry2.getKey());
            sb.append(dexc.dexa(">"));
            sb.append(entry2.getValue());
        }
        return sb.toString();
    }
}
