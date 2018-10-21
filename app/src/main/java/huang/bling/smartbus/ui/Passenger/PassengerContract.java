package huang.bling.smartbus.ui.Passenger;

public interface PassengerContract {
    interface Model{
        void requestNewData();
        void connectServer();
        void disconnectServer();
        PassengerData getData();
    }

    interface View{
        void updateUi(PassengerData data);
    }

    interface Presenter{
        void startWork();
        void endWork();
        void requestNewData();
        void setVM(PassengerContract.View v,PassengerContract.Model m);
    }
}

