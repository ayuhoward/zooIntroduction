package tw.lee.howard.zoodemo.data;

import retrofit2.http.GET;
import retrofit2.http.Url;
import io.reactivex.Observable;

public interface DataService {
    @GET Observable<VenueResponse> fetchModel(@Url String url);
    @GET Observable<PlantResponse> fetchPlantModel(@Url String url);
}
