package com.bykv.vk.component.ttvideo.network;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.component.ttvideo.model.LiveStreamInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public final class LiveDataFetcher {
    private final ExecutorService mExecutor;
    private Future mFuture;
    private final INetworkClient mNetworkClient;

    public interface OnCompletionListener {
        void onCompletion(LiveStreamInfo liveStreamInfo);

        void onError(LiveError liveError);
    }

    public LiveDataFetcher(ExecutorService executorService, INetworkClient iNetworkClient) {
        this.mExecutor = executorService;
        this.mNetworkClient = iNetworkClient;
    }

    public void cancel() {
        Future future = this.mFuture;
        if (future == null || future.isDone()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    public void startFetch(final String str, final String str2, final OnCompletionListener onCompletionListener) {
        if (TextUtils.isEmpty(str2) || onCompletionListener == null) {
            return;
        }
        if (this.mExecutor == null) {
            throw new IllegalStateException("mExecutor should not be null");
        }
        cancel();
        this.mFuture = this.mExecutor.submit(new Runnable() { // from class: com.bykv.vk.component.ttvideo.network.LiveDataFetcher.1
            @Override // java.lang.Runnable
            public void run() {
                NetworkManager.doRequest(LiveDataFetcher.this.mNetworkClient, str, str2, new NetworkManager.OnCompletionListener() { // from class: com.bykv.vk.component.ttvideo.network.LiveDataFetcher.1.1
                    @Override // com.bykv.vk.component.ttvideo.network.NetworkManager.OnCompletionListener
                    public void onCompletion(JSONObject jSONObject) {
                        onCompletionListener.onCompletion(new LiveStreamInfo(jSONObject.optJSONObject("Result")));
                    }

                    @Override // com.bykv.vk.component.ttvideo.network.NetworkManager.OnCompletionListener
                    public void onError(LiveError liveError) {
                        onCompletionListener.onError(liveError);
                    }
                });
            }
        });
    }
}
