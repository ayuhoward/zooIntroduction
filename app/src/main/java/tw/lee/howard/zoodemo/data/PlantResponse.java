package tw.lee.howard.zoodemo.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tw.lee.howard.zoodemo.data.entry.Result;
import tw.lee.howard.zoodemo.plantlist.model.PlantModel;

public class PlantResponse {
    @SerializedName("result")
    private Result<PlantModel> resultWithPlant;
    public List<PlantModel> getPlantList() {
        return resultWithPlant.getResults();
    }
}
