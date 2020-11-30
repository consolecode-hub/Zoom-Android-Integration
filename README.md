# Zoom-Android-Integration

![Integret Zoom Capture](https://user-images.githubusercontent.com/3745464/100644020-c7fc2680-3360-11eb-8c50-06a1a0a7e95d.PNG)

# 1 **[Integrate with your app](https://marketplace.zoom.us/docs/sdk/native-sdks/android/getting-started/integration)**

# 2 **[Build a Zoom meeting app](https://marketplace.zoom.us/docs/sdk/native-sdks/android/build-an-app)**

# 3 **[Design the UI](https://marketplace.zoom.us/docs/sdk/native-sdks/android/build-an-app/design-the-app-ui)**

# 4 **[Implement features](https://marketplace.zoom.us/docs/sdk/native-sdks/android/build-an-app/implement-features)**

# 5 **Run your app**

1. Locate the libraries
The aar libraries are in the commonlib and mobilertc folders. Please ensure the following files are in these folders, if any of them is missing, please re-download them.

commonlib

```
commonlib/
├── build.gradle
├── commonlib.aar
└── commonlib.iml
```
mobilertc

```
mobilertc/
├── build.gradle
├── mobilertc.aar
└── mobilertc.iml
```

2. Add modules and configure dependencies
Open “Project Structure” and press “+ (Add Module)”.


Select “Import .JAR/.AAR Package”, locate the aar files and add them into your project. Last but not least, select your own module in the Project Structure, and add the libraries as dependencies.


Now you can import classes from the SDK in your own applications and enjoy the fantastic video conferencing experience in your apps.

**Build a Zoom meeting app**
Explore the Zoom Client Android SDK by learning how to build a simple meetings app that has the following two features:

Join a Meeting : A user with a Zoom meeting ID and meeting passcode can join a meeting anonymously without having to log into the app.

Start a Meeting: A meeting host can start the meeting after logging into the app with their Zoom account credentials.

You can find an existing  with these features on Github.

**Prerequisites**

Android Device (Supported Devices: Phone, Tablets)
TV, Box and Chromebooks are not supported.

Meeting ID and the passcode of a Zoom meeting.

SDK Key and Secret, obtained by .

Android API Level: minSdkVersion 21 or higher

Note: If you select minSdkVersion 23 or higher as your minSDKVersion, you will need to reduce your app size by including: android:extractNativeLibs="true"in your AndroidManifest.xml

**Dependencies:**
```
implementation 'androidx.recyclerview:recyclerview:1.1.0'
implementation 'androidx.appcompat:appcompat:1.2.0'
implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
implementation 'com.google.android.material:material:1.3.0-alpha02'
implementation 'com.google.android:flexbox:2.0.1'
implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
```
This section of the tutorial demonstrates how to create an Android project and integrate the Zoom Client Android SDK into the project.

1. Create an Android project
Open Android Studio and click Start a new Android Studio Project. Next, on the Select a Project Template window, select Phone and Tablet > Empty Activity.

Click Next and enter your Application name, Company domain, select your Project location and Programming language in the next screen.

Select API 21: Android 5.0(Lollipop) or higher as the minimum SDK for the project and click Finish. A new project will be created for you by Android Studio.

Build and run this project on your emulator or on your device to ensure that there are no initial errors and your starter project is working.

2. Import the Zoom SDK libraries
If you have not already downloaded the Zoom Android SDK, click the following button to download it:

The downloaded folder includes SDK libraries and sample apps. The SDK libraries (aar libraries) are in the commonlib and mobilertc folders located inside the mobilertc-android studio folder. Ensure that the following files are included in these folders, if you find that any of them is missing or you delete one by mistake, re-download the SDK.

**Add modules and configure dependencies**
In this step, you are going to import commonlib.aar and mobilertc.aar modules from the downloaded SDK package to your project as AAR files.In Android Studio, click File > Project Structure > Module> + > New module.

In this step, you are going to import commonlib.aar and mobilertc.aar modules from the downloaded SDK package to your project as AAR files.In Android Studio, click File > Project Structure > Module> + > New module.


In the next screen, scroll down to select “Import .JAR/.AAR Package”, locate the aar files from the downloaded SDK package and add them into your project.

You will need to do it twice, once for commonlib.arr and once for mobilertc.arr.

Next, add these modules as dependencies of your app. Navigate to Project Structure, click Dependencies > App > + > “Module Dependency. In the next screen, select commonlib and mobilertc and click OK.


To confirm whether or not you have successfully configured the Zoom SDK dependencies, look for the build.gradle(Module:app) file inside the Gradle scripts folder and check if the following lines of code are present:

```
dependencies {
    implementation project(path: ':mobilertc')
    implementation project(path: ':commonlib')
}
```
If the above dependencies are present, your project is equipped with the Zoom Client SDK.

**3. Initialize the SDK**

At this point, your MainActivity.java file should look similar to the following:
```

package com.example.myfirstsdkapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import us.zoom.sdk.JoinMeetingOptions;
import us.zoom.sdk.JoinMeetingParams;
import us.zoom.sdk.MeetingService;
import us.zoom.sdk.StartMeetingOptions;
import us.zoom.sdk.ZoomSDK;
import us.zoom.sdk.ZoomSDKInitParams;
import us.zoom.sdk.ZoomSDKInitializeListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeSdk(this);

    }

public void initializeSdk(Context context) {
        ZoomSDK sdk = ZoomSDK.getInstance();
        // TODO: For the purpose of this demo app, we are storing the credentials in the client app itself. However, you should not use hard-coded values for your key/secret in your app in production.
       ZoomSDKInitParams params = new ZoomSDKInitParams();
        params.appKey = ""; // TODO: Retrieve your SDK key and enter it here
        params.appSecret = ""; // TODO: Retrieve your SDK secret and enter it here
        params.domain = "zoom.us";
        params.enableLog = true;
        // TODO: Add functionality to this listener (e.g. logs for debugging)
        ZoomSDKInitializeListener listener = new ZoomSDKInitializeListener() {
            /**
             * @param errorCode {@link us.zoom.sdk.ZoomError#ZOOM_ERROR_SUCCESS} if the SDK has been initialized successfully.
             */
            @Override
            public void onZoomSDKInitializeResult(int errorCode, int internalErrorCode) { }

            @Override
            public void onZoomAuthIdentityExpired() { }
        };
        sdk.initialize(context, listener, params);

    }

}
```

**Design the UI**
In the  section, you learned how to set up your Android project. This section demonstrates how to create a simple UI for your app.

**Create the UI**
Add two buttons to your layout. When clicked, one button(Join Meeting) must prompt users to provide the meeting number and meeting passcode to join a meeting and the other button(Login & Start Meeting) must prompt users to enter their Zoom login credentials.


Add these buttons by either using the design tab in the  or by directly editing your activity’s layout xml file.

You can be creative and design the buttons and the UI yourself. We will not be covering the Android Studio Layout design details here.

If you are new to Android development, refer to Google’s  and  to get familiar with Android development.

To follow along with the UI implementation that we used in this demo project, refer to the following layout example:

res/layout/activity_main.xml
 
**<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
   xmlns:app="http://schemas.android.com/apk/res-auto"
   xmlns:tools="http://schemas.android.com/tools"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   tools:context=".MainActivity">

   <Button
       android:id="@+id/join_button"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="join meeting"
       app:layout_constraintBottom_toBottomOf="parent"
       app:layout_constraintLeft_toLeftOf="parent"
       app:layout_constraintRight_toRightOf="parent"
       app:layout_constraintTop_toTopOf="parent" />

   <Button
       android:id="@+id/login_button"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="log in &amp; start meeting"
       app:layout_constraintTop_toBottomOf="@id/join_button"
       app:layout_constraintStart_toStartOf="parent"
       app:layout_constraintEnd_toEndOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>**
Next, create a  with input fields for the login and meeting information dialog prompts that will pop up each time a user clicks on the buttons.

When a user clicks on the Join Meeting button, display a dialog similar to the following:


Similar to activity_main.xml, we encourage you to design this layout according to your preference.

An example implementation for this layout is shown below:
```

res/layout/dialog_main.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/meeting_no_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent">
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/meeting_no_input"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Meeting Number"/>
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/password_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@id/meeting_no_layout">
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/password_input"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Meeting password"
            android:inputType="textPassword"/>
    </com.google.android.material.textfield.TextInputLayout>

</androidx.constraintlayout.widget.ConstraintLayout>


```
Next, create another custom layout file for the Login dialog that gets displayed when a user clicks on the Login & Start Meeting button.

 ```

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/email_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent">
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/email_input"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Email"/>
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/pw_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@id/email_layout">
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/pw_input"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="textPassword"
            android:hint="Password"/>
    </com.google.android.material.textfield.TextInputLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

Note that these layouts do not contain the buttons that are visible in the completed dialog. This is because we are using the built-in positive button of the AlertDialog, which does not require us to define anything in the layout XML.

After completing the steps listed above, you should have a simple UI ready for the app. Next, you will learn how to make the UI interactive, implement some features and run the app.

So far you learned how to successfully integrate the Zoom Client Android SDK in your app. Next, learn how to design the UI of this app.

**Implement features**
In the  section, you learned how to implement a simple UI in your app.

This section demonstrates how to make the buttons interactive by adding functions that enable the Join Meeting and Login and Start Meeting features. You will enable these features by using the MeetingService interface provided by Zoom Client SDK.

**1. Join a meeting**
The Join Meeting feature of this demo app should allow a participant to join an existing Zoom meeting once they enter the Meeting Number and Meeting Passcode (if one exists) for the meeting.

To implement this feature, add the following lines of code in your MainActivity.java file below the initializeSDK method:

```
MainActivity.java
//1. Write the joinMeeting function.
private void joinMeeting(Context context, String meetingNumber, String password) {
  MeetingService meetingService = ZoomSDK.getInstance().getMeetingService();
  JoinMeetingOptions options = new JoinMeetingOptions();
  JoinMeetingParams params = new JoinMeetingParams();
  params.displayName = ""; // TODO: Enter your name
  params.meetingNo = meetingNumber;
  params.password = password;
  meetingService.joinMeetingWithParams(context, params, options);
}
```
The joinMeeting function accepts meeting number(meeting ID) and meeting passcode as parameters and passes these parameters to the joinMeetingWithParams method.

2. Login and start a meeting
The Login & Start Meeting button of this demo app should prompt the user to login with Zoom login credentials if the user is not already loggen in. After successfully logging in, the user will join an instant meeting as a Meeting host.

To implement the Login & Start Meeting feature, add the following lines of code in your MainActivity.java file under the joinMeeting method:
```

MainActivity.java
// 1. Write the login function

private void login(String username, String password) {
  int result = ZoomSDK.getInstance().loginWithZoom(username, password);
  if (result == ZoomApiError.ZOOM_API_ERROR_SUCCESS) {

    // 2. After request is executed, listen for the authentication result prior to starting a meeting
    ZoomSDK.getInstance().addAuthenticationListener(authListener);
  }
}
// 3. Write the startMeeting function
private void startMeeting(Context context) {
  ZoomSDK sdk = ZoomSDK.getInstance();
  if (sdk.isLoggedIn()) {
    MeetingService meetingService = sdk.getMeetingService();
    StartMeetingOptions options = new StartMeetingOptions();
    meetingService.startInstantMeeting(context, options);
  }
}
```
Next, in MainActivity.java, add createJoinMeetingDialog() and createLoginDialog() methods that implement the following behaviors:

Utilize the AlertDialog interface to display dialogs with custom layouts that we created earlier for login and meeting information.

Verify that the information entered by the user is valid when the button is clicked and call associated methods(joinMeeting and startMeeting) upon validation.

MainActivity.java
// 1. Create a dialog where a participant can enter the meeting information to join a meeting.
```
private void createJoinMeetingDialog() {
  new AlertDialog.Builder(this).setView(R.layout.dialog_join_meeting).setPositiveButton("Join", new DialogInterface.OnClickListener() {@Override
    public void onClick(DialogInterface dialogInterface, int i) {
      AlertDialog dialog = (AlertDialog) dialogInterface;
      TextInputEditText numberInput = dialog.findViewById(R.id.meeting_no_input);
      TextInputEditText passwordInput = dialog.findViewById(R.id.password_input);
      if (numberInput != null && numberInput.getText() != null && passwordInput != null && passwordInput.getText() != null) {
        String meetingNumber = numberInput.getText().toString();
        String password = passwordInput.getText().toString();
        if (meetingNumber.trim().length() > 0 && password.trim().length() > 0) {
          joinMeeting(MainActivity.this, meetingNumber, password);
        }
      }
    }
  }).show();
}

// 2. Create a dialog where a host can enter Zoom email and password to login and start an instant meeting.
```
private void createLoginDialog() {
  new AlertDialog.Builder(this).setView(R.layout.dialog_login).setPositiveButton("Log in", new DialogInterface.OnClickListener() {@Override
    public void onClick(DialogInterface dialogInterface, int i) {
      AlertDialog dialog = (AlertDialog) dialogInterface;
      TextInputEditText emailInput = dialog.findViewById(R.id.email_input);
      TextInputEditText passwordInput = dialog.findViewById(R.id.pw_input);
      if (emailInput != null && emailInput.getText() != null && passwordInput != null && passwordInput.getText() != null) {
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        if (email.trim().length() > 0 && password.trim().length() > 0) {
          login(email, password);
        }
      }
    }
  }).show();
}
```
Create a method named initViews that handles the onClick events for the Join Meeting and Login & Start Meeting buttons.

MainActivity.java
//1. Write initViews method to handle onClick events for the Join Meeting and Login & Start Meeting buttons. 
private void initViews() {
  findViewById(R.id.join_button).setOnClickListener(new View.OnClickListener() {@Override
    public void onClick(View view) {
      createJoinMeetingDialog();
    }
  });

  findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {@Override
    public void onClick(View view) {
      // 2.  If a user is logged in, start the instant meeting, else prompt the user to login.
      if (ZoomSDK.getInstance().isLoggedIn()) {
        startMeeting(MainActivity.this);
      } else {
        createLoginDialog();
      }
    }
  });
}
```
When the Join Meeting button is pressed, the createJoinMeetingDialog method gets invoked which displays the dialog for users to enter the meeting information. Similarly, when the Login & Start Meeting button is clicked, createLoginDialog method gets invoked which displays the dialog for users to enter their Zoom login information.

Upon successful login, the user will immediately join an instant meeting as a host. If the user is already logged in, this will just start the instant meeting.

Note that to use AlertDialog, we need to import the AlertDialog and DialogInterfaces packages in our MainActivity.java file.

Refer to the following snippet to see what your complete MainActivity.java file should look like:

MainActivity.java
// The package name will be different for your project.
```

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import us.zoom.sdk.JoinMeetingOptions;
import us.zoom.sdk.JoinMeetingParams;
import us.zoom.sdk.MeetingService;
import us.zoom.sdk.StartMeetingOptions;
import us.zoom.sdk.ZoomApiError;
import us.zoom.sdk.ZoomAuthenticationError;
import us.zoom.sdk.ZoomSDK;
import us.zoom.sdk.ZoomSDKAuthenticationListener;
import us.zoom.sdk.ZoomSDKInitParams;
import us.zoom.sdk.ZoomSDKInitializeListener;

public class MainActivity extends AppCompatActivity {
  private ZoomSDKAuthenticationListener authListener = new ZoomSDKAuthenticationListener() {
    /**
        * This callback is invoked when a result from the SDK's request to the auth server is
        * received.
        */
    @Override
    public void onZoomSDKLoginResult(long result) {
      if (result == ZoomAuthenticationError.ZOOM_AUTH_ERROR_SUCCESS) {
        // Once we verify that the request was successful, we may start the meeting
        startMeeting(MainActivity.this);
      }
    }

    @Override
    public void onZoomSDKLogoutResult(long l) {}@Override
    public void onZoomIdentityExpired() {}@Override
    public void onZoomAuthIdentityExpired() {}
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initializeSdk(this);
    initViews();
  }

  /**
    * Initialize the SDK with your credentials. This is required before accessing any of the
    * SDK's meeting-related functionality.
    */
  public void initializeSdk(Context context) {
    ZoomSDK sdk = ZoomSDK.getInstance();
    // TODO: Do not use hard-coded values for your key/secret in your app in production!
    ZoomSDKInitParams params = new ZoomSDKInitParams();
    params.appKey = ""; // TODO: Retrieve your SDK key and enter it here
    params.appSecret = ""; // TODO: Retrieve your SDK secret and enter it here
    params.domain = "zoom.us";
    params.enableLog = true;
    // TODO: Add functionality to this listener (e.g. logs for debugging)
    ZoomSDKInitializeListener listener = new ZoomSDKInitializeListener() {
      /**
            * @param errorCode {@link us.zoom.sdk.ZoomError#ZOOM_ERROR_SUCCESS} if the SDK has been initialized successfully.
            */
      @Override
      public void onZoomSDKInitializeResult(int errorCode, int internalErrorCode) {}

      @Override
      public void onZoomAuthIdentityExpired() {}
    };
    sdk.initialize(context, listener, params);
  }

  private void initViews() {
    findViewById(R.id.join_button).setOnClickListener(new View.OnClickListener() {@Override
      public void onClick(View view) {
        createJoinMeetingDialog();
      }
    });

    findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {@Override
      public void onClick(View view) {
        if (ZoomSDK.getInstance().isLoggedIn()) {
          startMeeting(MainActivity.this);
        } else {
          createLoginDialog();
        }
      }
    });
  }

  /**
    * Join a meeting without any login/authentication with the meeting's number & password
    */
  public void joinMeeting(Context context, String meetingNumber, String password) {
    MeetingService meetingService = ZoomSDK.getInstance().getMeetingService();
    JoinMeetingOptions options = new JoinMeetingOptions();
    JoinMeetingParams params = new JoinMeetingParams();
    params.displayName = ""; // TODO: Enter your name
    params.meetingNo = meetingNumber;
    params.password = password;
    meetingService.joinMeetingWithParams(context, params, options);
  }

  /**
    * Log into a Zoom account through the SDK using your email and password. For more information,
    * see {@link ZoomSDKAuthenticationListener#onZoomSDKLoginResult} in the {@link #authListener}.
    */
  public void login(String username, String password) {
    int result = ZoomSDK.getInstance().loginWithZoom(username, password);
    if (result == ZoomApiError.ZOOM_API_ERROR_SUCCESS) {
      // Request executed, listen for result to start meeting
      ZoomSDK.getInstance().addAuthenticationListener(authListener);
    }
  }

  /**
    * Start an instant meeting as a logged-in user. An instant meeting has a meeting number and
    * password generated when it is created.
    */
  public void startMeeting(Context context) {
    ZoomSDK sdk = ZoomSDK.getInstance();
    if (sdk.isLoggedIn()) {
      MeetingService meetingService = sdk.getMeetingService();
      StartMeetingOptions options = new StartMeetingOptions();
      meetingService.startInstantMeeting(context, options);
    }
  }

  /**
    * Prompt the user to input the meeting number and password and uses the Zoom SDK to join the
    * meeting.
    */
  private void createJoinMeetingDialog() {
    new AlertDialog.Builder(this).setView(R.layout.dialog_join_meeting).setPositiveButton("Join", new DialogInterface.OnClickListener() {@Override
      public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog dialog = (AlertDialog) dialogInterface;
        TextInputEditText numberInput = dialog.findViewById(R.id.meeting_no_input);
        TextInputEditText passwordInput = dialog.findViewById(R.id.password_input);
        if (numberInput != null && numberInput.getText() != null && passwordInput != null && passwordInput.getText() != null) {
          String meetingNumber = numberInput.getText().toString();
          String password = passwordInput.getText().toString();
          if (meetingNumber.trim().length() > 0 && password.trim().length() > 0) {
            joinMeeting(MainActivity.this, meetingNumber, password);
          }
        }
        dialog.dismiss();
      }
    }).show();
  }

  /**
    * Prompts the user to input their account email and password and uses the Zoom SDK to login.
    * See {@link ZoomSDKAuthenticationListener#onZoomSDKLoginResult} in the {@link #authListener} for more information.
    */
  private void createLoginDialog() {
    new AlertDialog.Builder(this).setView(R.layout.dialog_login).setPositiveButton("Log in", new DialogInterface.OnClickListener() {@Override
      public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog dialog = (AlertDialog) dialogInterface;
        TextInputEditText emailInput = dialog.findViewById(R.id.email_input);
        TextInputEditText passwordInput = dialog.findViewById(R.id.pw_input);
        if (emailInput != null && emailInput.getText() != null && passwordInput != null && passwordInput.getText() != null) {
          String email = emailInput.getText().toString();
          String password = passwordInput.getText().toString();
          if (email.trim().length() > 0 && password.trim().length() > 0) {
            login(email, password);
          }
        }
        dialog.dismiss();
      }
    }).show();
  }
}
```

**Run your app**
Connect your Android device and press Run to run your app on your device. If you do not have an Android device handy, you can also run this app on your emulator.
