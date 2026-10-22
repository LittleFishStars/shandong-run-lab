package com.aliyun.svideosdk.editor.impl;

import android.net.Uri;
import com.aliyun.Visible;
import com.aliyun.svideosdk.editor.AliyunIEditor;
import com.aliyun.svideosdk.editor.EditorCallBack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunEditorFactory {
    public static AliyunIEditor creatAliyunEditor(Uri uri, EditorCallBack editorCallBack) {
        return new f(uri, editorCallBack);
    }
}
