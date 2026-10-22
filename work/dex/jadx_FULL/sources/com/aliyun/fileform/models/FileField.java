package com.aliyun.fileform.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FileField extends TeaModel {

    @NameInMap("content")
    @Validation(required = true)
    public InputStream content;

    @NameInMap("contentType")
    @Validation(required = true)
    public String contentType;

    @NameInMap("filename")
    @Validation(required = true)
    public String filename;

    public static FileField build(Map<String, ?> map) {
        try {
            return (FileField) TeaModel.build(map, new FileField());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
