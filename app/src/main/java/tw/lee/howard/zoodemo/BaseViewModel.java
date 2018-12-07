package tw.lee.howard.zoodemo;

import android.arch.lifecycle.ViewModel;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

public class BaseViewModel extends ViewModel implements Observable {

    private PropertyChangeRegistry registry =
            new PropertyChangeRegistry();

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        registry.add(callback);
    }

    public void notifyChange(int propertyId){
        registry.notifyChange(this,propertyId);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        registry.remove(callback);
    }
}
