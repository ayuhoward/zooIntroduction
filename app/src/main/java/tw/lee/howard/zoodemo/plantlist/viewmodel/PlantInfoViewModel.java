package tw.lee.howard.zoodemo.plantlist.viewmodel;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import tw.lee.howard.zoodemo.BR;
import tw.lee.howard.zoodemo.BaseViewModel;
import tw.lee.howard.zoodemo.plantlist.model.PlantModel;

public class PlantInfoViewModel extends BaseViewModel {
    @Bindable
    public String name_latin;
    @Bindable
    public String name_ch;
    @Bindable
    public String location;
    @Bindable
    public String pic_url;
    @Bindable
    public String name_alias;
    @Bindable
    public String brief;
    @Bindable
    public String identification;
    @Bindable
    public String feature;
    @Bindable
    public String update_time;
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public void setModel(PlantModel model){
        if (model != null) {
            name_ch = model.getName_ch();
            name_latin = model.getName_latin();
            name_alias = model.getName_alias();
            brief = model.getBrief();
            feature = model.getFeature();
            identification = model.getIdentification();
            update_time = model.getUpdate_time();
            pic_url = model.getPic_url();
            notifyChange(BR._all);
        }
    }
}



