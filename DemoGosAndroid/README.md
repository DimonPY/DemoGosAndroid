# DemoGosAndroid

Демонстрационное Android-приложение на Kotlin + Jetpack Compose.

## Сборка с телефона через GitHub Actions

1. Создай репозиторий на GitHub.
2. Загрузи в него содержимое этой папки.
3. Открой вкладку **Actions**.
4. Выбери **Build Android APK** → **Run workflow**.
5. После завершения открой workflow run → **Artifacts** → `DemoGos-debug-apk`.
6. Скачай ZIP с APK на телефон, распакуй и установи APK.

Workflow использует Java 17 и Gradle 9.5.0. Для AGP 9.3.0 это минимальная требуемая версия Gradle согласно документации Android.

В проекте также присутствуют `gradlew`, `gradlew.bat` и `gradle/wrapper/gradle-wrapper.properties`. На GitHub Actions wrapper JAR генерируется официальной задачей `gradle wrapper` перед сборкой, поэтому исходный ZIP не содержит бинарный JAR.

## Открытие в Android Studio

Открой папку проекта в Android Studio и дождись Gradle Sync.

Экран документа является демонстрационным и содержит маркировку DEMO / НЕ ЯВЛЯЕТСЯ ДОКУМЕНТОМ.
