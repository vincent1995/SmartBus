package util;

import android.util.Log;

import org.junit.Test;

import bean.DriverBean;

public class DriverNetTest {
    @Test
    public void dataTrans(DriverBean input){
        DriverNetImpl myDriverNet=new DriverNetImpl();
        DriverBean resultBean=myDriverNet.getDriverResponse(5);
        Log.d("Test",Integer.toString(resultBean.getNBusStopLocation()));
    }
}
