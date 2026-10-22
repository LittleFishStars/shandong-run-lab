package com.alibaba.ariver.kernel.common.network;

import androidx.annotation.WorkerThread;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadCallback;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVTransportService extends Proxiable {
    void addDownload(RVDownloadRequest rVDownloadRequest, RVDownloadCallback rVDownloadCallback);

    @WorkerThread
    RVHttpResponse httpRequest(RVHttpRequest rVHttpRequest);
}
