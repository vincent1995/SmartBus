package huang.bling.smartbus.ui.Driver;

public class DriverModel implements DriverContract.Model{
    DriverData data;
    DriverModel(){
        data = new DriverData();
    }
    @Override
    public void requestNewData() {
    }

    @Override
    public void connectServer() {
    }

    @Override
    public void disconnectServer() {
    }

    @Override
    public DriverData getData() {
        return data;
    }

}
