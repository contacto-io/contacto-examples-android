# Contacto Android SDK and Examples

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
   - [Requirements](#requirements)
   - [Setup](#setup)
   - [Usage](#usage)
- [Examples](#examples)
- [Owners](#owners)
- [Contributions](#contributions)
- [Bugs](#bugs)

## Features

## Getting Started
### Requirements
Contacto SDK clients require devices running Android 10 or higher.

### Setup
#### Get your App ID and App Key
Sign in to your Contacto account (here) as an Administrator. Navigate to Channels > Chat, select the Chat App to be integrated, and navigate the Code tab to access the APP ID and App Key.

<img width="1431" alt="Auth-credentials-from-Console" src="https://user-images.githubusercontent.com/1241804/181737700-42218645-69ea-4ab0-8756-b7a2f8c1c16e.png">

#### Add ContactoSDK to your project
Add the Contacto SDK dependency to the root build.gradle (project/build.gradle)

##### Gradle Kotlin DSL
```Kotlin
implementation("com.contacto:ContactoSDK:1.0.1-beta")
```
##### Gradle Groovy DSL
```Kotlin
implementation 'com.contacto:ContactoSDK:1.0.1-beta'
```
Code snippets to add Contacto SDK using other dependency managers are available [here](https://search.maven.org/artifact/com.contacto/ContactoSDK/1.0.1-beta/aar).

### Usage
#### Initialize the Contacto SDK
Invoke ContactoClient.init() with your APP ID and APP KEY before invoking/ using any feature of Contacto SDK.

##### Kotlin
```Kotlin
import com.contacto.consumer.android.ContactoClient
import com.contacto.consumer.android.ui.model.User

appId = "APP ID of the Chat App", // Access the APP ID from the Contacto Console (https://console.contacto.com)
appKey = "APP Key of the Chat App" // Access the APP Key from the Contacto Console (https://console.contacto.com)

ContactoClient.init(appId = appId, appKey = appKey)
```

##### Java
```Java
import com.contacto.consumer.android.ContactoClient
import com.contacto.consumer.android.ui.model.User

appId = "APP ID of the Chat App", // Access the APP ID from the Contacto Console (https://console.contacto.com)
appKey = "APP Key of the Chat App" // Access the APP Key from the Contacto Console (https://console.contacto.com)

ContactoClient.INSTANCE.init(appId, appKey);
```

#### User Information
You can send basic user information at any point to give you more context on the user when your support agents are messaging back and forth with them.

##### Kotlin
```Kotlin
val user = User(
  mobile = "9180505xxxx",
  email = "example@email.com"
)
```

##### Java
```Java
User user = new User(
  "9180505xxxx", 
  "example@email.com"
);
```

#### Launch a Chat Conversation
##### Kotlin
```Kotlin
ContactoClient.loadChat(this, user)
```

##### Java
```Java
ContactoClient.INSTANCE.loadChat(this, user);
```

## Examples

The repository contains sample apps to familiarize you with the [Contacto Android SDK](https://search.maven.org/artifact/com.contacto/ContactoSDK). You can re-use the code available here in your own Apps. Each example in this project is a stand-alone Android app, capable of being run independently through Gradle or Android Studio.

The current list of samples apps are:

- #### [Initiate Chat Conversation](InitiateChat/src/main)
  A demo app showcasing the initiation of chat conversation with the click of a `Chat with Us` button.

## Owners

If you have any questions, please email [support@contacto.com](mailto:support@contacto.com).

## Contributions

We welcome contributions of any kind including new examples, bug fixes, and documentation improvements. We recommend opening an issue describing what you want to build so that we can discuss how to move forward if it is a major change. For minor changes such as typo fixes and one-liners, go ahead and open a pull request.

## Bugs

Please submit bug reports to [Contacto](https://support.contacto.com/hc/en-us/requests/new).
