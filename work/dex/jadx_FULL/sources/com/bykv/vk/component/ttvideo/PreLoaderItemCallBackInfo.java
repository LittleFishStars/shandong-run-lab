package com.bykv.vk.component.ttvideo;

import com.bykv.vk.component.ttvideo.utils.Error;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class PreLoaderItemCallBackInfo {
    public static final int KEY_IS_PRELOAD_END_CANCEL = 5;
    public static final int KEY_IS_PRELOAD_END_FAIL = 3;
    public static final int KEY_IS_PRELOAD_END_SUCCEED = 2;
    public static final int KEY_IS_PRELOAD_INFO = 6;
    public static final int PRELOAD_TYPE_SIZE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29278a;
    public DataLoaderHelper.DataLoaderTaskProgressInfo preloadDataInfo = null;
    public DataLoaderHelper.c loadProgress = null;
    public Error preloadError = null;
    public int preloadType = 0;
    public long audioPreloadSize = 0;
    public long videoPreloadSize = 0;

    public PreLoaderItemCallBackInfo(int i) {
        this.f29278a = i;
    }

    public int getKey() {
        return this.f29278a;
    }
}
