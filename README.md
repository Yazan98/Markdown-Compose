# Markdown Render Composable

Android Library To Render Markdown Strings Inside Jetpack Compose Applications

Built With Native Jetpack Compose Composables

## Library Versions
1. Jetpack Compose : 1.3.1
2. Image Loading Library (Coil) : 2.1.0
3. Minumum Sdk Version : 24
4. Target Sdk Version : 32
5. Jetpack Compose UI : 1.1.1

## Installation

```
allprojects {
    repositories {
        mavenCentral()
    }
}
```

```
dependencies {
    implementation "com.yazantarifi:markdown-compose:1.0.4"
}
```

## Implementation

1. Basic Implementation

```kotlin
MarkdownViewComposable(
      modifier = Modifier.fillMaxWidth().padding(10.dp),
      content = content,
      config = MarkdownConfig(
            isLinksClickable = true,
            isImagesClickable = true,
            isScrollEnabled = false
      )
   ) { link, type ->
  // Callback on Click on Images, Links To Redirect to Image Viewer or WebView Screen
}
```

2. Color Control Example

```kotlin

            MarkdownViewComposable(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                content = content,
                config = MarkdownConfig(
                    isLinksClickable = true,
                    isImagesClickable = true,
                    isScrollEnabled = false,
                    colors = HashMap<String, Color>().apply {
                        this[MarkdownConfig.CHECKBOX_COLOR] = Color.Black
                        this[MarkdownConfig.LINKS_COLOR] = Color.Blue
                        this[MarkdownConfig.TEXT_COLOR] = Color.Gray
                        this[MarkdownConfig.HASH_TEXT_COLOR] = Color.Black
                        this[MarkdownConfig.CODE_BACKGROUND_COLOR] = Color.Gray
                        this[MarkdownConfig.CODE_BLOCK_TEXT_COLOR] = Color.White
                    }
                )
            ) { link, type ->
                when (type) {
                    MarkdownConfig.IMAGE_TYPE -> {} // Image Clicked
                    MarkdownConfig.LINK_TYPE -> {} // Link Clicked
                }
            }

```


## Config Description

| Attribute   |      Description      |
|----------|:-------------:|
| isLinksClickable |  Allow Links in View to be Clickable |
| isImagesClickable |    Allow Images in View to be Clickable   | 
| isScrollEnabled | Allow Md View To be Scrollable Inside itself (False if it's already inside Scroll View or LazyColumn) |
| colors | Pass Colors Based on Your Application Theme |
| MarkdownConfig.CHECKBOX_COLOR | The Color of Checkboxes When Checkbox is Checked |
| MarkdownConfig.LINKS_COLOR | The Color of Links |
| MarkdownConfig.TEXT_COLOR | Normal Text Color |
| MarkdownConfig.HASH_TEXT_COLOR | Hashes Text Color (#, ##, ###, ####) |
| MarkdownConfig.CODE_BACKGROUND_COLOR | Background of Code Block |
| MarkdownConfig.CODE_BLOCK_TEXT_COLOR | Text Color Inside Code Block



## Screenshots

| Images 1   |      Images 2      |  Images 3 |
|----------|:-------------:|------:|
| ![Screenshot 2022-06-25 130052](https://user-images.githubusercontent.com/29167110/175789436-75f2b162-950c-4095-8f8b-ffdb8683ef27.png) |  ![Screenshot 2022-06-25 130113](https://user-images.githubusercontent.com/29167110/175789437-f506df66-f49d-4344-afe3-0e38b3f6507f.png) | ![Screenshot 2022-06-25 130140](https://user-images.githubusercontent.com/29167110/175789438-db370d51-838e-4744-a727-4f59aca4cd88.png) |
|![Screenshot 2022-06-25 131141](https://user-images.githubusercontent.com/29167110/175789439-26f5a1b4-5d3f-4bcb-b6d1-9d8895b8c5dd.png) |    ![Screenshot 2022-06-25 131157](https://user-images.githubusercontent.com/29167110/175789440-f59dd087-e260-4cbb-a880-3e584268d494.png)   |   ![Screenshot 2022-06-25 132022](https://user-images.githubusercontent.com/29167110/175789443-b994a075-bbf2-4c0c-b0ce-d18f3aaeb657.png) |


## Supported Types
1. Hash Texts
2. Code Blocks
3. Text
4. Checkbox
5. Images
6. Shilds
7. Bold Text
8. Italic Text
9. Links
10. Space

## Publish Commands
```
gradle build
gradle library:publishReleasePublicationToSonatypeRepository  
```

## License

Copyright (C) 2022 Markdown Compose is An Open Source Library (Licensed under the Apache License, Version 2.0)

