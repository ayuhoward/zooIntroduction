package tw.lee.howard.zoodemo.data;

import tw.lee.howard.zoodemo.data.entry.Result;
import tw.lee.howard.zoodemo.venuelist.model.VenueModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VenueResponse {
    @SerializedName("result")
    private Result<VenueModel> resultWithVenue;
    public List<VenueModel> getVenueList() {
        return resultWithVenue.getResults();
    }
}
