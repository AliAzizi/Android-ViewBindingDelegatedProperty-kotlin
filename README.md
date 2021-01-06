# Android Viewbinding delegated property [![](https://jitpack.io/v/A-Azizi79/Android-ViewBindingDelegatedProperty-kotlin.svg)](https://jitpack.io/#A-Azizi79/Android-ViewBindingDelegatedProperty-kotlin)


With this library you can use the power of kotlin delegated properties and easily delegate your viewbinding classes.
One of the advantages of this library is the reduction of your code. 😍😍

![alt text](https://uupload.ir/files/89dr_1_mbgf3jidykv-5_b_dsnr8g_(1).png)
## installation (Gradle)

Add this line in your build.gradle file :

```gradle
dependencies {
    ...
    implementation 'com.github.A-Azizi79:Android-ViewBindingDelegatedProperty-kotlin:0.1.0'
}
```

## Usage

```kotlin
// You must replace YourActivityBinding with your generated binding file name like ActivityMainBinding or ...
class YourActivity : AppCompatActivity() {
    val binding: YourActivityBinding by viewBinding(YourActivityBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // you must remove setContentView(R.layout.name) because we will do that for you! Awsome right?
        //calling textView1 and set (Hello World!) text on it
        binding.textView1.text = "Hello world"
    }
}
```
# Contact me 
you can find me [@here](https://t.me/Ali_AZ1379) on Telegram messenger 😎
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License 🇮🇷
[MIT](https://choosealicense.com/licenses/mit/)
