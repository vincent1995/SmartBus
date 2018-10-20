package huang.bling.smartbus.ui.Passenger;

public class PassengerModel implements PassengerContract.Model{
    PassengerData data;
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
    public PassengerData getData() {
        return data;
    }
}
