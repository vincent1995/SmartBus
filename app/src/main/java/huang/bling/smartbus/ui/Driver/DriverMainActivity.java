package huang.bling.smartbus.ui.Driver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import huang.bling.smartbus.R;

public class DriverMainActivity extends AppCompatActivity implements DriverContract.View{
    DriverContract.Model mModel;
    DriverContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_driver);
        mModel = new DriverModel();
        mPresenter = new DriverPresenter();
        mPresenter.setVM(this,mModel);
        initView();
    }
    private void initView(){
        Toolbar toolBar= (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        toolBar.setTitleTextColor(getResources().getColor(R.color.white));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.start:
                break;
            case R.id.end:
                break;
            case R.id.nav_about:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void updateUi(DriverData data) {

    }
}
