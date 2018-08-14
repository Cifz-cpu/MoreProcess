// PushMessage.aidl
package com.example.administrator.moreprocess;
import com.example.administrator.moreprocess.data.PushMessageModel;

// Declare any non-default types here with import statements

interface PushMessage {
    void pushMessage(in PushMessageModel pushMessageModel);
}
