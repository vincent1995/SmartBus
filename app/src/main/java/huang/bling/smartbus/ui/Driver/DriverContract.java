package huang.bling.smartbus.ui.Driver;

public interface DriverContract {
    interface Model{
        void requestNewData();
        void connectServer();
        void disconnectServer();
        DriverData getData();
    }

    interface View{
        void updateUi(DriverData data);
    }

    interface Presenter{
        void startWork();
        void endWork();
        void requestNewData();
        void setVM(DriverContract.View v,DriverContract.Model m);
    }
}
