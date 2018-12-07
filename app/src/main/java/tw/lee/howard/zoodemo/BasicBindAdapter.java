package tw.lee.howard.zoodemo;

import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class BasicBindAdapter {

    @BindingAdapter("gridSize")
    public static void setGridSize(RecyclerView view,int size){
        if(size<=1)
            view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        else
            view.setLayoutManager(new GridLayoutManager(view.getContext(),size));
    }
    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView view,RecyclerView.Adapter adapter){
        view.setAdapter(adapter);
    }

}
