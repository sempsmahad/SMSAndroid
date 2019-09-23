package example.kahamhamidu.attendance3.base.misc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class Extras {

    public Context context;

    private SharedPreferences userSession;
    private SharedPreferences.Editor userSessionEdit;
    private SharedPreferences sharedPreferences;

    /**
     * Constructor
     * @param context
     */
    public Extras (Context context){
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        userSession = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE);
        userSessionEdit = userSession.edit();
    }



    /**
     * Return sharedpref
     * @return
     */
    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }


    //////////////////// LOGIN SESSION //////////////////////

    /**
     * Enable userlogin Session
     * @param username
     */
    public void setuserLogginSession(String username, Boolean torf) {
        userSessionEdit.putBoolean(Constants.INOUROUT, torf);
        userSessionEdit.putString(Constants.USERNAME, username);
        userSessionEdit.commit();
    }

    /**
     * Is User Logged or not
     * @return
     */
    public boolean isLogged(){
        return userSession.getBoolean(Constants.INOUROUT, false);
    }


    /**
     * Username
     * @return
     */
    public String getUserName(){
        return userSession.getString(Constants.USERNAME, null);
    }

    public SharedPreferences.Editor getUserSessionEdit() {
        return userSessionEdit;
    }



    /////////////////////// Attendance date between save ///////////////

    /**
     * Set start date
     * @param startDate
     */
    public void setStartDate(String startDate){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.STARTDATE, startDate);
        editor.apply();
    }

    /**
     * Return start date
     * @return
     */
    public String getStartDate(){
        return sharedPreferences.getString(Constants.STARTDATE, null);
    }


    /**
     * Set end date
     * @param endDate
     */
    public void setEndDate(String endDate){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.ENDDATE, endDate);
        editor.apply();
    }

    /**
     * Return end date
     * @return
     */
    public String getEndDate(){
        return sharedPreferences.getString(Constants.ENDDATE, null);
    }

    /////////////////////// Attendance Work ////////////////////////

    /**
     * Save checked Attendance data
     * @param list
     */
    public void saveatData(List<Integer> list) {
        String s = "";
        for (Integer i : list) {
            s += i + ",";
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.ATDATA, s);
        editor.commit();
    }

    /**
     * Return checked Attendance data
     * @return
     */
    public ArrayList<Integer> getatData() {
        String s = sharedPreferences.getString(Constants.ATDATA, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }

    /**
     * Save unchecked Attendance data
     * @param list
     */
    public void unsaveatData(List<Integer> list) {
        String s = "";
        for (Integer i : list) {
            s += i + ",";
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.UNSAVEDAT, s);
        editor.commit();
    }

    /**
     * Return unchecked Attendance data
     * @return
     */
    public ArrayList<Integer> getunsaveData() {
        String s = sharedPreferences.getString(Constants.UNSAVEDAT, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }


    /**
     * Save filter Attendance data
     * @param list
     */
    public void filterData(List<Integer> list) {
        String s = "";
        for (Integer i : list) {
            s += i + ",";
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.FILTERAT, s);
        editor.commit();
    }

    /**
     * Return filter Attendance data
     * @return
     */
    public ArrayList<Integer> getfilterData() {
        String s = sharedPreferences.getString(Constants.FILTERAT, "");
        StringTokenizer st = new StringTokenizer(s, ",");
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            result.add(Integer.parseInt(st.nextToken()));
        }
        return result;
    }

    /////////////// Counter record ///////////////

    /**
     * Save onclick int value for attendance
     * @param value
     */
    public void saveCounter(int value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.COUNTER, value);
        editor.apply();
    }

    /**
     * Return counter value
     * @return
     */
    public int getCounter(){
        return sharedPreferences.getInt(Constants.COUNTER, 0);
    }

    /**
     * Save Second Counter
     * @param value
     */
    public void saveCounterSecond(int value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.COUNTER2, value);
        editor.apply();
    }

    /**
     * Return counter second value
     * @return
     */
    public int getCounterSecond(){
        return sharedPreferences.getInt(Constants.COUNTER2, 0);
    }

    //////////////// Div Record /////////////

    /**
     * Set Div
     * @param value
     */
    public void setDiv(String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.DIV, value);
        editor.apply();
    }


    /**
     * Return div
     * @return
     */
    public String getDiv(){
        return sharedPreferences.getString(Constants.DIV, null);
    }


    ////////////////// Attendance Status Record ////////////////


    /**
     * Set Status
     * @param value
     */
    public void setStatus(String value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.STATUS, value);
        editor.apply();
    }


    /**
     * Return div
     * @return
     */
    public String getStatus(){
        return sharedPreferences.getString(Constants.STATUS, null);
    }


    /////////////////// Rollno save //////////////////////

    /**
     * Set rollno
     * @param rollno
     */
    public void setrollNo(int rollno){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.ROLLNO, rollno);
        editor.apply();
    }

    /**
     * get rollno
     * @return
     */
    public int getrollNo(){
        return sharedPreferences.getInt(Constants.ROLLNO, 0);
    }

    ////////////// Save attendance Date & time ///////////////////

    /**
     * Save date and time
     * @param dtime
     */
    public void saveDTime(String dtime){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.DATETIME, dtime);
        editor.apply();
    }

    public String getDTime(){
        return sharedPreferences.getString(Constants.DATETIME, null);
    }


    //////////////// table track //////////////


    public void saveTableData(String tabledata){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("TableData", tabledata);
        editor.apply();
    }

    public String getTableData(){
        return sharedPreferences.getString("TableData", null);
    }
}

