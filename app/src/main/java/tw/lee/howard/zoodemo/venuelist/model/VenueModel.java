package tw.lee.howard.zoodemo.venuelist.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VenueModel implements Serializable {
    /*
        E_Pic_URL
        E_Geo
        E_Info
        E_no
        E_Category
        E_Name
        E_Memo
        E_URL
    */
    @SerializedName("E_Name") private String title;
    @SerializedName("E_Info") private String content;
    @SerializedName("E_no") private String id;
    @SerializedName("E_Category") private String category;
    @SerializedName("E_URL") private String url;
    @SerializedName("E_Pic_URL") private String picurl;
    @SerializedName("E_Geo") private String location;
    @SerializedName("E_Memo") private String time;

    public String getTitle() { return title; }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getUrl() {
        return url;
    }

    public String getPicurl() {
        return picurl;
    }

    public String getLocation() {
        return location;
    }

}
