package huang.bling.smartbus.ui.Driver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import huang.bling.smartbus.R;

public class DriverMainActivity extends AppCompatActivity implements DriverContract.View{
    DriverContract.Model mModel;
    DriverContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);
        mModel = new DriverModel();
        mPresenter = new DriverPresenter();
        mPresenter.setVM(this,mModel);

    }

    @Override
    public void updateUi(DriverData data) {

    }
}
