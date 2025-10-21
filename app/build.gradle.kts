plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-parcelize")
}

android {
    namespace = "com.beupgo.myrecipeapp"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.beupgo.myrecipeapp"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
// ------------------- 앱의 핵심 기능 및 UI 관련 라이브러리 ------------------- //

    // 안드로이드 앱의 기본적인 클래스와 유용한 확장 기능(KTX)들을 모아놓은 라이브러리입니다.
    // 예를 들어, 코드를 더 간결하게 작성할 수 있도록 도와주는 여러 기능들이 포함되어 있어요.
    implementation(libs.androidx.core.ktx)

    // 앱의 생명주기(Lifecycle)를 쉽게 관리하게 해주는 라이브러리입니다.
    // 예를 들어, 사용자가 앱을 켜고 끌 때 특정 동작을 하도록 만들 수 있어요.
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Jetpack Compose를 Activity에서 사용할 수 있게 연결해주는 역할을 합니다.
    // Compose로 만든 화면을 앱의 메인 화면(Activity)에 표시하려면 꼭 필요해요.
    implementation(libs.androidx.activity.compose)

    // Compose 관련 라이브러리들의 버전을 하나로 통일해서 관리해주는 역할을 합니다. (Bill of Materials)
    // 이 덕분에 Compose 라이브러리들의 버전이 서로 꼬이는 것을 막을 수 있어요.
    implementation(platform(libs.androidx.compose.bom))

    // Jetpack Compose의 핵심 UI 기능을 담고 있는 라이브러리입니다.
    // Text, Button, Image 등 화면을 구성하는 기본적인 요소들이 들어있어요.
    implementation(libs.androidx.compose.ui)

    // Compose UI에서 사용되는 그래픽 관련 기능들을 제공합니다.
    // 도형을 그리거나 색상을 다루는 등의 작업을 할 때 필요해요.
    implementation(libs.androidx.compose.ui.graphics)

    // 안드로이드 스튜디오의 미리보기(Preview) 기능에서 Compose UI를 볼 수 있게 해줍니다.
    // 코드를 짜면서 화면이 어떻게 보일지 바로바로 확인할 수 있어 편리해요.
    implementation(libs.androidx.compose.ui.tooling.preview)

    // 구글의 최신 디자인 시스템인 Material Design 3를 Compose에서 사용할 수 있게 해줍니다.
    // 예쁜 버튼, 카드, 앱 바(상단 바) 등을 손쉽게 만들 수 있어요.
    implementation(libs.androidx.compose.material3)

    // ------------------- 추가 기능 라이브러리 ------------------- //

    // Jetpack Compose 환경에서 ViewModel을 쉽게 사용하기 위한 의존성입니다.
    // 화면과 데이터를 분리해서 코드를 깔끔하게 관리하는 데 도움을 줍니다.
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // 서버와 통신(네트워킹)을 쉽게 할 수 있도록 도와주는 Retrofit 라이브러리입니다.
    // 인터넷을 통해 데이터를 주고받을 때 사용해요.
    implementation(libs.retrofit)

    // Retrofit이 서버에서 받은 JSON 데이터를 코틀린 객체로 쉽게 변환할 수 있도록 도와주는 라이브러리입니다.
    implementation(libs.converter.gson)

    // 인터넷에 있는 이미지를 화면에 간편하게 보여줄 수 있게 해주는 Coil 라이브러리입니다.
    implementation(libs.coil.compose)

    // ⬇️ Jetpack Compose를 위한 Navigation 라이브러리를 추가합니다.
    //    이 라이브러리를 통해 앱의 화면(Composable) 간 이동을 쉽게 구현할 수 있습니다.
    implementation(libs.androidx.navigation.compose)

    // ------------------- 테스트 관련 라이브러리 ------------------- //

    // 코드가 제대로 동작하는지 확인하는 '단위 테스트'를 작성할 때 사용하는 JUnit 라이브러리입니다.
    // (컴퓨터 환경에서 실행)
    testImplementation(libs.junit)

    // 안드로이드 환경에서 JUnit 테스트를 할 수 있게 도와주는 라이브러리입니다.
    // (안드로이드 기기나 에뮬레이터에서 실행)
    androidTestImplementation(libs.androidx.junit)

    // 사용자가 앱 화면을 클릭하거나 스크롤하는 등의 동작을 테스트할 때 사용하는 Espresso 라이브러리입니다.
    androidTestImplementation(libs.androidx.espresso.core)

    // 안드로이드 테스트 환경에서도 Compose 라이브러리들의 버전을 통일해줍니다.
    androidTestImplementation(platform(libs.androidx.compose.bom))

    // Compose로 만든 UI가 제대로 보이는지 테스트할 때 사용하는 라이브러리입니다.
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)


    // ------------------- 디버깅(오류 수정) 및 개발 편의를 위한 라이브러리 ------------------- //

    // 개발 중에만 사용되는 Compose UI 도구들입니다. (예: 레이아웃 검사기)
    // 앱을 출시할 때는 포함되지 않아요.
    debugImplementation(libs.androidx.compose.ui.tooling)

    // Compose UI 테스트를 위한 Manifest(앱의 설정 파일)를 제공합니다.
    // 이 역시 개발 중에만 필요합니다.
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}