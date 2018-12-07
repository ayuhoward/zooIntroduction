package tw.lee.howard.zoodemo.venuelist.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tw.lee.howard.zoodemo.R;
import tw.lee.howard.zoodemo.databinding.VenueInfoBinding;
import tw.lee.howard.zoodemo.venuelist.viewmodel.VenueInfoViewModel;
import tw.lee.howard.zoodemo.venuelist.model.VenueModel;

public class VenueInfoFragment extends Fragment {

    VenueInfoBinding binding;
    VenueInfoViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(VenueInfoViewModel.class);
        binding = DataBindingUtil.inflate(inflater,R.layout.venueinfo_fragment, container, false);
        binding.setViewModel(mViewModel);
        mViewModel.setModel(((VenueModel)getArguments().getSerializable("venue")));

        setTitle(mViewModel.title);

        mViewModel.fetchPlantList();

        binding.venueinfoDetail.openLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityActionView(mViewModel.url);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewModel.clear();
    }

    private void startActivityActionView(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    private void setTitle(String title){
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
    }
}
