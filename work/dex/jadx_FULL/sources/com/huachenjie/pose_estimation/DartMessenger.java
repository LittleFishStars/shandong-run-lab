package com.huachenjie.pose_estimation;

import android.text.TextUtils;
import com.aliyun.tea.logging.DefaultLogger;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B\u0019\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/pose_estimation/DartMessenger;", "", "", "c", "Lcom/huachenjie/pose_estimation/DartMessenger$EventType;", "eventType", "", "description", "b", "Lio/flutter/plugin/common/EventChannel$EventSink;", "a", "Lio/flutter/plugin/common/EventChannel$EventSink;", "eventSink", "Lio/flutter/plugin/common/BinaryMessenger;", "messenger", "", "eventChannelId", "<init>", "(Lio/flutter/plugin/common/BinaryMessenger;J)V", "EventType", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final class DartMessenger {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public EventChannel.EventSink eventSink;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/huachenjie/pose_estimation/DartMessenger$EventType;", "", "(Ljava/lang/String;I)V", DefaultLogger.ERROR, "CAMERA_CLOSING", "pose_estimation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum EventType {
        ERROR,
        CAMERA_CLOSING
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/pose_estimation/DartMessenger$a", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "", "arguments", "Lio/flutter/plugin/common/EventChannel$EventSink;", "sink", "", "onListen", "onCancel", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements EventChannel.StreamHandler {
        public a() {
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onCancel(@Nullable Object arguments) {
            DartMessenger.this.eventSink = null;
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onListen(@Nullable Object arguments, @NotNull EventChannel.EventSink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            DartMessenger.this.eventSink = sink;
        }
    }

    public DartMessenger(@Nullable BinaryMessenger binaryMessenger, long j) {
        new EventChannel(binaryMessenger, "pose_estimation/cameraEvents" + j).setStreamHandler(new a());
    }

    public final void b(@NotNull EventType eventType, @Nullable String description) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        if (this.eventSink == null) {
            return;
        }
        HashMap map = new HashMap();
        String string = eventType.toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        map.put("eventType", lowerCase);
        if (eventType == EventType.ERROR && !TextUtils.isEmpty(description)) {
            map.put("errorDescription", description);
        }
        EventChannel.EventSink eventSink = this.eventSink;
        if (eventSink != null) {
            eventSink.success(map);
        }
    }

    public final void c() {
        b(EventType.CAMERA_CLOSING, null);
    }
}
