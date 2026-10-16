package com.linkbox0.android;

import com.linkbox0.android.activities.DeviceActivity;
import com.linkbox0.android.activities.FolderActivity;
import com.linkbox0.android.activities.MainActivity;
import com.linkbox0.android.activities.PhotoShootActivity;
import com.linkbox0.android.activities.ShareActivity;
import com.linkbox0.android.activities.SyncConditionsActivity;
import com.linkbox0.android.fragments.DeviceListFragment;
import com.linkbox0.android.fragments.FolderListFragment;
import com.linkbox0.android.fragments.StatusFragment;
import com.linkbox0.android.onboarding.OnboardingActivity;
import com.linkbox0.android.receiver.AppConfigReceiver;
import com.linkbox0.android.service.RunConditionMonitor;
import com.linkbox0.android.service.EventProcessor;
import com.linkbox0.android.service.RestApi;
import com.linkbox0.android.service.SyncthingRunnable;
import com.linkbox0.android.service.SyncthingService;
import com.linkbox0.android.settings.SettingsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SyncthingModule.class})
public interface DaggerComponent {
    void inject(AppConfigReceiver appConfigReceiver);
    void inject(DeviceActivity activity);
    void inject(DeviceListFragment fragment);
    void inject(EventProcessor eventProcessor);
    void inject(FolderActivity activity);
    void inject(FolderListFragment fragment);
    void inject(MainActivity activity);
    void inject(OnboardingActivity onboardingActivity);
    void inject(PhotoShootActivity photoShootActivity);
    void inject(RestApi restApi);
    void inject(RunConditionMonitor runConditionMonitor);
    void inject(SettingsActivity settingsActivity);
    void inject(ShareActivity activity);
    void inject(StatusFragment fragment);
    void inject(SyncConditionsActivity activity);
    void inject(SyncthingApp app);
    void inject(SyncthingRunnable syncthingRunnable);
    void inject(SyncthingService service);
}
