package com.yazantarifi.compose.markdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yazantarifi.compose.library.MarkdownComposable
import com.yazantarifi.compose.markdown.ui.theme.MarkdownComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarkdownComposeTheme {
                MarkdownComposable(Modifier.fillMaxWidth().padding(10.dp), "\n" +
                        "![158914920-32310149-7f76-4802-9745-6c5ecf05f335](https://user-images.githubusercontent.com/29167110/162568490-b0f18dae-6e56-485c-8c43-958a6104da92.png)\n" +
                        "\n" +
                        "\n" +
                        "![](https://img.shields.io/badge/Version-1.0.0--alpha-brightgreen)\n" +
                        "![](https://img.shields.io/badge/Language-Kotlin-orange)\n" +
                        "![](https://img.shields.io/badge/Status-Under%20Development-green)\n" +
                        "\n" +
                        "# Legora\n" +
                        "\n" +
                        "Legora is an Open Source Project To Generate Applications With Ready Configurations and Project Starter to Start Your Project Without Configurations\n" +
                        "This Application Built with Jetpack Compose To Be able to work on Mac, Windows, Linux\n" +
                        "\n" +
                        "> The Application in Alpha Version and it's not Supporting a lot of Projects to Generate\n" +
                        "\n" +
                        "## Supported Frameworks\n" +
                        "- [X] Android Applications\n" +
                        "- [X] Android Libraries (Maven Central)\n" +
                        "- [X] Spring Boot Applications (Kotlin)\n" +
                        "- [X] React.js Applications (JavaScript)\n" +
                        "- [X] Next.js Applications (Typescript)\n" +
                        "- [ ] Jetpack Compose Desktop\n" +
                        "- [ ] React.js TypeScript\n" +
                        "- [ ] React.js Redux, Material UI\n" +
                        "- [ ] Next.js Material UI\n" +
                        "- [ ] Ktor Framework\n" +
                        "- [ ] Nest.js Applications (MongoDB)\n" +
                        "- [ ] Android Applications Jetpack Compose\n" +
                        "- [ ] Android Studio Plugin\n" +
                        "- [ ] Gradle Plugins\n" +
                        "- [ ] CLI (TypeScript)\n" +
                        "- [ ] CLI (JavaScript)\n" +
                        "- [ ] Express.js (JavaScript)\n" +
                        "\n" +
                        "\n" +
                        "# Application Screenshot\n" +
                        "\n" +
                        "![New Project (15)](https://user-images.githubusercontent.com/29167110/162568598-19df4e84-99ac-46a9-a0c5-9faea55c1481.png)\n" +
                        "\n" +
                        "## Application Roadmap\n" +
                        "1. Alpha Version Containing the Application Alpha Build With General Configuration Files\n" +
                        "2. Beta Version Depending on Templating Files With Template Parser\n" +
                        "3. Beta-2 Support More Projects\n" +
                        "4. Version 1.0.0 Stable Support All Projects Mentioned in Supported Frameworks\n" +
                        "\n" +
                        "## Download\n" +
                        "[Alpha Version Download Link](https://github.com/legora-io/Legora/releases/tag/1.0.0-alpha)\n" +
                        "\n" +
                        "# License\n" +
                        "\n" +
                        "Copyright (C) 2022 Legora is An Open Source Library (Licensed under the MIT License)\n")
            }
        }
    }
}
