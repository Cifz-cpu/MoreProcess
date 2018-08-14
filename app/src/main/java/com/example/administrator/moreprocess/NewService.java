package com.example.administrator.moreprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.administrator.moreprocess.data.PushMessageModel;

/**
 * Author : cifz
 * Time : 2018/8/14
 * e_mail : wangzhen1798@gmail.com
 * function:
 */
public class NewService extends Service {

    public NewService() {
    }

    IBinder pushMessage  = new PushMessage.Stub(){

        @Override
        public void pushMessage(PushMessageModel pushMessageModel) throws RemoteException {
            Log.e("AIDLAIDL",pushMessageModel.getTitle()+pushMessageModel.getMessage());
        }

        @Override
        public IBinder asBinder() {
            return super.asBinder();
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return pushMessage;
    }
}
