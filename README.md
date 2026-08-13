# Qiyam — Aplikasi Bacaan Maulid

## Build APK (Signed Release)

### 1. Buat Keystore

```bash
# Tambahkan JDK ke PATH (jalankan sekali per sesi terminal)
export PATH="/usr/lib/jvm/java-25-openjdk/bin:$PATH"

keytool -genkeypair \
  -v \
  -storetype PKCS12 \
  -keystore qiyam-release.keystore \
  -alias qiyam \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000
```

Isi data yang diminta (nama, organisasi, dll). **Ingat password-nya!**

Pindahkan keystore ke folder android:

```bash
mv qiyam-release.keystore android/app/
```

### 2. Konfigurasi Signing di Gradle

Edit file `android/app/build.gradle`, tambahkan di dalam blok `android { ... }`:

```groovy
signingConfigs {
    release {
        storeFile file("qiyam-release.keystore")
        storePassword "PASSWORD_ANDA"
        keyAlias "qiyam"
        keyPassword "PASSWORD_ANDA"
    }
}

buildTypes {
    release {
        signingConfig signingConfigs.release
        minifyEnabled false
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
}
```

> ⚠️ Ganti `PASSWORD_ANDA` dengan password yang Anda buat di langkah 1.

### 3. Sync Web Assets

```bash
npx cap copy android
```

### 4. Build APK

```bash
cd android
./gradlew assembleRelease
```

APK hasil build ada di:

```
android/app/build/outputs/apk/release/app-release.apk
```

### 5. Build AAB (untuk Play Store)

```bash
cd android
./gradlew bundleRelease
```

Output:

```
android/app/build/outputs/bundle/release/app-release.aab
```

---

## Development

```bash
# Edit file di www/
# Sync ke android:
npx cap copy android
# Buka Android Studio:
npx cap open android
```
