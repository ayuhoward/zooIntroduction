package tw.lee.howard.zoodemo.venuelist.viewmodel;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import tw.lee.howard.zoodemo.BR;
import tw.lee.howard.zoodemo.BaseViewModel;
import tw.lee.howard.zoodemo.venuelist.model.VenueModel;

public class VenueItemViewModel extends BaseViewModel {

    @Bindable
    public String title;
    @Bindable
    public String content;
    @Bindable
    public String time;
    @Bindable
    public String picurl;
    @Bindable
    public String url;
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public void setModel(VenueModel model){
        title = model.getTitle();
        content = model.getContent();
        time = model.getTime();
        picurl = model.getPicurl();
        url = model.getUrl();

        notifyChange(BR._all);
    }


}
