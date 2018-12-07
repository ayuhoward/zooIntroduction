package tw.lee.howard.zoodemo.data.entry;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result<T> {
    @SerializedName("limit")
    private int limit;

    @SerializedName("offset")
    private int offset;

    @SerializedName("count")
    private int count;

    @SerializedName("sort")
    private String sort;

    @SerializedName("results")
    private List<T> results;

    public List<T> getResults(){
        return results;
    }
 }

