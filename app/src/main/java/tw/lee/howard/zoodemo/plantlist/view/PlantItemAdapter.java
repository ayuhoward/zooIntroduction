package tw.lee.howard.zoodemo.plantlist.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.Navigation;
import tw.lee.howard.zoodemo.R;
import tw.lee.howard.zoodemo.databinding.PlantItemBinding;
import tw.lee.howard.zoodemo.plantlist.model.PlantModel;
import tw.lee.howard.zoodemo.plantlist.viewmodel.PlantItemViewModel;

public class PlantItemAdapter extends RecyclerView.Adapter<PlantItemAdapter.ViewHolder> {

    List<PlantModel> data = new ArrayList<>();
    View.OnClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.plant_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setListener(listener);
        holder.setModel(data.get(position));
    }

    public void updateData(List<PlantModel> data){
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

        public void setModel(PlantModel model){
            PlantItemBinding binding = DataBindingUtil.bind(itemView);
            PlantItemViewModel plantItemViewModel = new PlantItemViewModel();

            binding.setViewModel(plantItemViewModel);
            binding.btnMore.setOnClickListener(view->{
                Bundle bundle = new Bundle();
                bundle.putSerializable("plant", model);
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_venueInfo_to_plantInfoFragment,bundle);
            });

            plantItemViewModel.setModel(model);
        }
    }
}
