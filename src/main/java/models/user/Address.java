package models.user;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address() {

    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getSuite() {
        return suite;
    }

    public Address setSuite(String suite) {
        this.suite = suite;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Address setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public Geo getGeo() {
        return geo;
    }

    public Address setGeo(Geo geo) {
        this.geo = geo;
        return this;
    }

    public static class Geo {
        private double lat;
        private double lng;

        public Geo() {

        }

        public double getLat() {
            return lat;
        }

        public Geo setLat(double lat) {
            this.lat = lat;
            return this;
        }

        public double getLng() {
            return lng;
        }

        public Geo setLng(double lng) {
            this.lng = lng;
            return this;
        }

        @Override
        public String toString() {
            return "Geo{" +
                    "lat=" + lat +
                    ", lng=" + lng +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", geo=" + geo +
                '}';
    }
}
