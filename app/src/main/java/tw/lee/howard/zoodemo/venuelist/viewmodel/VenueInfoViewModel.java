package tw.lee.howard.zoodemo.venuelist.viewmodel;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import tw.lee.howard.zoodemo.BR;
import tw.lee.howard.zoodemo.BaseViewModel;
import tw.lee.howard.zoodemo.data.DataClient;
import tw.lee.howard.zoodemo.data.DataService;
import tw.lee.howard.zoodemo.plantlist.model.PlantModel;
import tw.lee.howard.zoodemo.plantlist.view.PlantItemAdapter;
import tw.lee.howard.zoodemo.venuelist.model.VenueModel;

public class VenueInfoViewModel extends BaseViewModel {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Bindable
    public String title;
    @Bindable
    public String content;
    @Bindable
    public String time;
    @Bindable
    public String picurl;
    @Bindable
    public String category;
    @Bindable
    public String url;
    @Bindable
    public PlantItemAdapter plantItemAdapter;
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public void setModel(VenueModel model){
        title = model.getTitle();
        content = model.getContent();
        time = model.getTime();
        picurl = model.getPicurl();
        category = model.getCategory();
        url = model.getUrl();

        notifyChange(BR._all);
    }

    public VenueInfoViewModel(){
        plantItemAdapter = new PlantItemAdapter();
    }

    public void fetchPlantList() {
        DataService dataService = DataClient.create();
        Disposable disposable = dataService.fetchPlantModel(DataClient.ZOO_PLANT_URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(plantResponse -> changeDataSet(plantResponse.getPlantList()), throwable -> {
                });

        if (compositeDisposable != null) compositeDisposable.add(disposable);
    }

    private void changeDataSet(List<PlantModel> plantList){
        if (plantList != null)
            plantItemAdapter.updateData(mappingPlantItem(plantList));
        else
            System.out.print("plant list is null");
    }

    private List<PlantModel> mappingPlantItem(List<PlantModel> plantList){
        List<PlantModel> mapList = new ArrayList();
        for(PlantModel p : plantList){
            if (p.getLocation().contains(title)){
                mapList.add(p);
            }
        }
        return mapList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
    public void clear() {
        unSubscribeFromObservable();
        compositeDisposable = null;
    }
}



