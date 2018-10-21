package huang.bling.smartbus.ui.Passenger;

import android.os.AsyncTask;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

import huang.bling.smartbus.global.Constant;
import huang.bling.smartbus.ui.Driver.DriverPresenter;

public class PassengerPresenter implements PassengerContract.Presenter{
    private PassengerContract.View mView;
    private PassengerContract.Model mModel;
    Timer timer;
    Handler updateHandler;

    @Override
    public void startWork() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                mModel.connectServer();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                PassengerData data = mModel.getData();
                mView.updateUi(data);
            }
        }.execute();
        setTimerTask();
    }

    @Override
    public void endWork() {
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                mModel.disconnectServer();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                PassengerData data = mModel.getData();
                mView.updateUi(data);
            }
        }.execute();
        cancelTimerTask();
    }

    // not use
    @Override
    public void requestNewData() {
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                mModel.requestNewData();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                PassengerData data = mModel.getData();
                mView.updateUi(data);
            }
        }.execute();
    }
    @Override
    public void setVM(PassengerContract.View v, PassengerContract.Model m) {
        mView = v;
        mModel = m;
    }
    private void setTimerTask(){
        TimerTask task = new PassengerTimerTask();
        timer = new Timer();
        timer.schedule(task,0, Constant.PassengerUiUpateInterval);
    }
    private void cancelTimerTask(){
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }

    class PassengerTimerTask extends TimerTask{
        @Override
        public void run() {
            mModel.requestNewData();
            updateHandler.sendMessage(null);
        }
    }
}
