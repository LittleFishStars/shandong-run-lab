package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class y9c implements ValueEncoderContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FieldDescriptor f45983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k9c f20814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20815a = false;
    public boolean b = false;

    public y9c(k9c k9cVar) {
        this.f20814a = k9cVar;
    }

    public final void a(FieldDescriptor fieldDescriptor, boolean z) {
        this.f20815a = false;
        this.f45983a = fieldDescriptor;
        this.b = z;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(double d) throws IOException {
        b();
        this.f20814a.a(this.f45983a, d, this.b);
        return this;
    }

    public final void b() {
        if (this.f20815a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f20815a = true;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(float f) throws IOException {
        b();
        this.f20814a.b(this.f45983a, f, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(int i) throws IOException {
        b();
        this.f20814a.d(this.f45983a, i, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(long j) throws IOException {
        b();
        this.f20814a.e(this.f45983a, j, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(@Nullable String str) throws IOException {
        b();
        this.f20814a.c(this.f45983a, str, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(boolean z) throws IOException {
        b();
        this.f20814a.d(this.f45983a, z ? 1 : 0, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(@NonNull byte[] bArr) throws IOException {
        b();
        this.f20814a.c(this.f45983a, bArr, this.b);
        return this;
    }
}
