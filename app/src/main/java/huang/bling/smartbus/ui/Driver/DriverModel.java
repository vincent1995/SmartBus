package huang.bling.smartbus.ui.Driver;

public class DriverModel implements DriverContract.Model{
    DriverData data;
    DriverModel(){
        data = new DriverData();
    }
    @Override
    public void requestNewData() {
        data.value ++;
    }

    @Override
    public void connectServer() {
        data.value = 0;
    }

    @Override
    public void disconnectServer() {
        data.value = 0;
    }

    @Override
    public DriverData getData() {
        return data;
    }

}
