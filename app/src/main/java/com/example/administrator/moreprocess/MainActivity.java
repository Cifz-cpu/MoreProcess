package com.example.administrator.moreprocess;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.moreprocess.data.PushMessageModel;

public class MainActivity extends AppCompatActivity {

    private PushMessage pushMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpService();
    }

    private void setUpService() {
        Intent intent = new Intent(this, NewService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        startService(intent);
    }

    IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            Log.e("AIDLAIDL", "binder died");
            if (pushMessage != null) {
                pushMessage.asBinder().unlinkToDeath(this, 0);
                pushMessage = null;
            }
            setUpService();
        }
    };

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pushMessage = PushMessage.Stub.asInterface(iBinder);
            PushMessageModel pushMessageModel = new PushMessageModel();
            pushMessageModel.setTitle("推送消息");
            pushMessageModel.setMessage("我是一条消息但和你不是一个进程的");
            try {
                pushMessage.asBinder().linkToDeath(deathRecipient,0);
                pushMessage.pushMessage(pushMessageModel);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

}
