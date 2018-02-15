package com.snow.yp.demo.tempdemo;

import rehanced.com.simpleetherwallet.receiver.TransactionStatusReceiver;
import rehanced.com.simpleetherwallet.utils.MyLog;

/**
 * Created by y on 2018/2/9.
 */

public class MyTransactionStatusReceiver extends TransactionStatusReceiver {

    @Override
    public void onFail(String requestUUid, String txHash) {
        MyLog.i("requestUUid:" + requestUUid + "txHash" + txHash);
    }

    @Override
    public void onBuildSuccess(String requestUUid, String txHash) {
        MyLog.i("requestUUid:" + requestUUid + "txHash" + txHash);

    }

    @Override
    public void onTxSuccess(String requestUUid, String txHash) {
        MyLog.i("requestUUid:" + requestUUid + "txHash" + txHash);

    }
}
