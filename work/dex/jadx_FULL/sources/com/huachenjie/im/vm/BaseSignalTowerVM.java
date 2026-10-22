package com.huachenjie.im.vm;

import androidx.annotation.NonNull;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class BaseSignalTowerVM extends BaseChatVM {
    public MutableLiveData<Integer> m = new MutableLiveData<>();
    public MutableLiveData<Integer> n = new MutableLiveData<>(0);

    @Override // com.huachenjie.im.vm.BaseChatVM
    @NonNull
    public BaseQuickAdapter h() {
        return null;
    }
}
