package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    private final MediaBrowserImpl mImpl;
    static final String TAG = "MediaBrowserCompat";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static MediaDescription getDescription(MediaBrowser.MediaItem item) {
            return item.getDescription();
        }

        @DoNotInline
        public static int getFlags(MediaBrowser.MediaItem item) {
            return item.getFlags();
        }
    }

    public static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        public CallbackHandler(MediaBrowserServiceCallbackImpl callbackImpl) {
            this.mCallbackImplRef = new WeakReference<>(callbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message msg) {
            WeakReference<Messenger> weakReference = this.mCallbacksMessengerRef;
            if (weakReference == null || weakReference.get() == null || this.mCallbackImplRef.get() == null) {
                return;
            }
            Bundle data = msg.getData();
            MediaSessionCompat.ensureClassLoader(data);
            MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.mCallbackImplRef.get();
            Messenger messenger = this.mCallbacksMessengerRef.get();
            try {
                int i = msg.what;
                if (i == 1) {
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                } else if (i == 2) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                } else if (i != 3) {
                    Log.w(MediaBrowserCompat.TAG, "Unhandled message: " + msg + "\n  Client version: 1\n  Service version: " + msg.arg1);
                } else {
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                Log.e(MediaBrowserCompat.TAG, "Could not unparcel the data.");
                if (msg.what == 1) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                }
            }
        }

        public void setCallbacksMessenger(Messenger callbacksMessenger) {
            this.mCallbacksMessengerRef = new WeakReference<>(callbacksMessenger);
        }
    }

    public static class ConnectionCallback {
        final MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new ConnectionCallbackApi21();
        ConnectionCallbackInternal mConnectionCallbackInternal;

        @RequiresApi(21)
        public class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            public ConnectionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.onConnected();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionFailed();
                }
                ConnectionCallback.this.onConnectionFailed();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionSuspended();
                }
                ConnectionCallback.this.onConnectionSuspended();
            }
        }

        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    public static abstract class CustomActionCallback {
        public void onError(String action, Bundle extras, Bundle data) {
        }

        public void onProgressUpdate(String action, Bundle extras, Bundle data) {
        }

        public void onResult(String action, Bundle extras, Bundle resultData) {
        }
    }

    public static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        public CustomActionResultReceiver(String action, Bundle extras, CustomActionCallback callback, Handler handler) {
            super(handler);
            this.mAction = action;
            this.mExtras = extras;
            this.mCallback = callback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int resultCode, Bundle resultData) {
            if (this.mCallback == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(resultData);
            if (resultCode == -1) {
                this.mCallback.onError(this.mAction, this.mExtras, resultData);
                return;
            }
            if (resultCode == 0) {
                this.mCallback.onResult(this.mAction, this.mExtras, resultData);
                return;
            }
            if (resultCode == 1) {
                this.mCallback.onProgressUpdate(this.mAction, this.mExtras, resultData);
                return;
            }
            Log.w(MediaBrowserCompat.TAG, "Unknown result code: " + resultCode + " (extras=" + this.mExtras + ", resultData=" + resultData + ")");
        }
    }

    public static abstract class ItemCallback {
        final MediaBrowser.ItemCallback mItemCallbackFwk = new ItemCallbackApi23();

        @RequiresApi(23)
        public class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
            public ItemCallbackApi23() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onError(@NonNull String itemId) {
                ItemCallback.this.onError(itemId);
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onItemLoaded(MediaBrowser.MediaItem item) {
                ItemCallback.this.onItemLoaded(MediaItem.fromMediaItem(item));
            }
        }

        public void onError(@NonNull String itemId) {
        }

        public void onItemLoaded(MediaItem item) {
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        public ItemReceiver(String mediaId, ItemCallback callback, Handler handler) {
            super(handler);
            this.mMediaId = mediaId;
            this.mCallback = callback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData != null) {
                resultData = MediaSessionCompat.unparcelWithClassLoader(resultData);
            }
            if (resultCode != 0 || resultData == null || !resultData.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                this.mCallback.onError(this.mMediaId);
                return;
            }
            Parcelable parcelable = resultData.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.mCallback.onItemLoaded((MediaItem) parcelable);
            } else {
                this.mCallback.onError(this.mMediaId);
            }
        }
    }

    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @Nullable
        Bundle getExtras();

        void getItem(@NonNull String mediaId, @NonNull ItemCallback cb);

        @Nullable
        Bundle getNotifyChildrenChangedOptions();

        @NonNull
        String getRoot();

        ComponentName getServiceComponent();

        @NonNull
        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(@NonNull String query, Bundle extras, @NonNull SearchCallback callback);

        void sendCustomAction(@NonNull String action, Bundle extras, @Nullable CustomActionCallback callback);

        void subscribe(@NonNull String parentId, @Nullable Bundle options, @NonNull SubscriptionCallback callback);

        void unsubscribe(@NonNull String parentId, SubscriptionCallback callback);
    }

    @RequiresApi(21)
    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        protected final MediaBrowser mBrowserFwk;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        protected final CallbackHandler mHandler = new CallbackHandler(this);
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        public MediaBrowserImplApi21(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            this.mContext = context;
            Bundle bundle = rootHints != null ? new Bundle(rootHints) : new Bundle();
            this.mRootHints = bundle;
            bundle.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            bundle.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
            callback.setInternalConnectionCallback(this);
            this.mBrowserFwk = new MediaBrowser(context, serviceComponent, callback.mConnectionCallbackFwk, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            this.mBrowserFwk.connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            Messenger messenger;
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null && (messenger = this.mCallbacksMessenger) != null) {
                try {
                    serviceBinderWrapper.unregisterCallbackMessenger(messenger);
                } catch (RemoteException unused) {
                    Log.i(MediaBrowserCompat.TAG, "Remote error unregistering client messenger.");
                }
            }
            this.mBrowserFwk.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @Nullable
        public Bundle getExtras() {
            return this.mBrowserFwk.getExtras();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull final String mediaId, @NonNull final ItemCallback cb) {
            if (TextUtils.isEmpty(mediaId)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (cb == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!this.mBrowserFwk.isConnected()) {
                Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.1
                    @Override // java.lang.Runnable
                    public void run() {
                        cb.onError(mediaId);
                    }
                });
                return;
            }
            if (this.mServiceBinderWrapper == null) {
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.2
                    @Override // java.lang.Runnable
                    public void run() {
                        cb.onError(mediaId);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(mediaId, new ItemReceiver(mediaId, cb, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + mediaId);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.3
                    @Override // java.lang.Runnable
                    public void run() {
                        cb.onError(mediaId);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            return this.mBrowserFwk.getRoot();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return this.mBrowserFwk.getServiceComponent();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken());
            }
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mBrowserFwk.isConnected();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            try {
                Bundle extras = this.mBrowserFwk.getExtras();
                if (extras == null) {
                    return;
                }
                this.mServiceVersion = extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.mServiceBinderWrapper = new ServiceBinderWrapper(binder, this.mRootHints);
                    Messenger messenger = new Messenger(this.mHandler);
                    this.mCallbacksMessenger = messenger;
                    this.mHandler.setCallbacksMessenger(messenger);
                    try {
                        this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
                    } catch (RemoteException unused) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error registering client messenger.");
                    }
                }
                IMediaSession iMediaSessionAsInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (iMediaSessionAsInterface != null) {
                    this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken(), iMediaSessionAsInterface);
                }
            } catch (IllegalStateException e) {
                Log.e(MediaBrowserCompat.TAG, "Unexpected IllegalStateException", e);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger callback) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger callback, String parentId, List<MediaItem> list, Bundle options, Bundle notifyChildrenChangedOptions) {
            if (this.mCallbacksMessenger != callback) {
                return;
            }
            Subscription subscription = this.mSubscriptions.get(parentId);
            if (subscription == null) {
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + parentId);
                    return;
                }
                return;
            }
            SubscriptionCallback callback2 = subscription.getCallback(options);
            if (callback2 != null) {
                if (options == null) {
                    if (list == null) {
                        callback2.onError(parentId);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = notifyChildrenChangedOptions;
                    callback2.onChildrenLoaded(parentId, list);
                    this.mNotifyChildrenChangedOptions = null;
                    return;
                }
                if (list == null) {
                    callback2.onError(parentId, options);
                    return;
                }
                this.mNotifyChildrenChangedOptions = notifyChildrenChangedOptions;
                callback2.onChildrenLoaded(parentId, list, options);
                this.mNotifyChildrenChangedOptions = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(final Messenger callback, final String root, final MediaSessionCompat.Token session, final Bundle extra) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull final String query, final Bundle extras, @NonNull final SearchCallback callback) {
            if (!isConnected()) {
                throw new IllegalStateException("search() called while not connected");
            }
            if (this.mServiceBinderWrapper == null) {
                Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support search.");
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.4
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onError(query, extras);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.search(query, extras, new SearchResultReceiver(query, extras, callback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + query, e);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.5
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onError(query, extras);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull final String action, final Bundle extras, @Nullable final CustomActionCallback callback) {
            if (!isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + action + ") with extras " + extras + " because the browser is not connected to the service.");
            }
            if (this.mServiceBinderWrapper == null) {
                Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support sendCustomAction.");
                if (callback != null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.6
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onError(action, extras, null);
                        }
                    });
                }
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(action, extras, new CustomActionResultReceiver(action, extras, callback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + action + ", extras=" + extras, e);
                if (callback != null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.7
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onError(action, extras, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull final String parentId, final Bundle options, @NonNull final SubscriptionCallback callback) {
            Subscription subscription = this.mSubscriptions.get(parentId);
            if (subscription == null) {
                subscription = new Subscription();
                this.mSubscriptions.put(parentId, subscription);
            }
            callback.setSubscription(subscription);
            Bundle bundle = options == null ? null : new Bundle(options);
            subscription.putCallback(bundle, callback);
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                this.mBrowserFwk.subscribe(parentId, callback.mSubscriptionCallbackFwk);
                return;
            }
            try {
                serviceBinderWrapper.addSubscription(parentId, callback.mToken, bundle, this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.TAG, "Remote error subscribing media item: " + parentId);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String parentId, SubscriptionCallback callback) {
            Subscription subscription = this.mSubscriptions.get(parentId);
            if (subscription == null) {
                return;
            }
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null) {
                try {
                    if (callback == null) {
                        serviceBinderWrapper.removeSubscription(parentId, null, this.mCallbacksMessenger);
                    } else {
                        List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                        List<Bundle> optionsList = subscription.getOptionsList();
                        for (int size = callbacks.size() - 1; size >= 0; size--) {
                            if (callbacks.get(size) == callback) {
                                this.mServiceBinderWrapper.removeSubscription(parentId, callback.mToken, this.mCallbacksMessenger);
                                callbacks.remove(size);
                                optionsList.remove(size);
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + parentId);
                }
            } else if (callback == null) {
                this.mBrowserFwk.unsubscribe(parentId);
            } else {
                List<SubscriptionCallback> callbacks2 = subscription.getCallbacks();
                List<Bundle> optionsList2 = subscription.getOptionsList();
                for (int size2 = callbacks2.size() - 1; size2 >= 0; size2--) {
                    if (callbacks2.get(size2) == callback) {
                        callbacks2.remove(size2);
                        optionsList2.remove(size2);
                    }
                }
                if (callbacks2.size() == 0) {
                    this.mBrowserFwk.unsubscribe(parentId);
                }
            }
            if (subscription.isEmpty() || callback == null) {
                this.mSubscriptions.remove(parentId);
            }
        }
    }

    @RequiresApi(23)
    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            super(context, serviceComponent, callback, rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull final String mediaId, @NonNull final ItemCallback cb) {
            if (this.mServiceBinderWrapper == null) {
                this.mBrowserFwk.getItem(mediaId, cb.mItemCallbackFwk);
            } else {
                super.getItem(mediaId, cb);
            }
        }
    }

    @RequiresApi(26)
    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi26(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            super(context, serviceComponent, callback, rootHints);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String parentId, @Nullable Bundle options, @NonNull SubscriptionCallback callback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.subscribe(parentId, options, callback);
            } else if (options == null) {
                this.mBrowserFwk.subscribe(parentId, callback.mSubscriptionCallbackFwk);
            } else {
                this.mBrowserFwk.subscribe(parentId, options, callback.mSubscriptionCallbackFwk);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String parentId, SubscriptionCallback callback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.unsubscribe(parentId, callback);
            } else if (callback == null) {
                this.mBrowserFwk.unsubscribe(parentId);
            } else {
                this.mBrowserFwk.unsubscribe(parentId, callback.mSubscriptionCallbackFwk);
            }
        }
    }

    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        final CallbackHandler mHandler = new CallbackHandler(this);
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();
        int mState = 1;

        public class MediaServiceConnection implements ServiceConnection {
            public MediaServiceConnection() {
            }

            private void postOrRun(Runnable r) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    r.run();
                } else {
                    MediaBrowserImplBase.this.mHandler.post(r);
                }
            }

            public boolean isCurrent(String funcName) {
                int i;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mServiceConnection == this && (i = mediaBrowserImplBase.mState) != 0 && i != 1) {
                    return true;
                }
                int i2 = mediaBrowserImplBase.mState;
                if (i2 == 0 || i2 == 1) {
                    return false;
                }
                Log.i(MediaBrowserCompat.TAG, funcName + " for " + MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName name, final IBinder binder) {
                postOrRun(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z = MediaBrowserCompat.DEBUG;
                        if (z) {
                            Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceConnected name=" + name + " binder=" + binder);
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.mServiceBinderWrapper = new ServiceBinderWrapper(binder, mediaBrowserImplBase.mRootHints);
                            MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserImplBase.this.mHandler);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.mHandler.setCallbacksMessenger(mediaBrowserImplBase2.mCallbacksMessenger);
                            MediaBrowserImplBase.this.mState = 2;
                            if (z) {
                                try {
                                    Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.dump();
                                } catch (RemoteException unused) {
                                    Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                                    if (MediaBrowserCompat.DEBUG) {
                                        Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                        MediaBrowserImplBase.this.dump();
                                        return;
                                    }
                                    return;
                                }
                            }
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase3.mServiceBinderWrapper.connect(mediaBrowserImplBase3.mContext, mediaBrowserImplBase3.mCallbacksMessenger);
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName name) {
                postOrRun(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.DEBUG) {
                            Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceDisconnected name=" + name + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection);
                            MediaBrowserImplBase.this.dump();
                        }
                        if (MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.mServiceBinderWrapper = null;
                            mediaBrowserImplBase.mCallbacksMessenger = null;
                            mediaBrowserImplBase.mHandler.setCallbacksMessenger(null);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.mState = 4;
                            mediaBrowserImplBase2.mCallback.onConnectionSuspended();
                        }
                    }
                });
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (serviceComponent == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (callback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.mContext = context;
            this.mServiceComponent = serviceComponent;
            this.mCallback = callback;
            this.mRootHints = rootHints == null ? null : new Bundle(rootHints);
        }

        private static String getStateLabel(int state) {
            if (state == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (state == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (state == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (state == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (state == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + state;
        }

        private boolean isCurrent(Messenger callback, String funcName) {
            int i;
            if (this.mCallbacksMessenger == callback && (i = this.mState) != 0 && i != 1) {
                return true;
            }
            int i2 = this.mState;
            if (i2 == 0 || i2 == 1) {
                return false;
            }
            Log.i(MediaBrowserCompat.TAG, funcName + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int i = this.mState;
            if (i == 0 || i == 1) {
                this.mState = 2;
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zBindService;
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        if (mediaBrowserImplBase.mState == 0) {
                            return;
                        }
                        mediaBrowserImplBase.mState = 2;
                        if (MediaBrowserCompat.DEBUG && mediaBrowserImplBase.mServiceConnection != null) {
                            throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.mServiceConnection);
                        }
                        if (mediaBrowserImplBase.mServiceBinderWrapper != null) {
                            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.mServiceBinderWrapper);
                        }
                        if (mediaBrowserImplBase.mCallbacksMessenger != null) {
                            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.mCallbacksMessenger);
                        }
                        Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                        intent.setComponent(MediaBrowserImplBase.this.mServiceComponent);
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mServiceConnection = mediaBrowserImplBase2.new MediaServiceConnection();
                        try {
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            zBindService = mediaBrowserImplBase3.mContext.bindService(intent, mediaBrowserImplBase3.mServiceConnection, 1);
                        } catch (Exception unused) {
                            Log.e(MediaBrowserCompat.TAG, "Failed binding to service " + MediaBrowserImplBase.this.mServiceComponent);
                            zBindService = false;
                        }
                        if (!zBindService) {
                            MediaBrowserImplBase.this.forceCloseConnection();
                            MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                        }
                        if (MediaBrowserCompat.DEBUG) {
                            Log.d(MediaBrowserCompat.TAG, "connect...");
                            MediaBrowserImplBase.this.dump();
                        }
                    }
                });
            } else {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                    Messenger messenger = mediaBrowserImplBase.mCallbacksMessenger;
                    if (messenger != null) {
                        try {
                            mediaBrowserImplBase.mServiceBinderWrapper.disconnect(messenger);
                        } catch (RemoteException unused) {
                            Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                        }
                    }
                    MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                    int i = mediaBrowserImplBase2.mState;
                    mediaBrowserImplBase2.forceCloseConnection();
                    if (i != 0) {
                        MediaBrowserImplBase.this.mState = i;
                    }
                    if (MediaBrowserCompat.DEBUG) {
                        Log.d(MediaBrowserCompat.TAG, "disconnect...");
                        MediaBrowserImplBase.this.dump();
                    }
                }
            });
        }

        public void dump() {
            Log.d(MediaBrowserCompat.TAG, "MediaBrowserCompat...");
            Log.d(MediaBrowserCompat.TAG, "  mServiceComponent=" + this.mServiceComponent);
            Log.d(MediaBrowserCompat.TAG, "  mCallback=" + this.mCallback);
            Log.d(MediaBrowserCompat.TAG, "  mRootHints=" + this.mRootHints);
            Log.d(MediaBrowserCompat.TAG, "  mState=" + getStateLabel(this.mState));
            Log.d(MediaBrowserCompat.TAG, "  mServiceConnection=" + this.mServiceConnection);
            Log.d(MediaBrowserCompat.TAG, "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            Log.d(MediaBrowserCompat.TAG, "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            Log.d(MediaBrowserCompat.TAG, "  mRootId=" + this.mRootId);
            Log.d(MediaBrowserCompat.TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        public void forceCloseConnection() {
            MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
            if (mediaServiceConnection != null) {
                this.mContext.unbindService(mediaServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @Nullable
        public Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull final String mediaId, @NonNull final ItemCallback cb) {
            if (TextUtils.isEmpty(mediaId)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (cb == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!isConnected()) {
                Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.3
                    @Override // java.lang.Runnable
                    public void run() {
                        cb.onError(mediaId);
                    }
                });
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(mediaId, new ItemReceiver(mediaId, cb, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException unused) {
                Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + mediaId);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.4
                    @Override // java.lang.Runnable
                    public void run() {
                        cb.onError(mediaId);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mState == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(final Messenger callback) {
            Log.e(MediaBrowserCompat.TAG, "onConnectFailed for " + this.mServiceComponent);
            if (isCurrent(callback, "onConnectFailed")) {
                if (this.mState == 2) {
                    forceCloseConnection();
                    this.mCallback.onConnectionFailed();
                    return;
                }
                Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(final Messenger callback, final String parentId, final List<MediaItem> list, final Bundle options, final Bundle notifyChildrenChangedOptions) {
            if (isCurrent(callback, "onLoadChildren")) {
                boolean z = MediaBrowserCompat.DEBUG;
                if (z) {
                    Log.d(MediaBrowserCompat.TAG, "onLoadChildren for " + this.mServiceComponent + " id=" + parentId);
                }
                Subscription subscription = this.mSubscriptions.get(parentId);
                if (subscription == null) {
                    if (z) {
                        Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + parentId);
                        return;
                    }
                    return;
                }
                SubscriptionCallback callback2 = subscription.getCallback(options);
                if (callback2 != null) {
                    if (options == null) {
                        if (list == null) {
                            callback2.onError(parentId);
                            return;
                        }
                        this.mNotifyChildrenChangedOptions = notifyChildrenChangedOptions;
                        callback2.onChildrenLoaded(parentId, list);
                        this.mNotifyChildrenChangedOptions = null;
                        return;
                    }
                    if (list == null) {
                        callback2.onError(parentId, options);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = notifyChildrenChangedOptions;
                    callback2.onChildrenLoaded(parentId, list, options);
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(final Messenger callback, final String root, final MediaSessionCompat.Token session, final Bundle extra) {
            if (isCurrent(callback, "onConnect")) {
                if (this.mState != 2) {
                    Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                    return;
                }
                this.mRootId = root;
                this.mMediaSessionToken = session;
                this.mExtras = extra;
                this.mState = 3;
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                    dump();
                }
                this.mCallback.onConnected();
                try {
                    for (Map.Entry<String, Subscription> entry : this.mSubscriptions.entrySet()) {
                        String key = entry.getKey();
                        Subscription value = entry.getValue();
                        List<SubscriptionCallback> callbacks = value.getCallbacks();
                        List<Bundle> optionsList = value.getOptionsList();
                        for (int i = 0; i < callbacks.size(); i++) {
                            this.mServiceBinderWrapper.addSubscription(key, callbacks.get(i).mToken, optionsList.get(i), this.mCallbacksMessenger);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull final String query, final Bundle extras, @NonNull final SearchCallback callback) {
            if (!isConnected()) {
                throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
            }
            try {
                this.mServiceBinderWrapper.search(query, extras, new SearchResultReceiver(query, extras, callback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + query, e);
                this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.5
                    @Override // java.lang.Runnable
                    public void run() {
                        callback.onError(query, extras);
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull final String action, final Bundle extras, @Nullable final CustomActionCallback callback) {
            if (!isConnected()) {
                throw new IllegalStateException("Cannot send a custom action (" + action + ") with extras " + extras + " because the browser is not connected to the service.");
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(action, extras, new CustomActionResultReceiver(action, extras, callback, this.mHandler), this.mCallbacksMessenger);
            } catch (RemoteException e) {
                Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + action + ", extras=" + extras, e);
                if (callback != null) {
                    this.mHandler.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.6
                        @Override // java.lang.Runnable
                        public void run() {
                            callback.onError(action, extras, null);
                        }
                    });
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String parentId, Bundle options, @NonNull SubscriptionCallback callback) {
            Subscription subscription = this.mSubscriptions.get(parentId);
            if (subscription == null) {
                subscription = new Subscription();
                this.mSubscriptions.put(parentId, subscription);
            }
            Bundle bundle = options == null ? null : new Bundle(options);
            subscription.putCallback(bundle, callback);
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(parentId, callback.mToken, bundle, this.mCallbacksMessenger);
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException parentId=" + parentId);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String parentId, SubscriptionCallback callback) {
            Subscription subscription = this.mSubscriptions.get(parentId);
            if (subscription == null) {
                return;
            }
            try {
                if (callback != null) {
                    List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                    List<Bundle> optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == callback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(parentId, callback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                } else if (isConnected()) {
                    this.mServiceBinderWrapper.removeSubscription(parentId, null, this.mCallbacksMessenger);
                }
            } catch (RemoteException unused) {
                Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + parentId);
            }
            if (subscription.isEmpty() || callback == null) {
                this.mSubscriptions.remove(parentId);
            }
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger callback);

        void onLoadChildren(Messenger callback, String parentId, List<MediaItem> list, Bundle options, Bundle notifyChildrenChangedOptions);

        void onServiceConnected(Messenger callback, String root, MediaSessionCompat.Token session, Bundle extra);
    }

    public static abstract class SearchCallback {
        public void onError(@NonNull String query, Bundle extras) {
        }

        public void onSearchResult(@NonNull String query, Bundle extras, @NonNull List<MediaItem> items) {
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        public SearchResultReceiver(String query, Bundle extras, SearchCallback callback, Handler handler) {
            super(handler);
            this.mQuery = query;
            this.mExtras = extras;
            this.mCallback = callback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int resultCode, Bundle resultData) {
            if (resultData != null) {
                resultData = MediaSessionCompat.unparcelWithClassLoader(resultData);
            }
            if (resultCode != 0 || resultData == null || !resultData.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            Parcelable[] parcelableArray = resultData.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (parcelableArray == null) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
        }
    }

    public static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder target, Bundle rootHints) {
            this.mMessenger = new Messenger(target);
            this.mRootHints = rootHints;
        }

        private void sendRequest(int what, Bundle data, Messenger cbMessenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = what;
            messageObtain.arg1 = 1;
            messageObtain.setData(data);
            messageObtain.replyTo = cbMessenger;
            this.mMessenger.send(messageObtain);
        }

        public void addSubscription(String parentId, IBinder callbackToken, Bundle options, Messenger callbacksMessenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, parentId);
            BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, callbackToken);
            bundle.putBundle(MediaBrowserProtocol.DATA_OPTIONS, options);
            sendRequest(3, bundle, callbacksMessenger);
        }

        public void connect(Context context, Messenger callbacksMessenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, bundle, callbacksMessenger);
        }

        public void disconnect(Messenger callbacksMessenger) throws RemoteException {
            sendRequest(2, null, callbacksMessenger);
        }

        public void getMediaItem(String mediaId, ResultReceiver receiver, Messenger callbacksMessenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, mediaId);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, receiver);
            sendRequest(5, bundle, callbacksMessenger);
        }

        public void registerCallbackMessenger(Context context, Messenger callbackMessenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Process.myPid());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, bundle, callbackMessenger);
        }

        public void removeSubscription(String parentId, IBinder callbackToken, Messenger callbacksMessenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, parentId);
            BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, callbackToken);
            sendRequest(4, bundle, callbacksMessenger);
        }

        public void search(String query, Bundle extras, ResultReceiver receiver, Messenger callbacksMessenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, query);
            bundle.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, extras);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, receiver);
            sendRequest(8, bundle, callbacksMessenger);
        }

        public void sendCustomAction(String action, Bundle extras, ResultReceiver receiver, Messenger callbacksMessenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, action);
            bundle.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, extras);
            bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, receiver);
            sendRequest(9, bundle, callbacksMessenger);
        }

        public void unregisterCallbackMessenger(Messenger callbackMessenger) throws RemoteException {
            sendRequest(7, null, callbackMessenger);
        }
    }

    public static class Subscription {
        private final List<SubscriptionCallback> mCallbacks = new ArrayList();
        private final List<Bundle> mOptionsList = new ArrayList();

        public SubscriptionCallback getCallback(Bundle options) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), options)) {
                    return this.mCallbacks.get(i);
                }
            }
            return null;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(Bundle options, SubscriptionCallback callback) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), options)) {
                    this.mCallbacks.set(i, callback);
                    return;
                }
            }
            this.mCallbacks.add(callback);
            this.mOptionsList.add(options);
        }
    }

    public static abstract class SubscriptionCallback {
        WeakReference<Subscription> mSubscriptionRef;
        final IBinder mToken = new Binder();
        final MediaBrowser.SubscriptionCallback mSubscriptionCallbackFwk = new SubscriptionCallbackApi26();

        @RequiresApi(21)
        public class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            public SubscriptionCallbackApi21() {
            }

            public List<MediaItem> applyOptions(List<MediaItem> list, final Bundle options) {
                if (list == null) {
                    return null;
                }
                int i = options.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int i2 = options.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i;
                int size = i3 + i2;
                if (i < 0 || i2 < 1 || i3 >= list.size()) {
                    return Collections.emptyList();
                }
                if (size > list.size()) {
                    size = list.size();
                }
                return list.subList(i3, size);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String parentId, List<MediaBrowser.MediaItem> children) {
                WeakReference<Subscription> weakReference = SubscriptionCallback.this.mSubscriptionRef;
                Subscription subscription = weakReference == null ? null : weakReference.get();
                if (subscription == null) {
                    SubscriptionCallback.this.onChildrenLoaded(parentId, MediaItem.fromMediaItemList(children));
                    return;
                }
                List<MediaItem> listFromMediaItemList = MediaItem.fromMediaItemList(children);
                List<SubscriptionCallback> callbacks = subscription.getCallbacks();
                List<Bundle> optionsList = subscription.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    Bundle bundle = optionsList.get(i);
                    if (bundle == null) {
                        SubscriptionCallback.this.onChildrenLoaded(parentId, listFromMediaItemList);
                    } else {
                        SubscriptionCallback.this.onChildrenLoaded(parentId, applyOptions(listFromMediaItemList, bundle), bundle);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String parentId) {
                SubscriptionCallback.this.onError(parentId);
            }
        }

        @RequiresApi(26)
        public class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21 {
            public SubscriptionCallbackApi26() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaBrowser.MediaItem> children, @NonNull Bundle options) {
                MediaSessionCompat.ensureClassLoader(options);
                SubscriptionCallback.this.onChildrenLoaded(parentId, MediaItem.fromMediaItemList(children), options);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String parentId, @NonNull Bundle options) {
                MediaSessionCompat.ensureClassLoader(options);
                SubscriptionCallback.this.onError(parentId, options);
            }
        }

        public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> children) {
        }

        public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> children, @NonNull Bundle options) {
        }

        public void onError(@NonNull String parentId) {
        }

        public void onError(@NonNull String parentId, @NonNull Bundle options) {
        }

        public void setSubscription(Subscription subscription) {
            this.mSubscriptionRef = new WeakReference<>(subscription);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
        this.mImpl = new MediaBrowserImplApi26(context, serviceComponent, callback, rootHints);
    }

    public void connect() {
        Log.d(TAG, "Connecting to a MediaBrowserService.");
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@NonNull final String mediaId, @NonNull final ItemCallback cb) {
        this.mImpl.getItem(mediaId, cb);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    @NonNull
    public String getRoot() {
        return this.mImpl.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(@NonNull final String query, final Bundle extras, @NonNull SearchCallback callback) {
        if (TextUtils.isEmpty(query)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.search(query, extras, callback);
    }

    public void sendCustomAction(@NonNull String action, Bundle extras, @Nullable CustomActionCallback callback) {
        if (TextUtils.isEmpty(action)) {
            throw new IllegalArgumentException("action cannot be empty");
        }
        this.mImpl.sendCustomAction(action, extras, callback);
    }

    public void subscribe(@NonNull String parentId, @NonNull SubscriptionCallback callback) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.mImpl.subscribe(parentId, null, callback);
    }

    public void unsubscribe(@NonNull String parentId) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.mImpl.unsubscribe(parentId, null);
    }

    public void unsubscribe(@NonNull String parentId, @NonNull SubscriptionCallback callback) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (callback != null) {
            this.mImpl.unsubscribe(parentId, callback);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public void subscribe(@NonNull String parentId, @NonNull Bundle options, @NonNull SubscriptionCallback callback) {
        if (TextUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (callback == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (options != null) {
            this.mImpl.subscribe(parentId, options, callback);
            return;
        }
        throw new IllegalArgumentException("options are null");
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem createFromParcel(Parcel in) {
                return new MediaItem(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem[] newArray(int size) {
                return new MediaItem[size];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        public MediaItem(@NonNull MediaDescriptionCompat description, int flags) {
            if (description == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(description.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = flags;
            this.mDescription = description;
        }

        public static MediaItem fromMediaItem(Object itemObj) {
            if (itemObj == null) {
                return null;
            }
            MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) itemObj;
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(Api21Impl.getDescription(mediaItem)), Api21Impl.getFlags(mediaItem));
        }

        public static List<MediaItem> fromMediaItemList(List<?> itemList) {
            if (itemList == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(itemList.size());
            Iterator<?> it = itemList.iterator();
            while (it.hasNext()) {
                arrayList.add(fromMediaItem(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        @NonNull
        public String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.mFlags);
            this.mDescription.writeToParcel(out, flags);
        }

        public MediaItem(Parcel in) {
            this.mFlags = in.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(in);
        }
    }
}
