package tw.lee.howard.zoodemo.plantlist.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tw.lee.howard.zoodemo.R;
import tw.lee.howard.zoodemo.databinding.PlantInfoBinding;
import tw.lee.howard.zoodemo.plantlist.viewmodel.PlantInfoViewModel;
import tw.lee.howard.zoodemo.plantlist.model.PlantModel;


public class PlantInfoFragment extends Fragment {
    PlantInfoBinding binding;
    private PlantInfoViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(PlantInfoViewModel.class);
        mViewModel.setModel(((PlantModel)getArguments().getSerializable("plant")));

        binding = DataBindingUtil.inflate(inflater, R.layout.plantinfo_fragment,container,false);
        binding.setViewModel(mViewModel);

        setTitle(mViewModel.name_ch);

        return binding.getRoot();
    }

    private void setTitle(String title){
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }
}
