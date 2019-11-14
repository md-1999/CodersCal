package com.example.coderscal;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import androidx.cardview.widget.CardView;

public class FetchData extends AsyncTask<Void,Void,Void> {
    String data="";
    String singleparsed="";
    ArrayList<String> arrli=new ArrayList<String>();
    LinearLayout linear;

    @Override
    protected Void doInBackground(Void... voids) {
        try {

            Calendar cal=Calendar.getInstance(TimeZone.getDefault());
            String year=Integer.toString(cal.get(Calendar.YEAR));
            String month=Integer.toString(cal.get(Calendar.MONTH)+1);
            if(month.length()==1){
                month="0"+month;
            }
            String day=Integer.toString(cal.get(Calendar.DATE));
            if(day.length()==1){
                day="0"+day;
            }
            String hour=Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
            String min=Integer.toString(cal.get(Calendar.MINUTE));
            String sec=Integer.toString(cal.get(Calendar.SECOND));

            String link="https://clist.by/api/v1/contest/?end__gte="+year+"-"+month+"-"+day+"T"+hour+"%3A"+min+"%3A"+sec+"&order_by=start&username=Madhur&api_key=2b5a256c4b6bcacf6612809fb892a254d919aea7";
            URL url = new URL(link);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream input=httpURLConnection.getInputStream();
            BufferedReader buffer=new BufferedReader(new InputStreamReader(input));
            String line="";
            while(line!=null){
                line=buffer.readLine();
                data=data+line;
            }
            JSONObject JO1=new JSONObject(data);
            JSONArray JA=(JSONArray)JO1.get("objects");

            for(int i=0;i<JA.length();i++){
                JSONObject JO=(JSONObject)JA.get(i);
                JSONObject JO2=(JSONObject)JO.get("resource");
                String website=(String)JO2.get("name");
                if(website.equals("codechef.com")){
                    if(HomeFragment.iscc){
                        singleparsed="Contest : "+JO.get("event")+"\n"+"Duration : "+ JO.get("duration")+" sec\n"+
                                "Start : "+JO.get("start")+"\n"+"End : "+JO.get("end")+"\n"+"Organizer : "+JO2.get("name");
                        arrli.add(singleparsed);
                    }
                }
                else if(website.equals("codeforces.com")){
                    if(HomeFragment.iscf){
                        singleparsed="Contest : "+JO.get("event")+"\n"+"Duration : "+ JO.get("duration")+" sec\n"+
                                "Start : "+JO.get("start")+"\n"+"End : "+JO.get("end")+"\n"+"Organizer : "+JO2.get("name");
                        arrli.add(singleparsed);
                    }
                }
                else if(website.equals("topcoder.com")){
                    if(HomeFragment.istop){
                        singleparsed="Contest : "+JO.get("event")+"\n"+"Duration : "+ JO.get("duration")+" sec\n"+
                                "Start : "+JO.get("start")+"\n"+"End : "+JO.get("end")+"\n"+"Organizer : "+JO2.get("name");
                        arrli.add(singleparsed);
                    }
                }
                else if(website.equals("hackerearth.com")){
                    if(HomeFragment.ishe){
                        singleparsed="Contest : "+JO.get("event")+"\n"+"Duration : "+ JO.get("duration")+" sec\n"+
                                "Start : "+JO.get("start")+"\n"+"End : "+JO.get("end")+"\n"+"Organizer : "+JO2.get("name");
                        arrli.add(singleparsed);
                    }
                }
                else if(website.equals("hackerrank.com")){
                    if(HomeFragment.ishr){
                        singleparsed="Contest : "+JO.get("event")+"\n"+"Duration : "+ JO.get("duration")+" sec\n"+
                                "Start : "+JO.get("start")+"\n"+"End : "+JO.get("end")+"\n"+"Organizer : "+JO2.get("name");
                        arrli.add(singleparsed);
                    }
                }
                else{
                    if(HomeFragment.isothers) {
                        singleparsed="Contest : "+JO.get("event")+"\n"+"Duration : "+ JO.get("duration")+" sec\n"+
                                "Start : "+JO.get("start")+"\n"+"End : "+JO.get("end")+"\n"+"Organizer : "+JO2.get("name");
                        arrli.add(singleparsed);
                    }
                }
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        linear=HomeFragment.view.findViewById(R.id.listdata);
        linear.setBackgroundColor(Color.parseColor("#008577"));
        for(int i=0;i<arrli.size();i++){
            //HomeFragment.list.add(arrli.get(i));
            //HomeFragment.ad.notifyDataSetChanged();
            CardView card=new CardView(HomeFragment.context);
            LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if(i!=0) {
                lp.setMargins(10, 10, 10, 10);
            }
            else{
                lp.setMargins(10, 0, 10, 10);
            }
            LinearLayout.LayoutParams lp1=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            card.setLayoutParams(lp);
            TextView tv=new TextView(HomeFragment.context);
            lp1.setMargins(10, 10, 10, 10);
            tv.setLayoutParams(lp1);
            tv.setText(arrli.get(i));
            tv.setTextSize(18);
            tv.setTextColor(Color.parseColor("#000000"));
            card.addView(tv);
            linear.addView(card);
        }
    }
}
