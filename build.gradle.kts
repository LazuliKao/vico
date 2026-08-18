/*
 * Copyright 2025 by Patryk Goworowski and Patrick Michalik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

subprojects {
  tasks.withType<Test>().configureEach { useJUnitPlatform() }
  configurations.all {
    if (name.contains("desktop", ignoreCase = true) ||
        name.contains("jvm", ignoreCase = true) ||
        name.contains("wasm", ignoreCase = true) ||
        name.contains("js", ignoreCase = true)) {
      resolutionStrategy.eachDependency {
        if (requested.group.startsWith("org.jetbrains.compose") && requested.version?.contains("KBA") == true) {
          useVersion("1.6.1")
        }
        if (requested.group == "org.jetbrains.kotlinx" && requested.name.startsWith("kotlinx-coroutines") && requested.version?.contains("KBA") == true) {
          useVersion("1.8.0")
        }
        if (requested.group == "org.jetbrains.kotlinx" && requested.name.startsWith("atomicfu") && requested.version?.contains("KBA") == true) {
          useVersion("0.23.2")
        }
        if (requested.group == "androidx.annotation" && requested.name == "annotation" && requested.version?.contains("KBA") == true) {
          useVersion("1.9.1")
        }
      }
    }
  }
}
