package com.statusmaker_photoeditor_music.videoplayer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.royalplayer.lite.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class SpinnerActivity extends AppCompatActivity {

    TextView tvCoin;
    Context context;
    private RewardedAd mRewardedAd;
    List<LuckyItem> data = new ArrayList<>();
    AppCompatButton btnSpin, btnAd;
    String date = "";
    String curr = "";
    ProgressBar pb;
    SharedPreferences sh, sharedPreferences;
    SharedPreferences.Editor myEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        pb = findViewById(R.id.pb);
        btnSpin = findViewById(R.id.btnSpin);
        btnAd = findViewById(R.id.btnAd);
        context = getApplicationContext();
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        curr = df.format(c);
        //Toast.makeText(getApplicationContext(), curr, Toast.LENGTH_LONG).show();
        sh = getSharedPreferences("Coins", MODE_APPEND);
        tvCoin = findViewById(R.id.tvCoin);

        tvCoin.setText(sh.getInt("Number", 0) + "");
        date = sh.getString("Date", "");
        if (date.equals(curr) == true) {
            btnAd.setVisibility(View.VISIBLE);
            btnSpin.setEnabled(false);
        } else {
            btnAd.setVisibility(View.GONE);
            btnSpin.setEnabled(true);
        }
        sharedPreferences = getSharedPreferences("Coins", MODE_PRIVATE);
        myEdit = sharedPreferences.edit();
        LuckyWheelView luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);

        LuckyItem luckyItem1 = new LuckyItem();
        luckyItem1.topText = "0";
        luckyItem1.icon = R.drawable.coin;
        luckyItem1.color = R.color.red;
        data.add(luckyItem1);

        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.topText = "500";
        luckyItem2.icon = R.drawable.coin;
        luckyItem2.color = 0xFFFF7000;
        data.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.topText = "0";
        luckyItem3.icon = R.drawable.coin;
        luckyItem3.color = 0xFFFFEC00;
        data.add(luckyItem3);

        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.topText = "30";
        luckyItem4.icon = R.drawable.coin;
        luckyItem4.color = 0xFF00A6FF;
        data.add(luckyItem4);

        LuckyItem luckyItem5 = new LuckyItem();
        luckyItem5.topText = "350";
        luckyItem5.icon = R.drawable.coin;
        luckyItem5.color = 0xFF00BE1A;
        data.add(luckyItem5);

        LuckyItem luckyItem6 = new LuckyItem();
        luckyItem6.topText = "0";
        luckyItem6.icon = R.drawable.coin;
        luckyItem6.color = 0xFF00FF80;
        data.add(luckyItem6);

        LuckyItem luckyItem7 = new LuckyItem();
        luckyItem7.topText = "0";
        luckyItem7.icon = R.drawable.coin;
        luckyItem7.color = 0xFFFF6800;
        data.add(luckyItem7);

        LuckyItem luckyItem8 = new LuckyItem();
        luckyItem8.topText = "0";
        luckyItem8.icon = R.drawable.coin;
        luckyItem8.color = 0xFFA600FF;
        data.add(luckyItem8);


        LuckyItem luckyItem9 = new LuckyItem();
        luckyItem9.topText = "62";
        luckyItem9.icon = R.drawable.coin;
        luckyItem9.color = 0xFF000FFF;
        data.add(luckyItem9);
        ////////////////////////

        LuckyItem luckyItem10 = new LuckyItem();
        luckyItem10.topText = "5";
        luckyItem10.icon = R.drawable.coin;
        luckyItem10.color = 0xFFFFCD00;
        data.add(luckyItem10);

        LuckyItem luckyItem11 = new LuckyItem();
        luckyItem11.topText = "10";
        luckyItem11.icon = R.drawable.coin;
        luckyItem11.color = 0xFFF03131;
        data.add(luckyItem11);

        LuckyItem luckyItem12 = new LuckyItem();
        luckyItem12.topText = "0";
        luckyItem12.icon = R.drawable.coin;
        luckyItem12.color = 0xFFF56800;
        data.add(luckyItem12);

        luckyWheelView.setData(data);
        luckyWheelView.setRound(5);
        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        AdRequest adRequest = new AdRequest.Builder().build();
                        RewardedAd.load(context, "ca-app-pub-1071420265996072/3028101324",
                                adRequest, new RewardedAdLoadCallback() {
                                    @Override
                                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                        // Handle the error.
                                        Toast.makeText(context, "Failed to Load Ad.", Toast.LENGTH_SHORT).show();
                                        Log.d("TAG", loadAdError.getMessage());
                                        mRewardedAd = null;
                                    }

                                    @Override
                                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                        pb.setVisibility(View.GONE);
                                        mRewardedAd = rewardedAd;
                                        //Toast.makeText(context,"6",Toast.LENGTH_SHORT).show();
                                        Log.d("TAG", "Ad was loaded.");
                                        try {
                                            mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                                @Override
                                                public void onAdShowedFullScreenContent() {
                                                    //Toast.makeText(context,"1",Toast.LENGTH_SHORT).show();
                                                }

                                                @Override
                                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                                    //Toast.makeText(context,"2",Toast.LENGTH_SHORT).show();
                                                }

                                                @Override
                                                public void onAdDismissedFullScreenContent() {
                                                    //Toast.makeText(context,"3",Toast.LENGTH_SHORT).show();
                                                    mRewardedAd = null;
                                                }
                                            });

                                            if (mRewardedAd != null) {
                                                mRewardedAd.show(SpinnerActivity.this, new OnUserEarnedRewardListener() {
                                                            @Override
                                                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                                                int rewardAmount = rewardItem.getAmount();
                                                                String rewardType = rewardItem.getType();
                                                                btnAd.setVisibility(View.GONE);
                                                                btnSpin.setEnabled(true);
                                                                date = "";
                                                                myEdit.putString("Date", "");
                                                                myEdit.commit();
                                                            }
                                                        }
                                                );
                                            } else {
                                                Log.d("TAG", "The rewarded ad wasn't ready yet.");
                                                Toast.makeText(context, "The rewarded ad wasn't ready yet.", Toast.LENGTH_LONG).show();
                                            }

                                        } catch (Exception e) {
                                            Toast.makeText(context, "1" + e, Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                    }
                }, 2000);


            }
        });
        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int index = getRandomIndex();
                luckyWheelView.startLuckyWheelWithTargetIndex(index);

            }
        });

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                if (curr.equals(sh.getString("Date", ""))) {
                    Toast.makeText(getApplicationContext(), "Watch Ad to get more spins.", Toast.LENGTH_SHORT).show();

                } else {
                    int b = Integer.parseInt(data.get(index).topText);
                    int a = Integer.parseInt(data.get(index).topText) + sh.getInt("Number", 0);
                    myEdit.putInt("Number", a);
                    myEdit.commit();
                    tvCoin.setText(a + "");
                    if (b == 0) {
                        Toast.makeText(getApplicationContext(), "Better Luck Next Time", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Congrats!! You Won " + b + " Coins", Toast.LENGTH_SHORT).show();

                    }
                    date = curr;
                    myEdit.putString("Date", curr);
                    myEdit.commit();
                    btnAd.setVisibility(View.VISIBLE);
                    btnSpin.setEnabled(false);
                }
            }
        });
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size() - 1) + 0;
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }

}