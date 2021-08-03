package dev.fluttercommunity.plus.androidalarmmanager;

import android.content.Context;
import android.content.SharedPreferences;

public class AlarmFlagManager {

  private static final String FLUTTER_SHARED_PREFERENCE_KEY = "FlutterSharedPreferences";
  private static final String ALARM_FLAG_KEY = "flutter.alarmFlagKey";

  static void set(Context context, long callbackId) {
    long alarmId = _getActualIdFrom(callbackId);

    SharedPreferences prefs = context.getSharedPreferences(FLUTTER_SHARED_PREFERENCE_KEY, 0);
    prefs.edit().putLong(ALARM_FLAG_KEY, alarmId).apply();
  }

  /**
   * 알람 객체의 ID로 변환한 ID를 반환한다.
   *
   * 이때 `Timer`의 경우는 ID가 0이므로 반환값도 0이 되어 문제가 없다.
   */
  static long _getActualIdFrom(long callbackId) {
    return (long) Math.floor(callbackId / 7.0);
  }

}
