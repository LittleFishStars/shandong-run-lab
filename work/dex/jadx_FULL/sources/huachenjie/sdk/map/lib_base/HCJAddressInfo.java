package huachenjie.sdk.map.lib_base;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class HCJAddressInfo implements Comparable<HCJAddressInfo> {
    private float accuracy;
    private String adCode;
    private String adName;
    private String address;
    private double altitude;
    private String aoiName;
    private String building;
    private String cityCode;
    private String cityName;
    private String countryName;
    private float direction;
    private int gpsStatus;
    private boolean isFromMockProvider;
    private boolean isMock;
    private double lat;
    private double lng;
    private String neighborhood;
    private String originCityCode;
    private String originCityName;
    private String poiId;
    private String poiName;
    private String provider;
    private String provinceName;
    private int satellites;
    private float speed;
    private String street;
    private String streetNumber;
    private long time;
    private String title;
    private String township;

    public static HCJAddressInfo copy(HCJAddressInfo hCJAddressInfo) {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(HCJAddressInfo hCJAddressInfo) {
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public String getAdCode() {
        return this.adCode;
    }

    public String getAdName() {
        return this.adName;
    }

    public String getAddress() {
        return this.address;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public String getAoiName() {
        return this.aoiName;
    }

    public String getBuilding() {
        return this.building;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public float getDirection() {
        return this.direction;
    }

    public int getGpsStatus() {
        return this.gpsStatus;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public String getNeighborhood() {
        return this.neighborhood;
    }

    public String getOriginCityCode() {
        return this.originCityCode;
    }

    public String getOriginCityName() {
        return this.originCityName;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public int getSatellites() {
        return this.satellites;
    }

    public float getSpeed() {
        return this.speed;
    }

    public String getStreet() {
        return this.street;
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTownship() {
        return this.township;
    }

    public boolean isFromMockProvider() {
        return this.isFromMockProvider;
    }

    public boolean isMock() {
        return this.isMock;
    }

    public void setAccuracy(float f) {
        this.accuracy = f;
    }

    public void setAdCode(String str) {
        this.adCode = str;
    }

    public void setAdName(String str) {
        this.adName = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }

    public void setAoiName(String str) {
        this.aoiName = str;
    }

    public void setBuilding(String str) {
        this.building = str;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setDirection(float f) {
        this.direction = f;
    }

    public void setFromMockProvider(boolean z) {
        this.isFromMockProvider = z;
    }

    public void setGpsStatus(int i) {
        this.gpsStatus = i;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public void setMock(boolean z) {
        this.isMock = z;
    }

    public void setNeighborhood(String str) {
        this.neighborhood = str;
    }

    public void setOriginCityCode(String str) {
        this.originCityCode = str;
    }

    public void setOriginCityName(String str) {
        this.originCityName = str;
    }

    public void setPoiId(String str) {
        this.poiId = str;
    }

    public void setPoiName(String str) {
        this.poiName = str;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public void setProvinceName(String str) {
        this.provinceName = str;
    }

    public void setSatellites(int i) {
        this.satellites = i;
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public void setStreetNumber(String str) {
        this.streetNumber = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTownship(String str) {
        this.township = str;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(HCJAddressInfo hCJAddressInfo) {
    }
}
