package com.aliyun.vod.qupaiokhttp;

import android.text.TextUtils;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.aliyun.vod.common.utils.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RequestParams {
    private boolean applicationJson;
    protected CacheControl cacheControl;
    private final List<Part> files;
    protected final Headers.Builder headers;
    protected HttpCycleContext httpCycleContext;
    private String httpTaskKey;
    private final List<Part> params;
    private RequestBody requestBody;
    private boolean urlEncoder;

    public RequestParams() {
        this(null);
    }

    private void init() {
        this.headers.add("charset", "UTF-8");
        List<Part> commonParams = OkHttpFinal.getInstance().getCommonParams();
        if (commonParams != null && commonParams.size() > 0) {
            this.params.addAll(commonParams);
        }
        Headers commonHeaders = OkHttpFinal.getInstance().getCommonHeaders();
        if (commonHeaders != null && commonHeaders.size() > 0) {
            for (int i = 0; i < commonHeaders.size(); i++) {
                this.headers.add(commonHeaders.name(i), commonHeaders.value(i));
            }
        }
        HttpCycleContext httpCycleContext = this.httpCycleContext;
        if (httpCycleContext != null) {
            this.httpTaskKey = httpCycleContext.getHttpTaskKey();
        }
    }

    public void addFormDataPart(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Part part = new Part(str, str2);
        if (StringUtils.isEmpty(str) || this.params.contains(part)) {
            return;
        }
        this.params.add(part);
    }

    public void addFormDataPartFiles(String str, List<File> list) {
        for (File file : list) {
            if (file != null && file.exists() && file.length() != 0) {
                addFormDataPart(str, file);
            }
        }
    }

    public void addFormDataParts(List<Part> list) {
        this.params.addAll(list);
    }

    public void addHeader(String str) {
        this.headers.add(str);
    }

    public void applicationJson() {
        this.applicationJson = true;
    }

    public void clear() {
        this.params.clear();
        this.files.clear();
    }

    public List<Part> getFormParams() {
        return this.params;
    }

    public String getHttpTaskKey() {
        return this.httpTaskKey;
    }

    public RequestBody getRequestBody() {
        if (this.applicationJson) {
            return null;
        }
        RequestBody requestBodyBuild = this.requestBody;
        if (requestBodyBuild == null) {
            if (this.files.size() <= 0) {
                FormBody.Builder builder = new FormBody.Builder();
                for (Part part : this.params) {
                    builder.add(part.getKey(), part.getValue());
                }
                return builder.build();
            }
            MultipartBody.Builder builder2 = new MultipartBody.Builder();
            builder2.setType(MultipartBody.FORM);
            boolean z = false;
            for (Part part2 : this.params) {
                builder2.addFormDataPart(part2.getKey(), part2.getValue());
                z = true;
            }
            for (Part part3 : this.files) {
                String key = part3.getKey();
                FileWrapper fileWrapper = part3.getFileWrapper();
                if (fileWrapper != null) {
                    builder2.addFormDataPart(key, fileWrapper.getFileName(), RequestBody.create(fileWrapper.getMediaType(), fileWrapper.getFile()));
                    z = true;
                }
            }
            if (!z) {
                return null;
            }
            requestBodyBuild = builder2.build();
        }
        return requestBodyBuild;
    }

    public boolean isUrlEncoder() {
        return this.urlEncoder;
    }

    public void setCacheControl(CacheControl cacheControl) {
        this.cacheControl = cacheControl;
    }

    public void setCustomRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public void setRequestBody(String str, String str2) {
        setRequestBody(MediaType.parse(str), str2);
    }

    public void setRequestBodyString(String str) {
        setRequestBody(MediaType.parse("text/plain; charset=utf-8"), str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Part part : this.params) {
            String key = part.getKey();
            String value = part.getValue();
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(key);
            sb.append("=");
            sb.append(value);
        }
        Iterator<Part> it = this.files.iterator();
        while (it.hasNext()) {
            String key2 = it.next().getKey();
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(key2);
            sb.append("=");
            sb.append("FILE");
        }
        return sb.toString();
    }

    public void urlEncoder() {
        this.urlEncoder = true;
    }

    public RequestParams(HttpCycleContext httpCycleContext) {
        this.headers = new Headers.Builder();
        this.params = new ArrayList();
        this.files = new ArrayList();
        this.httpCycleContext = httpCycleContext;
        init();
    }

    public void addHeader(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.headers.add(str, str2);
    }

    public void setRequestBody(MediaType mediaType, String str) {
        setCustomRequestBody(RequestBody.create(mediaType, str));
    }

    public void addFormDataPart(String str, int i) {
        addFormDataPart(str, String.valueOf(i));
    }

    public void addHeader(String str, int i) {
        addHeader(str, String.valueOf(i));
    }

    public void addFormDataPart(String str, long j) {
        addFormDataPart(str, String.valueOf(j));
    }

    public void addHeader(String str, long j) {
        addHeader(str, String.valueOf(j));
    }

    public void addFormDataPart(String str, float f) {
        addFormDataPart(str, String.valueOf(f));
    }

    public void addHeader(String str, float f) {
        addHeader(str, String.valueOf(f));
    }

    public void addFormDataPart(String str, double d) {
        addFormDataPart(str, String.valueOf(d));
    }

    public void addHeader(String str, double d) {
        addHeader(str, String.valueOf(d));
    }

    public void addFormDataPart(String str, boolean z) {
        addFormDataPart(str, String.valueOf(z));
    }

    public void addHeader(String str, boolean z) {
        addHeader(str, String.valueOf(z));
    }

    public void addFormDataPart(String str, File file) {
        if (file == null || !file.exists() || file.length() == 0) {
            return;
        }
        boolean z = file.getName().lastIndexOf("png") > 0 || file.getName().lastIndexOf("PNG") > 0;
        if (z) {
            addFormDataPart(str, file, "image/png; charset=UTF-8");
            return;
        }
        boolean z2 = file.getName().lastIndexOf("jpg") > 0 || file.getName().lastIndexOf("JPG") > 0 || file.getName().lastIndexOf(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG) > 0 || file.getName().lastIndexOf("JPEG") > 0;
        if (z2) {
            addFormDataPart(str, file, "image/jpeg; charset=UTF-8");
        } else {
            if (z || z2) {
                return;
            }
            addFormDataPart(str, new FileWrapper(file, null));
        }
    }

    public void addFormDataPart(String str, File file, String str2) {
        MediaType mediaType;
        if (file == null || !file.exists() || file.length() == 0) {
            return;
        }
        try {
            mediaType = MediaType.parse(str2);
        } catch (Exception e) {
            ILogger.e(e);
            mediaType = null;
        }
        addFormDataPart(str, new FileWrapper(file, mediaType));
    }

    public void addFormDataPart(String str, File file, MediaType mediaType) {
        if (file == null || !file.exists() || file.length() == 0) {
            return;
        }
        addFormDataPart(str, new FileWrapper(file, mediaType));
    }

    public void addFormDataPart(String str, List<File> list, MediaType mediaType) {
        for (File file : list) {
            if (file != null && file.exists() && file.length() != 0) {
                addFormDataPart(str, new FileWrapper(file, mediaType));
            }
        }
    }

    public void addFormDataPart(String str, FileWrapper fileWrapper) {
        File file;
        if (StringUtils.isEmpty(str) || fileWrapper == null || (file = fileWrapper.getFile()) == null || !file.exists() || file.length() == 0) {
            return;
        }
        this.files.add(new Part(str, fileWrapper));
    }

    public void addFormDataPart(String str, List<FileWrapper> list) {
        Iterator<FileWrapper> it = list.iterator();
        while (it.hasNext()) {
            addFormDataPart(str, it.next());
        }
    }
}
