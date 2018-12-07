package tw.lee.howard.zoodemo.venuelist.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tw.lee.howard.zoodemo.R;
import tw.lee.howard.zoodemo.databinding.VenueItemBinding;
import tw.lee.howard.zoodemo.venuelist.model.VenueModel;
import tw.lee.howard.zoodemo.venuelist.viewmodel.VenueItemViewModel;

public class VenueItemAdapter extends RecyclerView.Adapter<VenueItemAdapter.ViewHolder> {

    List<VenueModel> data = new ArrayList<>();
    View.OnClickListener listener;

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.venue_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setListener(listener);
        holder.setModel(data.get(position));
    }

    public void updateData(List<VenueModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        View.OnClickListener listener;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setListener(View.OnClickListener listener){
            this.listener = listener;
        }

        public void setModel(VenueModel model){
            VenueItemBinding binding = DataBindingUtil.bind(itemView);
            VenueItemViewModel venueItemViewModel = new VenueItemViewModel();
            binding.setViewModel(venueItemViewModel);
            binding.btnMore.setOnClickListener(view->{
                //view.setTag(model.getTitle());
                view.setTag(model);
                if(listener!=null)
                    listener.onClick(view);
            });
            venueItemViewModel.setModel(model);
        }
    }
}
