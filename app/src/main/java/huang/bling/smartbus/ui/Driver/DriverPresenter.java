package huang.bling.smartbus.ui.Driver;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

import huang.bling.smartbus.global.Constant;

public class DriverPresenter  implements DriverContract.Presenter{
    DriverContract.Model mModel;
    DriverContract.View mView;
    Timer timer;
    Handler updateHandler;

    DriverPresenter(){
        updateHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                DriverData data = mModel.getData();
                mView.updateUi(data);
            }
        };
        timer = null;
    }

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
                DriverData data = mModel.getData();
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
                DriverData data = mModel.getData();
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
                DriverData data = mModel.getData();
                mView.updateUi(data);
            }
        }.execute();
    }

    @Override
    public void setVM(DriverContract.View v, DriverContract.Model m) {
        mView = v;
        mModel = m;
    }

    private void setTimerTask(){
        if(timer == null){
            TimerTask task = new DriverTimerTask();
            timer = new Timer();
            timer.schedule(task,0, Constant.DriverUiUpdateInterval);
        }
    }
    private void cancelTimerTask(){
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }

    class DriverTimerTask extends TimerTask{
        @Override
        public void run() {
            mModel.requestNewData();
            updateHandler.sendMessage(new Message());
        }
    }
}

