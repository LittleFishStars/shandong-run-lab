package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class Exif {
    public static final long INVALID_TIMESTAMP = -1;
    private static final String KILOMETERS_PER_HOUR = "K";
    private static final String KNOTS = "N";
    private static final String MILES_PER_HOUR = "M";
    private static final String TAG = "Exif";
    private final ExifInterface mExifInterface;
    private boolean mRemoveTimestamp = false;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.1
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.2
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.3
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    };
    private static final List<String> ALL_EXIF_TAGS = getAllExifTags();
    private static final List<String> DO_NOT_COPY_EXIF_TAGS = Arrays.asList("ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation");

    public static final class Speed {

        public static final class Converter {
            final double mMph;

            public Converter(double d) {
                this.mMph = d;
            }

            public double toMetersPerSecond() {
                return this.mMph / 2.23694d;
            }
        }

        private Speed() {
        }

        public static Converter fromKilometersPerHour(double d) {
            return new Converter(d * 0.621371d);
        }

        public static Converter fromKnots(double d) {
            return new Converter(d * 1.15078d);
        }

        public static Converter fromMilesPerHour(double d) {
            return new Converter(d);
        }
    }

    private Exif(ExifInterface exifInterface) {
        this.mExifInterface = exifInterface;
    }

    private void attachLastModifiedTimestamp() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strConvertToExifDateTime = convertToExifDateTime(jCurrentTimeMillis);
        this.mExifInterface.setAttribute("DateTime", strConvertToExifDateTime);
        try {
            this.mExifInterface.setAttribute("SubSecTime", Long.toString(jCurrentTimeMillis - convertFromExifDateTime(strConvertToExifDateTime).getTime()));
        } catch (ParseException unused) {
        }
    }

    private static Date convertFromExifDate(String str) throws ParseException {
        return DATE_FORMAT.get().parse(str);
    }

    private static Date convertFromExifDateTime(String str) throws ParseException {
        return DATETIME_FORMAT.get().parse(str);
    }

    private static Date convertFromExifTime(String str) throws ParseException {
        return TIME_FORMAT.get().parse(str);
    }

    private static String convertToExifDateTime(long j) {
        return DATETIME_FORMAT.get().format(new Date(j));
    }

    @NonNull
    public static Exif createFromFile(@NonNull File file) throws IOException {
        return createFromFileString(file.toString());
    }

    @NonNull
    public static Exif createFromFileString(@NonNull String str) throws IOException {
        return new Exif(new ExifInterface(str));
    }

    @NonNull
    public static Exif createFromImageProxy(@NonNull ImageProxy imageProxy) throws IOException {
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        buffer.rewind();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.get(bArr);
        return createFromInputStream(new ByteArrayInputStream(bArr));
    }

    @NonNull
    public static Exif createFromInputStream(@NonNull InputStream inputStream) throws IOException {
        return new Exif(new ExifInterface(inputStream));
    }

    @NonNull
    public static List<String> getAllExifTags() {
        return Arrays.asList("ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation", "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType");
    }

    private long parseTimestamp(@Nullable String str, @Nullable String str2) {
        if (str == null && str2 == null) {
            return -1L;
        }
        if (str2 == null) {
            try {
                return convertFromExifDate(str).getTime();
            } catch (ParseException unused) {
                return -1L;
            }
        }
        if (str == null) {
            try {
                return convertFromExifTime(str2).getTime();
            } catch (ParseException unused2) {
                return -1L;
            }
        }
        return parseTimestamp(str + " " + str2);
    }

    public void attachLocation(@NonNull Location location) {
        this.mExifInterface.setGpsInfo(location);
    }

    public void attachTimestamp() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strConvertToExifDateTime = convertToExifDateTime(jCurrentTimeMillis);
        this.mExifInterface.setAttribute("DateTimeOriginal", strConvertToExifDateTime);
        this.mExifInterface.setAttribute("DateTimeDigitized", strConvertToExifDateTime);
        try {
            String string = Long.toString(jCurrentTimeMillis - convertFromExifDateTime(strConvertToExifDateTime).getTime());
            this.mExifInterface.setAttribute("SubSecTimeOriginal", string);
            this.mExifInterface.setAttribute("SubSecTimeDigitized", string);
        } catch (ParseException unused) {
        }
        this.mRemoveTimestamp = false;
    }

    public void copyToCroppedImage(@NonNull Exif exif) {
        ArrayList<String> arrayList = new ArrayList(ALL_EXIF_TAGS);
        arrayList.removeAll(DO_NOT_COPY_EXIF_TAGS);
        for (String str : arrayList) {
            String attribute = this.mExifInterface.getAttribute(str);
            String attribute2 = exif.mExifInterface.getAttribute(str);
            if (attribute != null && !attribute.equals(attribute2)) {
                exif.mExifInterface.setAttribute(str, attribute);
            }
        }
    }

    public void flipHorizontally() {
        int i;
        switch (getOrientation()) {
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 2;
                break;
        }
        this.mExifInterface.setAttribute("Orientation", String.valueOf(i));
    }

    public void flipVertically() {
        int i;
        switch (getOrientation()) {
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                i = 1;
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 4;
                break;
        }
        this.mExifInterface.setAttribute("Orientation", String.valueOf(i));
    }

    @Nullable
    public String getDescription() {
        return this.mExifInterface.getAttribute("ImageDescription");
    }

    @NonNull
    @VisibleForTesting
    public ExifInterface getExifInterface() {
        return this.mExifInterface;
    }

    public int getHeight() {
        return this.mExifInterface.getAttributeInt("ImageLength", 0);
    }

    public long getLastModifiedTimestamp() {
        long timestamp = parseTimestamp(this.mExifInterface.getAttribute("DateTime"));
        if (timestamp == -1) {
            return -1L;
        }
        String attribute = this.mExifInterface.getAttribute("SubSecTime");
        if (attribute == null) {
            return timestamp;
        }
        try {
            long j = Long.parseLong(attribute);
            while (j > 1000) {
                j /= 10;
            }
            return timestamp + j;
        } catch (NumberFormatException unused) {
            return timestamp;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0092  */
    @Nullable
    public Location getLocation() {
        byte b;
        double metersPerSecond;
        String attribute = this.mExifInterface.getAttribute("GPSProcessingMethod");
        double[] latLong = this.mExifInterface.getLatLong();
        double altitude = this.mExifInterface.getAltitude(AudioStats.AUDIO_AMPLITUDE_NONE);
        double attributeDouble = this.mExifInterface.getAttributeDouble("GPSSpeed", AudioStats.AUDIO_AMPLITUDE_NONE);
        String attribute2 = this.mExifInterface.getAttribute("GPSSpeedRef");
        if (attribute2 == null) {
            attribute2 = "K";
        }
        long timestamp = parseTimestamp(this.mExifInterface.getAttribute("GPSDateStamp"), this.mExifInterface.getAttribute("GPSTimeStamp"));
        if (latLong == null) {
            return null;
        }
        if (attribute == null) {
            attribute = TAG;
        }
        Location location = new Location(attribute);
        location.setLatitude(latLong[0]);
        location.setLongitude(latLong[1]);
        if (altitude != AudioStats.AUDIO_AMPLITUDE_NONE) {
            location.setAltitude(altitude);
        }
        if (attributeDouble != AudioStats.AUDIO_AMPLITUDE_NONE) {
            int iHashCode = attribute2.hashCode();
            if (iHashCode != 75) {
                if (iHashCode != 77) {
                    if (iHashCode == 78 && attribute2.equals("N")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (attribute2.equals("M")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (attribute2.equals("K")) {
                b = 2;
            } else {
                b = -1;
            }
            if (b != 0) {
                metersPerSecond = b != 1 ? Speed.fromKilometersPerHour(attributeDouble).toMetersPerSecond() : Speed.fromKnots(attributeDouble).toMetersPerSecond();
            } else {
                metersPerSecond = Speed.fromMilesPerHour(attributeDouble).toMetersPerSecond();
            }
            location.setSpeed((float) metersPerSecond);
        }
        if (timestamp != -1) {
            location.setTime(timestamp);
        }
        return location;
    }

    public int getOrientation() {
        return this.mExifInterface.getAttributeInt("Orientation", 0);
    }

    public int getRotation() {
        switch (getOrientation()) {
            case 3:
            case 4:
                return 180;
            case 5:
                return 270;
            case 6:
            case 7:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public long getTimestamp() {
        long timestamp = parseTimestamp(this.mExifInterface.getAttribute("DateTimeOriginal"));
        if (timestamp == -1) {
            return -1L;
        }
        String attribute = this.mExifInterface.getAttribute("SubSecTimeOriginal");
        if (attribute == null) {
            return timestamp;
        }
        try {
            long j = Long.parseLong(attribute);
            while (j > 1000) {
                j /= 10;
            }
            return timestamp + j;
        } catch (NumberFormatException unused) {
            return timestamp;
        }
    }

    public int getWidth() {
        return this.mExifInterface.getAttributeInt("ImageWidth", 0);
    }

    public boolean isFlippedHorizontally() {
        return getOrientation() == 2;
    }

    public boolean isFlippedVertically() {
        int orientation = getOrientation();
        return orientation == 4 || orientation == 5 || orientation == 7;
    }

    public void removeLocation() {
        this.mExifInterface.setAttribute("GPSProcessingMethod", null);
        this.mExifInterface.setAttribute("GPSLatitude", null);
        this.mExifInterface.setAttribute("GPSLatitudeRef", null);
        this.mExifInterface.setAttribute("GPSLongitude", null);
        this.mExifInterface.setAttribute("GPSLongitudeRef", null);
        this.mExifInterface.setAttribute("GPSAltitude", null);
        this.mExifInterface.setAttribute("GPSAltitudeRef", null);
        this.mExifInterface.setAttribute("GPSSpeed", null);
        this.mExifInterface.setAttribute("GPSSpeedRef", null);
        this.mExifInterface.setAttribute("GPSDateStamp", null);
        this.mExifInterface.setAttribute("GPSTimeStamp", null);
    }

    public void removeTimestamp() {
        this.mExifInterface.setAttribute("DateTime", null);
        this.mExifInterface.setAttribute("DateTimeOriginal", null);
        this.mExifInterface.setAttribute("DateTimeDigitized", null);
        this.mExifInterface.setAttribute("SubSecTime", null);
        this.mExifInterface.setAttribute("SubSecTimeOriginal", null);
        this.mExifInterface.setAttribute("SubSecTimeDigitized", null);
        this.mRemoveTimestamp = true;
    }

    public void rotate(int i) {
        if (i % 90 != 0) {
            Logger.w(TAG, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", Integer.valueOf(i)));
            this.mExifInterface.setAttribute("Orientation", String.valueOf(0));
            return;
        }
        int i2 = i % 360;
        int orientation = getOrientation();
        while (i2 < 0) {
            i2 += 90;
            switch (orientation) {
                case 2:
                    orientation = 5;
                    break;
                case 3:
                case 8:
                    orientation = 6;
                    break;
                case 4:
                    orientation = 7;
                    break;
                case 5:
                    orientation = 4;
                    break;
                case 6:
                    orientation = 1;
                    break;
                case 7:
                    orientation = 2;
                    break;
                default:
                    orientation = 8;
                    break;
            }
        }
        while (i2 > 0) {
            i2 -= 90;
            switch (orientation) {
                case 2:
                    orientation = 7;
                    break;
                case 3:
                    orientation = 8;
                    break;
                case 4:
                    orientation = 5;
                    break;
                case 5:
                    orientation = 2;
                    break;
                case 6:
                    orientation = 3;
                    break;
                case 7:
                    orientation = 4;
                    break;
                case 8:
                    orientation = 1;
                    break;
                default:
                    orientation = 6;
                    break;
            }
        }
        this.mExifInterface.setAttribute("Orientation", String.valueOf(orientation));
    }

    public void save() throws Throwable {
        if (!this.mRemoveTimestamp) {
            attachLastModifiedTimestamp();
        }
        this.mExifInterface.saveAttributes();
    }

    public void setDescription(@Nullable String str) {
        this.mExifInterface.setAttribute("ImageDescription", str);
    }

    public void setOrientation(int i) {
        this.mExifInterface.setAttribute("Orientation", String.valueOf(i));
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(getRotation()), Boolean.valueOf(isFlippedVertically()), Boolean.valueOf(isFlippedHorizontally()), getLocation(), Long.valueOf(getTimestamp()), getDescription());
    }

    private long parseTimestamp(@Nullable String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return convertFromExifDateTime(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }
}
