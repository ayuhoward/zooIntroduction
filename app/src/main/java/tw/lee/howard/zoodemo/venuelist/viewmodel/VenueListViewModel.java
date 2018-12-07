package tw.lee.howard.zoodemo.venuelist.viewmodel;

import android.databinding.Bindable;
import android.view.View;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import io.reactivex.schedulers.Schedulers;
import tw.lee.howard.zoodemo.BaseViewModel;
import tw.lee.howard.zoodemo.data.DataClient;
import tw.lee.howard.zoodemo.data.VenueResponse;
import tw.lee.howard.zoodemo.data.DataService;
import tw.lee.howard.zoodemo.venuelist.model.VenueModel;
import tw.lee.howard.zoodemo.venuelist.view.VenueItemAdapter;

public class VenueListViewModel extends BaseViewModel {
    private final String TAG = getClass().getName();

    @Bindable
    public VenueItemAdapter venueItemAdapter;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private DataService dataService;

    VenueListViewModel(){
        venueItemAdapter = new VenueItemAdapter();
    }

    public void setAdapterListener(View.OnClickListener listener){
        venueItemAdapter.setOnClickListener(listener);
    }


    public void fetchVenueList() {
        if (dataService == null) dataService = DataClient.create();

        Disposable disposable = dataService.fetchModel(DataClient.ZOO_VENUE_URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<VenueResponse>() {
                    @Override
                    public void accept(VenueResponse venueResponse) throws Exception {
                        changeDataSet(venueResponse.getVenueList());
                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) {

                    }
                });

        if (disposable != null) compositeDisposable.add(disposable);
    }

    private void changeDataSet(List<VenueModel> venueList){
        if (venueList != null){
            venueItemAdapter.updateData(venueList);
        } else {
            System.out.print("venue list is null");
        }

    }
}
