package com.yazantarifi.compose.markdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yazantarifi.compose.library.MarkdownConfig
import com.yazantarifi.compose.library.MarkdownViewComposable
import com.yazantarifi.compose.markdown.ui.theme.MarkdownComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarkdownComposeTheme {
                MarkdownViewComposable(Modifier.fillMaxWidth().padding(10.dp), "# Vanite\n" +
                        "\n" +
                        "![New Project](https://user-images.githubusercontent.com/29167110/158914920-32310149-7f76-4802-9745-6c5ecf05f335.png)\n" +
                        "\n" +
                        "\n" +
                        "![](https://img.shields.io/badge/Project%20Status-Under%20Development-blue)\n" +
                        "[![Maven Central](https://img.shields.io/maven-central/v/com.yazantarifi/vanite.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.yazantarifi%22%20AND%20a:%22vanite%22)\n" +
                        "![](https://img.shields.io/badge/License-Apache%202.0-yellow)\n" +
                        "![](https://img.shields.io/badge/Language-Kotlin-orange)\n" +
                        "![](https://img.shields.io/badge/Android%20Status-AndroidX-green)\n" +
                        "\n" +
                        "\n" +
                        "# What is Vanite\n" +
                        "\n" +
                        "Vanite is an Open Source Library That Focus on Providing The Base Code of Android Applications with Utility Classes For Common Use Cases\n" +
                        "Under Multi Modular Architecture From Managing the State to Utils Classes to Providing Base Code in Base ViewModels, Fragments, Activities\n" +
                        "\n" +
                        "### Multi Modular Application\n" +
                        "The Library Focus on Main Modules\n" +
                        "1. UI\n" +
                        "2. Data\n" +
                        "3. Domain\n" +
                        "\n" +
                        "The UI Layer Contact with Domain to handle the logic from ViewModels, Use Cases, etc and This Layer Contact with Data Layer to get the Data from Repositories, this Layers could be provided by Modules or Packages because vanite is Built based on Modules and you can add the Required Dependency to one Module as you want\n" +
                        "\n" +
                        "\n" +
                        "### Application Flow Components\n" +
                        "1. Actions\n" +
                        "2. State\n" +
                        "3. ViewModel\n" +
                        "4. User Interface\n" +
                        "\n" +
                        "The UI Contact With ViewModel By execute Method Only and Send to ViewModel Actions, Each Action Should Execute specific Code or move to Use Case\n" +
                        "Then ViewModel Respond to View With New State For This ViewModel\n" +
                        "\n" +
                        "Also to Provide Utility Classes As much as Possible for Common Use Cases\n" +
                        "\n" +
                        "### Setup\n" +
                        "\n" +
                        "1. The Build.gradle Root File\n" +
                        "\n" +
                        "```\n" +
                        "allprojects {\n" +
                        "    repositories {\n" +
                        "        mavenCentral()\n" +
                        "    }\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "2. Application Module\n" +
                        "\n" +
                        "```\n" +
                        "dependencies {\n" +
                        "   implementation 'com.yazantarifi:Vanite:1.0.0'\n" +
                        "   implementation 'com.yazantarifi:Vanite-data:1.0.0'\n" +
                        "   implementation 'com.yazantarifi:Vanite-utils:1.0.0'\n" +
                        "   implementation 'com.yazantarifi:Vanite-ui-binding:1.0.0'\n" +
                        "   implementation 'com.yazantarifi:Vanite-ui:1.0.0'\n" +
                        "   implementation 'com.yazantarifi:Vanite-prefs:1.0.0'\n" +
                        "   implementation 'com.yazantarifi:Vanite-permissions:1.0.0'\n" +
                        "   implementation 'com.yazantarifi:Vanite-log:1.0.0'\n" +
                        "   implementation 'com.yazantarifi:Vanite-firebase:1.0.0'\n" +
                        "}\n" +
                        "```\n" +
                        "\n" +
                        "# Vanite Documentation\n" +
                        "Coming Soon Vanite still Under Development\n" +
                        "\n" +
                        "# License\n" +
                        "\n" +
                        "Copyright (C) 2019 Vanite is An Open Source Library (Licensed under the Apache License, Version 2.0)\n" +
                        "\n",
                    config = MarkdownConfig()
                ) { link, type ->
                    println("Link Clicked ::: $link")
                }
            }
        }
    }
}
