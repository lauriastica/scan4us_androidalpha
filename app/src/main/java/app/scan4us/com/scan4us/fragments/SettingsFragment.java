package app.scan4us.com.scan4us.fragments;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.RingtonePreference;
import android.text.TextUtils;



import app.scan4us.com.scan4us.R;


public class SettingsFragment extends PreferenceFragment {



    public final static String PREF_START_ACTION_ACCOUNT = "pref_start_action_account";
    public final static String PREF_START_ACTION_NOTIFICACION = "pref_start_action_notification";
    public final static String PREF_START_ACTION_OPINION = "pref_start_action_opinion";
    public final static String PREF_START_ACTION_HElP = "pref_start_action_help";
    public final static String PREF_START_ACTION_POLITICS_PRIVACY = "pref_start_action_pilitics_privacy";
    public static final String PREF_START_ACTION_TERMS_SERVICE = "pref_start_action_terms_service";
    public static final String PREF_START_ACTION_LICENSES = "pref_start_action_licenses";
    public static final String PREF_START_ACTION_LOCKED = "pref_start_action_locked";
    public final static String PREF_START_ACTION_CLOSE_ACCOUNT = "pref_start_action_close_account";


    public static final String PREF_START_ACTION_NAME = "pref_start_action_name";
    public static final String PREF_START_ACTION_USER_NAME = "pref_start_action_user_name";
    public static final String PREF_START_ACTION_BIRTHDAY = "pref_start_action_birthday";
    public static final String PREF_START_ACTION_NUMBER_MOBILE = "pref_start_action_number_mobile";
    public static final String PREF_START_ACTION_EMAIL = "pref_start_action_email";
    public static final String PREF_START_ACTION_PASSWORD = "pref_start_action_password";




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_setting_account);

    }




    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, final android.preference.Preference preference) {


        switch (preference.getKey()) {

            case PREF_START_ACTION_BIRTHDAY:

                break;

            case PREF_START_ACTION_ACCOUNT:

                break;

            case PREF_START_ACTION_OPINION:

                break;
            case PREF_START_ACTION_HElP:

                break;
            case PREF_START_ACTION_POLITICS_PRIVACY:

                break;
            case PREF_START_ACTION_LOCKED:

                break;

            case PREF_START_ACTION_TERMS_SERVICE:


                break;
            case PREF_START_ACTION_LICENSES:

                break;

        }




        return super.onPreferenceTreeClick(preferenceScreen, preference);


    }



    @Override
    public void onResume() {
        super.onResume();
    }


    /**
     * Un cambio oyente valor de preferencia que actualiza el resumen de la preferencia
     para reflejar su nuevo valor.
     *
     * A preference value change listener that updates the preference's summary
     * to reflect its new value.
     */
    private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener =
            new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference,Object value) {
                    String stringValue = value.toString();

                    switch (stringValue) {

                        case PREF_START_ACTION_NOTIFICACION:

                            break;

                        case PREF_START_ACTION_CLOSE_ACCOUNT:

                            break;

                        case PREF_START_ACTION_NAME:


                            break;

                        case PREF_START_ACTION_USER_NAME:


                            break;
                    }


                    if (preference instanceof ListPreference) {
                        // For list preferences, look up the correct display value in
                        // the preference's 'entries' list.
                        ListPreference listPreference = (ListPreference) preference;
                        int index = listPreference.findIndexOfValue(stringValue);

                        // Set the summary to reflect the new value.
                        preference.setSummary(
                                index >= 0
                                        ? listPreference.getEntries()[index]
                                        : null);

                    } else if (preference instanceof RingtonePreference) {
                        // For ringtone preferences, look up the correct display value
                        // using RingtoneManager.
                        if (TextUtils.isEmpty(stringValue)) {
                            // Empty values correspond to 'silent' (no ringtone).
                            preference.setSummary("pref_ringtone_silent");

                        } else {
                            Ringtone ringtone = RingtoneManager.getRingtone(
                                    preference.getContext(), Uri.parse(stringValue));

                            if (ringtone == null) {
                                // Clear the summary if there was a lookup error.
                                preference.setSummary(null);
                            } else {
                                // Set the summary to reflect the new ringtone display
                                // name.
                                String name = ringtone.getTitle(preference.getContext());
                                preference.setSummary(name);
                            }
                        }

                    } else {
                        // For all other preferences, set the summary to the value's
                        // simple string representation.
                        preference.setSummary(stringValue);
                    }
                    return true;
                }
            };

    /**
     * Helper method to determine if the device has an extra-large screen. For
     * example, 10" tablets are extra-large.

     private static boolean isXLargeTablet(Context context) {
     return (context.getResources().getConfiguration().screenLayout
     & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
     }
     */

    /**
     *
     Se une un resumen de la preferencia a su valor . Más específicamente, cuando la
     se cambia el valor de preferencia , su resumen ( línea de texto debajo de la
     Título de preferencia) se actualiza para reflejar el valor . El resumen es también
     inmediatamente actualizado a llamar a este método . El formato de visualización es exacta
     depende del tipo de preferencia.
     *
     *
     * Binds a preference's summary to its value. More specifically, when the
     * preference's value is changed, its summary (line of text below the
     * preference title) is updated to reflect the value. The summary is also
     * immediately updated upon calling this method. The exact display format is
     * dependent on the type of preference.
     *
     * @see #sBindPreferenceSummaryToValueListener
     */
    private static void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        // Trigger the listener immediately with the preference's
        // current value.
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,PreferenceManager
                .getDefaultSharedPreferences(preference.getContext())
                .getString(preference.getKey(),""));


    }



    public static class SettingsAccountFragment extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_setting_account);
            setHasOptionsMenu(true);
            /*
            Obligar a los resúmenes de EditText / Lista / diálogo Preferencias / Tono
            a sus valores . Cuando Sus valores cambian, sus resúmenes son
            Reflect actualizado al nuevo valor , según el diseño de Android
            directrices .
            *
            Bind the summaries of EditText/List/Dialog/Ringtone preferences
            to their values. When their values change, their summaries are
            updated to reflect the new value, per the Android Design
            guidelines.
            */
            bindPreferenceSummaryToValue(findPreference(PREF_START_ACTION_NAME));
            bindPreferenceSummaryToValue(findPreference(PREF_START_ACTION_USER_NAME));
            bindPreferenceSummaryToValue(findPreference(PREF_START_ACTION_BIRTHDAY));
            bindPreferenceSummaryToValue(findPreference(PREF_START_ACTION_NUMBER_MOBILE));
            bindPreferenceSummaryToValue(findPreference(PREF_START_ACTION_EMAIL));
            bindPreferenceSummaryToValue(findPreference(PREF_START_ACTION_PASSWORD));

            findPreference(PREF_START_ACTION_NAME).setDefaultValue("");
            findPreference(PREF_START_ACTION_USER_NAME).setDefaultValue("");
            findPreference(PREF_START_ACTION_BIRTHDAY).setDefaultValue("");
            findPreference(PREF_START_ACTION_NUMBER_MOBILE).setDefaultValue("");
            findPreference(PREF_START_ACTION_EMAIL).setDefaultValue("");
            findPreference(PREF_START_ACTION_PASSWORD).setDefaultValue("");


        }
    }



    /**
     * {@inheritDoc}
     @Override
     public boolean onIsMultiPane() {
     return isXLargeTablet(this);
     }
     */

    /**
     * {@inheritDoc}

    @Override
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onBuildHeaders(List<PreferenceActivity.Header> target) {
        loadHeadersFromResource(R.xml.pref_headers,target);
    }



    /**
     * Este método se detiene la inyección fragmento de aplicaciones maliciosas.
     Asegúrese de negar cualquier fragmento desconocido aquí.
     *
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.

     protected boolean isValidFragment(String fragmentName) {
     return PreferenceFragment.class.getName().equals(fragmentName)
     || GeneralPreferenceFragment.class.getName().equals(fragmentName)
     || DataSyncPreferenceFragment.class.getName().equals(fragmentName)
     || NotificationPreferenceFragment.class.getName().equals(fragmentName);
     }
     */




    /**
     * This fragment shows general preferences only. It is used when the
     * activity is showing a two-pane settings UI.

     @TargetApi(Build.VERSION_CODES.LOLLIPOP)
     public static class GeneralPreferenceFragment extends PreferenceFragment {
     @Override
     public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     addPreferencesFromResource(R.xml.pref_general);
     setHasOptionsMenu(true);

     // Bind the summaries of EditText/List/Dialog/Ringtone preferences
     // to their values. When their values change, their summaries are
     // updated to reflect the new value, per the Android Design
     // guidelines.
     bindPreferenceSummaryToValue(findPreference("example_text"));
     bindPreferenceSummaryToValue(findPreference("example_list"));
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
     int id = item.getItemId();
     if (id == android.R.id.home) {
     startActivity(new Intent(getActivity(), SettingsActivity.class));
     return true;
     }
     return super.onOptionsItemSelected(item);
     }
     }

      * This fragment shows notification preferences only. It is used when the
      * activity is showing a two-pane settings UI.

     @TargetApi(Build.VERSION_CODES.LOLLIPOP)
     public static class NotificationPreferenceFragment extends PreferenceFragment {
     @Override
     public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     addPreferencesFromResource(R.xml.pref_notification);
     setHasOptionsMenu(true);

     // Bind the summaries of EditText/List/Dialog/Ringtone preferences
     // to their values. When their values change, their summaries are
     // updated to reflect the new value, per the Android Design
     // guidelines.
     bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"));
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
     int id = item.getItemId();
     if (id == android.R.id.home) {
     startActivity(new Intent(getActivity(), SettingsActivity.class));
     return true;
     }
     return super.onOptionsItemSelected(item);
     }
     }




      * This fragment shows data and sync preferences only. It is used when the
      * activity is showing a two-pane settings UI.

     @TargetApi(Build.VERSION_CODES.LOLLIPOP)
     public static class DataSyncPreferenceFragment extends PreferenceFragment {
     @Override
     public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     addPreferencesFromResource(R.xml.pref_data_sync);
     setHasOptionsMenu(true);

     // Bind the summaries of EditText/List/Dialog/Ringtone preferences
     // to their values. When their values change, their summaries are
     // updated to reflect the new value, per the Android Design
     // guidelines.
     bindPreferenceSummaryToValue(findPreference("sync_frequency"));
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
     int id = item.getItemId();
     if (id == android.R.id.home) {
     startActivity(new Intent(getActivity(), SettingsActivity.class));
     return true;
     }
     return super.onOptionsItemSelected(item);
     }
     }
     */




}
