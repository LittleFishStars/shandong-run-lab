package com.ipd.dsp.internal.g;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k extends i<InputStream> {
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = 4;
    public static final int n = 5;
    public static final UriMatcher o;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        o = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public k(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.ipd.dsp.internal.g.i
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InputStream a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamC = c(uri, contentResolver);
        if (inputStreamC != null) {
            return inputStreamC;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    public final InputStream c(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = o.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return a(contentResolver, uri);
            }
            if (iMatch != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return a(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    public final InputStream a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // com.ipd.dsp.internal.g.i
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.ipd.dsp.internal.g.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
