package cn.cqjtu.lexian.model;

public class Address extends AddressKey {
    private String addressstr;

    private String addressphone;

    private String addressname;

    private String addresspost;

    public String getAddressstr() {
        return addressstr;
    }

    public void setAddressstr(String addressstr) {
        this.addressstr = addressstr == null ? null : addressstr.trim();
    }

    public String getAddressphone() {
        return addressphone;
    }

    public void setAddressphone(String addressphone) {
        this.addressphone = addressphone == null ? null : addressphone.trim();
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname == null ? null : addressname.trim();
    }

    public String getAddresspost() {
        return addresspost;
    }

    public void setAddresspost(String addresspost) {
        this.addresspost = addresspost == null ? null : addresspost.trim();
    }
}