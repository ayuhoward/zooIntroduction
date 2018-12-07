package tw.lee.howard.zoodemo.venuelist.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import tw.lee.howard.zoodemo.R;
import tw.lee.howard.zoodemo.databinding.VenueListBinding;
import tw.lee.howard.zoodemo.venuelist.model.VenueModel;
import tw.lee.howard.zoodemo.venuelist.viewmodel.VenueListViewModel;

public class VenueListFragment extends Fragment {

    private VenueListViewModel mViewModel;
    VenueListBinding binding;

    public static VenueListFragment newInstance() {
        return new VenueListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(VenueListViewModel.class);
        binding = DataBindingUtil.inflate(inflater,R.layout.venuelist_fragment, container, false);
        binding.setViewModel(mViewModel);

        mViewModel.setAdapterListener(view->{
            Bundle bundle = new Bundle();
            bundle.putSerializable("venue", (VenueModel)view.getTag());
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_venueList_to_venueInfoFragment,bundle);
        });

        mViewModel.fetchVenueList();

        return binding.getRoot();
    }


}
