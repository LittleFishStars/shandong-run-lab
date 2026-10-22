package com.google.android.datatransport.cct.internal;

import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.zj.adlib.ki0;
import com.zj.adlib.ze1;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements Configurator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30403a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Configurator f1885a = new a();

    /* JADX INFO: renamed from: com.google.android.datatransport.cct.internal.a$a, reason: collision with other inner class name */
    public static final class C0664a implements ObjectEncoder<AndroidClientInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0664a f30404a = new C0664a();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final FieldDescriptor f1886a = FieldDescriptor.of("sdkVersion");
        public static final FieldDescriptor b = FieldDescriptor.of(ze1.k);
        public static final FieldDescriptor c = FieldDescriptor.of(ze1.l);
        public static final FieldDescriptor d = FieldDescriptor.of("device");
        public static final FieldDescriptor e = FieldDescriptor.of(ze1.n);
        public static final FieldDescriptor f = FieldDescriptor.of("osBuild");
        public static final FieldDescriptor g = FieldDescriptor.of(ze1.p);
        public static final FieldDescriptor h = FieldDescriptor.of("fingerprint");
        public static final FieldDescriptor i = FieldDescriptor.of(ze1.r);
        public static final FieldDescriptor j = FieldDescriptor.of(ze1.s);
        public static final FieldDescriptor k = FieldDescriptor.of("mccMnc");
        public static final FieldDescriptor l = FieldDescriptor.of("applicationBuild");

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1886a, androidClientInfo.m());
            objectEncoderContext.add(b, androidClientInfo.j());
            objectEncoderContext.add(c, androidClientInfo.f());
            objectEncoderContext.add(d, androidClientInfo.d());
            objectEncoderContext.add(e, androidClientInfo.l());
            objectEncoderContext.add(f, androidClientInfo.k());
            objectEncoderContext.add(g, androidClientInfo.h());
            objectEncoderContext.add(h, androidClientInfo.e());
            objectEncoderContext.add(i, androidClientInfo.g());
            objectEncoderContext.add(j, androidClientInfo.c());
            objectEncoderContext.add(k, androidClientInfo.i());
            objectEncoderContext.add(l, androidClientInfo.b());
        }
    }

    public static final class b implements ObjectEncoder<BatchedLogRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f30405a = new b();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final FieldDescriptor f1887a = FieldDescriptor.of("logRequest");

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1887a, batchedLogRequest.c());
        }
    }

    public static final class c implements ObjectEncoder<ClientInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f30406a = new c();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final FieldDescriptor f1888a = FieldDescriptor.of("clientType");
        public static final FieldDescriptor b = FieldDescriptor.of("androidClientInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1888a, clientInfo.c());
            objectEncoderContext.add(b, clientInfo.b());
        }
    }

    public static final class d implements ObjectEncoder<LogEvent> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f30407a = new d();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final FieldDescriptor f1889a = FieldDescriptor.of("eventTimeMs");
        public static final FieldDescriptor b = FieldDescriptor.of(StrategyEventDBModel.COLUMN_EVENT_CODE);
        public static final FieldDescriptor c = FieldDescriptor.of("eventUptimeMs");
        public static final FieldDescriptor d = FieldDescriptor.of("sourceExtension");
        public static final FieldDescriptor e = FieldDescriptor.of("sourceExtensionJsonProto3");
        public static final FieldDescriptor f = FieldDescriptor.of("timezoneOffsetSeconds");
        public static final FieldDescriptor g = FieldDescriptor.of("networkConnectionInfo");

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1889a, logEvent.c());
            objectEncoderContext.add(b, logEvent.b());
            objectEncoderContext.add(c, logEvent.d());
            objectEncoderContext.add(d, logEvent.f());
            objectEncoderContext.add(e, logEvent.g());
            objectEncoderContext.add(f, logEvent.h());
            objectEncoderContext.add(g, logEvent.e());
        }
    }

    public static final class e implements ObjectEncoder<LogRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f30408a = new e();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final FieldDescriptor f1890a = FieldDescriptor.of("requestTimeMs");
        public static final FieldDescriptor b = FieldDescriptor.of("requestUptimeMs");
        public static final FieldDescriptor c = FieldDescriptor.of("clientInfo");
        public static final FieldDescriptor d = FieldDescriptor.of("logSource");
        public static final FieldDescriptor e = FieldDescriptor.of("logSourceName");
        public static final FieldDescriptor f = FieldDescriptor.of("logEvent");
        public static final FieldDescriptor g = FieldDescriptor.of("qosTier");

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1890a, logRequest.g());
            objectEncoderContext.add(b, logRequest.h());
            objectEncoderContext.add(c, logRequest.b());
            objectEncoderContext.add(d, logRequest.d());
            objectEncoderContext.add(e, logRequest.e());
            objectEncoderContext.add(f, logRequest.c());
            objectEncoderContext.add(g, logRequest.f());
        }
    }

    public static final class f implements ObjectEncoder<NetworkConnectionInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f30409a = new f();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final FieldDescriptor f1891a = FieldDescriptor.of("networkType");
        public static final FieldDescriptor b = FieldDescriptor.of("mobileSubtype");

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1891a, networkConnectionInfo.c());
            objectEncoderContext.add(b, networkConnectionInfo.b());
        }
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        b bVar = b.f30405a;
        encoderConfig.registerEncoder(BatchedLogRequest.class, bVar);
        encoderConfig.registerEncoder(ki0.class, bVar);
        e eVar = e.f30408a;
        encoderConfig.registerEncoder(LogRequest.class, eVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.e.class, eVar);
        c cVar = c.f30406a;
        encoderConfig.registerEncoder(ClientInfo.class, cVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.c.class, cVar);
        C0664a c0664a = C0664a.f30404a;
        encoderConfig.registerEncoder(AndroidClientInfo.class, c0664a);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.b.class, c0664a);
        d dVar = d.f30407a;
        encoderConfig.registerEncoder(LogEvent.class, dVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.d.class, dVar);
        f fVar = f.f30409a;
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, fVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.f.class, fVar);
    }
}
