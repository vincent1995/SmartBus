package huang.bling.smartbus.ui.Passenger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import huang.bling.smartbus.R;

public class PassengerMainActivity extends AppCompatActivity implements PassengerContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_main);
    }

    @Override
    public void updateUi(PassengerData data) {

    }
}
