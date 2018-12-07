package tw.lee.howard.zoodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        setActionBar();
        setupNavigation();
    }

    private void setActionBar(){
        setSupportActionBar(findViewById(R.id.toolbar));
        ((Toolbar)findViewById(R.id.toolbar)).setNavigationOnClickListener(view->Navigation.findNavController(this,R.id.container).navigateUp());

    }

    private void setupNavigation() {
        NavController navController = Navigation.findNavController(this,R.id.container);
        setupActionBarWithNavController(navController);
    }

    private void setupActionBarWithNavController(NavController navController){
        NavigationUI.setupActionBarWithNavController(this,navController);
    }


}
