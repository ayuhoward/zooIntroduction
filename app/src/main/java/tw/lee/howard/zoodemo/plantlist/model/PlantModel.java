package tw.lee.howard.zoodemo.plantlist.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PlantModel implements Serializable {
    @SerializedName("F_Name_Latin") private String name_latin;
    @SerializedName("F_Name_Ch") private String name_ch;
    @SerializedName("F_Location") private String location;
    @SerializedName("F_Pic01_URL") private String pic_url;
    @SerializedName("F_AlsoKnown") private String name_alias;
    @SerializedName("F_Brief") private String brief;
    @SerializedName("F_Feature") private String identification;
    @SerializedName("F_Function&Application") private String feature;
    @SerializedName("F_Update") private String update_time;

    public String getName_latin() {
        return name_latin;
    }

    public String getName_ch() { return name_ch; }

    public String getLocation() {
        return location;
    }

    public String getPic_url() {
        return pic_url;
    }

    public String getName_alias() {
        return name_alias;
    }

    public String getBrief() {
        return brief;
    }

    public String getIdentification() {
        return identification;
    }

    public String getFeature() {
        return feature;
    }

    public String getUpdate_time() {
        return update_time;
    }
}
