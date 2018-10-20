package huang.bling.smartbus.ui.Driver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import huang.bling.smartbus.R;
import huang.bling.smartbus.ui.uiUtil;

public class DriverMainActivity extends AppCompatActivity implements DriverContract.View{
    DriverContract.Model mModel;
    DriverContract.Presenter mPresenter;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);
        mModel = new DriverModel();
        mPresenter = new DriverPresenter();
        mPresenter.setVM(this,mModel);
        text = findViewById(R.id.textView);

    }

    @Override
    public void updateUi(DriverData data) {
        uiUtil.makeShortToast(this,"UI is updated");
        text.setText(String.valueOf(data.value));
    }

    public void clickStart(View view) {
        uiUtil.makeShortToast(this,"clickButton");
        mPresenter.startWork();
    }

    public void clickEnd(View view) {
        mPresenter.endWork();
    }
}
