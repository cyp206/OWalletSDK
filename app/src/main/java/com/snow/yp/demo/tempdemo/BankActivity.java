package com.snow.yp.demo.tempdemo;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import rehanced.com.simpleetherwallet.WalletSDK;
import rehanced.com.simpleetherwallet.activities.WalletMainActivity;

import static rehanced.com.simpleetherwallet.WalletSDK.getWalletAddress;

public class BankActivity extends AppCompatActivity {


    @BindView(R.id.btn_generate_new_wallet)
    Button btnGenerateNewWallet;
    @BindView(R.id.btn_get_eth_coin)
    Button btnGetEthCoin;
    @BindView(R.id.btn_transaction_ocn)
    Button btnTransactionOcn;
    @BindView(R.id.btn_transaction_eth)
    Button btnTransactionEth;
    @BindView(R.id.btn_summary)
    Button btnSummary;
    @BindView(R.id.btn_transaction_specify)
    Button btnTransactionSpecify;

    private BroadcastReceiver receiver = new MyTransactionStatusReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //钱包创建
        btnGenerateNewWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WalletSDK.generateWallet(BankActivity.this);
            }
        });
        //token 列表
        btnGetEthCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WalletSDK.openOwnWallet(BankActivity.this);

            }
        });
        //OCN交易
        btnTransactionOcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WalletSDK.sendTransaction(BankActivity.this, getWalletAddress(BankActivity.this), "0xd1bcbe82f40a9d7fbcbd28cca6043d72d66d8e9d");
            }
        });
        //以太币交易

        btnTransactionEth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WalletSDK.sendTransaction(BankActivity.this, getWalletAddress(BankActivity.this), null);

            }
        });
        btnSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                test();
                WalletMainActivity.startMainActivity(BankActivity.this);
            }
        });

        final String testAddress = "0x14fef048b878132c4cdcf7819a66b1eaa9ce8fc2";
        btnTransactionSpecify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WalletSDK.sendTransaction(BankActivity.this, getWalletAddress(BankActivity.this), testAddress, null, 2 + "");

            }
        });

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("TX_ACTION");
        this.registerReceiver(receiver, intentFilter);

    }


    @Override
    protected void onDestroy() {
        if (receiver != null)
            this.unregisterReceiver(receiver);
        super.onDestroy();
    }


}
