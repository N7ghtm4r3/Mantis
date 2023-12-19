# Mantis
Manage the translation of the content of your applications with Mantis!

## Implementation

Add the JitPack repository to your build file

### Gradle

- Add it in your root build.gradle at the end of repositories

    #### Gradle (Short)
    
    ```gradle
    repositories {
        ...
        maven { url 'https://jitpack.io' }
        maven("https://repo.clojars.org")
    }
    ```
    
    #### Gradle (Kotlin)
    
    ```gradle
    repositories {
        ...
        maven("https://jitpack.io")
        maven("https://repo.clojars.org")
    }
    ```
  
- Add the dependency

  #### Gradle (Short)

    ```gradle
    dependencies {
        implementation 'com.github.N7ghtm4r3:Mantis:1.0.0'
    }
    ```

  #### Gradle (Kotlin)

    ```gradle
    dependencies {
        implementation("com.github.N7ghtm4r3:Mantis:1.0.0")
    }
    ```

### Maven

- Add it in your root build.gradle at the end of repositories

```xml

<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

- Add the dependency

```xml

<dependency>
  <groupId>com.github.N7ghtm4r3</groupId>
  <artifactId>Mantis</artifactId>
  <version>1.0.0</version>
</dependency>
```

### Usage/Examples

#### Resources file

You must place the resources file, named **resource.mantis**, in the resources folder of your application:

``` bash
src
|-- main
    |-- resources
    |   |-- resources.mantis
```

Content example:

```json
{
    "it": {
      "string_one" : "ciao!",
      "string_two": "prova questa libreria :)"
    },
    "en": {
      "string_one" : "hello!", 
      "string_two": "try this library :)"
    } 
}
```

#### Workflow

```java
// current locale en
Mantis mantis = new Mantis(Locale.getDefault());
System.out.println(mantis.getResource("string_one")); // hello!

// current locale it
Mantis mantis = new Mantis(Locale.getDefault());
System.out.println(mantis.getResource("string_one")); // ciao!

// Dynamic translation of any contents
System.out.println(mantis.translate("Hello how are you?")); // Ciao, come stai?
```

## Authors

- [@N7ghtm4r3](https://www.github.com/N7ghtm4r3)

## Support

If you need help using the library or encounter any problems or bugs, please contact us via the following links:

- Support via <a href="mailto:infotecknobitcompany@gmail.com">email</a>
- Support via <a href="https://github.com/N7ghtm4r3/Mantis/issues/new">GitHub</a>

Thank you for your help!

## Badges

[![](https://img.shields.io/badge/Google_Play-414141?style=for-the-badge&logo=google-play&logoColor=white)](https://play.google.com/store/apps/developer?id=Tecknobit)
[![Twitter](https://img.shields.io/badge/Twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/tecknobit)

[![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)

[![](https://jitpack.io/v/N7ghtm4r3/Mantis.svg)](https://jitpack.io/#N7ghtm4r3/Mantis)

## Business contact

If you need to contact me for a project

[![](https://img.shields.io/badge/fiverr-1DBF73?style=for-the-badge&logo=fiverr&logoColor=white)](https://www.fiverr.com/manuel_maurizio)

## Donations

If you want support project and developer

| Crypto                                                                                              | Address                                        | Network  |
|-----------------------------------------------------------------------------------------------------|------------------------------------------------|----------|
| ![](https://img.shields.io/badge/Bitcoin-000000?style=for-the-badge&logo=bitcoin&logoColor=white)   | **3H3jyCzcRmnxroHthuXh22GXXSmizin2yp**         | Bitcoin  |
| ![](https://img.shields.io/badge/Ethereum-3C3C3D?style=for-the-badge&logo=Ethereum&logoColor=white) | **0x1b45bc41efeb3ed655b078f95086f25fc83345c4** | Ethereum |

If you want support project and developer with <a href="https://www.paypal.com/donate/?hosted_button_id=5QMN5UQH7LDT4">PayPal</a>

Copyright © 2023 Tecknobit
