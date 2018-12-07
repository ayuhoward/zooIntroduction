package tw.lee.howard.zoodemo.plantlist.viewmodel;

import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import tw.lee.howard.zoodemo.BR;
import tw.lee.howard.zoodemo.BaseViewModel;
import tw.lee.howard.zoodemo.plantlist.model.PlantModel;

public class PlantItemViewModel extends BaseViewModel {

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


    public void setModel(PlantModel model){
        name_ch = model.getName_ch();
        name_alias = model.getName_alias();
        pic_url = model.getPic_url();
        location = model.getLocation();
        brief = model.getBrief();
        notifyChange(BR._all);
    }
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

}
