package com.alibaba.ariver.commonability.file.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface FolderPickProxy extends Proxiable {
    public static final String DISPLAY_FILE_NAME = "DISPLAY_FILE_NAME";
    public static final String DISPLAY_ICON_PATH = "DISPLAY_ICON_PATH";
    public static final String STORAGE_PERMISSION = "STORAGE_PERMISSION";
    public static final String STORAGE_READ = "STORAGE_READ";
    public static final String STORAGE_WRITE = "STORAGE_WRITE";

    void setResultListener(a aVar);

    void start(HashMap<String, String> map);
}
